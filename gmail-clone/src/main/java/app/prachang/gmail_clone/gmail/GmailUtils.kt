package app.prachang.gmail_clone.gmail

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.focus.FocusRequester

data class GmailScrolls(
    val emailScroll: LazyListState,
    val searchFocus: FocusRequester = FocusRequester(),
)