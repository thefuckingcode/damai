package com.airbnb.lottie.model.content;

import tb.k5;
import tb.o5;

/* compiled from: Taobao */
public class Mask {
    private final MaskMode a;
    private final o5 b;
    private final k5 c;
    private final boolean d;

    /* compiled from: Taobao */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, o5 o5Var, k5 k5Var, boolean z) {
        this.a = maskMode;
        this.b = o5Var;
        this.c = k5Var;
        this.d = z;
    }

    public MaskMode a() {
        return this.a;
    }

    public o5 b() {
        return this.b;
    }

    public k5 c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
