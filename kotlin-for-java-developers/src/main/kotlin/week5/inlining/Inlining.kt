package week5.inlining

fun filterNonZero(list: List<Int>) = list.filter { it != 0 }

fun filterNonZeroGenerated(list: List<Int>): List<Int> {
    val resultingList = ArrayList<Int>()
    list.forEach { element -> if (element != 0) resultingList.add(element) }
    return resultingList
}

fun main() {
    val list = listOf(1, 2, 3)

    filterNonZero(list).toString() eq "[1, 2, 3]"
    filterNonZeroGenerated(list).toString() eq "[1, 2, 3]"
}

inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
    val destination = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            destination.add(element)
        }
    }
    return destination
}

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}
