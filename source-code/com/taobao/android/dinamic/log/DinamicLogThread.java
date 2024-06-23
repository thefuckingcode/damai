package com.taobao.android.dinamic.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: Taobao */
public class DinamicLogThread extends HandlerThread {
    private static HandlerThread handlerThread;
    private static boolean isInited;
    public static a threadHandler;

    /* compiled from: Taobao */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                Object obj = message.obj;
                if (obj != null && (obj instanceof Runnable)) {
                    ((Runnable) obj).run();
                }
            } catch (Throwable unused) {
            }
            super.handleMessage(message);
        }
    }

    private DinamicLogThread(String str) {
        super(str);
    }

    public static boolean checkInit() {
        return isInited;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    public static synchronized void init(String str) {
        synchronized (DinamicLogThread.class) {
            if (!isInited) {
                DinamicLogThread dinamicLogThread = new DinamicLogThread(str);
                handlerThread = dinamicLogThread;
                Looper looper = null;
                dinamicLogThread.start();
                try {
                    looper = handlerThread.getLooper();
                } catch (Throwable unused) {
                }
                threadHandler = new a(looper);
                isInited = true;
            }
        }
    }
}
