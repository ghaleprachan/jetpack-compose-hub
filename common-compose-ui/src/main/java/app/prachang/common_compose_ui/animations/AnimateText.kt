package app.prachang.common_compose_ui.animations

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntSize

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = LocalTextStyle.current,
    minimumMaxLines: Int = 3
) {
    var textLayoutState by remember {
        mutableStateOf<TextLayoutResult?>(null)
    }

    var isExpanded by remember {
        mutableStateOf(false)
    }

    AnimatedContent(targetState = isExpanded,
        transitionSpec = {
            fadeIn() with
                    fadeOut() using
                    SizeTransform { initialSize, targetSize ->
                        if (targetState) {
                            keyframes {
                                // Expand horizontally first.
                                IntSize(targetSize.width, initialSize.height) at 150
                                durationMillis = 300
                            }
                        } else {
                            keyframes {
                                // Shrink vertically first.
                                IntSize(initialSize.width, targetSize.height) at 150
                                durationMillis = 300
                            }
                        }
                    }
        }
    ) { target ->
        Text(
            modifier = modifier.clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null,
                enabled = (textLayoutState?.lineCount ?: 0) >= 3
            ) {
                isExpanded = !isExpanded
            },
            text = text,
            maxLines = if (target) Int.MAX_VALUE else minimumMaxLines,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = { textLayoutState = it },
            style = textStyle
        )
    }
}
