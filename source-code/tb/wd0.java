package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class wd0<T> {
    private final T a;
    @Nullable
    private final Annotations b;

    public wd0(T t, @Nullable Annotations annotations) {
        this.a = t;
        this.b = annotations;
    }

    public final T a() {
        return this.a;
    }

    @Nullable
    public final Annotations b() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wd0)) {
            return false;
        }
        wd0 wd0 = (wd0) obj;
        return k21.d(this.a, wd0.a) && k21.d(this.b, wd0.b);
    }

    public int hashCode() {
        T t = this.a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        Annotations annotations = this.b;
        if (annotations != null) {
            i = annotations.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "EnhancementResult(result=" + ((Object) this.a) + ", enhancementAnnotations=" + this.b + ')';
    }
}
