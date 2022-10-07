import org.junit.Assert.assertEquals
import org.junit.Test

class VeggieTest {

    fun filterRestaurants(
        restaurants: Array<IntArray>,
        veganFriendly: Int,
        maxPrice: Int,
        maxDistance: Int
    ): List<Int> {

        val stores: List<IntArray> = if (veganFriendly == 1) {
            restaurants.filter { it[2] == veganFriendly }
        } else {
            restaurants.toList()
        }

        val stn = stores.filter { it[3] <= maxPrice && it[4] <= maxDistance }

        val result = mutableSetOf<Int>()
        val st = stn.sortedByDescending { it[1] }

        for (i in st.indices) {
            val b = i + 1
            val aba = st[i][1]
            val bar = st.getOrNull(b)
            val ba = if (bar == null) {
                result.add(st[i][0]); break
            } else bar

            if (aba == ba[1]) {
                st[i].toList().let { println(it) }
                ba.toList().let { println(it) }
                if (st[i][0] < ba[0]) {
                    result.add(ba[0])
                    result.add(st[i][0])
                } else {
                    result.add(st[i][0])
                    result.add(ba[0])
                }
            } else {
                result.add(st[i][0])
            }
        }

        return result.toList()

    }

    @Test
    fun testes() {
        val input = Tada.v
        val actual = filterRestaurants(
            input, 0,
            96930,
            84142
        )

        val expected = Tada.e.toList()
        assertEquals(expected, actual)
    }
}

fun filterRestaurant(restaurants: Array<IntArray>, veganFriendly: Int, maxPrice: Int, maxDistance: Int): List<Int> {
    return restaurants.filter {
        val vegan = if (veganFriendly == 1) it[2] == veganFriendly else true

        vegan &&
                it[3] <= maxPrice &&
                it[4] <= maxDistance
    }.sortedWith(
        compareByDescending<IntArray> { it[1] }
            .thenByDescending { it[0] }
    )
        .map { it[0] }.toList()
}