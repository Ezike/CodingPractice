import java.util.Stack

fun backspaceCompareX(s: String, t: String): Boolean {
    val backSpace = '#'
    var sS = ""
    var tt = ""

    var i = 0
    while (i < s.length) {
        val c = s[i]
        if (c == backSpace) {
            if (sS.isNotBlank()) {
                sS = s.slice(0 until i)
            }
        } else {
            sS += c
        }
        i++
    }

    var iT = 0
    while (iT < s.length) {
        val c = s[iT]
        if (c == backSpace) {
            if (tt.isNotBlank()) {
                tt = tt.dropLast(1)
            }
        } else {
            tt += c
        }
        iT++
    }

    println("$sS, $tt")
    return sS == tt
}

fun backspaceCompare(s: String, t: String): Boolean {
    val backSpace = '#'

    val sStack = Stack<Char>()
    val tStack = Stack<Char>()

    s.forEach { c ->
        if (c == backSpace) {
            sStack.pop()
        } else {
            sStack.push(c)
        }
    }

    t.forEach { c ->
        if (c == backSpace) {
            tStack.pop()
        } else {
            tStack.push(c)
        }
    }

    println(sStack.toString())
    println(tStack.toString())
    return sStack.toString() == tStack.toString()
}



println(
    backspaceCompareX(
        "a#b#c",
        "ab##c"
    )
)