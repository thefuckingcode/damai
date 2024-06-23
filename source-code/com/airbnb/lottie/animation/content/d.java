package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.a;
import java.util.List;
import tb.ei;
import tb.he1;
import tb.pa1;
import tb.z51;

/* compiled from: Taobao */
public class d implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private final Path a = new Path();
    private final String b;
    private final LottieDrawable c;
    private final BaseKeyframeAnimation<?, PointF> d;
    private final BaseKeyframeAnimation<?, PointF> e;
    private final ei f;
    private b g = new b();
    private boolean h;

    public d(LottieDrawable lottieDrawable, a aVar, ei eiVar) {
        this.b = eiVar.a();
        this.c = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = eiVar.c().createAnimation();
        this.d = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = eiVar.b().createAnimation();
        this.e = createAnimation2;
        this.f = eiVar;
        aVar.c(createAnimation);
        aVar.c(createAnimation2);
        createAnimation.a(this);
        createAnimation2.a(this);
    }

    private void a() {
        this.h = false;
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        if (t == LottieProperty.ELLIPSE_SIZE) {
            this.d.n(pa1);
        } else if (t == LottieProperty.POSITION) {
            this.e.n(pa1);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.h) {
            return this.a;
        }
        this.a.reset();
        if (this.f.d()) {
            this.h = true;
            return this.a;
        }
        PointF h2 = this.d.h();
        float f2 = h2.x / 2.0f;
        float f3 = h2.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.a.reset();
        if (this.f.e()) {
            float f6 = -f3;
            this.a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            this.a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            this.a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            this.a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            this.a.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            this.a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            this.a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            this.a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            this.a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF h3 = this.e.h();
        this.a.offset(h3.x, h3.y);
        this.a.close();
        this.g.b(this.a);
        this.h = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        a();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(z51 z51, int i, List<z51> list, z51 z512) {
        he1.m(z51, i, list, z512, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof n) {
                n nVar = (n) content;
                if (nVar.e() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.g.a(nVar);
                    nVar.a(this);
                }
            }
        }
    }
}
