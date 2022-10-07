package leetcode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val newRoot = root ?: return listOf()
        val result = mutableListOf<List<Int>>()
        val deque = ArrayDeque<TreeNode>()
        deque.add(newRoot)

        while (deque.size > 0) {
            val inner = mutableListOf<Int>()
            for (i in 0 until deque.size) {

                val item = deque.removeFirst()

                inner.add(item.`val`)

                if (item.left != null) {
                    deque.add(item.left!!)
                }
                if (item.right != null) {
                    deque.add(item.right!!)
                }
            }

            result.add(inner)
        }

        return result
    }


fun filterRestaurants(restaurants: Array<IntArray>, veganFriendly: Int, maxPrice: Int, maxDistance: Int): List<Int> {

    val stores: List<IntArray> = if (veganFriendly == 1) {
        restaurants.filter { it[2] == 1 }
    } else {
        restaurants.toList()
    }

    val stn = stores.filter { it[3] <= maxPrice && it[4] <= maxDistance }

    return stn.map { it[2] }.sorted()
}