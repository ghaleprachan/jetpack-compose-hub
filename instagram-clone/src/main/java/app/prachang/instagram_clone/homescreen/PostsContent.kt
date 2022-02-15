package app.prachang.instagram_clone.homescreen

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.animations.AnimateIcon
import app.prachang.common_compose_ui.animations.DoubleTapLikeAnim
import app.prachang.common_compose_ui.animations.AnimationState
import app.prachang.common_compose_ui.animations.ExpandableText
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.common_compose_ui.extensions.Width
import app.prachang.dummy_data.instagram.Post
import app.prachang.dummy_data.instagram.kotlinIcon
import app.prachang.instagram_clone.R
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.OriginalSize

/**
 *  Here update post image using pager and other UI improvements
 *
 *  Also add previews todo
 *  */
@Composable
fun PostItem(post: Post) {
    val context = LocalContext.current
    val profilePainter = rememberImagePainter(data = post.userImage)
    val postImage = rememberImagePainter(
        data = post.postImage[0],
        builder = {
            size(OriginalSize)
        },
    )
    Column {
        // Post Content With UserProfile, Username and More-Option Icon
        // Have to add more option action todo(ghaleprachan)
        PostTopContent(
            profilePainter = profilePainter, post = post
        )
        Height(height = 6.dp)

        var isLiked by remember {
            mutableStateOf(false)
        }

        // PostImage
        PostImage(
            postImage = postImage,
            onLike = {
                isLiked = true
            },
        )
        Height(height = 6.dp)

        // Post Like, Share, Comment, Saved and Post Description Section
        // Have to change like process here todo(ghaleprachan)
        PostLikeContent(
            post = post,
            isLiked = isLiked,
            onLike = {
                isLiked = !isLiked
            },
        )
        Height(height = 8.dp)

        // Post Comment count and add new comment section
        PostCommentContent(post = post)
    }
}


@Composable
private fun PostImage(
    postImage: Painter,
    onLike: () -> Unit,
) {
    var transitionState by remember {
        mutableStateOf(MutableTransitionState(AnimationState.Idle))
    }

    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = postImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 200.dp)
                .background(Color.LightGray)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            onLike()
                            transitionState = MutableTransitionState(AnimationState.Start)
                        },
                    )
                },
            contentScale = ContentScale.Crop
        )

        DoubleTapLikeAnim(
            transitionState = transitionState,
            color = Color.White,
            icon = Icons.Filled.Favorite
        )
    }
}

@Composable
private fun PostCommentContent(post: Post) {
    Text(
        modifier = Modifier.padding(horizontal = 12.dp),
        text = "View all ${post.commentCount} comments",
        style = TextStyle(
            color = Color.Gray, fontSize = 14.sp, fontWeight = FontWeight.SemiBold
        )
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
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
            text = "Write your comment...", style = TextStyle(
                fontSize = 13.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold
            )
        )
    }
    Text(
        modifier = Modifier.padding(horizontal = 12.dp), text = post.date, style = TextStyle(
            fontSize = 12.sp,
            color = Color.Gray,
        )
    )
}

@Composable
private fun PostLikeContent(
    post: Post,
    isLiked: Boolean,
    onLike: () -> Unit = {},
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        val props = if (isLiked) {
            Pair(Icons.Filled.Favorite, Color.Red)
        } else {
            Pair(Icons.Outlined.FavoriteBorder, Color.Black.copy(alpha = 0.8f))
        }
        AnimateIcon(
            prop = props,
            onClick = onLike,
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
        val savedProps = if (isSaved) {
            Pair(Icons.Filled.Bookmark, Color.Black)
        } else {
            Pair(Icons.Outlined.BookmarkBorder, Color.Black.copy(alpha = 0.8f))
        }
        AnimateIcon(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End),
            prop = savedProps,
            onClick = {
                isSaved = !isSaved
            },
        )
    }
    Text(
        text = post.getLikes(), style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold,
        ), modifier = Modifier.padding(start = 12.dp)
    )
    Height(height = 6)
    ExpandableText(
        modifier = Modifier.padding(horizontal = 12.dp),
        text = post.description.orEmpty(),
        minimumMaxLines = 3,
        textStyle = TextStyle(
            color = Color.DarkGray,
            fontSize = 14.sp,
        )
    )
}

@Composable
private fun PostTopContent(
    profilePainter: ImagePainter, post: Post
) {
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
        Width(width = 14.dp)
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
                Icons.Default.MoreVert, contentDescription = null
            )
        }
    }
}
