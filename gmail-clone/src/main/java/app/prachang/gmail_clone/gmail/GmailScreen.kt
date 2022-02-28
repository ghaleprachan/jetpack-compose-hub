@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.gmail_clone.gmail

import android.location.provider.ProviderProperties
import android.widget.Toast
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInputModeManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import app.prachang.common_compose_ui.components.CircleImage
import app.prachang.dummy_data.instagram.kotlinIcon
import app.prachang.gmail_clone.home.HomeScreen
import app.prachang.gmail_clone.search.SearchScreen
import app.prachang.theme.materialyoutheme.GmailTheme
import app.prachang.theme.materialyoutheme.Material3Colors
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class GmailTargetState {
    HomeScreen, SearchScreen
}

@Composable
fun GmailScreen() {
    GmailTheme {
        GmailContent()
    }
}

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class,
    ExperimentalComposeUiApi::class
)
@Composable
private fun GmailContent() {
    val localContext = LocalContext.current
    val focusRequester = remember {
        FocusRequester()
    }
    val scope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current

    var currentScreen by remember {
        mutableStateOf(GmailTargetState.HomeScreen)
    }

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
                isEnabled = currentScreen == GmailTargetState.SearchScreen,
                onClick = {
                    currentScreen = if (currentScreen == GmailTargetState.HomeScreen) {
                        GmailTargetState.SearchScreen
                    } else {
                        focusRequester.freeFocus()
                        GmailTargetState.HomeScreen
                    }
                },
            )
            Crossfade(targetState = currentScreen) {
                when (it) {
                    GmailTargetState.HomeScreen -> HomeScreen()
                    GmailTargetState.SearchScreen -> SearchScreen()
                }
            }
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
