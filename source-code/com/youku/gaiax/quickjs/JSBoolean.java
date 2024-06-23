package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class JSBoolean extends JSValue {
    private final boolean value;

    JSBoolean(long j, JSContext jSContext, boolean z) {
        super(j, jSContext);
        this.value = z;
    }

    public boolean getBoolean() {
        return this.value;
    }
}
