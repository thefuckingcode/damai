package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.youku.arch.v3.data.Constants;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;
import tb.b41;
import tb.hk1;
import tb.k21;
import tb.l31;
import tb.v31;
import tb.x61;

public final class ContextKt {
    private static final x61 a(x61 x61, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i, Lazy<b41> lazy) {
        TypeParameterResolver typeParameterResolver;
        v31 a = x61.a();
        if (javaTypeParameterListOwner == null) {
            typeParameterResolver = null;
        } else {
            typeParameterResolver = new LazyJavaTypeParameterResolver(x61, declarationDescriptor, javaTypeParameterListOwner, i);
        }
        if (typeParameterResolver == null) {
            typeParameterResolver = x61.f();
        }
        return new x61(a, typeParameterResolver, lazy);
    }

    public static final x61 b(x61 x61, TypeParameterResolver typeParameterResolver) {
        k21.i(x61, "<this>");
        k21.i(typeParameterResolver, "typeParameterResolver");
        return new x61(x61.a(), typeParameterResolver, x61.c());
    }

    public static final x61 c(x61 x61, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        k21.i(x61, "<this>");
        k21.i(classOrPackageFragmentDescriptor, "containingDeclaration");
        return a(x61, classOrPackageFragmentDescriptor, javaTypeParameterListOwner, i, b.a(LazyThreadSafetyMode.NONE, new ContextKt$childForClassOrPackage$1(x61, classOrPackageFragmentDescriptor)));
    }

    public static /* synthetic */ x61 d(x61 x61, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            javaTypeParameterListOwner = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return c(x61, classOrPackageFragmentDescriptor, javaTypeParameterListOwner, i);
    }

    public static final x61 e(x61 x61, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        k21.i(x61, "<this>");
        k21.i(declarationDescriptor, "containingDeclaration");
        k21.i(javaTypeParameterListOwner, "typeParameterOwner");
        return a(x61, declarationDescriptor, javaTypeParameterListOwner, i, x61.c());
    }

    public static /* synthetic */ x61 f(x61 x61, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return e(x61, declarationDescriptor, javaTypeParameterListOwner, i);
    }

    public static final b41 g(x61 x61, Annotations annotations) {
        EnumMap<AnnotationQualifierApplicabilityType, l31> b;
        k21.i(x61, "<this>");
        k21.i(annotations, "additionalAnnotations");
        if (x61.a().h().a()) {
            return x61.b();
        }
        ArrayList<l31> arrayList = new ArrayList();
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            l31 i = i(x61, (AnnotationDescriptor) it.next());
            if (i != null) {
                arrayList.add(i);
            }
        }
        if (arrayList.isEmpty()) {
            return x61.b();
        }
        b41 b2 = x61.b();
        EnumMap enumMap = null;
        if (!(b2 == null || (b = b2.b()) == null)) {
            enumMap = new EnumMap((EnumMap) b);
        }
        if (enumMap == null) {
            enumMap = new EnumMap(AnnotationQualifierApplicabilityType.class);
        }
        boolean z = false;
        for (l31 l31 : arrayList) {
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : l31.f()) {
                enumMap.put((Object) annotationQualifierApplicabilityType, (Object) l31);
                z = true;
            }
        }
        return !z ? x61.b() : new b41(enumMap);
    }

    public static final x61 h(x61 x61, Annotations annotations) {
        k21.i(x61, "<this>");
        k21.i(annotations, "additionalAnnotations");
        return annotations.isEmpty() ? x61 : new x61(x61.a(), x61.f(), b.a(LazyThreadSafetyMode.NONE, new ContextKt$copyWithNewDefaultTypeQualifiers$1(x61, annotations)));
    }

    private static final l31 i(x61 x61, AnnotationDescriptor annotationDescriptor) {
        hk1 hk1;
        AnnotationTypeQualifierResolver a = x61.a().a();
        l31 l = a.l(annotationDescriptor);
        if (l != null) {
            return l;
        }
        AnnotationTypeQualifierResolver.a n = a.n(annotationDescriptor);
        if (n == null) {
            return null;
        }
        AnnotationDescriptor a2 = n.a();
        List<AnnotationQualifierApplicabilityType> b = n.b();
        ReportLevel k = a.k(annotationDescriptor);
        if (k == null) {
            k = a.j(a2);
        }
        if (k.isIgnore()) {
            return null;
        }
        hk1 h = x61.a().q().h(a2, x61.a().p().getTypeEnhancementImprovements(), false);
        if (h == null) {
            hk1 = null;
        } else {
            hk1 = hk1.b(h, null, k.isWarning(), 1, null);
        }
        if (hk1 == null) {
            return null;
        }
        return new l31(hk1, b, false, 4, null);
    }

    public static final x61 j(x61 x61, v31 v31) {
        k21.i(x61, "<this>");
        k21.i(v31, Constants.COMPONENT);
        return new x61(v31, x61.f(), x61.c());
    }
}
