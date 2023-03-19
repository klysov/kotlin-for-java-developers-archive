package week4.unstable_val

import kotlin.random.Random

val foo: Int
    get() = Random.nextInt()

fun main() {
    // The values should be different:
    println(foo)
    println(foo)
    println(foo)
}