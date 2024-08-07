package com.google.vr.cardboard;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.Choreographer;
import android.view.Display;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class DisplaySynchronizer implements Choreographer.FrameCallback {
    public static final long DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS = TimeUnit.SECONDS.toNanos(1);
    private volatile long a;
    private final c b;
    private volatile Display c;
    private volatile int d = -1;
    private long e = 0;

    public DisplaySynchronizer(Context context, Display display) {
        this.a = nativeCreate(getClass().getClassLoader(), context.getApplicationContext());
        if (this.a != 0) {
            h(display);
            c cVar = new c(this);
            this.b = cVar;
            cVar.a();
            return;
        }
        throw new IllegalStateException("Native DisplaySynchronizer creation failed, implementation unavailable.");
    }

    private void a() {
        if (this.a == 0) {
            throw new IllegalStateException("DisplaySynchronizer has already been shut down.");
        }
    }

    private void d() {
        this.d = -1;
    }

    public Display b() {
        return this.c;
    }

    public long c() {
        a();
        return this.a;
    }

    public void doFrame(long j) {
        a();
        if (this.d == -1 || j - this.e > DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS) {
            int rotation = this.c.getRotation();
            if (rotation == 0) {
                this.d = 0;
            } else if (rotation == 1) {
                this.d = 90;
            } else if (rotation == 2) {
                this.d = 180;
            } else if (rotation != 3) {
                Log.e("DisplaySynchronizer", "Unknown display rotation, defaulting to 0");
                this.d = 0;
            } else {
                this.d = AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
            }
            this.e = j;
        }
        nativeUpdate(this.a, j, this.d);
    }

    public void e() {
        d();
    }

    public void f() {
        this.b.b();
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            if (this.a != 0) {
                Log.w("DisplaySynchronizer", "DisplaySynchronizer.shutdown() should be called to ensure resource cleanup");
                nativeDestroy(this.a);
            }
        } finally {
            super.finalize();
        }
    }

    public void g() {
        d();
        this.b.c();
    }

    public void h(Display display) {
        a();
        this.c = display;
        d();
        float refreshRate = display.getRefreshRate();
        long j = 0;
        long nanos = refreshRate >= 30.0f ? (long) (((float) TimeUnit.SECONDS.toNanos(1)) / refreshRate) : 0;
        if (Build.VERSION.SDK_INT >= 21) {
            j = display.getAppVsyncOffsetNanos();
        }
        nativeReset(this.a, nanos, j);
    }

    public void i() {
        if (this.a != 0) {
            f();
            this.b.d();
            nativeDestroy(this.a);
            this.a = 0;
        }
    }

    /* access modifiers changed from: protected */
    public native long nativeCreate(ClassLoader classLoader, Context context);

    /* access modifiers changed from: protected */
    public native void nativeDestroy(long j);

    /* access modifiers changed from: protected */
    public native void nativeReset(long j, long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeUpdate(long j, long j2, int i);
}
