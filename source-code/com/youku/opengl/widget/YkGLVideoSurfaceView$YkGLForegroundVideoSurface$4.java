package com.youku.opengl.widget;

import com.youku.media.a;
import com.youku.opengl.widget.l;

/* compiled from: Taobao */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$4 implements Runnable {
    final /* synthetic */ l.a this$1;
    final /* synthetic */ a val$videoPlayer;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$4(l.a aVar, a aVar2) {
        this.this$1 = aVar;
        this.val$videoPlayer = aVar2;
    }

    public void run() {
        this.this$1.d.a(this.val$videoPlayer);
        this.this$1.c.a(this.this$1.d.h());
        this.this$1.c.a(this.val$videoPlayer);
        if (!(l.this.e == null || l.this.b == null)) {
            this.this$1.c.b(l.this.b.h());
        }
        if (this.this$1.f != null) {
            this.this$1.f.a(this.val$videoPlayer);
        }
    }
}
