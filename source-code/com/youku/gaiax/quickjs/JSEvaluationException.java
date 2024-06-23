package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class JSEvaluationException extends RuntimeException {
    private JSException jsException;

    JSEvaluationException(JSException jSException) {
        super(jSException.toString());
    }

    public JSException getJSException() {
        return this.jsException;
    }
}
