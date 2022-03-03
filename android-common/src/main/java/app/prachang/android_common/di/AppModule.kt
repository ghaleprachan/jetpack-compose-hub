package app.prachang.android_common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun getCoroutineScope(): CoroutineScope = CoroutineScope(Dispatchers.Main + Job())

    @Singleton
    @Provides
    fun getDispatcher(): CoroutineDispatcher = Dispatchers.IO
}