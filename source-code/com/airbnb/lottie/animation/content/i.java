package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import tb.he1;
import tb.pa1;
import tb.z51;

/* compiled from: Taobao */
public class i implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private final Path a = new Path();
    private final String b;
    private final LottieDrawable c;
    private final PolystarShape.Type d;
    private final boolean e;
    private final BaseKeyframeAnimation<?, Float> f;
    private final BaseKeyframeAnimation<?, PointF> g;
    private final BaseKeyframeAnimation<?, Float> h;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> i;
    private final BaseKeyframeAnimation<?, Float> j;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> k;
    private final BaseKeyframeAnimation<?, Float> l;
    private b m = new b();
    private boolean n;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            a = iArr;
            iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            a[PolystarShape.Type.POLYGON.ordinal()] = 2;
        }
    }

    public i(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.c = lottieDrawable;
        this.b = polystarShape.c();
        PolystarShape.Type i2 = polystarShape.i();
        this.d = i2;
        this.e = polystarShape.j();
        BaseKeyframeAnimation<Float, Float> createAnimation = polystarShape.f().createAnimation();
        this.f = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = polystarShape.g().createAnimation();
        this.g = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = polystarShape.h().createAnimation();
        this.h = createAnimation3;
        BaseKeyframeAnimation<Float, Float> createAnimation4 = polystarShape.d().createAnimation();
        this.j = createAnimation4;
        BaseKeyframeAnimation<Float, Float> createAnimation5 = polystarShape.e().createAnimation();
        this.l = createAnimation5;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (i2 == type) {
            this.i = polystarShape.a().createAnimation();
            this.k = polystarShape.b().createAnimation();
        } else {
            this.i = null;
            this.k = null;
        }
        aVar.c(createAnimation);
        aVar.c(createAnimation2);
        aVar.c(createAnimation3);
        aVar.c(createAnimation4);
        aVar.c(createAnimation5);
        if (i2 == type) {
            aVar.c(this.i);
            aVar.c(this.k);
        }
        createAnimation.a(this);
        createAnimation2.a(this);
        createAnimation3.a(this);
        createAnimation4.a(this);
        createAnimation5.a(this);
        if (i2 == type) {
            this.i.a(this);
            this.k.a(this);
        }
    }

    private void a() {
        double d2;
        double d3;
        double d4;
        int i2;
        int floor = (int) Math.floor((double) this.f.h().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.h;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.h().floatValue()) - 90.0d);
        double d5 = (double) floor;
        float floatValue = this.l.h().floatValue() / 100.0f;
        float floatValue2 = this.j.h().floatValue();
        double d6 = (double) floatValue2;
        float cos = (float) (Math.cos(radians) * d6);
        float sin = (float) (Math.sin(radians) * d6);
        this.a.moveTo(cos, sin);
        double d7 = (double) ((float) (6.283185307179586d / d5));
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i3 = 0;
        while (((double) i3) < ceil) {
            float cos2 = (float) (Math.cos(d8) * d6);
            float sin2 = (float) (d6 * Math.sin(d8));
            if (floatValue != 0.0f) {
                d4 = d6;
                i2 = i3;
                d3 = d8;
                double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                float cos3 = (float) Math.cos(atan2);
                d2 = d7;
                double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                float f2 = floatValue2 * floatValue * 0.25f;
                this.a.cubicTo(cos - (cos3 * f2), sin - (((float) Math.sin(atan2)) * f2), cos2 + (((float) Math.cos(atan22)) * f2), sin2 + (f2 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d3 = d8;
                d4 = d6;
                d2 = d7;
                i2 = i3;
                this.a.lineTo(cos2, sin2);
            }
            d8 = d3 + d2;
            i3 = i2 + 1;
            sin = sin2;
            cos = cos2;
            ceil = ceil;
            d6 = d4;
            d7 = d2;
        }
        PointF h2 = this.g.h();
        this.a.offset(h2.x, h2.y);
        this.a.close();
    }

    private void b() {
        double d2;
        int i2;
        float f2;
        float f3;
        float f4;
        double d3;
        float f5;
        float f6;
        double d4;
        float f7;
        float f8;
        float f9;
        float f10;
        float floatValue = this.f.h().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.h;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.h().floatValue()) - 90.0d);
        double d5 = (double) floatValue;
        float f11 = (float) (6.283185307179586d / d5);
        float f12 = f11 / 2.0f;
        float f13 = floatValue - ((float) ((int) floatValue));
        int i3 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (double) ((1.0f - f13) * f12);
        }
        float floatValue2 = this.j.h().floatValue();
        float floatValue3 = this.i.h().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.k;
        float floatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.h().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.l;
        float floatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.h().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f2 = ((floatValue2 - floatValue3) * f13) + floatValue3;
            i2 = i3;
            double d6 = (double) f2;
            d2 = d5;
            f4 = (float) (d6 * Math.cos(radians));
            f3 = (float) (d6 * Math.sin(radians));
            this.a.moveTo(f4, f3);
            d3 = radians + ((double) ((f11 * f13) / 2.0f));
        } else {
            d2 = d5;
            i2 = i3;
            double d7 = (double) floatValue2;
            float cos = (float) (Math.cos(radians) * d7);
            float sin = (float) (d7 * Math.sin(radians));
            this.a.moveTo(cos, sin);
            d3 = radians + ((double) f12);
            f4 = cos;
            f3 = sin;
            f2 = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        int i4 = 0;
        boolean z = false;
        while (true) {
            double d8 = (double) i4;
            if (d8 < ceil) {
                float f14 = z ? floatValue2 : floatValue3;
                int i5 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i5 == 0 || d8 != ceil - 2.0d) {
                    f5 = f11;
                    f6 = f12;
                } else {
                    f5 = f11;
                    f6 = (f11 * f13) / 2.0f;
                }
                if (i5 == 0 || d8 != ceil - 1.0d) {
                    f7 = f12;
                    d4 = d8;
                    f8 = f14;
                } else {
                    f7 = f12;
                    d4 = d8;
                    f8 = f2;
                }
                double d9 = (double) f8;
                float cos2 = (float) (d9 * Math.cos(d3));
                float sin2 = (float) (d9 * Math.sin(d3));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.a.lineTo(cos2, sin2);
                    f10 = floatValue4;
                    f9 = f2;
                } else {
                    f10 = floatValue4;
                    f9 = f2;
                    double atan2 = (double) ((float) (Math.atan2((double) f3, (double) f4) - 1.5707963267948966d));
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f15 = z ? f10 : floatValue5;
                    float f16 = z ? floatValue5 : f10;
                    float f17 = (z ? floatValue3 : floatValue2) * f15 * 0.47829f;
                    float f18 = cos3 * f17;
                    float f19 = f17 * sin3;
                    float f20 = (z ? floatValue2 : floatValue3) * f16 * 0.47829f;
                    float f21 = cos4 * f20;
                    float f22 = f20 * sin4;
                    if (i2 != 0) {
                        if (i4 == 0) {
                            f18 *= f13;
                            f19 *= f13;
                        } else if (d4 == ceil - 1.0d) {
                            f21 *= f13;
                            f22 *= f13;
                        }
                    }
                    this.a.cubicTo(f4 - f18, f3 - f19, cos2 + f21, sin2 + f22, cos2, sin2);
                }
                d3 += (double) f6;
                z = !z;
                i4++;
                f4 = cos2;
                f3 = sin2;
                floatValue4 = f10;
                f2 = f9;
                f12 = f7;
                f11 = f5;
                ceil = ceil;
            } else {
                PointF h2 = this.g.h();
                this.a.offset(h2.x, h2.y);
                this.a.close();
                return;
            }
        }
    }

    private void c() {
        this.n = false;
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.f.n(pa1);
        } else if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.h.n(pa1);
        } else if (t == LottieProperty.POSITION) {
            this.g.n(pa1);
        } else if (t == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.i) != null) {
            baseKeyframeAnimation2.n(pa1);
        } else if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.j.n(pa1);
        } else if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.k) != null) {
            baseKeyframeAnimation.n(pa1);
        } else if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.l.n(pa1);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        if (this.e) {
            this.n = true;
            return this.a;
        }
        int i2 = a.a[this.d.ordinal()];
        if (i2 == 1) {
            b();
        } else if (i2 == 2) {
            a();
        }
        this.a.close();
        this.m.b(this.a);
        this.n = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        c();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(z51 z51, int i2, List<z51> list, z51 z512) {
        he1.m(z51, i2, list, z512, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content content = list.get(i2);
            if (content instanceof n) {
                n nVar = (n) content;
                if (nVar.e() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.m.a(nVar);
                    nVar.a(this);
                }
            }
        }
    }
}
