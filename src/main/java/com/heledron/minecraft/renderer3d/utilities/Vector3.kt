package com.heledron.minecraft.renderer3d.utilities

import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class Vector3(var x: Double, var y: Double, var z: Double) {
    fun clone(): Vector3 {
        return Vector3(this.x, this.y, this.z)
    }

    fun length(): Double {
        return sqrt(this.x * this.x + this.y * this.y + this.z * this.z)
    }

    fun transformMat4(transform: Matrix4) {
        val m = transform
        val x = this.x
        val y = this.y
        val z = this.z
        val w0 = (m.m14 * x + m.m24 * y + m.m34 * z + m.m44)
        val w = if (w0 == .0) w0 else 1.0

        this.x = (m.m11 * x + m.m21 * y + m.m31 * z + m.m41) / w
        this.y = (m.m12 * x + m.m22 * y + m.m32 * z + m.m42) / w
        this.z = (m.m13 * x + m.m23 * y + m.m33 * z + m.m43) / w
    }

    fun add(other: Vector3) {
        this.x += other.x
        this.y += other.y
        this.z += other.z
    }

    fun subtract(other: Vector3) {
        this.x -= other.x
        this.y -= other.y
        this.z -= other.z
    }

    fun rotateX(angle: Double) {
        val cosA = cos(angle)
        val sinA = sin(angle)
        val y = this.y
        val z = this.z
        this.y = y * cosA - z * sinA
        this.z = y * sinA + z * cosA
    }

    fun rotateY(angle: Double) {
        val cosA = cos(angle)
        val sinA = sin(angle)
        val x = this.x
        val z = this.z
        this.x = z * sinA + x * cosA
        this.z = z * cosA - x * sinA
    }

    fun rotateZ(angle: Double) {
        val cosA = cos(angle)
        val sinA = sin(angle)
        val x = this.x
        val y = this.y
        this.x = x * cosA - y * sinA
        this.y = x * sinA + y * cosA
    }

    // override fun toString() {
    //     return `Vec3(${this.x.toFixed(3)}, ${this.y.toFixed(3)}, ${this.z.toFixed(3)})`
    // }

    // static readonly zero = Object.freeze(new Vector3(0, 0, 0))
}