package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: OverridingStrategy.kt */
public abstract class NonReportingOverrideStrategy extends OverridingStrategy {
    /* access modifiers changed from: protected */
    public abstract void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void overrideConflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "fromSuper");
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor2, "fromCurrent");
        conflict(callableMemberDescriptor, callableMemberDescriptor2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void inheritanceConflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "first");
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor2, "second");
        conflict(callableMemberDescriptor, callableMemberDescriptor2);
    }
}
