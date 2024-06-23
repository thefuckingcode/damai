package org.android.netutil;

import androidx.annotation.Keep;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Keep
/* compiled from: Taobao */
public class PingTask {
    private static int PING_DEFAULT_TIME = 5;
    private int interval;
    private int maxtime;
    private int payload;
    private String pingIPStr;
    private int ttl;

    /* access modifiers changed from: package-private */
    @Keep
    /* compiled from: Taobao */
    public class PingFuture extends AsyncTask implements Future<b> {
        private b _inner_response;
        private long native_ptr;

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private PingFuture start(String str, int i, int i2, int i3, int i4, PingTaskWatcher pingTaskWatcher) {
            b bVar = new b(i2);
            this._inner_response = bVar;
            bVar.g(pingTaskWatcher);
            this.native_ptr = PingTask.createPingTask(this, str, i, i2, i3, i4);
            return this;
        }

        public boolean cancel(boolean z) {
            return false;
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.Object
        public void finalize() throws Throwable {
            super.finalize();
            long j = this.native_ptr;
            if (j != 0) {
                PingTask.releasePingTask(j);
            }
        }

        public boolean isCancelled() {
            return false;
        }

        public boolean isDone() {
            return this.done;
        }

        /* access modifiers changed from: protected */
        public void onPingEntry(int i, int i2, double d) {
            this._inner_response.a(i, i2, d);
        }

        /* access modifiers changed from: protected */
        public void onTaskFinish(String str, int i) {
            this._inner_response.j(str);
            this._inner_response.h(i);
        }

        /* access modifiers changed from: protected */
        public void onTimxceed(String str) {
            this._inner_response.i(str);
        }

        private PingFuture() {
            this.native_ptr = 0;
            this._inner_response = null;
        }

        @Override // java.util.concurrent.Future
        public b get() throws InterruptedException, ExecutionException {
            try {
                return get(0L, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // java.util.concurrent.Future
        public b get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            synchronized (this) {
                if (!this.done) {
                    long j2 = this.native_ptr;
                    if (j2 == 0) {
                        return null;
                    }
                    if (PingTask.waitPingTask(j2, timeUnit.toSeconds(j))) {
                        PingTask.releasePingTask(this.native_ptr);
                        this.native_ptr = 0;
                    } else {
                        throw new TimeoutException();
                    }
                }
                return this._inner_response;
            }
        }
    }

    public PingTask(String str, int i, int i2, int i3, int i4) {
        this.pingIPStr = null;
        this.pingIPStr = str;
        this.interval = i;
        this.maxtime = i2 == 0 ? PING_DEFAULT_TIME : i2;
        this.payload = i3;
        this.ttl = i4;
    }

    /* access modifiers changed from: private */
    public static native long createPingTask(PingFuture pingFuture, String str, int i, int i2, int i3, int i4);

    /* access modifiers changed from: private */
    public static native void releasePingTask(long j);

    /* access modifiers changed from: private */
    public static native boolean waitPingTask(long j, long j2);

    public Future<b> launch() {
        return launchWith(null);
    }

    public Future<b> launchWith(PingTaskWatcher pingTaskWatcher) {
        return new PingFuture().start(this.pingIPStr, this.interval, this.maxtime, this.payload, this.ttl, pingTaskWatcher);
    }

    public PingTask(String str) {
        this(str, 0, 0, 0, 0);
    }
}
