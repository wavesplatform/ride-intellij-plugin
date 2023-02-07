package com.wavesplatform.rideplugin.psi

import com.intellij.ProjectTopics
import com.intellij.openapi.Disposable
import com.intellij.openapi.components.service
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootEvent
import com.intellij.openapi.roots.ModuleRootListener
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.ModificationTracker
import com.intellij.openapi.util.SimpleModificationTracker
import com.intellij.psi.*
import com.intellij.util.messages.MessageBusConnection
import com.wavesplatform.rideplugin.RideFile

val Project.rideStructureModificationTracker: ModificationTracker
    get() = ridePsiManager.rideStructureModificationTracker

val Project.ridePsiManager: RidePsiManager get() = service()

interface RidePsiManager {
    val rideStructureModificationTracker: ModificationTracker

    val rideStructureModificationTrackerInDependencies: SimpleModificationTracker

    fun incRideStructureModificationCount()

    /** This is an instance method because [RidePsiManager] should be created prior to event subscription */
    fun subscribeRideStructureChange(connection: MessageBusConnection, listener: RideStructureChangeListener) {
        connection.subscribe(RIDE_STRUCTURE_CHANGE_TOPIC, listener)
    }

    /** This is an instance method because [RidePsiManager] should be created prior to event subscription */
    fun subscribeRidePsiChange(connection: MessageBusConnection, listener: RidePsiChangeListener) {
        connection.subscribe(RIDE_PSI_CHANGE_TOPIC, listener)
    }

    companion object {
        private val IGNORE_PSI_EVENTS: Key<Boolean> = Key.create("IGNORE_PSI_EVENTS")

        fun <T> withIgnoredPsiEvents(psi: PsiFile, f: () -> T): T {
            setIgnorePsiEvents(psi, true)
            try {
                return f()
            } finally {
                setIgnorePsiEvents(psi, false)
            }
        }

        fun isIgnorePsiEvents(psi: PsiFile): Boolean =
            psi.getUserData(IGNORE_PSI_EVENTS) == true

        private fun setIgnorePsiEvents(psi: PsiFile, ignore: Boolean) {
            psi.putUserData(IGNORE_PSI_EVENTS, if (ignore) true else null)
        }
    }
}

class RidePsiManagerImpl(val project: Project) : RidePsiManager, Disposable {

    override val rideStructureModificationTracker = SimpleModificationTracker()
    override val rideStructureModificationTrackerInDependencies = SimpleModificationTracker()

    init {
        PsiManager.getInstance(project).addPsiTreeChangeListener(CacheInvalidator(), this)
        project.messageBus.connect().subscribe(ProjectTopics.PROJECT_ROOTS, object : ModuleRootListener {
            override fun rootsChanged(event: ModuleRootEvent) {
                incRideStructureModificationCount()
            }
        })
        project.messageBus.connect().subscribe(CargoProjectsService.CARGO_PROJECTS_TOPIC, CargoProjectsListener { _, _ ->
            incRideStructureModificationCount()
        })
    }

    override fun dispose() {}

    inner class CacheInvalidator : RidePsiTreeChangeAdapter() {
        override fun handleEvent(event: RidePsiTreeChangeEvent) {
            val element = when (event) {
                is ChildRemoval.Before -> event.child
                is ChildRemoval.After -> event.parent
                is ChildReplacement.Before -> event.oldChild
                is ChildReplacement.After -> event.newChild
                is ChildAddition.After -> event.child
                is ChildMovement.After -> event.child
                is ChildrenChange.After -> if (!event.isGenericChange) event.parent else return
                is PropertyChange.After -> {
                    when (event.propertyName) {
                        PsiTreeChangeEvent.PROP_UNLOADED_PSI, PsiTreeChangeEvent.PROP_FILE_TYPES -> {
                            incRideStructureModificationCount()
                            return
                        }
                        PsiTreeChangeEvent.PROP_WRITABLE -> return
                        else -> event.element ?: return
                    }
                }
                else -> return
            }

            val file = event.file

            // if file is null, this is an event about VFS changes
            if (file == null) {
                val isStructureModification = element is RideFile && !isIgnorePsiEvents(element)
                        || element is PsiDirectory && project.cargoProjects.findPackageForFile(element.virtualFile) != null
                if (isStructureModification) {
                    incRideStructureModificationCount(element as? RideFile, element as? RideFile)
                }
            } else {
                if (file.fileType != RideFileType) return
                if (isIgnorePsiEvents(file)) return

                val isWhitespaceOrComment = element is PsiComment || element is PsiWhiteSpace
                if (isWhitespaceOrComment && !isMacroExpansionModeNew) {
                    // Whitespace/comment changes are meaningful if new macro expansion engine is used
                    return
                }

                // Most of events means that some element *itself* is changed, but ChildrenChange means
                // that changed some of element's children, not the element itself. In this case
                // we should look up for ModificationTrackerOwner a bit differently
                val isChildrenChange = event is ChildrenChange || event is ChildRemoval.After

                updateModificationCount(file, element, isChildrenChange, isWhitespaceOrComment)
            }
        }

    }

    private fun updateModificationCount(
        file: PsiFile,
        psi: PsiElement,
        isChildrenChange: Boolean,
        isWhitespaceOrComment: Boolean
    ) {
        val owner = if (DumbService.isDumb(project)) null else psi.findModificationTrackerOwner(!isChildrenChange)

        // Whitespace/comment changes are meaningful for macros only
        // (b/c they affect range mappings and body hashes)
        if (isWhitespaceOrComment) {
        }

        val isStructureModification = owner == null || !owner.incModificationCount(psi)

        if (!isStructureModification &&
            (!isMacroExpansionModeNew || !owner.isTopLevelExpansion)) {
            return updateModificationCount(file, owner, isChildrenChange = false, isWhitespaceOrComment = false)
        }

        if (isStructureModification) {
            incRideStructureModificationCount(file, psi)
        }
        project.messageBus.syncPublisher(RIDE_PSI_CHANGE_TOPIC).ridePsiChanged(file, psi, isStructureModification)
    }

    private val isMacroExpansionModeNew
        get() = project.macroExpansionManagerIfCreated?.macroExpansionMode is MacroExpansionMode.New

    override fun incRideStructureModificationCount() =
        incRideStructureModificationCount(null, null)

    private fun incRideStructureModificationCount(file: PsiFile? = null, psi: PsiElement? = null) {
        rideStructureModificationTracker.incModificationCount()
        if (!isWorkspaceFile(file)) {
            rideStructureModificationTrackerInDependencies.incModificationCount()
        }
        project.messageBus.syncPublisher(RIDE_STRUCTURE_CHANGE_TOPIC).rideStructureChanged(file, psi)
    }

    private fun isWorkspaceFile(file: PsiFile?): Boolean {
        if (file !is RideFile) return false
        val virtualFile = file.virtualFile ?: return false
        val crates = if (virtualFile.fileSystem is MacroExpansionFileSystem) {
            val crateId = project.macroExpansionManagerIfCreated?.getCrateForExpansionFile(virtualFile) ?: return false
            listOf(crateId)
        } else {
            project.defMapService.findCrates(file)
        }
        if (crates.isEmpty()) return false
        val crateGraph =  project.crateGraph
        if (crates.any { crateGraph.findCrateById(it)?.origin != PackageOrigin.WORKSPACE }) return false

        return true
    }
}