package app.prachang.dummy_data.instagram

import app.prachang.android_common.extensions.likeConversion

data class Profile(
    val userId: String,
    val name: String,
    val username: String,
    val image: String? = null,
    val totalPosts: String = "",
    val followerCount: String = "",
    val followingCount: String = "",
    val description: String? = null,
    val link: String? = null
)

data class SavedStory(
    val storyId: String,
    val image: String,
    val date: String?,
    val label: String? = null,
    val filterName: String? = null,
    val tags: List<String> = listOf("@testuser", "@cr7", "@messi")
)

data class Post(
    val postId: String,
    val username: String,
    val userImage: String,
    val date: String,
    val postImage: List<String>,
    val likes: Int = 0,
    val lastLikeBy: List<String> = emptyList(),
    val description: String? = null,
    val commentCount: Int? = 0,
) {
    fun getLikes() = "${likes.likeConversion()} likes"
}

data class PostComment(
    val commentId: String,
    val postId: String?,
    val comment: String,
    val username: String,
    val date: String,
    val commentLikes: Int = 0,
    val userImage: String? = null,
)