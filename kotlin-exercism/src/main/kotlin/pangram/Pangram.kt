object Pangram {

    fun isPangram(input: String): Boolean = input.lowercase().toCharArray()
        .filter { char -> char in 'a'..'z' }
        .toSet().count() == 26

}
