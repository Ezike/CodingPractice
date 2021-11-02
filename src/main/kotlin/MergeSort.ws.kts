fun sort(array: Array<Int>) {
    split(array, 0, array.size)

}

fun split(array: Array<Int>, start: Int, end: Int) {
    if (end - start < 2) {
        return
    }

    val mid = (start + end) / 2

    println("$start, $end, $mid")

    split(array, start, mid)
    split(array, mid, end)
    merge(array, start, mid, end)
}

fun merge(array: Array<Int>, start: Int, mid: Int, end: Int) {
    if (array[mid - 1] <= array[mid]) {
        return
    }
    var i = start
    var j = mid
    var tempIndex = 0
    val tempArray = arrayOf<Int>()
    // while (i < mid && j < end) {
    //     tempArray[tempIndex++] = if (array[i] <= array[j]) array[i++] else array[j++]
    // }
    //
    // System.arraycopy(array, i, array, start + tempIndex, mid - 1)
    // System.arraycopy(tempArray, 0, array, start, tempIndex)
}

sort(arrayOf(20, 35, -15, 7, 55, 11 , -22))