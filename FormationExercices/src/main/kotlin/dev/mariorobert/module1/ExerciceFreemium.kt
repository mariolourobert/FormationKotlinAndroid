package dev.mariorobert.module1

/**
 * Step 1 :
 * Créez une enum UserType avec les valeurs PREMIUM et FREE
 * Créez une data class User avec un champ name (String) et champ type (UserType)
 *
 * Step 2 :
 * Reprenez votre MessageValidator de l'Exercice3.
 * Modifiez la fonction isMessageValid pour qu'elle prenne également en paramètre un User optionnel.
 * Si on est sûr que l'utilisateur est de type PREMIUM, on applique les règles non strictes.
 */
fun main(args: Array<String>) {

}

private val forbiddenChars = listOf('@', '#', '$', '%', '^', '&', '*')
