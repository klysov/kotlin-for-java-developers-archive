package hamming

object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int =
        if (leftStrand.length == rightStrand.length)
            leftStrand.indices.count { leftStrand[it] != rightStrand[it] }
        else throw IllegalArgumentException("left and right strands must be of equal length")
}
