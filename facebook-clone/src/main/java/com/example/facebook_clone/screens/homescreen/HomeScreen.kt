package com.example.facebook_clone.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.components.CircleImage
import com.example.facebook_clone.FacebookConstants
import com.example.facebook_clone.facebookthemes.FacebookColors

@Composable
internal fun HomeScreen() {
    HomeScreenContent()
}

@Composable
private fun HomeScreenContent() {
    Surface(
        color = FacebookColors.AlmostWhite,
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            content = {
                item {
                    AddPostItem()
                }
                item {
                    StoryContent()
                }
                items(14) {
                    PostItem()
                }
            },
        )
    }
}


@Composable
private fun AddPostItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 12.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CircleImage(
            modifier = Modifier.size(40.dp),
            url = FacebookConstants.ProfileImage,
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
                .clip(shape = CircleShape)
                .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
                .clickable {

                }
                .padding(start = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "What's on your mind?", color = Color.Gray, fontSize = 13.sp)
        }
    }
}

