package com.taobao.rxm.schedule;

import java.util.LinkedList;
import java.util.Queue;

/* compiled from: Taobao */
public class a implements ScheduledActionListener, ThrottlingScheduler {
    private final Scheduler a;
    private final Queue<ScheduledAction> b = new LinkedList();
    private int c;
    private int d;

    public a(Scheduler scheduler, int i) {
        this.a = scheduler;
        this.c = i;
    }

    private void a() {
        ScheduledAction scheduledAction = ScheduledAction.sActionCallerThreadLocal.get();
        while (true) {
            ScheduledAction scheduledAction2 = null;
            synchronized (this) {
                if (this.d < this.c) {
                    scheduledAction2 = this.b.poll();
                }
                if (scheduledAction2 != null) {
                    this.d++;
                }
            }
            if (scheduledAction2 != null) {
                this.a.schedule(scheduledAction2);
                ScheduledAction.sActionCallerThreadLocal.set(scheduledAction);
            } else {
                return;
            }
        }
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public int getQueueSize() {
        return this.b.size();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public synchronized String getStatus() {
        return this.a.getStatus();
    }

    @Override // com.taobao.rxm.schedule.Scheduler
    public synchronized boolean isScheduleMainThread() {
        return this.a.isScheduleMainThread();
    }

    @Override // com.taobao.rxm.schedule.ScheduledActionListener
    public void onActionFinished(ScheduledAction scheduledAction) {
        synchronized (this) {
            this.d--;
        }
        a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019  */
    @Override // com.taobao.rxm.schedule.Scheduler
    public void schedule(ScheduledAction scheduledAction) {
        boolean z;
        scheduledAction.setBranchActionListener(this);
        synchronized (this) {
            if (this.d >= this.c) {
                if (this.b.offer(scheduledAction)) {
                    z = false;
                    if (z) {
                        this.d++;
                    }
                }
            }
            z = true;
            if (z) {
            }
        }
        if (z) {
            this.a.schedule(scheduledAction);
        }
    }

    @Override // com.taobao.rxm.schedule.ThrottlingScheduler
    public void setMaxRunningCount(int i) {
        synchronized (this) {
            this.c = i;
        }
        a();
    }
}
