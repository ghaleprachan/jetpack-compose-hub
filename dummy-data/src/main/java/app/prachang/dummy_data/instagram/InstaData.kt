package app.prachang.dummy_data.instagram

import java.util.*

val profileData = Profile(
    userId = UUID.randomUUID().toString(),
    name = "Prachan Ghale",
    username = "g_prachan",
    image = null,
    followerCount = 233,
    followingCount = 325,
    description = null,
    link = null
)

val myPosts = listOf(
    Post(
        postId = UUID.randomUUID().toString(),
        username = "gprachan",
        userImage = "",
        date = "",
        postImage = listOf(),
        likes = 12,
        lastLikeBy = emptyList(),
        description = "",
        commentCount = 12,
    ),
)