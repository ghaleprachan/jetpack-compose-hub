package com.example.facebook_clone.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.prachang.common_compose_ui.components.ComposeImage

@Composable
internal fun StoryContent() {
    LazyRow(
        modifier = Modifier.background(Color.White),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(12.dp),
        content = {
            items(12) {
                StoryItem()
            }
        },
    )
}

@Composable
private fun StoryItem() {
    ComposeImage(
        url = "https://i.pinimg.com/originals/be/df/ca/bedfca592358f163d455f891f81cee6d.jpg",
        modifier = Modifier
            .size(width = 120.dp, height = 190.dp)
            .clip(shape = RoundedCornerShape(12.dp)),
    )
}