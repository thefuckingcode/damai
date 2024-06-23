package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class l50 extends r50 implements CustomTypeVariable, DefinitelyNotNullTypeMarker {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final ib2 b;
    private final boolean c;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        private final boolean a(es2 es2) {
            return (es2.c() instanceof NewTypeVariableConstructor) || (es2.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor) || (es2 instanceof ai1);
        }

        private final boolean c(es2 es2, boolean z) {
            if (!a(es2)) {
                return false;
            }
            if (!z || !(es2.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
                return !gk1.INSTANCE.a(es2);
            }
            return bp2.l(es2);
        }

        @Nullable
        public final l50 b(@NotNull es2 es2, boolean z) {
            k21.i(es2, "type");
            if (es2 instanceof l50) {
                return (l50) es2;
            }
            if (!c(es2, z)) {
                return null;
            }
            if (es2 instanceof dj0) {
                dj0 dj0 = (dj0) es2;
                k21.d(dj0.k().c(), dj0.l().c());
            }
            return new l50(gj0.c(es2), z, null);
        }
    }

    private l50(ib2 ib2, boolean z) {
        this.b = ib2;
        this.c = z;
    }

    public /* synthetic */ l50(ib2 ib2, boolean z, m40 m40) {
        this(ib2, z);
    }

    @Override // tb.r50, tb.g61
    public boolean d() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public boolean isTypeVariable() {
        return (l().c() instanceof NewTypeVariableConstructor) || (l().c().getDeclarationDescriptor() instanceof TypeParameterDescriptor);
    }

    @Override // tb.ib2
    @NotNull
    /* renamed from: j */
    public ib2 g(boolean z) {
        return z ? l().j(z) : this;
    }

    /* access modifiers changed from: protected */
    @Override // tb.r50
    @NotNull
    public ib2 l() {
        return this.b;
    }

    @NotNull
    public final ib2 o() {
        return this.b;
    }

    @NotNull
    /* renamed from: p */
    public l50 k(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return new l50(l().k(annotations), this.c);
    }

    @NotNull
    /* renamed from: q */
    public l50 n(@NotNull ib2 ib2) {
        k21.i(ib2, "delegate");
        return new l50(ib2, this.c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    @NotNull
    public g61 substitutionResult(@NotNull g61 g61) {
        k21.i(g61, "replacement");
        return ed2.e(g61.f(), this.c);
    }

    @Override // tb.ib2
    @NotNull
    public String toString() {
        return l() + "!!";
    }
}
