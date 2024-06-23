package com.taobao.weex.devtools.inspector.jsonrpc;

import javax.annotation.Nullable;

/* compiled from: Taobao */
public class PendingRequest {
    @Nullable
    public final PendingRequestCallback callback;
    public final long requestId;

    public PendingRequest(long j, @Nullable PendingRequestCallback pendingRequestCallback) {
        this.requestId = j;
        this.callback = pendingRequestCallback;
    }
}
