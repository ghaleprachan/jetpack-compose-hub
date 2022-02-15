package app.prachang.instagram_clone.profilescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.layouts.itemsInGrid
import app.prachang.dummy_data.image2
import app.prachang.dummy_data.instagram.myPosts
import app.prachang.dummy_data.instagram.profileData
import app.prachang.theme.ComposeHubTheme
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation


@Preview(showSystemUi = true)
@Composable
private fun ProfileScreenPreview() {
    ComposeHubTheme {
        ProfileScreen()
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun ProfileScreen() {
    val elevation = remember {
        mutableStateOf(0.dp)
    }
    val scrollState = rememberLazyListState()

    elevation.value = if (scrollState.firstVisibleItemScrollOffset > 0) {
        8.dp
    } else {
        0.dp
    }
    Scaffold(topBar = {
        TopAppBar(elevation = elevation.value, title = {
            Text(
                text = profileData.username,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        })
    }) {
        LazyColumn(state = scrollState, content = {
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(Modifier.height(IntrinsicSize.Min)) {
                        val painter = rememberImagePainter(data = image2, builder = {
                            transformations(CircleCropTransformation())
                        })
                        Image(
                            modifier = Modifier.size(size = 85.dp),
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
                        text = profileData.name, fontSize = 16.sp, fontWeight = FontWeight.Black
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

            itemsInGrid(
                items = myPosts,
                columns = 3,
                horizontalItemPadding = 2.dp,
                verticalItemPadding = 2.dp,
                contentPadding = PaddingValues(2.dp)
            ) { post ->
                val painter = rememberImagePainter(data = post?.postImage?.get(0), builder = {
                    transformations(RoundedCornersTransformation())
                })
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
        })
    }
}

@Composable
fun FollowMeter(
    modifier: Modifier, count: String? = "2", label: String = "Posts"
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
            text = count ?: "0", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = label, fontSize = 13.sp, fontWeight = FontWeight.Light
        )
    }
}
