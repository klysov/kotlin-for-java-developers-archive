object Acronym {
    fun generate(phrase: String): String = phrase.split(" ", "_", "-")
        .filter { it != "" }
        .map { it[0] }
        .joinToString(separator = "")
        .uppercase()
}
