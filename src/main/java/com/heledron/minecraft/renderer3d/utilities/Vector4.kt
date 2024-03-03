package com.heledron.minecraft.renderer3d.utilities

class Vector4(var x: Double, var y: Double, var z: Double, var w: Double) {

    fun clone(): Vector4 {
        return Vector4(this.x, this.y, this.z, this.w)
    }

    fun transformMat4(transform: Matrix4) {
        val x = this.x
        val y = this.y
        val z = this.z
        val w = this.w
        val m = transform
        this.x = m.m11 * x + m.m21 * y + m.m31 * z + m.m41 * w
        this.y = m.m12 * x + m.m22 * y + m.m32 * z + m.m42 * w
        this.z = m.m13 * x + m.m23 * y + m.m33 * z + m.m43 * w
        this.w = m.m14 * x + m.m24 * y + m.m34 * z + m.m44 * w
    }

    // toArray() {
    //     return [this.x, this.y, this.z, this.w] as const
    // }

    override fun toString(): String {
        val x = this.x
        val y = this.y
        val z = this.z
        val w = this.w

        return "Vec4($x, $y, $z, $w)"
    }
}