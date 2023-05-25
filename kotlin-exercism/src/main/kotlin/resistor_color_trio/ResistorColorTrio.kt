package resistor_color_trio

object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val zeros = (if (input[1] == Color.BLACK) 1 else 0) + input[2].ordinal
        return "".plus(input[0].ordinal)
            .plus(if (input[1] == Color.BLACK) "" else input[1].ordinal)
            .plus("0".repeat(zeros % 3))
            .plus(" ".plus(Unit.values()[zeros / 3]).lowercase())
    }
}
