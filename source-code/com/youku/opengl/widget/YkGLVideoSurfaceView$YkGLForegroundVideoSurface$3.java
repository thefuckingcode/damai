package com.youku.opengl.widget;

import com.youku.opengl.filter.b;
import com.youku.opengl.filter.c;
import com.youku.opengl.filter.e;
import com.youku.opengl.widget.l;

/* compiled from: Taobao */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$3 implements Runnable {
    final /* synthetic */ l.a this$1;
    final /* synthetic */ b val$filter;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$3(l.a aVar, b bVar) {
        this.this$1 = aVar;
        this.val$filter = bVar;
    }

    public void run() {
        c cVar = new c();
        cVar.a(new e());
        cVar.a(this.val$filter);
        if (this.this$1.f != null) {
            cVar.a(this.this$1.f);
        }
        cVar.a(this.this$1.c);
        this.this$1.b = cVar;
        this.this$1.e.a(this.this$1.b);
    }
}
