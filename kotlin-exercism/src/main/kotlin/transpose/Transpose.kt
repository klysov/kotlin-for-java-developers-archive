object Transpose {

    fun transpose(input: List<String>): List<String> {
        if (input.isEmpty()) return input
        val comparator: (String, String) -> Int =
            { o1, o2 -> if (o1.length > o2.length) 1 else (if (o1.length < o2.length) -1 else 0) }
        val max = input.stream().max(comparator).get().length
        val result = mutableListOf<String>()
        for (i in 0 until max) result.add("")
        for (str in input) {
            for (i in 0 until max) {
                result[i] = result[i].plus(if (i in str.indices) str[i] else " ")
            }
        }
        result[max - 1] = result[max - 1].trimEnd()
        return result
    }
}
