package com.huawei.agconnect.exception;

/* compiled from: Taobao */
public class AGCNetworkException extends AGCException {
    public static final int NETWORK_UNAVAILABLE = 0;
    public static final int SERVER_NOT_REACH = 1;

    public AGCNetworkException(String str, int i) {
        super(str, i);
    }
}
