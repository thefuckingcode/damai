package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.n;
import com.airbnb.lottie.model.layer.a;
import java.util.ArrayList;
import java.util.List;
import tb.he1;
import tb.k61;
import tb.l61;
import tb.n92;
import tb.pa1;
import tb.z51;

/* compiled from: Taobao */
public class e implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {
    private final Path a;
    private final Paint b = new l61(1);
    private final a c;
    private final String d;
    private final boolean e;
    private final List<PathContent> f = new ArrayList();
    private final BaseKeyframeAnimation<Integer, Integer> g;
    private final BaseKeyframeAnimation<Integer, Integer> h;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> i;
    private final LottieDrawable j;

    public e(LottieDrawable lottieDrawable, a aVar, n92 n92) {
        Path path = new Path();
        this.a = path;
        this.c = aVar;
        this.d = n92.c();
        this.e = n92.e();
        this.j = lottieDrawable;
        if (n92.a() == null || n92.d() == null) {
            this.g = null;
            this.h = null;
            return;
        }
        path.setFillType(n92.b());
        BaseKeyframeAnimation<Integer, Integer> createAnimation = n92.a().createAnimation();
        this.g = createAnimation;
        createAnimation.a(this);
        aVar.c(createAnimation);
        BaseKeyframeAnimation<Integer, Integer> createAnimation2 = n92.d().createAnimation();
        this.h = createAnimation2;
        createAnimation2.a(this);
        aVar.c(createAnimation2);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        if (t == LottieProperty.COLOR) {
            this.g.n(pa1);
        } else if (t == LottieProperty.OPACITY) {
            this.h.n(pa1);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.i;
            if (baseKeyframeAnimation != null) {
                this.c.w(baseKeyframeAnimation);
            }
            if (pa1 == null) {
                this.i = null;
                return;
            }
            n nVar = new n(pa1);
            this.i = nVar;
            nVar.a(this);
            this.c.c(this.i);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        if (!this.e) {
            k61.a("FillContent#draw");
            this.b.setColor(((com.airbnb.lottie.animation.keyframe.a) this.g).p());
            this.b.setAlpha(he1.d((int) ((((((float) i2) / 255.0f) * ((float) this.h.h().intValue())) / 100.0f) * 255.0f), 0, 255));
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.i;
            if (baseKeyframeAnimation != null) {
                this.b.setColorFilter(baseKeyframeAnimation.h());
            }
            this.a.reset();
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                this.a.addPath(this.f.get(i3).getPath(), matrix);
            }
            canvas.drawPath(this.a, this.b);
            k61.b("FillContent#draw");
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.a.addPath(this.f.get(i2).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.d;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.j.invalidateSelf();
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
                this.f.add((PathContent) content);
            }
        }
    }
}
