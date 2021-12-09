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

