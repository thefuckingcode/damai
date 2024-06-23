package com.youku.middlewareservice.provider.task;

/* compiled from: Taobao */
public abstract class YKRunnable implements Runnable {
    private DelayType delayType;
    private long mDelayTime;
    private long mInitialDelayTime;
    private final String name;
    private Priority priority;
    private TaskType type;

    public YKRunnable(String str) {
        this.name = str;
    }

    public long getDelayTime() {
        return this.mDelayTime;
    }

    public DelayType getDelayType() {
        return this.delayType;
    }

    public long getInitialDelayTime() {
        return this.mInitialDelayTime;
    }

    public String getName() {
        return this.name;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public TaskType getType() {
        return this.type;
    }

    public YKRunnable setDelayTime(long j) {
        this.mDelayTime = j;
        return this;
    }

    public YKRunnable setDelayType(DelayType delayType2) {
        this.delayType = delayType2;
        return this;
    }

    public YKRunnable setInitialDelayTime(long j) {
        this.mInitialDelayTime = j;
        return this;
    }

    public YKRunnable setPriority(Priority priority2) {
        this.priority = priority2;
        return this;
    }

    public YKRunnable setType(TaskType taskType) {
        this.type = taskType;
        return this;
    }
}
