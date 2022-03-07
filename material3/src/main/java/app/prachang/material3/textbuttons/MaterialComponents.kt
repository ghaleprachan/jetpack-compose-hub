package app.prachang.material3.textbuttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.prachang.material3.Material3Screen
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import kotlinx.coroutines.delay


@Composable
fun MaterialComponents3(navController: NavController) {
    Material3Screen(
        title = "Text & Buttons",
        navController = navController,
    ) {
        MaterialComponents()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MaterialComponents() {
    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress, animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = progress, block = {
        delay(1000)
        if (progress < 1f) progress += 0.1f
    })

    FlowRow(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE7F0F8))
            .padding(16.dp),
        mainAxisSpacing = 24.dp,
        crossAxisSpacing = 24.dp,
        crossAxisAlignment = FlowCrossAxisAlignment.Center
    ) {
        TextButton(onClick = { }) {
            Text(text = "Clickable Text")
        }

        OutlinedButton(
            onClick = {

            },
        ) {
            Text(text = "Outlined Button")
        }

        Button(
            onClick = { },
        ) {
            Text(text = "Button")
        }

        Text(text = "Random Normal Text")

        CircularProgressIndicator()

        LinearProgressIndicator(progress = animatedProgress)

        Button(onClick = {
            showDialog = !showDialog
        }) {
            Text(text = "Material3 Dialog")
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = !showDialog },
                text = {
                    Text(text = "This is material 3 dialog!")
                },
                title = {
                    Text(text = "Material3 Title")
                },
                confirmButton = {
                    TextButton(onClick = {
                        showDialog = false
                    }) {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        showDialog = false
                    }) {
                        Text(text = "Cancel")
                    }
                },
            )
        }


        Card(
            elevation = CardDefaults.cardElevation(
                pressedElevation = 16.dp, defaultElevation = 8.dp,
                draggedElevation = 16.dp,
            ),
            shape = RoundedCornerShape(12.dp),
        ) {
            Text(
                text = "Content Inside Card",
                modifier = Modifier
                    .clickable { }
                    .padding(16.dp),
            )
        }
    }
}
