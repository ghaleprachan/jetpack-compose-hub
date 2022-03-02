package app.prachang.dummy_data.data.dao;

import androidx.room.Dao;
import androidx.room.Query;
import app.prachang.dummy_data.gmail.MailsDataTable;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lapp/prachang/dummy_data/data/dao/GmailDao;", "Lapp/prachang/dummy_data/data/dao/BaseDao;", "Lapp/prachang/dummy_data/gmail/MailsDataTable;", "()V", "getAllEmails", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dummy-data_debug"})
public abstract class GmailDao extends app.prachang.dummy_data.data.dao.BaseDao<app.prachang.dummy_data.gmail.MailsDataTable> {
    
    public GmailDao() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM emails_table")
    public abstract java.lang.Object getAllEmails(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<app.prachang.dummy_data.gmail.MailsDataTable>> continuation);
}