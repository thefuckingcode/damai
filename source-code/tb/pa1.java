package tb;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* compiled from: Taobao */
public class pa1<T> {
    private final ma1<T> a = new ma1<>();
    @Nullable
    protected T b = null;

    public pa1() {
    }

    @Nullable
    public T a(ma1<T> ma1) {
        return this.b;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return a(this.a.a(f, f2, t, t2, f3, f4, f5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void c(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
    }

    public pa1(@Nullable T t) {
        this.b = t;
    }
}
