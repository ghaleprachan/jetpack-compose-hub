package app.prachang.instagram_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.prachang.common_compose_ui.components.CircleImage
import app.prachang.dummy_data.instagram.kotlinIcon
import app.prachang.instagram_clone.home.HomeScreen
import app.prachang.instagram_clone.profile.ProfileScreen
import app.prachang.instagram_clone.search.SearchScreen
import app.prachang.instagram_clone.shop.ShopScreen
import kotlinx.coroutines.launch

@Composable
fun InstagramScreen() {
    MainScreenContent()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun MainScreenContent() {
    val context = LocalContext.current
    val bottomNavItems = BottomNavItems.values()
    val rememberCoroutineScope = rememberCoroutineScope()

    val navController = rememberNavController()
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route

    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )
    ModalBottomSheetLayout(
        sheetContent = {
            BottomSheetContent()
        },
        sheetShape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp),
        sheetState = modalBottomSheetState,
    ) {
        Column {
            InstagramContent(
                modifier = Modifier.weight(1f),
                navController = navController,
                onMoreOptions = {
                    rememberCoroutineScope.launch {
                        modalBottomSheetState.show()
                    }
                },
            )

            BottomNavView(
                bottomNavItems = bottomNavItems,
                currentRoute = currentRoute,
                navController = navController,
            )
        }
    }
}

@Composable
private fun InstagramContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onMoreOptions: () -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomNavItems.Home.route,
        builder = {
            composable(BottomNavItems.Home.route) {
                HomeScreen()
            }
            composable(BottomNavItems.Search.route) {
                SearchScreen()
            }
            composable(BottomNavItems.Shop.route) {
                ShopScreen()
            }
            composable(BottomNavItems.Profile.route) {
                ProfileScreen(onMoreOptions = onMoreOptions)
            }
        },
    )
}

@Composable
private fun BottomNavView(
    bottomNavItems: Array<BottomNavItems>,
    currentRoute: String?,
    navController: NavHostController,
) {
    BottomAppBar(
        modifier = Modifier.background(Color.Red),
        contentColor = Color.Red,
    ) {
        bottomNavItems.forEachIndexed { _, bottomNavItem ->
            val isItemSelected = currentRoute == bottomNavItem.route
            val icon = if (isItemSelected) {
                bottomNavItem.selectedIcon
            } else {
                bottomNavItem.icon
            }

            BottomNavigationItem(
                selected = isItemSelected,
                onClick = {
                    navController.navigate(route = bottomNavItem.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route = route)
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    if (bottomNavItem == BottomNavItems.Profile) {
                        CircleImage(
                            modifier = Modifier
                                .size(24.dp)
                                .then(
                                    if (isItemSelected) {
                                        Modifier
                                            .border(
                                                width = 1.dp,
                                                color = Color.Black,
                                                shape = CircleShape,
                                            )
                                            .padding(3.dp)
                                    } else {
                                        Modifier
                                    }
                                ),
                            url = kotlinIcon,
                        )
                    } else {
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = icon),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )
                    }
                },
                selectedContentColor = Color.Black,
            )
        }
    }
}

@Composable
private fun BottomSheetContent() {
    Column(modifier = Modifier) {
        (0..12).forEach {
            Text(text = "Content number is $it")
        }
    }
}

