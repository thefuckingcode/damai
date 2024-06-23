package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.a;
import java.util.Collections;
import tb.a42;
import tb.b61;
import tb.pa1;
import tb.s5;

/* compiled from: Taobao */
public class m {
    private final Matrix a = new Matrix();
    private final Matrix b;
    private final Matrix c;
    private final Matrix d;
    private final float[] e;
    @NonNull
    private BaseKeyframeAnimation<PointF, PointF> f;
    @NonNull
    private BaseKeyframeAnimation<?, PointF> g;
    @NonNull
    private BaseKeyframeAnimation<a42, a42> h;
    @NonNull
    private BaseKeyframeAnimation<Float, Float> i;
    @NonNull
    private BaseKeyframeAnimation<Integer, Integer> j;
    @Nullable
    private b k;
    @Nullable
    private b l;
    @Nullable
    private BaseKeyframeAnimation<?, Float> m;
    @Nullable
    private BaseKeyframeAnimation<?, Float> n;

    public m(s5 s5Var) {
        this.f = s5Var.b() == null ? null : s5Var.b().createAnimation();
        this.g = s5Var.e() == null ? null : s5Var.e().createAnimation();
        this.h = s5Var.g() == null ? null : s5Var.g().createAnimation();
        this.i = s5Var.f() == null ? null : s5Var.f().createAnimation();
        b bVar = s5Var.h() == null ? null : (b) s5Var.h().createAnimation();
        this.k = bVar;
        if (bVar != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.l = s5Var.i() == null ? null : (b) s5Var.i().createAnimation();
        if (s5Var.d() != null) {
            this.j = s5Var.d().createAnimation();
        }
        if (s5Var.j() != null) {
            this.m = s5Var.j().createAnimation();
        } else {
            this.m = null;
        }
        if (s5Var.c() != null) {
            this.n = s5Var.c().createAnimation();
        } else {
            this.n = null;
        }
    }

    private void d() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.e[i2] = 0.0f;
        }
    }

    public void a(a aVar) {
        aVar.c(this.j);
        aVar.c(this.m);
        aVar.c(this.n);
        aVar.c(this.f);
        aVar.c(this.g);
        aVar.c(this.h);
        aVar.c(this.i);
        aVar.c(this.k);
        aVar.c(this.l);
    }

    public void b(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.a(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.a(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.a(animationListener);
        }
        BaseKeyframeAnimation<a42, a42> baseKeyframeAnimation6 = this.h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.a(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.a(animationListener);
        }
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(animationListener);
        }
        b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.a(animationListener);
        }
    }

    public <T> boolean c(T t, @Nullable pa1<T> pa1) {
        b bVar;
        b bVar2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.f;
            if (baseKeyframeAnimation3 == null) {
                this.f = new n(pa1, new PointF());
                return true;
            }
            baseKeyframeAnimation3.n(pa1);
            return true;
        } else if (t == LottieProperty.TRANSFORM_POSITION) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.g;
            if (baseKeyframeAnimation4 == null) {
                this.g = new n(pa1, new PointF());
                return true;
            }
            baseKeyframeAnimation4.n(pa1);
            return true;
        } else {
            if (t == LottieProperty.TRANSFORM_POSITION_X) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.g;
                if (baseKeyframeAnimation5 instanceof k) {
                    ((k) baseKeyframeAnimation5).r(pa1);
                    return true;
                }
            }
            if (t == LottieProperty.TRANSFORM_POSITION_Y) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation6 = this.g;
                if (baseKeyframeAnimation6 instanceof k) {
                    ((k) baseKeyframeAnimation6).s(pa1);
                    return true;
                }
            }
            if (t == LottieProperty.TRANSFORM_SCALE) {
                BaseKeyframeAnimation<a42, a42> baseKeyframeAnimation7 = this.h;
                if (baseKeyframeAnimation7 == null) {
                    this.h = new n(pa1, new a42());
                    return true;
                }
                baseKeyframeAnimation7.n(pa1);
                return true;
            } else if (t == LottieProperty.TRANSFORM_ROTATION) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation8 = this.i;
                if (baseKeyframeAnimation8 == null) {
                    this.i = new n(pa1, Float.valueOf(0.0f));
                    return true;
                }
                baseKeyframeAnimation8.n(pa1);
                return true;
            } else if (t == LottieProperty.TRANSFORM_OPACITY) {
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation9 = this.j;
                if (baseKeyframeAnimation9 == null) {
                    this.j = new n(pa1, 100);
                    return true;
                }
                baseKeyframeAnimation9.n(pa1);
                return true;
            } else if (t != LottieProperty.TRANSFORM_START_OPACITY || (baseKeyframeAnimation2 = this.m) == null) {
                if (t != LottieProperty.TRANSFORM_END_OPACITY || (baseKeyframeAnimation = this.n) == null) {
                    if (t == LottieProperty.TRANSFORM_SKEW && (bVar2 = this.k) != null) {
                        if (bVar2 == null) {
                            this.k = new b(Collections.singletonList(new b61(Float.valueOf(0.0f))));
                        }
                        this.k.n(pa1);
                        return true;
                    } else if (t != LottieProperty.TRANSFORM_SKEW_ANGLE || (bVar = this.l) == null) {
                        return false;
                    } else {
                        if (bVar == null) {
                            this.l = new b(Collections.singletonList(new b61(Float.valueOf(0.0f))));
                        }
                        this.l.n(pa1);
                        return true;
                    }
                } else if (baseKeyframeAnimation == null) {
                    this.n = new n(pa1, 100);
                    return true;
                } else {
                    baseKeyframeAnimation.n(pa1);
                    return true;
                }
            } else if (baseKeyframeAnimation2 == null) {
                this.m = new n(pa1, 100);
                return true;
            } else {
                baseKeyframeAnimation2.n(pa1);
                return true;
            }
        }
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> e() {
        return this.n;
    }

    public Matrix f() {
        float f2;
        this.a.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.g;
        if (baseKeyframeAnimation != null) {
            PointF h2 = baseKeyframeAnimation.h();
            float f3 = h2.x;
            if (!(f3 == 0.0f && h2.y == 0.0f)) {
                this.a.preTranslate(f3, h2.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.i;
        if (baseKeyframeAnimation2 != null) {
            if (baseKeyframeAnimation2 instanceof n) {
                f2 = baseKeyframeAnimation2.h().floatValue();
            } else {
                f2 = ((b) baseKeyframeAnimation2).p();
            }
            if (f2 != 0.0f) {
                this.a.preRotate(f2);
            }
        }
        if (this.k != null) {
            b bVar = this.l;
            float cos = bVar == null ? 0.0f : (float) Math.cos(Math.toRadians((double) ((-bVar.p()) + 90.0f)));
            b bVar2 = this.l;
            float sin = bVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((double) ((-bVar2.p()) + 90.0f)));
            d();
            float[] fArr = this.e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f4 = -sin;
            fArr[3] = f4;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.b.setValues(fArr);
            d();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians((double) this.k.p()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            d();
            float[] fArr3 = this.e;
            fArr3[0] = cos;
            fArr3[1] = f4;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        BaseKeyframeAnimation<a42, a42> baseKeyframeAnimation3 = this.h;
        if (baseKeyframeAnimation3 != null) {
            a42 h3 = baseKeyframeAnimation3.h();
            if (!(h3.b() == 1.0f && h3.c() == 1.0f)) {
                this.a.preScale(h3.b(), h3.c());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            PointF h4 = baseKeyframeAnimation4.h();
            float f5 = h4.x;
            if (!(f5 == 0.0f && h4.y == 0.0f)) {
                this.a.preTranslate(-f5, -h4.y);
            }
        }
        return this.a;
    }

    public Matrix g(float f2) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.g;
        PointF pointF = null;
        PointF h2 = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.h();
        BaseKeyframeAnimation<a42, a42> baseKeyframeAnimation2 = this.h;
        a42 h3 = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.h();
        this.a.reset();
        if (h2 != null) {
            this.a.preTranslate(h2.x * f2, h2.y * f2);
        }
        if (h3 != null) {
            double d2 = (double) f2;
            this.a.preScale((float) Math.pow((double) h3.b(), d2), (float) Math.pow((double) h3.c(), d2));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.i;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.h().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
            if (baseKeyframeAnimation4 != null) {
                pointF = baseKeyframeAnimation4.h();
            }
            Matrix matrix = this.a;
            float f3 = floatValue * f2;
            float f4 = 0.0f;
            float f5 = pointF == null ? 0.0f : pointF.x;
            if (pointF != null) {
                f4 = pointF.y;
            }
            matrix.preRotate(f3, f5, f4);
        }
        return this.a;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Integer> h() {
        return this.j;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> i() {
        return this.m;
    }

    public void j(float f2) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.m(f2);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.m(f2);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.m(f2);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.m(f2);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.m(f2);
        }
        BaseKeyframeAnimation<a42, a42> baseKeyframeAnimation6 = this.h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.m(f2);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.m(f2);
        }
        b bVar = this.k;
        if (bVar != null) {
            bVar.m(f2);
        }
        b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.m(f2);
        }
    }
}
