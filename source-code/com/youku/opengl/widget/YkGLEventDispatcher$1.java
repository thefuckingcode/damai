package com.youku.opengl.widget;

import com.youku.opengl.a.a;
import java.util.ArrayList;
import java.util.Iterator;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class YkGLEventDispatcher$1 implements Runnable {
    final /* synthetic */ g this$0;
    final /* synthetic */ f val$event;
    final /* synthetic */ ArrayList val$listeners;

    YkGLEventDispatcher$1(g gVar, ArrayList arrayList, f fVar) {
        this.this$0 = gVar;
        this.val$listeners = arrayList;
        this.val$event = fVar;
    }

    public void run() {
        Iterator it = this.val$listeners.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (a.b) {
                a.a("YkGLEventDispatcher", "dispatchEvent() - notifying listener:" + bVar);
            }
            bVar.a(this.val$event);
            if (a.b) {
                a.a("YkGLEventDispatcher", "dispatchEvent() - notified listener:" + bVar);
            }
        }
    }
}
