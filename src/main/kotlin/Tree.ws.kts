import java.util.Stack

data class TreeNode(
    var value: Int?
) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun insert(data: Int) {
        if (value == data) {
            return
        }
        if (data < value!!) {
            if (left == null) {
                left = TreeNode(data)
            } else {
                left?.insert(data)
            }
        } else {
            if (right == null) {
                right = TreeNode(data)
            } else {
                right?.insert(data)
            }
        }
    }

    fun traverseInOrder() {
        left?.traverseInOrder()
        println("Data = $value, ")
        right?.traverseInOrder()
    }

    fun get(arg: Int): TreeNode? {
        if (value == arg) {
            return this
        }

        if (arg < value!!) {
            if (left != null) {
                return left?.get(arg)
            }
        } else {
            if (right != null) {
                return right?.get(arg)
            }
        }

        return null
    }

    fun min(): Int? = left?.min() ?: value
    fun minT(): Int? = left?.minT()
    fun maxT(): Int? = left?.maxT()
    fun max(): Int? = right?.max() ?: value
}

class MyTree : Iterable<Int> {

    private var root: TreeNode? = null

    fun insert(data: Int) {
        if (root == null) {
            root = TreeNode(data)
        } else {
            root?.insert(data)
        }
    }

    fun render() {
        root?.traverseInOrder()
    }

    fun get(arg: Int) = root?.get(arg)

    fun min(): Int? = root?.min()
    fun max(): Int? = root?.max()

    fun delete(value: Int) {
        root = deleteInternal(root, value)
    }

    private fun deleteInternal(root: TreeNode?, value: Int): TreeNode? {
        root ?: return null
        if (value < root.value!!) {
            println("$root, ${root.left}")
            root.left = deleteInternal(root.left, value)
        } else if (value > root.value!!) {
            println("$root, ${root.right}")
            root.right = deleteInternal(root.right, value)
        } else {
            if (root.left == null) {
                println("--$root, ${root.left} ${root.right}")
                return root.right
            } else if (root.right == null) {
                println("--$root, ${root.left} ${root.right}")
                return root.left
            }

            println("--$root, ${root.left} ${root.right}")
            root.value = root.right?.min()
            println("--$root, ${root.left} ${root.right}")
            root.right = deleteInternal(root.right, root.value!!)
            println("--$root, ${root.left} ${root.right}")
        }
        return root
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            val stack = Stack<Int>()
            fun TreeNode.update(v: (Int) -> Unit) {
                left?.update(v)
                value?.let { v(it) }
                right?.update(v)
            }

            init {
                root?.update(stack::push)
            }

            override fun hasNext(): Boolean {
                return stack.isNotEmpty()
            }

            override fun next(): Int {
                return stack.pop()
            }
        }
    }
}

val tree = MyTree()
tree.insert(25)
tree.insert(20)
tree.insert(15)
tree.insert(27)
tree.insert(30)
tree.insert(29)
tree.insert(26)
tree.insert(22)
tree.insert(32)
tree.insert(17)


// tree.delete(15)
// tree.render()

tree.forEach { println(it) }
// print(tree.get(32))
// println(tree.max())
// println(tree.min())