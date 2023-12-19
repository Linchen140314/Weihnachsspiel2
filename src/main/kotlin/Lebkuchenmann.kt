import Gegner
import Held
class Lebkuchenmann(name: String, hp: Int) : Held(name, hp)

{
    override fun verursacheSchaden(gegner: Gegner, schaden: Int) {
        // Zieht den Schaden von den Gesundheitspunkten des Zielgegners ab
        gegner.hp -= schaden

        // Zeigt den verursachten Schaden
        println("${gegner.name} erleidet $schaden Schaden. Aktuelle HP: ${gegner.hp}")
    }
    override fun alleAktionen() {
        return super.alleAktionen() // gibt die vorher auf Klassenebene deklarierte Liste zurück
    }
    fun aktion1(gegner: Gegner) {
        println("Lebkuchenmann führt den Zuckerstangen Angriff aus und fügt dem Gegner.Gegner 60 Schaden zu.")
        verursacheSchaden(gegner, 40)

    }

    fun aktion2(lebkuchenmann: Lebkuchenmann) {
        println("Lebkuchenmann verwendet Heilung und heilt sich um 50 HP.")
        lebkuchenmann.hp += 50
    }

    fun aktion3(gegner: Gegner) {
        println("Lebkuchenmann fügt ${gegner.name} 30 Schaden hinzu")
        verursacheSchaden(gegner, 30)
    }

    override fun aktion4() {
        println("Lebkuchenmann öffnet den Beutel, aber es ist nichts Nützliches drin.")
    }
    public fun turn(gegner: Gegner, lebkuchenmann: Lebkuchenmann) {
        println("Zuckerstangen Angriff")
        println("Heilung")
        println("30 Schaden")
        println("Beutel")

        val userChoice: String = readln()

        when (userChoice) {
            "1" -> aktion1(gegner)
            "2" -> aktion2(lebkuchenmann)
            "3" -> aktion3(gegner)
            "4" -> aktion4()
        }
    }
}