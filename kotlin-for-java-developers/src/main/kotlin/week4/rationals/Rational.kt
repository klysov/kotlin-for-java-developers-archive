package week4.rationals

import java.math.BigInteger

class Rational(
    val numerator: BigInteger,
    val denominator: BigInteger
) : Comparable<Rational> {
    operator fun plus(rational: Rational): Rational = (numerator.times(rational.denominator)
        .plus(rational.numerator.times(denominator)))
        .divBy(rational.denominator.times(denominator))

    operator fun minus(rational: Rational): Rational = (numerator.times(rational.denominator)
        .minus(rational.numerator.times(denominator)))
        .divBy(rational.denominator.times(denominator))

    operator fun times(rational: Rational): Rational = numerator.times(rational.numerator)
        .divBy(rational.denominator.times(denominator))

    operator fun div(rational: Rational): Rational = numerator.times(rational.denominator)
        .divBy(denominator.times(rational.numerator))

    operator fun unaryMinus(): Rational = Rational(numerator.negate(), denominator)

    override fun compareTo(other: Rational): Int = numerator.times(other.denominator)
        .compareTo(other.numerator.times(denominator))

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        other as Rational
        return numerator.times(other.denominator) == denominator.times(other.numerator)
    }

    override fun toString(): String {
        return when {
            (denominator == 1.toBigInteger() || (numerator % denominator) == 0.toBigInteger()) -> numerator.div(
                denominator
            ).toString()

            else -> {
                val rational = simplify(this)
                if (rational.denominator < 0.toBigInteger() || (rational.numerator < 0.toBigInteger() && rational.denominator < 0.toBigInteger())) {
                    format(Rational(rational.numerator.negate(), rational.denominator.negate()))
                } else {
                    format(Rational(rational.numerator, rational.denominator))
                }
            }
        }
    }
}

fun simplify(rational: Rational): Rational {
    val gcd = rational.numerator.gcd(rational.denominator)
    return Rational(rational.numerator / gcd, rational.denominator / gcd)
}

fun format(rational: Rational): String = rational.numerator.toString() + "/" + rational.denominator.toString()

infix fun Int.divBy(anotherInt: Int): Rational = Rational(toBigInteger(), anotherInt.toBigInteger())

infix fun Long.divBy(anotherLong: Long): Rational = Rational(toBigInteger(), anotherLong.toBigInteger())

infix fun BigInteger.divBy(anotherBigInt: BigInteger): Rational = Rational(this, anotherBigInt)

fun String.toRational(): Rational {
    val number = split("/")
    return when (number.size) {
        1 -> Rational(number[0].toBigInteger(), 1.toBigInteger())
        else -> Rational(number[0].toBigInteger(), number[1].toBigInteger())
    }
}

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println(
        "912016490186296920119201192141970416029".toBigInteger() divBy
                "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2
    )
}