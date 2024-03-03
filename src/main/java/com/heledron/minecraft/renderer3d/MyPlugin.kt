package com.heledron.minecraft.renderer3d

import com.heledron.minecraft.renderer3d.presentation.Presentation
import com.heledron.minecraft.renderer3d.scenes.EmptyScene
import com.heledron.minecraft.renderer3d.scenes.RainbowTriangleScene
import com.heledron.minecraft.renderer3d.scenes.RotatingCubeScene
import com.heledron.minecraft.renderer3d.scenes.Scene
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.util.Vector

class MyPlugin : JavaPlugin() {
    var scene: Scene = EmptyScene()

    override fun onEnable() {
        logger.info("============================")
        logger.info("Enabling Plugin")

        val display = Presentation(
                Location(Bukkit.getWorld("world"), .0, .0, .0),
                Vector(1, 0, 0),
                Vector(0, 1, 0)
        )


        val actionItemKey = NamespacedKey(this, "action")
        fun createItem(material: Material, action: String, displayName: String): ItemStack {
            val item = ItemStack(material)
            item.amount = 1
            item.itemMeta = item.itemMeta.apply {
                displayName(Component.text(displayName))
                persistentDataContainer.set(actionItemKey, PersistentDataType.STRING, action)
            }
            return item
        }

        getCommand("renderer3d")!!.setExecutor(fun (sender, _, _, args): Boolean {
            if (args.isEmpty()) return false
            when (args[0]) {
                "empty" -> {
                    display.clear(scene.buffer)
                    scene = EmptyScene()
                    scene.update()
                    display.draw(scene.buffer)
                    sender.sendMessage("Created Empty Scene")
                }
                "rainbowTriangle" -> {
                    display.clear(scene.buffer)
                    scene = RainbowTriangleScene()
                    scene.update()
                    display.draw(scene.buffer)
                    sender.sendMessage("Created Rainbow Triangle Scene")
                }
                "rotatingCube" -> {
                    display.clear(scene.buffer)
                    scene = RotatingCubeScene()
                    scene.update()
                    display.draw(scene.buffer)
                    sender.sendMessage("Created Rotating Cube Scene")
                }
                "getItems" -> {
                    val player = sender as Player

                    player.inventory.apply {
                        addItem(createItem(Material.LEVER, "cube.toggleRotation" , "Cube: Toggle Rotation"))

                        addItem(createItem(Material.STONE_BUTTON, "camera.moveLeft" , "Camera: Move Left"))
                        addItem(createItem(Material.STONE_BUTTON, "camera.moveRight", "Camera: Move Right"))
                        addItem(createItem(Material.STONE_BUTTON, "camera.moveUp"   , "Camera: Move Up"))
                        addItem(createItem(Material.STONE_BUTTON, "camera.moveDown" , "Camera: Move Down"))
                        addItem(createItem(Material.STONE_BUTTON, "camera.moveIn"   , "Camera: Move In"))
                        addItem(createItem(Material.STONE_BUTTON, "camera.moveOut"  , "Camera: Move Out"))
                    }
                }
            }

            return true
        })


        val self = this
        var activeAction: String? = null
        var task: Int? = null
        server.pluginManager.registerEvents(object : Listener {
            @EventHandler(priority = EventPriority.HIGH)
            fun on(event: PlayerInteractEvent) {
                if (event.action != Action.RIGHT_CLICK_AIR) return
                val actionId = event.player.inventory.itemInMainHand
                        .itemMeta.persistentDataContainer.get(actionItemKey, PersistentDataType.STRING)

                activeAction = actionId
                if (actionId != null) {
                    doAction(actionId)

                    val taskI = task
                    if (taskI !== null) server.scheduler.cancelTask(taskI)

                    task = server.scheduler.scheduleSyncDelayedTask(self, fun () {
                        activeAction = null
                    }, 4)
                }
            }
        }, this)

        server.scheduler.runTaskTimer(this, fun () {
            scene.update()
            display.draw(scene.buffer)

            val activeActionI = activeAction
            if (activeActionI != null) doActiveAction(activeActionI)
        }, 0, 1)

        logger.info("============================")
    }

    override fun onDisable() {
        logger.info("============================")
        logger.info("Disabling Plugin")
        logger.info("============================")
    }

    private fun doAction(action: String) {
        if (scene !is RotatingCubeScene) return
        val cScene = scene as RotatingCubeScene

        when (action) {
            "cube.toggleRotation" -> {
                cScene.rotateCube = !cScene.rotateCube
            }
        }
    }

    private fun doActiveAction(action: String) {
        if (scene !is RotatingCubeScene) return
        val cScene = scene as RotatingCubeScene

        fun updateCameraOrbit() {
            if (cScene.cameraAngleX > 360) cScene.cameraAngleX -= 360.0
            if (cScene.cameraAngleY > 90) cScene.cameraAngleY = 90.0
            if (cScene.cameraAngleY < -90) cScene.cameraAngleY = -90.0
            cScene.updateCamera()
        }
        fun updateCameraDistance() {
            if (cScene.cameraDistance < 3) cScene.cameraDistance = 3.0
            if (cScene.cameraDistance > 100) cScene.cameraDistance = 100.0
            cScene.updateCamera()
        }

        val cameraMoveSpeed = .25
        val cameraRotateSpeed = 2

        when (action) {
            "camera.moveLeft" -> {
                cScene.cameraAngleX -= cameraRotateSpeed
                updateCameraOrbit()
            }
            "camera.moveRight" -> {
                cScene.cameraAngleX += cameraRotateSpeed
                updateCameraOrbit()
            }
            "camera.moveUp" -> {
                cScene.cameraAngleY += cameraRotateSpeed
                updateCameraOrbit()
            }
            "camera.moveDown" -> {
                cScene.cameraAngleY -= cameraRotateSpeed
                updateCameraOrbit()
            }
            "camera.moveIn" -> {
                cScene.cameraDistance -= cameraMoveSpeed
                updateCameraDistance()
            }
            "camera.moveOut" -> {
                cScene.cameraDistance += cameraMoveSpeed
                updateCameraDistance()
            }
        }
    }
}