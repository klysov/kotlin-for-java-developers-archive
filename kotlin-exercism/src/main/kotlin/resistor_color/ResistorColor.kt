object ResistorColor {
    private val colors = listOf("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white")

    fun colorCode(input: String): Int = colors.indexOf(input.lowercase())

    fun colors(): List<String> = colors

}
