package dev.mariorobert.module1

import dev.mariorobert.tools.nextString
import kotlin.random.Random

/**
 * Step 1 :
 * Écrivez une fonction qui print "Uppercase!!" si originalString commence par une majuscule.
 * Sinon printez "Lowercase!!"
 * Les fonctions .first() sur une string et .isUpperCase() sur un char peuvent être utiles
 *
 * Step 2 :
 * Laissez l'analyse dans la nouvelle fonction mais printez dans la fonction main.
 */
fun main(args: Array<String>) {
    val originalString = Random.nextString()

    println(originalString)
}
