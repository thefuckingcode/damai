package com.taobao.android.job.core.task;

/* compiled from: Taobao */
public interface TaskFactory<T, R> {
    Task<T, R> newRunner(Task<T, R> task);
}
