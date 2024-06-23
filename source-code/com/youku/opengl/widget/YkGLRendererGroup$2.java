package com.youku.opengl.widget;

import com.youku.opengl.a.a;

/* compiled from: Taobao */
class YkGLRendererGroup$2 implements Runnable {
    final /* synthetic */ i this$0;
    final /* synthetic */ e val$renderer;

    YkGLRendererGroup$2(i iVar, e eVar) {
        this.this$0 = iVar;
        this.val$renderer = eVar;
    }

    public void run() {
        this.this$0.e.remove(this.val$renderer);
        if (a.b) {
            a.a("YkGLRendererGroup", "removeRenderer() - removed render:" + this.val$renderer);
        }
    }
}
