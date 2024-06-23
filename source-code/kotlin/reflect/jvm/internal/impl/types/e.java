package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.i61;
import tb.ib2;
import tb.k21;
import tb.me0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class e extends ib2 {
    @NotNull
    private final TypeConstructor b;
    @NotNull
    private final List<TypeProjection> c;
    private final boolean d;
    @NotNull
    private final MemberScope e;
    @NotNull
    private final Function1<i61, ib2> f;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super tb.i61, ? extends tb.ib2> */
    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z, @NotNull MemberScope memberScope, @NotNull Function1<? super i61, ? extends ib2> function1) {
        k21.i(typeConstructor, "constructor");
        k21.i(list, "arguments");
        k21.i(memberScope, "memberScope");
        k21.i(function1, "refinedTypeFactory");
        this.b = typeConstructor;
        this.c = list;
        this.d = z;
        this.e = memberScope;
        this.f = function1;
        if (getMemberScope() instanceof me0.d) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + getMemberScope() + '\n' + c());
        }
    }

    @Override // tb.g61
    @NotNull
    public List<TypeProjection> b() {
        return this.c;
    }

    @Override // tb.g61
    @NotNull
    public TypeConstructor c() {
        return this.b;
    }

    @Override // tb.g61
    public boolean d() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return Annotations.Companion.b();
    }

    @Override // tb.g61
    @NotNull
    public MemberScope getMemberScope() {
        return this.e;
    }

    @Override // tb.ib2
    @NotNull
    /* renamed from: j */
    public ib2 g(boolean z) {
        if (z == d()) {
            return this;
        }
        if (z) {
            return new d(this);
        }
        return new c(this);
    }

    @Override // tb.ib2
    @NotNull
    /* renamed from: k */
    public ib2 i(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return annotations.isEmpty() ? this : new a(this, annotations);
    }

    @NotNull
    /* renamed from: l */
    public ib2 h(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        ib2 invoke = this.f.invoke(i61);
        return invoke == null ? this : invoke;
    }
}
