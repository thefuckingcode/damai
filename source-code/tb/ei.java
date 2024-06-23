package tb;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.d;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.a;

/* compiled from: Taobao */
public class ei implements ContentModel {
    private final String a;
    private final AnimatableValue<PointF, PointF> b;
    private final m5 c;
    private final boolean d;
    private final boolean e;

    public ei(String str, AnimatableValue<PointF, PointF> animatableValue, m5 m5Var, boolean z, boolean z2) {
        this.a = str;
        this.b = animatableValue;
        this.c = m5Var;
        this.d = z;
        this.e = z2;
    }

    public String a() {
        return this.a;
    }

    public AnimatableValue<PointF, PointF> b() {
        return this.b;
    }

    public m5 c() {
        return this.c;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.d;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, a aVar) {
        return new d(lottieDrawable, aVar, this);
    }
}
