package app.prachang.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/*val DefaultFontFamily = FontFamily(
    // Font(R.font.regular),
    // Font(R.font.regular, FontWeight.Bold),

)*/

val Typography = Typography(
    // defaultFontFamily = DefaultFontFamily,
    body1 = TextStyle(
        fontFamily = FontFamily.Default, fontWeight = FontWeight.Normal, fontSize = 16.sp
    ), button = TextStyle(
        fontFamily = FontFamily.Default, fontWeight = FontWeight.W500, fontSize = 14.sp
    ), caption = TextStyle(
        fontFamily = FontFamily.Default, fontWeight = FontWeight.Normal, fontSize = 12.sp
    ), h3 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    ), h5 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
    ),
    subtitle1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    body2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Color.LightGray
    )
)