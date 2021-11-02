val items = arrayOf(3,1,3,4,2)
fun findRepeated(array: Array<Int>): Int {
    val size = array.size
    val initial = array.sum()
    var index = 0
    var after = 0
    for (num in array) {
        if (index == size - 1) {
            break
        }
        after += num
        index++
    }

    return initial - after
}

println(findRepeated(items))