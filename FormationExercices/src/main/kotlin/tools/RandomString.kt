package dev.mariorobert.tools

import kotlin.random.Random

private val lowerCaseAlphabet: List<Char> = ('a'..'z').toList()
private val upperCaseAlphabet: List<Char> = ('A'..'Z').toList()
private val digits: List<Char> = ('1'..'9').toList()

fun Random.nextString(length: Int = nextInt(2, 20)): String {
    val alphabet = lowerCaseAlphabet + upperCaseAlphabet + digits

    return (1..length)
        .map { alphabet.random() }
        .joinToString("")
}