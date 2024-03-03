package com.heledron.minecraft.renderer3d.utilities

class Camera(val foxy: Double) {
    val view: Matrix4 = Matrix4();
    val projection: Matrix4 = Matrix4().apply { perspective(foxy, 1.0, 0.1, 1000.0) };

    fun getTransform(model: Matrix4 = Matrix4()): Matrix4 {
        val out = model.clone();
        out.multiply(view);
        out.multiply(projection);
        return out;
    }

    fun lookAt(position: Vector3, target: Vector3, up: Vector3) {
        this.view.lookAt(position, target, up)
    }

    fun lookAround(target: Vector3, distance: Double, angleX: Double, angleY: Double, up: Vector3) {
        val relativePos = Vector3(distance, 0.0, 0.0).apply { rotateZ(angleY); rotateY(angleX); }
        val cameraPos = target.clone().apply { add(relativePos) };
        this.view.lookAt(cameraPos,target,up);
    }
}