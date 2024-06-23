package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.es2;
import tb.g61;
import tb.i61;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class NewCapturedTypeConstructor implements CapturedTypeConstructor {
    @NotNull
    private final TypeProjection a;
    @Nullable
    private Function0<? extends List<? extends es2>> b;
    @Nullable
    private final NewCapturedTypeConstructor c;
    @Nullable
    private final TypeParameterDescriptor d;
    @NotNull
    private final Lazy e;

    public NewCapturedTypeConstructor(@NotNull TypeProjection typeProjection, @Nullable Function0<? extends List<? extends es2>> function0, @Nullable NewCapturedTypeConstructor newCapturedTypeConstructor, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        k21.i(typeProjection, "projection");
        this.a = typeProjection;
        this.b = function0;
        this.c = newCapturedTypeConstructor;
        this.d = typeParameterDescriptor;
        this.e = b.a(LazyThreadSafetyMode.PUBLICATION, new NewCapturedTypeConstructor$_supertypes$2(this));
    }

    private final List<es2> c() {
        return (List) this.e.getValue();
    }

    @NotNull
    /* renamed from: b */
    public List<es2> getSupertypes() {
        List<es2> c2 = c();
        return c2 == null ? m.g() : c2;
    }

    public final void d(@NotNull List<? extends es2> list) {
        k21.i(list, "supertypes");
        this.b = new NewCapturedTypeConstructor$initializeSupertypes$2(list);
    }

    @NotNull
    /* renamed from: e */
    public NewCapturedTypeConstructor refine(@NotNull i61 i61) {
        NewCapturedTypeConstructor$refine$1$1 newCapturedTypeConstructor$refine$1$1;
        k21.i(i61, "kotlinTypeRefiner");
        TypeProjection refine = getProjection().refine(i61);
        k21.h(refine, "projection.refine(kotlinTypeRefiner)");
        if (this.b == null) {
            newCapturedTypeConstructor$refine$1$1 = null;
        } else {
            newCapturedTypeConstructor$refine$1$1 = new NewCapturedTypeConstructor$refine$1$1(this, i61);
        }
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.c;
        if (newCapturedTypeConstructor == null) {
            newCapturedTypeConstructor = this;
        }
        return new NewCapturedTypeConstructor(refine, newCapturedTypeConstructor$refine$1$1, newCapturedTypeConstructor, this.d);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k21.d(NewCapturedTypeConstructor.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        NewCapturedTypeConstructor newCapturedTypeConstructor = (NewCapturedTypeConstructor) obj;
        NewCapturedTypeConstructor newCapturedTypeConstructor2 = this.c;
        if (newCapturedTypeConstructor2 == null) {
            newCapturedTypeConstructor2 = this;
        }
        NewCapturedTypeConstructor newCapturedTypeConstructor3 = newCapturedTypeConstructor.c;
        if (newCapturedTypeConstructor3 != null) {
            newCapturedTypeConstructor = newCapturedTypeConstructor3;
        }
        if (newCapturedTypeConstructor2 == newCapturedTypeConstructor) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.b getBuiltIns() {
        g61 type = getProjection().getType();
        k21.h(type, "projection.type");
        return TypeUtilsKt.e(type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @Nullable
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
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

    public int hashCode() {
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.c;
        return newCapturedTypeConstructor == null ? super.hashCode() : newCapturedTypeConstructor.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @NotNull
    public String toString() {
        return "CapturedType(" + getProjection() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection typeProjection, Function0 function0, NewCapturedTypeConstructor newCapturedTypeConstructor, TypeParameterDescriptor typeParameterDescriptor, int i, m40 m40) {
        this(typeProjection, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : newCapturedTypeConstructor, (i & 8) != 0 ? null : typeParameterDescriptor);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection typeProjection, List list, NewCapturedTypeConstructor newCapturedTypeConstructor, int i, m40 m40) {
        this(typeProjection, list, (i & 4) != 0 ? null : newCapturedTypeConstructor);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor(@NotNull TypeProjection typeProjection, @NotNull final List<? extends es2> list, @Nullable NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this(typeProjection, new Function0<List<? extends es2>>() {
            /* class kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor.AnonymousClass1 */

            /* Return type fixed from 'java.util.List<tb.es2>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends es2> invoke() {
                return list;
            }
        }, newCapturedTypeConstructor, null, 8, null);
        k21.i(typeProjection, "projection");
        k21.i(list, "supertypes");
    }
}
