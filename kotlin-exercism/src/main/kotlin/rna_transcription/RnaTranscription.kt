fun transcribeToRna(dna: String): String = dna.map { char ->
    when (char) {
        'G' -> 'C'
        'C' -> 'G'
        'T' -> 'A'
        'A' -> 'U'
        else -> char
    }
}.joinToString(separator = "")
