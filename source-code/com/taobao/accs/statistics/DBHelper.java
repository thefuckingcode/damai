package com.taobao.accs.statistics;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
public class DBHelper extends SQLiteOpenHelper {
    private static final int MAX_DB_COUNT = 4000;
    private static final int MAX_SQL_NUM = 5;
    private static final String TAG = "DBHelper";
    private static final Lock lock = new ReentrantLock();
    private static volatile DBHelper sInstance;
    LinkedList<SQLObject> cachedSql = new LinkedList<>();
    public int curLogsCount = 0;
    private Context mContext;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class SQLObject {
        Object[] args;
        String sql;

        private SQLObject(String str, Object[] objArr) {
            this.sql = str;
            this.args = objArr;
        }
    }

    private DBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.mContext = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r2 != null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        if (0 == 0) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        return false;
     */
    private synchronized boolean checkTrafficsExist(String str, String str2, String str3, boolean z, long j, String str4) {
        Cursor cursor = null;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            cursor = writableDatabase.query("traffic", new String[]{"_id", "date", "host", "serviceid", "bid", "isbackground", "size"}, "date=? AND host=? AND bid=? AND isbackground=?", new String[]{str4, str, str3, String.valueOf(z)}, null, null, null, String.valueOf(100));
            if (cursor != null && cursor.getCount() > 0) {
                cursor.close();
                return true;
            }
        } catch (Exception e) {
            ALog.w(TAG, e.toString(), new Object[0]);
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private synchronized void execSQL(String str, Object[] objArr, boolean z) {
        try {
            this.cachedSql.add(new SQLObject(str, objArr));
            if (this.cachedSql.size() > 5 || z) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    while (true) {
                        try {
                            if (this.cachedSql.size() <= 0) {
                                break;
                            }
                            SQLObject removeFirst = this.cachedSql.removeFirst();
                            Object[] objArr2 = removeFirst.args;
                            if (objArr2 != null) {
                                writableDatabase.execSQL(removeFirst.sql, objArr2);
                            } else {
                                writableDatabase.execSQL(removeFirst.sql);
                            }
                            if (removeFirst.sql.contains("INSERT")) {
                                int i = this.curLogsCount + 1;
                                this.curLogsCount = i;
                                if (i > 4000) {
                                    ALog.d(TAG, "db is full!", new Object[0]);
                                    onUpgrade(writableDatabase, 0, 1);
                                    this.curLogsCount = 0;
                                    break;
                                }
                            }
                        } finally {
                            writableDatabase.close();
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            ALog.d(TAG, e.toString(), new Object[0]);
        }
        return;
    }

    public static DBHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DBHelper.class) {
                if (sInstance == null) {
                    sInstance = new DBHelper(context, Constants.DB_NAME, null, 3);
                }
            }
        }
        return sInstance;
    }

    public void clearTraffics() {
        execSQL("DELETE FROM traffic", null, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d5  */
    public List<TrafficsMonitor.TrafficInfo> getTraffics(boolean z) {
        Throwable th;
        Exception e;
        Cursor cursor;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor2 = null;
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return null;
                }
                if (z) {
                    cursor = writableDatabase.query("traffic", new String[]{"_id", "date", "host", "serviceid", "bid", "isbackground", "size"}, "date=?", new String[]{UtilityImpl.formatDay(System.currentTimeMillis())}, null, null, null, String.valueOf(100));
                } else {
                    cursor = writableDatabase.query("traffic", new String[]{"_id", "date", "host", "serviceid", "bid", "isbackground", "size"}, null, null, null, null, null, String.valueOf(100));
                }
                if (cursor == null) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    if (cursor.moveToFirst()) {
                        do {
                            String string = cursor.getString(1);
                            String string2 = cursor.getString(2);
                            String string3 = cursor.getString(3);
                            String string4 = cursor.getString(4);
                            boolean booleanValue = Boolean.valueOf(cursor.getString(5)).booleanValue();
                            long j = cursor.getLong(6);
                            if (string4 != null && j > 0) {
                                arrayList.add(new TrafficsMonitor.TrafficInfo(string, string4, string3, booleanValue, string2, j));
                            }
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                } catch (Exception e2) {
                    cursor2 = cursor;
                    e = e2;
                    try {
                        ALog.w(TAG, e.toString(), new Object[0]);
                        if (cursor2 != null) {
                        }
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    cursor2 = cursor;
                    th = th3;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
                return arrayList;
            } catch (Exception e3) {
                e = e3;
                ALog.w(TAG, e.toString(), new Object[0]);
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayList;
            }
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        if (!AdapterUtilityImpl.checkIsWritable(super.getWritableDatabase().getPath(), 102400)) {
            return null;
        }
        return super.getWritableDatabase();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            Lock lock2 = lock;
            if (lock2.tryLock()) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traffic(_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, host TEXT,serviceid TEXT, bid TEXT, isbackground TEXT, size TEXT)");
            }
            lock2.unlock();
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public void onTraffics(String str, String str2, String str3, boolean z, long j, String str4) {
        if (!checkTrafficsExist(str, str2, str3, z, j, str4)) {
            execSQL("INSERT INTO traffic VALUES(null,?,?,?,?,?,?)", new Object[]{str4, str, str2, str3, String.valueOf(z), Long.valueOf(j)}, true);
            return;
        }
        execSQL("UPDATE traffic SET size=? WHERE date=? AND host=? AND bid=? AND isbackground=?", new Object[]{Long.valueOf(j), str4, str, str3, String.valueOf(z)}, true);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS service");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS network");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ping");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS election");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindApp");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindUser");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS traffic");
            onCreate(sQLiteDatabase);
        }
    }
}
