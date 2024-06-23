package com.youku.antitheftchain.exception;

/* compiled from: Taobao */
public class BaseException extends Exception {
    private static final long serialVersionUID = 5269089054051757504L;
    private int errorCode = 0;
    private String errorInfo = "";
    private ExceptionErrorCode exceptionErrorCode;
    private int subErrorCode = 0;

    public BaseException(BaseException baseException, ExceptionErrorCode exceptionErrorCode2, String str) {
        super("Reason: " + exceptionErrorCode2.getMessage() + ", ErrorCode " + exceptionErrorCode2.getErrorCode() + ", SubErrorCode " + baseException.getErrorCode() + ", ErrorInfo: " + str);
        initCause(baseException);
        this.errorInfo = str;
        this.errorCode = exceptionErrorCode2.getErrorCode();
        this.subErrorCode = baseException.getErrorCode();
        this.exceptionErrorCode = exceptionErrorCode2;
    }

    public BaseException(ExceptionErrorCode exceptionErrorCode2, int i, String str) {
        super("Reason: " + exceptionErrorCode2.getMessage() + ", ErrorCode " + i + ", ErrorInfo: " + str);
        this.errorInfo = str;
        this.errorCode = i;
        this.exceptionErrorCode = exceptionErrorCode2;
    }

    public BaseException(ExceptionErrorCode exceptionErrorCode2, String str) {
        super("Reason: " + exceptionErrorCode2.getMessage() + ", ErrorCode " + exceptionErrorCode2.getErrorCode() + ", ErrorInfo: " + str);
        this.errorInfo = str;
        this.errorCode = exceptionErrorCode2.getErrorCode();
        this.exceptionErrorCode = exceptionErrorCode2;
    }

    public BaseException(Throwable th, ExceptionErrorCode exceptionErrorCode2, int i, String str) {
        super("Reason: " + exceptionErrorCode2.getMessage() + ", ErrorCode " + i + ", ErrorInfo: " + str);
        initCause(th);
        this.errorInfo = str;
        this.errorCode = i;
        this.exceptionErrorCode = exceptionErrorCode2;
    }

    public BaseException(Throwable th, ExceptionErrorCode exceptionErrorCode2, String str) {
        super("Reason: " + exceptionErrorCode2.getMessage() + ", ErrorCode " + exceptionErrorCode2.getErrorCode() + ", ErrorInfo: " + str);
        initCause(th);
        this.errorInfo = str;
        this.errorCode = exceptionErrorCode2.getErrorCode();
        this.exceptionErrorCode = exceptionErrorCode2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public ExceptionErrorCode getExceptionErrorCode() {
        return this.exceptionErrorCode;
    }

    public int getSubErrorCode() {
        return this.subErrorCode;
    }
}
