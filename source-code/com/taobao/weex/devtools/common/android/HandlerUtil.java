package com.taobao.weex.devtools.common.android;

import android.os.Handler;
import android.os.Looper;
import com.taobao.weex.devtools.common.UncheckedCallable;
import com.taobao.weex.devtools.common.Util;

/* compiled from: Taobao */
public final class HandlerUtil {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class WaitableRunnable<V> implements Runnable {
        private Exception mException;
        private boolean mIsDone;
        private V mValue;

        protected WaitableRunnable() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
        /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:11:0x0001, LOOP_START, SYNTHETIC] */
        private void join() {
            synchronized (this) {
                while (!this.mIsDone) {
                    wait();
                }
            }
        }

        public V invoke(Handler handler) {
            if (handler.post(this)) {
                join();
                if (this.mException == null) {
                    return this.mValue;
                }
                throw new RuntimeException(this.mException);
            }
            throw new RuntimeException("Handler.post() returned false");
        }

        /* access modifiers changed from: protected */
        public abstract V onRun();

        public final void run() {
            try {
                this.mValue = onRun();
                this.mException = null;
                synchronized (this) {
                    this.mIsDone = true;
                    notifyAll();
                }
            } catch (Exception e) {
                try {
                    this.mValue = null;
                    this.mException = e;
                    synchronized (this) {
                        this.mIsDone = true;
                        notifyAll();
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        this.mIsDone = true;
                        notifyAll();
                        throw th;
                    }
                }
            }
        }
    }

    private HandlerUtil() {
    }

    public static boolean checkThreadAccess(Handler handler) {
        return Looper.myLooper() == handler.getLooper();
    }

    public static <V> V postAndWait(Handler handler, final UncheckedCallable<V> uncheckedCallable) {
        if (!checkThreadAccess(handler)) {
            return (V) new WaitableRunnable<V>() {
                /* class com.taobao.weex.devtools.common.android.HandlerUtil.AnonymousClass1 */

                /* access modifiers changed from: protected */
                @Override // com.taobao.weex.devtools.common.android.HandlerUtil.WaitableRunnable
                public V onRun() {
                    return (V) uncheckedCallable.call();
                }
            }.invoke(handler);
        }
        try {
            return uncheckedCallable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void verifyThreadAccess(Handler handler) {
        Util.throwIfNot(checkThreadAccess(handler));
    }

    public static void postAndWait(Handler handler, final Runnable runnable) {
        if (checkThreadAccess(handler)) {
            try {
                runnable.run();
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        } else {
            new WaitableRunnable<Void>() {
                /* class com.taobao.weex.devtools.common.android.HandlerUtil.AnonymousClass2 */

                /* access modifiers changed from: protected */
                @Override // com.taobao.weex.devtools.common.android.HandlerUtil.WaitableRunnable
                public Void onRun() {
                    runnable.run();
                    return null;
                }
            }.invoke(handler);
        }
    }
}
