package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;

/* compiled from: Taobao */
public class ResponseHeader implements IMessageEntity {
    @Packed
    protected int statusCode;

    public ResponseHeader() {
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public ResponseHeader(int i) {
        this.statusCode = i;
    }
}
