import java.util.Stack

val sample = listOf(1, 3, 6, 7)
val sum = 9

fun printMAxSubArray(list: List<Int>, sum: Int): Result? {
    val set = hashSetOf<Int>()
    list.forEach {
        if (set.contains(it)) {
            return Result(it, sum - it)
        }
        set.add(sum - it)
    }
    return null
}

println(printMAxSubArray(sample, sum))

data class Result(
    val a: Int,
    val b: Int
)
val s = "5F3Z-2e-9-w"
print(s.split("-"))