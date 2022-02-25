package app.prachang.instagram_clone

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun InstagramScreen() {
    MainScreenContent()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun MainScreenContent() {
    val bottomNavItems = BottomNavItems.values()

    BottomSheetScaffold(sheetContent = {}) {
        Column {
            Surface(modifier = Modifier.fillMaxSize(1f)) {

            }
            BottomAppBar {
                bottomNavItems.forEachIndexed { index, bottomNavItem ->
                    BottomNavigationItem(
                        selected = true,
                        onClick = { /*TODO*/ },
                        icon = {
                            Icon(
                                painter = painterResource(id = bottomNavItem.icon),
                                contentDescription = null
                            )
                        },
                    )
                }
            }
        }
    }
}
