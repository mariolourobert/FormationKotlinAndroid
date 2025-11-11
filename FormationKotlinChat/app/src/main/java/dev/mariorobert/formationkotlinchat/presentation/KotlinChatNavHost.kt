package dev.mariorobert.formationkotlinchat.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dev.mariorobert.formationkotlinchat.presentation.kotlinchat.KotlinChatScreen
import dev.mariorobert.formationkotlinchat.presentation.kotlinchat.KotlinChatScreenRoute
import dev.mariorobert.formationkotlinchat.presentation.signup.SignUpScreen
import dev.mariorobert.formationkotlinchat.presentation.signup.SignUpScreenRoute

@Composable
fun KotlinChatNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SignUpScreenRoute,
    ) {
        composable<SignUpScreenRoute> { SignUpScreen(navController) }

        composable<KotlinChatScreenRoute> {
            val arg: KotlinChatScreenRoute = it.toRoute()
            KotlinChatScreen(username = arg.username)
        }
    }
}
