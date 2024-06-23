package com.youku.opengl.widget;

import android.view.TextureView;
import com.youku.media.a;
import com.youku.media.b;
import com.youku.opengl.widget.l;

/* compiled from: Taobao */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$1 implements Runnable {
    final /* synthetic */ l.a this$1;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$1(l.a aVar) {
        this.this$1 = aVar;
    }

    public void run() {
        if (this.this$1.c != null) {
            this.this$1.c.a((a) null);
            this.this$1.c.b((b) null);
        }
        if (this.this$1.b != null) {
            this.this$1.b.e();
        }
        this.this$1.d.i();
        this.this$1.d.a((TextureView.SurfaceTextureListener) null);
    }
}
