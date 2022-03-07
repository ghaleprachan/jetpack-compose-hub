package app.prachang.composehub.screens.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import app.prachang.common_compose_ui.components.ComposeImage
import app.prachang.composehub.utils.getWidth
import app.prachang.dummy_data.instagram.pagerImages
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun HomeTopContent() {
    val pagerState = rememberPagerState()

    val screenWidth = getWidth()
    val screenWidthOverflow = getWidth(percentage = 0.85)
    val screenWidthHalf = getWidth(percentage = 0.50)

    LaunchedEffect(key1 = true, block = {
        pagerState.scrollToPage(1)
    })

    HorizontalPager(
        count = pagerImages.size,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 50.dp),
    ) { page ->
        Card(
            modifier = Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                    lerp(
                        start = screenWidthOverflow,
                        stop = screenWidth,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = (scale / screenWidth)
                        scaleY = (scale / screenWidth)
                    }
                    alpha = lerp(
                        start = screenWidthHalf,
                        stop = screenWidth,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ) / screenWidth
                }
                .height(180.dp),
            elevation = 8.dp,
        ) {
            ComposeImage(
                url = pagerImages[page],
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}