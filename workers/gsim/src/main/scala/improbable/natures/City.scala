package improbable.natures

import improbable.PositionUtils
import improbable.apps.LatLonPosition
import improbable.city.CityInfoComponent
import improbable.corelib.natures.{BaseNature, NatureApplication, NatureDescription}
import improbable.corelibrary.transforms.TransformNature
import improbable.papi.entity.EntityPrefab
import improbable.papi.entity.behaviour.EntityBehaviourDescriptor

object City extends NatureDescription {

  override val dependencies = Set[NatureDescription](BaseNature, TransformNature)

  override def activeBehaviours: Set[EntityBehaviourDescriptor] = Set()

  def apply(position: LatLonPosition, name: String, demand: Float): NatureApplication = {
    application(
      states = Seq(CityInfoComponent(name, demand)),
      natures = Seq(BaseNature(EntityPrefab("City")), TransformNature(PositionUtils.convertToVector(position)))
    )
  }
}