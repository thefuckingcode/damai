package com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class IncompleteHandshakeException extends RuntimeException {
    private static final long serialVersionUID = 7906596804233893092L;
    private final int preferredSize;

    public IncompleteHandshakeException(int i) {
        this.preferredSize = i;
    }

    public int getPreferredSize() {
        return this.preferredSize;
    }

    public IncompleteHandshakeException() {
        this.preferredSize = 0;
    }
}
