fun solution(s: String): Boolean {
    val anomaly = "ba"
    return !s.contains(anomaly)
}

fun solutionDiff(s: String): Boolean {
    val anomaly = "ba"
    var f = 1
    var ba = 0
    while (f < s.length){
        val s1 = "${s[ba]}${s[f]}"
        if (s1 == anomaly) {
            return false
        }

        ba++
        f++
    }
    return true
}

fun main() {
println(solutionDiff(List(1_000) {
    return@List if (it % 2 == 0) "a" else "b"
}.toString().also { println(it) }))

    // println(solutionDiff("aab"))
}