package com.taobao.rxm.schedule;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ConcurrentLinkedQueue;
import tb.l22;

/* compiled from: Taobao */
public class UiThreadSchedulerFront implements Scheduler, Runnable {
    private static final long INIT_POST_TIME = System.currentTimeMillis();
    private static final int MAX_COST_TIME = 8;
    private static final long MAX_POST_TIME = 4000;
    private static final int MAX_RECURSIVE_DEPTH = 10;
    private long mCostTime;
    private int mCurrRecursiveDepth;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ConcurrentLinkedQueue<ScheduledAction> mQueue = new ConcurrentLinkedQueue<>();

    private boolean isUsePostAtFront() {
        return l22.b() && System.currentTimeMillis() - INIT_POST_TIME < 4000;
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public int getQueueSize() {
        return this.mQueue.size();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public String getStatus() {
        return "ui thread scheduler status:\nqueue size:" + getQueueSize();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public boolean isScheduleMainThread() {
        return true;
    }

    public void run() {
        int i = this.mCurrRecursiveDepth + 1;
        this.mCurrRecursiveDepth = i;
        if (i > 10 || this.mCostTime > 8) {
            this.mCurrRecursiveDepth = 0;
            this.mCostTime = 0;
            if (this.mQueue.isEmpty()) {
                return;
            }
            if (isUsePostAtFront()) {
                this.mHandler.postAtFrontOfQueue(this);
            } else {
                this.mHandler.post(this);
            }
        } else {
            ScheduledAction poll = this.mQueue.poll();
            if (poll != null) {
                long currentTimeMillis = System.currentTimeMillis();
                poll.run();
                this.mCostTime += System.currentTimeMillis() - currentTimeMillis;
                run();
            }
        }
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public void schedule(final ScheduledAction scheduledAction) {
        if (l22.a()) {
            this.mHandler.post(new Runnable() {
                /* class com.taobao.rxm.schedule.UiThreadSchedulerFront.AnonymousClass1 */

                public void run() {
                    scheduledAction.run();
                }
            });
            return;
        }
        boolean isEmpty = this.mQueue.isEmpty();
        this.mQueue.add(scheduledAction);
        if (isEmpty && !this.mQueue.isEmpty()) {
            if (isUsePostAtFront()) {
                this.mHandler.postAtFrontOfQueue(this);
            } else {
                this.mHandler.post(this);
            }
        }
    }
}
