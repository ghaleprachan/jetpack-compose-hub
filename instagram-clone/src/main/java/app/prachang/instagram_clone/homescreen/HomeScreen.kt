package app.prachang.instagram_clone.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Message
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.prachang.dummy_data.instagram.myPosts
import app.prachang.instagram_clone.R

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    val scrollState = rememberLazyListState()
    // val showElevation = scrollState.firstVisibleItemScrollOffset > 0
    val showElevation by remember {
        derivedStateOf { scrollState.firstVisibleItemScrollOffset > 0 }
    }

    Scaffold(
        topBar = {
            TopBar(elevation = if (showElevation) 6.dp else 0.dp)
        }
    ) {
        LazyColumn(
            state = scrollState,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                item {
                    StoryContent()
                    Divider()
                }
                items(myPosts) {
                    PostItem(post = it)
                }
            }
        )
    }
}


@Composable
fun TopBar(elevation: Dp) {
    TopAppBar(
        elevation = elevation,
        title = {
            Icon(
                modifier = Modifier.height(45.dp),
                painter = painterResource(id = R.drawable.ic_instagram),
                contentDescription = null
            )
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    )
}
