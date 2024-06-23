package com.alibaba.security.realidentity.http.model;

import anet.channel.request.a;

/* compiled from: Taobao */
public enum HttpMethod {
    GET("GET", 1),
    POST("POST", 2),
    PUT(a.c.PUT, 3),
    DELETE(a.c.DELETE, 4),
    PATCH("PATCH", 5);
    
    private int index;
    private String name;

    private HttpMethod(String str, int i) {
        this.name = str;
        this.index = i;
    }

    public final String toString() {
        return this.name;
    }
}
