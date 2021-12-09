import leetcode.ListNode

class Solution {

    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        if (head?.next == null) return intArrayOf(-1, -1)
        var prevNode: ListNode? = null
        var currentNode = head
        val array = mutableListOf<Int>()
        var count = -1

        while (currentNode != null) {
            count++
            val nextNode = currentNode.next
            if (prevNode != null && nextNode != null) {
                if ((prevNode.`val` < currentNode.`val`) && (nextNode.`val` < currentNode.`val`)) {
                    array.add(count)
                }
                if ((prevNode.`val` > currentNode.`val`) && (nextNode.`val` > currentNode.`val`)) {
                    array.add(count)
                }
            }

            prevNode = currentNode
            currentNode = currentNode.next
        }

        if (array.size <= 1) return intArrayOf(-1, -1)
        var min = Integer.MAX_VALUE
        for (i in 1 until array.size) {
            min = minOf(min, array[i] - array[i - 1])
        }
        val max = array[array.lastIndex] - array[0]

        return intArrayOf(min, max)
    }
}