package com.huawei.hms.common;

import com.huawei.hms.support.api.client.Status;

/* compiled from: Taobao */
public class ApiException extends Exception {
    protected final Status mStatus;

    /* JADX WARNING: Illegal instructions before constructor call */
    public ApiException(Status status) {
        super(r0.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(status.getStatusCode());
        sb.append(": ");
        sb.append(status.getStatusMessage() != null ? status.getStatusMessage() : "");
        this.mStatus = status;
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
