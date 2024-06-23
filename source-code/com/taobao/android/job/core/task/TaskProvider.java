package com.taobao.android.job.core.task;

/* compiled from: Taobao */
public interface TaskProvider<T, R> {
    Task<T, R> provideTask(T t);
}
