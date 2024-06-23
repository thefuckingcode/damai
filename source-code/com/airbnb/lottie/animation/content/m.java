package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.n;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.a;
import tb.pa1;

/* compiled from: Taobao */
public class m extends a {
    private final a o;
    private final String p;
    private final boolean q;
    private final BaseKeyframeAnimation<Integer, Integer> r;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> s;

    public m(LottieDrawable lottieDrawable, a aVar, ShapeStroke shapeStroke) {
        super(lottieDrawable, aVar, shapeStroke.a().toPaintCap(), shapeStroke.d().toPaintJoin(), shapeStroke.f(), shapeStroke.h(), shapeStroke.i(), shapeStroke.e(), shapeStroke.c());
        this.o = aVar;
        this.p = shapeStroke.g();
        this.q = shapeStroke.j();
        BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeStroke.b().createAnimation();
        this.r = createAnimation;
        createAnimation.a(this);
        aVar.c(createAnimation);
    }

    @Override // com.airbnb.lottie.animation.content.a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable pa1<T> pa1) {
        super.addValueCallback(t, pa1);
        if (t == LottieProperty.STROKE_COLOR) {
            this.r.n(pa1);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.s;
            if (baseKeyframeAnimation != null) {
                this.o.w(baseKeyframeAnimation);
            }
            if (pa1 == null) {
                this.s = null;
                return;
            }
            n nVar = new n(pa1);
            this.s = nVar;
            nVar.a(this);
            this.o.c(this.r);
        }
    }

    @Override // com.airbnb.lottie.animation.content.a, com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        if (!this.q) {
            this.i.setColor(((com.airbnb.lottie.animation.keyframe.a) this.r).p());
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.s;
            if (baseKeyframeAnimation != null) {
                this.i.setColorFilter(baseKeyframeAnimation.h());
            }
            super.draw(canvas, matrix, i);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.p;
    }
}
