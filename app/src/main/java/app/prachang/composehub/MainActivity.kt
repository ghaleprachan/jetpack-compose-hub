package app.prachang.composehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.TestUI
import app.prachang.dummy_data.image2
import app.prachang.dummy_data.instagram.myPosts
import app.prachang.dummy_data.instagram.profileData
import app.prachang.theme.ComposeHubTheme
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TestUI {
                        Text("MyBasicColumn")
                        Text("places items")
                        Text("vertically.")
                        Text("We've done it by hand!")
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ProfileScreenPreview() {
    ComposeHubTheme {
        ProfileScreen()
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
internal fun ProfileScreen() {
    val elevation = remember {
        mutableStateOf(0.dp)
    }
    val scrollState = rememberLazyListState()
    if (scrollState.firstVisibleItemScrollOffset > 0) {
        elevation.value = 8.dp
    } else {
        elevation.value = 0.dp
    }
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = elevation.value,
                title = {
                    Text(
                        text = profileData.username,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
            )
        }
    ) {
        LazyColumn(
            state = scrollState,
            content = {
                item {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(Modifier.height(IntrinsicSize.Min)) {
                            val painter = rememberImagePainter(
                                data = image2,
                                builder = {
                                    transformations(CircleCropTransformation())
                                }
                            )
                            Image(
                                modifier = Modifier
                                    .size(size = 85.dp),
                                painter = painter,
                                contentDescription = null,
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            FollowMeter(
                                modifier = Modifier.weight(1f),
                                count = profileData.totalPosts,
                                label = "Posts"
                            )
                            FollowMeter(
                                modifier = Modifier.weight(1f),
                                count = profileData.followerCount,
                                label = "Followers"
                            )
                            FollowMeter(
                                modifier = Modifier.weight(1f),
                                count = profileData.followingCount,
                                label = "Following"
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = profileData.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black
                        )
                        Text(text = "Athlete", fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                stickyHeader {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                            .background(Color.Gray)
                    ) {

                    }
                }
                val paddingValues = PaddingValues(top = 2.dp, start = 2.dp)
                val endPaddingValues = PaddingValues(start = 2.dp, end = 2.dp, top = 2.dp)
                items(myPosts.windowed(3, 3, true)) { subList ->
                    Row {
                        subList.forEachIndexed { index, post ->
                            val painter = rememberImagePainter(
                                data = post.postImage[0],
                                builder = {
                                    transformations(RoundedCornersTransformation())
                                }
                            )
                            Image(
                                painter = painter,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(if (subList.lastIndex == index) endPaddingValues else paddingValues)
                                    .weight(1f)
                                    .aspectRatio(1f),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun FollowMeter(
    modifier: Modifier,
    count: String? = "2",
    label: String = "Posts"
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .clickable {

            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = count ?: "0",
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Light
        )
    }
}
