package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.m;
import com.airbnb.lottie.model.layer.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import tb.he1;
import tb.pa1;
import tb.vz1;
import tb.z51;

/* compiled from: Taobao */
public class k implements DrawingContent, GreedyContent, KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private final Matrix a = new Matrix();
    private final Path b = new Path();
    private final LottieDrawable c;
    private final a d;
    private final String e;
    private final boolean f;
    private final BaseKeyframeAnimation<Float, Float> g;
    private final BaseKeyframeAnimation<Float, Float> h;
    private final m i;
    private c j;

    public k(LottieDrawable lottieDrawable, a aVar, vz1 vz1) {
        this.c = lottieDrawable;
        this.d = aVar;
        this.e = vz1.b();
        this.f = vz1.e();
        BaseKeyframeAnimation<Float, Float> createAnimation = vz1.a().createAnimation();
        this.g = createAnimation;
        aVar.c(createAnimation);
        createAnimation.a(this);
        BaseKeyframeAnimation<Float, Float> createAnimation2 = vz1.c().createAnimation();
        this.h = createAnimation2;
        aVar.c(createAnimation2);
        createAnimation2.a(this);
        m a2 = vz1.d().a();
        this.i = a2;
        a2.a(aVar);
        a2.b(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:6:0x000f, LOOP_START] */
    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void absorbContent(ListIterator<Content> listIterator) {
        if (this.j == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.j = new c(this.c, this.d, "Repeater", this.f, arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        if (!this.i.c(t, pa1)) {
            if (t == LottieProperty.REPEATER_COPIES) {
                this.g.n(pa1);
            } else if (t == LottieProperty.REPEATER_OFFSET) {
                this.h.n(pa1);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.g.h().floatValue();
        float floatValue2 = this.h.h().floatValue();
        float floatValue3 = this.i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.i.e().h().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.a.set(matrix);
            float f2 = (float) i3;
            this.a.preConcat(this.i.g(f2 + floatValue2));
            this.j.draw(canvas, this.a, (int) (((float) i2) * he1.k(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.j.getBounds(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.e;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        Path path = this.j.getPath();
        this.b.reset();
        float floatValue = this.g.h().floatValue();
        float floatValue2 = this.h.h().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.a.set(this.i.g(((float) i2) + floatValue2));
            this.b.addPath(path, this.a);
        }
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(z51 z51, int i2, List<z51> list, z51 z512) {
        he1.m(z51, i2, list, z512, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        this.j.setContents(list, list2);
    }
}
