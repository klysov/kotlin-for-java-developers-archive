package week4.late_init

class A {
    private lateinit var prop: String

    fun setUp() {
        prop = "value"
    }

    fun display() {
        println(prop)
    }
}

fun main() {
    val a = A()
    a.setUp()
    a.display()
}