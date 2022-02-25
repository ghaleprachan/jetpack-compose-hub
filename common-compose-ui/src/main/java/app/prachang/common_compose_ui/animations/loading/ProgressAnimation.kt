package app.prachang.common_compose_ui.animations.loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun ProgressAnimation(modifier: Modifier) {
    val dots = listOf(
        remember { Animatable(0f) },
        remember { Animatable(0f) },
        remember { Animatable(0f) },
    )

    val animationSpec = infiniteRepeatable<Float>(
        animation = keyframes {
            durationMillis = 2000
            0.0f at 0 with LinearOutSlowInEasing // for 0-15 ms
            1.0f at 200 with LinearOutSlowInEasing // for 15-75 ms
            0.0f at 400 with LinearOutSlowInEasing // for 0-15 ms
            0.0f at 2000
        },
        repeatMode = RepeatMode.Restart,
    )

    dots.forEachIndexed { index, animatable ->
        LaunchedEffect(animatable) {
            delay(index * 100L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = animationSpec,
            )
        }
    }

    val dys = dots.map { it.value }

    val travelDistance = with(LocalDensity.current) { 15.dp.toPx() }

    Row(
        modifier
            .height(90.dp)
            .wrapContentHeight(align = Alignment.CenterVertically)
    ) {
        dys.forEachIndexed { index, dy ->
            Box(
                Modifier
                    .size(25.dp)
                    .graphicsLayer {
                        translationY = -dy * travelDistance
                    },
            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(color = Color.White, shape = CircleShape)
                )
            }

            if (index != dys.size - 1) {
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }

}