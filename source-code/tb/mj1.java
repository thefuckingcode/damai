package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class mj1 extends r50 implements NotNullTypeVariable {
    @NotNull
    private final ib2 b;

    public mj1(@NotNull ib2 ib2) {
        k21.i(ib2, "delegate");
        this.b = ib2;
    }

    private final ib2 o(ib2 ib2) {
        ib2 j = ib2.j(false);
        if (!TypeUtilsKt.i(ib2)) {
            return j;
        }
        return new mj1(j);
    }

    @Override // tb.r50, tb.g61
    public boolean d() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public boolean isTypeVariable() {
        return true;
    }

    @Override // tb.ib2
    @NotNull
    /* renamed from: j */
    public ib2 g(boolean z) {
        return z ? l().j(true) : this;
    }

    /* access modifiers changed from: protected */
    @Override // tb.r50
    @NotNull
    public ib2 l() {
        return this.b;
    }

    @NotNull
    /* renamed from: p */
    public mj1 k(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return new mj1(l().k(annotations));
    }

    @NotNull
    /* renamed from: q */
    public mj1 n(@NotNull ib2 ib2) {
        k21.i(ib2, "delegate");
        return new mj1(ib2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    @NotNull
    public g61 substitutionResult(@NotNull g61 g61) {
        k21.i(g61, "replacement");
        es2 f = g61.f();
        if (!TypeUtilsKt.i(f) && !bp2.l(f)) {
            return f;
        }
        if (f instanceof ib2) {
            return o((ib2) f);
        }
        if (f instanceof dj0) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            dj0 dj0 = (dj0) f;
            return cp2.d(KotlinTypeFactory.d(o(dj0.k()), o(dj0.l())), cp2.a(f));
        }
        throw new IllegalStateException(k21.r("Incorrect type: ", f).toString());
    }
}
