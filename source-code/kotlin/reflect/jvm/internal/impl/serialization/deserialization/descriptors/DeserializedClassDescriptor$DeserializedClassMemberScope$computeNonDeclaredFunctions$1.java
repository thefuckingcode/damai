package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* compiled from: DeserializedClassDescriptor.kt */
final class DeserializedClassDescriptor$DeserializedClassMemberScope$computeNonDeclaredFunctions$1 extends Lambda implements Function1<SimpleFunctionDescriptor, Boolean> {
    final /* synthetic */ DeserializedClassDescriptor.DeserializedClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$DeserializedClassMemberScope$computeNonDeclaredFunctions$1(DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
        super(1);
        this.this$0 = deserializedClassMemberScope;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        return Boolean.valueOf(invoke(simpleFunctionDescriptor));
    }

    public final boolean invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkParameterIsNotNull(simpleFunctionDescriptor, "it");
        return this.this$0.getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.this$0.this$0, simpleFunctionDescriptor);
    }
}
