package app.prachang.instagram_clone.profilescreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Float?.convertToDp(): Dp {
    return with(LocalDensity.current) {
        this@convertToDp?.toDp() ?: 0.dp
    }
}