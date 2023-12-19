import Gegner

class Schneemann (name: String, hp: Int) : Held(name, hp)

{
    override fun verursacheSchaden(gegner: Gegner, schaden: Int) {
        // Zieht den Schaden von den Gesundheitspunkten des Zielgegners ab
        gegner.hp -= schaden

        //// Zeigt den verursachten Schaden
        println("${gegner.name} erleidet $schaden Schaden. Aktuelle HP: ${gegner.hp}")
    }

    override fun alleAktionen() {
        return super.alleAktionen()
    }
    fun aktion1(gegner: Gegner) {
        println("Schneemann führt den Schneeball Angriff aus und fügt dem Gegner.Gegner 40 Schaden zu.")
        verursacheSchaden(gegner, 40)
    }

    fun aktion2(schneemann: Schneemann) {
        println("Schneemann verwendet Heilung und heilt sich um 50 HP.")
        schneemann.hp += 50
    }

    fun aktion3(gegner: Gegner) {
        println("Schneemann fügt ${gegner.name} 30 Schaden hinzu")  //ToDo
        verursacheSchaden(gegner, 30)
    }

    override fun aktion4() {
        println("Schneemann öffnet den Beutel, aber es ist nichts Nützliches drin.")
    }
    public fun turn(gegner: Gegner, schneemann: Schneemann) {
        println("Schneeballangriff")
        println("Heilung")
        println("30 Schaden")
        println("Beutel")

        val userChoice: String = readln()

        when (userChoice) {
            "1" -> aktion1(gegner)
            "2" -> aktion2(schneemann)
            "3" -> aktion3(gegner)
            "4" -> aktion4()
        }
    }
}