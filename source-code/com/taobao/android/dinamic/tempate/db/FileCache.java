package com.taobao.android.dinamic.tempate.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.taobao.android.dinamic.tempate.db.Entry;
import java.io.File;
import tb.zt2;

/* compiled from: Taobao */
public class FileCache {
    private static final String h = FileEntry.SCHEMA.e();
    private static final String[] i = {String.format("sum(%s)", "size")};
    private static final String[] j = {"_id", "filename", "tag", "size"};
    private static final String k = String.format("%s ASC", "last_access");
    private final LruCache<String, b> a;
    private File b;
    private boolean c;
    private long d;
    private long e;
    private c f;
    private OnDeleteFileListener g;

    /* access modifiers changed from: private */
    @Entry.Table("file_cache")
    /* compiled from: Taobao */
    public static class FileEntry extends Entry {
        public static final a SCHEMA = new a(FileEntry.class);
        @Entry.Column(indexed = true, value = "hash_code")
        public long b;
        @Entry.Column("tag")
        public String c;
        @Entry.Column("filename")
        public String d;
        @Entry.Column("size")
        public long e;
        @Entry.Column(indexed = true, value = "last_access")
        public long f;

        /* compiled from: Taobao */
        public interface Columns extends Entry.Columns {
            public static final String FILENAME = "filename";
            public static final String HASH_CODE = "hash_code";
            public static final String LAST_ACCESS = "last_access";
            public static final String SIZE = "size";
            public static final String TAG = "tag";
        }

        private FileEntry() {
        }

        public String toString() {
            return "FileEntry{hashCode=" + this.b + ", tag='" + this.c + '\'' + ", filename='" + this.d + '\'' + ", size=" + this.e + ", lastAccess=" + this.f + '}';
        }
    }

    /* compiled from: Taobao */
    public interface OnDeleteFileListener {
        void afterDeleteFile();

        void beforeDeleteFile(File file);
    }

    /* compiled from: Taobao */
    public static final class b {
        private long a;
        public File b;

        private b(long j, String str, File file) {
            this.a = j;
            this.b = file;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class c extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;

        public c(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            FileEntry.SCHEMA.a(sQLiteDatabase);
            File[] listFiles = FileCache.this.b.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        Log.w("FileCache", "fail to remove: " + file.getAbsolutePath());
                    }
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            FileEntry.SCHEMA.c(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    public FileCache(Context context, File file, String str, long j2) {
        this(context, file, str, j2, 4);
    }

    private boolean b(File file) {
        if (file == null) {
            return true;
        }
        OnDeleteFileListener onDeleteFileListener = this.g;
        if (onDeleteFileListener != null) {
            try {
                onDeleteFileListener.beforeDeleteFile(file);
            } catch (Throwable th) {
                Log.e("FileCache", "before delete file action exception", th);
            }
        }
        boolean delete = file.delete();
        OnDeleteFileListener onDeleteFileListener2 = this.g;
        if (onDeleteFileListener2 == null) {
            return delete;
        }
        try {
            onDeleteFileListener2.afterDeleteFile();
            return delete;
        } catch (Throwable th2) {
            Log.e("FileCache", "after delete file action exception", th2);
            return delete;
        }
    }

    private void c(int i2) {
        Cursor query = this.f.getReadableDatabase().query(h, j, null, null, null, null, k);
        while (i2 > 0) {
            try {
                if (this.e <= this.d || !query.moveToNext()) {
                    break;
                }
                long j2 = query.getLong(0);
                String string = query.getString(1);
                String string2 = query.getString(2);
                long j3 = query.getLong(3);
                synchronized (this.a) {
                    if (this.a.get(string2) == null) {
                        i2--;
                        if (b(new File(this.b, string))) {
                            this.e -= j3;
                            this.f.getWritableDatabase().delete(h, "_id=?", new String[]{String.valueOf(j2)});
                        } else {
                            Log.w("FileCache", "unable to delete file: " + string);
                        }
                    }
                }
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051 A[DONT_GENERATE] */
    private FileEntry f(String str) {
        Cursor cursor;
        Throwable th;
        String[] strArr = {String.valueOf(zt2.b(str)), str};
        try {
            SQLiteDatabase readableDatabase = this.f.getReadableDatabase();
            String str2 = h;
            a aVar = FileEntry.SCHEMA;
            cursor = readableDatabase.query(str2, aVar.d(), "hash_code=? AND tag=?", strArr, null, null, null);
            try {
                if (!cursor.moveToNext()) {
                    cursor.close();
                    return null;
                }
                FileEntry fileEntry = new FileEntry();
                aVar.b(cursor, fileEntry);
                h(fileEntry.a);
                cursor.close();
                return fileEntry;
            } catch (Throwable th2) {
                th = th2;
                try {
                    Log.e("FileCache", "query database exception", th);
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            Log.e("FileCache", "query database exception", th);
            return null;
        }
    }

    private void h(long j2) {
        if (Build.VERSION.SDK_INT == 29) {
            try {
                i(this.f.getWritableDatabase(), h, "_id=?", String.valueOf(j2));
            } catch (Throwable th) {
                Log.e("FileCache", "sdk int 29 update db exception", th);
            }
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("last_access", Long.valueOf(System.currentTimeMillis()));
            try {
                this.f.getWritableDatabase().update(h, contentValues, "_id=?", new String[]{String.valueOf(j2)});
            } catch (Throwable th2) {
                Log.e("FileCache", "update db exception", th2);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private int i(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.acquireReference();
        try {
            StringBuilder sb = new StringBuilder(120);
            sb.append("UPDATE ");
            sb.append(str);
            sb.append(" SET ");
            sb.append("last_access=?");
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(sb.toString());
            compileStatement.bindLong(1, System.currentTimeMillis());
            compileStatement.bindString(2, str3);
            try {
                int executeUpdateDelete = compileStatement.executeUpdateDelete();
                compileStatement.close();
                return executeUpdateDelete;
            } catch (Throwable th) {
                compileStatement.close();
                throw th;
            }
        } finally {
            sQLiteDatabase.releaseReference();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        if (0 == 0) goto L_0x006d;
     */
    public synchronized void d() {
        if (!this.c) {
            this.c = true;
            if (!this.b.isDirectory()) {
                this.b.mkdirs();
                if (!this.b.isDirectory()) {
                    throw new RuntimeException("cannot create: " + this.b.getAbsolutePath());
                }
            }
            Cursor cursor = null;
            try {
                cursor = this.f.getReadableDatabase().query(h, i, null, null, null, null, null);
                if (cursor.moveToNext()) {
                    this.e = cursor.getLong(0);
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
            cursor.close();
            if (this.e > this.d) {
                c(16);
            }
        }
    }

    public b e(String str) {
        if (!this.c) {
            try {
                d();
            } catch (Exception e2) {
                Log.e("FileCache", "file cache init exception:", e2);
                return null;
            }
        }
        b bVar = this.a.get(str);
        if (bVar != null) {
            if (bVar.b.isFile()) {
                synchronized (this) {
                    h(bVar.a);
                }
                return bVar;
            }
            this.a.remove(str);
        }
        synchronized (this) {
            FileEntry f2 = f(str);
            if (f2 == null) {
                return null;
            }
            b bVar2 = new b(f2.a, str, new File(this.b, f2.d));
            if (!bVar2.b.isFile()) {
                try {
                    this.f.getWritableDatabase().delete(h, "_id=?", new String[]{String.valueOf(f2.a)});
                    this.e -= f2.e;
                } catch (Throwable th) {
                    Log.w("FileCache", "cannot delete entry: " + f2.d, th);
                }
                return null;
            }
            this.a.put(str, bVar2);
            return bVar2;
        }
    }

    public void g(String str, File file) {
        if (!this.c) {
            try {
                d();
            } catch (Exception e2) {
                Log.e("FileCache", "file cache init exception:", e2);
                return;
            }
        }
        zt2.a(file.getParentFile().equals(this.b));
        FileEntry fileEntry = new FileEntry();
        fileEntry.b = zt2.b(str);
        fileEntry.c = str;
        fileEntry.d = file.getName();
        fileEntry.e = file.length();
        fileEntry.f = System.currentTimeMillis();
        if (fileEntry.e < this.d) {
            synchronized (this) {
                FileEntry f2 = f(str);
                if (f2 != null) {
                    fileEntry.d = f2.d;
                    fileEntry.e = f2.e;
                } else {
                    this.e += fileEntry.e;
                }
                FileEntry.SCHEMA.f(this.f.getWritableDatabase(), fileEntry);
                if (this.e > this.d) {
                    c(16);
                }
            }
            return;
        }
        file.delete();
        throw new IllegalArgumentException("file too large: " + fileEntry.e);
    }

    public FileCache(Context context, File file, String str, long j2, int i2) {
        this.c = false;
        this.b = file;
        this.d = j2;
        this.a = new LruCache<>(i2);
        this.f = new c(context, str);
    }
}
