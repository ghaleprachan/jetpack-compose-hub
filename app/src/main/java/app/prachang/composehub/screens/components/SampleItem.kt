package app.prachang.composehub.screens.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.prachang.common_compose_ui.extensions.Width
import app.prachang.composehub.SampleAppData
import app.prachang.theme.materialtheme.Typography


@Composable
internal fun SampleItem(
    sample: SampleAppData.SampleApp,
    onItemClick: (sample: SampleAppData.SampleApp) -> Unit = {},
) {
    val hasSubList = sample.subSamples.isNotEmpty()
    var expanded by remember {
        mutableStateOf(false)
    }
    val paddingHorizontal: Dp by animateDpAsState(targetValue = if (expanded) 0.dp else 22.dp)
    val corner: Dp by animateDpAsState(targetValue = if (expanded) 0.dp else 8.dp)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = paddingHorizontal)
            .clip(shape = RoundedCornerShape(corner))
            .shadow(elevation = 8.dp)
            .background(Color.White),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .clickable(
                    enabled = hasSubList,
                    indication = LocalIndication.current,
                    interactionSource = MutableInteractionSource()
                ) {
                    expanded = !expanded
                }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = sample.icon),
                contentDescription = null,
            )
            Width(width = 12.dp)
            Text(
                text = sample.label,
                style = Typography.h5,
            )
        }
        if (hasSubList) {
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(),
                exit = shrinkVertically(),
            ) {
                SampleSubItem(
                    sample = sample,
                    onItemClick = onItemClick,
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SampleSubItem(
    sample: SampleAppData.SampleApp,
    onItemClick: (sample: SampleAppData.SampleApp) -> Unit,
) {
    Column {
        sample.subSamples.forEach { subSample ->
            ListItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick.invoke(subSample)
                    }
                    .padding(start = 30.dp),
                secondaryText = {
                    Text(
                        text = subSample.description.orEmpty(),
                        style = Typography.body2,
                    )
                },
                icon = {
                    Image(
                        modifier = Modifier.size(40.dp),
                        painter = painterResource(id = subSample.icon),
                        contentDescription = null
                    )
                },
                text = {
                    Text(
                        text = subSample.label,
                        style = Typography.subtitle1.copy(color = Color.Gray),
                    )
                },
            )
        }
    }
}