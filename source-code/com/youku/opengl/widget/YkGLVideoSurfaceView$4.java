package com.youku.opengl.widget;

/* compiled from: Taobao */
class YkGLVideoSurfaceView$4 implements Runnable {
    final /* synthetic */ l this$0;
    final /* synthetic */ int[] val$wh;

    YkGLVideoSurfaceView$4(l lVar, int[] iArr) {
        this.this$0 = lVar;
        this.val$wh = iArr;
    }

    public void run() {
        this.this$0.b.b(this.val$wh);
        this.this$0.d.e();
    }
}
