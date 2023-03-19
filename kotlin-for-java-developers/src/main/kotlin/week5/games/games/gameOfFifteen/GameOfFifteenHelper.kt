package week5.games.games.gameOfFifteen

/*
 * This function should return the parity of the permutation.
 * true - the permutation is even
 * false - the permutation is odd
 * https://en.wikipedia.org/wiki/Parity_of_a_permutation

 * If the game of fifteen is started with the wrong parity, you can't get the correct result
 *   (numbers sorted in the right order, empty cell at last).
 * Thus the initial permutation should be correct.
 */
fun isEven(permutation: List<Int>): Boolean {
    val array = permutation.toMutableList()
    var position = 0
    with(array) {
        for (j in 1 until size) {
            var i = j - 1
            val value = this[j]
            while (i >= 0 && this[i] > value) {
                this[i + 1] = this[i]
                position++
                i--
            }
            this[i + 1] = value
        }
    }
    return position % 2 == 0
}