// Beutel-Klasse, die Gegenstände wie Heiltränke und Booster enthält
open class Beutel {

    // Anzahl der Heiltränke im Beutel
    var anzahlHeiltränke: Int = 3

    // Anzahl der Booster im Beutel
    var anzahlBooster: Int = 2

    // Funktion zum Befüllen des Beutels (kann weiter angepasst werden)
    fun fülleBeutel() {
        // Diese Funktion stellt einfach die Standardwerte für Heiltränke und Booster wieder her.
        anzahlHeiltränke = 3
        anzahlBooster = 2
    }

    // Methode zum Nutzen eines Heiltranks durch einen Held
    fun heiltrankNutzen(user: Held) {
        if (anzahlHeiltränke > 0) {
            println("${user.name} hat ${user.hp} HP und heilt sich mit dem Trank...")

            // Heilung des Helden (Hier wird die HP verdoppelt)
            user.hp *= 2

            // Verbrauchten Heiltrank entfernen
            anzahlHeiltränke--

            println("${user.name} hat sich geheilt und hat jetzt ${user.hp} HP!")
        } else {
            // Wenn keine Heiltränke mehr vorhanden sind, wird eine Nachricht ausgegeben und der Held kann erneut auswählen.
            println("Es sind keine Heiltränke mehr übrig!")
            println("Wähle erneut!")
            user.useBeutel(this) // Die Funktion useBeutel wird aufgerufen, um dem Benutzer die Möglichkeit zu geben, erneut auszuwählen.
        }
    }

    // Methode zum Nutzen eines Boosters durch einen Held
    fun boosterNutzen(user: Held) {
        if (anzahlBooster > 0) {
            println("${user.name} hat ${user.ap} AP und benutzt einen Booster...")

            // Stärkung des Helden (Hier wird die AP nicht verändert, da *= 1 dasselbe ist wie keine Veränderung)
            user.ap *= 1

            // Verbrauchten Booster entfernen
            anzahlBooster--

            println("${user.name} hat sich gestärkt und hat jetzt ${user.ap} AP!")
        } else {
            // Wenn keine Booster mehr vorhanden sind, wird eine Nachricht ausgegeben und der Held kann erneut auswählen.
            println("Alle Booster wurden aufgebraucht!")
            println("Suche erneut aus!")
            user.useBeutel(this) // Die Funktion useBeutel wird aufgerufen, um dem Benutzer die Möglichkeit zu geben, erneut auszuwählen.
        }
    }
}