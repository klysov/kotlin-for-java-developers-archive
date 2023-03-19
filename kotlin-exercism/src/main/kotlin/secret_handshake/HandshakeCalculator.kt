object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        var list = mutableListOf<Signal>()
        number.toString(2).reversed().forEachIndexed{
            i, char ->
            when(i) {
                0 -> if (char == '1') list.add(Signal.WINK)
                1 -> if (char == '1') list.add(Signal.DOUBLE_BLINK)
                2 -> if (char == '1') list.add(Signal.CLOSE_YOUR_EYES)
                3 -> if (char == '1') list.add(Signal.JUMP)
                4 -> if (char == '1') list = list.reversed().toMutableList()
            }
        }
        return list
    }
}
