class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun removeNthFromEndA(head: ListNode?, n: Int): ListNode? {
    val l = head
    if(l == null || (l.next == null && n > 0)) return null

    var r: ListNode? = l
    var sizeCheck = head
    var size = 0

    while(sizeCheck != null) {
        size++
        sizeCheck = sizeCheck.next
    }

    if(size == n) return l.next

    while(r != null) {
        if(size == n + 1) {
            r.next = r.next?.next
            break
        } else {
            size--
            r = r.next
        }
    }

    return l
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val preHead = ListNode(0).also { it.next = head }
    var fast = preHead
    var slow = preHead

    repeat(n) {
        fast = fast.next!!
    }

    while (fast.next != null) {
        fast = fast.next!!
        slow = slow.next!!
    }
    slow.next = slow.next?.next
    return preHead.next
}

removeNthFromEndA(ListNode(4).also {it.next = ListNode(5)}, 1 )?.`val`