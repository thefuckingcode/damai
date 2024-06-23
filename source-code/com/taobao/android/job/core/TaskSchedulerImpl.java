package com.taobao.android.job.core;

import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.task.ExecutionResult;
import com.taobao.android.job.core.task.Task;
import com.taobao.android.job.core.task.TaskExecutionException;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;

/* compiled from: Taobao */
public final class TaskSchedulerImpl<T, R> implements TaskScheduler<T, R> {
    private static final String TAG = "TaskSchedulerImpl";
    private final CompletionService<ExecutionResult<T, R>> completionService;
    private final Collection<ExecutionListener<T, R>> executionListeners = new CopyOnWriteArrayList();
    private final ExecutorService executorService;

    TaskSchedulerImpl(ExecutorService executorService2) {
        this.executorService = executorService2;
        this.completionService = new ExecutorCompletionService(executorService2);
    }

    private Callable<ExecutionResult<T, R>> newCallable(final Task<T, R> task) {
        return new Callable<ExecutionResult<T, R>>() {
            /* class com.taobao.android.job.core.TaskSchedulerImpl.AnonymousClass1 */

            @Override // java.util.concurrent.Callable
            public ExecutionResult<T, R> call() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    ExecutionResult<T, R> success = ExecutionResult.success(task.getId(), task.execute(), currentTimeMillis, System.currentTimeMillis());
                    success.getSummary().isMainThread = task.shouldRunImmediately();
                    for (ExecutionListener executionListener : TaskSchedulerImpl.this.executionListeners) {
                        executionListener.onSuccess(task, success);
                    }
                    return success;
                } catch (Throwable th) {
                    ExecutionResult<T, R> failed = ExecutionResult.failed(task.getId(), null, th.getMessage());
                    for (ExecutionListener executionListener2 : TaskSchedulerImpl.this.executionListeners) {
                        executionListener2.onError(task, failed, th);
                    }
                    Log.e(TaskSchedulerImpl.TAG, "Error Execution Task # %s", task.getId(), th);
                    return failed;
                }
            }
        };
    }

    @Override // com.taobao.android.job.core.TaskScheduler
    public boolean addExecutionListener(ExecutionListener<T, R> executionListener) {
        if (executionListener != null) {
            return this.executionListeners.add(executionListener);
        }
        return false;
    }

    @Override // com.taobao.android.job.core.TaskScheduler
    public ExecutionResult<T, R> processResult() {
        try {
            return this.completionService.take().get();
        } catch (Exception e) {
            throw new TaskExecutionException("Task executed failed", e);
        }
    }

    @Override // com.taobao.android.job.core.TaskScheduler
    public boolean removeExecutionListener(ExecutionListener<T, R> executionListener) {
        if (executionListener != null) {
            return this.executionListeners.remove(executionListener);
        }
        return false;
    }

    @Override // com.taobao.android.job.core.TaskScheduler
    public ExecutionResult<T, R> submit(Task<T, R> task) {
        Log.v(TAG, "Received Task %s", task.getId());
        Callable<ExecutionResult<T, R>> newCallable = newCallable(task);
        if (task.shouldRunImmediately()) {
            try {
                return newCallable.call();
            } catch (Exception e) {
                return ExecutionResult.failed(task.getId(), null, e.getMessage());
            }
        } else {
            this.completionService.submit(newCallable);
            return null;
        }
    }

    public String toString() {
        return this.executorService.toString();
    }
}
