package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public final class rn0 {
    public static final ib2 a(b bVar, Annotations annotations, g61 g61, List<? extends g61> list, List<og1> list2, g61 g612, boolean z) {
        k21.i(bVar, "builtIns");
        k21.i(annotations, "annotations");
        k21.i(list, "parameterTypes");
        k21.i(g612, "returnType");
        List<TypeProjection> e = e(g61, list, list2, g612, bVar);
        int size = list.size();
        if (g61 != null) {
            size++;
        }
        ClassDescriptor d = d(bVar, size, z);
        if (g61 != null) {
            annotations = q(annotations, bVar);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.g(annotations, d, e);
    }

    public static /* synthetic */ ib2 b(b bVar, Annotations annotations, g61 g61, List list, List list2, g61 g612, boolean z, int i, Object obj) {
        return a(bVar, annotations, g61, list, list2, g612, (i & 64) != 0 ? false : z);
    }

    public static final og1 c(g61 g61) {
        String str;
        k21.i(g61, "<this>");
        AnnotationDescriptor findAnnotation = g61.getAnnotations().findAnnotation(c.a.parameterName);
        if (findAnnotation == null) {
            return null;
        }
        Object p0 = k.p0(findAnnotation.getAllValueArguments().values());
        bg2 bg2 = p0 instanceof bg2 ? (bg2) p0 : null;
        if (bg2 == null || (str = (String) bg2.b()) == null || !og1.h(str)) {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return og1.f(str);
    }

    public static final ClassDescriptor d(b bVar, int i, boolean z) {
        k21.i(bVar, "builtIns");
        ClassDescriptor W = z ? bVar.W(i) : bVar.C(i);
        k21.h(W, "if (isSuspendFunction) builtIns.getSuspendFunction(parameterCount) else builtIns.getFunction(parameterCount)");
        return W;
    }

    public static final List<TypeProjection> e(g61 g61, List<? extends g61> list, List<og1> list2, g61 g612, b bVar) {
        og1 og1;
        k21.i(list, "parameterTypes");
        k21.i(g612, "returnType");
        k21.i(bVar, "builtIns");
        int i = 0;
        ArrayList arrayList = new ArrayList(list.size() + (g61 != null ? 1 : 0) + 1);
        qj.a(arrayList, g61 == null ? null : TypeUtilsKt.a(g61));
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            T t2 = t;
            if (list2 == null || (og1 = list2.get(i)) == null || og1.g()) {
                og1 = null;
            }
            if (og1 != null) {
                en0 en0 = c.a.parameterName;
                og1 f = og1.f("name");
                String b = og1.b();
                k21.h(b, "name.asString()");
                t2 = TypeUtilsKt.l(t2, Annotations.Companion.a(CollectionsKt___CollectionsKt.j0(t2.getAnnotations(), new BuiltInAnnotationDescriptor(bVar, en0, w.f(do2.a(f, new bg2(b)))))));
            }
            arrayList.add(TypeUtilsKt.a(t2));
            i = i2;
        }
        arrayList.add(TypeUtilsKt.a(g612));
        return arrayList;
    }

    public static final FunctionClassKind f(DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "<this>");
        if ((declarationDescriptor instanceof ClassDescriptor) && b.I0(declarationDescriptor)) {
            return g(DescriptorUtilsKt.j(declarationDescriptor));
        }
        return null;
    }

    private static final FunctionClassKind g(fn0 fn0) {
        if (!fn0.f() || fn0.e()) {
            return null;
        }
        FunctionClassKind.a aVar = FunctionClassKind.Companion;
        String b = fn0.i().b();
        k21.h(b, "shortName().asString()");
        en0 e = fn0.l().e();
        k21.h(e, "toSafe().parent()");
        return aVar.b(b, e);
    }

    public static final g61 h(g61 g61) {
        k21.i(g61, "<this>");
        m(g61);
        if (p(g61)) {
            return ((TypeProjection) k.P(g61.b())).getType();
        }
        return null;
    }

    public static final g61 i(g61 g61) {
        k21.i(g61, "<this>");
        m(g61);
        g61 type = ((TypeProjection) k.b0(g61.b())).getType();
        k21.h(type, "arguments.last().type");
        return type;
    }

    public static final List<TypeProjection> j(g61 g61) {
        k21.i(g61, "<this>");
        m(g61);
        List<TypeProjection> b = g61.b();
        return b.subList(k(g61) ? 1 : 0, b.size() - 1);
    }

    public static final boolean k(g61 g61) {
        k21.i(g61, "<this>");
        return m(g61) && p(g61);
    }

    public static final boolean l(DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "<this>");
        FunctionClassKind f = f(declarationDescriptor);
        return f == FunctionClassKind.Function || f == FunctionClassKind.SuspendFunction;
    }

    public static final boolean m(g61 g61) {
        k21.i(g61, "<this>");
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        return k21.d(declarationDescriptor == null ? null : Boolean.valueOf(l(declarationDescriptor)), Boolean.TRUE);
    }

    public static final boolean n(g61 g61) {
        k21.i(g61, "<this>");
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        return (declarationDescriptor == null ? null : f(declarationDescriptor)) == FunctionClassKind.Function;
    }

    public static final boolean o(g61 g61) {
        k21.i(g61, "<this>");
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        return (declarationDescriptor == null ? null : f(declarationDescriptor)) == FunctionClassKind.SuspendFunction;
    }

    private static final boolean p(g61 g61) {
        return g61.getAnnotations().findAnnotation(c.a.extensionFunctionType) != null;
    }

    public static final Annotations q(Annotations annotations, b bVar) {
        k21.i(annotations, "<this>");
        k21.i(bVar, "builtIns");
        en0 en0 = c.a.extensionFunctionType;
        return annotations.hasAnnotation(en0) ? annotations : Annotations.Companion.a(CollectionsKt___CollectionsKt.j0(annotations, new BuiltInAnnotationDescriptor(bVar, en0, x.i())));
    }
}
