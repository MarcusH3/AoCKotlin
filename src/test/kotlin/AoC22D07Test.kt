import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AoC22D07Test {

    private val day07 = AoC22D07()

    @Test
    fun sumDirectories1() {
        assertEquals(1770595, day07.sumDirectories1())

    }

    @Test
    fun findAndDelete2() {
        assertEquals(2195372, day07.findAndDelete2())

    }
}