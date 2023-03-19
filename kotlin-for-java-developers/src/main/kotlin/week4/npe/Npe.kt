package week4.npe

open class A(open val value: String) {
    init {
        // call any method
        value.chars()
    }
}

class B(override val value: String) : A(value)

fun main() {
    B("a")
}