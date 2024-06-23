package com.alipay.euler.andfix.exception;

/* compiled from: Taobao */
public class AndFixException extends RuntimeException {
    public AndFixException() {
    }

    public AndFixException(String str) {
        super(str);
    }

    public AndFixException(String str, Throwable th) {
        super(str, th);
    }

    public AndFixException(Throwable th) {
        super(th);
    }
}
