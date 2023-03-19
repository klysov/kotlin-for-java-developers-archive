package week3.nicestring

fun String.isNice(): Boolean {
    val conditionOne = !this.contains(Regex("bu|ba|be"))
    val conditionTwo = this.contains(Regex("(\\w*[aeuio]\\w*){3,}"))
    val conditionThree = this.contains(Regex("(.)\\1+"))
    return conditionOne && conditionTwo
            || conditionOne && conditionThree
            || conditionTwo && conditionThree
}