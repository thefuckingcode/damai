package com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class IncompleteException extends Exception {
    private static final long serialVersionUID = 7330519489840500997L;
    private final int preferredSize;

    public IncompleteException(int i) {
        this.preferredSize = i;
    }

    public int getPreferredSize() {
        return this.preferredSize;
    }
}
