package app.prachang.instagram_clone

import androidx.compose.foundation.lazy.LazyColumn
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

@Composable
fun InstaHomeScreen() {
    var elevation by remember {
        mutableStateOf(8.dp)
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

            }
        )
    }
}