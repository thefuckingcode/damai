package com.google.vr.sdk.widgets.pano;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.vr.sdk.widgets.common.VrEventListener;
import com.google.vr.sdk.widgets.common.VrWidgetRenderer;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class VrPanoramaRenderer extends VrWidgetRenderer {
    private static final String TAG = VrPanoramaRenderer.class.getSimpleName();
    private volatile VrWidgetRenderer.ApiRequest lastLoadImageRequest;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class LoadBitmapRequest implements VrWidgetRenderer.ApiRequest {
        public final Bitmap bitmap;
        public final VrEventListener eventListener;
        public final VrPanoramaView.Options options;

        public LoadBitmapRequest(Bitmap bitmap2, VrPanoramaView.Options options2, VrEventListener vrEventListener) {
            this.bitmap = bitmap2;
            this.options = options2;
            this.eventListener = vrEventListener;
        }

        @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest
        public void execute() {
            VrPanoramaRenderer vrPanoramaRenderer = VrPanoramaRenderer.this;
            vrPanoramaRenderer.nativeLoadImageFromBitmap(vrPanoramaRenderer.getNativeRenderer(), this.bitmap, this.options, this.eventListener);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class LoadImageFromByteArrayRequest implements VrWidgetRenderer.ApiRequest {
        public final VrEventListener eventListener;
        public final byte[] jpegImageData;
        public final VrPanoramaView.Options options;

        public LoadImageFromByteArrayRequest(byte[] bArr, VrPanoramaView.Options options2, VrEventListener vrEventListener) {
            this.jpegImageData = bArr;
            this.options = options2;
            this.eventListener = vrEventListener;
        }

        @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest
        public void execute() {
            VrPanoramaRenderer vrPanoramaRenderer = VrPanoramaRenderer.this;
            vrPanoramaRenderer.nativeLoadImageFromByteArray(vrPanoramaRenderer.getNativeRenderer(), this.jpegImageData, this.options, this.eventListener);
        }
    }

    public VrPanoramaRenderer(Context context, VrWidgetRenderer.GLThreadScheduler gLThreadScheduler, float f, float f2) {
        super(context, gLThreadScheduler, f, f2);
        System.loadLibrary("panorenderer");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeLoadImageFromBitmap(long j, Bitmap bitmap, VrPanoramaView.Options options, VrEventListener vrEventListener);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeLoadImageFromByteArray(long j, byte[] bArr, VrPanoramaView.Options options, VrEventListener vrEventListener);

    public void loadImageFromBitmap(Bitmap bitmap, VrPanoramaView.Options options, VrEventListener vrEventListener) {
        this.lastLoadImageRequest = new LoadBitmapRequest(bitmap, options, vrEventListener);
        postApiRequestToGlThread(this.lastLoadImageRequest);
    }

    public void loadImageFromByteArray(byte[] bArr, VrPanoramaView.Options options, VrEventListener vrEventListener) {
        this.lastLoadImageRequest = new LoadImageFromByteArrayRequest(bArr, options, vrEventListener);
        postApiRequestToGlThread(this.lastLoadImageRequest);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    public native long nativeCreate(ClassLoader classLoader, Context context, float f);

    /* access modifiers changed from: protected */
    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    public native void nativeDestroy(long j);

    /* access modifiers changed from: protected */
    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    public native void nativeGetHeadRotation(long j, float[] fArr);

    /* access modifiers changed from: protected */
    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    public native void nativeOnPanningEvent(long j, float f, float f2);

    /* access modifiers changed from: protected */
    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    public native void nativeOnPause(long j);

    /* access modifiers changed from: protected */
    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    public native void nativeOnResume(long j);

    /* access modifiers changed from: protected */
    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    public native void nativeRenderFrame(long j);

    /* access modifiers changed from: protected */
    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    public native void nativeResize(long j, int i, int i2, float f, float f2, int i3);

    /* access modifiers changed from: protected */
    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    public native void nativeSetPureTouchTracking(long j, boolean z);

    /* access modifiers changed from: protected */
    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    public native void nativeSetStereoMode(long j, boolean z);

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        super.onSurfaceCreated(gl10, eGLConfig);
        if (this.lastLoadImageRequest != null) {
            executeApiRequestOnGlThread(this.lastLoadImageRequest);
        }
    }
}
