package app.prachang.dummy_data.gmail;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lapp/prachang/dummy_data/gmail/MailsData;", "", "()V", "generateUrl", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "getGenerateUrl", "()Lkotlin/jvm/functions/Function1;", "mails", "", "Lapp/prachang/dummy_data/gmail/MailsDataTable;", "getMails", "()Ljava/util/List;", "Tags", "dummy-data_debug"})
public final class MailsData {
    @org.jetbrains.annotations.NotNull()
    public static final app.prachang.dummy_data.gmail.MailsData INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> generateUrl = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<app.prachang.dummy_data.gmail.MailsDataTable> mails = null;
    
    private MailsData() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> getGenerateUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<app.prachang.dummy_data.gmail.MailsDataTable> getMails() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lapp/prachang/dummy_data/gmail/MailsData$Tags;", "", "(Ljava/lang/String;I)V", "Email", "Promotions", "Social", "dummy-data_debug"})
    public static enum Tags {
        /*public static final*/ Email /* = new Email() */,
        /*public static final*/ Promotions /* = new Promotions() */,
        /*public static final*/ Social /* = new Social() */;
        
        Tags() {
        }
    }
}