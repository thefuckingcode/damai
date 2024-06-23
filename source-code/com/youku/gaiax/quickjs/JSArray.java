package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public final class JSArray extends JSObject {
    JSArray(long j, JSContext jSContext) {
        super(j, jSContext, null);
    }

    public int getLength() {
        return ((JSNumber) getProperty("length").cast(JSNumber.class)).getInt();
    }
}
