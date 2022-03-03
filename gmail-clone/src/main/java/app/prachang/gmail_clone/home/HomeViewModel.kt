package app.prachang.gmail_clone.home

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.rememberNavController
import app.prachang.dummy_data.data.dao.GmailDao
import app.prachang.dummy_data.gmail.MailsDataTable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gmailDao: GmailDao
) : ViewModel() {

    private val _gmailList = MutableStateFlow<List<MailsDataTable>>(emptyList())
    val gmailList = _gmailList.asStateFlow()
    fun getGmail() = viewModelScope.launch {
        _gmailList.value = gmailDao.getAllEmails()
    }

}