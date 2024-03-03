package com.heledron.minecraft.renderer3d.scenes

import com.heledron.minecraft.renderer3d.utilities.Matrix4
import com.heledron.minecraft.renderer3d.utilities.Vector3
import com.heledron.minecraft.renderer3d.scenes.meshes.*
import com.heledron.minecraft.renderer3d.scenes.shaders.*
import com.heledron.minecraft.renderer3d.renderer.RenderBuffer
import com.heledron.minecraft.renderer3d.utilities.Camera
import com.heledron.minecraft.renderer3d.scenes.shaders.RGBShader

abstract class Scene {
	abstract var buffer: RenderBuffer
    open fun update() {}
}

class EmptyScene : Scene() {
    override var buffer = RenderBuffer(80, 80)
}

class RainbowTriangleScene : Scene() {
    override var buffer = RenderBuffer(80, 80)
    init {
        buffer.drawTriangles(
                RainbowTriangle.vertices,
                RainbowTriangle.indices,
                RGB2DShader.vertex,
                RGB2DShader.pixel,
                true
        )
    }
}

class RotatingCubeScene : Scene() {
    var size = 80
    var tick = 0
    var rotation = Math.PI / 4
    var reflectionTexture = RenderBuffer(size, size)
    var cameraAngleX = 0.0
    var cameraAngleY = 30.0
    var cameraDistance = 15.0
    var camera = Camera(Math.PI / 4)
    var reflectionCamera = Camera(Math.PI / 2.2).apply { lookAt(
            Vector3(0.0, -5.0, 0.0),  // camera position (at water surface)
            Vector3(0.0, 0.0, 0.0),  // cube position
            Vector3(0.0, 0.0, -1.0) // up vector
    ) }

    var rotateCube = false

    var drawWater = true
    var updateReflection = true

    override var buffer = RenderBuffer(size, size)

    init {
        updateCamera()
    }

    fun updateCamera() {
        camera.lookAround(
                Vector3(0.0, 0.0, 0.0),
                cameraDistance,  // distance to cube
                cameraAngleX * Math.PI / 180.0,  // angle X of camera
                cameraAngleY * Math.PI / 180.0,  // angle Y of camera
                Vector3(0.0, 1.0, 0.0)
        )
    }

    override fun update() {
        buffer.clear()

        // get model transform
        val model = Matrix4().apply {
            rotateY(rotation);
            rotateX(rotation/4);
        }

        // draw cube
        RGBShader.transform = camera.getTransform(model)
        buffer.drawTriangles(
                Cube.vertices,
                Cube.indices,
                RGBShader.vertex,
                RGBShader.pixel,
                true
        )

        if (updateReflection) {
            reflectionTexture.clear()
            RGBShader.transform = reflectionCamera.getTransform(model);
            reflectionTexture.drawTriangles(
                    Cube.vertices,
                    Cube.indices,
                    RGBShader.vertex,
                    RGBShader.pixel,
                    true
            );
            WaterShader.reflectionTexture = reflectionTexture
        } else {
            WaterShader.reflectionTexture = WaterShader.emptyReflectionTexture;
        }

        if (drawWater) {
            WaterShader.transform = camera.getTransform()
            WaterShader.distortionFrame = tick / 20.0
            buffer.drawTriangles(
                Water.vertices,
                Water.indices,
                WaterShader.vertex,
                WaterShader.pixel,
                true
            )
        }

        tick++
        if (rotateCube) rotation += .3 * (2.0 * Math.PI) / 20.0
    }
}