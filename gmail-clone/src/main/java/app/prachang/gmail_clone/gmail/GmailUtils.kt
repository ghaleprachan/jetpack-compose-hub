package app.prachang.gmail_clone.gmail

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.focus.FocusRequester
import androidx.navigation.NavHostController

data class GmailUtils(
    val emailScrollState: LazyListState,
    val searchValue: MutableState<String>,
    val focusRequester: FocusRequester,
    val currentRoute: String?,
    val navController: NavHostController,
)