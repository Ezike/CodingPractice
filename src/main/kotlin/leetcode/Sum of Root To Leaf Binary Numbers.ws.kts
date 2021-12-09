import leetcode.TreeNode

class Solution {
    fun sumRootToLeaf(root: TreeNode?): Int {
        fun dfs(root: TreeNode?, result: String): Int {
            if(root == null) return 0
            if(root.left == null && root.right == null) {
                return Integer.parseInt("$result${root.`val`}", 2)
            }

            return dfs(root.left, "$result${root.`val`}") + dfs(root.right, "$result${root.`val`}")
        }

        return dfs(root, "")
    }
}