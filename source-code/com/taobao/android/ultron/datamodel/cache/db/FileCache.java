package com.taobao.android.ultron.datamodel.cache.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import android.util.LruCache;
import com.taobao.android.ultron.datamodel.cache.db.Entry;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tb.au2;

/* compiled from: Taobao */
public class FileCache {
    private static final String f = FileEntry.SCHEMA.e();
    private final LruCache<String, b> a;
    private File b;
    private boolean c;
    private long d;
    private c e;

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
    public static final class b {
        private long a;
        public String b;
        public File c;

        private b(long j, String str, File file) {
            this.a = j;
            this.b = str;
            this.c = file;
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

    static {
        String.format("sum(%s)", "size");
    }

    public FileCache(Context context, File file, String str, long j) {
        this(context, file, str, j, 4);
    }

    private List<FileEntry> d() {
        Cursor cursor;
        Throwable th;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.e.getReadableDatabase().query(f, FileEntry.SCHEMA.d(), null, null, null, null, null);
            while (cursor.moveToNext()) {
                try {
                    FileEntry fileEntry = new FileEntry();
                    FileEntry.SCHEMA.b(cursor, fileEntry);
                    i(fileEntry.a);
                    arrayList.add(fileEntry);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        Log.e("FileCache", "query database exception", th);
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            Log.e("FileCache", "query database exception", th);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051 A[DONT_GENERATE] */
    private FileEntry g(String str) {
        Cursor cursor;
        Throwable th;
        String[] strArr = {String.valueOf(au2.b(str)), str};
        try {
            SQLiteDatabase readableDatabase = this.e.getReadableDatabase();
            String str2 = f;
            a aVar = FileEntry.SCHEMA;
            cursor = readableDatabase.query(str2, aVar.d(), "hash_code=? AND tag=?", strArr, null, null, null);
            try {
                if (!cursor.moveToNext()) {
                    cursor.close();
                    return null;
                }
                FileEntry fileEntry = new FileEntry();
                aVar.b(cursor, fileEntry);
                i(fileEntry.a);
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

    private void i(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_access", Long.valueOf(System.currentTimeMillis()));
        try {
            this.e.getWritableDatabase().update(f, contentValues, "_id=?", new String[]{String.valueOf(j)});
        } catch (Exception e2) {
            Log.e("FileCache", "update db exception", e2);
        }
    }

    public void b(String str) {
        synchronized (this) {
            FileEntry g = g(str);
            if (g != null) {
                b bVar = new b(g.a, str, new File(this.b, g.d));
                try {
                    this.e.getWritableDatabase().delete(f, "_id=?", new String[]{String.valueOf(g.a)});
                } catch (Throwable th) {
                    Log.w("FileCache", "cannot delete db entry: " + g.d, th);
                }
                try {
                    bVar.c.delete();
                } catch (Throwable th2) {
                    Log.w("FileCache", "cannot delete file: " + g.d, th2);
                }
            }
        }
    }

    public List<b> c() {
        if (!this.c) {
            try {
                e();
            } catch (Exception e2) {
                Log.e("FileCache", "file cache init exception:", e2);
                return null;
            }
        }
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            List<FileEntry> d2 = d();
            if (d2 == null) {
                return null;
            }
            for (FileEntry fileEntry : d2) {
                b bVar = new b(fileEntry.a, fileEntry.c, new File(this.b, fileEntry.d));
                if (!bVar.c.isFile()) {
                    try {
                        this.e.getWritableDatabase().delete(f, "_id=?", new String[]{String.valueOf(fileEntry.a)});
                    } catch (Throwable th) {
                        Log.w("FileCache", "cannot delete entry: " + fileEntry.d, th);
                    }
                } else {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
    }

    public synchronized void e() {
        if (!this.c) {
            this.c = true;
            if (!this.b.isDirectory()) {
                this.b.mkdirs();
                if (!this.b.isDirectory()) {
                    throw new RuntimeException("cannot create: " + this.b.getAbsolutePath());
                }
            }
        }
    }

    public b f(String str) {
        if (!this.c) {
            try {
                e();
            } catch (Exception e2) {
                Log.e("FileCache", "file cache init exception:", e2);
                return null;
            }
        }
        b bVar = this.a.get(str);
        if (bVar != null) {
            if (bVar.c.isFile()) {
                synchronized (this) {
                    i(bVar.a);
                }
                return bVar;
            }
            this.a.remove(str);
        }
        synchronized (this) {
            FileEntry g = g(str);
            if (g == null) {
                return null;
            }
            b bVar2 = new b(g.a, str, new File(this.b, g.d));
            if (!bVar2.c.isFile()) {
                try {
                    this.e.getWritableDatabase().delete(f, "_id=?", new String[]{String.valueOf(g.a)});
                } catch (Throwable th) {
                    Log.w("FileCache", "cannot delete entry: " + g.d, th);
                }
                return null;
            }
            this.a.put(str, bVar2);
            return bVar2;
        }
    }

    public void h(String str, File file) {
        if (!this.c) {
            try {
                e();
            } catch (Exception e2) {
                Log.e("FileCache", "file cache init exception:", e2);
                return;
            }
        }
        au2.a(file.getParentFile().equals(this.b));
        FileEntry fileEntry = new FileEntry();
        fileEntry.b = au2.b(str);
        fileEntry.c = str;
        fileEntry.d = file.getName();
        fileEntry.e = file.length();
        fileEntry.f = System.currentTimeMillis();
        if (fileEntry.e < this.d) {
            synchronized (this) {
                FileEntry g = g(str);
                if (g != null) {
                    fileEntry.d = g.d;
                    fileEntry.e = g.e;
                }
                FileEntry.SCHEMA.f(this.e.getWritableDatabase(), fileEntry);
                Log.e("detail_FileCache", "insertOrReplace entry:" + fileEntry);
            }
            return;
        }
        file.delete();
        throw new IllegalArgumentException("file too large: " + fileEntry.e);
    }

    public FileCache(Context context, File file, String str, long j, int i) {
        this.c = false;
        this.b = file;
        this.d = j;
        this.a = new LruCache<>(i);
        c cVar = new c(context, str);
        this.e = cVar;
        if (Build.VERSION.SDK_INT >= 16) {
            cVar.setWriteAheadLoggingEnabled(false);
        }
    }
}
