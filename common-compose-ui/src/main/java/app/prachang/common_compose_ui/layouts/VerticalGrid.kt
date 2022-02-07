package app.prachang.common_compose_ui.layouts

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

var recentX = 0
var recentY = 0
var rowCount = 0

/**
 * 1. val configuration = LocalConfiguration.current
 * 2. val screenHeight = configuration.screenHeightDp.dp
 * 3. val screenWidth = configuration.screenWidthDp.dp
 */
@Composable
fun Grid(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = { content() },
        measurePolicy = { measurables, constraints ->
            val width = constraints.maxWidth / 3

            val placeables = measurables.map { measurable ->
                // Measure each children
                measurable.measure(constraints)
            }
            /*val columnHeights = Array(3) { 0 }
            placeables.forEachIndexed { index, placeable ->
                val column = index % 3
                columnHeights[column] += placeable.height
            }

            val height = (columnHeights.maxOrNull() ?: constraints.minHeight)
                .coerceAtMost(constraints.maxHeight)*/
            layout(constraints.maxWidth, 3000) {
                placeables.forEach { placeable ->
                    val x = rowCount % 3
                    val y = (rowCount / 3.0).toInt()
                    rowCount += 1
                    Log.e(
                        "PrachanGhale",
                        "$rowCount x = $x Place= ${x * width} ${y * width}"
                    )
                    placeable.placeRelative(x = x * (width), y = y * width)
                }
            }
        }
    )
}

/**
 * A simple grid which lays elements out vertically in evenly sized [columns].
 */
@Composable
fun VerticalGrid(
    modifier: Modifier = Modifier,
    columns: Int = 2,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val itemWidth = constraints.maxWidth / columns
        // Keep given height constraints, but set an exact width
        val itemConstraints = constraints.copy(
            minWidth = itemWidth,
            maxWidth = itemWidth
        )
        // Measure each item with these constraints
        val placeables = measurables.map { it.measure(itemConstraints) }
        // Track each columns height so we can calculate the overall height
        val columnHeights = Array(columns) { 0 }
        placeables.forEachIndexed { index, placeable ->
            val column = index % columns
            columnHeights[column] += placeable.height
        }
        val height = (columnHeights.maxOrNull() ?: constraints.minHeight)
            .coerceAtMost(constraints.maxHeight)
        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            // Track the Y co-ord per column we have placed up to
            val columnY = Array(columns) { 0 }
            placeables.forEachIndexed { index, placeable ->
                val column = index % columns
                Log.e("PrachanGhale ", "x = ${column * itemWidth} y = ${columnY[column]}")
                placeable.placeRelative(
                    x = column * itemWidth,
                    y = columnY[column]
                )
                columnY[column] += placeable.height
            }
        }
    }
}