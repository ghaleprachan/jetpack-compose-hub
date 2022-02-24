package app.prachang.common_compose_ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import app.prachang.common_compose_ui.R
import coil.compose.rememberImagePainter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import coil.size.OriginalSize

@Composable
fun ComposeImage(
    modifier: Modifier = Modifier,
    url: String?,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop
) {
    val painter = rememberImagePainter(data = url) {
        size(OriginalSize)
        placeholder(R.drawable.anim_loading)
        error(R.drawable.ic_error_image)
    }
    Image(
        modifier = modifier.background(Color.LightGray),
        painter = painter,
        contentDescription = contentDescription,
        contentScale = contentScale,
    )
}