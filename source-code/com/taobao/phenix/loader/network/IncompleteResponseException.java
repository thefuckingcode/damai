package com.taobao.phenix.loader.network;

/* compiled from: Taobao */
public class IncompleteResponseException extends NetworkResponseException {
    public IncompleteResponseException() {
        super(200, "Incomplete Response");
    }
}
