package com.youku.opengl.widget;

import com.youku.opengl.a.a;
import javax.microedition.khronos.opengles.GL10;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class YkGLRendererGroup$1 implements Runnable {
    final /* synthetic */ i this$0;
    final /* synthetic */ e val$renderer;

    YkGLRendererGroup$1(i iVar, e eVar) {
        this.this$0 = iVar;
        this.val$renderer = eVar;
    }

    public void run() {
        this.val$renderer.a(false);
        this.this$0.e.add(this.val$renderer);
        if (a.b) {
            a.a("YkGLRendererGroup", "addRenderer() - added renderer:" + this.val$renderer);
        }
        e eVar = this.val$renderer;
        i iVar = this.this$0;
        eVar.onSurfaceCreated(iVar.c, iVar.d);
        e eVar2 = this.val$renderer;
        i iVar2 = this.this$0;
        GL10 gl10 = iVar2.c;
        int[] iArr = iVar2.b;
        eVar2.onSurfaceChanged(gl10, iArr[0], iArr[1]);
    }
}
