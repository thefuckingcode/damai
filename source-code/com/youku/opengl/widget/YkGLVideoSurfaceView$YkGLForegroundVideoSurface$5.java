package com.youku.opengl.widget;

import com.youku.opengl.widget.l;

/* compiled from: Taobao */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$5 implements Runnable {
    final /* synthetic */ l.a this$1;
    final /* synthetic */ int[] val$wh;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$5(l.a aVar, int[] iArr) {
        this.this$1 = aVar;
        this.val$wh = iArr;
    }

    public void run() {
        this.this$1.d.b(this.val$wh);
        this.this$1.e.e();
    }
}
