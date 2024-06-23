package com.huawei.hms.support.api.client;

import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;

/* compiled from: Taobao */
public abstract class ResultConvert<R extends Result, S extends Result> {

    /* compiled from: Taobao */
    public class FailPendingResult extends EmptyPendingResult {
        public FailPendingResult(ResultConvert resultConvert, Status status) {
            setResult(status);
        }
    }

    public final PendingResult newFailedPendingResult(Status status) {
        Preconditions.checkNotNull(status, "The input status cannot be null");
        Preconditions.checkArgument(!status.isSuccess(), "The input status must be call with success status");
        return new FailPendingResult(this, status);
    }

    public Status onFailed(Status status) {
        Preconditions.checkNotNull(status, "The input status cannot be null");
        if (status.getStatusCode() != 0) {
            return status;
        }
        return Status.CoreException;
    }

    public abstract PendingResult onSuccess(Result result);
}
