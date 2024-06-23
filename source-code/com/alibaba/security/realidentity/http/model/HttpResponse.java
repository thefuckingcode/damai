package com.alibaba.security.realidentity.http.model;

import java.io.Serializable;

/* compiled from: Taobao */
public abstract class HttpResponse implements Serializable {
    public String Code;
    public int errorCode;

    public abstract boolean isSuccessful();
}
