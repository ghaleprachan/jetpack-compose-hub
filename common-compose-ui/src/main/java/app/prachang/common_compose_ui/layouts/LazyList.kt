package app.prachang.common_compose_ui.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * From
 *
 * [Github repository for more](https://github.com/ghaleprachan/jetpack-compose-hub)
 * */

fun LazyListScope.itemSpacing(space: Dp) {
    item {
        Spacer(
            Modifier
                .height(space)
                .fillParentMaxWidth()
        )
    }
}

fun <T : Any> LazyListScope.itemsInGrid(
    items: List<T>,
    columns: Int = 2,
    contentPadding: PaddingValues = PaddingValues(),
    horizontalItemPadding: Dp = 0.dp,
    verticalItemPadding: Dp = 0.dp,
    content: @Composable LazyItemScope.(T?) -> Unit
) {
    val rows = when {
        items.size % columns == 0 -> {
            items.size / columns
        }
        else -> {
            (items.size / columns) + 1
        }
    }
    for (row in 0 until rows) {
        if (row == 0) itemSpacing(contentPadding.calculateTopPadding())
        item {
            val layoutDirection = LocalLayoutDirection.current
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = contentPadding.calculateStartPadding(layoutDirection),
                        end = contentPadding.calculateEndPadding(layoutDirection)
                    )
            ) {
                for (column in 0 until columns) {
                    Box(modifier = Modifier.weight(1f)) {
                        val index = (row * columns) + column
                        if (index < items.size) {
                            content(items[index])
                        }
                    }
                    if (column < columns - 1) {
                        Spacer(modifier = Modifier.width(horizontalItemPadding))
                    }
                }
            }
        }

        if (row < rows - 1) {
            itemSpacing(verticalItemPadding)
        } else {
            itemSpacing(contentPadding.calculateBottomPadding())
        }
    }
}