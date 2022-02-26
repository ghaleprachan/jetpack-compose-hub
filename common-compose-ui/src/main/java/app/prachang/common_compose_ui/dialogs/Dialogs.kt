package app.prachang.common_compose_ui.dialogs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ShowDialog(showDialog: MutableState<Boolean>) {
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = !showDialog.value
            },
            text = {
                Text(
                    text = "Sorry, Screen you are trying to look is unavailable!",
                    textAlign = TextAlign.Center
                )
            },
            title = {
                Text(text = "Progress")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Work,
                    contentDescription = null,
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    showDialog.value = !showDialog.value
                }) {
                    Text(text = "Ok")
                }
            },
        )
    }
}