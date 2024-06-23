package mtopsdk.mtop.domain;

import anet.channel.request.a;

/* compiled from: Taobao */
public enum MethodEnum {
    GET("GET"),
    POST("POST"),
    HEAD(a.c.HEAD),
    PATCH("PATCH");
    
    private String method;

    private MethodEnum(String str) {
        this.method = str;
    }

    public String getMethod() {
        return this.method;
    }
}
