@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.gmail_clone.gmail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.prachang.common_compose_ui.animations.RotateIcon
import app.prachang.common_compose_ui.components.CircleImage
import app.prachang.common_compose_ui.utils.isScrollingUp
import app.prachang.dummy_data.instagram.kotlinIcon
import app.prachang.gmail_clone.GmailRoutes
import app.prachang.gmail_clone.home.*
import app.prachang.gmail_clone.home.EmailListScreen
import app.prachang.gmail_clone.search.SearchScreen
import app.prachang.theme.CustomColors
import app.prachang.theme.materialyoutheme.GmailTheme
import app.prachang.theme.materialyoutheme.Material3Colors
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class,
    ExperimentalComposeUiApi::class,
)
@Composable
private fun GmailContent() {
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

    NavigationDrawer(
        drawerContent = {
            DrawerContent()
        },
        drawerContainerColor = Color.White,
        drawerShape = RoundedCornerShape(0.dp),
        drawerState = drawerState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Material3Colors.background)
        ) {
            // Common top bar for search screen
            AnimatedVisibility(
                visible = isScrollingUp && currentRoute != BottomNavItems.Bookings.route,
            ) {
                TopContent(
                    focusRequester = focusRequester,
                    searchValue = searchValue,
                    isEnabled = currentRoute == GmailRoutes.SearchScreen,
                    onClick = {
                        navController.navigate(route = GmailRoutes.SearchScreen) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route = route)
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                    onLeadingIconClick = {
                        if (currentRoute == GmailRoutes.SearchScreen) {
                            navController.popBackStack()
                        } else {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }
                    },
                )
            }
            // Navigation components for screen
            NavigationComponents(
                navController = navController,
                emailScrollState = emailScrollState,
                isScrollingUp = isScrollingUp,
                focusRequester = focusRequester,
                modifier = Modifier.weight(1f)
            )
            // Bottom navigation bar
            AnimatedVisibility(visible = currentRoute != GmailRoutes.SearchScreen) {
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
private fun NavigationComponents(
    navController: NavHostController,
    emailScrollState: LazyListState,
    isScrollingUp: Boolean,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier
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

