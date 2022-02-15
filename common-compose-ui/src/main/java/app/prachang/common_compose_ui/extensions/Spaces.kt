package app.prachang.common_compose_ui.extensions

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * The composable Height() takes [height] as parameter.
 *
 * The height is in Dp and adds vertical spacer between composable */
@Composable
fun Height(
    height: Dp
) {
    Spacer(modifier = Modifier.height(height = height))
}

@Deprecated(
    "This composable is deprecated instead use height in Dp.", ReplaceWith(
        "Height(height = height.dp)",
        "androidx.compose.ui.unit.dp"
    )
)
@Composable
fun Height(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

@Composable
fun Width(width: Int) {
    Spacer(modifier = Modifier.width(width.dp))
}