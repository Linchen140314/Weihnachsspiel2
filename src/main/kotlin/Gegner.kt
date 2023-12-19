
open class Gegner(val name: String,
                  var hp: Int,
) {





    open fun verursacheSchaden(held: Held, schaden: Int) {
        held.hp -= schaden
        println("${held.name} erleidet $schaden Schaden. Aktuelle HP: ${held.hp}")
    }

    open fun flächenSchaden(heldengruppe: List<Held>, minSchaden: Int, maxSchaden: Int) {
        for (held in heldengruppe) {
            val randomSchaden = (minSchaden..maxSchaden).random()
            verursacheSchaden(held, randomSchaden)
        }
    }

    open fun führeZufälligeAktionAus() {

        // Der Boss kann eine zufällige Aktion ausführen, die Schaden verursacht
        val randomActionIndex = (1..4).random()
        when (randomActionIndex) {
            1 -> aktionGegner1()
            2 -> aktionGegner2()
            3 -> aktionGegner3()
            4 -> aktionGegner4()
            else -> throw IllegalArgumentException("Ungültige Aktion")
        }
    }

    open fun aktionGegner1() {
        println("$name führt Aktion 1 aus.")
    }

    open fun aktionGegner2() {
        println("$name führt Aktion 2 aus.")
    }

    open fun aktionGegner3() {
        println("$name führt Aktion 3 aus.")
    }

    open fun aktionGegner4() {
        println("$name führt Aktion 4 aus.")
    }

    open fun isEmpty(): Boolean {
        return hp <= 0
    }

    open fun helfer(nameList: String, count: Int): List<Gegner> {
        val helferNamen = listOf("Goblin", "Zwerg", "Ork", "Kobold")

        val helferListe = mutableListOf<Gegner>()

        // Hier werden 'count' Helfer mit zufälligen Namen aus der Liste und jeweils 50 HP erstellt und zur Liste hinzugefügt
        repeat(count) {
            val zufälligerName = helferNamen.random()
            helferListe.add(Gegner(zufälligerName, 50))
        }

        return helferListe
    }


    open fun rufeVerstärkung(round: Int, gegnerListe: MutableList<Gegner>) {
        if (round == 2) {
            // Füge eine Liste von neuen Helfern (Verstärkung) hinzu
            gegnerListe.addAll(helfer("Verstärkung1", 4))
            println("$name hat Verstärkung gerufen!")
        }
    }
}