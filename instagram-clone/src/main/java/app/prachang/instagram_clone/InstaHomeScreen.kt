package app.prachang.instagram_clone

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Message
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        content = {
            items((1..20).toList()) {
                Text(text = "Story $it")
            }
        }
    )
}