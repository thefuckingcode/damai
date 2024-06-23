package com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions;

import androidx.annotation.Keep;
import java.io.UnsupportedEncodingException;

@Keep
/* compiled from: Taobao */
public class InvalidEncodingException extends RuntimeException {
    private final UnsupportedEncodingException encodingException;

    public InvalidEncodingException(UnsupportedEncodingException unsupportedEncodingException) {
        if (unsupportedEncodingException != null) {
            this.encodingException = unsupportedEncodingException;
            return;
        }
        throw new IllegalArgumentException();
    }

    public UnsupportedEncodingException getEncodingException() {
        return this.encodingException;
    }
}
