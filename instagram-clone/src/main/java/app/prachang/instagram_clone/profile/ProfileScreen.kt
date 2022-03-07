@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.instagram_clone.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PermContactCalendar
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.components.ComposeImage
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.common_compose_ui.layouts.items
import app.prachang.dummy_data.R
import app.prachang.dummy_data.instagram.myPosts
import app.prachang.dummy_data.instagram.profileData
import app.prachang.theme.materialtheme.ComposeHubTheme


@Preview(showSystemUi = true)
@Composable
private fun ProfileScreenPreview(
    onMoreOptions: () -> Unit = {}
) {
    ComposeHubTheme {
        ProfileScreen(
            onMoreOptions = onMoreOptions
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ProfileScreen(onMoreOptions: () -> Unit) {
    val scrollState = rememberLazyListState()
    val showElevation by remember {
        derivedStateOf {
            scrollState.firstVisibleItemScrollOffset > 0
        }
    }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(showElevation = showElevation, onMoreOptions = onMoreOptions)
            }
        },
    ) {
        LazyColumn(
            state = scrollState,
            content = {
                item {
                    // Top Content contains follow count, profile, name and edit profile
                    TopContent()
                }

                item {
                    // Pinned Stories
                    PinnedStoryContent()
                }

                stickyHeader {
                    // Tab for profile screen
                    ProfileTab()
                }

                items(
                    items = myPosts,
                    columns = 3,
                    horizontalItemPadding = 2.dp,
                    verticalItemPadding = 2.dp,
                    contentPadding = PaddingValues(2.dp)
                ) { post ->
                    ComposeImage(
                        modifier = Modifier.aspectRatio(1f),
                        url = post.postImage[0],
                    )
                }
            },
        )
    }
}

@Composable
private fun TopAppBar(
    showElevation: Boolean,
    onMoreOptions: () -> Unit = {},
) {
    TopAppBar(
        elevation = 0.dp,
        title = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = profileData.username,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                )
                Icon(
                    imageVector = Icons.Outlined.ExpandMore,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.AddBox,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black,
                )
            }
            IconButton(onClick = onMoreOptions) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )
            }
        },
    )
    if (showElevation) {
        Divider()
    }
}

@Composable
private fun ProfileTab() {
    Column(modifier = Modifier.background(Color.White)) {
        Height(height = 16.dp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_grid), contentDescription = null
                )
                Height(height = 16.dp)
                Divider(color = Color.Black)
            }
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    Icons.Default.PermContactCalendar, contentDescription = null, tint = Color.Gray
                )
                Height(height = 16.dp)
                Divider(color = Color.Transparent)
            }
        }
    }
}
