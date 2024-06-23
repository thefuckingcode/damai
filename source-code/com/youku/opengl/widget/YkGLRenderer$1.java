package com.youku.opengl.widget;

import com.youku.opengl.a.a;

/* compiled from: Taobao */
class YkGLRenderer$1 implements Runnable {
    final /* synthetic */ h this$0;
    final /* synthetic */ c val$listener;

    YkGLRenderer$1(h hVar, c cVar) {
        this.this$0 = hVar;
        this.val$listener = cVar;
    }

    public void run() {
        this.this$0.m.add(this.val$listener);
        if (a.b) {
            a.a("YkGLRenderer", "addSurfaceListener() - added listener:" + this.val$listener);
        }
        this.val$listener.a();
        c cVar = this.val$listener;
        int[] iArr = this.this$0.b;
        cVar.a(iArr[0], iArr[1]);
    }
}
