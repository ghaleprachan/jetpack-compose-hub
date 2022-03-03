package app.prachang.dummy_data.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import app.prachang.dummy_data.gmail.MailsData;
import app.prachang.dummy_data.gmail.MailsDataTable;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GmailDao_Impl extends GmailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MailsDataTable> __insertionAdapterOfMailsDataTable;

  private final EntityDeletionOrUpdateAdapter<MailsDataTable> __deletionAdapterOfMailsDataTable;

  private final EntityDeletionOrUpdateAdapter<MailsDataTable> __updateAdapterOfMailsDataTable;

  public GmailDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMailsDataTable = new EntityInsertionAdapter<MailsDataTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `emails_table` (`id`,`sender`,`image`,`subTitle`,`body`,`dataTime`,`tags`,`isRead`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MailsDataTable value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getSender() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSender());
        }
        if (value.getImage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImage());
        }
        if (value.getSubTitle() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSubTitle());
        }
        if (value.getBody() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBody());
        }
        if (value.getDataTime() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDataTime());
        }
        if (value.getTags() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, __Tags_enumToString(value.getTags()));
        }
        final int _tmp = value.isRead() ? 1 : 0;
        stmt.bindLong(8, _tmp);
      }
    };
    this.__deletionAdapterOfMailsDataTable = new EntityDeletionOrUpdateAdapter<MailsDataTable>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `emails_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MailsDataTable value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfMailsDataTable = new EntityDeletionOrUpdateAdapter<MailsDataTable>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `emails_table` SET `id` = ?,`sender` = ?,`image` = ?,`subTitle` = ?,`body` = ?,`dataTime` = ?,`tags` = ?,`isRead` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MailsDataTable value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getSender() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSender());
        }
        if (value.getImage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImage());
        }
        if (value.getSubTitle() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSubTitle());
        }
        if (value.getBody() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBody());
        }
        if (value.getDataTime() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDataTime());
        }
        if (value.getTags() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, __Tags_enumToString(value.getTags()));
        }
        final int _tmp = value.isRead() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        if (value.getId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final MailsDataTable value, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMailsDataTable.insert(value);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insert(final List<? extends MailsDataTable> values,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMailsDataTable.insert(values);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object delete(final MailsDataTable value, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMailsDataTable.handle(value);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final MailsDataTable value, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfMailsDataTable.handle(value);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object getAllEmails(final Continuation<? super List<MailsDataTable>> arg0) {
    final String _sql = "SELECT * FROM emails_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<MailsDataTable>>() {
      @Override
      public List<MailsDataTable> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSender = CursorUtil.getColumnIndexOrThrow(_cursor, "sender");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subTitle");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfDataTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dataTime");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "isRead");
          final List<MailsDataTable> _result = new ArrayList<MailsDataTable>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MailsDataTable _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpSender;
            if (_cursor.isNull(_cursorIndexOfSender)) {
              _tmpSender = null;
            } else {
              _tmpSender = _cursor.getString(_cursorIndexOfSender);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final String _tmpSubTitle;
            if (_cursor.isNull(_cursorIndexOfSubTitle)) {
              _tmpSubTitle = null;
            } else {
              _tmpSubTitle = _cursor.getString(_cursorIndexOfSubTitle);
            }
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final String _tmpDataTime;
            if (_cursor.isNull(_cursorIndexOfDataTime)) {
              _tmpDataTime = null;
            } else {
              _tmpDataTime = _cursor.getString(_cursorIndexOfDataTime);
            }
            final MailsData.Tags _tmpTags;
            _tmpTags = __Tags_stringToEnum(_cursor.getString(_cursorIndexOfTags));
            final boolean _tmpIsRead;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRead);
            _tmpIsRead = _tmp != 0;
            _item = new MailsDataTable(_tmpId,_tmpSender,_tmpImage,_tmpSubTitle,_tmpBody,_tmpDataTime,_tmpTags,_tmpIsRead);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg0);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __Tags_enumToString(final MailsData.Tags _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case Email: return "Email";
      case Promotions: return "Promotions";
      case Social: return "Social";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private MailsData.Tags __Tags_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "Email": return MailsData.Tags.Email;
      case "Promotions": return MailsData.Tags.Promotions;
      case "Social": return MailsData.Tags.Social;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
