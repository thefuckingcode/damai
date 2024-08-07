package com.ut.mini.behavior.expression;

/* compiled from: Taobao */
class ExpressionException extends RuntimeException {
    private Throwable mRootCause;

    public ExpressionException() {
    }

    public Throwable getRootCause() {
        return this.mRootCause;
    }

    public String toString() {
        if (getMessage() == null) {
            return this.mRootCause.toString();
        }
        if (this.mRootCause == null) {
            return getMessage();
        }
        return getMessage() + ": " + this.mRootCause;
    }

    public ExpressionException(String str) {
        super(str);
    }

    public ExpressionException(Throwable th) {
        this.mRootCause = th;
    }

    public ExpressionException(String str, Throwable th) {
        super(str);
        this.mRootCause = th;
    }
}
