package dev.mariorobert.tools

import kotlin.random.Random

fun Random.nextMessage(): String =
    listOf(
        "Hello there!",
        "How are you doing today?",
        "Did you know that Kotlin is a great programming language?",
        "Random messages are fun()!",
        "Take a coffee and code on!",
        "Keep It Simple Stupid.",
        "You Are Not Gonna Need It.",
        "Don't Repeat Yourself.",
        "There are only two hard things in Computer Science: cache invalidation and naming things.",
        "There's two hard problems in computer science: we only have one joke and it's not funny."
    ).random()
