package improbable.apps

import improbable.logging.Logger
import improbable.natures.Habitat
import improbable.papi.world.AppWorld
import improbable.papi.worldapp.WorldApp

class MapSpawner(appWorld: AppWorld, logger: Logger) extends WorldApp{
  appWorld.entities.spawnEntity(improbable.natures.Map())
  logger.info("Spawned map")

  appWorld.entities.spawnEntity(Habitat())
  logger.info("Spawned dummy habitat")
}