package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$getConstructors$1 extends Lambda implements Function2<ConstructorDescriptor, ConstructorDescriptor, Boolean> {
    final /* synthetic */ TypeSubstitutor $substitutor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsSettings$getConstructors$1(TypeSubstitutor typeSubstitutor) {
        super(2);
        this.$substitutor = typeSubstitutor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(ConstructorDescriptor constructorDescriptor, ConstructorDescriptor constructorDescriptor2) {
        return Boolean.valueOf(invoke(constructorDescriptor, constructorDescriptor2));
    }

    public final boolean invoke(ConstructorDescriptor constructorDescriptor, ConstructorDescriptor constructorDescriptor2) {
        Intrinsics.checkParameterIsNotNull(constructorDescriptor, "$this$isEffectivelyTheSameAs");
        Intrinsics.checkParameterIsNotNull(constructorDescriptor2, "javaConstructor");
        return OverridingUtil.getBothWaysOverridability(constructorDescriptor, constructorDescriptor2.substitute(this.$substitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }
}
