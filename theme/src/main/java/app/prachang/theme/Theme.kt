package app.prachang.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
)

private val LightColorPalette = lightColors(
    primary = White700,
    onPrimary = Black500,
    primaryVariant = White700,
    secondary = Teal200,
    background = White700,
    onBackground = Black500,
    surface = White500,
    onSurface = Black500,
)

@Composable
fun ComposeHubTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()

    val colors = if (darkTheme) {
        SideEffect {
            systemUiController.setSystemBarsColor(color = Color.Transparent)
        }
        DarkColorPalette
    } else {
        SideEffect {
            systemUiController.setSystemBarsColor(color = White700)
        }
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}