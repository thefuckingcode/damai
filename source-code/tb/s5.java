package tb;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.m;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.a;

/* compiled from: Taobao */
public class s5 implements ModifierContent, ContentModel {
    @Nullable
    private final l5 a;
    @Nullable
    private final AnimatableValue<PointF, PointF> b;
    @Nullable
    private final n5 c;
    @Nullable
    private final i5 d;
    @Nullable
    private final k5 e;
    @Nullable
    private final i5 f;
    @Nullable
    private final i5 g;
    @Nullable
    private final i5 h;
    @Nullable
    private final i5 i;

    public s5() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public m a() {
        return new m(this);
    }

    @Nullable
    public l5 b() {
        return this.a;
    }

    @Nullable
    public i5 c() {
        return this.i;
    }

    @Nullable
    public k5 d() {
        return this.e;
    }

    @Nullable
    public AnimatableValue<PointF, PointF> e() {
        return this.b;
    }

    @Nullable
    public i5 f() {
        return this.d;
    }

    @Nullable
    public n5 g() {
        return this.c;
    }

    @Nullable
    public i5 h() {
        return this.f;
    }

    @Nullable
    public i5 i() {
        return this.g;
    }

    @Nullable
    public i5 j() {
        return this.h;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, a aVar) {
        return null;
    }

    public s5(@Nullable l5 l5Var, @Nullable AnimatableValue<PointF, PointF> animatableValue, @Nullable n5 n5Var, @Nullable i5 i5Var, @Nullable k5 k5Var, @Nullable i5 i5Var2, @Nullable i5 i5Var3, @Nullable i5 i5Var4, @Nullable i5 i5Var5) {
        this.a = l5Var;
        this.b = animatableValue;
        this.c = n5Var;
        this.d = i5Var;
        this.e = k5Var;
        this.h = i5Var2;
        this.i = i5Var3;
        this.f = i5Var4;
        this.g = i5Var5;
    }
}
