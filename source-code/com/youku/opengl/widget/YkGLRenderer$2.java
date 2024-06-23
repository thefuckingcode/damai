package com.youku.opengl.widget;

import com.youku.opengl.a.a;

/* compiled from: Taobao */
class YkGLRenderer$2 implements Runnable {
    final /* synthetic */ h this$0;
    final /* synthetic */ c val$listener;

    YkGLRenderer$2(h hVar, c cVar) {
        this.this$0 = hVar;
        this.val$listener = cVar;
    }

    public void run() {
        this.this$0.m.remove(this.val$listener);
        if (a.b) {
            a.a("YkGLRenderer", "removeSurfaceListener() - removed listener:" + this.val$listener);
        }
    }
}
