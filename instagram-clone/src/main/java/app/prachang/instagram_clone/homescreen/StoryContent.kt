package app.prachang.instagram_clone.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.components.CircleImage
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.dummy_data.instagram.kotlinIcon
import app.prachang.dummy_data.instagram.myPosts
import app.prachang.instagram_clone.commoncomponents.StoryItem


@Preview(showSystemUi = true, device = Devices.NEXUS_6)
@Composable
private fun StoryContentPreview() {
    StoryContent()
}

@Composable
internal fun StoryContent() {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        content = {
            item {
                MyStoryItem()
            }
            items(myPosts.take(10)) { post ->
                StoryItem(post)
            }
        }
    )
}

@Preview
@Composable
private fun MyStoryItem() {
    Column {
        Box(contentAlignment = Alignment.BottomEnd) {
            CircleImage(
                modifier = Modifier
                    .size(70.dp)
                    .padding(5.dp),
                url = kotlinIcon,
            )
            Icon(
                Icons.Outlined.Add,
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .size(20.dp)
                    .clip(shape = CircleShape)
                    .background(Color(0xFF2196F3))
                    .border(width = 1.dp, color = Color.White, shape = CircleShape)
                    .padding(2.dp),
                tint = Color.White
            )
        }
        Height(4)
        Text(
            modifier = Modifier.width(70.dp),
            text = "Your story",
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
