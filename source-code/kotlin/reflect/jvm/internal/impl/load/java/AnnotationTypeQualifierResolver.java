package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.r;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a6;
import tb.ae0;
import tb.b6;
import tb.en0;
import tb.hk1;
import tb.k21;
import tb.l31;
import tb.og1;
import tb.om;
import tb.u41;
import tb.w7;

/* compiled from: Taobao */
public final class AnnotationTypeQualifierResolver {
    @NotNull
    private final JavaTypeEnhancementState a;
    @NotNull
    private final MemoizedFunctionToNullable<ClassDescriptor, AnnotationDescriptor> b;

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        private final AnnotationDescriptor a;
        private final int b;

        public a(@NotNull AnnotationDescriptor annotationDescriptor, int i) {
            k21.i(annotationDescriptor, "typeQualifier");
            this.a = annotationDescriptor;
            this.b = i;
        }

        private final boolean c(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
            return ((1 << annotationQualifierApplicabilityType.ordinal()) & this.b) != 0;
        }

        private final boolean d(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
            if (c(annotationQualifierApplicabilityType)) {
                return true;
            }
            if (!c(AnnotationQualifierApplicabilityType.TYPE_USE) || annotationQualifierApplicabilityType == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) {
                return false;
            }
            return true;
        }

        @NotNull
        public final AnnotationDescriptor a() {
            return this.a;
        }

        @NotNull
        public final List<AnnotationQualifierApplicabilityType> b() {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            ArrayList arrayList = new ArrayList();
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : values) {
                if (d(annotationQualifierApplicabilityType)) {
                    arrayList.add(annotationQualifierApplicabilityType);
                }
            }
            return arrayList;
        }
    }

    public AnnotationTypeQualifierResolver(@NotNull StorageManager storageManager, @NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        k21.i(storageManager, "storageManager");
        k21.i(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.a = javaTypeEnhancementState;
        this.b = storageManager.createMemoizedFunctionWithNullableValues(new AnnotationTypeQualifierResolver$resolvedNicknames$1(this));
    }

    /* access modifiers changed from: private */
    public final AnnotationDescriptor c(ClassDescriptor classDescriptor) {
        if (!classDescriptor.getAnnotations().hasAnnotation(a6.g())) {
            return null;
        }
        for (AnnotationDescriptor annotationDescriptor : classDescriptor.getAnnotations()) {
            AnnotationDescriptor m = m(annotationDescriptor);
            if (m != null) {
                return m;
            }
        }
        return null;
    }

    private final List<AnnotationQualifierApplicabilityType> d(om<?> omVar, Function2<? super ae0, ? super AnnotationQualifierApplicabilityType, Boolean> function2) {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        if (omVar instanceof w7) {
            ArrayList arrayList = new ArrayList();
            for (om<?> omVar2 : (Iterable) ((w7) omVar).b()) {
                boolean unused = r.v(arrayList, d(omVar2, function2));
            }
            return arrayList;
        } else if (!(omVar instanceof ae0)) {
            return m.g();
        } else {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    annotationQualifierApplicabilityType = null;
                    break;
                }
                annotationQualifierApplicabilityType = values[i];
                if (function2.invoke(omVar, annotationQualifierApplicabilityType).booleanValue()) {
                    break;
                }
                i++;
            }
            return m.k(annotationQualifierApplicabilityType);
        }
    }

    private final List<AnnotationQualifierApplicabilityType> e(om<?> omVar) {
        return d(omVar, AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1.INSTANCE);
    }

    private final List<AnnotationQualifierApplicabilityType> f(om<?> omVar) {
        return d(omVar, new AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1(this));
    }

    private final ReportLevel g(ClassDescriptor classDescriptor) {
        AnnotationDescriptor findAnnotation = classDescriptor.getAnnotations().findAnnotation(a6.d());
        om<?> b2 = findAnnotation == null ? null : DescriptorUtilsKt.b(findAnnotation);
        ae0 ae0 = b2 instanceof ae0 ? (ae0) b2 : null;
        if (ae0 == null) {
            return null;
        }
        ReportLevel f = this.a.f();
        if (f != null) {
            return f;
        }
        String b3 = ae0.c().b();
        int hashCode = b3.hashCode();
        if (hashCode != -2137067054) {
            if (hashCode != -1838656823) {
                if (hashCode == 2656902 && b3.equals("WARN")) {
                    return ReportLevel.WARN;
                }
                return null;
            } else if (!b3.equals("STRICT")) {
                return null;
            } else {
                return ReportLevel.STRICT;
            }
        } else if (!b3.equals("IGNORE")) {
            return null;
        } else {
            return ReportLevel.IGNORE;
        }
    }

    private final ReportLevel i(AnnotationDescriptor annotationDescriptor) {
        if (a6.c().containsKey(annotationDescriptor.getFqName())) {
            return this.a.e();
        }
        return j(annotationDescriptor);
    }

    private final AnnotationDescriptor o(ClassDescriptor classDescriptor) {
        if (classDescriptor.getKind() != ClassKind.ANNOTATION_CLASS) {
            return null;
        }
        return this.b.invoke(classDescriptor);
    }

    /* access modifiers changed from: private */
    public final List<String> p(String str) {
        Set<KotlinTarget> b2 = JavaAnnotationTargetMapper.INSTANCE.b(str);
        ArrayList arrayList = new ArrayList(n.q(b2, 10));
        Iterator<T> it = b2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().name());
        }
        return arrayList;
    }

    @Nullable
    public final a h(@NotNull AnnotationDescriptor annotationDescriptor) {
        k21.i(annotationDescriptor, "annotationDescriptor");
        ClassDescriptor f = DescriptorUtilsKt.f(annotationDescriptor);
        if (f == null) {
            return null;
        }
        Annotations annotations = f.getAnnotations();
        en0 en0 = u41.TARGET_ANNOTATION;
        k21.h(en0, "TARGET_ANNOTATION");
        AnnotationDescriptor findAnnotation = annotations.findAnnotation(en0);
        if (findAnnotation == null) {
            return null;
        }
        Map<og1, om<?>> allValueArguments = findAnnotation.getAllValueArguments();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<og1, om<?>> entry : allValueArguments.entrySet()) {
            boolean unused = r.v(arrayList, f(entry.getValue()));
        }
        int i = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        return new a(annotationDescriptor, i);
    }

    @NotNull
    public final ReportLevel j(@NotNull AnnotationDescriptor annotationDescriptor) {
        k21.i(annotationDescriptor, "annotationDescriptor");
        ReportLevel k = k(annotationDescriptor);
        return k == null ? this.a.d() : k;
    }

    @Nullable
    public final ReportLevel k(@NotNull AnnotationDescriptor annotationDescriptor) {
        k21.i(annotationDescriptor, "annotationDescriptor");
        Map<String, ReportLevel> g = this.a.g();
        en0 fqName = annotationDescriptor.getFqName();
        ReportLevel reportLevel = g.get(fqName == null ? null : fqName.b());
        if (reportLevel != null) {
            return reportLevel;
        }
        ClassDescriptor f = DescriptorUtilsKt.f(annotationDescriptor);
        if (f == null) {
            return null;
        }
        return g(f);
    }

    @Nullable
    public final l31 l(@NotNull AnnotationDescriptor annotationDescriptor) {
        l31 l31;
        k21.i(annotationDescriptor, "annotationDescriptor");
        if (this.a.a() || (l31 = a6.a().get(annotationDescriptor.getFqName())) == null) {
            return null;
        }
        ReportLevel i = i(annotationDescriptor);
        if (!(i != ReportLevel.IGNORE)) {
            i = null;
        }
        if (i == null) {
            return null;
        }
        return l31.b(l31, hk1.b(l31.e(), null, i.isWarning(), 1, null), null, false, 6, null);
    }

    @Nullable
    public final AnnotationDescriptor m(@NotNull AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor f;
        k21.i(annotationDescriptor, "annotationDescriptor");
        if (this.a.b() || (f = DescriptorUtilsKt.f(annotationDescriptor)) == null) {
            return null;
        }
        if (b6.b(f)) {
            return annotationDescriptor;
        }
        return o(f);
    }

    @Nullable
    public final a n(@NotNull AnnotationDescriptor annotationDescriptor) {
        Object obj;
        boolean z;
        List<AnnotationQualifierApplicabilityType> list;
        k21.i(annotationDescriptor, "annotationDescriptor");
        if (this.a.b()) {
            return null;
        }
        ClassDescriptor f = DescriptorUtilsKt.f(annotationDescriptor);
        if (f == null || !f.getAnnotations().hasAnnotation(a6.e())) {
            f = null;
        }
        if (f == null) {
            return null;
        }
        ClassDescriptor f2 = DescriptorUtilsKt.f(annotationDescriptor);
        k21.f(f2);
        AnnotationDescriptor findAnnotation = f2.getAnnotations().findAnnotation(a6.e());
        k21.f(findAnnotation);
        Map<og1, om<?>> allValueArguments = findAnnotation.getAllValueArguments();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<og1, om<?>> entry : allValueArguments.entrySet()) {
            om<?> value = entry.getValue();
            if (k21.d(entry.getKey(), u41.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                list = e(value);
            } else {
                list = m.g();
            }
            boolean unused = r.v(arrayList, list);
        }
        int i = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        Iterator it = f.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (m((AnnotationDescriptor) obj) != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        AnnotationDescriptor annotationDescriptor2 = (AnnotationDescriptor) obj;
        if (annotationDescriptor2 == null) {
            return null;
        }
        return new a(annotationDescriptor2, i);
    }
}
