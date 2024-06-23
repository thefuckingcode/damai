package com.youku.opengl.widget;

import android.os.Handler;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class g {
    private final Handler a;
    private ArrayList<b> b;

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = (ArrayList) this.b.clone();
        }
        this.a.post(new YkGLEventDispatcher$1(this, arrayList, fVar));
    }
}
