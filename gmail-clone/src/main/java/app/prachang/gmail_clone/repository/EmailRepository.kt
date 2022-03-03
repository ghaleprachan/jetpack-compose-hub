package app.prachang.gmail_clone.repository

import app.prachang.android_common.apputils.Success
import app.prachang.android_common.apputils.UiStates
import app.prachang.dummy_data.data.dao.GmailDao
import app.prachang.dummy_data.gmail.MailsDataTable
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay

interface EmailRepository {
    suspend fun getEmails(): UiStates<List<MailsDataTable>>
}

class EmailRepositoryImpl(
    private val dao: GmailDao,
    private val dispatcher: CoroutineDispatcher,
) : EmailRepository {
    override suspend fun getEmails(): UiStates<List<MailsDataTable>> {
        delay(3000)
        return Success(data = dao.getAllEmails())
    }
}