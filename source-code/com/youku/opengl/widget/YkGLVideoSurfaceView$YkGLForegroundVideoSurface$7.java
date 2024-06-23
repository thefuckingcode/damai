package com.youku.opengl.widget;

import com.youku.opengl.widget.l;

/* compiled from: Taobao */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$7 implements Runnable {
    final /* synthetic */ l.a this$1;
    final /* synthetic */ int val$renderType;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$7(l.a aVar, int i) {
        this.this$1 = aVar;
        this.val$renderType = i;
    }

    public void run() {
        this.this$1.e.a(this.val$renderType);
    }
}
