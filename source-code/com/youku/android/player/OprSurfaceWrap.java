package com.youku.android.player;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class OprSurfaceWrap extends Surface {
    private static final String TAG = "OprSurfaceWrap";
    private int mEngineId = 0;
    private Handler mHandler;
    private int mHeight = 0;
    private int mLayerId = -1;
    private boolean mSurfaceFlag = true;
    private int mWidth = 0;

    public OprSurfaceWrap(SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        if (Build.VERSION.SDK_INT >= 21) {
            HandlerThread handlerThread = new HandlerThread(TAG, 0);
            handlerThread.start();
            this.mHandler = new Handler(handlerThread.getLooper());
            surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                /* class com.youku.android.player.OprSurfaceWrap.AnonymousClass1 */

                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    if (OprSurfaceWrap.this.mSurfaceFlag) {
                        OprSurfaceWrap oprSurfaceWrap = OprSurfaceWrap.this;
                        oprSurfaceWrap.notifyFrameAvailable(oprSurfaceWrap.mWidth, OprSurfaceWrap.this.mHeight, OprSurfaceWrap.this.mEngineId, OprSurfaceWrap.this.mLayerId);
                        return;
                    }
                    Log.w(OprSurfaceWrap.TAG, "aliplayer not running, do not call notifyFrameAvailable");
                }
            }, this.mHandler);
            return;
        }
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            /* class com.youku.android.player.OprSurfaceWrap.AnonymousClass2 */

            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (OprSurfaceWrap.this.mSurfaceFlag) {
                    OprSurfaceWrap oprSurfaceWrap = OprSurfaceWrap.this;
                    oprSurfaceWrap.notifyFrameAvailable(oprSurfaceWrap.mWidth, OprSurfaceWrap.this.mHeight, OprSurfaceWrap.this.mEngineId, OprSurfaceWrap.this.mLayerId);
                    return;
                }
                Log.w(OprSurfaceWrap.TAG, "aliplayer not running, do not call notifyFrameAvailable");
            }
        });
    }

    public void SetHeight(int i) {
        this.mHeight = i;
    }

    public void SetOprSurfaceFlag(boolean z) {
        this.mSurfaceFlag = z;
    }

    public void SetRenderCtx(int i, int i2) {
        this.mEngineId = i;
        this.mLayerId = i2;
    }

    public void SetWidth(int i) {
        this.mWidth = i;
    }

    public native void nativeNotifyFrameAvailable(int i, int i2, int i3, int i4);

    public void notifyFrameAvailable(int i, int i2, int i3, int i4) {
        nativeNotifyFrameAvailable(i, i2, i3, i4);
    }

    public void release() {
        super.release();
        if (this.mHandler != null && Looper.getMainLooper() != this.mHandler.getLooper()) {
            this.mHandler.getLooper().quit();
        }
    }
}
