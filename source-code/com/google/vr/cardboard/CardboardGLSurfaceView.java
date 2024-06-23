package com.google.vr.cardboard;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.google.vr.ndk.base.GvrSurfaceView;
import java.util.ArrayList;
import tb.uc0;

/* compiled from: Taobao */
public class CardboardGLSurfaceView extends GvrSurfaceView {
    private static final String TAG = CardboardGLSurfaceView.class.getSimpleName();
    private final uc0 eglFactory;
    private ArrayList<Runnable> eventQueueWhileDetached;
    private boolean isDetached;
    private boolean isRendererSet;
    private final DetachListener listener;

    /* compiled from: Taobao */
    public interface DetachListener {
        void onSurfaceViewDetachedFromWindow();
    }

    public CardboardGLSurfaceView(Context context, DetachListener detachListener) {
        super(context);
        this.listener = detachListener;
        uc0 uc0 = new uc0();
        this.eglFactory = uc0;
        setEGLContextFactory(uc0);
        setEGLWindowSurfaceFactory(uc0);
    }

    public boolean isDetached() {
        return this.isDetached;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.vr.ndk.base.GvrSurfaceView
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = 0;
        this.isDetached = false;
        ArrayList<Runnable> arrayList = this.eventQueueWhileDetached;
        if (arrayList != null) {
            int size = arrayList.size();
            while (i < size) {
                Runnable runnable = arrayList.get(i);
                i++;
                super.queueEvent(runnable);
            }
            this.eventQueueWhileDetached.clear();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.vr.ndk.base.GvrSurfaceView
    public void onDetachedFromWindow() {
        DetachListener detachListener;
        if (this.isRendererSet && (detachListener = this.listener) != null) {
            detachListener.onSurfaceViewDetachedFromWindow();
        }
        super.onDetachedFromWindow();
        this.isDetached = true;
    }

    @Override // com.google.vr.ndk.base.GvrSurfaceView
    public void onPause() {
        if (this.isRendererSet) {
            super.onPause();
        }
    }

    @Override // com.google.vr.ndk.base.GvrSurfaceView
    public void onResume() {
        if (this.isRendererSet) {
            super.onResume();
        }
    }

    @Override // com.google.vr.ndk.base.GvrSurfaceView
    public void queueEvent(Runnable runnable) {
        if (!this.isRendererSet) {
            runnable.run();
        } else if (this.isDetached) {
            if (this.eventQueueWhileDetached == null) {
                this.eventQueueWhileDetached = new ArrayList<>();
            }
            this.eventQueueWhileDetached.add(runnable);
        } else {
            super.queueEvent(runnable);
        }
    }

    @Override // com.google.vr.ndk.base.GvrSurfaceView
    public void setEGLContextClientVersion(int i) {
        super.setEGLContextClientVersion(i);
        this.eglFactory.a(i);
    }

    @Override // com.google.vr.ndk.base.GvrSurfaceView
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        super.setRenderer(renderer);
        this.isRendererSet = true;
    }

    public CardboardGLSurfaceView(Context context, AttributeSet attributeSet, DetachListener detachListener) {
        super(context, attributeSet);
        this.listener = detachListener;
        uc0 uc0 = new uc0();
        this.eglFactory = uc0;
        setEGLContextFactory(uc0);
        setEGLWindowSurfaceFactory(uc0);
    }
}
