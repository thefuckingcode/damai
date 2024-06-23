package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a;
import tb.b61;
import tb.xt2;

/* compiled from: Taobao */
public class f extends b61<PointF> {
    @Nullable
    private Path q;
    private final b61<PointF> r;

    public f(a aVar, b61<PointF> b61) {
        super(aVar, b61.b, b61.c, b61.d, b61.e, b61.f, b61.g, b61.h);
        this.r = b61;
        i();
    }

    public void i() {
        T t;
        T t2;
        T t3 = this.c;
        boolean z = (t3 == null || (t2 = this.b) == null || !t2.equals(((PointF) t3).x, ((PointF) t3).y)) ? false : true;
        T t4 = this.b;
        if (t4 != null && (t = this.c) != null && !z) {
            b61<PointF> b61 = this.r;
            this.q = xt2.d(t4, t, b61.o, b61.p);
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Path j() {
        return this.q;
    }
}
