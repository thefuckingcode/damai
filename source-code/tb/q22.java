package tb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.analytics.utils.Logger;
import java.io.File;
import java.io.FileFilter;

/* compiled from: Taobao */
public class q22 extends SQLiteOpenHelper {
    private SQLiteDatabase a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements FileFilter {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public boolean accept(File file) {
            return file.getName().startsWith(this.a);
        }
    }

    public q22(Context context, String str) {
        super(context, str, null, 2, null);
    }

    private void b(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    private synchronized void c() {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
            this.a = null;
        }
    }

    private static boolean d(File file) {
        if (file == null) {
            return false;
        }
        boolean delete = file.delete() | false | new File(file.getPath() + "-journal").delete() | new File(file.getPath() + "-shm").delete() | new File(file.getPath() + "-wal").delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            File[] listFiles = parentFile.listFiles(new a(file.getName() + "-mj"));
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    delete |= file2.delete();
                }
            }
        }
        return delete;
    }

    public void a() {
        getWritableDatabase();
        c();
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        try {
            if (this.a == null) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.a = writableDatabase;
                boolean isDatabaseIntegrityOk = writableDatabase.isDatabaseIntegrityOk();
                Logger.f("SQLiteCheckHelper", "isDatabaseIntegrityOk", Boolean.valueOf(isDatabaseIntegrityOk));
                if (!isDatabaseIntegrityOk) {
                    Logger.i("SQLiteCheckHelper", "delete Database", Boolean.valueOf(d(new File(this.a.getPath()))));
                }
                Logger.f("SQLiteCheckHelper", "WritableDatabase", this.a);
            }
        } catch (Throwable th) {
            Logger.v("TAG", "e", th);
        }
        return this.a;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
        } catch (Throwable unused) {
        }
        b(cursor);
        super.onOpen(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
