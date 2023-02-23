package nl.avisi.structurizr.site.generatr.site.model

import com.structurizr.model.SoftwareSystem
import nl.avisi.structurizr.site.generatr.hasContainerDecisions
import nl.avisi.structurizr.site.generatr.hasDecisions
import nl.avisi.structurizr.site.generatr.normalize
import nl.avisi.structurizr.site.generatr.site.GeneratorContext

class SoftwareSystemDecisionsPageViewModel(generatorContext: GeneratorContext, softwareSystem: SoftwareSystem) :
    SoftwareSystemPageViewModel(generatorContext, softwareSystem, Tab.DECISIONS) {

    val containerDecisionsTable = createContainerTableViewModel(softwareSystem.containers) {
        "$url/${it.name.normalize()}"
    }
    val decisionsTable = createDecisionsTableViewModel(softwareSystem.documentation.decisions) {
        "$url/${it.id}"
    }

    val visibleContainerDecisions = softwareSystem.hasContainerDecisions()
    val visibleSoftwareSystemDecisions = softwareSystem.hasDecisions()

    val visible = visibleSoftwareSystemDecisions or visibleContainerDecisions
}
