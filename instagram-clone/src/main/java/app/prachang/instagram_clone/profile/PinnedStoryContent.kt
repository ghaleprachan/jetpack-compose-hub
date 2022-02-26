package app.prachang.instagram_clone.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import app.prachang.dummy_data.instagram.myPosts
import app.prachang.instagram_clone.commoncomponents.StoryItem

@Composable
internal fun PinnedStoryContent() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(16.dp),
        content = {
            items(myPosts.subList(5, 12)) {
                StoryItem(post = it)
            }
        },
    )
}