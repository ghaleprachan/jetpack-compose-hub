package app.prachang.common_compose_ui.animations

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    text: String,
    minimumMaxLines: Int = 3
) {
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
            modifier = modifier
                .background(Color.Green)
                .clickable {
                    isExpanded = !isExpanded
                },
            text = text,
            maxLines = if (target) Int.MAX_VALUE else minimumMaxLines
        )
    }
}