package app.prachang.instagram_clone.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.common_compose_ui.extensions.Width
import app.prachang.dummy_data.instagram.Post
import app.prachang.dummy_data.instagram.kotlinIcon
import app.prachang.theme.Typography
import coil.compose.rememberImagePainter
import coil.size.OriginalSize

/**
 *  Here update post image using pager and other UI improvements
 *
 *  Also add previews todo
 *  */
@Composable
fun PostItem(post: Post) {
    val profilePainter = rememberImagePainter(data = post.userImage)
    val postImage = rememberImagePainter(data = post.postImage[0], builder = {
        size(OriginalSize)
    })
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = profilePainter,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(shape = CircleShape)
                    .background(Color.Gray),
                contentScale = ContentScale.Crop
            )
            Width(width = 14)
            Text(
                text = post.username,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                ),
            )
            IconButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.End)
            ) {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = null
                )
            }
        }
        Height(height = 6)
        Image(
            painter = postImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Height(height = 6)
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { }) {
                Icon(Icons.Outlined.FavoriteBorder, contentDescription = null)
            }
            IconButton(onClick = { }) {
                Icon(Icons.Outlined.Comment, contentDescription = null)
            }
            IconButton(onClick = { }) {
                Icon(Icons.Outlined.Share, contentDescription = null)
            }
            IconButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.End)
            ) {
                Icon(Icons.Outlined.BookmarkBorder, contentDescription = null)
            }
        }
        Text(
            text = "${post.likes} likes",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
            ),
            modifier = Modifier.padding(start = 12.dp)
        )
        Height(height = 6)
        Text(
            text = "Unless you've made a change to your Instagram bio, it will appear in Instagram's default font, Neue Helvetica. This font is used for the majority of text within the app, such as captions and comments",
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 14.sp
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 3,
            modifier = Modifier.padding(
                horizontal = 12.dp
            )
        )
        Height(height = 8)
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = "View all ${post.commentCount} comments",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val myProfilePainter = rememberImagePainter(data = kotlinIcon)
            Image(
                painter = myProfilePainter,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
            )
            Text(
                text = "Write your comment...",
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = post.date,
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.Gray,
            )
        )
    }
}