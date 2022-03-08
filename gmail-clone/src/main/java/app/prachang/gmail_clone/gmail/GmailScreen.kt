@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED", "OPT_IN_IS_NOT_ENABLED")

package app.prachang.gmail_clone.gmail

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.prachang.common_compose_ui.utils.isScrollingUp
import app.prachang.gmail_clone.GmailRoutes
import app.prachang.gmail_clone.home.EmailListScreen
import app.prachang.gmail_clone.home.MeetScreen
import app.prachang.gmail_clone.navigateToRoute
import app.prachang.gmail_clone.search.SearchScreen
import app.prachang.theme.materialyoutheme.GmailTheme
import app.prachang.theme.materialyoutheme.Material3Colors
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun GmailScreenPreview() {
    GmailScreen()
}

@Composable
fun GmailScreen() {
    GmailTheme {
        GmailContent()
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
private fun GmailContent() {
    // Keyboard
    val configuration = LocalSoftwareKeyboardController.current

    // Search field values
    val focusRequester = remember { FocusRequester() }
    val searchValue = remember { mutableStateOf("") }

    // Drawer Content
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    // Scrolling state
    val emailScrollState = rememberLazyListState()
    val isScrollingUp = emailScrollState.isScrollingUp()

    // Navigation Items
    val navigationItems = BottomNavItems.values()
    val navController = rememberNavController()
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route

    // Top Content Offset
    var topContentHeight by remember { mutableStateOf(0f) }
    var offset by remember {
        mutableStateOf(0f)
    }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = offset + delta
                offset = newOffset.coerceIn(-topContentHeight, 0f)
                return Offset.Zero
            }
        }
    }

    ModalNavigationDrawer(
        modifier = Modifier.nestedScroll(nestedScrollConnection),
        drawerContent = {
            DrawerContent()
        },
        drawerState = drawerState,
        drawerShape = RoundedCornerShape(0.dp),
        drawerContainerColor = Color.White,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Material3Colors.background)
        ) {
            Box(modifier = Modifier.weight(1f)) {
                // Navigation components for screen
                NavigationComponents(
                    modifier = Modifier.fillMaxSize(1f),
                    topContentHeight = topContentHeight,
                    navController = navController,
                    emailScrollState = emailScrollState,
                    isScrollingUp = isScrollingUp,
                    focusRequester = focusRequester,
                )

                // Common top bar for search screen
                TopContentVisibility(
                    isVisible = currentRoute != BottomNavItems.Bookings.route,
                    modifier = Modifier.onGloballyPositioned {
                        topContentHeight = it.size.height.toFloat()
                    },
                    translationY = offset,
                    topContentHeight = topContentHeight
                ) {
                    TopContent(
                        focusRequester = focusRequester,
                        searchValue = searchValue,
                        isEnabled = currentRoute == GmailRoutes.SearchScreen,
                        onClick = {
                            navController.navigateToRoute(route = GmailRoutes.SearchScreen)
                            coroutineScope.launch {
                                awaitFrame()
                                focusRequester.requestFocus()
                            }
                        },
                        onLeadingIconClick = {
                            if (currentRoute == GmailRoutes.SearchScreen) {
                                configuration?.hide()
                                navController.popBackStack()
                            } else {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        },
                    )
                }
            }

            // Bottom navigation bar
            AnimatedVisibility(
                modifier = Modifier,
                visible = currentRoute != GmailRoutes.SearchScreen,
            ) {
                BottomNavBar(
                    navigationItems = navigationItems,
                    currentRoute = currentRoute,
                    navController = navController,
                )
            }
        }
    }
}

@Composable
private fun BoxScope.TopContentVisibility(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    topContentHeight: Float,
    translationY: Float,
    content: @Composable () -> Unit,
) {
    AnimatedVisibility(visible = isVisible,
        modifier = modifier
            .align(alignment = Alignment.TopCenter)
            .graphicsLayer {
                this.translationY = translationY
            },
        exit = slideOut(tween(100)) {
            IntOffset(0, -topContentHeight.roundToInt())
        },
        enter = slideIn(tween(100)) {
            IntOffset(0, 0)
        }) {
        content()
    }
}

@Composable
private fun NavigationComponents(
    navController: NavHostController,
    emailScrollState: LazyListState,
    isScrollingUp: Boolean,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier,
    topContentHeight: Float
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = GmailRoutes.HomeScreen,
        builder = {
            composable(BottomNavItems.Home.route) {
                EmailListScreen(
                    scrollState = emailScrollState,
                    isScrollingUp = isScrollingUp,
                    topContentHeight = topContentHeight
                )
            }
            composable(BottomNavItems.Bookings.route) {
                MeetScreen()
            }
            composable(GmailRoutes.SearchScreen) {
                SearchScreen(
                    focusRequester = focusRequester
                )
            }
        },
    )
}

