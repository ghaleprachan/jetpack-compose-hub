package app.prachang.instagram_clone.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.animations.AnimateIcon
import app.prachang.common_compose_ui.animations.AnimateIconProp
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.common_compose_ui.extensions.Width
import app.prachang.dummy_data.instagram.Post
import app.prachang.dummy_data.instagram.kotlinIcon
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import app.prachang.instagram_clone.R

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
                .defaultMinSize(minHeight = 200.dp)
                .background(Color.LightGray),
            contentScale = ContentScale.Crop
        )
        Height(height = 6)
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            var isLiked by remember {
                mutableStateOf(false)
            }
            val iconProp = if (isLiked) {
                AnimateIconProp(
                    icon = Icons.Filled.Favorite,
                    color = Color.Red
                )
            } else {
                AnimateIconProp(
                    icon = Icons.Outlined.FavoriteBorder,
                    color = Color.Black.copy(alpha = 0.8f)
                )
            }
            AnimateIcon(
                prop = iconProp,
                onClick = {
                    isLiked = !isLiked
                }
            )

            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outlined_comment),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

            var isSaved by remember {
                mutableStateOf(false)
            }
            val savedIconProp = if (isSaved) {
                AnimateIconProp(
                    icon = Icons.Filled.Bookmark,
                    color = Color.Black
                )
            } else {
                AnimateIconProp(
                    icon = Icons.Outlined.BookmarkBorder,
                    color = Color.Black.copy(alpha = 0.8f)
                )
            }
            AnimateIcon(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.End),
                prop = savedIconProp,
                onClick = {
                    isSaved = !isSaved
                }
            )
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