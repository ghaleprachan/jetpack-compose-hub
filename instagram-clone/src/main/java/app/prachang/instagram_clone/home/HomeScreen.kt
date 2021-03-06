package app.prachang.instagram_clone.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.dummy_data.instagram.myPosts
import app.prachang.instagram_clone.R
import app.prachang.theme.materialtheme.ComposeHubTheme

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    ComposeHubTheme {
        HomeScreen()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun HomeScreen() {
    val scrollState = rememberLazyListState()
    val showElevation by remember {
        derivedStateOf { scrollState.firstVisibleItemScrollOffset > 0 }
    }

    Scaffold(
        topBar = {
            TopBar(elevation = if (showElevation) 6.dp else 0.dp)
        },
    ) {
        LazyColumn(
            contentPadding = it,
            state = scrollState,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                item {
                    StoryContent()
                    Divider()
                }
                items(myPosts) { post ->
                    PostItem(post = post)
                }
                item {
                    Height(height = 12.dp)
                }
            },
        )
    }
}


@Composable
private fun TopBar(elevation: Dp) {
    TopAppBar(elevation = elevation, title = {
        Icon(
            modifier = Modifier.height(45.dp),
            painter = painterResource(id = R.drawable.ic_instagram),
            contentDescription = null
        )
    }, actions = {
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
    })
}
