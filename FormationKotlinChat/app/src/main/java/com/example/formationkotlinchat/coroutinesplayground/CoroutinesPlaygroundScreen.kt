package com.example.formationkotlinchat.coroutinesplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun CoroutinesPlaygroundScreen() {
    val viewModel: CoroutinesPlaygroundScreenViewModel = koinViewModel()

    val messages = viewModel.uiState.collectAsStateWithLifecycle().value.messages

    val listState = rememberLazyListState()

    var autoScroll by remember { mutableStateOf(true) }

    LaunchedEffect(messages.size) {
        if (autoScroll && messages.isNotEmpty()) {
            listState.animateScrollToItem(index = messages.size - 1)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 8.dp),
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxWidth().weight(1f),
        ) {
            items(messages) {
                Row(modifier = Modifier.fillMaxSize().padding(top = 4.dp)) {
                    Text(text = it.time)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = it.content)
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = autoScroll,
                onCheckedChange = { autoScroll = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Auto-scroll", fontSize = 24.sp)
        }
    }
}
