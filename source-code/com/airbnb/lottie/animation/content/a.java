package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.d;
import com.airbnb.lottie.animation.keyframe.n;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
import tb.he1;
import tb.i5;
import tb.k5;
import tb.k61;
import tb.l61;
import tb.pa1;
import tb.xt2;
import tb.z51;

/* compiled from: Taobao */
public abstract class a implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {
    private final PathMeasure a = new PathMeasure();
    private final Path b = new Path();
    private final Path c = new Path();
    private final RectF d = new RectF();
    private final LottieDrawable e;
    protected final com.airbnb.lottie.model.layer.a f;
    private final List<b> g = new ArrayList();
    private final float[] h;
    final Paint i;
    private final BaseKeyframeAnimation<?, Float> j;
    private final BaseKeyframeAnimation<?, Integer> k;
    private final List<BaseKeyframeAnimation<?, Float>> l;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> m;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> n;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b {
        private final List<PathContent> a;
        @Nullable
        private final n b;

        private b(@Nullable n nVar) {
            this.a = new ArrayList();
            this.b = nVar;
        }
    }

    a(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f2, k5 k5Var, i5 i5Var, List<i5> list, i5 i5Var2) {
        l61 l61 = new l61(1);
        this.i = l61;
        this.e = lottieDrawable;
        this.f = aVar;
        l61.setStyle(Paint.Style.STROKE);
        l61.setStrokeCap(cap);
        l61.setStrokeJoin(join);
        l61.setStrokeMiter(f2);
        this.k = k5Var.createAnimation();
        this.j = i5Var.createAnimation();
        if (i5Var2 == null) {
            this.m = null;
        } else {
            this.m = i5Var2.createAnimation();
        }
        this.l = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.l.add(list.get(i2).createAnimation());
        }
        aVar.c(this.k);
        aVar.c(this.j);
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            aVar.c(this.l.get(i3));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.m;
        if (baseKeyframeAnimation != null) {
            aVar.c(baseKeyframeAnimation);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.l.get(i4).a(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(this);
        }
    }

    private void a(Matrix matrix) {
        k61.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            k61.b("StrokeContent#applyDashPattern");
            return;
        }
        float g2 = xt2.g(matrix);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            this.h[i2] = this.l.get(i2).h().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.h;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.h;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.h;
            fArr3[i2] = fArr3[i2] * g2;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.m;
        this.i.setPathEffect(new DashPathEffect(this.h, baseKeyframeAnimation == null ? 0.0f : g2 * baseKeyframeAnimation.h().floatValue()));
        k61.b("StrokeContent#applyDashPattern");
    }

    private void b(Canvas canvas, b bVar, Matrix matrix) {
        k61.a("StrokeContent#applyTrimPath");
        if (bVar.b == null) {
            k61.b("StrokeContent#applyTrimPath");
            return;
        }
        this.b.reset();
        for (int size = bVar.a.size() - 1; size >= 0; size--) {
            this.b.addPath(((PathContent) bVar.a.get(size)).getPath(), matrix);
        }
        this.a.setPath(this.b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        float floatValue = (bVar.b.c().h().floatValue() * length) / 360.0f;
        float floatValue2 = ((bVar.b.d().h().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((bVar.b.b().h().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = bVar.a.size() - 1; size2 >= 0; size2--) {
            this.c.set(((PathContent) bVar.a.get(size2)).getPath());
            this.c.transform(matrix);
            this.a.setPath(this.c, false);
            float length2 = this.a.getLength();
            float f3 = 1.0f;
            if (floatValue3 > length) {
                float f4 = floatValue3 - length;
                if (f4 < f2 + length2 && f2 < f4) {
                    xt2.a(this.c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f4 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.c, this.i);
                    f2 += length2;
                }
            }
            float f5 = f2 + length2;
            if (f5 >= floatValue2 && f2 <= floatValue3) {
                if (f5 > floatValue3 || floatValue2 >= f2) {
                    float f6 = floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2;
                    if (floatValue3 <= f5) {
                        f3 = (floatValue3 - f2) / length2;
                    }
                    xt2.a(this.c, f6, f3, 0.0f);
                    canvas.drawPath(this.c, this.i);
                } else {
                    canvas.drawPath(this.c, this.i);
                }
            }
            f2 += length2;
        }
        k61.b("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        if (t == LottieProperty.OPACITY) {
            this.k.n(pa1);
        } else if (t == LottieProperty.STROKE_WIDTH) {
            this.j.n(pa1);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.n;
            if (baseKeyframeAnimation != null) {
                this.f.w(baseKeyframeAnimation);
            }
            if (pa1 == null) {
                this.n = null;
                return;
            }
            n nVar = new n(pa1);
            this.n = nVar;
            nVar.a(this);
            this.f.c(this.n);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        k61.a("StrokeContent#draw");
        if (xt2.h(matrix)) {
            k61.b("StrokeContent#draw");
            return;
        }
        this.i.setAlpha(he1.d((int) ((((((float) i2) / 255.0f) * ((float) ((d) this.k).p())) / 100.0f) * 255.0f), 0, 255));
        this.i.setStrokeWidth(((com.airbnb.lottie.animation.keyframe.b) this.j).p() * xt2.g(matrix));
        if (this.i.getStrokeWidth() <= 0.0f) {
            k61.b("StrokeContent#draw");
            return;
        }
        a(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.n;
        if (baseKeyframeAnimation != null) {
            this.i.setColorFilter(baseKeyframeAnimation.h());
        }
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            b bVar = this.g.get(i3);
            if (bVar.b != null) {
                b(canvas, bVar, matrix);
            } else {
                k61.a("StrokeContent#buildPath");
                this.b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.b.addPath(((PathContent) bVar.a.get(size)).getPath(), matrix);
                }
                k61.b("StrokeContent#buildPath");
                k61.a("StrokeContent#drawPath");
                canvas.drawPath(this.b, this.i);
                k61.b("StrokeContent#drawPath");
            }
        }
        k61.b("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        k61.a("StrokeContent#getBounds");
        this.b.reset();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            for (int i3 = 0; i3 < bVar.a.size(); i3++) {
                this.b.addPath(((PathContent) bVar.a.get(i3)).getPath(), matrix);
            }
        }
        this.b.computeBounds(this.d, false);
        float p = ((com.airbnb.lottie.animation.keyframe.b) this.j).p();
        RectF rectF2 = this.d;
        float f2 = p / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        k61.b("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(z51 z51, int i2, List<z51> list, z51 z512) {
        he1.m(z51, i2, list, z512, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        n nVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof n) {
                n nVar2 = (n) content;
                if (nVar2.e() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    nVar = nVar2;
                }
            }
        }
        if (nVar != null) {
            nVar.a(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof n) {
                n nVar3 = (n) content2;
                if (nVar3.e() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.g.add(bVar);
                    }
                    bVar = new b(nVar3);
                    nVar3.a(this);
                }
            }
            if (content2 instanceof PathContent) {
                if (bVar == null) {
                    bVar = new b(nVar);
                }
                bVar.a.add((PathContent) content2);
            }
        }
        if (bVar != null) {
            this.g.add(bVar);
        }
    }
}
