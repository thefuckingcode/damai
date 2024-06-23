package com.taobao.android.job.core.task;

/* compiled from: Taobao */
public class DefaultTaskFactory<T, R> implements TaskFactory<T, R> {
    @Override // com.taobao.android.job.core.task.TaskFactory
    public Task<T, R> newRunner(Task<T, R> task) {
        return new LoggerTask(task);
    }
}
