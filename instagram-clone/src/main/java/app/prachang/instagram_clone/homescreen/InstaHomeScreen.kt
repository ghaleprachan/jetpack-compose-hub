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
import app.prachang.instagram_clone.homescreen.MyStoryItem
import app.prachang.instagram_clone.homescreen.StoryContent
import app.prachang.instagram_clone.homescreen.StoryItem
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

