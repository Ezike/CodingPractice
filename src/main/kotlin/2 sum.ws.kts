fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, i ->
        map[target - i]?.let {
            return intArrayOf(it, index)
        }
        map[i] = index
    }
    return intArrayOf()
}

twoSum(
    intArrayOf(-1, 0, 1, 2, -1, -4),
    3
).forEach {
    println(it)
}