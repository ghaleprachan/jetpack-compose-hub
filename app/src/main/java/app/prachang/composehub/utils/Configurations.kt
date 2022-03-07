package app.prachang.composehub.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun getWidth(percentage: Double = 1.0): Dp {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    return (width * percentage).dp
}
