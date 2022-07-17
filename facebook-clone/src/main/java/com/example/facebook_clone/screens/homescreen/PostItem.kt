package com.example.facebook_clone.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.components.ComposeImage
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.common_compose_ui.extensions.Width
import app.prachang.dummy_data.facebook.FacebookDataModel
import com.example.facebook_clone.FacebookConstants

@Composable
internal fun PostItem(post: FacebookDataModel) {
    val horizontalPadding = 8.dp
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(vertical = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = horizontalPadding)
        ) {
            ComposeImage(
                url = post.profile,
                modifier = Modifier
                    .size(35.dp)
                    .clip(shape = CircleShape)
            )
            Width(width = 16.dp)
            Column {
                Text(
                    text = post.name,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                )
                Text(text = post.time, fontSize = 12.sp, fontWeight = FontWeight.Light)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.End)
            ) {
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreHoriz,
                        contentDescription = null,
                        tint = Color.DarkGray,
                    )
                }
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color.DarkGray,
                    )
                }
            }
        }
        Height(height = 12.dp)
        Text(
            text = post.postDescription,
            modifier = Modifier.padding(horizontal = horizontalPadding),
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Light),
        )
        Height(height = 8.dp)
        ComposeImage(
            url = post.postImage,
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 200.dp),
        )
        // todo
        Height(height = 16.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = post.likes, color = Color.Gray)
            Text(text = post.comments, color = Color.Gray)
            Text(text = post.shares, color = Color.Gray)
        }
        // Text(text = "Like numbers")
        Height(height = 12.dp)
        Divider()
        Height(height = 8.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PostActionItem(imageVector = Icons.Outlined.ThumbUp, label = "Like")
            PostActionItem(imageVector = Icons.Outlined.Message, label = "Comment")
            PostActionItem(imageVector = Icons.Outlined.Share, label = "Share")
        }
    }
}


@Composable
private fun PostActionItem(imageVector: ImageVector, label: String) {
    Row(
        modifier = Modifier
            .clip(shape = CircleShape)
            .clickable {

            }
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(imageVector = imageVector, contentDescription = null, tint = Color.Gray)
        Text(text = label, fontSize = 16.sp, color = Color.Gray)
    }
}