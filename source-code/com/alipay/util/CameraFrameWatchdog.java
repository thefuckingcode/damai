package com.alipay.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.alipay.camera.base.CameraStateTracer;
import com.alipay.camera2.Camera2AvailabilityCallback;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.mobile.watchdog.BQCWatchCallback;
import com.alipay.performance.memory.ScanMemoryMonitor;

/* compiled from: Taobao */
public class CameraFrameWatchdog {
    public static final long MIN_WATCH_DOG_DURATION = 3000;
    public static final long WATCH_DOG_DURATION = 10000;
    public static final int WAtCH_RETRY_TIME = 3;
    private final BQCWatchCallback a;
    private final long b;
    private Runnable c;
    private HandlerThread d;
    private Handler e;
    private WatcherState f = WatcherState.INIT;
    private long g = 0;
    private long h = 0;
    private long i = 0;
    private long j = 0;
    private long k = 0;
    private long l = 0;

    /* renamed from: com.alipay.util.CameraFrameWatchdog$2  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[WatcherState.values().length];
            a = iArr;
            iArr[WatcherState.INIT.ordinal()] = 1;
            a[WatcherState.CAMERA_START.ordinal()] = 2;
            a[WatcherState.CAMERA_END.ordinal()] = 3;
            a[WatcherState.PREVIEW_START.ordinal()] = 4;
            a[WatcherState.PREVIEW_END.ordinal()] = 5;
            try {
                a[WatcherState.TIMEOUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum NoFrameReason {
        CAMERA_METHOD_BLOCK,
        CAMERA_ERROR,
        CAMERA_HAL_NOT_PRODUCE_FRAME
    }

    /* compiled from: Taobao */
    public enum WatcherState {
        INIT,
        CAMERA_START,
        CAMERA_END,
        PREVIEW_START,
        PREVIEW_END,
        TIMEOUT
    }

    public CameraFrameWatchdog(BQCWatchCallback bQCWatchCallback, long j2, final Runnable runnable) {
        MPaasLogger.d("CameraFrameWatchdog", new Object[]{"terminateDurationMs:", Long.valueOf(j2)});
        this.a = bQCWatchCallback;
        if (runnable != null) {
            this.c = new Runnable() {
                /* class com.alipay.util.CameraFrameWatchdog.AnonymousClass1 */

                public void run() {
                    try {
                        MPaasLogger.d("CameraFrameWatchdog", new Object[]{"Watchdog run......"});
                        runnable.run();
                        if (CameraFrameWatchdog.this.d != null) {
                            CameraFrameWatchdog.this.d.quit();
                            CameraFrameWatchdog.this.d = null;
                        }
                    } catch (Throwable th) {
                        MPaasLogger.e("CameraFrameWatchdog", new Object[]{"run watchdog runnable with exception:"}, th);
                    }
                }
            };
        }
        this.b = j2;
    }

    private synchronized String c() {
        StringBuilder sb;
        sb = new StringBuilder();
        if (this.g > 0) {
            sb.append("initTime=");
            sb.append(this.g);
            sb.append("^");
        }
        if (this.h > 0) {
            sb.append("cameraStartTime=");
            sb.append(this.h);
            sb.append("^");
        }
        if (this.i > 0) {
            sb.append("cameraEndTime=");
            sb.append(this.i);
            sb.append("^");
        }
        if (this.j > 0) {
            sb.append("previewStartTime=");
            sb.append(this.j);
            sb.append("^");
        }
        if (this.k > 0) {
            sb.append("previewEndTime=");
            sb.append(this.k);
            sb.append("^");
        }
        if (this.l > 0) {
            sb.append("timeoutTime=");
            sb.append(this.l);
            sb.append("^");
        }
        return sb.toString();
    }

    public void buryWatchDogErrorDetails(NoFrameReason noFrameReason, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("###terminateDurationMs=");
        sb.append(String.valueOf(this.b));
        sb.append("###watcherState=");
        sb.append(String.valueOf(this.f));
        sb.append("###memoryTrimLevel=");
        sb.append(String.valueOf(ScanMemoryMonitor.getLastTrimMemoryLevel()));
        sb.append("###cameraStateTime=^");
        sb.append(String.valueOf(c()));
        if (Camera2AvailabilityCallback.isAvailableCallbackCheckEnable()) {
            sb.append("###isAllCameraUnAvailable=");
            sb.append(String.valueOf(CameraStateTracer.isAllCameraUnAvailable()));
            sb.append("###cameraAvailableStatus=");
            sb.append(CameraStateTracer.getCameraAvailableStatusMap());
        }
        WalletBury.addWalletBury("recordWatchDogErrorDetails", new Class[]{String.class, String.class, String.class}, new Object[]{String.valueOf(noFrameReason), sb.toString(), String.valueOf(z)});
    }

    public synchronized WatcherState getWatcherState() {
        return this.f;
    }

    public void postCameraFailRetryNotice(String str, boolean z) {
        try {
            BQCWatchCallback bQCWatchCallback = this.a;
            if (bQCWatchCallback != null) {
                bQCWatchCallback.onCameraFailRetryingNotice(str, z);
            }
        } catch (Throwable unused) {
        }
    }

    public void postCameraPreviewTimeOut(boolean z, String str) {
        MPaasLogger.d("CameraFrameWatchdog", new Object[]{"postCameraPreviewTimeOut:isCamera2:", Boolean.valueOf(z)});
        try {
            if (this.a != null) {
                this.a.onCameraPreviewTimeOut(getWatcherState().toString(), z, c() + str);
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void setWatcherState(WatcherState watcherState) {
        if (watcherState != WatcherState.TIMEOUT) {
            this.f = watcherState;
        }
        switch (AnonymousClass2.a[watcherState.ordinal()]) {
            case 1:
                this.g = SystemClock.elapsedRealtime();
                break;
            case 2:
                this.h = SystemClock.elapsedRealtime();
                break;
            case 3:
                this.i = SystemClock.elapsedRealtime();
                break;
            case 4:
                this.j = SystemClock.elapsedRealtime();
                break;
            case 5:
                this.k = SystemClock.elapsedRealtime();
                break;
            case 6:
                this.l = SystemClock.elapsedRealtime();
                break;
        }
    }

    public void startWatch() {
        try {
            if (this.a == null) {
                return;
            }
            if (this.b >= 3000) {
                MPaasLogger.d("CameraFrameWatchdog", new Object[]{"startWatch"});
                HandlerThread handlerThread = this.d;
                if (handlerThread != null && handlerThread.isAlive()) {
                    MPaasLogger.d("CameraFrameWatchdog", new Object[]{"stopBeforeWatch."});
                    this.d.quit();
                }
                HandlerThread handlerThread2 = new HandlerThread("Scan-WatchdogThread");
                this.d = handlerThread2;
                handlerThread2.start();
                Handler handler = new Handler(this.d.getLooper());
                this.e = handler;
                handler.postDelayed(this.c, this.b);
                this.g = 0;
                this.h = 0;
                this.i = 0;
                this.j = 0;
                this.k = 0;
                this.l = 0;
            }
        } catch (Throwable th) {
            MPaasLogger.e("CameraFrameWatchdog", new Object[]{"startWatch with exception:"}, th);
        }
    }

    public void stopWatch() {
        try {
            HandlerThread handlerThread = this.d;
            if (handlerThread == null) {
                return;
            }
            if (handlerThread.isAlive()) {
                MPaasLogger.d("CameraFrameWatchdog", new Object[]{"stopWatch"});
                this.e.removeCallbacks(this.c);
                HandlerThread handlerThread2 = this.d;
                if (handlerThread2 != null) {
                    handlerThread2.quit();
                    this.d = null;
                }
            }
        } catch (Throwable th) {
            MPaasLogger.e("CameraFrameWatchdog", new Object[]{"stopWatch with exception:"}, th);
        }
    }
}
