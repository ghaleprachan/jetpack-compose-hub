@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.material3.appbar

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import app.prachang.material3.Material3Screen
import androidx.compose.material3.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
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
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior = remember(decayAnimationSpec) {
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
    }

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Spacer(modifier = Modifier)
        SmallTopAppBar(
            title = {
                Text(text = "Small TopAppBar")
            },
            navigationIcon = {
                NavigationIcon()
            },
            actions = {
                Actions()
            },
        )

        MediumTopAppBar(
            title = {
                Text(text = "Medium TopAppBar")
            },
            navigationIcon = {
                NavigationIcon()
            },
            actions = {
                Actions()
            },
        )

        Scaffold(modifier = Modifier
            .weight(1f)
            .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                LargeTopAppBar(title = {
                    Text(text = "Large TopAppBar")
                }, navigationIcon = {
                    NavigationIcon()
                }, actions = {
                    Actions()
                }, scrollBehavior = scrollBehavior
                )
            }) {
            LazyColumn(content = {
                items(50) {
                    Text(text = "Index Number $it", modifier = Modifier.fillMaxWidth())
                }
            })
        }
    }

}

@Composable
private fun RowScope.Actions() {
    IconButton(onClick = { }) {
        Icon(imageVector = Icons.Default.Settings, contentDescription = null)
    }
    IconButton(onClick = { }) {
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
    }
}
