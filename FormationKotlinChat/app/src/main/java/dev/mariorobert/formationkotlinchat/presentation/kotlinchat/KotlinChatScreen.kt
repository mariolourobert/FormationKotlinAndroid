package dev.mariorobert.formationkotlinchat.presentation.kotlinchat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun KotlinChatScreen(
    viewModel: KotlinChatScreenViewModel = koinViewModel(),
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        reverseLayout = true,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(
            items = uiState.messages,
            key = { it.id },
        ) {
            Message(messageUiState = it)
        }
    }
}

@Composable
private fun Message(
    messageUiState: KotlinChatScreenUiState.MessageUiState,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = messageUiState.authorName,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = messageUiState.formattedCreatedAt,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = messageUiState.content,
            fontSize = 18.sp,
        )
    }
}
