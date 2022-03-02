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
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lapp/prachang/dummy_data/di/StorageModule;", "", "()V", "provideRoomDatabase", "Lapp/prachang/dummy_data/data/database/AppRoomDatabase;", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dummy-data_debug"})
@dagger.Module()
public final class StorageModule {
    @org.jetbrains.annotations.NotNull()
    public static final app.prachang.dummy_data.di.StorageModule INSTANCE = null;
    
    private StorageModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final app.prachang.dummy_data.data.database.AppRoomDatabase provideRoomDatabase(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
        return null;
    }
}