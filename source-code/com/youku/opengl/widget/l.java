package com.youku.opengl.widget;

import android.opengl.GLSurfaceView;
import android.view.TextureView;
import androidx.core.internal.view.SupportMenu;
import com.youku.opengl.filter.b;
import com.youku.opengl.filter.c;
import com.youku.opengl.filter.e;

/* compiled from: Taobao */
public class l extends GLSurfaceView implements a {
    private i a;
    private n b;
    private b c;
    private h d;
    private com.youku.media.b e;
    private a f;
    private k g;
    private final g h;

    /* compiled from: Taobao */
    public class a {
        private b b;
        private m c;
        private n d;
        private h e;
        private k f;

        private a() {
            c cVar;
            com.youku.opengl.a.a.a("YkGLFgVideoSurface", "YkGLForegroundVideoSurface()");
            n nVar = new n(l.this);
            this.d = nVar;
            nVar.a("-front");
            m mVar = new m();
            this.c = mVar;
            mVar.a(l.this.h);
            if (com.youku.opengl.a.a.b) {
                cVar = a();
            } else {
                c cVar2 = new c();
                cVar2.a(new e());
                cVar2.a(this.c);
                cVar = cVar2;
            }
            this.b = cVar;
            h hVar = new h(l.this, this.d, this.b);
            this.e = hVar;
            hVar.a(1.0f, 1.0f, 1.0f, 0.0f);
            l.this.a.a(this.e);
        }

        /* synthetic */ a(l lVar, YkGLVideoSurfaceView$1 ykGLVideoSurfaceView$1) {
            this();
        }

        private b a() {
            c cVar = new c();
            cVar.a(new e());
            k kVar = new k();
            this.f = kVar;
            kVar.c(SupportMenu.CATEGORY_MASK);
            this.f.b(30);
            this.f.a(0.0f, 0.3f);
            this.f.a(this.d);
            cVar.a(this.f);
            cVar.a(this.c);
            return cVar;
        }
    }

    /* access modifiers changed from: private */
    public synchronized a a(boolean z) {
        if (this.f == null && z) {
            this.f = new a(this, null);
        }
        return this.f;
    }

    private void a(Runnable runnable) {
        this.a.a(runnable);
    }

    private void b(Runnable runnable) {
        this.a.b(runnable);
    }

    private b getDebugSyncFilter() {
        c cVar = new c();
        cVar.a(new e());
        k kVar = new k();
        this.g = kVar;
        kVar.c(-1);
        this.g.b(30);
        this.g.a(0.0f, 0.4f);
        this.g.a(this.e);
        this.g.a(this.b);
        cVar.a(this.g);
        return cVar;
    }

    public int getDecodingFps() {
        return this.b.j();
    }

    public int getDrawFps() {
        return this.d.f();
    }

    public a getForegroundVideoSurface() {
        return a(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "onDetachedFromWindow()");
        this.b.i();
        this.c.e();
        a a2 = a(false);
        if (a2 != null) {
            a2.d.i();
            a2.b.e();
        }
    }

    public void setFilter(b bVar) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "setImageFilter() - filter:" + bVar);
        }
        a(new YkGLVideoSurfaceView$1(this, bVar));
        if (bVar instanceof com.youku.opengl.filter.a) {
            com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "setFilter() - set z-order on top");
            setZOrderOnTop(true);
            getHolder().setFormat(-2);
        }
    }

    public void setRenderType(int i) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "setRenderType() - renderType:" + i);
        }
        a(new YkGLVideoSurfaceView$5(this, i));
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "setSurfaceTextureListener() - listener:" + surfaceTextureListener);
        }
        a(new YkGLVideoSurfaceView$3(this, surfaceTextureListener));
    }

    public void setVideoPtsProvider(com.youku.media.b bVar) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "setVideoPtsProvider() - provider:" + bVar);
        }
        b(new YkGLVideoSurfaceView$2(this, bVar));
    }
}
