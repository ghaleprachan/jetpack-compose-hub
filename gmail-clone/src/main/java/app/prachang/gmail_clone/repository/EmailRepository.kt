package app.prachang.gmail_clone.repository

import app.prachang.android_common.apputils.SuccessState
import app.prachang.android_common.apputils.LoadResults
import app.prachang.dummy_data.data.dao.GmailDao
import app.prachang.dummy_data.gmail.MailsDataTable
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay

interface EmailRepository {
    suspend fun getEmails(): LoadResults<List<MailsDataTable>>
}

class EmailRepositoryImpl(
    private val dao: GmailDao,
    private val dispatcher: CoroutineDispatcher,
) : EmailRepository {
    override suspend fun getEmails(): LoadResults<List<MailsDataTable>> {
        return SuccessState(data = dao.getAllEmails())
    }
}