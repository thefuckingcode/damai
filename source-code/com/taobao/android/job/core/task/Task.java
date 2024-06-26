package com.taobao.android.job.core.task;

/* compiled from: Taobao */
public abstract class Task<T, R> {
    private boolean considerExecutionError = true;
    private T id;
    private boolean shouldRunImmediately = false;

    public abstract R execute();

    public T getId() {
        return this.id;
    }

    public boolean intercept(ExecutionResults<T, R> executionResults) {
        return true;
    }

    public void setConsiderExecutionError(boolean z) {
        this.considerExecutionError = z;
    }

    public void setId(T t) {
        this.id = t;
    }

    public boolean shouldConsiderExecutionError() {
        return this.considerExecutionError;
    }

    public void shouldRunImmediately(boolean z) {
        this.shouldRunImmediately = z;
    }

    public boolean shouldRunImmediately() {
        return this.shouldRunImmediately;
    }
}
