package dev.mariorobert.formationkotlinchat.presentation.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen() {
    val viewModel = koinViewModel<SignUpScreenViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    PrivateSignUpScreen(
        uiState = uiState,
        onUsernameChange = viewModel::onUsernameChange,
        onCheckboxToggle = viewModel::onCheckboxToggle,
    )
}

@Composable
private fun PrivateSignUpScreen(
    uiState: SignUpScreenUiState,
    onUsernameChange: (String) -> Unit,
    onCheckboxToggle: (Boolean) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .weight(1f)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(0.5f),
                imageVector = Icons.Default.Send,
                contentDescription = "Logo",
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .weight(2f)
                .verticalScroll(rememberScrollState())
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Kotlin Chat",
                fontSize = 32.sp,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 14.dp),
                textAlign = TextAlign.Center,
            )
            OutlinedTextField(
                value = uiState.currentUsername,
                onValueChange = onUsernameChange,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 14.dp)
                    .padding(top = 16.dp),
                placeholder = { Text("Enter your username") },
                label = {
                    Text("Username")
                }
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(
                    checked = uiState.isCheckboxChecked,
                    onCheckedChange = onCheckboxToggle,
                )
                Text("I agree to the Terms and Conditions")
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { },
                ) {
                    Text("Cancel")
                }
                Button(
                    onClick = { },
                    enabled = uiState.isSignUpButtonEnabled,
                ) {
                    Text("Sign Up")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    PrivateSignUpScreen(
        uiState = SignUpScreenUiState(
            currentUsername = "Mario",
            isCheckboxChecked = true,
            isSignUpButtonEnabled = true,
        ),
        onUsernameChange = { },
        onCheckboxToggle = { },
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreviewEmpty() {
    PrivateSignUpScreen(
        uiState = SignUpScreenUiState(
            currentUsername = "",
            isCheckboxChecked = false,
            isSignUpButtonEnabled = false,
        ),
        onUsernameChange = { },
        onCheckboxToggle = { },
    )
}
