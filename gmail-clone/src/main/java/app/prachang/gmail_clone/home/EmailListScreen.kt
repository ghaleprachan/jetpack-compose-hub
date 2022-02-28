package app.prachang.gmail_clone.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmailListScreen() {
    LazyColumn(content = {
        items(150) {
            ListItem {
                Text(text = "Item number $it")
            }
        }
    })
}