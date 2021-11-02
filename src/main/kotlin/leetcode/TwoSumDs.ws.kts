class TwoSum() {

    /** Initialize your data structure here. */
    val sortedList = mutableListOf<Int>()

    /** Add the number to an internal data structure.. */
    fun add(number: Int) {
        var left = 0
        var right = sortedList.size - 1
        while (left <= right) {
            val mid = (right - left) / 2 + left
            println("$right == $left == $mid == $number \n")
            if (number == sortedList[mid]) {
                sortedList.add(mid, number)
                return
            }
            if (number < sortedList[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
         println("$left -== $number \n")
        sortedList.add(left, number)
        println(sortedList)
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    fun find(value: Int): Boolean {
        var left = 0
        var right = sortedList.size - 1
        while (left < right) {
            if (sortedList[left] + sortedList[right] == value) return true
            if (sortedList[left] + sortedList[right] < value) left++
            else right--
        }
        return false
    }
}

val e = TwoSum()
e.add(4)
e.add(2)
e.add(12)
e.add(5)
e.add(11)
