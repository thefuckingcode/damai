package com.taobao.android.job.core;

/* compiled from: Taobao */
public class SchedulePolicy {
    public static final SchedulePolicy DEFERRABLE = new SchedulePolicy().deferrable();
    public static final SchedulePolicy IMMEDIATE_NON_TERMINATING = new SchedulePolicy().immediateNonTerminating();
    public static final SchedulePolicy TERMINATING = new SchedulePolicy().terminating();
    private int scheduleBehavior;

    private SchedulePolicy deferrable() {
        this.scheduleBehavior = 4;
        return this;
    }

    private SchedulePolicy immediateNonTerminating() {
        this.scheduleBehavior = 1;
        return this;
    }

    private SchedulePolicy terminating() {
        this.scheduleBehavior = 0;
        return this;
    }

    public int getScheduleBehavior() {
        return this.scheduleBehavior;
    }

    public boolean isImmediateNonTerminating() {
        return 1 == this.scheduleBehavior;
    }

    public boolean isTerminating() {
        return this.scheduleBehavior == 0;
    }
}
