package app.prachang.dummy_data.data.dao

import androidx.room.Dao
import androidx.room.Query
import app.prachang.dummy_data.gmail.MailsDataTable

@Dao
abstract class GmailDao : BaseDao<MailsDataTable>() {
    @Query("""SELECT * FROM emails_table""")
    abstract suspend fun getAllEmails(): List<MailsDataTable>
}