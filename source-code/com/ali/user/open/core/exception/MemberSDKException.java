package com.ali.user.open.core.exception;

/* compiled from: Taobao */
public class MemberSDKException extends RuntimeException {
    private static final long serialVersionUID = 1357689949294215654L;
    public int code;
    public String message;
    public Throwable throwable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MemberSDKException(int i, String str, Throwable th) {
        super(str == null ? "" : str, th);
        this.code = i;
        this.message = str;
        this.throwable = th;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MemberSDKException(int i, String str) {
        super(str == null ? "" : str);
        this.message = str;
    }
}
