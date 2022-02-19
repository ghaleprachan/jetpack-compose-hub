package app.prachang.common_compose_ui.animations

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

private const val springRatio = Spring.DampingRatioHighBouncy

@Composable
fun AnimateIcon(
    modifier: Modifier = Modifier,
    prop: Pair<ImageVector, Color>,
    onClick: () -> Unit = {},
) {
    var transitionState by remember {
        mutableStateOf(MutableTransitionState(AnimationState.Idle))
    }
    if (transitionState.currentState == AnimationState.Start) {
        transitionState.targetState = AnimationState.End
    }
    val transition = updateTransition(transitionState = transitionState, label = "IconTransition")

    val size by transition.animateDp(
        transitionSpec = {
            when {
                AnimationState.Idle isTransitioningTo AnimationState.Start -> spring(dampingRatio = springRatio)
                AnimationState.Start isTransitioningTo AnimationState.End -> tween(200)
                else -> snap()
            }
        },
        label = "",
    ) { state ->
        when (state) {
            AnimationState.Idle -> 26.dp
            AnimationState.Start -> 16.dp
            AnimationState.End -> 26.dp
        }
    }
    IconButton(modifier = modifier, onClick = {
        onClick()
        transitionState = MutableTransitionState(AnimationState.Start)
    }) {
        Icon(
            prop.first,
            contentDescription = null,
            modifier = Modifier.size(size = size),
            tint = prop.second
        )
    }
}

@Composable
fun DoubleTapLikeAnim(
    modifier: Modifier = Modifier,
    color: Color,
    icon: ImageVector,
    transitionState: MutableTransitionState<AnimationState>
) {
    if (transitionState.currentState == AnimationState.Start) {
        transitionState.targetState = AnimationState.End
    }
    if (transitionState.currentState == AnimationState.End) {
        transitionState.targetState = AnimationState.Idle
    }
    val transition = updateTransition(
        transitionState = transitionState,
        label = "IconTransition",
    )

    val size by transition.animateDp(
        transitionSpec = {
            when {
                AnimationState.Idle isTransitioningTo AnimationState.Start -> tween(200)
                AnimationState.Start isTransitioningTo AnimationState.End -> spring(dampingRatio = springRatio)
                AnimationState.End isTransitioningTo AnimationState.Idle -> tween(100)
                else -> snap()
            }
        },
        label = "",
    ) { state ->
        when (state) {
            AnimationState.Idle -> 0.dp
            AnimationState.Start -> 100.dp
            AnimationState.End -> 80.dp
        }
    }

    Icon(
        icon,
        contentDescription = null,
        modifier = modifier
            .shadow(elevation = 40.dp)
            .size(size = size),
        tint = color,
    )
}
