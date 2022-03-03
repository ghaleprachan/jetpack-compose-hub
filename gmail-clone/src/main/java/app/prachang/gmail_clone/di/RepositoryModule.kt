package app.prachang.gmail_clone.di

import app.prachang.dummy_data.data.dao.GmailDao
import app.prachang.gmail_clone.repository.EmailRepository
import app.prachang.gmail_clone.repository.EmailRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun getRepository(
        gmailDao: GmailDao,
        dispatcher: CoroutineDispatcher,
    ): EmailRepository {
        return EmailRepositoryImpl(gmailDao, dispatcher)
    }
}