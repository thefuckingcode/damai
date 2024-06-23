package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public final class JSString extends JSValue {
    private final String value;

    JSString(long j, JSContext jSContext, String str) {
        super(j, jSContext);
        this.value = str;
    }

    public String getString() {
        return this.value;
    }
}
