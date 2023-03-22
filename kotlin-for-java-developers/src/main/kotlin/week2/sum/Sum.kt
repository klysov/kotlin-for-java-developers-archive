package week2.sum

fun List<Int>.sum(): Int {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}

fun main() {
    val sum = listOf(1, 2, 3).sum()
    println(sum)    // 6
}