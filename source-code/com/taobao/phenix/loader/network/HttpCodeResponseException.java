package com.taobao.phenix.loader.network;

/* compiled from: Taobao */
public class HttpCodeResponseException extends NetworkResponseException {
    public HttpCodeResponseException(int i) {
        super(i, "Failed Http Code");
    }
}
