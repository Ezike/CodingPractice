import kotlin.math.abs

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

fun twoSumAll(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    val size = nums.size
    val result = IntArray(size.plus(size / 2))
    var _index = -1
    nums.forEachIndexed { index, i ->
        map[target - i]?.let {
            result[++_index] = it
            result[++_index] = index
        }
        map[i] = index
    }
    return result.copyOf(_index + 1)
}

println(
    twoSumAll(
        intArrayOf(2, 0, 5, 3, 1, 4, 5),
        5
    ).toList()
)