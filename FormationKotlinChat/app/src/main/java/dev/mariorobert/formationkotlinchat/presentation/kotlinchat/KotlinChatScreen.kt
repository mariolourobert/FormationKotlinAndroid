package dev.mariorobert.formationkotlinchat.presentation.kotlinchat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun KotlinChatScreen(
    viewModel: KotlinChatScreenViewModel = viewModel(),
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        uiState.messages.forEach {
            Text(
                modifier = Modifier
                    .padding(all = 8.dp),
                text = it,
            )
        }
    }
}
