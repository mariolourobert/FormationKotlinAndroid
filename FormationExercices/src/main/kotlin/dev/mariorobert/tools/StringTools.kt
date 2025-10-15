package dev.mariorobert.tools

fun String.containsAnyOf(chars: List<Char>): Boolean =
    this.any { it in chars }
