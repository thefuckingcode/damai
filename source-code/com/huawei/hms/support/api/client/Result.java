package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.IMessageEntity;

/* compiled from: Taobao */
public abstract class Result implements IMessageEntity {
    private Status status = Status.FAILURE;

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status2) {
        if (status2 != null) {
            this.status = status2;
        }
    }
}
