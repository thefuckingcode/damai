package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.e;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* compiled from: Taobao */
public final class TimeoutFuture<V> extends e.a<V> {
    @NullableDecl
    private ListenableFuture<V> a;
    @NullableDecl
    private ScheduledFuture<?> b;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class Fire<V> implements Runnable {
        @NullableDecl
        TimeoutFuture<V> timeoutFutureRef;

        Fire(TimeoutFuture<V> timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        public void run() {
            ListenableFuture<? extends V> listenableFuture;
            TimeoutFuture<V> timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture != null && (listenableFuture = ((TimeoutFuture) timeoutFuture).a) != null) {
                this.timeoutFutureRef = null;
                if (listenableFuture.isDone()) {
                    timeoutFuture.setFuture(listenableFuture);
                    return;
                }
                try {
                    ScheduledFuture scheduledFuture = ((TimeoutFuture) timeoutFuture).b;
                    ((TimeoutFuture) timeoutFuture).b = null;
                    String str = "Timed out";
                    if (scheduledFuture != null) {
                        try {
                            long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                            if (abs > 10) {
                                str = str + " (timeout delayed by " + abs + " ms after scheduled time)";
                            }
                        } catch (Throwable th) {
                            timeoutFuture.setException(new TimeoutFutureException(str));
                            throw th;
                        }
                    }
                    timeoutFuture.setException(new TimeoutFutureException(str + ": " + listenableFuture));
                } finally {
                    listenableFuture.cancel(true);
                }
            }
        }
    }

    /* compiled from: Taobao */
    private static final class TimeoutFutureException extends TimeoutException {
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }

        private TimeoutFutureException(String str) {
            super(str);
        }
    }

    private TimeoutFuture(ListenableFuture<V> listenableFuture) {
        this.a = (ListenableFuture) ds1.p(listenableFuture);
    }

    static <V> ListenableFuture<V> d(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(listenableFuture);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.b = scheduledExecutorService.schedule(fire, j, timeUnit);
        listenableFuture.addListener(fire, MoreExecutors.a());
        return timeoutFuture;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        maybePropagateCancellationTo(this.a);
        ScheduledFuture<?> scheduledFuture = this.b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.a = null;
        this.b = null;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        ListenableFuture<V> listenableFuture = this.a;
        ScheduledFuture<?> scheduledFuture = this.b;
        if (listenableFuture == null) {
            return null;
        }
        String str = "inputFuture=[" + listenableFuture + jl1.ARRAY_END_STR;
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
