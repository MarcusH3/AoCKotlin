import java.io.File
class AoC22D01 {
/*-------------------Före lösning ----------------------------*/

    fun calCount(tempcal: Int): Int {
        val input = this::class.java.getResource("input.txt").readText().split("\n")
        var maxCal = 0
        var currentCal = 0
        for (i in input) {
            if (i == "") {
                currentCal = 0
                continue
            } else {
                currentCal += i.toInt()
            }
            if (currentCal > maxCal && currentCal < tempcal){
                maxCal  = currentCal
            }
        }
        println("Tomten bär kalorier till ett värde av: $maxCal")
        return maxCal
    }
}
fun main(){
        println(AoC22D01().calCount(800000) + AoC22D01().calCount(69795) + AoC22D01().calCount(69434))}





