import Gegner
import Held
class Elfe(name: String, hp: Int) : Held(name, hp) {


    override fun verursacheSchaden(gegner: Gegner, schaden: Int) {
        // Zieht den Schaden von den Gesundheitspunkten des Zielgegners ab
        gegner.hp -= schaden

        // Zeigt den verursachten Schaden
        println("${gegner.name} erleidet $schaden Schaden. Aktuelle HP: ${gegner.hp}")
    }

    override fun alleAktionen() {
        return alleAktionen() // gibt die vorher auf Klassenebene deklarierte Liste zurück
    }

    fun aktion1(gegner: Gegner) {
        println("Elfe führt den Packet Angriff aus und fügt dem Gegner.Gegner 50 Schaden zu.")
        verursacheSchaden(gegner, 50)
    }

    fun aktion2(elfe: Elfe) {
        println("Elfe verwendet Heilung und heilt sich um 50 HP.")
        elfe.hp += 50
    }

    fun aktion3(gegner: Gegner) {
        println("Elfe fügt ${gegner.name} 30 Schaden hinzu")  //ToDo
        verursacheSchaden(gegner, 30)
    }

    override fun aktion4() {
        println("Elfe öffnet den Beutel, aber es ist nichts Nützliches drin.")
    }

    public fun turn(gegner: Gegner, elfe: Elfe) {
        println("Paketangriff")
        println("Heilung")
        println("30 Schaden")
        println("Beutel")

        val userChoice: String = readln()

        when (userChoice) {
            "1" -> aktion1(gegner)
            "2" -> aktion2(elfe)
            "3" -> aktion3(gegner)
            "4" -> aktion4()
        }
    }
}


