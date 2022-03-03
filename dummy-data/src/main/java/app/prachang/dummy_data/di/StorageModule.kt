package app.prachang.dummy_data.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import app.prachang.dummy_data.data.dao.GmailDao
import app.prachang.dummy_data.data.database.AppRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object StorageModule {

    // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationComponent (i.e. everywhere in the application)
    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext context: Context,
        scope: CoroutineScope,
    ): AppRoomDatabase {
        var database: AppRoomDatabase? = null
        database = Room.databaseBuilder(context, AppRoomDatabase::class.java, "compose_hub.db")
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    AppRoomDatabase.onCreate(scope = scope, database = database)
                }
            })
            .fallbackToDestructiveMigration()
            .build()
        return database
    }

}

@InstallIn(SingletonComponent::class)
@Module
object DatabaseDaoModule {
    @Provides
    fun provideGmailDao(
        db: AppRoomDatabase
    ): GmailDao = db.getGmailDao()
}
