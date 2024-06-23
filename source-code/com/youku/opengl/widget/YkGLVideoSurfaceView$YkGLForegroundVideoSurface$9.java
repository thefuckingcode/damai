package com.youku.opengl.widget;

import com.youku.opengl.widget.l;

/* compiled from: Taobao */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$9 implements Runnable {
    final /* synthetic */ l.a this$1;
    final /* synthetic */ int val$atBackgroundVideoPts;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$9(l.a aVar, int i) {
        this.this$1 = aVar;
        this.val$atBackgroundVideoPts = i;
    }

    public void run() {
        this.this$1.c.b(this.val$atBackgroundVideoPts);
    }
}
