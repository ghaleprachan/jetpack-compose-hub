package app.prachang.theme.materialyoutheme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import app.prachang.theme.CustomColors
import com.google.accompanist.systemuicontroller.rememberSystemUiController

// Add dark theme support for email todo(ghaleprachan)
private val DarkColorScheme = darkColorScheme(
    primary = Color.Black,
    onPrimary = Color.White,
    primaryContainer = Color.Black,
    onPrimaryContainer = Color.White,
    secondary = CustomColors.LightBlack,
    onSecondary = Color.White,
    secondaryContainer = CustomColors.LightBlack,
    onSecondaryContainer = Color.White,
    background = Color.Black,
    onBackground = Color.White,
    surface = CustomColors.VeryLightBlack,
    onSurface = Color.White,
    inverseSurface = CustomColors.LightBlack,
    inverseOnSurface = Color.White,
    tertiary = CustomColors.LightBlack,
    onTertiary = Color.Black,
)

private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    onPrimary = Color.Black,
    primaryContainer = Color.White,
    onPrimaryContainer = Color.Black,
    secondary = CustomColors.LightBlue,
    onSecondary = Color.Black,
    secondaryContainer = CustomColors.LightBlue,
    onSecondaryContainer = Color.Black,
    background = Color.White,
    onBackground = Color.Black,
    surface = CustomColors.VeryLightBlue,
    onSurface = Color.Black,
    inverseSurface = CustomColors.LightBlue,
    inverseOnSurface = Color.Black,
    tertiary = CustomColors.LightBlue,
    onTertiary = Color.White,
)

@Composable
fun GmailTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    // val context = LocalContext.current
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content,
    )
}