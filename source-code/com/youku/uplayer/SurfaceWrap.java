package com.youku.uplayer;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.youku.player.util.d;

/* compiled from: Taobao */
public class SurfaceWrap extends Surface {
    private static final String TAG = "SurfaceWrap";
    private int mDecoderId = -1;
    private Handler mHandler;
    private int mHeight;
    private int mRenderCtx = 0;
    private int mWidth;

    public SurfaceWrap(SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        boolean z;
        boolean z2;
        Exception e;
        int i = 0;
        try {
            z = Boolean.parseBoolean(d.a().a("youku_player_config", "render_in_main", "false"));
            try {
                z2 = Boolean.parseBoolean(d.a().a("youku_player_config", "surfacewrap_thread_background", "false"));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            e.printStackTrace();
            z2 = false;
            if (Build.VERSION.SDK_INT >= 21) {
            }
            surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                /* class com.youku.uplayer.SurfaceWrap.AnonymousClass2 */

                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    SurfaceWrap surfaceWrap = SurfaceWrap.this;
                    surfaceWrap.notifyFrameAvailable(surfaceWrap.mRenderCtx, SurfaceWrap.this.mWidth, SurfaceWrap.this.mHeight, SurfaceWrap.this.mDecoderId);
                }
            });
            return;
        }
        if (Build.VERSION.SDK_INT >= 21 || z) {
            surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                /* class com.youku.uplayer.SurfaceWrap.AnonymousClass2 */

                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    SurfaceWrap surfaceWrap = SurfaceWrap.this;
                    surfaceWrap.notifyFrameAvailable(surfaceWrap.mRenderCtx, SurfaceWrap.this.mWidth, SurfaceWrap.this.mHeight, SurfaceWrap.this.mDecoderId);
                }
            });
            return;
        }
        HandlerThread handlerThread = new HandlerThread(TAG, z2 ? 10 : i);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            /* class com.youku.uplayer.SurfaceWrap.AnonymousClass1 */

            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                SurfaceWrap surfaceWrap = SurfaceWrap.this;
                surfaceWrap.notifyFrameAvailable(surfaceWrap.mRenderCtx, SurfaceWrap.this.mWidth, SurfaceWrap.this.mHeight, SurfaceWrap.this.mDecoderId);
            }
        }, this.mHandler);
    }

    public void SetData(int i) {
        this.mRenderCtx = i;
    }

    public void SetHeight(int i) {
        this.mHeight = i;
    }

    public void SetRenderCtx(int i, int i2) {
        this.mRenderCtx = i;
        this.mDecoderId = i2;
    }

    public void SetWidth(int i) {
        this.mWidth = i;
    }

    /* access modifiers changed from: package-private */
    public native void notifyFrameAvailable(int i, int i2, int i3, int i4);

    public void release() {
        super.release();
        if (this.mHandler != null && Looper.getMainLooper() != this.mHandler.getLooper()) {
            this.mHandler.getLooper().quit();
        }
    }
}
