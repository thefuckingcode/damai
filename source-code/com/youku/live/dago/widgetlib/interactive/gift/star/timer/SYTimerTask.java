package com.youku.live.dago.widgetlib.interactive.gift.star.timer;

import android.os.SystemClock;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
public abstract class SYTimerTask implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Condition condition;
    private long createTime;
    private ReentrantLock lock;
    private String name;
    private long offsetTimeMillis;
    private final Runnable r;
    private long step;
    private SYTimerStepListener stepListener;
    private Thread thread;
    private AtomicBoolean threadIntterupt;
    private long when;

    /* compiled from: Taobao */
    public interface SYTimerStepListener {
        void onStepError(long j, long j2);

        void onStepNotify(long j, long j2);
    }

    protected SYTimerTask() {
        this(1);
    }

    public final void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027380265")) {
            ipChange.ipc$dispatch("1027380265", new Object[]{this});
        } else if (this.thread != null) {
            this.threadIntterupt.set(true);
            try {
                if (this.lock.isLocked()) {
                    this.condition.signal();
                }
            } catch (Exception unused) {
            }
        }
    }

    public final String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1384946746")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("1384946746", new Object[]{this});
    }

    public final long getSurplus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2126956125")) {
            return this.when - SystemClock.elapsedRealtime();
        }
        return ((Long) ipChange.ipc$dispatch("-2126956125", new Object[]{this})).longValue();
    }

    public final long getWhen() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2048563701")) {
            return this.when;
        }
        return ((Long) ipChange.ipc$dispatch("-2048563701", new Object[]{this})).longValue();
    }

    public abstract void onTimeOver();

    public abstract void run();

    public final void setOffsetTimeMillis(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384328763")) {
            ipChange.ipc$dispatch("-384328763", new Object[]{this, Long.valueOf(j)});
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.createTime = elapsedRealtime;
        this.offsetTimeMillis = j;
        this.when = elapsedRealtime + j;
    }

    protected SYTimerTask(long j) {
        this(j, String.valueOf(System.nanoTime()));
    }

    protected SYTimerTask(long j, String str) {
        this(j, str, null, 0);
    }

    protected SYTimerTask(long j, SYTimerStepListener sYTimerStepListener, long j2) {
        this(j, String.valueOf(System.nanoTime()), sYTimerStepListener, j2);
    }

    protected SYTimerTask(long j, String str, SYTimerStepListener sYTimerStepListener, long j2) {
        this.threadIntterupt = new AtomicBoolean(false);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        AnonymousClass1 r0 = new Runnable() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x00aa, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
                r8.this$0.stepListener.onStepError(r8.this$0.step * ((long) r3), r8.this$0.offsetTimeMillis);
                r8.this$0.stepListener = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d2, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d3, code lost:
                r8.this$0.lock.unlock();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x00dc, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:0x0126, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
                r8.this$0.stepListener.onStepError(r8.this$0.offsetTimeMillis, r8.this$0.offsetTimeMillis);
                r8.this$0.stepListener = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:0x014b, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x014c, code lost:
                r8.this$0.lock.unlock();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x0155, code lost:
                throw r0;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00ac */
            /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0128 */
            public void run() {
                IpChange ipChange = $ipChange;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange, "-764469521")) {
                    ipChange.ipc$dispatch("-764469521", new Object[]{this});
                    return;
                }
                while (!SYTimerTask.this.thread.isInterrupted() && SYTimerTask.this.getSurplus() > SYTimerTask.this.step && !SYTimerTask.this.threadIntterupt.get()) {
                    SYTimerTask.this.lock.lock();
                    SYTimerTask.this.condition.await(SYTimerTask.this.step, TimeUnit.MILLISECONDS);
                    i++;
                    if (SYTimerTask.this.threadIntterupt.get()) {
                        SYTimerTask.this.stepListener.onStepError(SYTimerTask.this.step * ((long) i), SYTimerTask.this.offsetTimeMillis);
                        SYTimerTask.this.lock.unlock();
                        return;
                    }
                    SYTimerTask.this.stepListener.onStepNotify(SYTimerTask.this.step * ((long) i), SYTimerTask.this.offsetTimeMillis);
                    SYTimerTask.this.lock.unlock();
                }
                long surplus = SYTimerTask.this.getSurplus() - SYTimerTask.this.step;
                if (!SYTimerTask.this.thread.isInterrupted() && surplus > 0 && !SYTimerTask.this.threadIntterupt.get()) {
                    SYTimerTask.this.lock.lock();
                    SYTimerTask.this.condition.await(surplus, TimeUnit.MILLISECONDS);
                    SYTimerTask.this.lock.unlock();
                }
                SYTimerTask.this.onTimeOver();
                SYTimerTask.this.stepListener = null;
            }
        };
        this.r = r0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.createTime = elapsedRealtime;
        this.offsetTimeMillis = j;
        this.when = elapsedRealtime + j;
        this.name = str;
        this.stepListener = sYTimerStepListener;
        this.step = j2;
        if (j2 > 0 && sYTimerStepListener != null) {
            this.threadIntterupt.set(false);
            Thread thread2 = new Thread(r0);
            this.thread = thread2;
            thread2.setName("SYTimer-Step-Task");
            this.thread.start();
        }
    }
}
