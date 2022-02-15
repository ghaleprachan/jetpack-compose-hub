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
    "This composable is deprecated instead use height in Dp.",
    ReplaceWith(
        "Height(height = height.dp)",
        "androidx.compose.ui.unit.dp"
    )
)
@Composable
fun Height(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

/**
 * The composable Width() takes [width] as parameter.
 *
 * The width is in Dp and adds horizontal spacer between composable */
@Composable
fun Width(width: Dp) {
    Spacer(modifier = Modifier.width(width = width))
}

@Deprecated(
    "This composable is deprecated instead use width in Dp.",
    ReplaceWith(
        "Width(width = width.dp)",
        "androidx.compose.ui.unit.dp"
    )
)
@Composable
fun Width(width: Int) {
    Spacer(modifier = Modifier.width(width.dp))
}