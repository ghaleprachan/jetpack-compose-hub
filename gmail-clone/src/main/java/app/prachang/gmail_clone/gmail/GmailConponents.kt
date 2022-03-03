@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.gmail_clone.gmail

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import app.prachang.common_compose_ui.animations.RotateIcon
import app.prachang.common_compose_ui.components.CircleImage
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.dummy_data.instagram.kotlinIcon
import app.prachang.theme.CustomColors
import app.prachang.theme.materialyoutheme.Material3Colors
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DrawerContent(
    modifier: Modifier = Modifier
) {
    val paddingStart = 20.dp
    val drawerItems = DrawerItems.values()

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = "Gmail",
            style = TextStyle(
                color = Color(0xFFFF5722),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
            ),
            modifier = Modifier.padding(start = paddingStart, top = 16.dp),
        )

        Height(height = 20.dp)
        Divider()

        DrawerItem("All Inboxes", Icons.Outlined.Image)

        Divider()
        drawerItems.forEach { item ->
            DrawerItem(title = item.label, icon = item.icon)
            when (item) {
                DrawerItems.Promotions -> {
                    Text(
                        text = "All Labels",
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = paddingStart)
                    )
                }
                DrawerItems.Bin -> {
                    Text(
                        text = "Google Apps",
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = paddingStart)
                    )
                }
                DrawerItems.Contacts -> {
                    Divider()
                }
                else -> {}
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DrawerItem(
    title: String,
    icon: ImageVector,
) {
    ListItem(
        icon = {
            Icon(imageVector = icon, contentDescription = null)
        },
        text = {
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
            )
        },
    )
}


@Composable
internal fun TopContent(
    modifier: Modifier = Modifier,
    searchValue: MutableState<String>,
    isEnabled: Boolean,
    onClick: () -> Unit,
    focusRequester: FocusRequester,
    onLeadingIconClick: () -> Unit = {},
    onProfileIconClick: () -> Unit = {},
) {
    val systemUiController = rememberSystemUiController()
    var icon by remember {
        mutableStateOf(Icons.Default.Menu)
    }
    LaunchedEffect(
        key1 = isEnabled,
        block = {
            delay(300)
            icon = if (isEnabled) Icons.Default.ArrowBack else Icons.Default.Menu
        },
    )
    val backgroundColor = animateColorAsState(
        targetValue = if (isEnabled) Material3Colors.surface else Material3Colors.primary
    )
    SideEffect {
        systemUiController.setSystemBarsColor(backgroundColor.value)
        systemUiController.setNavigationBarColor(CustomColors.VeryLightBlue)
    }

    Box(
        modifier = modifier
            .background(backgroundColor.value)
            .padding(
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
                IconButton(onClick = onLeadingIconClick) {
                    RotateIcon(
                        state = isEnabled,
                        icon = icon,
                        angle = 360F,
                        duration = 600,
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = onProfileIconClick) {
                    CircleImage(
                        url = kotlinIcon,
                        modifier = Modifier.size(30.dp),
                    )
                }
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
                cursorColor = Color.DarkGray,
                backgroundColor = Material3Colors.surface
            ),
        )
    }
}


@Composable
internal fun BottomNavBar(
    navigationItems: Array<BottomNavItems>, currentRoute: String?, navController: NavHostController
) {
    NavigationBar {
        navigationItems.forEach { bottomNavItem ->
            val isSelected = bottomNavItem.route == currentRoute
            val icon = if (isSelected) bottomNavItem.selectedIcon else bottomNavItem.unselectedIcon

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(route = bottomNavItem.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route)
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                label = {
                    Text(text = bottomNavItem.label)
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                    )
                },
            )
        }
    }
}
