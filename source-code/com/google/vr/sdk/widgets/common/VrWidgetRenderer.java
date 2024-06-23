package com.google.vr.sdk.widgets.common;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import tb.v;

/* compiled from: Taobao */
public abstract class VrWidgetRenderer implements GLSurfaceView.Renderer {
    private static final String TAG = VrWidgetRenderer.class.getSimpleName();
    public static boolean disableRenderingForTesting;
    private final Context context;
    private float currentYaw;
    private final Display display;
    private final GLThreadScheduler glThreadScheduler;
    private volatile SetPureTouchTrackingRequest lastSetPureTouchTrackingRequest;
    private volatile SetStereoModeRequest lastSetStereoModeRequest;
    private long nativeRenderer;
    private float[] tmpHeadAngles = new float[2];
    private float xMetersPerPixel;
    private float yMetersPerPixel;

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public interface ApiRequest {
        void execute();
    }

    /* compiled from: Taobao */
    public interface GLThreadScheduler {
        void queueGlThreadEvent(Runnable runnable);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class SetPureTouchTrackingRequest implements ApiRequest {
        public final boolean setPureTouchTracking;

        public SetPureTouchTrackingRequest(boolean z) {
            this.setPureTouchTracking = z;
        }

        @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest
        public void execute() {
            VrWidgetRenderer vrWidgetRenderer = VrWidgetRenderer.this;
            vrWidgetRenderer.nativeSetPureTouchTracking(vrWidgetRenderer.nativeRenderer, this.setPureTouchTracking);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class SetStereoModeRequest implements ApiRequest {
        public final boolean stereoMode;

        public SetStereoModeRequest(boolean z) {
            this.stereoMode = z;
        }

        @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest
        public void execute() {
            VrWidgetRenderer vrWidgetRenderer = VrWidgetRenderer.this;
            vrWidgetRenderer.nativeSetStereoMode(vrWidgetRenderer.nativeRenderer, this.stereoMode);
        }
    }

    protected VrWidgetRenderer(Context context2, GLThreadScheduler gLThreadScheduler, float f, float f2) {
        this.context = context2;
        this.glThreadScheduler = gLThreadScheduler;
        this.xMetersPerPixel = f;
        this.yMetersPerPixel = f2;
        this.display = ((WindowManager) context2.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
    }

    /* access modifiers changed from: protected */
    public void executeApiRequestOnGlThread(ApiRequest apiRequest) {
        if (disableRenderingForTesting) {
            Log.i(TAG, "disableRenderingForTesting");
        } else if (this.nativeRenderer == 0) {
            Log.i(TAG, "Native renderer has just been destroyed. Dropping request.");
        } else {
            apiRequest.execute();
        }
    }

    public void getHeadRotation(float[] fArr) {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeGetHeadRotation(j, fArr);
        }
    }

    /* access modifiers changed from: protected */
    public long getNativeRenderer() {
        return this.nativeRenderer;
    }

    /* access modifiers changed from: protected */
    public abstract long nativeCreate(ClassLoader classLoader, Context context2, float f);

    /* access modifiers changed from: protected */
    public abstract void nativeDestroy(long j);

    /* access modifiers changed from: protected */
    public abstract void nativeGetHeadRotation(long j, float[] fArr);

    /* access modifiers changed from: protected */
    public abstract void nativeOnPanningEvent(long j, float f, float f2);

    /* access modifiers changed from: protected */
    public abstract void nativeOnPause(long j);

    /* access modifiers changed from: protected */
    public abstract void nativeOnResume(long j);

    /* access modifiers changed from: protected */
    public abstract void nativeRenderFrame(long j);

    /* access modifiers changed from: protected */
    public abstract void nativeResize(long j, int i, int i2, float f, float f2, int i3);

    /* access modifiers changed from: protected */
    public abstract void nativeSetPureTouchTracking(long j, boolean z);

    /* access modifiers changed from: protected */
    public abstract void nativeSetStereoMode(long j, boolean z);

    public void onDrawFrame(GL10 gl10) {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeRenderFrame(j);
        }
    }

    public void onPanningEvent(float f, float f2) {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeOnPanningEvent(j, f, f2);
        }
    }

    public void onPause() {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeOnPause(j);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        this.currentYaw = bundle.getFloat("currentYaw");
    }

    public void onResume() {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeOnResume(j);
        }
    }

    public Bundle onSaveInstanceState() {
        updateCurrentYaw();
        Bundle bundle = new Bundle();
        bundle.putFloat("currentYaw", this.currentYaw);
        return bundle;
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        nativeResize(this.nativeRenderer, i, i2, this.xMetersPerPixel, this.yMetersPerPixel, VrWidgetView.getScreenRotationInDegrees(this.display.getRotation()));
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeDestroy(j);
        }
        this.nativeRenderer = nativeCreate(getClass().getClassLoader(), this.context.getApplicationContext(), this.currentYaw);
        if (this.lastSetPureTouchTrackingRequest != null) {
            executeApiRequestOnGlThread(this.lastSetPureTouchTrackingRequest);
        }
        if (this.lastSetStereoModeRequest != null) {
            executeApiRequestOnGlThread(this.lastSetStereoModeRequest);
        }
    }

    /* access modifiers changed from: protected */
    public void onViewDetach() {
    }

    /* access modifiers changed from: protected */
    public void postApiRequestToGlThread(final ApiRequest apiRequest) {
        this.glThreadScheduler.queueGlThreadEvent(new Runnable() {
            /* class com.google.vr.sdk.widgets.common.VrWidgetRenderer.AnonymousClass1 */

            public void run() {
                VrWidgetRenderer.this.executeApiRequestOnGlThread(apiRequest);
            }
        });
    }

    public void setPureTouchTracking(boolean z) {
        this.lastSetPureTouchTrackingRequest = new SetPureTouchTrackingRequest(z);
        postApiRequestToGlThread(this.lastSetPureTouchTrackingRequest);
    }

    public void setStereoMode(boolean z) {
        this.lastSetStereoModeRequest = new SetStereoModeRequest(z);
        postApiRequestToGlThread(this.lastSetStereoModeRequest);
    }

    public void shutdown() {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeDestroy(j);
            this.nativeRenderer = 0;
        }
    }

    public void updateCurrentYaw() {
        getHeadRotation(this.tmpHeadAngles);
        this.currentYaw = this.tmpHeadAngles[0];
    }
}
