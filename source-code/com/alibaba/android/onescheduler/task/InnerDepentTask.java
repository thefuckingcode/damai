package com.alibaba.android.onescheduler.task;

import com.alibaba.android.onescheduler.OneDependentTask;

/* compiled from: Taobao */
public interface InnerDepentTask {
    void addPredecessor(OneDependentTask oneDependentTask);

    void addSuccessor(OneDependentTask oneDependentTask);

    void removePredecessorTryRun(OneDependentTask oneDependentTask);

    void tryRunSuccessor();
}
