package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class jb2 extends r50 implements TypeWithEnhancement {
    @NotNull
    private final ib2 b;
    @NotNull
    private final g61 c;

    public jb2(@NotNull ib2 ib2, @NotNull g61 g61) {
        k21.i(ib2, "delegate");
        k21.i(g61, "enhancement");
        this.b = ib2;
        this.c = g61;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    @NotNull
    public g61 getEnhancement() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    @NotNull
    public es2 getOrigin() {
        return l();
    }

    @Override // tb.ib2
    @NotNull
    /* renamed from: j */
    public ib2 g(boolean z) {
        return (ib2) cp2.d(getOrigin().g(z), getEnhancement().f().g(z));
    }

    @Override // tb.ib2
    @NotNull
    /* renamed from: k */
    public ib2 i(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return (ib2) cp2.d(getOrigin().i(annotations), getEnhancement());
    }

    /* access modifiers changed from: protected */
    @Override // tb.r50
    @NotNull
    public ib2 l() {
        return this.b;
    }

    @NotNull
    /* renamed from: o */
    public jb2 m(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return new jb2((ib2) i61.g(l()), i61.g(getEnhancement()));
    }

    @NotNull
    /* renamed from: p */
    public jb2 n(@NotNull ib2 ib2) {
        k21.i(ib2, "delegate");
        return new jb2(ib2, getEnhancement());
    }
}
