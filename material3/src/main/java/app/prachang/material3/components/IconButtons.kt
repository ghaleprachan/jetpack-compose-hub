package app.prachang.material3.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
internal fun NavigationIcon(
    onBack: () -> Unit = {}
) {
    IconButton(
        onClick = {
            onBack()
        },
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
    }
}