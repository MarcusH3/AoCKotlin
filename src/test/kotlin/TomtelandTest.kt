import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class TomtelandTest {
  @Test
    fun testGetUnderlingsTomten() {
        val tomteland = Tomteland()
        val expected = listOf("Glader", "Butter", "Tröger", "Trötter", "Blyger", "Skumtomten", "Dammråttan",
            "Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran", "Bladlusen")
        val actual = tomteland.getUnderlings("Tomten", mutableListOf())
        assertEquals(actual, expected)

    }
    @Test
    fun testGetUnderlingsGlader() {
        val tomteland = Tomteland()
        val expected = listOf("Tröger", "Trötter","Blyger","Skumtomten","Dammråttan")
        val actual = tomteland.getUnderlings("Glader", mutableListOf())
        assertEquals(actual, expected)
    }
    @Test
    fun testGetUnderlingsButter() {
        val tomteland = Tomteland()
        val expected = listOf("Rådjuret", "Nyckelpigan","Haren","Räven","Gråsuggan","Myran","Bladlusen")
        val actual = tomteland.getUnderlings("Butter", mutableListOf())
        assertEquals(actual, expected)
    }
    @Test
    fun testGetUnderlingsTrötter() {
        val tomteland = Tomteland()
        val expected = listOf("Skumtomten","Dammråttan")
        val actual = tomteland.getUnderlings("Trötter", mutableListOf())
        assertEquals(actual, expected)
    }
    @Test
    fun testGetUnderlingsSkumtomten() {
    val tomteland = Tomteland()
    val expected = listOf("Dammråttan")
    val actual = tomteland.getUnderlings("Skumtomten", mutableListOf())
    assertEquals(actual, expected)
    }

    @Test
    fun testGetUnderlingsRäven() {
        val tomteland = Tomteland()
        val expected = listOf("Gråsuggan", "Myran", "Bladlusen")
        val actual = tomteland.getUnderlings("Räven", mutableListOf())
        assertEquals(actual, expected)}
    @Test
    fun testGetUnderlingsMyran() {
        val tomteland = Tomteland()
        val expected = listOf("Bladlusen")
        val actual = tomteland.getUnderlings("Myran", mutableListOf())
        assertEquals(actual, expected)}
}



