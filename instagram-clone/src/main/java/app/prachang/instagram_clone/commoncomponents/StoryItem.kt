package app.prachang.instagram_clone.commoncomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.components.CircleImage
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.common_compose_ui.modifiers.diagonalGradientBorder
import app.prachang.dummy_data.instagram.Post

@Composable
internal fun StoryItem(
    post: Post
) {
    Column {
        CircleImage(
            modifier = Modifier
                .size(70.dp)
                .diagonalGradientBorder(
                    borderSize = 1.5.dp,
                    colors = listOf(
                        Color(0xFFd71069),
                        Color(0xFFe25d6a),
                        Color(0xFFe9ad55),
                    ),
                    shape = CircleShape,
                    isFromRight = true
                )
                .padding(5.dp),
            url = post.userImage,
        )
        Height(4)
        Text(
            modifier = Modifier.width(70.dp),
            text = post.username,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            ),
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}