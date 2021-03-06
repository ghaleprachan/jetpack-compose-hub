package app.prachang.common_compose_ui.layouts

import android.util.Log
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

var recentX = 0
var recentY = 0
var rowCount = 0
val uni: () -> Unit = {}
private lateinit var composable: @Composable () -> Unit

@Composable
fun MyGrid(
    cells: GridCells.Fixed
) {
    /*val slotsPerLine = remember<Density.(Constraints) -> Int>(cells) {
        {
            cells.count
        }
    }*/
}

/**
 * -  val configuration = LocalConfiguration.current
 * -  val screenHeight = configuration.screenHeightDp.dp
 * -  val screenWidth = configuration.screenWidthDp.dp
 */
@Composable
fun Grid(
    modifier: Modifier = Modifier,
    image: String
) {
    Layout(
        modifier = modifier,
        content = {
            /*images.add(image)
            images.forEach {
                val painter = rememberImagePainter(data = it)
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .background(Color.Red),
                    contentScale = ContentScale.Crop
                )
            }*/
        },
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
            layout(
                constraints.maxWidth,
                constraints.minHeight.coerceAtMost(constraints.maxHeight)
            ) {
                placeables.forEach { placeable ->
                    val x = rowCount % 3
                    val y = (rowCount / 3.0).toInt()
                    rowCount += 1
                    placeable.placeRelative(x = x * (width), y = y * width)
                }
            }
        }
    )
}

fun <T> MutableList<T>.addUnique(value: T) {
    if (!this.contains(value)) {
        this.add(value)
    }
}

/**
 * A simple grid which lays elements out vertically in evenly sized [columns].
 */
@Composable
fun VerticalGrid(
    modifier: Modifier = Modifier,
    columns: Int = 2,
    content: @Composable () -> Unit,
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