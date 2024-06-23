package com.youku.opengl.widget;

import android.opengl.GLSurfaceView;
import com.youku.opengl.a.a;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class e implements GLSurfaceView.Renderer {
    protected boolean a = true;
    protected final int[] b = {0, 0};
    protected GL10 c;
    protected EGLConfig d;
    private a e;
    private final LinkedList<Runnable> f = new LinkedList<>();
    private final LinkedList<Runnable> g = new LinkedList<>();

    e(a aVar) {
        this.e = aVar;
    }

    private void a(LinkedList<Runnable> linkedList) {
        LinkedList linkedList2;
        synchronized (linkedList) {
            linkedList2 = (LinkedList) linkedList.clone();
            linkedList.clear();
        }
        while (!linkedList2.isEmpty()) {
            ((Runnable) linkedList2.poll()).run();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a.a("YkGLAbstractRenderer", "requestRender()");
        this.e.requestRender();
    }

    /* access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        synchronized (this.f) {
            this.f.add(runnable);
        }
        a();
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        this.a = z;
    }

    /* access modifiers changed from: protected */
    public void b() {
        a(this.f);
    }

    /* access modifiers changed from: package-private */
    public void b(Runnable runnable) {
        synchronized (this.g) {
            this.g.add(runnable);
        }
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        a(this.g);
    }

    public void onDrawFrame(GL10 gl10) {
        if (a.b) {
            a.a("YkGLAbstractRenderer", "onDrawFrame() - gl:" + gl10);
        }
        this.c = gl10;
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        if (a.b) {
            a.a("YkGLAbstractRenderer", "onSurfaceChanged() - gl:" + gl10 + " width:" + i + " height:" + i2);
        }
        this.c = gl10;
        int[] iArr = this.b;
        iArr[0] = i;
        iArr[1] = i2;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        if (a.b) {
            a.a("YkGLAbstractRenderer", "onSurfaceCreated() - gl:" + gl10 + " config:" + eGLConfig);
        }
        this.c = gl10;
        this.d = eGLConfig;
    }
}
