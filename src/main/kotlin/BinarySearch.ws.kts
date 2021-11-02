import java.util.Stack

val items = arrayOf(-22, -15,1,3,5, 20, 30, 35, 55)

fun searchNoRecursion(array: Array<Int>, value: Int): Int {
    var start = 0
    var end = array.size

    while (start < end) {
        val mid = (start + end) / 2
        if (array[mid] == value) {
          return  array[mid]
        } else if (value > array[mid]) {
            start = mid + 1
        } else {
           end = mid
        }
    }
    
    return Integer.MAX_VALUE
}  

fun search(array: Array<Int>, value: Int): Int {
    return runSearch(0, array.size, array, value)
}

fun runSearch(start: Int, end: Int, array: Array<Int>, value: Int): Int {
    if (start >= end) {
        return -1
    }
    val mid = (start + end) / 2
    println("$start, $end, $mid --")
    return if (array[mid] == value) {
        array[mid]
    } else if (value > array[mid]) {
        runSearch(start = mid + 1, end, array, value)
    } else {
        runSearch(start, mid, array, value)
    }
}

println(searchNoRecursion(items, 55))