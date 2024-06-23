package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    public static final Companion Companion = new Companion(null);

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableDescriptor, "superDescriptor");
        Intrinsics.checkParameterIsNotNull(callableDescriptor2, "subDescriptor");
        if (isIncompatibleInAccordanceWithBuiltInOverridabilityRules(callableDescriptor, callableDescriptor2, classDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor, callableDescriptor2)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if ((callableDescriptor instanceof CallableMemberDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && !KotlinBuiltIns.isBuiltIn(callableDescriptor2)) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
            FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor2;
            Name name = functionDescriptor.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "subDescriptor.name");
            if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
                BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.INSTANCE;
                Name name2 = functionDescriptor.getName();
                Intrinsics.checkExpressionValueIsNotNull(name2, "subDescriptor.name");
                if (!builtinMethodsWithDifferentJvmName.getSameAsRenamedInJvmBuiltin(name2)) {
                    return false;
                }
            }
            CallableMemberDescriptor overriddenSpecialBuiltin = SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor) callableDescriptor);
            boolean isHiddenToOvercomeSignatureClash = functionDescriptor.isHiddenToOvercomeSignatureClash();
            boolean z = callableDescriptor instanceof FunctionDescriptor;
            FunctionDescriptor functionDescriptor2 = (FunctionDescriptor) (!z ? null : callableDescriptor);
            if ((functionDescriptor2 == null || isHiddenToOvercomeSignatureClash != functionDescriptor2.isHiddenToOvercomeSignatureClash()) && (overriddenSpecialBuiltin == null || !functionDescriptor.isHiddenToOvercomeSignatureClash())) {
                return true;
            }
            if ((classDescriptor instanceof JavaClassDescriptor) && functionDescriptor.getInitialSignatureDescriptor() == null && overriddenSpecialBuiltin != null && !SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(classDescriptor, overriddenSpecialBuiltin)) {
                if ((overriddenSpecialBuiltin instanceof FunctionDescriptor) && z && BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor) overriddenSpecialBuiltin) != null) {
                    String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 2, null);
                    FunctionDescriptor original = ((FunctionDescriptor) callableDescriptor).getOriginal();
                    Intrinsics.checkExpressionValueIsNotNull(original, "superDescriptor.original");
                    if (Intrinsics.areEqual(computeJvmDescriptor$default, MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    /* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
            Intrinsics.checkParameterIsNotNull(callableDescriptor, "superDescriptor");
            Intrinsics.checkParameterIsNotNull(callableDescriptor2, "subDescriptor");
            if ((callableDescriptor2 instanceof JavaMethodDescriptor) && (callableDescriptor instanceof FunctionDescriptor)) {
                JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
                javaMethodDescriptor.getValueParameters().size();
                FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
                functionDescriptor.getValueParameters().size();
                SimpleFunctionDescriptor original = javaMethodDescriptor.getOriginal();
                Intrinsics.checkExpressionValueIsNotNull(original, "subDescriptor.original");
                List<ValueParameterDescriptor> valueParameters = original.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters, "subDescriptor.original.valueParameters");
                FunctionDescriptor original2 = functionDescriptor.getOriginal();
                Intrinsics.checkExpressionValueIsNotNull(original2, "superDescriptor.original");
                List<ValueParameterDescriptor> valueParameters2 = original2.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters2, "superDescriptor.original.valueParameters");
                for (Pair pair : CollectionsKt.zip(valueParameters, valueParameters2)) {
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.component1();
                    ValueParameterDescriptor valueParameterDescriptor2 = (ValueParameterDescriptor) pair.component2();
                    Companion companion = this;
                    Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor, "subParameter");
                    boolean z = companion.mapValueParameterType((FunctionDescriptor) callableDescriptor2, valueParameterDescriptor) instanceof JvmType.Primitive;
                    Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor2, "superParameter");
                    if (z != (companion.mapValueParameterType(functionDescriptor, valueParameterDescriptor2) instanceof JvmType.Primitive)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private final JvmType mapValueParameterType(FunctionDescriptor functionDescriptor, ValueParameterDescriptor valueParameterDescriptor) {
            if (MethodSignatureMappingKt.forceSingleValueParameterBoxing(functionDescriptor) || isPrimitiveCompareTo(functionDescriptor)) {
                KotlinType type = valueParameterDescriptor.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "valueParameterDescriptor.type");
                return MethodSignatureMappingKt.mapToJvmType(TypeUtilsKt.makeNullable(type));
            }
            KotlinType type2 = valueParameterDescriptor.getType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "valueParameterDescriptor.type");
            return MethodSignatureMappingKt.mapToJvmType(type2);
        }

        private final boolean isPrimitiveCompareTo(FunctionDescriptor functionDescriptor) {
            if (functionDescriptor.getValueParameters().size() != 1) {
                return false;
            }
            DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            ClassDescriptor classDescriptor = null;
            if (!(containingDeclaration instanceof ClassDescriptor)) {
                containingDeclaration = null;
            }
            ClassDescriptor classDescriptor2 = (ClassDescriptor) containingDeclaration;
            if (classDescriptor2 != null) {
                List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters, "f.valueParameters");
                Object single = CollectionsKt.single((List) valueParameters);
                Intrinsics.checkExpressionValueIsNotNull(single, "f.valueParameters.single()");
                ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) single).getType().getConstructor().getDeclarationDescriptor();
                if (declarationDescriptor instanceof ClassDescriptor) {
                    classDescriptor = declarationDescriptor;
                }
                ClassDescriptor classDescriptor3 = classDescriptor;
                if (classDescriptor3 == null || !KotlinBuiltIns.isPrimitiveClass(classDescriptor2) || !Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(classDescriptor2), DescriptorUtilsKt.getFqNameSafe(classDescriptor3))) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }
}
