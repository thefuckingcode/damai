package com.youku.opengl.widget;

import com.youku.opengl.filter.b;
import com.youku.opengl.filter.c;
import com.youku.opengl.filter.e;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class YkGLVideoSurfaceView$1 implements Runnable {
    final /* synthetic */ l this$0;
    final /* synthetic */ b val$filter;

    YkGLVideoSurfaceView$1(l lVar, b bVar) {
        this.this$0 = lVar;
        this.val$filter = bVar;
    }

    public void run() {
        c cVar = new c();
        cVar.a(new e());
        cVar.a(this.val$filter);
        this.this$0.c = cVar;
        this.this$0.d.a(this.this$0.c);
    }
}
