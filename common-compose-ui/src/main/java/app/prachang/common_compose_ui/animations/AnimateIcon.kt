package app.prachang.common_compose_ui.animations

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

private const val springRatio = Spring.DampingRatioHighBouncy

@Composable
fun AnimateIcon(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    tint: Color = Color.Black,
    onClick: () -> Unit = {}
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
                AnimationState.Idle isTransitioningTo AnimationState.Start ->
                    spring(dampingRatio = springRatio)
                AnimationState.Start isTransitioningTo AnimationState.End ->
                    tween(200)
                else -> snap()
            }
        },
        label = ""
    ) { state ->
        when (state) {
            AnimationState.Idle -> 24.dp
            AnimationState.Start -> 12.dp
            AnimationState.End -> 24.dp
        }
    }
    IconButton(
        onClick = {
            onClick()
            transitionState = MutableTransitionState(AnimationState.Start)
        }
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = modifier.size(size = size),
            tint = tint
        )
    }
}