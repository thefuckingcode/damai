package com.alibaba.android.onescheduler.task;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.onescheduler.CallableCallback;
import com.alibaba.android.onescheduler.OneCommonTask;
import com.alibaba.android.onescheduler.OneDependentTask;
import com.alibaba.android.onescheduler.OneTaskBuilder;
import com.alibaba.android.onescheduler.Priority;
import com.alibaba.android.onescheduler.TaskTracker;
import com.alibaba.android.onescheduler.TaskType;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
public class a implements OneTaskBuilder {
    Priority a = Priority.NORMAL;
    @Nullable
    String b = null;
    @Nullable
    String c = null;
    Runnable d;
    Callable e;
    CallableCallback f;
    TaskType g = TaskType.NORMAL;
    boolean h;
    Executor i;
    TaskTracker j;
    long k;

    @NonNull
    /* renamed from: a */
    public a setAnchorTask(boolean z) {
        this.h = z;
        return this;
    }

    @NonNull
    /* renamed from: b */
    public a setCallable(Callable<?> callable, CallableCallback<?> callableCallback) {
        this.e = callable;
        this.f = callableCallback;
        return this;
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    public OneCommonTask buildCommonTask() {
        return new OneCommonTaskImpl(this);
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    public OneDependentTask buildDependentTask() {
        return new OneDependentTaskImpl(this);
    }

    @NonNull
    /* renamed from: c */
    public a setExecutor(Executor executor) {
        this.i = executor;
        return this;
    }

    @NonNull
    /* renamed from: d */
    public a setPriority(Priority priority) {
        this.a = priority;
        return this;
    }

    @NonNull
    /* renamed from: e */
    public a setRunnable(Runnable runnable) {
        this.d = runnable;
        return this;
    }

    @NonNull
    /* renamed from: f */
    public a setTaskGroup(String str) {
        this.b = str;
        return this;
    }

    @NonNull
    /* renamed from: g */
    public a setTaskName(String str) {
        this.c = str;
        return this;
    }

    @NonNull
    /* renamed from: h */
    public a setTaskTracker(TaskTracker taskTracker) {
        this.j = taskTracker;
        return this;
    }

    @NonNull
    /* renamed from: i */
    public a setTaskType(TaskType taskType) {
        this.g = taskType;
        return this;
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    public OneTaskBuilder setDelayTime(long j2) {
        this.k = j2;
        return this;
    }
}
