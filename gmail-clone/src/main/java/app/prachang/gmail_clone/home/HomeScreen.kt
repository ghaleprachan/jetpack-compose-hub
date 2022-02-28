package app.prachang.gmail_clone.home

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.prachang.theme.materialyoutheme.Material3Colors

@Composable
fun HomeScreen() {
    HomeContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeContent() {
    val navigationItems = BottomNavItems.values()
    val navController = rememberNavController()
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route

    Scaffold(
        bottomBar = {
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
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                containerColor = Material3Colors.secondary,
                icon = {
                    Icon(Icons.Default.Edit, contentDescription = null)
                },
                text = {
                    Text(text = "Compose")
                },
                onClick = {

                },
            )
        },
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItems.Home.route,
            builder = {
                composable(BottomNavItems.Home.route) {
                    EmailListScreen()
                }
                composable(BottomNavItems.Bookings.route) {
                    MeetScreen()
                }
            },
        )
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