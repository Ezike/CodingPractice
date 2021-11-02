fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var product = 0
    while (left < right) {
        val minimumHeight = minOf(height[left], height[right])
        val container = minimumHeight * (right - left)
        if (product < container) {
            product = container
        }
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return product
}

println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))