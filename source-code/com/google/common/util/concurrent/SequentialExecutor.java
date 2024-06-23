package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import tb.ds1;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* compiled from: Taobao */
public final class SequentialExecutor implements Executor {
    private static final Logger f = Logger.getLogger(SequentialExecutor.class.getName());
    private final Executor a;
    @GuardedBy("queue")
    private final Deque<Runnable> b;
    @GuardedBy("queue")
    private WorkerRunningState c;
    @GuardedBy("queue")
    private long d;
    private final QueueWorker e;

    /* compiled from: Taobao */
    private final class QueueWorker implements Runnable {
        private QueueWorker() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r3.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
            r4 = com.google.common.util.concurrent.SequentialExecutor.f;
            r5 = java.util.logging.Level.SEVERE;
            r4.log(r5, "Exception while executing runnable " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
            if (r1 == false) goto L_?;
         */
        private void workOnQueue() {
            boolean z = false;
            boolean z2 = false;
            while (true) {
                try {
                    synchronized (SequentialExecutor.this.b) {
                        if (!z) {
                            WorkerRunningState workerRunningState = SequentialExecutor.this.c;
                            WorkerRunningState workerRunningState2 = WorkerRunningState.RUNNING;
                            if (workerRunningState != workerRunningState2) {
                                SequentialExecutor.d(SequentialExecutor.this);
                                SequentialExecutor.this.c = workerRunningState2;
                                z = true;
                            }
                        }
                        Runnable runnable = (Runnable) SequentialExecutor.this.b.poll();
                        if (runnable == null) {
                            SequentialExecutor.this.c = WorkerRunningState.IDLE;
                        }
                    }
                } finally {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.b) {
                    SequentialExecutor.this.c = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    static /* synthetic */ long d(SequentialExecutor sequentialExecutor) {
        long j = sequentialExecutor.d;
        sequentialExecutor.d = 1 + j;
        return j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r8.a.execute(r8.e);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r8.c == r9) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r0 == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r6 = r8.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        if (r8.d != r3) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r8.c != r9) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        r8.c = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004d, code lost:
        monitor-enter(r8.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r3 = r8.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0052, code lost:
        if (r3 == com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0061, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0064, code lost:
        if ((r9 instanceof java.util.concurrent.RejectedExecutionException) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0069, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x006a, code lost:
        throw r9;
     */
    public void execute(final Runnable runnable) {
        ds1.p(runnable);
        synchronized (this.b) {
            WorkerRunningState workerRunningState = this.c;
            if (workerRunningState != WorkerRunningState.RUNNING) {
                WorkerRunningState workerRunningState2 = WorkerRunningState.QUEUED;
                if (workerRunningState != workerRunningState2) {
                    long j = this.d;
                    AnonymousClass1 r1 = new Runnable() {
                        /* class com.google.common.util.concurrent.SequentialExecutor.AnonymousClass1 */

                        public void run() {
                            runnable.run();
                        }
                    };
                    this.b.add(r1);
                    WorkerRunningState workerRunningState3 = WorkerRunningState.QUEUING;
                    this.c = workerRunningState3;
                }
            }
            this.b.add(runnable);
        }
    }
}
