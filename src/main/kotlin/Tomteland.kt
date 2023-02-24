import java.util.*

class Tomteland {

    val chefshierarki = mapOf(
        "Tomten" to listOf("Glader", "Butter"),
        "Glader" to listOf("Tröger", "Trötter", "Blyger"),
        "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to listOf("Skumtomten"),
        "Skumtomten" to listOf("Dammråttan"),
        "Räven" to listOf("Gråsuggan", "Myran"),
        "Myran" to listOf("Bladlusen")
    )

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        val underlings = chefshierarki[currentName]
        if (underlings != null) {
            res.addAll(underlings)
            underlings.forEach { getUnderlings(it, res) }
        }
        return res.toList()
    }}

    fun main() {
        val tomteland = Tomteland()
        while (true) {
            println("\nVems underlydande önskar ni listas??")
            val input = readln().replaceFirstChar { if (it.isLowerCase())
                it.titlecase(Locale.getDefault()) else it.toString() }
            if (input.isBlank()) break
            println(tomteland.getUnderlings(input, mutableListOf()))
        }
    }
