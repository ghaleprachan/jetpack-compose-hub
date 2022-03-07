package app.prachang.material3.bottombar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.prachang.material3.Material3Screen

@Composable
fun BottomBarScreen3(
    navController: NavController
) {
    Material3Screen(title = "Bottom Bar", navController = navController) {
        BottomBarScreen()
    }
}

@Composable
private fun BottomBarScreen() {
    val items = BottomBarItems.values()

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Spacer(modifier = Modifier)
        NavigationBar {
            items.forEach { item ->
                NavigationBarItem(
                    selected = item == BottomBarItems.Home,
                    onClick = { },
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = item.label)
                    },
                )
            }
        }
        NavigationBar {
            items.forEach { item ->
                NavigationBarItem(
                    selected = item == BottomBarItems.Home,
                    onClick = { },
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = item.label)
                    },
                    label = {
                        Text(text = item.label)
                    }
                )
            }
        }
    }
}

enum class BottomBarItems(val label: String, val icon: ImageVector) {
    Home("Home", Icons.Default.Home),
    Bookings("Bookings", Icons.Default.MenuBook),
    Analytics("Analytics", Icons.Default.Analytics),
    Profile("Profile", Icons.Default.Person),
}