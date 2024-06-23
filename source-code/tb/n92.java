package tb;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.e;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.a;

/* compiled from: Taobao */
public class n92 implements ContentModel {
    private final boolean a;
    private final Path.FillType b;
    private final String c;
    @Nullable
    private final h5 d;
    @Nullable
    private final k5 e;
    private final boolean f;

    public n92(String str, boolean z, Path.FillType fillType, @Nullable h5 h5Var, @Nullable k5 k5Var, boolean z2) {
        this.c = str;
        this.a = z;
        this.b = fillType;
        this.d = h5Var;
        this.e = k5Var;
        this.f = z2;
    }

    @Nullable
    public h5 a() {
        return this.d;
    }

    public Path.FillType b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    @Nullable
    public k5 d() {
        return this.e;
    }

    public boolean e() {
        return this.f;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, a aVar) {
        return new e(lottieDrawable, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }
}
