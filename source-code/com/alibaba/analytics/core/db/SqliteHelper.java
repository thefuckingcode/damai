package com.alibaba.analytics.core.db;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.analytics.utils.Logger;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import tb.gj2;

/* compiled from: Taobao */
public class SqliteHelper extends SQLiteOpenHelper {
    private static boolean e;
    private static DatabaseErrorHandler f = new a();
    private AtomicInteger a = new AtomicInteger();
    private SQLiteDatabase b;
    private DelayCloseDbTask c = new DelayCloseDbTask();
    private Future<?> d;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class DelayCloseDbTask implements Runnable {
        DelayCloseDbTask() {
        }

        public void run() {
            synchronized (SqliteHelper.this) {
                if (SqliteHelper.this.a.get() == 0 && SqliteHelper.this.b != null) {
                    SqliteHelper.this.b.close();
                    SqliteHelper.this.b = null;
                }
            }
        }
    }

    /* compiled from: Taobao */
    static class a implements DatabaseErrorHandler {
        a() {
        }

        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            Logger.v("SqliteHelper", "DatabaseErrorHandler onCorruption");
            boolean unused = SqliteHelper.e = true;
        }
    }

    public SqliteHelper(Context context, String str) {
        super(context, str, null, 2, f);
    }

    public void e(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void f(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                if (this.a.decrementAndGet() == 0) {
                    Future<?> future = this.d;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.d = gj2.c().d(null, this.c, 30000);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        try {
            if (this.b == null) {
                if (e) {
                    return null;
                }
                this.b = super.getWritableDatabase();
            }
            this.a.incrementAndGet();
        } catch (Throwable th) {
            Logger.v("TAG", "e", th);
        }
        return this.b;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
        } catch (Throwable unused) {
        }
        e(cursor);
        super.onOpen(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
