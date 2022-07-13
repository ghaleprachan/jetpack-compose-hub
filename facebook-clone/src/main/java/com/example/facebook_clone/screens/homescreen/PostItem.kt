package com.example.facebook_clone.screens.homescreen

import android.provider.CalendarContract
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.components.ComposeImage
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.common_compose_ui.extensions.Width
import com.example.facebook_clone.FacebookConstants

@Composable
internal fun PostItem() {
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
                url = FacebookConstants.ProfileImage,
                modifier = Modifier
                    .size(35.dp)
                    .clip(shape = CircleShape)
            )
            Width(width = 16.dp)
            Column {
                Text(
                    text = "Prachan Ghale",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                )
                Text(text = "Just now", fontSize = 12.sp, fontWeight = FontWeight.Light)
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
            text = "Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.",
            modifier = Modifier.padding(horizontal = horizontalPadding),
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Light),
        )
        Height(height = 8.dp)
        ComposeImage(
            url = "https://wallpapershome.com/images/pages/pic_h/23277.jpg",
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
            Text(text = "400K", color = Color.Gray)
            Text(text = "235 Comments", color = Color.Gray)
            Text(text = "12 Shares", color = Color.Gray)
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