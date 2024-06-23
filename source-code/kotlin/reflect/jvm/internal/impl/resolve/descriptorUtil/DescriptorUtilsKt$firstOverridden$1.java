package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* access modifiers changed from: package-private */
/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt$firstOverridden$1<N> implements DFS.Neighbors<N> {
    final /* synthetic */ boolean $useOriginal;

    DescriptorUtilsKt$firstOverridden$1(boolean z) {
        this.$useOriginal = z;
    }

    public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
        Collection<? extends CallableMemberDescriptor> collection;
        if (this.$useOriginal) {
            callableMemberDescriptor = callableMemberDescriptor != null ? callableMemberDescriptor.getOriginal() : null;
        }
        if (callableMemberDescriptor == null || (collection = callableMemberDescriptor.getOverriddenDescriptors()) == null) {
            collection = CollectionsKt.emptyList();
        }
        return collection;
    }
}
