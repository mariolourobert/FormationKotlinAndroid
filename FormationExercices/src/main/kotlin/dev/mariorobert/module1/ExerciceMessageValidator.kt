package dev.mariorobert.module1

/**
 * Écrivez une classe MessageValidator prenant en paramètre un booléen strictMode.
 * Cette classe doit contenir une fonction isMessageValid prenant en paramètre une String message
 * et retournant un booléen.
 * - Si strictMode est false, isMessageValid doit retourner true si message contient moins de 100 caractères.
 * - Si strictMode est true, isMessageValid doit retourner true si message contient moins de 100 caractères
 *   et ne contient aucun des caractères contenus dans la liste forbiddenChars.
 * N'hésitez pas à découper votre code pour qu'il soit lisible et non redondant.
 *
 * Vous pouvez utiliser la fonction Random.nextString pour générer un message aléatoire de longueur donnée.
 * Vous pouvez utiliser la fonction containsAnyOf (sur une String) pour vérifier si un message contient
 * un des caractères d'une liste.
 */
fun main(args: Array<String>) {

}

private val forbiddenChars = listOf('@', '#', '$', '%', '^', '&', '*')
