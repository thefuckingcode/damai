package com.huawei.agconnect.exception;

/* compiled from: Taobao */
public abstract class AGCException extends Exception {
    private int code;
    private String errMsg;

    public AGCException(String str, int i) {
        this.code = i;
        this.errMsg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getMessage() {
        return " code: " + this.code + " message: " + this.errMsg;
    }
}
