package com.tencent.mm.opensdk.diffdev.a;

import com.ali.user.open.core.exception.RpcException;

/* compiled from: Taobao */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(RpcException.ErrorCode.API_UNAUTHORIZED),
    UUID_ERROR(500);
    
    private int a;

    private d(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public String toString() {
        return "UUIDStatusCode:" + this.a;
    }
}
