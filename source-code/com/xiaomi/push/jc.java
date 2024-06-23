package com.xiaomi.push;

import tb.jl1;

/* compiled from: Taobao */
public class jc {
    public final byte a;

    /* renamed from: a  reason: collision with other field name */
    public final String f800a;

    /* renamed from: a  reason: collision with other field name */
    public final short f801a;

    public jc() {
        this("", (byte) 0, 0);
    }

    public jc(String str, byte b, short s) {
        this.f800a = str;
        this.a = b;
        this.f801a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f800a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f801a) + jl1.G;
    }
}
