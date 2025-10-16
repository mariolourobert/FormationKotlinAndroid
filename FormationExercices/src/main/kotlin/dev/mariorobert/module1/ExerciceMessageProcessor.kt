package dev.mariorobert.module1

/**
 * Step 1 :
 * Reprenez votre MessageValidator de l'exercice précédent (Exercice3).
 * Séparez la logique de validation dans deux classes différentes, qui implémentent la même interface.
 *
 * Step 2 :
 * Créez une classe MessageProcessor qui prend en paramètre un booléen strictMode MUTABLE.
 * Cette classe doit contenir une fonction isMessageValid prenant en paramètre une String message
 * et retournant un booléen.
 * Cette fonction doit déléguer la validation à une de vos classes, selon la valeur de strictMode.
 * Vous devez pouvoir changer la valeur de strictMode à tout moment, sans recréer MessageProcessor.
 *
 * Step 3 :
 * Peut-on améliorer l'abstraction autour de MessageProcessor ?
 */
fun main(args: Array<String>) {

}

private val forbiddenChars = listOf('@', '#', '$', '%', '^', '&', '*')
