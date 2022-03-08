package app.prachang.gmail_clone

import androidx.navigation.NavController
import androidx.navigation.NavHostController

internal object GmailRoutes {
    const val HomeScreen = "route-home"
    const val SearchScreen = "route-search"
    const val EmailDetail = "route-email-details/{email_id}"
}

// This is better way to use route when having
// parameter to pass or else just use enums to be more specific or else object
internal sealed class Routes(
    val route: String
) {
    object HomeScreen : Routes(GmailRoutes.HomeScreen)
    object SearchScreen : Routes(GmailRoutes.SearchScreen)
    object EmailDetail : Routes(GmailRoutes.EmailDetail) {
        fun getRoute(emailId: String): String {
            return "$route/$emailId"
        }
    }
}


internal fun NavHostController.navigateToRoute(route: String) {
    this.navigate(route = route) {
        this@navigateToRoute.graph.startDestinationRoute?.let { route ->
            popUpTo(route = route)
        }
        restoreState = true
        launchSingleTop = true
    }
}