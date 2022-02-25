package app.prachang.instagram_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.prachang.instagram_clone.homescreen.HomeScreen

@Composable
fun InstagramScreen() {
    MainScreenContent()
}

@Composable
private fun MainScreenContent() {
    val bottomNavItems = BottomNavItems.values()

    /*BottomSheetScaffold(sheetContent = {}) {

    }*/

    Scaffold(
        bottomBar = {
            BottomAppBar {
                bottomNavItems.forEachIndexed { index, bottomNavItem ->
                    BottomNavigationItem(
                        selected = true,
                        onClick = { },
                        icon = {
                            val icon =
                                if (bottomNavItem == BottomNavItems.Home) bottomNavItem.selectedIcon
                                else bottomNavItem.icon
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = icon),
                                contentDescription = null,
                                tint = Color.Black,
                            )
                        },
                        selectedContentColor = Color.Black,
                    )
                }
            }
        },
    ) {
        Box(modifier = Modifier.padding(it)) {
            HomeScreen()
        }
    }

    /*BottomSheetScaffold(sheetContent = {}) {
        Column(modifier = Modifier.padding(it)) {
            *//*Surface(modifier = Modifier.fillMaxSize(1f)) {

            }*//*
            // HomeScreen()

        }
    }*/
}
