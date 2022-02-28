package app.prachang.composehub.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import app.prachang.common_compose_ui.components.ComposeImage
import app.prachang.common_compose_ui.extensions.Width
import app.prachang.composehub.SampleAppData
import app.prachang.dummy_data.instagram.pagerImages
import app.prachang.theme.materialtheme.Typography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue


@Composable
internal fun DashboardScreen(
    onItemClick: (sample: SampleAppData.SampleApp) -> Unit
) {
    Scaffold(
        backgroundColor = Color(0xFFDFEDF3),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Compose Hub")
                },
            )
        },
        content = {
            LazyColumn(
                contentPadding = PaddingValues(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                content = {
                    item {
                        HomeTopContent()
                    }
                    itemsIndexed(SampleAppData.sampleApps) { _, sample ->
                        SampleItem(
                            sample = sample,
                            onItemClick = onItemClick,
                        )
                    }
                },
            )
        },
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun HomeTopContent() {
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

@Composable
fun getWidth(percentage: Double = 1.0): Dp {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    return (width * percentage).dp
}

@Composable
private fun SampleItem(
    sample: SampleAppData.SampleApp,
    onItemClick: (sample: SampleAppData.SampleApp) -> Unit = {},
) {
    val hasSubList = sample.subSamples.isNotEmpty()
    var expanded by remember {
        mutableStateOf(false)
    }
    val paddingHorizontal: Dp by animateDpAsState(targetValue = if (expanded) 0.dp else 22.dp)
    val corner: Dp by animateDpAsState(targetValue = if (expanded) 0.dp else 8.dp)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = paddingHorizontal)
            .clip(shape = RoundedCornerShape(corner))
            .shadow(elevation = 8.dp)
            .background(Color.White),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .clickable(
                    enabled = hasSubList,
                    indication = LocalIndication.current,
                    interactionSource = MutableInteractionSource()
                ) {
                    expanded = !expanded
                }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = sample.icon),
                contentDescription = null,
            )
            Width(width = 12.dp)
            Text(
                text = sample.label,
                style = Typography.h5,
            )
        }
        if (hasSubList) {
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(),
                exit = shrinkVertically(),
            ) {
                SampleSubItem(
                    sample = sample,
                    onItemClick = onItemClick,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SampleSubItem(
    sample: SampleAppData.SampleApp,
    onItemClick: (sample: SampleAppData.SampleApp) -> Unit,
) {
    Column {
        sample.subSamples.forEach { subSample ->
            ListItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick.invoke(subSample)
                    }
                    .padding(start = 30.dp),
                secondaryText = {
                    Text(
                        text = subSample.description.orEmpty(),
                        style = Typography.body2,
                    )
                },
                icon = {
                    Image(
                        modifier = Modifier.size(40.dp),
                        painter = painterResource(id = subSample.icon),
                        contentDescription = null
                    )
                },
                text = {
                    Text(
                        text = subSample.label,
                        style = Typography.subtitle1.copy(color = Color.Gray),
                    )
                },
            )
        }
    }
}