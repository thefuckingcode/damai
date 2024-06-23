package tb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class eo2 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final TypeAliasExpansionReportStrategy a;
    private final boolean b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void b(int i, TypeAliasDescriptor typeAliasDescriptor) {
            if (i > 100) {
                throw new AssertionError(k21.r("Too deep recursion while expanding type alias ", typeAliasDescriptor.getName()));
            }
        }

        public final void c(@NotNull TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, @NotNull g61 g61, @NotNull g61 g612, @NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeSubstitutor typeSubstitutor) {
            k21.i(typeAliasExpansionReportStrategy, "reportStrategy");
            k21.i(g61, "unsubstitutedArgument");
            k21.i(g612, "typeArgument");
            k21.i(typeParameterDescriptor, "typeParameterDescriptor");
            k21.i(typeSubstitutor, "substitutor");
            for (g61 g613 : typeParameterDescriptor.getUpperBounds()) {
                g61 n = typeSubstitutor.n(g613, Variance.INVARIANT);
                k21.h(n, "substitutor.safeSubstitute(bound, Variance.INVARIANT)");
                if (!KotlinTypeChecker.DEFAULT.isSubtypeOf(g612, n)) {
                    typeAliasExpansionReportStrategy.boundsViolationInSubstitution(n, g61, g612, typeParameterDescriptor);
                }
            }
        }
    }

    static {
        new eo2(TypeAliasExpansionReportStrategy.a.INSTANCE, false);
    }

    public eo2(@NotNull TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, boolean z) {
        k21.i(typeAliasExpansionReportStrategy, "reportStrategy");
        this.a = typeAliasExpansionReportStrategy;
        this.b = z;
    }

    private final void a(Annotations annotations, Annotations annotations2) {
        HashSet hashSet = new HashSet();
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(((AnnotationDescriptor) it.next()).getFqName());
        }
        Iterator it2 = annotations2.iterator();
        while (it2.hasNext()) {
            AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor) it2.next();
            if (hashSet.contains(annotationDescriptor.getFqName())) {
                this.a.repeatedAnnotation(annotationDescriptor);
            }
        }
    }

    private final void b(g61 g61, g61 g612) {
        TypeSubstitutor f = TypeSubstitutor.f(g612);
        k21.h(f, "create(substitutedType)");
        int i = 0;
        for (T t : g612.b()) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            T t2 = t;
            if (!t2.isStarProjection()) {
                g61 type = t2.getType();
                k21.h(type, "substitutedArgument.type");
                if (!TypeUtilsKt.c(type)) {
                    TypeProjection typeProjection = g61.b().get(i);
                    TypeParameterDescriptor typeParameterDescriptor = g61.c().getParameters().get(i);
                    if (this.b) {
                        a aVar = Companion;
                        TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.a;
                        g61 type2 = typeProjection.getType();
                        k21.h(type2, "unsubstitutedArgument.type");
                        g61 type3 = t2.getType();
                        k21.h(type3, "substitutedArgument.type");
                        k21.h(typeParameterDescriptor, "typeParameter");
                        aVar.c(typeAliasExpansionReportStrategy, type2, type3, typeParameterDescriptor, f);
                    }
                }
            }
            i = i2;
        }
    }

    private final nc0 c(nc0 nc0, Annotations annotations) {
        return nc0.i(h(nc0, annotations));
    }

    private final ib2 d(ib2 ib2, Annotations annotations) {
        return h61.a(ib2) ? ib2 : yo2.f(ib2, null, h(ib2, annotations), 1, null);
    }

    private final ib2 e(ib2 ib2, g61 g61) {
        ib2 r = bp2.r(ib2, g61.d());
        k21.h(r, "makeNullableIfNeeded(this, fromType.isMarkedNullable)");
        return r;
    }

    private final ib2 f(ib2 ib2, g61 g61) {
        return d(e(ib2, g61), g61.getAnnotations());
    }

    private final ib2 g(fo2 fo2, Annotations annotations, boolean z) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        TypeConstructor typeConstructor = fo2.b().getTypeConstructor();
        k21.h(typeConstructor, "descriptor.typeConstructor");
        return KotlinTypeFactory.j(annotations, typeConstructor, fo2.a(), z, MemberScope.b.INSTANCE);
    }

    private final Annotations h(g61 g61, Annotations annotations) {
        if (h61.a(g61)) {
            return g61.getAnnotations();
        }
        return e6.a(annotations, g61.getAnnotations());
    }

    private final TypeProjection j(TypeProjection typeProjection, fo2 fo2, int i) {
        es2 f = typeProjection.getType().f();
        if (oc0.a(f)) {
            return typeProjection;
        }
        ib2 a2 = yo2.a(f);
        if (h61.a(a2) || !TypeUtilsKt.n(a2)) {
            return typeProjection;
        }
        TypeConstructor c = a2.c();
        ClassifierDescriptor declarationDescriptor = c.getDeclarationDescriptor();
        c.getParameters().size();
        a2.b().size();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        if (declarationDescriptor instanceof TypeAliasDescriptor) {
            TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) declarationDescriptor;
            if (fo2.d(typeAliasDescriptor)) {
                this.a.recursiveTypeAlias(typeAliasDescriptor);
                return new vo2(Variance.INVARIANT, me0.j(k21.r("Recursive type alias: ", typeAliasDescriptor.getName())));
            }
            List<TypeProjection> b2 = a2.b();
            ArrayList arrayList = new ArrayList(n.q(b2, 10));
            int i2 = 0;
            for (TypeProjection typeProjection2 : b2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    m.p();
                }
                arrayList.add(l(typeProjection2, fo2, c.getParameters().get(i2), i + 1));
                i2 = i3;
            }
            ib2 k = k(fo2.Companion.a(fo2, typeAliasDescriptor, arrayList), a2.getAnnotations(), a2.d(), i + 1, false);
            ib2 m = m(a2, fo2, i);
            if (!oc0.a(k)) {
                k = ed2.j(k, m);
            }
            return new vo2(typeProjection.getProjectionKind(), k);
        }
        ib2 m2 = m(a2, fo2, i);
        b(a2, m2);
        return new vo2(typeProjection.getProjectionKind(), m2);
    }

    private final ib2 k(fo2 fo2, Annotations annotations, boolean z, int i, boolean z2) {
        TypeProjection l = l(new vo2(Variance.INVARIANT, fo2.b().getUnderlyingType()), fo2, null, i);
        g61 type = l.getType();
        k21.h(type, "expandedProjection.type");
        ib2 a2 = yo2.a(type);
        if (h61.a(a2)) {
            return a2;
        }
        l.getProjectionKind();
        a(a2.getAnnotations(), annotations);
        ib2 r = bp2.r(d(a2, annotations), z);
        k21.h(r, "expandedType.combineAnnotations(annotations).let { TypeUtils.makeNullableIfNeeded(it, isNullable) }");
        return z2 ? ed2.j(r, g(fo2, annotations, z)) : r;
    }

    private final TypeProjection l(TypeProjection typeProjection, fo2 fo2, TypeParameterDescriptor typeParameterDescriptor, int i) {
        Variance variance;
        g61 g61;
        Variance variance2;
        Variance variance3;
        Companion.b(i, fo2.b());
        if (typeProjection.isStarProjection()) {
            k21.f(typeParameterDescriptor);
            TypeProjection s = bp2.s(typeParameterDescriptor);
            k21.h(s, "makeStarProjection(typeParameterDescriptor!!)");
            return s;
        }
        g61 type = typeProjection.getType();
        k21.h(type, "underlyingProjection.type");
        TypeProjection c = fo2.c(type.c());
        if (c == null) {
            return j(typeProjection, fo2, i);
        }
        if (c.isStarProjection()) {
            k21.f(typeParameterDescriptor);
            TypeProjection s2 = bp2.s(typeParameterDescriptor);
            k21.h(s2, "makeStarProjection(typeParameterDescriptor!!)");
            return s2;
        }
        es2 f = c.getType().f();
        Variance projectionKind = c.getProjectionKind();
        k21.h(projectionKind, "argument.projectionKind");
        Variance projectionKind2 = typeProjection.getProjectionKind();
        k21.h(projectionKind2, "underlyingProjection.projectionKind");
        if (!(projectionKind2 == projectionKind || projectionKind2 == (variance3 = Variance.INVARIANT))) {
            if (projectionKind == variance3) {
                projectionKind = projectionKind2;
            } else {
                this.a.conflictingProjection(fo2.b(), typeParameterDescriptor, f);
            }
        }
        if (typeParameterDescriptor == null) {
            variance = null;
        } else {
            variance = typeParameterDescriptor.getVariance();
        }
        if (variance == null) {
            variance = Variance.INVARIANT;
        }
        k21.h(variance, "typeParameterDescriptor?.variance ?: Variance.INVARIANT");
        if (!(variance == projectionKind || variance == (variance2 = Variance.INVARIANT))) {
            if (projectionKind == variance2) {
                projectionKind = variance2;
            } else {
                this.a.conflictingProjection(fo2.b(), typeParameterDescriptor, f);
            }
        }
        a(type.getAnnotations(), f.getAnnotations());
        if (f instanceof nc0) {
            g61 = c((nc0) f, type.getAnnotations());
        } else {
            g61 = f(yo2.a(f), type);
        }
        return new vo2(projectionKind, g61);
    }

    private final ib2 m(ib2 ib2, fo2 fo2, int i) {
        TypeConstructor c = ib2.c();
        List<TypeProjection> b2 = ib2.b();
        ArrayList arrayList = new ArrayList(n.q(b2, 10));
        int i2 = 0;
        for (T t : b2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                m.p();
            }
            T t2 = t;
            TypeProjection l = l(t2, fo2, c.getParameters().get(i2), i + 1);
            if (!l.isStarProjection()) {
                l = new vo2(l.getProjectionKind(), bp2.q(l.getType(), t2.getType().d()));
            }
            arrayList.add(l);
            i2 = i3;
        }
        return yo2.f(ib2, arrayList, null, 2, null);
    }

    @NotNull
    public final ib2 i(@NotNull fo2 fo2, @NotNull Annotations annotations) {
        k21.i(fo2, "typeAliasExpansion");
        k21.i(annotations, "annotations");
        return k(fo2, annotations, false, 0, true);
    }
}
