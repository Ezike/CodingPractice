class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
) {

    override fun toString(): String {
        return "Node == $value"
    }
}

fun bfs(node: TreeNode) {
    val q = ArrayDeque<TreeNode>()
    q.add(node)

    val result = mutableListOf<Int>()

    var i = 0
    while (q.isNotEmpty()) {
        i++
        println("$i--$q")
        val child = q.removeFirst()
        if (child.left != null) q.add(child.left!!)
        if (child.right != null) q.add(child.right!!)
        result.add(child.value)
    }

    println(result)
}


val eg = TreeNode(
    value = 1,
    left = TreeNode(
        7,
        TreeNode(7),
        TreeNode(-8)
    ),
    right = TreeNode(0, right = TreeNode(7))
)

bfs(eg)
// bfs 1, 7, 0, 7, -8
//