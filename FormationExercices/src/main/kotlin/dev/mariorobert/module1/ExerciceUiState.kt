package dev.mariorobert.module1

/**
 * Step 1 :
 * Créez une sealed class UiState.
 * - À l’ouverture de l’écran, on va afficher un Loader le temps de demander les messages au serveur.
 * - Si le serveur répond avec une erreur, on affichera un message d’erreur générique (toujours le même).
 * - Si le serveur répond avec un succès, on affichera les messages.
 *
 *
 * Step 2 :
 * Utilisez cette classe dans la fonction main.
 * Utilisez la fonction getMessages() pour simuler l’appel au serveur.
 * Utilisez la fonction refreshUi() pour simuler le rafraîchissement de l’UI.
 *
 * Step 3 :
 * La classe de Success ne contient pas de fonctionnel... Cela vous rappelle quelque chose ?
 *
 * Step 4 :
 * Ajoutez un état supplémentaire à UiState pour gérer le cas où la liste de messages est
 * vide. Dans ce cas, on affichera un message "Aucun message disponible".
 *
 */
fun main(args: Array<String>) {

}

class UiState


fun refreshUi(uiState: UiState) {}
fun getMessages(): List<String>? = listOf("Hello", "Bonjour", "Hola")
