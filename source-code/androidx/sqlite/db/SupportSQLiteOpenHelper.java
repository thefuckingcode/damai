package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* compiled from: Taobao */
public interface SupportSQLiteOpenHelper extends Closeable {

    /* compiled from: Taobao */
    public static abstract class Callback {
        private static final String TAG = "SupportSQLite";
        public final int version;

        public Callback(int i) {
            this.version = i;
        }

        private void deleteDatabaseFile(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                Log.w(TAG, "deleting the database file: " + str);
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        SupportSQLiteCompat.Api16Impl.deleteDatabase(new File(str));
                        return;
                    }
                    try {
                        if (!new File(str).delete()) {
                            Log.e(TAG, "Could not delete the database file " + str);
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "error while deleting corrupted database file", e);
                    }
                } catch (Exception e2) {
                    Log.w(TAG, "delete failed: ", e2);
                }
            }
        }

        public void onConfigure(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
            if (r0 != null) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
            r3 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
            if (r3.hasNext() != false) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
            deleteDatabaseFile((java.lang.String) r3.next().second);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
            deleteDatabaseFile(r3.getPath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0030 */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x002e A[ExcHandler: all (r1v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
          PHI: (r0v10 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:5:0x0029, B:8:0x0030, B:9:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0029] */
        public void onCorruption(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            Log.e(TAG, "Corruption reported by sqlite on database: " + supportSQLiteDatabase.getPath());
            if (!supportSQLiteDatabase.isOpen()) {
                deleteDatabaseFile(supportSQLiteDatabase.getPath());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                list = supportSQLiteDatabase.getAttachedDbs();
                supportSQLiteDatabase.close();
            } catch (IOException unused) {
            } catch (Throwable th) {
            }
            if (list == null) {
                for (Pair<String, String> pair : list) {
                    deleteDatabaseFile((String) pair.second);
                }
                return;
            }
            deleteDatabaseFile(supportSQLiteDatabase.getPath());
        }

        public abstract void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
            throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
        }

        public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void onUpgrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);
    }

    /* compiled from: Taobao */
    public static class Configuration {
        @NonNull
        public final Callback callback;
        @NonNull
        public final Context context;
        @Nullable
        public final String name;
        public final boolean useNoBackupDirectory;

        /* compiled from: Taobao */
        public static class Builder {
            Callback mCallback;
            Context mContext;
            String mName;
            boolean mUseNoBackupDirectory;

            Builder(@NonNull Context context) {
                this.mContext = context;
            }

            @NonNull
            public Configuration build() {
                if (this.mCallback == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (this.mContext == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                } else if (!this.mUseNoBackupDirectory || !TextUtils.isEmpty(this.mName)) {
                    return new Configuration(this.mContext, this.mName, this.mCallback, this.mUseNoBackupDirectory);
                } else {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
            }

            @NonNull
            public Builder callback(@NonNull Callback callback) {
                this.mCallback = callback;
                return this;
            }

            @NonNull
            public Builder name(@Nullable String str) {
                this.mName = str;
                return this;
            }

            @NonNull
            public Builder noBackupDirectory(boolean z) {
                this.mUseNoBackupDirectory = z;
                return this;
            }
        }

        Configuration(@NonNull Context context2, @Nullable String str, @NonNull Callback callback2) {
            this(context2, str, callback2, false);
        }

        @NonNull
        public static Builder builder(@NonNull Context context2) {
            return new Builder(context2);
        }

        Configuration(@NonNull Context context2, @Nullable String str, @NonNull Callback callback2, boolean z) {
            this.context = context2;
            this.name = str;
            this.callback = callback2;
            this.useNoBackupDirectory = z;
        }
    }

    /* compiled from: Taobao */
    public interface Factory {
        @NonNull
        SupportSQLiteOpenHelper create(@NonNull Configuration configuration);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Nullable
    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z);
}
