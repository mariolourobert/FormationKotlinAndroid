package dev.mariorobert.module1

import dev.mariorobert.tools.nextLocalDateTime
import dev.mariorobert.tools.nextMessage
import dev.mariorobert.tools.prettyFormat
import java.time.LocalDateTime
import kotlin.math.max
import kotlin.random.Random

val printingEnabled = true

/**
 * Le but est de get le user courant, puis de récupérer, traiter et afficher ses messages.
 * Vous avez à votre disposition les fonctions `getCurrentUser`, `getMessages` et `displayMessage`.
 *
 * Step 1 :
 *  - Récupérer l'utilisateur courant s'il y en a 1
 *  - Récupérer ses messages
 *  - Filtrer les messages pour ne garder que ceux après le 8/11/2010 (le 1e commit sur le repo Kotlin !)
 *  - Trier les messages par date de création décroissante
 *  - Si l'option printingEnabled est à true, afficher les messages
 * Veuillez à ajouter des print de debug à chaque étape !
 *
 * Step 2 :
 * Essayez de faire tout ça sans créer une seule variable !
 */
fun main(args: Array<String>) {

}

data class User(val id: Long, val name: String)

data class Message(val createdAt: LocalDateTime, val content: String)

fun displayMessage(message: Message) {
    val header = "At ${message.createdAt.prettyFormat()}"
    val maxLength = max(header.length, message.content.length)
    println("=".repeat(maxLength + 4))
    val headerAdditionalSpacings = " ".repeat((maxLength - header.length).coerceAtLeast(0))
    println("= $header$headerAdditionalSpacings =")
    val messageAdditionalSpacings = " ".repeat((maxLength - message.content.length).coerceAtLeast(0))
    println("= ${message.content}$messageAdditionalSpacings =")
    println("=".repeat(maxLength + 4) + "\n")
}

fun getMessages(userId: Long): List<Message> = List(Random.nextInt(20, 50)) {
    Message(
        createdAt = Random.nextLocalDateTime(),
        content = List(Random.nextInt(1, 4)) { Random.nextMessage() }.joinToString(" "),
    )
}

fun getCurrentUser(): User? {
    val randomUser = User(
        id = Random.nextLong(1000, 3000),
        name = listOf("Alice", "Bob", "Charlie", "Diana", "Eve").random(),
    )

    return listOf(randomUser, randomUser, randomUser, null).random()
}
