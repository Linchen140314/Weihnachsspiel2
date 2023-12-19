class Grinchil(name: String, hp: Int) : Gegner(name, hp) {

    private var specialAbilityUsed = false

    // Funktion für die Ausführung der speziellen Aktion des Trolls
    fun spezielleAktion(held: Held) {
        if (!specialAbilityUsed) {
            println("$name führt die spezielle Aktion aus!")
            val schaden = 30 // Annahme: Schaden für die spezielle Aktion
            held.hp -= schaden
            specialAbilityUsed = true
        } else {
            println("$name kann die spezielle Aktion nicht erneut ausführen.")
        }
    }


    // Überschreibe die Funktion für die zufällige Aktion
    fun führeZufälligeAktionAus(helden: MutableList<Held>) {
        val randomIndex: Int = (0 until 4).random()
        val target = helden[randomIndex]
        spezielleAktion(target)
    }

    // Überschreibe die Funktion zur Überprüfung, ob der Grinchi-Gegner keine HP mehr hat
    override fun isEmpty(): Boolean {
        return hp <= 0
    }
}