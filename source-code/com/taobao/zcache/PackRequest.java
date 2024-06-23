package com.taobao.zcache;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class PackRequest {
    private Error error = null;
    private final String info;
    private final String name;
    private String traceId = null;

    public PackRequest(String str) {
        this.name = str;
        this.info = null;
    }

    public Error getError() {
        return this.error;
    }

    public String getInfo() {
        return this.info;
    }

    public String getName() {
        return this.name;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setError(Error error2) {
        this.error = error2;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public PackRequest(String str, String str2) {
        this.name = str;
        this.info = str2;
    }
}
