package app.prachang.common_compose_ui.animations.loading

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.prachang.common_compose_ui.animations.AnimState
import kotlinx.coroutines.delay

@Composable
fun SpinKitLoading(
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colors.primary,
    spinKitHeight: SpinKitHeight = SpinKitHeight()
) {
    val state = remember { mutableStateOf(AnimState.StateIdle) }
    val animItems = animationItemsHeight(spinKitHeight = spinKitHeight, state = state)

    SpinKitLoading(
        modifier = modifier,
        state = state,
        maxHeight = spinKitHeight.maxHeight,
        color = tint,
        animItems = animItems
    )
}

@Composable
private fun SpinKitLoading(
    state: MutableState<AnimState>,
    modifier: Modifier,
    maxHeight: Dp,
    color: Color,
    animItems: List<State<Dp>>
) {
    LaunchedEffect(key1 = state.value, block = {
        updateAnimationState(state)
    })

    Box(
        modifier = modifier.height(maxHeight),
        contentAlignment = Alignment.Center,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            animItems.forEachIndexed { index, data ->
                Row {
                    Box(
                        modifier = Modifier
                            .width(8.dp)
                            .height(data.value)
                            .clip(shape = CircleShape)
                            .background(color)
                    )
                    if (index != animItems.lastIndex) {
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }
        }
    }
}

private suspend fun updateAnimationState(state: MutableState<AnimState>) {
    state.value = when (state.value) {
        AnimState.StateIdle -> {
            delay(150)
            AnimState.StateOne
        }
        AnimState.StateOne -> {
            delay(90)
            AnimState.StateTwo
        }
        AnimState.StateTwo -> {
            delay(70)
            AnimState.StateThree
        }
        AnimState.StateThree -> {
            delay(70)
            AnimState.StateFour
        }
        AnimState.StateFour -> {
            delay(90)
            AnimState.StateFive
        }
        AnimState.StateFive -> {
            delay(100)
            AnimState.StateIdle
        }
    }
}

data class SpinKitHeight(
    val minHeight: Dp = 30.dp,
    val maxHeight: Dp = 80.dp,
    val heightDiff: Dp = 10.dp,
)

@Composable
private fun animationItemsHeight(
    state: MutableState<AnimState>, spinKitHeight: SpinKitHeight
): List<State<Dp>> {
    val minHeight = spinKitHeight.minHeight
    val maxHeight = spinKitHeight.maxHeight
    val heightOne = maxHeight - spinKitHeight.heightDiff
    val heightTwo = heightOne - spinKitHeight.heightDiff

    return listOf(
        // First
        animateDpAsState(
            targetValue = when (state.value) {
                AnimState.StateIdle -> minHeight
                AnimState.StateOne -> maxHeight
                AnimState.StateTwo -> heightOne
                AnimState.StateThree -> heightTwo
                else -> minHeight
            },
        ),
        // Second
        animateDpAsState(
            targetValue = when (state.value) {
                AnimState.StateIdle -> minHeight
                AnimState.StateOne -> heightOne
                AnimState.StateTwo -> maxHeight
                AnimState.StateThree -> heightOne
                AnimState.StateFour -> heightTwo
                else -> minHeight
            },
        ),
        // Third
        animateDpAsState(
            targetValue = when (state.value) {
                AnimState.StateIdle -> minHeight
                AnimState.StateOne -> heightTwo
                AnimState.StateTwo -> heightOne
                AnimState.StateThree -> maxHeight
                AnimState.StateFour -> heightOne
                else -> minHeight
            },
        ),
        // Fourth
        animateDpAsState(
            targetValue = when (state.value) {
                AnimState.StateIdle -> minHeight
                AnimState.StateTwo -> heightTwo
                AnimState.StateThree -> heightOne
                AnimState.StateFour -> maxHeight
                AnimState.StateFive -> heightOne
                else -> minHeight
            },
        ),
        // Fifth
        animateDpAsState(
            targetValue = when (state.value) {
                AnimState.StateIdle -> minHeight
                AnimState.StateThree -> heightTwo
                AnimState.StateFour -> heightOne
                AnimState.StateFive -> maxHeight
                else -> minHeight
            },
        ),
    )
}


