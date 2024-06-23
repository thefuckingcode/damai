package com.alibaba.security.realidentity.http.base;

import com.alibaba.security.realidentity.http.model.HttpRequest;
import java.io.Serializable;

/* compiled from: Taobao */
public class BusinessRequest implements Serializable {
    public HttpRequest httpRequest;
    public Class<? extends HttpRequest> httpRequestCls;

    public BusinessRequest(Class<? extends HttpRequest> cls, HttpRequest httpRequest2) {
        this.httpRequestCls = cls;
        this.httpRequest = httpRequest2;
    }
}
