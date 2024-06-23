package com.taobao.android.job.core;

import androidx.annotation.Nullable;
import java.util.concurrent.ExecutorService;

/* compiled from: Taobao */
public class DAGSchedulerConfig<T, R> {
    private final TaskScheduler<T, R> taskScheduler;

    public DAGSchedulerConfig(@Nullable ExecutorService executorService) {
        this.taskScheduler = new TaskSchedulerImpl(executorService);
    }

    /* access modifiers changed from: package-private */
    public TaskScheduler<T, R> getTaskScheduler() {
        return this.taskScheduler;
    }
}
