package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.k;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bp2;
import tb.cp2;
import tb.dj0;
import tb.es2;
import tb.g61;
import tb.ib2;
import tb.k21;
import tb.vo2;
import tb.yo2;

/* compiled from: Taobao */
public final class TypeUtilsKt {
    @NotNull
    public static final TypeProjection a(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        return new vo2(g61);
    }

    public static final boolean b(@NotNull g61 g61, @NotNull Function1<? super es2, Boolean> function1) {
        k21.i(g61, "<this>");
        k21.i(function1, "predicate");
        return bp2.c(g61, function1);
    }

    public static final boolean c(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        return b(g61, TypeUtilsKt$containsTypeAliasParameters$1.INSTANCE);
    }

    @NotNull
    public static final TypeProjection d(@NotNull g61 g61, @NotNull Variance variance, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        k21.i(g61, "type");
        k21.i(variance, "projectionKind");
        if ((typeParameterDescriptor == null ? null : typeParameterDescriptor.getVariance()) == variance) {
            variance = Variance.INVARIANT;
        }
        return new vo2(variance, g61);
    }

    @NotNull
    public static final b e(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        b builtIns = g61.c().getBuiltIns();
        k21.h(builtIns, "constructor.builtIns");
        return builtIns;
    }

    @NotNull
    public static final g61 f(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        ClassDescriptor classDescriptor;
        k21.i(typeParameterDescriptor, "<this>");
        List<g61> upperBounds = typeParameterDescriptor.getUpperBounds();
        k21.h(upperBounds, "upperBounds");
        upperBounds.isEmpty();
        List<g61> upperBounds2 = typeParameterDescriptor.getUpperBounds();
        k21.h(upperBounds2, "upperBounds");
        Iterator<T> it = upperBounds2.iterator();
        while (true) {
            classDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            ClassifierDescriptor declarationDescriptor = next.c().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                classDescriptor = (ClassDescriptor) declarationDescriptor;
            }
            boolean z = false;
            if (!(classDescriptor == null || classDescriptor.getKind() == ClassKind.INTERFACE || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS)) {
                z = true;
                continue;
            }
            if (z) {
                classDescriptor = next;
                break;
            }
        }
        g61 g61 = (g61) classDescriptor;
        if (g61 != null) {
            return g61;
        }
        List<g61> upperBounds3 = typeParameterDescriptor.getUpperBounds();
        k21.h(upperBounds3, "upperBounds");
        Object P = k.P(upperBounds3);
        k21.h(P, "upperBounds.first()");
        return (g61) P;
    }

    public static final boolean g(@NotNull g61 g61, @NotNull g61 g612) {
        k21.i(g61, "<this>");
        k21.i(g612, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(g61, g612);
    }

    public static final boolean h(@NotNull ClassifierDescriptor classifierDescriptor) {
        k21.i(classifierDescriptor, "<this>");
        return (classifierDescriptor instanceof TypeParameterDescriptor) && (((TypeParameterDescriptor) classifierDescriptor).getContainingDeclaration() instanceof TypeAliasDescriptor);
    }

    public static final boolean i(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        return bp2.m(g61);
    }

    @NotNull
    public static final g61 j(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        g61 n = bp2.n(g61);
        k21.h(n, "makeNotNullable(this)");
        return n;
    }

    @NotNull
    public static final g61 k(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        g61 o = bp2.o(g61);
        k21.h(o, "makeNullable(this)");
        return o;
    }

    @NotNull
    public static final g61 l(@NotNull g61 g61, @NotNull Annotations annotations) {
        k21.i(g61, "<this>");
        k21.i(annotations, "newAnnotations");
        if (!g61.getAnnotations().isEmpty() || !annotations.isEmpty()) {
            return g61.f().i(annotations);
        }
        return g61;
    }

    @NotNull
    public static final g61 m(@NotNull g61 g61) {
        ib2 ib2;
        k21.i(g61, "<this>");
        es2 f = g61.f();
        if (f instanceof dj0) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            dj0 dj0 = (dj0) f;
            ib2 k = dj0.k();
            if (!k.c().getParameters().isEmpty() && k.c().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = k.c().getParameters();
                k21.h(parameters, "constructor.parameters");
                ArrayList arrayList = new ArrayList(n.q(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new StarProjectionImpl(it.next()));
                }
                k = yo2.f(k, arrayList, null, 2, null);
            }
            ib2 l = dj0.l();
            if (!l.c().getParameters().isEmpty() && l.c().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = l.c().getParameters();
                k21.h(parameters2, "constructor.parameters");
                ArrayList arrayList2 = new ArrayList(n.q(parameters2, 10));
                Iterator<T> it2 = parameters2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new StarProjectionImpl(it2.next()));
                }
                l = yo2.f(l, arrayList2, null, 2, null);
            }
            ib2 = KotlinTypeFactory.d(k, l);
        } else if (f instanceof ib2) {
            ib2 ib22 = (ib2) f;
            boolean isEmpty = ib22.c().getParameters().isEmpty();
            ib2 = ib22;
            if (!isEmpty) {
                ClassifierDescriptor declarationDescriptor = ib22.c().getDeclarationDescriptor();
                ib2 = ib22;
                if (declarationDescriptor != null) {
                    List<TypeParameterDescriptor> parameters3 = ib22.c().getParameters();
                    k21.h(parameters3, "constructor.parameters");
                    ArrayList arrayList3 = new ArrayList(n.q(parameters3, 10));
                    Iterator<T> it3 = parameters3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new StarProjectionImpl(it3.next()));
                    }
                    ib2 = yo2.f(ib22, arrayList3, null, 2, null);
                }
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return cp2.b(ib2, f);
    }

    public static final boolean n(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        return b(g61, TypeUtilsKt$requiresTypeAliasExpansion$1.INSTANCE);
    }
}
