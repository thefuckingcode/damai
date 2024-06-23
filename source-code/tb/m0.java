package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class m0 extends r50 {
    @NotNull
    private final ib2 b;
    @NotNull
    private final ib2 c;

    public m0(@NotNull ib2 ib2, @NotNull ib2 ib22) {
        k21.i(ib2, "delegate");
        k21.i(ib22, "abbreviation");
        this.b = ib2;
        this.c = ib22;
    }

    @NotNull
    public final ib2 getExpandedType() {
        return l();
    }

    /* access modifiers changed from: protected */
    @Override // tb.r50
    @NotNull
    public ib2 l() {
        return this.b;
    }

    @NotNull
    public final ib2 o() {
        return this.c;
    }

    @NotNull
    /* renamed from: p */
    public m0 j(boolean z) {
        return new m0(l().j(z), this.c.j(z));
    }

    @NotNull
    /* renamed from: q */
    public m0 m(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return new m0((ib2) i61.g(l()), (ib2) i61.g(this.c));
    }

    @NotNull
    /* renamed from: r */
    public m0 k(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return new m0(l().k(annotations), this.c);
    }

    @NotNull
    /* renamed from: s */
    public m0 n(@NotNull ib2 ib2) {
        k21.i(ib2, "delegate");
        return new m0(ib2, this.c);
    }
}
