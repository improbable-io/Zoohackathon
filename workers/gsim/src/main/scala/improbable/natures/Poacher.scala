package improbable.natures

import improbable.behaviours.PoacherTradingBehaviour
import improbable.corelib.natures.{BaseNature, NatureApplication, NatureDescription}
import improbable.corelibrary.transforms.TransformNature
import improbable.papi.entity.EntityPrefab
import improbable.papi.entity.behaviour.EntityBehaviourDescriptor
import improbable.poacher.PoacherInfoComponent
import improbable.util.LatLonPosition

object Poacher extends NatureDescription {

  override val dependencies = Set[NatureDescription](BaseNature, TransformNature)

  override def activeBehaviours: Set[EntityBehaviourDescriptor] = Set(
    descriptorOf[PoacherTradingBehaviour]
  )

  def apply(position: LatLonPosition): NatureApplication = {
    application(
      states = Seq(PoacherInfoComponent("")),
      natures = Seq(BaseNature(EntityPrefab("Poacher")), TransformNature(position.convertToVector()))
    )
  }
}