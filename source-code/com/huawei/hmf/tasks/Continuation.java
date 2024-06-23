package com.huawei.hmf.tasks;

/* compiled from: Taobao */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> task) throws Exception;
}
