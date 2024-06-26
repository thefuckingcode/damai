package tb;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.j;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.a;

/* compiled from: Taobao */
public class rx1 implements ContentModel {
    private final String a;
    private final AnimatableValue<PointF, PointF> b;
    private final AnimatableValue<PointF, PointF> c;
    private final i5 d;
    private final boolean e;

    public rx1(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatableValue<PointF, PointF> animatableValue2, i5 i5Var, boolean z) {
        this.a = str;
        this.b = animatableValue;
        this.c = animatableValue2;
        this.d = i5Var;
        this.e = z;
    }

    public i5 a() {
        return this.d;
    }

    public String b() {
        return this.a;
    }

    public AnimatableValue<PointF, PointF> c() {
        return this.b;
    }

    public AnimatableValue<PointF, PointF> d() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, a aVar) {
        return new j(lottieDrawable, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.b + ", size=" + this.c + '}';
    }
}
