package com.amap.api.mapcore.util;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* compiled from: Taobao */
public class e extends GLSurfaceView implements IGLSurfaceView {
    protected boolean a;
    private IAMapDelegate b;
    private GLMapRender c;

    public e(Context context, boolean z) {
        this(context, null, z);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            GLMapRender gLMapRender = this.c;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
        onResume();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (!MapsInitializer.isSupportRecycleView()) {
            onPause();
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
            onPause();
            try {
                GLMapRender gLMapRender = this.c;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                eq.a(th);
            }
            super.onDetachedFromWindow();
        }
    }

    public void onPause() {
        if (!this.c.mSurfacedestoryed) {
            queueEvent(new Runnable() {
                /* class com.amap.api.mapcore.util.e.AnonymousClass1 */

                public void run() {
                    if (e.this.c != null) {
                        try {
                            e.this.c.onSurfaceDestory();
                        } catch (Throwable th) {
                            th.printStackTrace();
                            eq.a(th);
                        }
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
        super.onPause();
    }

    public void onResume() {
        super.onResume();
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
        super.setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) dwVar);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setEGLContextFactory(dx dxVar) {
        super.setEGLContextFactory((GLSurfaceView.EGLContextFactory) dxVar);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    public e(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.a = false;
        dy.a(this, 5, 6, 5, 0, 16, 8);
        this.b = new c(this, context, attributeSet, z);
    }

    public IAMapDelegate a() {
        return this.b;
    }
}
