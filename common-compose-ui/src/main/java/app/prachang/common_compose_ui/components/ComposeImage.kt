package app.prachang.common_compose_ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.prachang.common_compose_ui.R
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
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
): ImagePainter {
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
@OptIn(ExperimentalCoilApi::class)
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
    Box {
        Image(
            modifier = modifier.background(Color.LightGray),
            painter = painter,
            contentDescription = contentDescription,
            contentScale = contentScale,
        )

        /*
        make instagram like loading and do in following way todo(ghaleprachan)
        when (painter.state) {
            is ImagePainter.State.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Yellow,
                )
            }
            is ImagePainter.State.Error -> {
            }
            else -> {}
        }*/
    }
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