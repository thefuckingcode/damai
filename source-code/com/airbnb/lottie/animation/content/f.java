package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.n;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.a;
import java.util.ArrayList;
import java.util.List;
import tb.bt0;
import tb.et0;
import tb.he1;
import tb.k61;
import tb.l61;
import tb.pa1;
import tb.z51;

/* compiled from: Taobao */
public class f implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {
    @NonNull
    private final String a;
    private final boolean b;
    private final a c;
    private final LongSparseArray<LinearGradient> d = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> e = new LongSparseArray<>();
    private final Path f;
    private final Paint g;
    private final RectF h;
    private final List<PathContent> i;
    private final GradientType j;
    private final BaseKeyframeAnimation<bt0, bt0> k;
    private final BaseKeyframeAnimation<Integer, Integer> l;
    private final BaseKeyframeAnimation<PointF, PointF> m;
    private final BaseKeyframeAnimation<PointF, PointF> n;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> o;
    @Nullable
    private n p;
    private final LottieDrawable q;
    private final int r;

    public f(LottieDrawable lottieDrawable, a aVar, et0 et0) {
        Path path = new Path();
        this.f = path;
        this.g = new l61(1);
        this.h = new RectF();
        this.i = new ArrayList();
        this.c = aVar;
        this.a = et0.e();
        this.b = et0.h();
        this.q = lottieDrawable;
        this.j = et0.d();
        path.setFillType(et0.b());
        this.r = (int) (lottieDrawable.getComposition().d() / 32.0f);
        BaseKeyframeAnimation<bt0, bt0> createAnimation = et0.c().createAnimation();
        this.k = createAnimation;
        createAnimation.a(this);
        aVar.c(createAnimation);
        BaseKeyframeAnimation<Integer, Integer> createAnimation2 = et0.f().createAnimation();
        this.l = createAnimation2;
        createAnimation2.a(this);
        aVar.c(createAnimation2);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = et0.g().createAnimation();
        this.m = createAnimation3;
        createAnimation3.a(this);
        aVar.c(createAnimation3);
        BaseKeyframeAnimation<PointF, PointF> createAnimation4 = et0.a().createAnimation();
        this.n = createAnimation4;
        createAnimation4.a(this);
        aVar.c(createAnimation4);
    }

    private int[] a(int[] iArr) {
        n nVar = this.p;
        if (nVar != null) {
            Integer[] numArr = (Integer[]) nVar.h();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    private int b() {
        int round = Math.round(this.m.f() * ((float) this.r));
        int round2 = Math.round(this.n.f() * ((float) this.r));
        int round3 = Math.round(this.k.f() * ((float) this.r));
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private LinearGradient c() {
        long b2 = (long) b();
        LinearGradient linearGradient = this.d.get(b2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h2 = this.m.h();
        PointF h3 = this.n.h();
        bt0 h4 = this.k.h();
        LinearGradient linearGradient2 = new LinearGradient(h2.x, h2.y, h3.x, h3.y, a(h4.a()), h4.b(), Shader.TileMode.CLAMP);
        this.d.put(b2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long b2 = (long) b();
        RadialGradient radialGradient = this.e.get(b2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h2 = this.m.h();
        PointF h3 = this.n.h();
        bt0 h4 = this.k.h();
        int[] a2 = a(h4.a());
        float[] b3 = h4.b();
        float f2 = h2.x;
        float f3 = h2.y;
        float hypot = (float) Math.hypot((double) (h3.x - f2), (double) (h3.y - f3));
        RadialGradient radialGradient2 = new RadialGradient(f2, f3, hypot <= 0.0f ? 0.001f : hypot, a2, b3, Shader.TileMode.CLAMP);
        this.e.put(b2, radialGradient2);
        return radialGradient2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.lang.Integer[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        if (t == LottieProperty.OPACITY) {
            this.l.n(pa1);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.o;
            if (baseKeyframeAnimation != null) {
                this.c.w(baseKeyframeAnimation);
            }
            if (pa1 == null) {
                this.o = null;
                return;
            }
            n nVar = new n(pa1);
            this.o = nVar;
            nVar.a(this);
            this.c.c(this.o);
        } else if (t == LottieProperty.GRADIENT_COLOR) {
            n nVar2 = this.p;
            if (nVar2 != null) {
                this.c.w(nVar2);
            }
            if (pa1 == null) {
                this.p = null;
                return;
            }
            this.d.clear();
            this.e.clear();
            n nVar3 = new n(pa1);
            this.p = nVar3;
            nVar3.a(this);
            this.c.c(this.p);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        Shader shader;
        if (!this.b) {
            k61.a("GradientFillContent#draw");
            this.f.reset();
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                this.f.addPath(this.i.get(i3).getPath(), matrix);
            }
            this.f.computeBounds(this.h, false);
            if (this.j == GradientType.LINEAR) {
                shader = c();
            } else {
                shader = d();
            }
            shader.setLocalMatrix(matrix);
            this.g.setShader(shader);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.o;
            if (baseKeyframeAnimation != null) {
                this.g.setColorFilter(baseKeyframeAnimation.h());
            }
            this.g.setAlpha(he1.d((int) ((((((float) i2) / 255.0f) * ((float) this.l.h().intValue())) / 100.0f) * 255.0f), 0, 255));
            canvas.drawPath(this.f, this.g);
            k61.b("GradientFillContent#draw");
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f.addPath(this.i.get(i2).getPath(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(z51 z51, int i2, List<z51> list, z51 z512) {
        he1.m(z51, i2, list, z512, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            Content content = list2.get(i2);
            if (content instanceof PathContent) {
                this.i.add((PathContent) content);
            }
        }
    }
}
