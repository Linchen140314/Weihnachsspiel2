import java.io.File
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip

// Hier kannst du die Helden auswählen
val weihnachtswichtel = Weihnachtswichtel("Weihnachtswichtel", 550)

val elfe = Elfe ("Elfe", 400)

val schneemann = Schneemann("Schneemann",350)

val lebkuchenmann = Lebkuchenmann("Lebkuchenmann", 550)

val rudolf = Rudolf("Rudolf", 350)

val red = "\u001B[31m"
val green = "\u001B[32m"
val yellow = "\u001B[33m"
val blue = "\u001B[34m"
val magenta = "\u001B[35m"
val cyan = "\u001B[36m"
val reset = "\u001B[0m"
val bold = "\u001B[1m"
val underline = "\u001B[4m"

/*fun playSound(intro: String) {
    // Erstelle eine Datei aus dem angegebenen Dateipfad
    val audioPath = "src/main/kotlin/BASEMENT STORAGE.wav"
    val audio: File = File(audioPath)                                                 // Audio Code aus Vorlesung

    // Hier wird die Audio in das Audiosystem gepackt
    val audioInput: AudioInputStream = AudioSystem.getAudioInputStream(audio)

    // Es wird ein Clip-Objekt erstellt, um den Sound abzuspielen
    val clip: Clip = AudioSystem.getClip()

    // Clip öffnen, Audio laden
    clip.open(audioInput)

    // Starte die Wiedergabe des Sounds
    clip.start()
}*/

fun main() {
    //Intro-Musik abgespielt
    val intro: String = "src/main/kotlin/BASEMENT STORAGE.wav"
    //playSound(intro)

    println("${yellow}")

    println(
        """
██╗    ██╗███████╗██╗██╗  ██╗███╗   ██╗ █████╗  ██████╗██╗  ██╗████████╗███████╗ ██████╗██╗  ██╗ █████╗  ██████╗ ███████╗
██║    ██║██╔════╝██║██║  ██║████╗  ██║██╔══██╗██╔════╝██║  ██║╚══██╔══╝██╔════╝██╔════╝██║  ██║██╔══██╗██╔═══██╗██╔════╝
██║ █╗ ██║█████╗  ██║███████║██╔██╗ ██║███████║██║     ███████║   ██║   ███████╗██║     ███████║███████║██║   ██║███████╗
██║███╗██║██╔══╝  ██║██╔══██║██║╚██╗██║██╔══██║██║     ██╔══██║   ██║   ╚════██║██║     ██╔══██║██╔══██║██║   ██║╚════██║
╚███╔███╔╝███████╗██║██║  ██║██║ ╚████║██║  ██║╚██████╗██║  ██║   ██║   ███████║╚██████╗██║  ██║██║  ██║╚██████╔╝███████║
 ╚══╝╚══╝ ╚══════╝╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝
                                                                                                                                                                                                                    
    """.trimIndent()
    )

    println("${reset}")

    // Hier werden die ausgewählten Helden in einer Liste gespeichert
    val alleHelden = listOf(weihnachtswichtel, elfe, schneemann, lebkuchenmann, rudolf)
    println()
    println("${blue}${bold}-------------------------------------------------------------")
    println              ("----------- Wähle drei Helden für deinen Kampf --------------")
    println              ("-------------------------------------------------------------${reset}")
    println()

    val ausgewählteHelden = mutableListOf<Held>()

    for (i in 1..3) {
        println("${magenta}${bold}${underline}Verfügbare Helden:${reset}")
        println()

        alleHelden.forEachIndexed { index, held ->
            println("${index + 1}. ${held.name}")
        }
        println()

        print("${magenta}${bold}${underline}Wähle Helden $i: ${reset}")
        println()
        val ausgewählteNummer = readLine()?.toIntOrNull()

        if (ausgewählteNummer != null && ausgewählteNummer in 1..alleHelden.size) {
            val ausgewählterHeld = alleHelden[ausgewählteNummer - 1]
            ausgewählteHelden.add(ausgewählterHeld)
        } else {
            println("Ungültige Eingabe. Bitte wähle erneut.")
        }
    }
    println()
    val gegner1: Gegner = Grinchil("Troll", 350)
    val gegner2: Gegner = Troll("Troll", 350,)

    if (gegner1.isEmpty() && gegner2.isEmpty()) {
        // Hier musst du eine Liste von Strings für die ep-Parameter übergeben, um den ursprünglichen Konstruktor von Boss zu verwenden
        val endBoss = Boss("Endboss", 300)
        kämpfen(ausgewählteHelden, endBoss)
    } else {
        if (!gegner1.isEmpty()) {
            kämpfen(ausgewählteHelden, gegner1)
        }

        if (!gegner2.isEmpty()) {
            kämpfen(ausgewählteHelden, gegner2)
        }
    }

    val gegnerListe = mutableListOf<Gegner>()
    if (gegnerListe.all { it.isEmpty() }) {
        val gegner = beschwöreBoss()
        val heldenListe = ausgewählteHelden
        heldenListe?.let { kämpfeGegenBoss(gegner, it) }
    } else {
        println("Nicht alle Gegner wurden besiegt. Das Spiel endet.")
    }
    weihnachtswichtel.turn(gegner1, weihnachtswichtel)
    elfe.turn(gegner1, elfe)
    schneemann.turn(gegner1, schneemann)
    lebkuchenmann.turn(gegner1, lebkuchenmann)
    rudolf.turn(gegner1, rudolf)
}


private fun <Grinchi> Grinchi.isEmpty() {

}

fun beschwöreBoss(): Boss {
    val bossAktionen = listOf("Feueratem", "Frostnova", "Blitzschlag", "Schleifen Peitsche")

    val boss = Boss("Weihnachtsmann", 150)
    println()
    println("${blue}${bold}-------------------------------------------------------------")
    println("---------- Der Boss ${boss.name} wurde beschworen! --------")
    println("-------------------------------------------------------------${reset}")
    println()
    return boss
}

fun kämpfeGegenBoss(boss: Boss, heldenListe: List<Held>) {
    for (runde in 1..4) {
        println("Runde $runde:")
        boss.bossKampfzug(heldenListe)
        if (heldenListe.all { it.hp > 0 }) {
            for (held in heldenListe) {
                held.alleAktionen()
            }
        } else {
            println("Ein oder mehrere Helden wurden besiegt. Das Spiel endet.")
            break
        }
    }
    println()
    if (boss.isEmpty()) {
        println("Der Boss ${boss.name} wurde besiegt!")
    } else {
        println()
        println("Der Boss ${boss.name} hat überlebt. Das Spiel endet.")
    }
}

fun gameOver(heldengruppe: List<Held>, lebendeGegner: List<Gegner>): Boolean {
    return heldengruppe.all { it.isEmptyWorries() } || lebendeGegner.isEmpty()
}

fun kämpfen(heldengruppe: List<Held>, gegner: Any) {
    println("${blue}${bold}-------------------------------------------------------------")
    println("------------- Der Kampf gegen ${gegner} beginnt! --------------")
    println("-------------------------------------------------------------${reset}")

    val beutel = Beutel()
    beutel.fülleBeutel()

    for (runde in 1..4) {
        println()
        println("Runde $runde:")
        println()
        for (held in heldengruppe) {
            println()
            println("${magenta}${bold}${underline}${held.name} ist am Zug:${reset}")
            println()
            println("${cyan}${bold}${underline}Verfügbare Aktionen:${reset}")


            held.alleAktionen.forEachIndexed { index, action ->
                println("${index + 1}. Aktion ${index + 1}")
            }
            println()
            print("${cyan}${bold}Wähle Aktion: ${reset}")
            println()

            val ausgewählteAktion = readln().toInt()

            if (ausgewählteAktion in 1..held.alleAktionen.size) {
                when (ausgewählteAktion) {
                    4 -> {
                        beutel.heiltrankNutzen(held)
                        held.useBeutel(beutel)
                    }

                    5 -> {
                        beutel.boosterNutzen(held)
                        held.useBeutel(beutel)
                    }

                }
                // Hier sollte geprüft werden, ob der `gegner` ein Boss ist, um dessen spezielle Aktionen auszuführen
                (gegner as? Boss)?.bossKampfzug(heldengruppe)
            } else {
                println("Ungültige Eingabe. Standardaktion wird ausgeführt.")
            }
        }

        println()

        println("${cyan}${bold}${underline}---------- Aktueller Zustand ----------${reset}")
        println()

        heldengruppe.forEach { held ->
            println("${bold}${held.name}: ${held.hp} HP${reset}")
        }
        //  Zustand des `gegner` ausgegeben
        println("${bold}${gegner}: ${gegner} HP${reset}")
    }

    println()

    println("Spiel beendet!")

    println()
}