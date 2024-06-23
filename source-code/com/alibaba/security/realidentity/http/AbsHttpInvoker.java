package com.alibaba.security.realidentity.http;

import com.alibaba.security.realidentity.http.base.RetrofitInvokeHandler;
import java.lang.reflect.Proxy;

/* compiled from: Taobao */
public abstract class AbsHttpInvoker {
    private IHttpInvoker mHttpInvoker = ((IHttpInvoker) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{IHttpInvoker.class}, new RetrofitInvokeHandler(getRPCInvoker())));

    public IHttpInvoker getHttpInvoker() {
        return this.mHttpInvoker;
    }

    public abstract AbsRPCInvoker getRPCInvoker();
}
