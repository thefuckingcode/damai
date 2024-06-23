package com.taobao.android.job.core;

/* compiled from: Taobao */
public class DAGSchedulers {
    private DAGSchedulers() {
    }

    public static <T, R> DAGScheduler<T, R> with(DAGSchedulerConfig<T, R> dAGSchedulerConfig) {
        return new DAGSchedulerImpl(dAGSchedulerConfig);
    }
}
