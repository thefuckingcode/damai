package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Status;

/* compiled from: Taobao */
public class AbstractMessageEntity implements IMessageEntity {
    @Packed
    private Status commonStatus;

    public Status getCommonStatus() {
        return this.commonStatus;
    }

    public void setCommonStatus(Status status) {
        this.commonStatus = status;
    }
}
