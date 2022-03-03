package app.prachang.composehub

import android.app.Application
import android.util.Log
import app.prachang.dummy_data.data.database.AppDatabase
import app.prachang.dummy_data.data.database.AppRoomDatabase
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltAndroidApp
class ComposeHubApp : Application() {
    @Inject
    lateinit var appDatabase: AppRoomDatabase

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}