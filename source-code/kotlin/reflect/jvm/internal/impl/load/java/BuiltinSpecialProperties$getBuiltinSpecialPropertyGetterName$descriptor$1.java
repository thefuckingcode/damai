package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: specialBuiltinMembers.kt */
public final class BuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public static final BuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1 INSTANCE = new BuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1();

    BuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke(callableMemberDescriptor));
    }

    public final boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "it");
        return BuiltinSpecialProperties.INSTANCE.hasBuiltinSpecialPropertyFqName(callableMemberDescriptor);
    }
}
