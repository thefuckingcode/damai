package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import java.util.List;
import tb.b61;
import tb.he1;
import tb.m92;

/* compiled from: Taobao */
public class j extends BaseKeyframeAnimation<m92, Path> {
    private final m92 i = new m92();
    private final Path j = new Path();

    public j(List<b61<m92>> list) {
        super(list);
    }

    /* renamed from: p */
    public Path i(b61<m92> b61, float f) {
        this.i.c(b61.b, b61.c, f);
        he1.i(this.i, this.j);
        return this.j;
    }
}
