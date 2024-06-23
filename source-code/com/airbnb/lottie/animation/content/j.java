package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.b;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.a;
import java.util.List;
import tb.he1;
import tb.pa1;
import tb.rx1;
import tb.z51;

/* compiled from: Taobao */
public class j implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private final Path a = new Path();
    private final RectF b = new RectF();
    private final String c;
    private final boolean d;
    private final LottieDrawable e;
    private final BaseKeyframeAnimation<?, PointF> f;
    private final BaseKeyframeAnimation<?, PointF> g;
    private final BaseKeyframeAnimation<?, Float> h;
    private b i = new b();
    private boolean j;

    public j(LottieDrawable lottieDrawable, a aVar, rx1 rx1) {
        this.c = rx1.b();
        this.d = rx1.e();
        this.e = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = rx1.c().createAnimation();
        this.f = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = rx1.d().createAnimation();
        this.g = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = rx1.a().createAnimation();
        this.h = createAnimation3;
        aVar.c(createAnimation);
        aVar.c(createAnimation2);
        aVar.c(createAnimation3);
        createAnimation.a(this);
        createAnimation2.a(this);
        createAnimation3.a(this);
    }

    private void a() {
        this.j = false;
        this.e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        if (t == LottieProperty.RECTANGLE_SIZE) {
            this.g.n(pa1);
        } else if (t == LottieProperty.POSITION) {
            this.f.n(pa1);
        } else if (t == LottieProperty.CORNER_RADIUS) {
            this.h.n(pa1);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.c;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        float f2;
        if (this.j) {
            return this.a;
        }
        this.a.reset();
        if (this.d) {
            this.j = true;
            return this.a;
        }
        PointF h2 = this.g.h();
        float f3 = h2.x / 2.0f;
        float f4 = h2.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.h;
        if (baseKeyframeAnimation == null) {
            f2 = 0.0f;
        } else {
            f2 = ((b) baseKeyframeAnimation).p();
        }
        float min = Math.min(f3, f4);
        if (f2 > min) {
            f2 = min;
        }
        PointF h3 = this.f.h();
        this.a.moveTo(h3.x + f3, (h3.y - f4) + f2);
        this.a.lineTo(h3.x + f3, (h3.y + f4) - f2);
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i2 > 0) {
            RectF rectF = this.b;
            float f5 = h3.x;
            float f6 = f2 * 2.0f;
            float f7 = h3.y;
            rectF.set((f5 + f3) - f6, (f7 + f4) - f6, f5 + f3, f7 + f4);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((h3.x - f3) + f2, h3.y + f4);
        if (i2 > 0) {
            RectF rectF2 = this.b;
            float f8 = h3.x;
            float f9 = h3.y;
            float f10 = f2 * 2.0f;
            rectF2.set(f8 - f3, (f9 + f4) - f10, (f8 - f3) + f10, f9 + f4);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(h3.x - f3, (h3.y - f4) + f2);
        if (i2 > 0) {
            RectF rectF3 = this.b;
            float f11 = h3.x;
            float f12 = h3.y;
            float f13 = f2 * 2.0f;
            rectF3.set(f11 - f3, f12 - f4, (f11 - f3) + f13, (f12 - f4) + f13);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((h3.x + f3) - f2, h3.y - f4);
        if (i2 > 0) {
            RectF rectF4 = this.b;
            float f14 = h3.x;
            float f15 = f2 * 2.0f;
            float f16 = h3.y;
            rectF4.set((f14 + f3) - f15, f16 - f4, f14 + f3, (f16 - f4) + f15);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.i.b(this.a);
        this.j = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        a();
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
                    this.i.a(nVar);
                    nVar.a(this);
                }
            }
        }
    }
}
