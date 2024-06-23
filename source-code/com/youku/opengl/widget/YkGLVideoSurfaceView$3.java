package com.youku.opengl.widget;

import android.view.TextureView;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class YkGLVideoSurfaceView$3 implements Runnable {
    final /* synthetic */ l this$0;
    final /* synthetic */ TextureView.SurfaceTextureListener val$listener;

    YkGLVideoSurfaceView$3(l lVar, TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.this$0 = lVar;
        this.val$listener = surfaceTextureListener;
    }

    public void run() {
        this.this$0.b.a(this.val$listener);
    }
}
