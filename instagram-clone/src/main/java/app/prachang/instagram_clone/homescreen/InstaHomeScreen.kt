package app.prachang.instagram_clone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Message
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.prachang.dummy_data.instagram.myPosts
import app.prachang.instagram_clone.homescreen.PostItem
import app.prachang.instagram_clone.homescreen.StoryContent

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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                item {
                    StoryContent()
                }
                items(myPosts.take(10)) {
                    PostItem(post = it)
                }
            }
        )
    }
}

