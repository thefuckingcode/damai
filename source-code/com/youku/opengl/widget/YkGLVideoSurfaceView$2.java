package com.youku.opengl.widget;

import com.youku.media.b;
import com.youku.opengl.widget.l;

/* compiled from: Taobao */
class YkGLVideoSurfaceView$2 implements Runnable {
    final /* synthetic */ l this$0;
    final /* synthetic */ b val$provider;

    YkGLVideoSurfaceView$2(l lVar, b bVar) {
        this.this$0 = lVar;
        this.val$provider = bVar;
    }

    public void run() {
        m mVar;
        this.this$0.e = this.val$provider;
        this.this$0.b.a(this.val$provider);
        b h = this.this$0.b.h();
        if (this.this$0.g != null) {
            this.this$0.g.a(h);
        }
        l.a aVar = this.this$0.a(false);
        if (aVar != null && (mVar = aVar.c) != null) {
            mVar.b(h);
        }
    }
}
