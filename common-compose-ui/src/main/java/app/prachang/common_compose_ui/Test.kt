package app.prachang.common_compose_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@Composable
fun Test() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        text = "Prachan"
    )
}