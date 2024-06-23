package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* access modifiers changed from: package-private */
/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt$declaresOrInheritsDefaultValue$1<N> implements DFS.Neighbors<N> {
    public static final DescriptorUtilsKt$declaresOrInheritsDefaultValue$1 INSTANCE = new DescriptorUtilsKt$declaresOrInheritsDefaultValue$1();

    DescriptorUtilsKt$declaresOrInheritsDefaultValue$1() {
    }

    public final List<ValueParameterDescriptor> getNeighbors(ValueParameterDescriptor valueParameterDescriptor) {
        Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor, "current");
        Collection<ValueParameterDescriptor> overriddenDescriptors = valueParameterDescriptor.getOverriddenDescriptors();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(overriddenDescriptors, 10));
        Iterator<T> it = overriddenDescriptors.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getOriginal());
        }
        return arrayList;
    }
}
