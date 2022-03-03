package app.prachang.dummy_data.data.database;

import android.util.Log;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import app.prachang.dummy_data.gmail.MailsData;
import app.prachang.dummy_data.gmail.MailsDataTable;

@androidx.room.Database(entities = {app.prachang.dummy_data.gmail.MailsDataTable.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00062\u00020\u00012\u00020\u0002:\u0001\u0006B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0007"}, d2 = {"Lapp/prachang/dummy_data/data/database/AppRoomDatabase;", "Landroidx/room/RoomDatabase;", "Lapp/prachang/dummy_data/data/database/AppDatabase;", "()V", "clearDatabase", "", "Companion", "dummy-data_debug"})
public abstract class AppRoomDatabase extends androidx.room.RoomDatabase implements app.prachang.dummy_data.data.database.AppDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final app.prachang.dummy_data.data.database.AppRoomDatabase.Companion Companion = null;
    
    public AppRoomDatabase() {
        super();
    }
    
    public final void clearDatabase() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a8\u0006\t"}, d2 = {"Lapp/prachang/dummy_data/data/database/AppRoomDatabase$Companion;", "", "()V", "onCreate", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "database", "Lapp/prachang/dummy_data/data/database/AppRoomDatabase;", "dummy-data_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void onCreate(@org.jetbrains.annotations.NotNull()
        kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.Nullable()
        app.prachang.dummy_data.data.database.AppRoomDatabase database) {
        }
    }
}