package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;
import com.alipay.sdk.m.n.a;

@Keep
/* compiled from: Taobao */
public final class JSInt extends JSNumber {
    private final int value;

    JSInt(long j, JSContext jSContext, int i) {
        super(j, jSContext);
        this.value = i;
    }

    private int getIntInRange(String str, int i, int i2) {
        int i3 = this.value;
        if (i <= i3 && i3 <= i2) {
            return i3;
        }
        throw new JSDataException("Can't treat " + i3 + " as " + str);
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public byte getByte() {
        return (byte) getIntInRange("byte", a.g, 127);
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public double getDouble() {
        return (double) this.value;
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public float getFloat() {
        return (float) this.value;
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public int getInt() {
        return this.value;
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public long getLong() {
        return (long) this.value;
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public short getShort() {
        return (short) getIntInRange("short", -32768, 32767);
    }
}
