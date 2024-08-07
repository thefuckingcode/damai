package com.ali.alihadeviceevaluator.cpu;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tb.jb;

/* compiled from: Taobao */
public class AliHACPUTracker implements Runnable {
    private static final boolean Debug = false;
    private static final int[] PROCESS_STATS_FORMAT = {32, 544, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224};
    static final int PROCESS_STAT_MAJOR_FAULTS = 1;
    static final int PROCESS_STAT_MINOR_FAULTS = 0;
    static final int PROCESS_STAT_STIME = 3;
    static final int PROCESS_STAT_UTIME = 2;
    public static final int PROC_COMBINE = 256;
    public static final int PROC_OUT_FLOAT = 16384;
    public static final int PROC_OUT_LONG = 8192;
    public static final int PROC_OUT_STRING = 4096;
    public static final int PROC_PARENS = 512;
    public static final int PROC_QUOTES = 1024;
    public static final int PROC_SPACE_TERM = 32;
    public static final int PROC_TAB_TERM = 9;
    public static final int PROC_TERM_MASK = 255;
    public static final int PROC_ZERO_TERM = 0;
    private static final int[] SYSTEM_CPU_FORMAT = {288, 8224, 8224, 8224, 8224, 8224, 8224, 8224};
    private static final String TAG = "CpuTracker";
    private volatile boolean initCpu;
    private int lastRelIdleTime;
    private long mBaseIdleTime;
    private long mBaseIoWaitTime;
    private long mBaseIrqTime;
    private long mBaseSoftIrqTime;
    private long mBaseSystemTime;
    private long mBaseUserTime;
    private Handler mCPUHandler;
    private float mCpuPercent;
    private float mCurProcessCpuPercent;
    public long mDeltaDuration;
    private long mFirstDeltaDuration;
    private long mProcessBaseSystemTime;
    private long mProcessBaseUserTime;
    private volatile double o_cpu;
    private volatile double o_idle;
    private volatile boolean open;
    private ReadWriteLock peakCpuLock;
    private ReadWriteLock peakCurProCpuLock;
    private Method readProcFile;
    private String statFile;
    private final long[] statsData;
    private long[] sysCpu;

    public AliHACPUTracker(int i, Handler handler) {
        this.statsData = new long[4];
        this.sysCpu = new long[7];
        this.mCpuPercent = -1.0f;
        this.mCurProcessCpuPercent = -1.0f;
        this.peakCpuLock = new ReentrantReadWriteLock();
        this.peakCurProCpuLock = new ReentrantReadWriteLock();
        this.mDeltaDuration = 7000;
        this.mFirstDeltaDuration = 2000;
        this.open = true;
        this.initCpu = true;
        this.o_cpu = 0.0d;
        this.o_idle = 0.0d;
        if (handler != null) {
            this.mCPUHandler = handler;
        } else {
            HandlerThread handlerThread = new HandlerThread(TAG);
            handlerThread.start();
            this.mCPUHandler = new Handler(handlerThread.getLooper());
        }
        init(i);
    }

    private void closeRandomAccessFile(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void init(int i) {
        try {
            this.statFile = "/proc/" + i + "/stat";
            Method method = Process.class.getMethod("readProcFile", String.class, int[].class, String[].class, long[].class, float[].class);
            this.readProcFile = method;
            method.setAccessible(true);
            if (Build.VERSION.SDK_INT < 26) {
                this.mCPUHandler.post(this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public float peakCpuPercent() {
        this.peakCpuLock.readLock().lock();
        float f = this.mCpuPercent;
        this.peakCpuLock.readLock().unlock();
        return f;
    }

    public float peakCurProcessCpuPercent() {
        this.peakCurProCpuLock.readLock().lock();
        float f = this.mCurProcessCpuPercent;
        this.peakCurProCpuLock.readLock().unlock();
        return f;
    }

    public void reset(long j) {
        if (Build.VERSION.SDK_INT < 26) {
            this.mCPUHandler.removeCallbacks(this);
            if (j > 0) {
                this.mDeltaDuration = j;
                this.mCPUHandler.postDelayed(this, j);
                this.open = true;
                return;
            }
            this.open = false;
        }
    }

    public void run() {
        try {
            if (this.initCpu) {
                this.mCPUHandler.postDelayed(this, this.mFirstDeltaDuration);
            } else if (this.open) {
                this.mCPUHandler.postDelayed(this, this.mDeltaDuration);
            }
            updateCpuPercent();
            updateCurProcessCpuPercent();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public float updateCpuPercent() {
        float f;
        Throwable th;
        RandomAccessFile randomAccessFile;
        double parseDouble;
        double parseDouble2;
        double d;
        double d2;
        double d3;
        Throwable th2;
        this.peakCpuLock.writeLock().lock();
        RandomAccessFile randomAccessFile2 = null;
        if (this.initCpu) {
            this.initCpu = false;
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile("/proc/stat", UploadQueueMgr.MSGTYPE_REALTIME);
                try {
                    String[] split = randomAccessFile3.readLine().split(" ");
                    this.o_idle = Double.parseDouble(split[5]);
                    this.o_cpu = Double.parseDouble(split[2]) + Double.parseDouble(split[3]) + Double.parseDouble(split[4]) + Double.parseDouble(split[6]) + Double.parseDouble(split[8]) + Double.parseDouble(split[7]);
                    closeRandomAccessFile(randomAccessFile3);
                } catch (Throwable th3) {
                    th2 = th3;
                    randomAccessFile2 = randomAccessFile3;
                    try {
                        th2.printStackTrace();
                        f = 0.0f;
                        this.peakCpuLock.writeLock().unlock();
                        return f;
                    } finally {
                        closeRandomAccessFile(randomAccessFile2);
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                th2.printStackTrace();
                f = 0.0f;
                this.peakCpuLock.writeLock().unlock();
                return f;
            }
            f = 0.0f;
        } else {
            try {
                RandomAccessFile randomAccessFile4 = new RandomAccessFile("/proc/stat", UploadQueueMgr.MSGTYPE_REALTIME);
                try {
                    String[] split2 = randomAccessFile4.readLine().split(" ");
                    parseDouble = Double.parseDouble(split2[5]);
                    parseDouble2 = Double.parseDouble(split2[2]) + Double.parseDouble(split2[3]) + Double.parseDouble(split2[4]) + Double.parseDouble(split2[6]) + Double.parseDouble(split2[8]) + Double.parseDouble(split2[7]);
                    d = parseDouble2 + parseDouble;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile4;
                    randomAccessFile2 = randomAccessFile;
                    f = 0.0f;
                    try {
                        th.printStackTrace();
                        this.peakCpuLock.writeLock().unlock();
                        return f;
                    } finally {
                        closeRandomAccessFile(randomAccessFile2);
                    }
                }
                try {
                    double d4 = 100.0d;
                    if (0.0d != d - (this.o_cpu + this.o_idle)) {
                        try {
                            d3 = parseDouble;
                            d2 = parseDouble2;
                            double a = jb.a((parseDouble2 - this.o_cpu) * 100.0d, d - (this.o_cpu + this.o_idle), 2);
                            if (a >= 0.0d) {
                                if (a <= 100.0d) {
                                    d4 = a;
                                }
                                this.o_cpu = d2;
                                this.o_idle = d3;
                                f = (float) d4;
                                this.mCpuPercent = f;
                                closeRandomAccessFile(randomAccessFile4);
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            randomAccessFile2 = randomAccessFile4;
                            f = 0.0f;
                            th.printStackTrace();
                            this.peakCpuLock.writeLock().unlock();
                            return f;
                        }
                    } else {
                        d3 = parseDouble;
                        d2 = parseDouble2;
                    }
                    d4 = 0.0d;
                    this.o_cpu = d2;
                    this.o_idle = d3;
                    f = (float) d4;
                } catch (Throwable th7) {
                    th = th7;
                    randomAccessFile = randomAccessFile4;
                    randomAccessFile2 = randomAccessFile;
                    f = 0.0f;
                    th.printStackTrace();
                    this.peakCpuLock.writeLock().unlock();
                    return f;
                }
                try {
                    this.mCpuPercent = f;
                    closeRandomAccessFile(randomAccessFile4);
                } catch (Throwable th8) {
                    th = th8;
                    randomAccessFile2 = randomAccessFile4;
                    th.printStackTrace();
                    this.peakCpuLock.writeLock().unlock();
                    return f;
                }
            } catch (Throwable th9) {
                th = th9;
                f = 0.0f;
                th.printStackTrace();
                this.peakCpuLock.writeLock().unlock();
                return f;
            }
        }
        this.peakCpuLock.writeLock().unlock();
        return f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0061 A[Catch:{ Exception -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f3  */
    public float updateCurProcessCpuPercent() {
        float f;
        Exception e;
        boolean z;
        float f2;
        if (this.readProcFile == null || this.statFile == null) {
            Log.e(TAG, "readProcFile : " + this.readProcFile + ", statFile : " + this.statFile);
            return 0.0f;
        }
        this.peakCurProCpuLock.writeLock().lock();
        try {
            if (((Boolean) this.readProcFile.invoke(null, this.statFile, PROCESS_STATS_FORMAT, null, this.statsData, null)).booleanValue()) {
                if (((Boolean) this.readProcFile.invoke(null, "/proc/stat", SYSTEM_CPU_FORMAT, null, this.sysCpu, null)).booleanValue()) {
                    z = true;
                    if (!z) {
                        long[] jArr = this.statsData;
                        int i = (int) (jArr[2] - this.mProcessBaseUserTime);
                        int i2 = (int) (jArr[3] - this.mProcessBaseSystemTime);
                        long[] jArr2 = this.sysCpu;
                        long j = jArr2[0] + jArr2[1];
                        long j2 = jArr2[2];
                        long j3 = jArr2[3];
                        long j4 = jArr2[4];
                        long j5 = jArr2[5];
                        long j6 = jArr2[6];
                        int i3 = (int) (j - this.mBaseUserTime);
                        int i4 = (int) (j2 - this.mBaseSystemTime);
                        int i5 = (int) (j4 - this.mBaseIoWaitTime);
                        int i6 = (int) (j5 - this.mBaseIrqTime);
                        int i7 = (int) (j6 - this.mBaseSoftIrqTime);
                        int i8 = (int) (j3 - this.mBaseIdleTime);
                        if (i8 <= 1) {
                            i8 = this.lastRelIdleTime;
                        }
                        int i9 = i3 + i4 + i5 + i6 + i7 + i8;
                        if (i9 > 1) {
                            f2 = jb.b((float) ((i + i2) * 100), (float) i9, 2);
                            try {
                                this.mCurProcessCpuPercent = f2;
                            } catch (Exception e2) {
                                e = e2;
                                f = f2;
                                try {
                                    e.printStackTrace();
                                    return f;
                                } finally {
                                    this.peakCurProCpuLock.writeLock().unlock();
                                }
                            }
                        } else {
                            f2 = 0.0f;
                        }
                        long[] jArr3 = this.statsData;
                        this.mProcessBaseUserTime = jArr3[2];
                        this.mProcessBaseSystemTime = jArr3[3];
                        this.mBaseUserTime = j;
                        this.mBaseSystemTime = j2;
                        this.mBaseIdleTime = j3;
                        this.mBaseIoWaitTime = j4;
                        this.mBaseIrqTime = j5;
                        this.mBaseSoftIrqTime = j6;
                        this.lastRelIdleTime = i8;
                        this.peakCurProCpuLock.writeLock().unlock();
                        return f2;
                    }
                    this.peakCurProCpuLock.writeLock().unlock();
                    return 0.0f;
                }
            }
            z = false;
            if (!z) {
            }
        } catch (Exception e3) {
            e = e3;
            f = 0.0f;
            e.printStackTrace();
            return f;
        }
    }

    public AliHACPUTracker(int i) {
        this.statsData = new long[4];
        this.sysCpu = new long[7];
        this.mCpuPercent = -1.0f;
        this.mCurProcessCpuPercent = -1.0f;
        this.peakCpuLock = new ReentrantReadWriteLock();
        this.peakCurProCpuLock = new ReentrantReadWriteLock();
        this.mDeltaDuration = 7000;
        this.mFirstDeltaDuration = 2000;
        this.open = true;
        this.initCpu = true;
        this.o_cpu = 0.0d;
        this.o_idle = 0.0d;
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.mCPUHandler = new Handler(handlerThread.getLooper());
        init(i);
    }
}
