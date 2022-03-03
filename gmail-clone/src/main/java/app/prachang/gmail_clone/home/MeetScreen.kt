package app.prachang.gmail_clone.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.prachang.common_compose_ui.components.CircleImage
import app.prachang.common_compose_ui.components.ProgressScreen
import app.prachang.dummy_data.instagram.kotlinIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeetScreen() {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text(text = "Meet") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    }
                },
                actions = {
                    CircleImage(
                        url = kotlinIcon,
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .size(30.dp),
                    )
                },
            )
        },
    ) {
        ProgressScreen()
    }
}