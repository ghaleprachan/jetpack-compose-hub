package app.prachang.composehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.*
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
import app.prachang.dummy_data.instagram.pagerImages
import app.prachang.instagram_clone.InstagramScreen
import app.prachang.theme.ComposeHubTheme
import app.prachang.theme.Typography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Gray//color = MaterialTheme.colors.background
                ) {
                    // MainScreen()
                    // HomeScreen()
                    InstagramScreen()
                }
            }
        }
    }
}

@Composable
internal fun MainScreen() {
    Scaffold(
        backgroundColor = Color(0xFFDFEDF3),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Compose Sample")
                },
            )
        },
        content = {
            val samples = SampleAppData.SampleAppType.values()
            LazyColumn(
                contentPadding = PaddingValues(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                content = {
                    item {
                        HomeTopContent()
                    }
                    itemsIndexed(samples) { index, sample ->
                        SampleItem(
                            sample = sample,
                            onItemSelected = {},
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
    val widthOne = getWidth(percentage = 0.85)
    val widthTwo = getWidth(percentage = 0.50)
    val width = getWidth()
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
                        start = widthOne, stop = width, fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = (scale / width)
                        scaleY = (scale / width)
                    }
                    alpha = lerp(
                        start = widthTwo, stop = width, fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ) / width
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
private fun SampleItem(sample: SampleAppData.SampleAppType, onItemSelected: () -> Unit = {}) {
    val hasSubList = sample.samples.isNotEmpty()
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
                    onItemSelected()
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
                text = sample.title,
                style = Typography.h5,
            )
        }
        if (hasSubList) {
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(),
                exit = shrinkVertically(),
            ) {
                SubItem(
                    sampleContent = sample,
                    onItemClick = {},
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SubItem(
    sampleContent: SampleAppData.SampleAppType,
    onItemClick: (sample: SampleAppData.SampleApp) -> Unit,
) {
    Column {
        sampleContent.samples.forEach { sample ->
            ListItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick.invoke(sample)
                    }
                    .padding(start = 30.dp),
                secondaryText = {
                    Text(
                        text = sample.description.orEmpty(),
                        style = Typography.body2,
                    )
                },
                icon = {
                    sample.icon?.let { icon ->
                        Image(
                            modifier = Modifier.size(40.dp),
                            painter = painterResource(id = icon),
                            contentDescription = null
                        )
                    }
                },
                text = {
                    Text(
                        text = sample.label,
                        style = Typography.subtitle1.copy(color = Color.Gray),
                    )
                },
            )
        }
    }
}