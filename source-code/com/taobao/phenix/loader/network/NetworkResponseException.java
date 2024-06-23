package com.taobao.phenix.loader.network;

import tb.jl1;

/* compiled from: Taobao */
public class NetworkResponseException extends RuntimeException {
    private final int mExtraCode;
    private final int mHttpCode;

    public NetworkResponseException(int i, String str, int i2, Throwable th) {
        super(str, th);
        this.mHttpCode = i;
        this.mExtraCode = i2;
    }

    public int getExtraCode() {
        return this.mExtraCode;
    }

    public int getHttpCode() {
        return this.mHttpCode;
    }

    public String toString() {
        return getClass().getName() + jl1.BRACKET_START_STR + "httpCode=" + this.mHttpCode + ", extraCode=" + this.mExtraCode + ", desc=" + getMessage() + jl1.BRACKET_END_STR;
    }

    public NetworkResponseException(int i, String str) {
        this(i, str, 0, null);
    }
}
