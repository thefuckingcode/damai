package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import tb.ib2;
import tb.k21;
import tb.r50;

/* compiled from: Taobao */
public abstract class b extends r50 {
    @NotNull
    private final ib2 b;

    public b(@NotNull ib2 ib2) {
        k21.i(ib2, "delegate");
        this.b = ib2;
    }

    @Override // tb.ib2
    @NotNull
    /* renamed from: j */
    public ib2 g(boolean z) {
        if (z == d()) {
            return this;
        }
        return l().j(z).k(getAnnotations());
    }

    /* access modifiers changed from: protected */
    @Override // tb.r50
    @NotNull
    public ib2 l() {
        return this.b;
    }

    @NotNull
    /* renamed from: o */
    public b k(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return annotations != getAnnotations() ? new a(this, annotations) : this;
    }
}
