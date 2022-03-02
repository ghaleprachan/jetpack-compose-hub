package app.prachang.composehub

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ComposeHubApp : Application() {
    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}