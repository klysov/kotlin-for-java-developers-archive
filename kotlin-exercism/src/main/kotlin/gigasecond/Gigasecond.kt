import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.Temporal
import kotlin.math.pow

class Gigasecond(initialDate: Temporal) {

    val date: LocalDateTime = try {
        (initialDate as LocalDateTime).plusSeconds(10.0.pow(9).toLong())
    } catch (e: ClassCastException) {
        (initialDate as LocalDate).atStartOfDay().plusSeconds(10.0.pow(9).toLong())
    }
}
