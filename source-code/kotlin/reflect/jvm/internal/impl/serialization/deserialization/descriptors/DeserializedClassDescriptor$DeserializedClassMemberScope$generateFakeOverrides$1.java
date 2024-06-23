package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1 extends NonReportingOverrideStrategy {
    final /* synthetic */ Collection $result;

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
    public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "fromSuper");
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor2, "fromCurrent");
    }

    DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(Collection collection) {
        this.$result = collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "fakeOverride");
        OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
        this.$result.add(callableMemberDescriptor);
    }
}
