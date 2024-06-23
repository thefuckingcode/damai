package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public abstract class JSValue {
    public final JSContext jsContext;
    public final long pointer;

    JSValue(long j, JSContext jSContext) {
        this.pointer = j;
        this.jsContext = jSContext;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.youku.gaiax.quickjs.JSValue */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends JSValue> T cast(Class<T> cls) {
        if (cls.isInstance(this)) {
            return this;
        }
        throw new JSDataException("expected: " + cls.getSimpleName() + ", actual: " + getClass().getSimpleName());
    }

    /* access modifiers changed from: package-private */
    public final void checkSameJSContext(JSValue jSValue) {
        if (jSValue.jsContext != this.jsContext) {
            throw new IllegalStateException("Two JSValues are not from the same JSContext");
        }
    }
}
