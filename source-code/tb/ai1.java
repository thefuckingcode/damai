package tb;

import java.util.List;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ai1 extends ib2 implements CapturedTypeMarker {
    @NotNull
    private final CaptureStatus b;
    @NotNull
    private final NewCapturedTypeConstructor c;
    @Nullable
    private final es2 d;
    @NotNull
    private final Annotations e;
    private final boolean f;
    private final boolean g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ai1(CaptureStatus captureStatus, NewCapturedTypeConstructor newCapturedTypeConstructor, es2 es2, Annotations annotations, boolean z, boolean z2, int i, m40 m40) {
        this(captureStatus, newCapturedTypeConstructor, es2, (i & 8) != 0 ? Annotations.Companion.b() : annotations, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
    }

    @Override // tb.g61
    @NotNull
    public List<TypeProjection> b() {
        return m.g();
    }

    @Override // tb.g61
    public boolean d() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.e;
    }

    @Override // tb.g61
    @NotNull
    public MemberScope getMemberScope() {
        MemberScope i = me0.i("No member resolution should be done on captured type!", true);
        k21.h(i, "createErrorScope(\"No member resolution should be done on captured type!\", true)");
        return i;
    }

    @NotNull
    public final CaptureStatus l() {
        return this.b;
    }

    @NotNull
    /* renamed from: m */
    public NewCapturedTypeConstructor c() {
        return this.c;
    }

    @Nullable
    public final es2 n() {
        return this.d;
    }

    public final boolean o() {
        return this.g;
    }

    @NotNull
    /* renamed from: p */
    public ai1 j(boolean z) {
        return new ai1(this.b, c(), this.d, getAnnotations(), z, false, 32, null);
    }

    @NotNull
    /* renamed from: q */
    public ai1 h(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        CaptureStatus captureStatus = this.b;
        NewCapturedTypeConstructor e2 = c().refine(i61);
        es2 es2 = this.d;
        return new ai1(captureStatus, e2, es2 == null ? null : i61.g(es2).f(), getAnnotations(), d(), false, 32, null);
    }

    @NotNull
    /* renamed from: r */
    public ai1 k(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return new ai1(this.b, c(), this.d, annotations, d(), false, 32, null);
    }

    public ai1(@NotNull CaptureStatus captureStatus, @NotNull NewCapturedTypeConstructor newCapturedTypeConstructor, @Nullable es2 es2, @NotNull Annotations annotations, boolean z, boolean z2) {
        k21.i(captureStatus, "captureStatus");
        k21.i(newCapturedTypeConstructor, "constructor");
        k21.i(annotations, "annotations");
        this.b = captureStatus;
        this.c = newCapturedTypeConstructor;
        this.d = es2;
        this.e = annotations;
        this.f = z;
        this.g = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ai1(@NotNull CaptureStatus captureStatus, @Nullable es2 es2, @NotNull TypeProjection typeProjection, @NotNull TypeParameterDescriptor typeParameterDescriptor) {
        this(captureStatus, new NewCapturedTypeConstructor(typeProjection, null, null, typeParameterDescriptor, 6, null), es2, null, false, false, 56, null);
        k21.i(captureStatus, "captureStatus");
        k21.i(typeProjection, "projection");
        k21.i(typeParameterDescriptor, "typeParameter");
    }
}
