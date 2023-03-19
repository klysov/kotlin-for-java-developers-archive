package week2.checking_identifier

fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty()) {
        return false
    }

    if (s[0] != '_'
        && s[0] !in 'a'..'z'
        && s[0] !in 'A'..'Z'
    ) {
        return false
    }

    for (char in s.substring(1)) {
        if (char != '_'
            && char !in 'a'..'z'
            && char !in 'A'..'Z'
            && char !in '0'..'9'
        ) {
            return false
        }
    }

    return true
}

fun main() {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}