fun rotate(matrix: Array<IntArray>): Unit {
    val size = matrix.size - 1
    for (i in 0..size) {
        for (j in i..size) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }

    for (i in 0..size) {
        for (j in 0..(size / 2)) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[i][size - j]
            matrix[i][size - j] = temp
        }
    }
    matrix.forEach {
        it.forEach { print("$it ") }
        println()
    }
}

val arrayOfArrays = arrayOf(
    intArrayOf(1, 2, 3),
    intArrayOf(4, 5, 6),
    intArrayOf(7, 8, 9)
)
rotate(arrayOfArrays)