package app.prachang.gmail_clone.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchScreen() {
    LazyColumn(content = {
        items(100) {
            ListItem {
                Text(text = "Label $it")
            }
        }
    })
}