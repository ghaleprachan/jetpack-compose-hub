package app.prachang.gmail_clone.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen() {
    HomeContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeContent() {
    val navigationItems = BottomNavItems.values()
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        NavigationBar {
            navigationItems.forEach { bottomNavItem ->
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    label = {
                        Text(text = bottomNavItem.label)
                    },
                    icon = {
                        Icon(
                            imageVector = bottomNavItem.unselectedIcon, contentDescription = null
                        )
                    },
                )
            }
        }
    }) {
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