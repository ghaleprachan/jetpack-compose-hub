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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.common_compose_ui.extensions.Width
import app.prachang.dummy_data.instagram.Post
import coil.compose.rememberImagePainter

/**
 *  Here update post image using pager and other UI improvements
 *
 *  Also add previews
 *  todo*/
@Composable
fun PostItem(post: Post) {
    val profilePainter = rememberImagePainter(data = post.userImage)
    val postImage = rememberImagePainter(data = post.postImage[0])
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
                .height(280.dp)
                .background(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Height(height = 6)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
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
    }
}