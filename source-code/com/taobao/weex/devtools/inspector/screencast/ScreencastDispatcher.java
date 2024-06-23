package com.taobao.weex.devtools.inspector.screencast;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64OutputStream;
import android.view.View;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.inspector.elements.android.ActivityTracker;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.protocol.module.Page;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
public final class ScreencastDispatcher {
    private static final long FRAME_DELAY = 200;
    private static float sBitmapScale = 1.0f;
    private final ActivityTracker mActivityTracker = ActivityTracker.get();
    private Handler mBackgroundHandler;
    private Bitmap mBitmap;
    private final BitmapFetchRunnable mBitmapFetchRunnable = new BitmapFetchRunnable();
    private Canvas mCanvas;
    private Page.ScreencastFrameEvent mEvent = new Page.ScreencastFrameEvent();
    private final EventDispatchRunnable mEventDispatchRunnable = new EventDispatchRunnable();
    private HandlerThread mHandlerThread;
    private boolean mIsRunning;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private Page.ScreencastFrameEventMetadata mMetadata = new Page.ScreencastFrameEventMetadata();
    private JsonRpcPeer mPeer;
    private Page.StartScreencastRequest mRequest;
    private ByteArrayOutputStream mStream;
    private final RectF mTempDst = new RectF();
    private final RectF mTempSrc = new RectF();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class BitmapFetchRunnable implements Runnable {
        private BitmapFetchRunnable() {
        }

        private void updateScreenBitmap() {
            Activity tryGetTopActivity;
            if (ScreencastDispatcher.this.mIsRunning && (tryGetTopActivity = ScreencastDispatcher.this.mActivityTracker.tryGetTopActivity()) != null) {
                View decorView = tryGetTopActivity.getWindow().getDecorView();
                try {
                    if (ScreencastDispatcher.this.mBitmap == null) {
                        int width = decorView.getWidth();
                        int height = decorView.getHeight();
                        if (width <= 0) {
                            return;
                        }
                        if (height > 0) {
                            float f = (float) width;
                            float f2 = (float) height;
                            float min = Math.min(((float) ScreencastDispatcher.this.mRequest.maxWidth) / f, ((float) ScreencastDispatcher.this.mRequest.maxHeight) / f2);
                            float unused = ScreencastDispatcher.sBitmapScale = min;
                            int i = (int) (f * min);
                            int i2 = (int) (min * f2);
                            ScreencastDispatcher.this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
                            ScreencastDispatcher.this.mCanvas = new Canvas(ScreencastDispatcher.this.mBitmap);
                            Matrix matrix = new Matrix();
                            ScreencastDispatcher.this.mTempSrc.set(0.0f, 0.0f, f, f2);
                            ScreencastDispatcher.this.mTempDst.set(0.0f, 0.0f, (float) i, (float) i2);
                            matrix.setRectToRect(ScreencastDispatcher.this.mTempSrc, ScreencastDispatcher.this.mTempDst, Matrix.ScaleToFit.CENTER);
                            ScreencastDispatcher.this.mCanvas.setMatrix(matrix);
                        } else {
                            return;
                        }
                    }
                    decorView.draw(ScreencastDispatcher.this.mCanvas);
                } catch (OutOfMemoryError unused2) {
                    LogUtil.w("Out of memory trying to allocate screencast Bitmap.");
                }
            }
        }

        public void run() {
            updateScreenBitmap();
            ScreencastDispatcher.this.mBackgroundHandler.post(ScreencastDispatcher.this.mEventDispatchRunnable.withEndAction(this));
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class CancellationRunnable implements Runnable {
        private CancellationRunnable() {
        }

        public void run() {
            ScreencastDispatcher.this.mHandlerThread.interrupt();
            ScreencastDispatcher.this.mMainHandler.removeCallbacks(ScreencastDispatcher.this.mBitmapFetchRunnable);
            ScreencastDispatcher.this.mBackgroundHandler.removeCallbacks(ScreencastDispatcher.this.mEventDispatchRunnable);
            ScreencastDispatcher.this.mIsRunning = false;
            ScreencastDispatcher.this.mHandlerThread = null;
            ScreencastDispatcher.this.mBitmap = null;
            ScreencastDispatcher.this.mCanvas = null;
            ScreencastDispatcher.this.mStream = null;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class EventDispatchRunnable implements Runnable {
        private Runnable mEndAction;

        private EventDispatchRunnable() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private EventDispatchRunnable withEndAction(Runnable runnable) {
            this.mEndAction = runnable;
            return this;
        }

        public void run() {
            if (ScreencastDispatcher.this.mIsRunning && ScreencastDispatcher.this.mBitmap != null) {
                int width = ScreencastDispatcher.this.mBitmap.getWidth();
                int height = ScreencastDispatcher.this.mBitmap.getHeight();
                ScreencastDispatcher.this.mStream.reset();
                Base64OutputStream base64OutputStream = new Base64OutputStream(ScreencastDispatcher.this.mStream, 0);
                ScreencastDispatcher.this.mBitmap.compress(Bitmap.CompressFormat.valueOf(ScreencastDispatcher.this.mRequest.format.toUpperCase()), ScreencastDispatcher.this.mRequest.quality, base64OutputStream);
                ScreencastDispatcher.this.mEvent.data = ScreencastDispatcher.this.mStream.toString();
                ScreencastDispatcher.this.mMetadata.pageScaleFactor = ScreencastDispatcher.sBitmapScale;
                ScreencastDispatcher.this.mMetadata.deviceWidth = width;
                ScreencastDispatcher.this.mMetadata.deviceHeight = height;
                ScreencastDispatcher.this.mEvent.metadata = ScreencastDispatcher.this.mMetadata;
                if (ScreencastDispatcher.this.mPeer.getWebSocket() != null && ScreencastDispatcher.this.mPeer.getWebSocket().isOpen()) {
                    ScreencastDispatcher.this.mPeer.invokeMethod("Page.screencastFrame", ScreencastDispatcher.this.mEvent, null);
                    ScreencastDispatcher.this.mMainHandler.postDelayed(this.mEndAction, ScreencastDispatcher.FRAME_DELAY);
                }
            }
        }
    }

    public static float getsBitmapScale() {
        return sBitmapScale;
    }

    public void startScreencast(JsonRpcPeer jsonRpcPeer, Page.StartScreencastRequest startScreencastRequest) {
        this.mRequest = startScreencastRequest;
        HandlerThread handlerThread = new HandlerThread("Screencast Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mPeer = jsonRpcPeer;
        this.mIsRunning = true;
        this.mStream = new ByteArrayOutputStream();
        this.mBackgroundHandler = new Handler(this.mHandlerThread.getLooper());
        this.mMainHandler.postDelayed(this.mBitmapFetchRunnable, FRAME_DELAY);
    }

    public void stopScreencast() {
        this.mBackgroundHandler.post(new CancellationRunnable());
    }
}
