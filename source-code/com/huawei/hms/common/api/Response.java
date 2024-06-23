package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.Result;

/* compiled from: Taobao */
public class Response<T extends Result> {
    protected T result;

    public Response() {
    }

    /* access modifiers changed from: protected */
    public T getResult() {
        return this.result;
    }

    public void setResult(T t) {
        this.result = t;
    }

    protected Response(T t) {
        this.result = t;
    }
}
