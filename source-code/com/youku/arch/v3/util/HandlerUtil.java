package com.youku.arch.v3.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
public final class HandlerUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "HandlerUtil";

    /* compiled from: Taobao */
    public static abstract class WaitableRunnable<V> implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final int MSG_INVOKE = 2147483646;
        private static final int MSG_PEEK = Integer.MAX_VALUE;
        private Exception exception;
        private volatile boolean isDone;
        private volatile boolean isStarted;
        private Object lock = new Object();
        private V value;

        protected WaitableRunnable() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0179, code lost:
            if ((r6 + 1) > 1) goto L_0x01bd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x0031, code lost:
            continue;
         */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0119  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x012b  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x01c3  */
        private void join(Handler handler) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1982944743")) {
                ipChange.ipc$dispatch("1982944743", new Object[]{this, handler});
                return;
            }
            synchronized (this.lock) {
                Looper looper = handler.getLooper();
                if (looper != null) {
                    Thread thread = looper.getThread();
                    boolean z = Looper.getMainLooper() == looper;
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        if (this.isDone || thread == null || !thread.isAlive()) {
                            break;
                        }
                        try {
                            if (AppInfoProviderProxy.isDebuggable()) {
                                Object[] objArr = new Object[1];
                                StringBuilder sb = new StringBuilder();
                                sb.append("wait thread join start  ");
                                sb.append(Thread.currentThread().getName());
                                sb.append(" count ");
                                int i3 = i + 1;
                                try {
                                    sb.append(i);
                                    sb.append(" , ");
                                    sb.append(this.lock.hashCode());
                                    objArr[0] = sb.toString();
                                    LogUtil.v(HandlerUtil.TAG, objArr);
                                    i = i3;
                                } catch (InterruptedException unused) {
                                    i = i3;
                                    try {
                                        LogUtil.v(HandlerUtil.TAG, "wait thread interrupted " + Thread.currentThread().getName() + AVFSCacheConstants.COMMA_SEP + this.lock.hashCode());
                                        if (!z) {
                                        }
                                    } catch (Throwable th) {
                                        if (z) {
                                            if (!this.isStarted) {
                                                if (!handler.hasMessages(MSG_INVOKE, this.lock)) {
                                                }
                                            }
                                        } else if (handler.sendEmptyMessage(Integer.MAX_VALUE)) {
                                            handler.removeMessages(Integer.MAX_VALUE);
                                        } else if (AppInfoProviderProxy.isDebuggable()) {
                                            LogUtil.v(HandlerUtil.TAG, "wait thread finally break " + Thread.currentThread().getName() + AVFSCacheConstants.COMMA_SEP + this.lock.hashCode());
                                        }
                                        throw th;
                                    }
                                    if (AppInfoProviderProxy.isDebuggable()) {
                                    }
                                }
                            }
                            this.lock.wait(1000);
                            if (z) {
                                if (!this.isStarted && !handler.hasMessages(MSG_INVOKE, this.lock) && (i2 = i2 + 1) > 1) {
                                    break;
                                }
                            } else {
                                if (!handler.sendEmptyMessage(Integer.MAX_VALUE)) {
                                    if (AppInfoProviderProxy.isDebuggable()) {
                                        LogUtil.v(HandlerUtil.TAG, "wait thread finally break " + Thread.currentThread().getName() + AVFSCacheConstants.COMMA_SEP + this.lock.hashCode());
                                    }
                                }
                                handler.removeMessages(Integer.MAX_VALUE);
                            }
                        } catch (InterruptedException unused2) {
                            LogUtil.v(HandlerUtil.TAG, "wait thread interrupted " + Thread.currentThread().getName() + AVFSCacheConstants.COMMA_SEP + this.lock.hashCode());
                            if (!z) {
                                if (!this.isStarted && !handler.hasMessages(MSG_INVOKE, this.lock) && (i2 = i2 + 1) > 1) {
                                    break;
                                }
                            } else {
                                if (!handler.sendEmptyMessage(Integer.MAX_VALUE)) {
                                    if (AppInfoProviderProxy.isDebuggable()) {
                                        LogUtil.v(HandlerUtil.TAG, "wait thread finally break " + Thread.currentThread().getName() + AVFSCacheConstants.COMMA_SEP + this.lock.hashCode());
                                    }
                                }
                                handler.removeMessages(Integer.MAX_VALUE);
                            }
                            if (AppInfoProviderProxy.isDebuggable()) {
                            }
                        }
                    }
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.v(HandlerUtil.TAG, "wait thread join end  " + Thread.currentThread().getName() + " , " + this.lock.hashCode());
                    }
                }
            }
        }

        public V invoke(Handler handler) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-382801799")) {
                return (V) ipChange.ipc$dispatch("-382801799", new Object[]{this, handler});
            }
            Message obtain = Message.obtain(handler, this);
            obtain.what = MSG_INVOKE;
            obtain.obj = this.lock;
            if (!handler.sendMessage(obtain)) {
                Log.e(HandlerUtil.TAG, "Handler.post() returned false and loop is" + handler.getLooper());
                return null;
            }
            join(handler);
            if (this.exception == null) {
                return this.value;
            }
            throw new RuntimeException(this.exception);
        }

        /* access modifiers changed from: protected */
        public abstract V onRun();

        public final void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1902209374")) {
                ipChange.ipc$dispatch("1902209374", new Object[]{this});
                return;
            }
            try {
                this.isStarted = true;
                this.value = onRun();
                this.exception = null;
                synchronized (this.lock) {
                    this.isDone = true;
                    this.lock.notifyAll();
                }
            } catch (Exception e) {
                try {
                    this.value = null;
                    this.exception = e;
                    synchronized (this.lock) {
                        this.isDone = true;
                        this.lock.notifyAll();
                    }
                } catch (Throwable th) {
                    synchronized (this.lock) {
                        this.isDone = true;
                        this.lock.notifyAll();
                        throw th;
                    }
                }
            }
        }
    }

    private HandlerUtil() {
    }

    public static boolean checkThreadAccess(Handler handler) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2123926169")) {
            return Looper.myLooper() == handler.getLooper();
        }
        return ((Boolean) ipChange.ipc$dispatch("-2123926169", new Object[]{handler})).booleanValue();
    }

    public static void postAndWait(Handler handler, final Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2087874645")) {
            ipChange.ipc$dispatch("-2087874645", new Object[]{handler, runnable});
        } else if (checkThreadAccess(handler)) {
            try {
                runnable.run();
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        } else {
            new WaitableRunnable<Void>() {
                /* class com.youku.arch.v3.util.HandlerUtil.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                /* access modifiers changed from: protected */
                @Override // com.youku.arch.v3.util.HandlerUtil.WaitableRunnable
                public Void onRun() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-489300307")) {
                        return (Void) ipChange.ipc$dispatch("-489300307", new Object[]{this});
                    }
                    runnable.run();
                    return null;
                }
            }.invoke(handler);
        }
    }

    public static void verifyThreadAccess(Handler handler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-7554966")) {
            ipChange.ipc$dispatch("-7554966", new Object[]{handler});
            return;
        }
        checkThreadAccess(handler);
    }
}
