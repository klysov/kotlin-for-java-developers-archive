object ResistorColorDuo {
    private val colors = arrayOf("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white")

    fun value(vararg colors: Color): Int = (this.colors.indexOf(colors[0].name.lowercase()) * 10) + this.colors.indexOf(colors[1].name.lowercase())
}
