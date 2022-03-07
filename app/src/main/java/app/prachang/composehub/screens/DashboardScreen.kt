package app.prachang.composehub.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.prachang.composehub.SampleAppData
import app.prachang.composehub.screens.components.HomeTopContent
import app.prachang.composehub.screens.components.SampleItem


@Composable
internal fun DashboardScreen(
    onItemClick: (sample: SampleAppData.SampleApp) -> Unit
) {
    Scaffold(
        backgroundColor = Color(0xFFDFEDF3),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Compose Hub")
                },
            )
        },
        content = {
            LazyColumn(
                contentPadding = PaddingValues(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                content = {
                    item {
                        HomeTopContent()
                    }
                    itemsIndexed(SampleAppData.sampleApps) { _, sample ->
                        SampleItem(
                            sample = sample,
                            onItemClick = onItemClick,
                        )
                    }
                },
            )
        },
    )
}

