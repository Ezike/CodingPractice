import java.util.ArrayDeque
import java.util.LinkedList

fun isPalindrome(string: String): Boolean {
    val arrayDeque = ArrayDeque<Char>()
    string.forEach {
        if (it.isLetter()) arrayDeque.push(it)
    }

    for (char in string) {
        if (!char.isLetter()) {
            continue
        }
        if (char != arrayDeque.pop()) {
            return false
        }
    }
    return arrayDeque.isEmpty()
}

fun isPalindromeNeu(string: String): Boolean {
    val arrayDeque = ArrayDeque<Char>()
    string.forEach {
        if (it.isLetter()) arrayDeque.push(it)
    }
    while (arrayDeque.size > 1) {
        val pollFirst = arrayDeque.pollFirst()
        val pollLast = arrayDeque.pollLast()
        if (pollFirst != pollLast) {
            return false
        }
    }
    return true
}

isPalindromeNeu(",,,I did,did I....")