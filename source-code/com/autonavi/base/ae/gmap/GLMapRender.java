package com.autonavi.base.ae.gmap;

import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.amap.api.mapcore.util.hd;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
public class GLMapRender implements GLSurfaceView.Renderer {
    public static final int ANIMATION_TICK_COUNT = 10;
    public static final int LONG_LONG_TICK_COUNT = 30;
    public static final int LONG_TICK_COUNT = 6;
    private static final int MAP_RENDER_MSG_RUNNABLE_ONGLTHREAD = 100;
    private static final int MAP_RENDER_MSG_SURFACE_RENDER = 10;
    public static final int NORMAL_TICK_COUNT = 2;
    public static final int RENDER_FPS_ANIMATION = 30;
    public static final int RENDER_FPS_GESTURE_ACTION = 40;
    static final int RENDER_FPS_MAX = 60;
    public static final int RENDER_FPS_NAVI = 10;
    public static final int RENDER_FPS_NORMAL = 15;
    static final long RENDER_TIMMER_DIFF_MIN = 16;
    static final String TAG = "render";
    private volatile AtomicLong mDrawFrameTickCount = new AtomicLong(6);
    public IAMap mGLMapView;
    private Handler mGLRenderHandler = null;
    private HandlerThread mGLRenderThread = null;
    private volatile boolean mIsRendPause = false;
    private boolean mIsTrafficMode = false;
    private long mLastFrameTime = System.currentTimeMillis();
    public volatile boolean mSurfacedestoryed = false;
    private int mTargetFrameDurationMillis = 66;
    private float mTargetRenderFPS = 15.0f;

    public GLMapRender(IAMap iAMap) {
        this.mGLMapView = iAMap;
    }

    private void drawSingleFrame(GL10 gl10) {
        try {
            this.mGLMapView.drawFrame(gl10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isRenderPause() {
        return this.mIsRendPause;
    }

    public void onAttachedToWindow() {
        if (this.mGLRenderThread == null) {
            HandlerThread handlerThread = new HandlerThread(" AMapGlRenderThread");
            this.mGLRenderThread = handlerThread;
            handlerThread.start();
            this.mGLRenderHandler = new Handler(this.mGLRenderThread.getLooper()) {
                /* class com.autonavi.base.ae.gmap.GLMapRender.AnonymousClass1 */

                public void handleMessage(Message message) {
                    IAMap iAMap;
                    int i = message.what;
                    if (i != 10) {
                        if (i == 100) {
                            ((Runnable) message.obj).run();
                        }
                    } else if (!GLMapRender.this.mIsRendPause && (iAMap = GLMapRender.this.mGLMapView) != null && iAMap.getRenderMode() == 0) {
                        GLMapRender.this.mGLMapView.requestRender();
                    }
                }
            };
        }
    }

    public void onDetachedFromWindow() {
        HandlerThread handlerThread = this.mGLRenderThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mGLRenderThread = null;
            this.mGLRenderHandler = null;
        }
    }

    public void onDrawFrame(GL10 gl10) {
        HandlerThread handlerThread;
        long j;
        Handler handler;
        if (this.mGLMapView != null) {
            try {
                this.mLastFrameTime = System.currentTimeMillis();
                drawSingleFrame(gl10);
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = currentTimeMillis - this.mLastFrameTime;
                this.mLastFrameTime = currentTimeMillis;
                long j3 = this.mDrawFrameTickCount.get();
                if (this.mGLMapView.getRenderMode() == 0 && this.mGLRenderHandler != null && (handlerThread = this.mGLRenderThread) != null && handlerThread.isAlive()) {
                    long j4 = j3 - 1;
                    this.mDrawFrameTickCount.set(j4);
                    if (j4 > 0) {
                        j = Math.max(16L, ((long) this.mTargetFrameDurationMillis) - j2);
                    } else if (j4 > ((long) -5)) {
                        j = 60;
                    } else if (j4 > ((long) -7)) {
                        j = 100;
                    } else if (j4 > ((long) -9)) {
                        j = 250;
                    } else {
                        j = this.mIsTrafficMode ? 10000 : 500;
                        this.mDrawFrameTickCount.set(-9);
                    }
                    if (j > 0 && (handler = this.mGLRenderHandler) != null) {
                        handler.removeMessages(10);
                        this.mGLRenderHandler.sendEmptyMessageDelayed(10, j);
                    }
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapRender", "onDrawFrame");
            }
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        if (this.mSurfacedestoryed) {
            onSurfaceCreated(gl10, null);
        }
        this.mGLMapView.changeSurface(gl10, i, i2);
        resetTickCount(30);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.mIsRendPause = false;
        this.mSurfacedestoryed = false;
        this.mGLMapView.createSurface(gl10, eGLConfig);
    }

    public void onSurfaceDestory() {
        this.mIsRendPause = true;
        Handler handler = this.mGLRenderHandler;
        if (!(handler == null || this.mGLRenderThread == null)) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mGLMapView.destroySurface(1);
        this.mSurfacedestoryed = true;
    }

    public void renderPause() {
        HandlerThread handlerThread;
        if (!(this.mGLRenderHandler == null || (handlerThread = this.mGLRenderThread) == null || !handlerThread.isAlive())) {
            this.mGLRenderHandler.removeMessages(10);
        }
        this.mIsRendPause = true;
    }

    public void renderResume() {
        HandlerThread handlerThread;
        if (!(this.mGLRenderHandler == null || (handlerThread = this.mGLRenderThread) == null || !handlerThread.isAlive())) {
            this.mGLRenderHandler.removeMessages(10);
        }
        this.mIsRendPause = false;
        this.mDrawFrameTickCount.set(-1);
        resetTickCount(30);
    }

    public void resetTickCount(int i) {
        HandlerThread handlerThread;
        long j = this.mDrawFrameTickCount.get();
        if (this.mIsRendPause || (handlerThread = this.mGLRenderThread) == null || this.mGLRenderHandler == null || !handlerThread.isAlive()) {
            long j2 = (long) i;
            if (j < j2) {
                this.mDrawFrameTickCount.set(j2);
            }
        } else if (j <= 0) {
            this.mDrawFrameTickCount.set((long) i);
            this.mGLRenderHandler.removeMessages(10);
            this.mGLRenderHandler.sendEmptyMessage(10);
        } else {
            long j3 = (long) i;
            if (j < j3) {
                this.mDrawFrameTickCount.set(j3);
            }
        }
    }

    public void sendToRenderEvent(Runnable runnable) {
        HandlerThread handlerThread;
        if (this.mGLRenderHandler != null && (handlerThread = this.mGLRenderThread) != null && handlerThread.isAlive()) {
            this.mGLRenderHandler.post(runnable);
        }
    }

    public void setRenderFps(float f) {
        if (this.mTargetRenderFPS != f && f > 0.0f) {
            this.mTargetFrameDurationMillis = (int) ((1.0f / f) * 1000.0f);
            this.mTargetRenderFPS = f;
        }
    }

    public void setTrafficMode(boolean z) {
        this.mIsTrafficMode = z;
    }
}
