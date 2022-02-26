package app.prachang.composehub

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import app.prachang.composehub.screens.DashboardScreen
import app.prachang.instagram_clone.InstagramScreen
import app.prachang.theme.ComposeHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Gray//color = MaterialTheme.colors.background
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
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Routes.Dashboard,
        builder = {
            composable(Routes.Dashboard) {
                DashboardScreen { sample ->
                    val route = sample.route
                    navigateNext(route, navController, context)
                }
            }

            composable(Routes.Instagram) {
                InstagramScreen()
            }

            dialog(Routes.Dialog) {

            }
        },
    )
}

private fun navigateNext(
    route: String?,
    navController: NavHostController,
    context: Context,
) {
    // Optimize it later todo(ghaleprachan)
    try {
        if (route != null) {
            navController.navigate(route = route)
        } else {
            Toast.makeText(context, "Work on progress", Toast.LENGTH_SHORT).show()
        }
    } catch (ex: Exception) {
        Toast.makeText(context, "Work on progress", Toast.LENGTH_SHORT).show()
    }
}