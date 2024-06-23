package com.huawei.hmf.tasks;

/* compiled from: Taobao */
public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    public abstract CancellationToken register(Runnable runnable);
}
