package app.prachang.instagram_clone.profilescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.common_compose_ui.layouts.items
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

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun ProfileScreen() {
    val scrollState = rememberLazyListState()
    val showElevation by remember {
        derivedStateOf {
            scrollState.firstVisibleItemScrollOffset > 0
        }
    }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    elevation = 0.dp,
                    title = {
                        Text(
                            text = profileData.username,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.MoreVert, contentDescription = null)
                        }
                    },
                )
                if (showElevation) {
                    Divider()
                }
            }
        },
    ) {
        LazyColumn(state = scrollState, content = {
            item {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.height(IntrinsicSize.Min)
                    ) {
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
                    Height(height = 8.dp)
                    Text(
                        text = profileData.name, fontSize = 16.sp, fontWeight = FontWeight.Black
                    )
                    Text(text = "Athlete", fontSize = 14.sp)
                    Height(height = 8.dp)
                }
            }

            stickyHeader {
                Column(modifier = Modifier.background(Color.White)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(65.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Dashboard, contentDescription = null)
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Save, contentDescription = null)
                        }
                    }
                }
            }

            items(
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
