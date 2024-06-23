package com.huawei.hmf.tasks;

/* compiled from: Taobao */
public interface SuccessContinuation<TResult, TContinuationResult> {
    Task<TContinuationResult> then(TResult tresult) throws Exception;
}
