package tb;

import java.util.Collection;
import java.util.List;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class sf implements CapturedTypeConstructor {
    @NotNull
    private final TypeProjection a;
    @Nullable
    private NewCapturedTypeConstructor b;

    public sf(@NotNull TypeProjection typeProjection) {
        k21.i(typeProjection, "projection");
        this.a = typeProjection;
        getProjection().getProjectionKind();
        Variance variance = Variance.INVARIANT;
    }

    @Nullable
    public Void a() {
        return null;
    }

    @Nullable
    public final NewCapturedTypeConstructor b() {
        return this.b;
    }

    @NotNull
    /* renamed from: c */
    public sf refine(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        TypeProjection refine = getProjection().refine(i61);
        k21.h(refine, "projection.refine(kotlinTypeRefiner)");
        return new sf(refine);
    }

    public final void d(@Nullable NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this.b = newCapturedTypeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public b getBuiltIns() {
        b builtIns = getProjection().getType().c().getBuiltIns();
        k21.h(builtIns, "projection.type.constructor.builtIns");
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
        return (ClassifierDescriptor) a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    @NotNull
    public TypeProjection getProjection() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public Collection<g61> getSupertypes() {
        g61 g61;
        if (getProjection().getProjectionKind() == Variance.OUT_VARIANCE) {
            g61 = getProjection().getType();
        } else {
            g61 = getBuiltIns().I();
        }
        k21.h(g61, "if (projection.projectionKind == Variance.OUT_VARIANCE)\n            projection.type\n        else\n            builtIns.nullableAnyType");
        return l.e(g61);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @NotNull
    public String toString() {
        return "CapturedTypeConstructor(" + getProjection() + ')';
    }
}
