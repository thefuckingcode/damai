package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
/* compiled from: Taobao */
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@NullableDecl String str) {
        super(str);
    }

    public UncheckedTimeoutException(@NullableDecl Throwable th) {
        super(th);
    }

    public UncheckedTimeoutException(@NullableDecl String str, @NullableDecl Throwable th) {
        super(str, th);
    }
}
