package com.heledron.minecraft.renderer3d.scenes.meshes

object Cube {
	val vertices = arrayOf(
		doubleArrayOf(-1.0, +1.0, +1.0, 1.0, 0.0, 0.0),
		doubleArrayOf(-1.0, -1.0, +1.0, 1.0, 0.0, 0.0),
		doubleArrayOf(-1.0, -1.0, -1.0, 1.0, 0.0, 0.0),
		doubleArrayOf(-1.0, +1.0, -1.0, 1.0, 0.0, 0.0),
		doubleArrayOf(+1.0, +1.0, +1.0, 0.7, 0.2, 0.5),
		doubleArrayOf(+1.0, -1.0, +1.0, 0.7, 0.2, 0.5),
		doubleArrayOf(+1.0, -1.0, -1.0, 0.7, 0.2, 0.5),
		doubleArrayOf(+1.0, +1.0, -1.0, 0.7, 0.2, 0.5),
		doubleArrayOf(+1.0, +1.0, -1.0, 0.2, 0.2, 0.7),
		doubleArrayOf(+1.0, -1.0, -1.0, 0.2, 0.2, 0.7),
		doubleArrayOf(-1.0, -1.0, -1.0, 0.2, 0.2, 0.7),
		doubleArrayOf(-1.0, +1.0, -1.0, 0.2, 0.2, 0.7),
		doubleArrayOf(+1.0, +1.0, +1.0, 0.0, 1.0, 0.0),
		doubleArrayOf(+1.0, -1.0, +1.0, 0.0, 1.0, 0.0),
		doubleArrayOf(-1.0, -1.0, +1.0, 0.0, 1.0, 0.0),
		doubleArrayOf(-1.0, +1.0, +1.0, 0.0, 1.0, 0.0),
		doubleArrayOf(-1.0, -1.0, -1.0, 0.5, 0.5, 1.0),
		doubleArrayOf(-1.0, -1.0, +1.0, 0.5, 0.5, 1.0),
		doubleArrayOf(+1.0, -1.0, +1.0, 0.5, 0.5, 1.0),
		doubleArrayOf(+1.0, -1.0, -1.0, 0.5, 0.5, 1.0),
		doubleArrayOf(-1.0, +1.0, -1.0, 1.0, 0.7, 0.0),
		doubleArrayOf(-1.0, +1.0, +1.0, 1.0, 0.7, 0.0),
		doubleArrayOf(+1.0, +1.0, +1.0, 1.0, 0.7, 0.0),
		doubleArrayOf(+1.0, +1.0, -1.0, 1.0, 0.7, 0.0)
	)

	val indices = intArrayOf(
			// FRONT
            0, 1, 2,
            0, 2, 3,
			// BACK
            5, 4, 6,
            6, 4, 7,
			// LEFT
            8, 9, 10,
            8, 10, 11,
			// RIGHT
            13, 12, 14,
            15, 14, 12,
			// UNDER
            16, 17, 18,
            16, 18, 19,
			// TOP
            21, 20, 22,
            22, 20, 23
    )
}