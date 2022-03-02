package app.prachang.dummy_data.data.database;

import app.prachang.dummy_data.data.dao.GmailDao;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lapp/prachang/dummy_data/data/database/AppDatabase;", "", "getGmailDao", "Lapp/prachang/dummy_data/data/dao/GmailDao;", "dummy-data_debug"})
public abstract interface AppDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract app.prachang.dummy_data.data.dao.GmailDao getGmailDao();
}