package com.example.facebook_clone.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.facebook_clone.BottomNavItems
import com.example.facebook_clone.R
import com.example.facebook_clone.screens.homescreen.HomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun FacebookHomeScreen() {
    FacebookHomeContent()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FacebookHomeContent() {
    val tabs = BottomNavItems.values()
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    Column {
        AnimatedVisibility(visible = pagerState.currentPage == BottomNavItems.Home.ordinal) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = rememberImagePainter(data = R.drawable.ic_facebook_label),
                    contentDescription = null,
                    modifier = Modifier.size(height = 36.dp, width = 113.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { }) {
                    Image(
                        painter = rememberImagePainter(data = R.drawable.ic_search_outlined),
                        contentDescription = null,
                        modifier = Modifier.size(35.dp)
                    )
                }
                IconButton(onClick = { }) {
                    Image(
                        painter = rememberImagePainter(data = R.drawable.ic_messanger),
                        contentDescription = null,
                        modifier = Modifier.size(35.dp),
                    )
                }
            }
        }

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    color = Color.Blue,
                )
            },
            backgroundColor = Color.White,
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = pagerState.currentPage == index,
                    selectedContentColor = Color.Blue,
                    unselectedContentColor = Color.DarkGray,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                    // text = { Text(title) },
                    icon = {
                        Icon(
                            modifier = Modifier.size(22.dp),
                            painter = painterResource(id = if (pagerState.currentPage == index) tab.selectedIcon else tab.unSelectedIcon),
                            contentDescription = null,
                        )
                    }
                )
            }
        }
        HorizontalPager(count = tabs.size, state = pagerState) { page: Int ->
            Crossfade(targetState = page) {
                when (it) {
                    BottomNavItems.Home.ordinal -> HomeScreen()
                    else -> Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Current Page $page")
                    }
                }
            }
        }
    }
}

