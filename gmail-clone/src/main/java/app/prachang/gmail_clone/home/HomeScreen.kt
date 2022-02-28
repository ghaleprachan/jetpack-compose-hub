@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.gmail_clone.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.prachang.common_compose_ui.extensions.Width
import app.prachang.common_compose_ui.utils.isScrollingUp
import app.prachang.theme.materialyoutheme.Material3Colors

@Composable
fun HomeScreen(state: LazyListState) {
    HomeContent(state = state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeContent(
    state: LazyListState
) {
    val navigationItems = BottomNavItems.values()
    val navController = rememberNavController()
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val isScrollingUp = state.isScrollingUp()

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navigationItems = navigationItems,
                currentRoute = currentRoute,
                navController = navController,
            )
        },
        floatingActionButton = {
            ExpandableFloatingButton(isScrollingUp = isScrollingUp)
        },
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItems.Home.route,
            builder = {
                composable(BottomNavItems.Home.route) {
                    EmailListScreen(
                        emailScrollState = state
                    )
                }
                composable(BottomNavItems.Bookings.route) {
                    MeetScreen()
                }
            },
        )
    }
}

@Composable
private fun BottomNavBar(
    navigationItems: Array<BottomNavItems>,
    currentRoute: String?,
    navController: NavHostController
) {
    NavigationBar {
        navigationItems.forEach { bottomNavItem ->
            val isSelected = bottomNavItem.route == currentRoute
            val icon =
                if (isSelected) bottomNavItem.selectedIcon else bottomNavItem.unselectedIcon

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(route = bottomNavItem.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route)
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                label = {
                    Text(text = bottomNavItem.label)
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                    )
                },
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ExpandableFloatingButton(isScrollingUp: Boolean) {
    Card(
        modifier = Modifier.height(60.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        onClick = {},
        backgroundColor = Material3Colors.secondary
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Outlined.Edit, contentDescription = null)
            AnimatedVisibility(visible = isScrollingUp) {
                Row {
                    Width(width = 12.dp)
                    Text(text = "Compose", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

enum class BottomNavItems(
    val label: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    Home("Mail", "route-home", Icons.Filled.Mail, Icons.Outlined.Mail), Bookings(
        "Meet", "route-meet", Icons.Filled.VideoCall, Icons.Outlined.VideoCall
    ),
}