package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class z31 {
    @NotNull
    private final JavaResolverSettings a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        @NotNull
        private final g61 a;
        private final int b;
        private final boolean c;

        public a(@NotNull g61 g61, int i, boolean z) {
            k21.i(g61, "type");
            this.a = g61;
            this.b = i;
            this.c = z;
        }

        public final int a() {
            return this.b;
        }

        @NotNull
        public g61 b() {
            return this.a;
        }

        @Nullable
        public final g61 c() {
            g61 b2 = b();
            if (d()) {
                return b2;
            }
            return null;
        }

        public final boolean d() {
            return this.c;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b extends a {
        @NotNull
        private final ib2 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull ib2 ib2, int i, boolean z) {
            super(ib2, i, z);
            k21.i(ib2, "type");
            this.d = ib2;
        }

        @NotNull
        /* renamed from: e */
        public ib2 b() {
            return this.d;
        }
    }

    public z31(@NotNull JavaResolverSettings javaResolverSettings) {
        k21.i(javaResolverSettings, "javaResolverSettings");
        this.a = javaResolverSettings;
    }

    private final g61 a(g61 g61, g61 g612) {
        g61 a2 = cp2.a(g612);
        g61 a3 = cp2.a(g61);
        if (a3 == null) {
            if (a2 == null) {
                return null;
            }
            a3 = a2;
        }
        if (a2 == null) {
            return a3;
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.d(gj0.c(a3), gj0.d(a2));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x0177 */
    private final b c(ib2 ib2, Function1<? super Integer, a41> function1, int i, TypeComponentPosition typeComponentPosition, boolean z) {
        TypeProjection typeProjection;
        if (!jo2.a(typeComponentPosition) && ib2.b().isEmpty()) {
            return new b(ib2, 1, false);
        }
        ClassifierDescriptor declarationDescriptor = ib2.c().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return new b(ib2, 1, false);
        }
        a41 invoke = function1.invoke(Integer.valueOf(i));
        wd0 b2 = oo2.b(declarationDescriptor, invoke, typeComponentPosition);
        ClassifierDescriptor classifierDescriptor = (ClassifierDescriptor) b2.a();
        Annotations b3 = b2.b();
        TypeConstructor typeConstructor = classifierDescriptor.getTypeConstructor();
        k21.h(typeConstructor, "enhancedClassifier.typeConstructor");
        int i2 = i + 1;
        boolean z2 = b3 != null;
        List<TypeProjection> b4 = ib2.b();
        ArrayList arrayList = new ArrayList(n.q(b4, 10));
        int i3 = 0;
        for (T t : b4) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                m.p();
            }
            T t2 = t;
            if (t2.isStarProjection()) {
                int i5 = i2 + 1;
                if (function1.invoke(Integer.valueOf(i2)).c() != NullabilityQualifier.NOT_NULL || z) {
                    typeProjection = bp2.s(classifierDescriptor.getTypeConstructor().getParameters().get(i3));
                    k21.h(typeProjection, "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }");
                } else {
                    g61 j = TypeUtilsKt.j(t2.getType().f());
                    Variance projectionKind = t2.getProjectionKind();
                    k21.h(projectionKind, "arg.projectionKind");
                    typeProjection = TypeUtilsKt.d(j, projectionKind, typeConstructor.getParameters().get(i3));
                }
                i2 = i5;
            } else {
                a e = e(t2.getType().f(), function1, i2);
                z2 = z2 || e.d();
                i2 += e.a();
                g61 b5 = e.b();
                Variance projectionKind2 = t2.getProjectionKind();
                k21.h(projectionKind2, "arg.projectionKind");
                typeProjection = TypeUtilsKt.d(b5, projectionKind2, typeConstructor.getParameters().get(i3));
            }
            arrayList.add(typeProjection);
            i3 = i4;
        }
        wd0 c = oo2.c(ib2, invoke, typeComponentPosition);
        boolean booleanValue = ((Boolean) c.a()).booleanValue();
        Annotations b6 = c.b();
        int i6 = i2 - i;
        if (!(z2 || b6 != null)) {
            return new b(ib2, i6, false);
        }
        boolean z3 = false;
        Annotations a2 = oo2.a(m.l(ib2.getAnnotations(), b3, b6));
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        ib2 i7 = KotlinTypeFactory.i(a2, typeConstructor, arrayList, booleanValue, null, 16, null);
        es2 es2 = i7;
        if (invoke.d()) {
            es2 = f(i7);
        }
        if (b6 != null && invoke.e()) {
            z3 = true;
        }
        if (z3) {
            es2 = cp2.d(ib2, es2);
        }
        return new b((ib2) es2, i6, true);
    }

    static /* synthetic */ b d(z31 z31, ib2 ib2, Function1 function1, int i, TypeComponentPosition typeComponentPosition, boolean z, int i2, Object obj) {
        return z31.c(ib2, function1, i, typeComponentPosition, (i2 & 8) != 0 ? false : z);
    }

    private final a e(es2 es2, Function1<? super Integer, a41> function1, int i) {
        es2 es22;
        boolean z = false;
        if (h61.a(es2)) {
            return new a(es2, 1, false);
        }
        if (es2 instanceof dj0) {
            boolean z2 = es2 instanceof RawType;
            dj0 dj0 = (dj0) es2;
            b c = c(dj0.k(), function1, i, TypeComponentPosition.FLEXIBLE_LOWER, z2);
            b c2 = c(dj0.l(), function1, i, TypeComponentPosition.FLEXIBLE_UPPER, z2);
            c.a();
            c2.a();
            if (c.d() || c2.d()) {
                z = true;
            }
            g61 a2 = a(c.b(), c2.b());
            if (z) {
                if (es2 instanceof RawTypeImpl) {
                    es22 = new RawTypeImpl(c.b(), c2.b());
                } else {
                    KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                    es22 = KotlinTypeFactory.d(c.b(), c2.b());
                }
                es2 = cp2.d(es22, a2);
            }
            return new a(es2, c.a(), z);
        } else if (es2 instanceof ib2) {
            return d(this, (ib2) es2, function1, i, TypeComponentPosition.INFLEXIBLE, false, 8, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final ib2 f(ib2 ib2) {
        if (this.a.getCorrectNullabilityForNotNullTypeParameter()) {
            return ed2.h(ib2, true);
        }
        return new mj1(ib2);
    }

    @Nullable
    public final g61 b(@NotNull g61 g61, @NotNull Function1<? super Integer, a41> function1) {
        k21.i(g61, "<this>");
        k21.i(function1, "qualifiers");
        return e(g61.f(), function1, 0).c();
    }
}
