package com.taobao.rxm.schedule;

/* compiled from: Taobao */
public interface Scheduler {
    int getQueueSize();

    String getStatus();

    boolean isScheduleMainThread();

    void schedule(ScheduledAction scheduledAction);
}
