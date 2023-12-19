import Gegner
import Held

class Rudolf (name: String, hp: Int) : Held(name, hp)

{

    // Verursachen von Schaden an einem Gegner
    override fun verursacheSchaden(gegner: Gegner, schaden: Int) {
        // Zieht den Schaden von den Gesundheitspunkten des Zielgegners ab
        gegner.hp -= schaden

        // // Zeigt den verursachten Schaden
        println("${gegner.name} erleidet $schaden Schaden. Aktuelle HP: ${gegner.hp}")
    }

    //  spezifischen Aktionen für Rudolfs Angriffe
    fun aktion1(gegner: Gegner) {

        println("Rudolf führt den Leuchtangriff aus und fügt dem Gegner 60 Schaden zu.")
        verursacheSchaden(gegner, 60)
    }

    fun aktion2(rudolf: Rudolf) {
        println("Rudolf verwendet Heilung und heilt sich um 40 HP.")
        rudolf.hp += 40
    }

    fun aktion3(gegner: Gegner) {
        println("Rudolf fügt ${gegner.name} 30 Schaden hinzu")
        verursacheSchaden(gegner, 40)
    }

    override fun aktion4() {
        println("Rudolf öffnet den Beutel, aber es ist nichts Nützliches drin.")
    }
    public fun turn(gegner: Gegner, rudolf: Rudolf) {
        println("Leuchtangriff")
        println("Heilung")
        println("30 Schaden")
        println("Beutel")

        val userChoice: String = readln()

        when (userChoice) {
            "1" -> aktion1(gegner)
            "2" -> aktion2(rudolf)
            "3" -> aktion3(gegner)
            "4" -> aktion4()
        }
    }
}