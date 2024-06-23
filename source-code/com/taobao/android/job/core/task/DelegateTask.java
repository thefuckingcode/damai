package com.taobao.android.job.core.task;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
public abstract class DelegateTask<T, R> extends Task<T, R> {
    private Task<T, R> task;

    protected DelegateTask(@NonNull Task<T, R> task2) {
        this.task = task2;
    }

    @Override // com.taobao.android.job.core.task.Task
    public T getId() {
        return this.task.getId();
    }

    /* access modifiers changed from: protected */
    public Task<T, R> getTargetTask() {
        return this.task;
    }

    @Override // com.taobao.android.job.core.task.Task
    public boolean intercept(ExecutionResults<T, R> executionResults) {
        return this.task.intercept(executionResults);
    }

    @Override // com.taobao.android.job.core.task.Task
    public void setConsiderExecutionError(boolean z) {
        this.task.setConsiderExecutionError(z);
    }

    @Override // com.taobao.android.job.core.task.Task
    public void setId(T t) {
        this.task.setId(t);
    }

    @Override // com.taobao.android.job.core.task.Task
    public boolean shouldConsiderExecutionError() {
        return this.task.shouldConsiderExecutionError();
    }

    @Override // com.taobao.android.job.core.task.Task
    public boolean shouldRunImmediately() {
        return this.task.shouldRunImmediately();
    }
}
