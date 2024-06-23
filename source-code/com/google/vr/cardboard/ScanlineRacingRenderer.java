package com.google.vr.cardboard;

import android.graphics.Point;
import android.opengl.GLSurfaceView;
import android.os.Process;
import com.google.vr.ndk.base.GvrApi;
import com.google.vr.ndk.base.GvrSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import tb.f5;
import tb.vk2;

/* compiled from: Taobao */
public class ScanlineRacingRenderer implements GLSurfaceView.Renderer {
    private final GvrApi a;
    private GvrSurfaceView b;

    public ScanlineRacingRenderer(GvrApi gvrApi) {
        if (gvrApi != null) {
            this.a = gvrApi;
            return;
        }
        throw new IllegalArgumentException("GvrApi must be supplied for proper scanline rendering");
    }

    public void b() {
        c();
    }

    public void c() {
        this.a.onPauseReprojectionThread();
    }

    public void d(final int i, final int i2) {
        vk2.a(new Runnable() {
            /* class com.google.vr.cardboard.ScanlineRacingRenderer.AnonymousClass1 */

            public void run() {
                if (i <= 0 || i2 <= 0) {
                    ScanlineRacingRenderer.this.b.getHolder().setSizeFromLayout();
                } else {
                    ScanlineRacingRenderer.this.b.getHolder().setFixedSize(i, i2);
                }
            }
        });
    }

    public void e(GvrSurfaceView gvrSurfaceView) {
        if (gvrSurfaceView != null) {
            this.b = gvrSurfaceView;
            return;
        }
        throw new IllegalArgumentException("GvrSurfaceView must be supplied for proper scanline rendering");
    }

    public void onDrawFrame(GL10 gl10) {
        Point renderReprojectionThread = this.a.renderReprojectionThread();
        if (renderReprojectionThread != null) {
            d(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(renderReprojectionThread), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(renderReprojectionThread));
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.a.onSurfaceChangedReprojectionThread();
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Thread.currentThread().setPriority(10);
        f5.j(Process.myTid());
        this.a.onSurfaceCreatedReprojectionThread();
    }
}
