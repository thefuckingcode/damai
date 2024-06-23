package com.google.vr.vrcore.base.api;

/* compiled from: Taobao */
public final class VrCoreNotAvailableException extends Exception {
    public final int errorCode;

    public VrCoreNotAvailableException(int i) {
        super(VrCoreUtils.c(i));
        this.errorCode = i;
    }
}
