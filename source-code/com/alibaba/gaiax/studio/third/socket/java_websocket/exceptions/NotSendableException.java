package com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class NotSendableException extends RuntimeException {
    private static final long serialVersionUID = -6468967874576651628L;

    public NotSendableException(String str) {
        super(str);
    }

    public NotSendableException(Throwable th) {
        super(th);
    }

    public NotSendableException(String str, Throwable th) {
        super(str, th);
    }
}
