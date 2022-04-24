fun solution(s: String): Boolean {
    val anomaly = "ba"
    return !s.contains(anomaly)
}

fun solutionDiff(s: String): Boolean {
    val anomaly = "ba"
    var f = 1
    var ba = 0
    while (f < s.length) {
        val s1 = "${s[ba]}${s[f]}"
        if (s1 == anomaly) {
            return false
        }
        ba++
        f++
    }
    return true
}

println(solutionDiff(List(1_000_900) {
    return@List if (it % 500 == 0) "a" else "b"
}.joinToString(separator = "")))

data class Student(
    val id: Int,
    val name: String,
    val subscribedCourses: List<Course>
)

data class Course(
    val id: Int,
    val name: String,
    val isPaid: Boolean
)

interface Repository<T> {
    fun get(): Iterable<T>

    companion object : Repository<Student> {
        override fun get(): Iterable<Student> {
            return listOf(
                Student(
                    id = 1,
                    name = "lad",
                    subscribedCourses = listOf(
                        Course(name = "Maths", isPaid = false, id = 1),
                        Course(name = "Arts", isPaid = true, id = 3)
                    )
                ),
                Student(
                    id = 1,
                    name = "lad",
                    subscribedCourses = listOf(
                        Course(name = "History", isPaid = true, id = 2),
                        Course(name = "Biology", isPaid = true, id = 0)
                    )
                ),
                Student(
                    id = 1,
                    name = "lad",
                    subscribedCourses = listOf(
                        Course(name = "Physics", isPaid = true, id = 6),
                        Course(
                            name = "History", isPaid = true, id = 2
                        )
                    )
                )
            )
        }
    }
}

class University(
    private val repository: Repository<Student>
) {
    fun call(coursesCount: Int): Map<Course, Int> {
        val result = mutableMapOf<Course, Int>()
        repository.get().forEach { student ->
            student.subscribedCourses.forEach {
                if (it.isPaid) {
                    result[it] = result.getOrDefault(it, 0) + 1
                }
            }
        }
        return result.toList().filter { (_, i) ->
            i > 0
        }.sortedByDescending {
            it.second
        }.take(coursesCount).toMap()
    }
}

University(Repository).call(2)
