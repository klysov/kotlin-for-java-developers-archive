package week2.mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var wrongPosition = 0
    var processedGuess = guess
    var processedSecret = secret
    for (i in 0..3) {
        if (processedGuess[i] == processedSecret[i]) {
            rightPosition++
            processedSecret = processedSecret.replaceRange(i, i + 1, "_")
            processedGuess = processedGuess.replaceRange(i, i + 1, "*")
        }
    }
    for (i in 0..3) {
        if (processedGuess[i] != processedSecret[i] && processedGuess[i] in processedSecret) {
            wrongPosition++
            processedSecret = processedSecret.replaceFirst(guess[i], '_')
        }
    }
    return Evaluation(rightPosition, wrongPosition)
}
