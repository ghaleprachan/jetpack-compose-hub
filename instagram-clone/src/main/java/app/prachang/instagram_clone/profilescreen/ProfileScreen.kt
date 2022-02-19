package app.prachang.instagram_clone.profilescreen

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
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
import app.prachang.common_compose_ui.layouts.items
import app.prachang.dummy_data.instagram.myPosts
import app.prachang.dummy_data.instagram.profileData
import app.prachang.theme.ComposeHubTheme
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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
    var post by remember {
        mutableStateOf(true)
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
                // Top Content contains follow count, profile, name and edit profile
                TopContent()
            }

            item {
                // Pinned Stories
                PinnedStoryContent()
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
                        IconButton(onClick = {
                            post = true
                        }) {
                            Icon(Icons.Default.Dashboard, contentDescription = null)
                        }
                        IconButton(onClick = {
                            post = false
                        }) {
                            Icon(Icons.Default.Save, contentDescription = null)
                        }
                    }
                }
            }

            /*item {
                Crossfade(targetState = post) {
                    if (it) {
                        Column {
                            myPosts.windowed(3, 3).forEach { subList ->
                                subList.forEach { post ->
                                    Row {
                                        val painter =
                                            rememberImagePainter(
                                                data = post.postImage[0],
                                                builder = {
                                                    transformations(RoundedCornersTransformation())
                                                })
                                        Image(
                                            painter = painter,
                                            contentDescription = null,
                                            modifier = Modifier.aspectRatio(1f),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }
                            }
                        }
                    } else {
                        Column {
                            myPosts.asReversed().windowed(3, 3).forEach { subList ->
                                subList.forEach { post ->
                                    Row {
                                        val painter =
                                            rememberImagePainter(
                                                data = post.postImage[0],
                                                builder = {
                                                    transformations(RoundedCornersTransformation())
                                                })
                                        Image(
                                            painter = painter,
                                            contentDescription = null,
                                            modifier = Modifier.aspectRatio(1f),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }*/

            items(
                items = myPosts,
                columns = 3,
                horizontalItemPadding = 2.dp,
                verticalItemPadding = 2.dp,
                contentPadding = PaddingValues(2.dp)
            ) { post ->

                val painter = rememberImagePainter(
                    data = post?.postImage?.get(0),
                    builder = {
                        transformations(RoundedCornersTransformation())
                    },
                )
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
private fun LazyListScope.SavedPosts() {
    items(
        items = myPosts.subList(6, 12),
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
}

@Composable
private fun LazyListScope.MyPosts() {
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
}