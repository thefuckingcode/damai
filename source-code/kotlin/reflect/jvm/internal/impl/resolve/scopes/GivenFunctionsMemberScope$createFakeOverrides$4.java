package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* compiled from: GivenFunctionsMemberScope.kt */
public final class GivenFunctionsMemberScope$createFakeOverrides$4 extends NonReportingOverrideStrategy {
    final /* synthetic */ ArrayList $result;
    final /* synthetic */ GivenFunctionsMemberScope this$0;

    GivenFunctionsMemberScope$createFakeOverrides$4(GivenFunctionsMemberScope givenFunctionsMemberScope, ArrayList arrayList) {
        this.this$0 = givenFunctionsMemberScope;
        this.$result = arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "fakeOverride");
        OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
        this.$result.add(callableMemberDescriptor);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
    public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "fromSuper");
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor2, "fromCurrent");
        throw new IllegalStateException(("Conflict in scope of " + this.this$0.getContainingClass() + ": " + callableMemberDescriptor + " vs " + callableMemberDescriptor2).toString());
    }
}
