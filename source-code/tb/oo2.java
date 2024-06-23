package tb;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class oo2 {
    @NotNull
    private static final vd0 a;
    @NotNull
    private static final vd0 b;

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MutabilityQualifier.values().length];
            iArr[MutabilityQualifier.READ_ONLY.ordinal()] = 1;
            iArr[MutabilityQualifier.MUTABLE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NullabilityQualifier.values().length];
            iArr2[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            iArr2[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        en0 en0 = u41.ENHANCED_NULLABILITY_ANNOTATION;
        k21.h(en0, "ENHANCED_NULLABILITY_ANNOTATION");
        a = new vd0(en0);
        en0 en02 = u41.ENHANCED_MUTABILITY_ANNOTATION;
        k21.h(en02, "ENHANCED_MUTABILITY_ANNOTATION");
        b = new vd0(en02);
    }

    /* access modifiers changed from: private */
    public static final Annotations d(List<? extends Annotations> list) {
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("At least one Annotations object expected".toString());
        } else if (size != 1) {
            return new CompositeAnnotations(CollectionsKt___CollectionsKt.y0(list));
        } else {
            return (Annotations) k.o0(list);
        }
    }

    /* access modifiers changed from: private */
    public static final wd0<ClassifierDescriptor> e(ClassifierDescriptor classifierDescriptor, a41 a41, TypeComponentPosition typeComponentPosition) {
        if (!jo2.a(typeComponentPosition)) {
            return j(classifierDescriptor);
        }
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            return j(classifierDescriptor);
        }
        x31 x31 = x31.INSTANCE;
        MutabilityQualifier b2 = a41.b();
        int i = b2 == null ? -1 : a.$EnumSwitchMapping$0[b2.ordinal()];
        if (i != 1) {
            if (i == 2 && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
                if (x31.e(classDescriptor)) {
                    return f(x31.b(classDescriptor));
                }
            }
        } else if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
            ClassDescriptor classDescriptor2 = (ClassDescriptor) classifierDescriptor;
            if (x31.c(classDescriptor2)) {
                return f(x31.a(classDescriptor2));
            }
        }
        return j(classifierDescriptor);
    }

    private static final <T> wd0<T> f(T t) {
        return new wd0<>(t, b);
    }

    private static final <T> wd0<T> g(T t) {
        return new wd0<>(t, a);
    }

    /* access modifiers changed from: private */
    public static final wd0<Boolean> h(g61 g61, a41 a41, TypeComponentPosition typeComponentPosition) {
        if (!jo2.a(typeComponentPosition)) {
            return j(Boolean.valueOf(g61.d()));
        }
        NullabilityQualifier c = a41.c();
        int i = c == null ? -1 : a.$EnumSwitchMapping$1[c.ordinal()];
        if (i == 1) {
            return g(Boolean.TRUE);
        }
        if (i != 2) {
            return j(Boolean.valueOf(g61.d()));
        }
        return g(Boolean.FALSE);
    }

    public static final boolean i(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        return mo2.b(ab2.INSTANCE, g61);
    }

    private static final <T> wd0<T> j(T t) {
        return new wd0<>(t, null);
    }
}
