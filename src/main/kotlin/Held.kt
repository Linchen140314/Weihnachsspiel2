import Gegner
import kotlin.math.round

open class Held(
    val name: String,
    var hp: Int = 0,
    var ep: List<Pair<String, Int>> = emptyList(),
    var ap: Int = 0
) {
    open fun verursacheSchaden(gegner: Gegner, schaden: Int) {
        gegner.hp -= schaden
        println("${gegner.name} erleidet $schaden Schaden. Aktuelle HP: ${gegner.hp}")
    }

    val alleAktionen = listOf(::aktion1, ::aktion2, ::aktion3, ::aktion4)

    open fun aktion1() {
        println("$name führt Aktion 1 aus.")
    }

    open fun aktion2() {
        println("$name führt Aktion 2 aus.")
    }

    open fun aktion3() {
        println("$name führt Aktion 3 aus.")
    }

    open fun aktion4() {
        println("$name führt Aktion 4 aus.")
    }

    open fun alleAktionen() {
        println("Verfügbare Aktionen:")
        alleAktionen.forEach { println(it) }
    }

    fun useBeutel(beutel: Beutel): Int {
        println("Du möchtest den Beutel nutzen?")
        println(" Verfügbare Heiltränke ${beutel.anzahlHeiltränke}")
        println(" Verfügbare Booster ${beutel.anzahlBooster}")
        println(" [1] => Heiltrank, [2] => Booster, [3] => Beutel verlassen")

        try {
            val input = readln()
            when (input) {
                "1" -> {
                    beutel.heiltrankNutzen(this)
                    return 1
                }

                "2" -> {
                    beutel.boosterNutzen(this)
                    return 2
                }
                "3" -> {
                    return 3
                }
                else -> {
                    println("Bitte gib eine gültige Zahl ein! \nProbier's nochmal...")
                    return useBeutel(beutel)
                }
            }
        } catch (e: NumberFormatException) {
            println("Du musst eine gültige Zahl, keinen Buchstaben eingeben!")
            return useBeutel(beutel)
        }
    }

    open fun isEmptyWorries(): Boolean {
        return hp <= 0
    }
}