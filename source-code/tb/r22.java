package tb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class r22 extends SQLiteOpenHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String Lock = "dblock";
    private final String a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r22(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i, @NotNull String str2) {
        super(context, str, cursorFactory, i);
        k21.i(str2, "mTableName");
        this.a = str2;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            k21.h(writableDatabase, "sqLiteDatabase");
            onCreate(writableDatabase);
            writableDatabase.close();
        } catch (Exception e) {
            vp.b("SQLiteHelper", e);
        }
    }

    public final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1791828227")) {
            ipChange.ipc$dispatch("1791828227", new Object[]{this});
            return;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.a);
        } catch (Exception e) {
            vp.b("SQLiteHelper", e);
        }
    }

    public final void c(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1495839849")) {
            ipChange.ipc$dispatch("1495839849", new Object[]{this, str});
            return;
        }
        k21.i(str, "key");
        synchronized (Lock) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = getWritableDatabase();
                sQLiteDatabase.delete(this.a, "key=?", new String[]{str});
                sQLiteDatabase.close();
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076  */
    @Nullable
    public final ie d(@NotNull String str) {
        Throwable th;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1924096009")) {
            return (ie) ipChange.ipc$dispatch("1924096009", new Object[]{this, str});
        }
        k21.i(str, "key");
        synchronized (Lock) {
            Cursor cursor = null;
            try {
                Cursor query = getReadableDatabase().query(this.a, new String[]{"value", "cacheTime"}, "key=?", new String[]{str}, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(0);
                        if (string == null || string.length() == 0) {
                            z = true;
                        }
                        if (z) {
                            query.close();
                            return null;
                        }
                        ie ieVar = new ie(str, string);
                        ieVar.f(query.getLong(1));
                        query.close();
                        return ieVar;
                    }
                    query.close();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050  */
    public final void e(@Nullable String str, @Nullable String str2) {
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1491110529")) {
            ipChange.ipc$dispatch("1491110529", new Object[]{this, str, str2});
            return;
        }
        synchronized (Lock) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("key", str);
                    contentValues.put("value", str2);
                    contentValues.put("cacheTime", Long.valueOf(System.currentTimeMillis()));
                    writableDatabase.insert(this.a, null, contentValues);
                    writableDatabase.close();
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = writableDatabase;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        }
    }

    public final void f(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886643345")) {
            ipChange.ipc$dispatch("1886643345", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "key");
        synchronized (Lock) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", str2);
                contentValues.put("cacheTime", Long.valueOf(System.currentTimeMillis()));
                sQLiteDatabase.update(this.a, contentValues, "key=?", new String[]{str});
                sQLiteDatabase.close();
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    public final void g(@Nullable String str, @Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906062475")) {
            ipChange.ipc$dispatch("-906062475", new Object[]{this, str, l});
        } else if (str != null && l != null) {
            synchronized (Lock) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    sQLiteDatabase = getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("cacheTime", l);
                    sQLiteDatabase.update(this.a, contentValues, "key=?", new String[]{str});
                    sQLiteDatabase.close();
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            }
        }
    }

    public void onCreate(@NotNull SQLiteDatabase sQLiteDatabase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1891950152")) {
            ipChange.ipc$dispatch("-1891950152", new Object[]{this, sQLiteDatabase});
            return;
        }
        k21.i(sQLiteDatabase, "db");
        sQLiteDatabase.execSQL("create table if not exists " + this.a + jl1.BRACKET_START_STR + "key varchar(128) primary key," + "value varchar(4096)," + "cacheTime long)");
    }

    public void onUpgrade(@NotNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834251948")) {
            ipChange.ipc$dispatch("1834251948", new Object[]{this, sQLiteDatabase, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        k21.i(sQLiteDatabase, "db");
        a();
        onCreate(sQLiteDatabase);
    }
}
