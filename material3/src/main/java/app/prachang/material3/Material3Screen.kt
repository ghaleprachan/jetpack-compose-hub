@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.material3

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import app.prachang.material3.components.NavigationIcon
import app.prachang.theme.materialyoutheme.GmailTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Material3Screen(
    title: String, navController: NavController, content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(title = {
                Text(text = title)
            }, navigationIcon = {
                NavigationIcon {
                    navController.popBackStack()
                }
            })
        },
        content = {
            content()
        },
    )
}