package tb;

import androidx.annotation.RestrictTo;

/* compiled from: Taobao */
public class ma1<T> {
    private T a;
    private T b;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ma1<T> a(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        this.a = t;
        this.b = t2;
        return this;
    }
}
