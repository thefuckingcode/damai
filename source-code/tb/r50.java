package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class r50 extends ib2 {
    @Override // tb.g61
    @NotNull
    public List<TypeProjection> b() {
        return l().b();
    }

    @Override // tb.g61
    @NotNull
    public TypeConstructor c() {
        return l().c();
    }

    @Override // tb.g61
    public boolean d() {
        return l().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return l().getAnnotations();
    }

    @Override // tb.g61
    @NotNull
    public MemberScope getMemberScope() {
        return l().getMemberScope();
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract ib2 l();

    @NotNull
    /* renamed from: m */
    public ib2 h(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return n((ib2) i61.g(l()));
    }

    @NotNull
    public abstract r50 n(@NotNull ib2 ib2);
}
