package tb;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.k;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.a;

/* compiled from: Taobao */
public class vz1 implements ContentModel {
    private final String a;
    private final i5 b;
    private final i5 c;
    private final s5 d;
    private final boolean e;

    public vz1(String str, i5 i5Var, i5 i5Var2, s5 s5Var, boolean z) {
        this.a = str;
        this.b = i5Var;
        this.c = i5Var2;
        this.d = s5Var;
        this.e = z;
    }

    public i5 a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public i5 c() {
        return this.c;
    }

    public s5 d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, a aVar) {
        return new k(lottieDrawable, aVar, this);
    }
}
