@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.gmail_clone.gmail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.prachang.common_compose_ui.components.CircleImage
import app.prachang.common_compose_ui.utils.isScrollingUp
import app.prachang.dummy_data.instagram.kotlinIcon
import app.prachang.gmail_clone.GmailRoutes
import app.prachang.gmail_clone.home.HomeScreen
import app.prachang.gmail_clone.search.SearchScreen
import app.prachang.theme.materialyoutheme.GmailTheme
import app.prachang.theme.materialyoutheme.Material3Colors

@Composable
fun GmailScreen() {
    GmailTheme {
        GmailContent()
    }
}

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class
)
@Composable
private fun GmailContent() {
    val focusRequester = remember {
        FocusRequester()
    }

    val emailScrollState = rememberLazyListState()
    val isScrollingUp = emailScrollState.isScrollingUp()

    val navController = rememberNavController()
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route

    val searchValue = remember {
        mutableStateOf("")
    }

    NavigationDrawer(
        drawerContent = {
            Text("Here is drawer content")
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Material3Colors.background)
        ) {
            TopContent(
                focusRequester = focusRequester,
                searchValue = searchValue,
                isEnabled = currentRoute == GmailRoutes.SearchScreen,
                onClick = {
                    navController.navigate(route = GmailRoutes.SearchScreen) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route = route)
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
            )
            NavHost(
                navController = navController, startDestination = GmailRoutes.HomeScreen,
                builder = {
                    composable(GmailRoutes.HomeScreen) {
                        HomeScreen(state = emailScrollState)
                    }
                    composable(GmailRoutes.SearchScreen) {
                        SearchScreen(
                            focusRequester = focusRequester
                        )
                    }
                },
            )
        }
    }
}

@Composable
private fun TopContent(
    modifier: Modifier = Modifier,
    searchValue: MutableState<String>,
    isEnabled: Boolean,
    onClick: () -> Unit,
    focusRequester: FocusRequester,
) {
    Box(
        modifier = modifier.padding(
            horizontal = 16.dp, vertical = 8.dp
        )
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .clip(shape = CircleShape)
                .clickable { onClick() },
            placeholder = {
                Text(text = "Search in emails")
            },
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = null,
                    )
                }
            },
            trailingIcon = {
                CircleImage(url = kotlinIcon, modifier = Modifier.size(30.dp))
            },
            value = searchValue.value,
            onValueChange = { searchValue.value = it },
            shape = CircleShape,
            singleLine = true,
            enabled = isEnabled,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = Color.DarkGray
            ),
        )
    }
}
