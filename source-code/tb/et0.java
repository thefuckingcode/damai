package tb;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.f;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.a;

/* compiled from: Taobao */
public class et0 implements ContentModel {
    private final GradientType a;
    private final Path.FillType b;
    private final j5 c;
    private final k5 d;
    private final m5 e;
    private final m5 f;
    private final String g;
    private final boolean h;

    public et0(String str, GradientType gradientType, Path.FillType fillType, j5 j5Var, k5 k5Var, m5 m5Var, m5 m5Var2, i5 i5Var, i5 i5Var2, boolean z) {
        this.a = gradientType;
        this.b = fillType;
        this.c = j5Var;
        this.d = k5Var;
        this.e = m5Var;
        this.f = m5Var2;
        this.g = str;
        this.h = z;
    }

    public m5 a() {
        return this.f;
    }

    public Path.FillType b() {
        return this.b;
    }

    public j5 c() {
        return this.c;
    }

    public GradientType d() {
        return this.a;
    }

    public String e() {
        return this.g;
    }

    public k5 f() {
        return this.d;
    }

    public m5 g() {
        return this.e;
    }

    public boolean h() {
        return this.h;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, a aVar) {
        return new f(lottieDrawable, aVar, this);
    }
}
