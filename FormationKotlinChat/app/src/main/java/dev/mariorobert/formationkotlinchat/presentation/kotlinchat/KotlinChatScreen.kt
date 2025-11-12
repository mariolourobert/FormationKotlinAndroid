package dev.mariorobert.formationkotlinchat.presentation.kotlinchat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.mariorobert.formationkotlinchat.presentation.tools.collectWithLifecycle
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
data class KotlinChatScreenRoute(val username: String)

@Composable
fun KotlinChatScreen(
    username: String,
) {
    val viewModel = koinViewModel<KotlinChatScreenViewModel>()
    val lazyListState = rememberLazyListState()

    LaunchedEffect(Unit) {
        viewModel.init(username = username)
    }

    viewModel.events.collectWithLifecycle { event ->
        when (event) {
            is KotlinChatScreenViewModel.Events.ScrollDown -> {
                lazyListState.animateScrollToItem(0)
            }
        }
    }

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .weight(1f),
            state = lazyListState,
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
        NewMessageBar(
            currentNewMessage = uiState.currentNewMessage,
            isSendButtonEnabled = uiState.isSendButtonEnabled,
            onNewMessageChange = viewModel::onNewMessageChange,
            onSendButtonClick = viewModel::onSendButtonClick,
            modifier = Modifier.fillMaxWidth(),
        )
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

@Composable
private fun NewMessageBar(
    currentNewMessage: String,
    isSendButtonEnabled: Boolean,
    onNewMessageChange: (String) -> Unit,
    onSendButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OutlinedTextField(
            modifier = Modifier
                .weight(1f),
            value = currentNewMessage,
            onValueChange = onNewMessageChange,
            placeholder = {
                Text(text = "Message")
            },
            maxLines = 4,
        )

        val sendButtonBackgroundColor =
            if (isSendButtonEnabled) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface
            }
        Box(
            modifier = Modifier
                .padding(start = 8.dp)
                .background(
                    color = sendButtonBackgroundColor,
                    shape = CircleShape,
                )
                .padding(all = 8.dp)
                .clickable(
                    enabled = isSendButtonEnabled,
                    onClick = onSendButtonClick,
                )
                .clip(CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Send message",
                tint = MaterialTheme.colorScheme.background,
            )
        }
    }
}
