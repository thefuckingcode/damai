package com.youku.alixplayer.opensdk.utils;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: Taobao */
public class AsyncTasker {
    private static AsyncTasker sAsyncTasker;
    private HandlerThread mHandleThread;
    private Handler mHandler = new Handler(this.mHandleThread.getLooper());

    private AsyncTasker() {
        HandlerThread handlerThread = new HandlerThread("AsyncTasker-playerservice");
        this.mHandleThread = handlerThread;
        handlerThread.start();
    }

    public static AsyncTasker getInstance() {
        if (sAsyncTasker == null) {
            synchronized (AsyncTasker.class) {
                if (sAsyncTasker == null) {
                    sAsyncTasker = new AsyncTasker();
                }
            }
        }
        return sAsyncTasker;
    }

    public void asyncCall(Runnable runnable) {
        Handler handler;
        if (runnable != null && (handler = this.mHandler) != null) {
            handler.post(runnable);
        }
    }

    public void asyncCall(Runnable runnable, long j) {
        Handler handler;
        if (runnable != null && (handler = this.mHandler) != null) {
            handler.postDelayed(runnable, j);
        }
    }
}
