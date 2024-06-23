package com.airbnb.lottie.animation.keyframe;

import java.util.List;
import tb.b61;
import tb.bt0;

/* compiled from: Taobao */
public class c extends e<bt0> {
    private final bt0 i;

    public c(List<b61<bt0>> list) {
        super(list);
        int i2 = 0;
        T t = list.get(0).b;
        i2 = t != null ? t.c() : i2;
        this.i = new bt0(new float[i2], new int[i2]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public bt0 i(b61<bt0> b61, float f) {
        this.i.d(b61.b, b61.c, f);
        return this.i;
    }
}
