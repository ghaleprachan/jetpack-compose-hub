@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package app.prachang.gmail_clone.home

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import app.prachang.common_compose_ui.components.ProgressScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeetScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Meet") },
            )
        },
    ) {
        ProgressScreen()
    }
}