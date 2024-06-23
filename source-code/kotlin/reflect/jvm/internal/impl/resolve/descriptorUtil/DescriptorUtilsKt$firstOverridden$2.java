package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt$firstOverridden$2 extends DFS.AbstractNodeHandler<CallableMemberDescriptor, CallableMemberDescriptor> {
    final /* synthetic */ Function1 $predicate;
    final /* synthetic */ Ref.ObjectRef $result;

    DescriptorUtilsKt$firstOverridden$2(Ref.ObjectRef objectRef, Function1 function1) {
        this.$result = objectRef;
        this.$predicate = function1;
    }

    public boolean beforeChildren(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "current");
        return this.$result.element == null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor */
    /* JADX WARN: Multi-variable type inference failed */
    public void afterChildren(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "current");
        if (this.$result.element == null && ((Boolean) this.$predicate.invoke(callableMemberDescriptor)).booleanValue()) {
            this.$result.element = callableMemberDescriptor;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
    public CallableMemberDescriptor result() {
        return this.$result.element;
    }
}
