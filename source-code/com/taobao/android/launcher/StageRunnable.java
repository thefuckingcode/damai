package com.taobao.android.launcher;

import com.taobao.android.job.core.DAGStage;
import com.taobao.android.job.core.task.ExecutionSummary;

/* compiled from: Taobao */
public interface StageRunnable<T, R> {
    void onComplete(DAGStage<T, R> dAGStage, ExecutionSummary executionSummary);
}
