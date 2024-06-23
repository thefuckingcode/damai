package com.taobao.weex.devtools.inspector;

/* compiled from: Taobao */
public class MismatchedResponseException extends MessageHandlingException {
    public long mRequestId;

    public MismatchedResponseException(long j) {
        super("Response for request id " + j + ", but no such request is pending");
        this.mRequestId = j;
    }

    public long getRequestId() {
        return this.mRequestId;
    }
}
