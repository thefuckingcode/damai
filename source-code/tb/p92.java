package tb;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.l;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.a;

/* compiled from: Taobao */
public class p92 implements ContentModel {
    private final String a;
    private final int b;
    private final o5 c;
    private final boolean d;

    public p92(String str, int i, o5 o5Var, boolean z) {
        this.a = str;
        this.b = i;
        this.c = o5Var;
        this.d = z;
    }

    public String a() {
        return this.a;
    }

    public o5 b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, a aVar) {
        return new l(lottieDrawable, aVar, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.b + '}';
    }
}
