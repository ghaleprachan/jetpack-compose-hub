package app.prachang.instagram_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Message
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.dummy_data.instagram.Post
import app.prachang.dummy_data.instagram.kotlinIcon
import app.prachang.dummy_data.instagram.myPosts
import coil.compose.rememberImagePainter

@Preview(showSystemUi = true)
@Composable
private fun InstaHomeScreenPreview() {
    InstaHomeScreen()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun InstaHomeScreen() {
    var elevation by remember {
        mutableStateOf(0.dp)
    }

    val scrollState = rememberLazyListState()
    elevation = if (scrollState.firstVisibleItemScrollOffset > 0) {
        8.dp
    } else {
        0.dp
    }
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = elevation,
                title = {
                    Text(text = "Instagram")
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Outlined.FavoriteBorder, contentDescription = null)
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Outlined.Message, contentDescription = null)
                    }
                }
            )
        }
    ) {
        LazyColumn(
            state = scrollState,
            content = {
                item {
                    StoryContent()
                }
                items((1..100).toList()) {
                    ListItem {
                        Text(text = "Title $it")
                    }
                }
            }
        )
    }
}

@Composable
fun StoryContent() {
    val gradient = Brush.sweepGradient(listOf(Color.Red, Color.Magenta))
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        content = {
            item {
                MyStoryItem()
            }
            items(myPosts.take(10)) { post ->
                StoryItem(post, gradient)
            }
        }
    )
}

@Composable
fun MyStoryItem() {
    val painter = rememberImagePainter(data = kotlinIcon)
    Column {
        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .padding(5.dp)
                    .clip(shape = CircleShape)
            )
            Icon(
                Icons.Outlined.Add,
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .size(20.dp)
                    .clip(shape = CircleShape)
                    .background(Color(0xFF2196F3))
                    .border(width = 1.dp, color = Color.White, shape = CircleShape)
                    .padding(2.dp),
                tint = Color.White
            )
        }
        Height(4)
        Text(
            modifier = Modifier.width(70.dp),
            text = "Your story",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            ),
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}

@Composable
private fun StoryItem(
    post: Post,
    gradient: Brush
) {
    val painter = rememberImagePainter(data = post.userImage)
    Column {
        Image(
            painter = painter,
            modifier = Modifier
                .size(70.dp)
                .border(
                    width = 1.5.dp,
                    brush = gradient,
                    shape = CircleShape
                )
                .padding(5.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Height(4)
        Text(
            modifier = Modifier.width(70.dp),
            text = post.username,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            ),
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}