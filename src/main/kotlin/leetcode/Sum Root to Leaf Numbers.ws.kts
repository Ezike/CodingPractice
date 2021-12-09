import leetcode.TreeNode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 */

class Solution {
    fun sumNumbers(root: TreeNode?): Int {

        fun traverse(node: TreeNode?, result: String): Int {
            if (node == null) return 0

            if (node.left == null && node.right == null) {
                return Integer.parseInt("$result${node.`val`}")
            }
            return traverse(node.left, "$result${node.`val`}") + traverse(node.right, "$result${node.`val`}")
        }

        return traverse(root, "")
    }
    fun sumNumbersStack(root: TreeNode?): Int {
        if(root == null) return 0
        val pathHolder = mutableListOf<List<Int>>()
        val stack = ArrayDeque<Int>()
        stack.add(root.`val`)

        fun dfs(node: TreeNode, list: MutableList<List<Int>>, stack: ArrayDeque<Int>) {
            if(node.left == null && node.right == null) {
                list.add(stack.toList())
                return
            }
            if(node.left != null) {
                stack.add(node.left!!.`val`)
                dfs(node.left!!, list, stack)
                stack.removeLast()
            }
            if(node.right != null) {
                stack.add(node.right!!.`val`)
                dfs(node.right!!, list, stack)
                stack.removeLast()
            }

        }
        dfs(root, pathHolder,stack)
        var sum = 0
        for (e in pathHolder){
            var ch = ""
            e.forEach {
                ch += it
            }
            sum += ch.toInt()
        }
        return sum
    }
}