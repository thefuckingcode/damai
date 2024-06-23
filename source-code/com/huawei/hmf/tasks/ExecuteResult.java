package com.huawei.hmf.tasks;

/* compiled from: Taobao */
public interface ExecuteResult<TResult> {
    void cancel();

    void onComplete(Task<TResult> task);
}
