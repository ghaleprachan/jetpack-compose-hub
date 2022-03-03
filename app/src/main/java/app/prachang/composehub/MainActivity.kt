package app.prachang.composehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.prachang.common_compose_ui.dialogs.ShowDialog
import app.prachang.composehub.screens.DashboardScreen
import app.prachang.gmail_clone.gmail.GmailScreen
import app.prachang.instagram_clone.InstagramScreen
import app.prachang.theme.materialtheme.ComposeHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    MainScreen()
                }
            }
        }
    }
}


@Composable
internal fun MainScreen() {
    val navController = rememberNavController()
    val showDialog = remember {
        mutableStateOf(false)
    }
    ShowDialog(showDialog = showDialog)

    NavHost(
        navController = navController,
        startDestination = Routes.Dashboard,
        builder = {
            composable(Routes.Dashboard) {
                DashboardScreen { sample ->
                    val route = sample.route
                    try {
                        navController.navigate(route = route.orEmpty())
                    } catch (ex: Exception) {
                        showDialog.value = !showDialog.value
                    }
                }
            }

            composable(Routes.Instagram) {
                InstagramScreen()
            }

            composable(Routes.Gmail) {
                GmailScreen()
            }
        },
    )
}

sealed class Route(val route: String) {
    object Dashboard : Route(route = Routes.Dashboard)
    object Instagram : Route(route = "${Routes.Instagram}/{id}") {
        fun getRoute(id: String): String {
            return "${Routes.Instagram}/$id"
        }
    }
}
