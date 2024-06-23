package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public abstract class JSNumber extends JSValue {
    JSNumber(long j, JSContext jSContext) {
        super(j, jSContext);
    }

    public abstract byte getByte();

    public abstract double getDouble();

    public abstract float getFloat();

    public abstract int getInt();

    public abstract long getLong();

    public abstract short getShort();
}
