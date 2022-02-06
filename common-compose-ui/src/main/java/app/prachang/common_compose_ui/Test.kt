package app.prachang.common_compose_ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TestOne() {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        content = {

        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun TestUI() {
    Layout(
        content = {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Prachan",
            )
        },
        measurePolicy = { s, e ->
            layout(200, 100) {

            }
        },
    )
}