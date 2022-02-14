package app.prachang.common_compose_ui.animations

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntSize

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    text: String,
    minimumMaxLines: Int = 3
) {
    var textLayoutState by remember {
        mutableStateOf<TextLayoutResult?>(null)
    }

    var isExpanded by remember {
        mutableStateOf(false)
    }
    val seeMoreSizeState = remember { mutableStateOf<IntSize?>(null) }

    AnimatedContent(targetState = isExpanded,
        transitionSpec = {
            fadeIn() with
                    fadeOut() using
                    SizeTransform { initialSize, targetSize ->
                        if (targetState) {
                            keyframes {
                                // Expand horizontally first.
                                IntSize(targetSize.width, initialSize.height) at 150
                                durationMillis = 500
                            }
                        } else {
                            keyframes {
                                // Shrink vertically first.
                                IntSize(initialSize.width, targetSize.height) at 150
                                durationMillis = 500
                            }
                        }
                    }
        }
    ) { target ->
        Text(
            modifier = modifier.then(
                if ((textLayoutState?.lineCount ?: 0) >= 3)
                    Modifier.clickable {
                        isExpanded = !isExpanded
                    }
                else
                    Modifier
            ),
            text = text,
            maxLines = if (target) Int.MAX_VALUE else minimumMaxLines,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = { textLayoutState = it },
        )
    }
}

/*val annotatedString = buildAnnotatedString {
        append(text = text)
        if (target) {
            pushStringAnnotation(tag = "SeeMore", "SeeMoreHere")
            withStyle(
                style = SpanStyle(color = Color.Gray),
            ) {
                append("..See More")
            }
            pop()
        } else {
            pushStringAnnotation("SeeLess", "SeeLessHere")
            withStyle(
                style = SpanStyle(color = Color.Gray),
            ) {
                append("...See Less")
            }
            pop()
        }

    }
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                tag = "SeeMore",
                start = offset,
                end = offset
            ).let {
                isExpanded = true
            }
            annotatedString.getStringAnnotations(
                tag = "SeeLess",
                start = offset,
                end = offset
            ).let {
                isExpanded = false
            }
        },
        overflow = TextOverflow.Ellipsis,
        // maxLines = if (target) Int.MAX_VALUE else minimumMaxLines,
        onTextLayout = {
            textLayoutState = it
        }
    )*/


/*Text(
    modifier = modifier
        .background(Color.Green)
    *//*.then(
                if ((textLayoutState?.lineCount ?: 0) >= 3)
                    Modifier.clickable {
                        isExpanded = !isExpanded
                    }
                else
                    Modifier
            )*//*,
            text = text,
            maxLines = if (target) Int.MAX_VALUE else minimumMaxLines,
            onTextLayout = {
                textLayoutState = it
            },
            overflow = TextOverflow.Ellipsis
        )*/