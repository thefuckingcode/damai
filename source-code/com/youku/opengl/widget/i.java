package com.youku.opengl.widget;

import com.youku.opengl.a.a;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class i extends e {
    private final ArrayList<e> e;

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        a(new YkGLRendererGroup$1(this, eVar));
    }

    @Override // com.youku.opengl.widget.e
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);
        b();
        for (int i = 0; i < this.e.size(); i++) {
            if (a.b) {
                a.a("YkGLRendererGroup", "onDrawFrame() - calling " + i);
            }
            this.e.get(i).onDrawFrame(gl10);
            if (a.b) {
                a.a("YkGLRendererGroup", "onDrawFrame() - called " + i);
            }
        }
        c();
    }

    @Override // com.youku.opengl.widget.e
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        super.onSurfaceChanged(gl10, i, i2);
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            if (a.b) {
                a.a("YkGLRendererGroup", "onSurfaceChanged() - calling " + i3);
            }
            this.e.get(i3).onSurfaceChanged(gl10, i, i2);
            if (a.b) {
                a.a("YkGLRendererGroup", "onSurfaceChanged() - called " + i3);
            }
        }
    }

    @Override // com.youku.opengl.widget.e
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        super.onSurfaceCreated(gl10, eGLConfig);
        for (int i = 0; i < this.e.size(); i++) {
            if (a.b) {
                a.a("YkGLRendererGroup", "onSurfaceCreated() - calling " + i);
            }
            this.e.get(i).onSurfaceCreated(gl10, eGLConfig);
            if (a.b) {
                a.a("YkGLRendererGroup", "onSurfaceCreated() - called " + i);
            }
        }
    }
}
