import kotlin.math.absoluteValue
import kotlin.math.pow

class Squares(private val number: Int) {

    fun sumOfSquares(): Int = IntProgression.fromClosedRange(1, number, 1)
        .sumOf { it.toDouble().pow(2).toInt() }

    fun squareOfSum(): Int = IntProgression.fromClosedRange(1, number, 1)
        .sum().toDouble().pow(2).toInt()

    fun difference(): Int = sumOfSquares().minus(squareOfSum()).absoluteValue

}
