package com.alipay.camera.base;

import com.alipay.camera.base.CameraStateTracer;
import com.alipay.camera.util.CameraLog;
import com.alipay.camera.util.WalletBehaviorBury;

/* compiled from: Taobao */
public class CameraPerformanceRecorder {
    private static String u;
    private static long v;
    private static long w;
    private static long x;
    private static long y;
    private static boolean z;
    private final boolean a;
    private final String b;
    private long c = 0;
    private long d = 0;
    private long e;
    private long f;
    private long g = 0;
    private long h;
    private long i;
    private long j = 0;
    private long k;
    private long l;
    private long m;
    private long n = 0;
    private long o;
    private long p;
    private long q = 0;
    private long r;
    private long s;
    private String t;

    public CameraPerformanceRecorder(boolean z2, String str) {
        this.b = str;
        this.a = z2;
    }

    private void a() {
        CameraLog.d("CameraPerfRecorder", this.b + ", buryPerformanceData:" + toString());
        WalletBehaviorBury.bury("recordCameraNativePerformance", new Class[]{String.class, String.class, String.class}, new Object[]{this.b, String.valueOf(this.a), toString()});
    }

    public static String getStaticBlockEvent() {
        long j2;
        CameraStateTracer.CameraEvent cameraEvent;
        long currentTimeMillis = System.currentTimeMillis();
        if (y - x < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.GET_NUMBER_OF_CAMERAS;
            j2 = currentTimeMillis - x;
        } else {
            cameraEvent = null;
            j2 = 0;
        }
        if (w - v < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.GET_CAMERA_INFO;
            j2 = currentTimeMillis - v;
        }
        if (cameraEvent == null) {
            return null;
        }
        return "###blockCameraEvent=" + String.valueOf(cameraEvent) + "###blockDuration=" + String.valueOf(j2);
    }

    public static void setBeginGetCameraInfo(long j2) {
        v = j2;
        w = 0;
    }

    public static void setBeginGetNumberOfCameras(long j2) {
        x = j2;
        y = 0;
    }

    public static void setEndGetCameraInfo(long j2) {
        w = j2;
    }

    public static void setEndGetNumberOfCameras(long j2) {
        y = j2;
    }

    public static void setPreviewUseSurfaceView(boolean z2) {
        z = z2;
    }

    public static void updateServiceInitInfo(String str) {
        u = str;
    }

    public float getCurrentAvgFps() {
        if (this.k <= 0) {
            return -1.0f;
        }
        long j2 = this.m;
        if (j2 <= 0) {
            j2 = System.currentTimeMillis();
        }
        long j3 = j2 - this.k;
        long j4 = this.r;
        if (j4 <= 0 || j3 <= 0) {
            return -1.0f;
        }
        return (1000.0f / ((float) j3)) * ((float) j4);
    }

    public String getDynamicBlockEvent() {
        long j2;
        CameraStateTracer.CameraEvent cameraEvent;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.g < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.OPEN;
            j2 = currentTimeMillis - this.e;
        } else {
            cameraEvent = null;
            j2 = 0;
        }
        if (this.j < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.START_PREVIEW;
            j2 = currentTimeMillis - this.h;
        }
        if (this.n < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.STOP_PREVIEW;
            j2 = currentTimeMillis - this.l;
        }
        if (this.q < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.RELEASE;
            j2 = currentTimeMillis - this.o;
        }
        if (cameraEvent == null) {
            return null;
        }
        return "###blockCameraEvent=" + String.valueOf(cameraEvent) + "###blockDuration=" + String.valueOf(j2);
    }

    public long getEndOpenCamera() {
        return this.f;
    }

    public void setBeginCloseCamera(long j2) {
        this.o = j2;
        this.q = -1;
        this.p = 0;
    }

    public void setBeginOpenCamera(long j2) {
        this.e = j2;
        this.g = -1;
        this.f = 0;
        long j3 = v;
        if (j3 > 0) {
            long j4 = w;
            if (j4 >= j3) {
                this.c = j4 - j3;
                w = 0;
                v = 0;
            }
        }
        long j5 = x;
        if (j5 > 0) {
            long j6 = y;
            if (j6 >= j5) {
                this.d = j6 - j5;
                y = 0;
                x = 0;
            }
        }
    }

    public void setBeginStartPreview(long j2) {
        this.h = j2;
        this.j = -1;
        this.i = 0;
    }

    public void setBeginStopPreview(long j2) {
        this.l = j2;
        this.n = -1;
        this.m = 0;
    }

    public void setEndCloseCamera(long j2) {
        this.p = j2;
        if (this.k <= 0) {
            this.k = j2;
        }
        this.q = j2 - this.o;
    }

    public void setEndFirstPreviewFrame(long j2) {
        if (this.h <= 0 || this.i <= 0) {
            long j3 = this.f;
            this.h = j3;
            this.i = j3;
        }
        this.k = j2;
    }

    public void setEndOpenCamera(long j2) {
        this.f = j2;
        this.g = j2 - this.e;
    }

    public void setEndStartPreview(long j2) {
        this.i = j2;
        this.j = j2 - this.h;
    }

    public void setEndStopPreview(long j2) {
        this.m = j2;
        this.n = j2 - this.l;
    }

    public void setFirstTriggerFrameCount(int i2) {
        this.s = (long) i2;
    }

    public void setFocusTriggerRecord(String str) {
        this.t = str;
    }

    public void setFrameCountAndBuryPerfData(long j2) {
        this.r = j2;
        a();
    }

    public String toString() {
        return String.valueOf(u) + "###isCamera2=" + this.a + "###beginOpenCamera=" + String.valueOf(this.e) + "###endOpenCamera=" + String.valueOf(this.f) + "###beginStartPreview=" + String.valueOf(this.h) + "###endStartPreview=" + String.valueOf(this.i) + "###getCameraInfoDuration=" + String.valueOf(this.c) + "###getNumberOfDuration=" + String.valueOf(this.d) + "###OpenDuration=" + String.valueOf(this.g) + "###OpenedToStartPreview=" + String.valueOf(this.h - this.f) + "###startPreviewDuration=" + String.valueOf(this.j) + "###startedPreviewToFirstFrame=" + String.valueOf(this.k - this.i) + "###previewDuration=" + String.valueOf(this.m - this.k) + "###avgFps=" + String.valueOf(getCurrentAvgFps()) + "###stopPreviewDuration=" + String.valueOf(this.n) + "###closeCameraDuration=" + String.valueOf(this.q) + "###firstFocusTriggerFrameCount=" + String.valueOf(this.s) + "###frameCount=" + String.valueOf(this.r) + "###previewUseSurfaceView=" + String.valueOf(z) + "###focusTriggerRecord=" + String.valueOf(this.t);
    }
}
