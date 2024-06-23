package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public interface JSFunctionCallback {
    @Keep
    JSValue invoke(JSContext jSContext, JSValue[] jSValueArr);
}
