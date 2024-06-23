package com.alibaba.security.realidentity.http;

import com.alibaba.security.realidentity.http.base.Request;
import com.alibaba.security.realidentity.http.base.RetrofitHttpCallback;

/* compiled from: Taobao */
public abstract class AbsRPCInvoker {
    protected static final String TAG = "AbsRPCInvoker";

    public abstract void enqueue(Request request, RetrofitHttpCallback retrofitHttpCallback);
}
