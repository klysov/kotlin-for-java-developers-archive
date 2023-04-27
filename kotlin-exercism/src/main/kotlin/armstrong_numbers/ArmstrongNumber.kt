import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val elements = input.toString().split("").filter { it != "" }.toList()
        if (elements.size == 1) return true
        return elements.sumOf { it.toDouble().pow(elements.size) }.toInt() == input
    }

}
