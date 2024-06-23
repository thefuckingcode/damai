package com.taobao.alivfssdk.fresco.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.taobao.orange.OConstant;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: Taobao */
public class StatFsHelper {
    private static StatFsHelper h;
    private static final long i = TimeUnit.MINUTES.toMillis(2);
    private volatile StatFs a = null;
    private volatile File b;
    private volatile StatFs c = null;
    private volatile File d;
    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private long e;
    private final Lock f = new ReentrantLock();
    private volatile boolean g = false;

    /* compiled from: Taobao */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    protected StatFsHelper() {
    }

    protected static StatFs a(String str) {
        return new StatFs(str);
    }

    private void b() {
        if (!this.g) {
            this.f.lock();
            try {
                if (!this.g) {
                    this.b = Environment.getDataDirectory();
                    this.d = Environment.getExternalStorageDirectory();
                    g();
                    this.g = true;
                }
            } finally {
                this.f.unlock();
            }
        }
    }

    public static synchronized StatFsHelper d() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (h == null) {
                h = new StatFsHelper();
            }
            statFsHelper = h;
        }
        return statFsHelper;
    }

    private void e() {
        if (this.f.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.e > i) {
                    g();
                }
            } finally {
                this.f.unlock();
            }
        }
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void g() {
        this.a = h(this.a, this.b);
        this.c = h(this.c, this.d);
        this.e = SystemClock.uptimeMillis();
    }

    private StatFs h(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (statFs == null) {
            try {
                statFs = a(file.getAbsolutePath());
            } catch (IllegalArgumentException unused) {
                return null;
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        } else {
            statFs.restat(file.getAbsolutePath());
        }
        return statFs;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long c(StorageType storageType) {
        long j;
        long j2;
        b();
        e();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.a : this.c;
        if (statFs == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockSizeLong();
            j = statFs.getAvailableBlocksLong();
        } else {
            j2 = (long) statFs.getBlockSize();
            j = (long) statFs.getAvailableBlocks();
        }
        return j2 * j;
    }

    public boolean f(StorageType storageType, long j) {
        b();
        long c2 = c(storageType);
        return c2 <= 0 || c2 < j;
    }
}
