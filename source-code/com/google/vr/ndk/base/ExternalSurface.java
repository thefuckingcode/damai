package com.google.vr.ndk.base;

import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.google.vr.ndk.base.GvrLayout;

/* compiled from: Taobao */
public class ExternalSurface {
    private static final String TAG = "ExternalSurface";
    private long nativeExternalSurface;

    ExternalSurface(GvrApi gvrApi, final GvrLayout.ExternalSurfaceListener externalSurfaceListener, Handler handler) {
        if (externalSurfaceListener == null) {
            throw new IllegalArgumentException("ExternalSurface creation requires a valid listener.");
        } else if (handler != null) {
            long nativeExternalSurfaceCreateWithListeners = GvrApi.nativeExternalSurfaceCreateWithListeners(gvrApi.getNativeGvrContext(), new Runnable() {
                /* class com.google.vr.ndk.base.ExternalSurface.AnonymousClass1 */

                public void run() {
                    externalSurfaceListener.onSurfaceAvailable(ExternalSurface.this.getSurface());
                }
            }, new Runnable(this) {
                /* class com.google.vr.ndk.base.ExternalSurface.AnonymousClass2 */

                public void run() {
                    externalSurfaceListener.onFrameAvailable();
                }
            }, handler);
            this.nativeExternalSurface = nativeExternalSurfaceCreateWithListeners;
            if (nativeExternalSurfaceCreateWithListeners == 0) {
                throw new IllegalStateException("ExternalSurface creation failed. Is reprojection enabled?");
            }
        } else {
            throw new IllegalArgumentException("ExternalSurface creation requires a valid Handler.");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.nativeExternalSurface != 0) {
                Log.w(TAG, "ExternalSurface.shutdown() should be called to ensure resource cleanup");
                shutdown();
            }
        } finally {
            super.finalize();
        }
    }

    public int getId() {
        return GvrApi.nativeExternalSurfaceGetId(this.nativeExternalSurface);
    }

    public Surface getSurface() {
        return GvrApi.nativeExternalSurfaceGetSurface(this.nativeExternalSurface);
    }

    public void shutdown() {
        long j = this.nativeExternalSurface;
        if (j != 0) {
            GvrApi.nativeExternalSurfaceDestroy(j);
            this.nativeExternalSurface = 0;
        }
    }
}
