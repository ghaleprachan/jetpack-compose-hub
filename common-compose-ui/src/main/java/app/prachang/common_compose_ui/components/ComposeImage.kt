package app.prachang.common_compose_ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import app.prachang.common_compose_ui.R
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import coil.transform.CircleCropTransformation
import coil.transform.Transformation

@Composable
private fun getImagePainter(
    url: String?,
    @DrawableRes loadingResId: Int,
    @DrawableRes errorResId: Int,
    transformation: Transformation? = null
): Painter {
    return rememberImagePainter(data = url) {
        size(OriginalSize)
        placeholder(loadingResId)
        error(errorResId)
        crossfade(true)
        crossfade(300)
        transformation?.let {
            transformations(it)
        }
    }
}

/**
 * Jetpack compose reusable-image using coil library
 * This may change in future based on work conditions
 * */
@Composable
fun ComposeImage(
    modifier: Modifier = Modifier,
    url: String?,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    @DrawableRes loadingResId: Int = R.drawable.anim_loading,
    @DrawableRes errorResId: Int = R.drawable.ic_error_image,
) {
    val painter = getImagePainter(
        url = url,
        loadingResId = loadingResId,
        errorResId = errorResId,
    )
    Image(
        modifier = modifier.background(Color.LightGray),
        painter = painter,
        contentDescription = contentDescription,
        contentScale = contentScale,
    )
}

@Composable
fun CircleImage(
    modifier: Modifier = Modifier,
    url: String?,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    @DrawableRes loadingResId: Int = R.drawable.anim_loading,
    @DrawableRes errorResId: Int = R.drawable.ic_error_image,
) {
    val painter = getImagePainter(
        url = url,
        loadingResId = loadingResId,
        errorResId = errorResId,
        transformation = CircleCropTransformation()
    )
    Image(
        modifier = modifier
            .clip(shape = CircleShape)
            .background(Color.LightGray),
        painter = painter,
        contentDescription = contentDescription,
        contentScale = contentScale,
    )
}