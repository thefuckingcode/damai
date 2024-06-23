package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.n;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.a;
import tb.bt0;
import tb.pa1;

/* compiled from: Taobao */
public class g extends a {
    private final String o;
    private final boolean p;
    private final LongSparseArray<LinearGradient> q = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> r = new LongSparseArray<>();
    private final RectF s = new RectF();
    private final GradientType t;
    private final int u;
    private final BaseKeyframeAnimation<bt0, bt0> v;
    private final BaseKeyframeAnimation<PointF, PointF> w;
    private final BaseKeyframeAnimation<PointF, PointF> x;
    @Nullable
    private n y;

    public g(LottieDrawable lottieDrawable, a aVar, com.airbnb.lottie.model.content.a aVar2) {
        super(lottieDrawable, aVar, aVar2.a().toPaintCap(), aVar2.f().toPaintJoin(), aVar2.h(), aVar2.j(), aVar2.l(), aVar2.g(), aVar2.b());
        this.o = aVar2.i();
        this.t = aVar2.e();
        this.p = aVar2.m();
        this.u = (int) (lottieDrawable.getComposition().d() / 32.0f);
        BaseKeyframeAnimation<bt0, bt0> createAnimation = aVar2.d().createAnimation();
        this.v = createAnimation;
        createAnimation.a(this);
        aVar.c(createAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = aVar2.k().createAnimation();
        this.w = createAnimation2;
        createAnimation2.a(this);
        aVar.c(createAnimation2);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = aVar2.c().createAnimation();
        this.x = createAnimation3;
        createAnimation3.a(this);
        aVar.c(createAnimation3);
    }

    private int[] c(int[] iArr) {
        n nVar = this.y;
        if (nVar != null) {
            Integer[] numArr = (Integer[]) nVar.h();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    private int d() {
        int round = Math.round(this.w.f() * ((float) this.u));
        int round2 = Math.round(this.x.f() * ((float) this.u));
        int round3 = Math.round(this.v.f() * ((float) this.u));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private LinearGradient e() {
        long d = (long) d();
        LinearGradient linearGradient = this.q.get(d);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h = this.w.h();
        PointF h2 = this.x.h();
        bt0 h3 = this.v.h();
        LinearGradient linearGradient2 = new LinearGradient(h.x, h.y, h2.x, h2.y, c(h3.a()), h3.b(), Shader.TileMode.CLAMP);
        this.q.put(d, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient f() {
        long d = (long) d();
        RadialGradient radialGradient = this.r.get(d);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h = this.w.h();
        PointF h2 = this.x.h();
        bt0 h3 = this.v.h();
        int[] c = c(h3.a());
        float[] b = h3.b();
        float f = h.x;
        float f2 = h.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (h2.x - f), (double) (h2.y - f2)), c, b, Shader.TileMode.CLAMP);
        this.r.put(d, radialGradient2);
        return radialGradient2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.lang.Integer[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t2, @Nullable pa1<T> pa1) {
        super.addValueCallback(t2, pa1);
        if (t2 == LottieProperty.GRADIENT_COLOR) {
            n nVar = this.y;
            if (nVar != null) {
                this.f.w(nVar);
            }
            if (pa1 == null) {
                this.y = null;
                return;
            }
            n nVar2 = new n(pa1);
            this.y = nVar2;
            nVar2.a(this);
            this.f.c(this.y);
        }
    }

    @Override // com.airbnb.lottie.animation.content.a, com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        if (!this.p) {
            getBounds(this.s, matrix, false);
            if (this.t == GradientType.LINEAR) {
                shader = e();
            } else {
                shader = f();
            }
            shader.setLocalMatrix(matrix);
            this.i.setShader(shader);
            super.draw(canvas, matrix, i);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.o;
    }
}
