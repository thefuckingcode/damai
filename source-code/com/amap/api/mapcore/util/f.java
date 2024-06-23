package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* compiled from: Taobao */
public class f extends n implements IGLSurfaceView {
    protected boolean a = false;
    private IAMapDelegate b = null;
    private GLMapRender c = null;

    public f(Context context, boolean z) {
        super(context, null);
        dy.a(this, 5, 6, 5, 0, 16, 8);
        this.b = new c(this, context, null, z);
    }

    @Override // com.amap.api.mapcore.util.n
    public void b() {
        if (!this.c.mSurfacedestoryed) {
            queueEvent(new Runnable() {
                /* class com.amap.api.mapcore.util.f.AnonymousClass1 */

                public void run() {
                    try {
                        if (f.this.c != null) {
                            f.this.c.onSurfaceDestory();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        eq.a(th);
                    }
                }
            });
            int i = 0;
            while (!this.c.mSurfacedestoryed) {
                int i2 = i + 1;
                if (i >= 50) {
                    break;
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException unused) {
                }
                i = i2;
            }
        }
        super.b();
    }

    @Override // com.amap.api.mapcore.util.n
    public void c() {
        super.c();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public SurfaceHolder getHolder() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.n
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            GLMapRender gLMapRender = this.c;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        c();
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.n
    public void onDetachedFromWindow() {
        if (!MapsInitializer.isSupportRecycleView()) {
            b();
            try {
                GLMapRender gLMapRender = this.c;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void onDetachedGLThread() {
        if (MapsInitializer.isSupportRecycleView()) {
            b();
            try {
                GLMapRender gLMapRender = this.c;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // com.amap.api.mapcore.util.n
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        requestRender();
        try {
            if (MapsInitializer.getTextureDestroyRender()) {
                Thread.sleep(100);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.b.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            GLMapRender gLMapRender = this.c;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
                this.a = false;
            }
            requestRender();
        } else if (i == 0) {
            try {
                GLMapRender gLMapRender2 = this.c;
                if (gLMapRender2 != null) {
                    gLMapRender2.renderResume();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                eq.a(th);
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setEGLConfigChooser(dw dwVar) {
        super.a(dwVar);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setEGLContextFactory(dx dxVar) {
        super.a(dxVar);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView, com.amap.api.mapcore.util.n
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setZOrderOnTop(boolean z) {
    }

    public IAMapDelegate a() {
        return this.b;
    }
}
