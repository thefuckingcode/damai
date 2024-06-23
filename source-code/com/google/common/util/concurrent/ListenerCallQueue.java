package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import tb.ds1;
import tb.iw1;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* compiled from: Taobao */
public final class ListenerCallQueue<L> {
    private static final Logger b = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> a = Collections.synchronizedList(new ArrayList());

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface Event<L> {
        void call(L l);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        @GuardedBy("this")
        boolean isThreadScheduled;
        @GuardedBy("this")
        final Queue<Object> labelQueue = iw1.a();
        final L listener;
        @GuardedBy("this")
        final Queue<Event<L>> waitQueue = iw1.a();

        PerListenerQueue(L l, Executor executor2) {
            this.listener = (L) ds1.p(l);
            this.executor = (Executor) ds1.p(executor2);
        }

        /* access modifiers changed from: package-private */
        public synchronized void add(Event<L> event, Object obj) {
            this.waitQueue.add(event);
            this.labelQueue.add(obj);
        }

        /* access modifiers changed from: package-private */
        public void dispatch() {
            boolean z;
            synchronized (this) {
                z = true;
                if (!this.isThreadScheduled) {
                    this.isThreadScheduled = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        Logger logger = ListenerCallQueue.b;
                        Level level = Level.SEVERE;
                        logger.log(level, "Exception while running callbacks for " + ((Object) this.listener) + " on " + this.executor, (Throwable) e);
                        throw e;
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r2.call(r9.listener);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            r4 = com.google.common.util.concurrent.ListenerCallQueue.b;
            r5 = java.util.logging.Level.SEVERE;
            r4.log(r5, "Exception while executing callback: " + ((java.lang.Object) r9.listener) + " " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
            r2 = r1;
            r1 = r2;
         */
        public void run() {
            boolean z;
            Throwable th;
            while (true) {
                boolean z2 = true;
                try {
                    synchronized (this) {
                        try {
                            ds1.w(this.isThreadScheduled);
                            Event<L> poll = this.waitQueue.poll();
                            Object poll2 = this.labelQueue.poll();
                            if (poll == null) {
                                this.isThreadScheduled = false;
                                try {
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z = false;
                                    while (true) {
                                        try {
                                            break;
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            z = true;
                            while (true) {
                                break;
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    if (z2) {
                        synchronized (this) {
                            this.isThreadScheduled = false;
                        }
                    }
                    throw th6;
                }
            }
        }
    }

    ListenerCallQueue() {
    }

    private void e(Event<L> event, Object obj) {
        ds1.q(event, "event");
        ds1.q(obj, "label");
        synchronized (this.a) {
            for (PerListenerQueue<L> perListenerQueue : this.a) {
                perListenerQueue.add(event, obj);
            }
        }
    }

    public void b(L l, Executor executor) {
        ds1.q(l, "listener");
        ds1.q(executor, "executor");
        this.a.add(new PerListenerQueue<>(l, executor));
    }

    public void c() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).dispatch();
        }
    }

    public void d(Event<L> event) {
        e(event, event);
    }
}
