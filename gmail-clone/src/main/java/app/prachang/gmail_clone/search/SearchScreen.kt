@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.gmail_clone.search

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.delay

@Composable
fun SearchScreen(focusRequester: FocusRequester) {
    LaunchedEffect(key1 = true, block = {
        /*awaitFrame()
        focusRequester.requestFocus()*/
    })
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Search Emails")
    }
}