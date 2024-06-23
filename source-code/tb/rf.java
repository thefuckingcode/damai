package tb;

import java.util.List;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class rf extends ib2 implements CapturedTypeMarker {
    @NotNull
    private final TypeProjection b;
    @NotNull
    private final CapturedTypeConstructor c;
    private final boolean d;
    @NotNull
    private final Annotations e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rf(TypeProjection typeProjection, CapturedTypeConstructor capturedTypeConstructor, boolean z, Annotations annotations, int i, m40 m40) {
        this(typeProjection, (i & 2) != 0 ? new sf(typeProjection) : capturedTypeConstructor, (i & 4) != 0 ? false : z, (i & 8) != 0 ? Annotations.Companion.b() : annotations);
    }

    @Override // tb.g61
    @NotNull
    public List<TypeProjection> b() {
        return m.g();
    }

    @Override // tb.g61
    public boolean d() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.e;
    }

    @Override // tb.g61
    @NotNull
    public MemberScope getMemberScope() {
        MemberScope i = me0.i("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        k21.h(i, "createErrorScope(\n            \"No member resolution should be done on captured type, it used only during constraint system resolution\", true\n        )");
        return i;
    }

    @NotNull
    /* renamed from: l */
    public CapturedTypeConstructor c() {
        return this.c;
    }

    @NotNull
    /* renamed from: m */
    public rf j(boolean z) {
        if (z == d()) {
            return this;
        }
        return new rf(this.b, c(), z, getAnnotations());
    }

    @NotNull
    /* renamed from: n */
    public rf h(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        TypeProjection refine = this.b.refine(i61);
        k21.h(refine, "typeProjection.refine(kotlinTypeRefiner)");
        return new rf(refine, c(), d(), getAnnotations());
    }

    @NotNull
    /* renamed from: o */
    public rf k(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return new rf(this.b, c(), d(), annotations);
    }

    @Override // tb.ib2
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Captured(");
        sb.append(this.b);
        sb.append(')');
        sb.append(d() ? "?" : "");
        return sb.toString();
    }

    public rf(@NotNull TypeProjection typeProjection, @NotNull CapturedTypeConstructor capturedTypeConstructor, boolean z, @NotNull Annotations annotations) {
        k21.i(typeProjection, "typeProjection");
        k21.i(capturedTypeConstructor, "constructor");
        k21.i(annotations, "annotations");
        this.b = typeProjection;
        this.c = capturedTypeConstructor;
        this.d = z;
        this.e = annotations;
    }
}
