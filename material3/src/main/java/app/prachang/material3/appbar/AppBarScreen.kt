@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.material3.appbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import app.prachang.material3.Material3Screen
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.prachang.material3.components.NavigationIcon

@Composable
fun AppBarScreen3(
    navController: NavController
) {
    Material3Screen(title = "Material3 Appbar", navController = navController) {
        AppBarScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBarScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Spacer(modifier = Modifier)
        SmallTopAppBar(title = {
            Text(text = "Small Top Appbar")
        }, navigationIcon = {
            NavigationIcon()
        }, actions = {
            Actions()
        })

        MediumTopAppBar(title = {
            Text(text = "Medium Top Appbar")
        }, navigationIcon = {
            NavigationIcon()
        }, actions = {
            Actions()
        })

        LargeTopAppBar(title = {
            Text(text = "Large Top Appbar")
        }, navigationIcon = {
            NavigationIcon()
        }, actions = {
            Actions()
        })
    }
}

@Composable
private fun RowScope.Actions() {
    IconButton(onClick = { }) {
        Icon(imageVector = Icons.Default.Person, contentDescription = null)
    }
    IconButton(onClick = { }) {
        Icon(imageVector = Icons.Default.Settings, contentDescription = null)
    }
    IconButton(onClick = { }) {
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
    }
}
