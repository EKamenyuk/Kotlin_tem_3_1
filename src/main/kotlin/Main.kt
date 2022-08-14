const val MIN: Int = 60
const val HOUR: Int = 3_600
const val DAY: Int = 86_400

val secondSum = 100_125  // вводимая величина в секундах

fun main() {
    println("был(а) " + agoToText(secondSum))
}
fun agoToText(seсondSum: Int): String {
    var text: String = ""
    when {
        seсondSum > 3 * DAY -> text = "давно"
        secondSum <= 3 * DAY && secondSum > 2 * DAY -> text = "вчера"
        secondSum <= 2 * DAY && secondSum > 1 * DAY -> text = "сегодня"
        secondSum <= 2 * HOUR && secondSum > 1 * HOUR -> text = "час назад"
        secondSum in (HOUR + 1)..DAY -> {
            val hours: Int = (secondSum / (HOUR)).toInt()
            text = "$hours час" + endHours(hours) + " назад"
        }

        secondSum in (MIN + 1)..HOUR -> {
            val minutes: Int = (secondSum / (MIN)).toInt()
            text = "$minutes минут" + endMinutes(minutes) + " назад"
        }

        else -> text = "только что"
    }
    return text
}
fun endHours(hours: Int) = when (hours % 10) {
    1 -> if (hours == 11) "ов" else ""
    2, 3, 4 -> "а"
    else -> "ов"
}

fun endMinutes(min: Int) = when (min % 10) {
    1 -> if (min == 11) "" else "у"
    2, 3, 4 -> "ы"
    else -> ""
}