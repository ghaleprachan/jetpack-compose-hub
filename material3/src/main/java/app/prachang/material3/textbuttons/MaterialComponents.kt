@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.material3.textbuttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.prachang.material3.Material3Screen
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
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

        ElevatedButton(onClick = { }) {
            Text(text = "Elevated Button")
        }

        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "Filled Tonal Button")
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


        val interactionSource = remember {
            MutableInteractionSource()
        }
        val clickable = Modifier.clickable(
            interactionSource = interactionSource,
            indication = LocalIndication.current,
            onClick = {

            },
        )
        // val isPressed by interactionSource.collectIsPressedAsState()
        Card(
            elevation = CardDefaults.cardElevation(
                pressedElevation = 22.dp,
                defaultElevation = 6.dp,
                draggedElevation = 22.dp,
            ),
            interactionSource = interactionSource,
        ) {
            Text(
                text = "Content Inside Card",
                modifier = Modifier
                    .then(clickable)
                    .padding(16.dp),
            )
        }
        OutlinedCard {
            Text(
                text = "Outlined Card",
                modifier = Modifier
                    .then(clickable)
                    .padding(16.dp),
            )
        }
        ElevatedCard {
            Text(
                text = "Elevated Card",
                modifier = Modifier
                    .then(clickable)
                    .padding(16.dp),
            )
        }

        FloatingActionButton(onClick = { }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
        ExtendedFloatingActionButton(
            onClick = { },
            icon = {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            },
            text = {
                Text(text = "Compose")
            },
        )
        LargeFloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
        SmallFloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }
}
