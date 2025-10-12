package dev.mariorobert.module1

import dev.mariorobert.tools.nextNullableString
import kotlin.random.Random

// Step 1 : Écrire une fonction qui prend originalString et print si possible le 5e caractère
// ou qui sinon print "Y a pas !". Dans tous les cas, il faut print originalString.

// Step 2 : Utiliser la fonction repeat(N) {} pour vérifier que votre solution fonctionne.
// Vous pouvez ajouter println("============") pour clarifier les logs

// Step 3 : On veut print "Trop court !" si originalString est trop courte pour l'algo,
// mais toujours print "Y a pas !" si originalString est null
fun main(args: Array<String>) {
    val originalString = Random.nextNullableString()
    println(originalString)
}
