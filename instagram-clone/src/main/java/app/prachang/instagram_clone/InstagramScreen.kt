package app.prachang.instagram_clone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.prachang.common_compose_ui.components.CircleImage
import app.prachang.dummy_data.instagram.kotlinIcon
import app.prachang.instagram_clone.homescreen.HomeScreen
import app.prachang.instagram_clone.profilescreen.ProfileScreen

@Composable
fun InstagramScreen() {
    MainScreenContent()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun MainScreenContent() {
    val context = LocalContext.current
    val bottomNavItems = BottomNavItems.values()

    val navController = rememberNavController()
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route


    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )
    ModalBottomSheetLayout(
        sheetContent = {
            Text(text = "One")
        },
        sheetState = modalBottomSheetState,
    ) {
        Column {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = BottomNavItems.Home.route,
                builder = {
                    composable(BottomNavItems.Home.route) {
                        HomeScreen()
                    }
                    composable(BottomNavItems.Profile.route) {
                        ProfileScreen()
                    }
                },
            )
            BottomAppBar(
                modifier = Modifier.background(Color.Red),
                contentColor = Color.Red,
            ) {
                bottomNavItems.forEachIndexed { index, bottomNavItem ->
                    val isItemSelected = currentRoute == bottomNavItem.route
                    val icon = if (isItemSelected) {
                        bottomNavItem.selectedIcon
                    } else {
                        bottomNavItem.icon
                    }

                    BottomNavigationItem(
                        selected = isItemSelected,
                        onClick = {
                            navController.navigate(route = bottomNavItem.route)
                        },
                        icon = {
                            if (bottomNavItem == BottomNavItems.Profile) {
                                CircleImage(
                                    modifier = Modifier.size(24.dp),
                                    url = kotlinIcon,
                                )
                            } else {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(id = icon),
                                    contentDescription = null,
                                    tint = Color.Black,
                                )
                            }
                        },
                        selectedContentColor = Color.Black,
                    )
                }
            }
        }
    }
}
