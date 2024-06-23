package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
final class AutoCloser {
    final long mAutoCloseTimeoutInMs;
    @NonNull
    final Runnable mAutoCloser = new Runnable() {
        /* class androidx.room.AutoCloser.AnonymousClass2 */

        public void run() {
            synchronized (AutoCloser.this.mLock) {
                long uptimeMillis = SystemClock.uptimeMillis();
                AutoCloser autoCloser = AutoCloser.this;
                if (uptimeMillis - autoCloser.mLastDecrementRefCountTimeStamp >= autoCloser.mAutoCloseTimeoutInMs) {
                    if (autoCloser.mRefCount == 0) {
                        Runnable runnable = autoCloser.mOnAutoCloseCallback;
                        if (runnable != null) {
                            runnable.run();
                            SupportSQLiteDatabase supportSQLiteDatabase = AutoCloser.this.mDelegateDatabase;
                            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                                try {
                                    AutoCloser.this.mDelegateDatabase.close();
                                } catch (IOException e) {
                                    SneakyThrow.reThrow(e);
                                }
                                AutoCloser.this.mDelegateDatabase = null;
                            }
                            return;
                        }
                        throw new IllegalStateException("mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                    }
                }
            }
        }
    };
    @Nullable
    @GuardedBy("mLock")
    SupportSQLiteDatabase mDelegateDatabase;
    @Nullable
    private SupportSQLiteOpenHelper mDelegateOpenHelper = null;
    private final Runnable mExecuteAutoCloser = new Runnable() {
        /* class androidx.room.AutoCloser.AnonymousClass1 */

        public void run() {
            AutoCloser autoCloser = AutoCloser.this;
            autoCloser.mExecutor.execute(autoCloser.mAutoCloser);
        }
    };
    @NonNull
    final Executor mExecutor;
    @NonNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    @GuardedBy("mLock")
    long mLastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
    @NonNull
    final Object mLock = new Object();
    private boolean mManuallyClosed = false;
    @Nullable
    Runnable mOnAutoCloseCallback = null;
    @GuardedBy("mLock")
    int mRefCount = 0;

    AutoCloser(long j, @NonNull TimeUnit timeUnit, @NonNull Executor executor) {
        this.mAutoCloseTimeoutInMs = timeUnit.toMillis(j);
        this.mExecutor = executor;
    }

    public void closeDatabaseIfOpen() throws IOException {
        synchronized (this.mLock) {
            this.mManuallyClosed = true;
            SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegateDatabase;
            if (supportSQLiteDatabase != null) {
                supportSQLiteDatabase.close();
            }
            this.mDelegateDatabase = null;
        }
    }

    public void decrementCountAndScheduleClose() {
        synchronized (this.mLock) {
            int i = this.mRefCount;
            if (i > 0) {
                int i2 = i - 1;
                this.mRefCount = i2;
                if (i2 == 0) {
                    if (this.mDelegateDatabase != null) {
                        this.mHandler.postDelayed(this.mExecuteAutoCloser, this.mAutoCloseTimeoutInMs);
                    } else {
                        return;
                    }
                }
                return;
            }
            throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
        }
    }

    @Nullable
    public <V> V executeRefCountingFunction(@NonNull Function<SupportSQLiteDatabase, V> function) {
        try {
            return function.apply(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    @Nullable
    public SupportSQLiteDatabase getDelegateDatabase() {
        SupportSQLiteDatabase supportSQLiteDatabase;
        synchronized (this.mLock) {
            supportSQLiteDatabase = this.mDelegateDatabase;
        }
        return supportSQLiteDatabase;
    }

    @VisibleForTesting
    public int getRefCountForTest() {
        int i;
        synchronized (this.mLock) {
            i = this.mRefCount;
        }
        return i;
    }

    @NonNull
    public SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        synchronized (this.mLock) {
            this.mHandler.removeCallbacks(this.mExecuteAutoCloser);
            this.mRefCount++;
            if (!this.mManuallyClosed) {
                SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegateDatabase;
                if (supportSQLiteDatabase == null || !supportSQLiteDatabase.isOpen()) {
                    SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.mDelegateOpenHelper;
                    if (supportSQLiteOpenHelper != null) {
                        SupportSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
                        this.mDelegateDatabase = writableDatabase;
                        return writableDatabase;
                    }
                    throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                return this.mDelegateDatabase;
            }
            throw new IllegalStateException("Attempting to open already closed database.");
        }
    }

    public void init(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (this.mDelegateOpenHelper != null) {
            Log.e("ROOM", "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        } else {
            this.mDelegateOpenHelper = supportSQLiteOpenHelper;
        }
    }

    public boolean isActive() {
        return !this.mManuallyClosed;
    }

    public void setAutoCloseCallback(Runnable runnable) {
        this.mOnAutoCloseCallback = runnable;
    }
}
