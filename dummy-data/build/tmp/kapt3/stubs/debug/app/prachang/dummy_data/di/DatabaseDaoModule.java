package app.prachang.dummy_data.di;

import android.content.Context;
import android.util.Log;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import app.prachang.dummy_data.data.database.AppRoomDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lapp/prachang/dummy_data/di/DatabaseDaoModule;", "", "()V", "provideGmailDao", "Lapp/prachang/dummy_data/data/dao/GmailDao;", "db", "Lapp/prachang/dummy_data/data/database/AppRoomDatabase;", "dummy-data_debug"})
@dagger.Module()
public final class DatabaseDaoModule {
    @org.jetbrains.annotations.NotNull()
    public static final app.prachang.dummy_data.di.DatabaseDaoModule INSTANCE = null;
    
    private DatabaseDaoModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final app.prachang.dummy_data.data.dao.GmailDao provideGmailDao(@org.jetbrains.annotations.NotNull()
    app.prachang.dummy_data.data.database.AppRoomDatabase db) {
        return null;
    }
}