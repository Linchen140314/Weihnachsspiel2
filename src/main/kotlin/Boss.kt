

import Gegner
import Held
import bold
import cyan
import red
import reset
import underline

// Klasse für den Boss-Gegner, erbt von Gegner
class Boss(name: String, hp: Int) : Gegner(name, hp) {

    // Überschreibe die Funktion für Flächenschaden an der Heldengruppe
    override fun flächenSchaden(heldengruppe: List<Held>, minSchaden: Int, maxSchaden: Int) {
        // Flächenschaden
        val randomSchaden: Int = (minSchaden..maxSchaden).random()

        for (held in heldengruppe) {
            held.hp -= randomSchaden
        }
    }

    // Überschreibe die Funktion für die Ausführung der ersten spezifischen Aktion des Bosses
    override fun aktionGegner1() {
        println("$name führt die Christbaumkugel Explosion aus.")
    }

    // Überschreibe die Funktion für die Ausführung der zweiten spezifischen Aktion des Bosses
    override fun aktionGegner2() {
        println("$name benutzt die Weihnachtsschleifen Peitsche.")
    }

    // Überschreibe die Funktion zur Überprüfung, ob der Boss-Gegner keine HP mehr hat
    override fun isEmpty(): Boolean {
        return hp <= 0
    }

    // Funktion für den Kampfzug des Bosses
    open fun bossKampfzug(heldengruppe: List<Held>) {
        println("${red}${bold}${underline}$name ist am Zug:${reset}")
        println()
        println("${cyan}${bold}${underline}Verfügbare Aktionen:${reset}")

        // Hier können Sie die Aktionen für den Boss definieren
        val bossAktionen = listOf("Schleifen Peitsche", "Feuerschlag", "Erderschütterung", "Blitzkaskade")

        // Zufällige Auswahl einer Aktion
        val ausgewählteAktion = bossAktionen.random()

        // Implementiere hier die Logik für die ausgewählte Aktion
        when (ausgewählteAktion) {
            "Schleifen Peitsche" -> aktionGegner2()
            "Feuerschlag" -> aktionGegner1()
            // Hier weitere Aktionen hinzufügen...
            else -> println("$name führt eine Standardaktion aus.")
        }

        // Füge hier den restlichen Code für den Boss-Kampfzug hinzu

        println()
    }
}
