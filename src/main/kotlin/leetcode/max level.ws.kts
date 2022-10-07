
class TreeNode(
    var `val`: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun maxLevelSum(root: TreeNode?): Int {
    fun dfs(root: TreeNode?, sums: IntArray, depth: Int): Int {
        root ?: return depth - 1

        sums[depth] += root.`val`
        val l = dfs(root.left, sums, depth + 1)
        val r = dfs(root.right, sums, depth + 1)
        return maxOf(l, r)
    }

    val sums = IntArray(10_001)
    val maxDepth = dfs(root, sums, 1)


    var res = 1
    for (i in 1..maxDepth) {
        if (sums[i] > sums[res]) {
            res = i
        }
    }

    return res
}

println(
    maxLevelSum(
        TreeNode(
            1,
            TreeNode(
                7,
                TreeNode(7),
                TreeNode(-8)
            ),
            TreeNode(0)
        )
    )
)