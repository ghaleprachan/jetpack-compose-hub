package app.prachang.dummy_data.data.database

import android.util.Log
import androidx.room.Database
import androidx.room.RoomDatabase
import app.prachang.dummy_data.gmail.MailsData
import app.prachang.dummy_data.gmail.MailsDataTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [
        MailsDataTable::class
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppRoomDatabase : RoomDatabase(), AppDatabase {
    companion object {
        fun onCreate(scope: CoroutineScope, database: AppRoomDatabase?) {
            scope.launch {
                database?.getGmailDao()?.insert(MailsData.mails)
            }
        }
    }
}

/*autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]*/