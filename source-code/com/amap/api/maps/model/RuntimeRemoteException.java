package com.amap.api.maps.model;

import android.os.RemoteException;

/* compiled from: Taobao */
public final class RuntimeRemoteException extends RuntimeException {
    private static final long serialVersionUID = -3541841807100437802L;

    public RuntimeRemoteException(String str) {
        super(str);
    }

    public RuntimeRemoteException(RemoteException remoteException) {
        super(remoteException);
    }
}
