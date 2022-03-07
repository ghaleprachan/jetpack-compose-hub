package app.prachang.material3.textbuttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.prachang.material3.Material3Screen
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun ClickableScreen3(navController: NavController) {
    Material3Screen(
        title = "Text & Buttons",
        navController = navController,
    ) {
        ClickableScreen()
    }
}

@Composable
private fun ClickableScreen() {
    FlowRow(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE7F0F8))
            .padding(16.dp),
        mainAxisSpacing = 16.dp,
        crossAxisSpacing = 16.dp
    ) {
        TextButton(onClick = { }) {
            Text(text = "Clickable Text", color = Color.Black)
        }

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White,
            ),
        ) {
            Text(text = "Button")
        }

        OutlinedButton(
            onClick = { },
            border = BorderStroke(
                width = 1.dp,
                color = Color.Blue,
            ),
        ) {
            Text(text = "Outlined Button", color = Color.Black)
        }

        Text(text = "Random Normal Text")
    }
}
