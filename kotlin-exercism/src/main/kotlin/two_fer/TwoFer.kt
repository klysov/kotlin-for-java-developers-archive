package two_fer
fun twofer(vararg name: String): String {
    return "One for ${if (name.isEmpty()) "you" else name[0]}, one for me."
}
