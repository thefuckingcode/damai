package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class vt2 {
    @NotNull
    public static final List<ValueParameterDescriptor> a(@NotNull Collection<xu2> collection, @NotNull Collection<? extends ValueParameterDescriptor> collection2, @NotNull CallableDescriptor callableDescriptor) {
        k21.i(collection, "newValueParametersTypes");
        k21.i(collection2, "oldValueParameters");
        k21.i(callableDescriptor, "newOwner");
        collection.size();
        collection2.size();
        List<Pair> list = CollectionsKt___CollectionsKt.F0(collection, collection2);
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (Pair pair : list) {
            xu2 xu2 = (xu2) pair.component1();
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.component2();
            int index = valueParameterDescriptor.getIndex();
            Annotations annotations = valueParameterDescriptor.getAnnotations();
            og1 name = valueParameterDescriptor.getName();
            k21.h(name, "oldParameter.name");
            g61 b = xu2.b();
            boolean a = xu2.a();
            boolean isCrossinline = valueParameterDescriptor.isCrossinline();
            boolean isNoinline = valueParameterDescriptor.isNoinline();
            g61 k = valueParameterDescriptor.getVarargElementType() != null ? DescriptorUtilsKt.l(callableDescriptor).getBuiltIns().k(xu2.b()) : null;
            SourceElement source = valueParameterDescriptor.getSource();
            k21.h(source, "oldParameter.source");
            arrayList.add(new ValueParameterDescriptorImpl(callableDescriptor, null, index, annotations, name, b, a, isCrossinline, isNoinline, k, source));
        }
        return arrayList;
    }

    @Nullable
    public static final y5 b(@NotNull ValueParameterDescriptor valueParameterDescriptor) {
        bg2 bg2;
        String str;
        om<?> b;
        k21.i(valueParameterDescriptor, "<this>");
        Annotations annotations = valueParameterDescriptor.getAnnotations();
        en0 en0 = u41.DEFAULT_VALUE_FQ_NAME;
        k21.h(en0, "DEFAULT_VALUE_FQ_NAME");
        AnnotationDescriptor findAnnotation = annotations.findAnnotation(en0);
        if (findAnnotation == null || (b = DescriptorUtilsKt.b(findAnnotation)) == null) {
            bg2 = null;
        } else {
            if (!(b instanceof bg2)) {
                b = null;
            }
            bg2 = (bg2) b;
        }
        if (bg2 != null && (str = (String) bg2.b()) != null) {
            return new kf2(str);
        }
        Annotations annotations2 = valueParameterDescriptor.getAnnotations();
        en0 en02 = u41.DEFAULT_NULL_FQ_NAME;
        k21.h(en02, "DEFAULT_NULL_FQ_NAME");
        if (annotations2.hasAnnotation(en02)) {
            return ck1.INSTANCE;
        }
        return null;
    }

    @Nullable
    public static final LazyJavaStaticClassScope c(@NotNull ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "<this>");
        ClassDescriptor p = DescriptorUtilsKt.p(classDescriptor);
        LazyJavaStaticClassScope lazyJavaStaticClassScope = null;
        if (p == null) {
            return null;
        }
        MemberScope staticScope = p.getStaticScope();
        if (staticScope instanceof LazyJavaStaticClassScope) {
            lazyJavaStaticClassScope = (LazyJavaStaticClassScope) staticScope;
        }
        return lazyJavaStaticClassScope == null ? c(p) : lazyJavaStaticClassScope;
    }
}
