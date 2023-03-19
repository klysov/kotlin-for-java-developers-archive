package week3.safe_casts

fun main() {
    val s = "a"
    println(s as? Int)    // null
    println(s as Int?)    // exception
}