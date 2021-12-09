data class ListNode(
    var data: Int,
    var next: ListNode? = null
)

val head
    get() = ListNode(
        0,
        ListNode(
            4,
            ListNode(
                9,
                ListNode(
                    8
                )
            )
        )
    )

fun insertAtTail(node: ListNode?, d: Int): ListNode? {
    val head = node
    fun traverse(node: ListNode?, d: Int): ListNode? {
        return if (node?.next == null) {
            node?.next = ListNode(d)
            node
        } else {
            traverse(node.next, d)
        }
    }
    traverse(head, d)
    return head!!
}

fun delete(node: ListNode?, int: Int): ListNode? {
    var current = node
    val sent = ListNode(0, node)
    var prev: ListNode = sent

    while (current != null) {
        if (current.data == int) {
            prev.next = current.next
        } else prev = current
        current = current.next
    }
    return sent.next
}

fun printNode(node: ListNode?) {
    if (node != null) {
        println(node.data)
        printNode(node.next)
    }
}

fun reverse(node: ListNode): ListNode? {
    var prev: ListNode? = null
    var next: ListNode?
    var current: ListNode? = node

    while (current != null) {
        next = current?.next
        current?.next = prev
        prev = current
        current = next
    }

    return prev
}

fun fromList(vararg list: Int): ListNode? {
    var head: ListNode? = null
    list.forEach {
        val node = ListNode(it)
        if (head == null) head = node
        else {
            var e = head
            while (e?.next != null) {
                e = e.next
            }
            e?.next = node
        }
    }

    return head
}

fun union(node1: ListNode?, node2: ListNode?): ListNode? {
    node1 ?: return node2
    node2 ?: return node1

    val set = hashSetOf<Int>()
    var first = node1
    while (first?.next != null) {
        first = first.next
    }
    var lopp = node1
    while (lopp != null) {
        set.add(lopp.data)
        lopp = lopp.next
    }
    var sec = node2
    val sent = ListNode(Integer.MAX_VALUE).also { it.next = node2 }
    var prev = sent

    while (sec != null) {
        if (set.contains(sec.data)) prev.next = sec.next
        else prev = sec
        sec = sec.next
    }
    first?.next = sent.next
    return node1
}

fun intersection(node1: ListNode?, node2: ListNode?): ListNode? {
    node1 ?: return null
    node2 ?: return null

    var b = node2
    var result: ListNode? = null
    val set = hashSetOf<Int?>()
    var e = node1

    while (e != null) {
        set.add(e?.data)
        e = e?.next
    }

    while (b != null) {
        if (set.contains(b.data)) {
            if (result == null) {
                result = ListNode(b.data)
            } else {
                var ll = result
                while (ll?.next != null) {
                    ll = ll.next
                }
                ll?.next = ListNode(b.data)
            }
        }
        b = b.next
    }

    return result
}

fun palindrome(node: ListNode): Boolean {
    var slow: ListNode? = node
    var fast: ListNode? = node.next
    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    var current: ListNode? = slow
    var prev: ListNode? = null

    while (current != null) {
        val next: ListNode? = current?.next
        current?.next = prev
        prev = current
        current = next
    }
    var iter: ListNode? = node
    var result = prev
    while (result != null) {
        if (iter?.data != result?.data) {
            return false
        }
        iter = iter?.next
        result = result?.next
    }

    return true
}

fun cycle(node: ListNode): Boolean {
    var slow: ListNode? = node
    var fast: ListNode? = node.next
    while (fast != slow) {
        if (fast == null || fast?.next == null) {
            return false
        }
        slow = slow?.next
        fast = fast?.next?.next
    }
    return true
}

fun printNodew(node: ListNode?) {
    var ler = node
    while (ler != null) {
        print(ler.data)
        ler = ler.next
    }
}

// printNode(reverse(head))
// printNode(intersection(head, fromList(4, 9, 8, 0)))
palindrome(fromList(0,1,9,9,1,0)!!)

val rel = fromList(2)
val cyc = ListNode(
    0,
    rel?.apply {
        next =
            ListNode(
                4,
                ListNode(
                    9,
                    rel
                )
            )
    }

)

cycle(cyc)