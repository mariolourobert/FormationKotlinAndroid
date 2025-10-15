package dev.mariorobert.module1

import dev.mariorobert.tools.nextString
import kotlin.random.Random

/**
 * Step 1 :
 * Écrire une fonction qui print "Uppercase!!" si originalString commence par une majuscule
 * Sinon écrire "Lowercase!!"
 *
 * Step 2 :
 * Laisser l'analayse dans la nouvelle fonction mais print dans la fonction main
 *
 * Les fonctions .first() sur une string et .isUpperCase() sur un char peuvent être utiles
 */
fun main(args: Array<String>) {
    val originalString = Random.nextString()

    println(originalString)
}
