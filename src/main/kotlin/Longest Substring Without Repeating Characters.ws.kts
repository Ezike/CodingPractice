fun lengthOfLongestSubstring(s: String): Int {
    val set = mutableSetOf<Char>()
    var left = 0
    var right = 0
    var sum = 0

    while(right < s.length) {
        val char = s[right]
        if(!set.contains(char)) {
            set.add(char)
            right++
            sum = maxOf(sum, set.size)
        } else {
            set.remove(s[left])
            left++
        }
    }

    return sum
}
println(lengthOfLongestSubstring("abcabcbb"))