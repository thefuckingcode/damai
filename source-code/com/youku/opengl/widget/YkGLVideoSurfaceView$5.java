package com.youku.opengl.widget;

/* compiled from: Taobao */
class YkGLVideoSurfaceView$5 implements Runnable {
    final /* synthetic */ l this$0;
    final /* synthetic */ int val$renderType;

    YkGLVideoSurfaceView$5(l lVar, int i) {
        this.this$0 = lVar;
        this.val$renderType = i;
    }

    public void run() {
        this.this$0.d.a(this.val$renderType);
    }
}
