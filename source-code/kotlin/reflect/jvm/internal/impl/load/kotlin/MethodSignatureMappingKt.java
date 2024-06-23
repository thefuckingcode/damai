package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public final class MethodSignatureMappingKt {
    public static final String computeJvmDescriptor(FunctionDescriptor functionDescriptor, boolean z, boolean z2) {
        String str;
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "$this$computeJvmDescriptor");
        StringBuilder sb = new StringBuilder();
        if (z2) {
            if (functionDescriptor instanceof ConstructorDescriptor) {
                str = "<init>";
            } else {
                str = functionDescriptor.getName().asString();
                Intrinsics.checkExpressionValueIsNotNull(str, "name.asString()");
            }
            sb.append(str);
        }
        sb.append("(");
        for (ValueParameterDescriptor valueParameterDescriptor : functionDescriptor.getValueParameters()) {
            Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor, "parameter");
            KotlinType type = valueParameterDescriptor.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "parameter.type");
            appendErasedType(sb, type);
        }
        sb.append(")");
        if (z) {
            if (TypeSignatureMappingKt.hasVoidReturnType(functionDescriptor)) {
                sb.append("V");
            } else {
                KotlinType returnType = functionDescriptor.getReturnType();
                if (returnType == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(returnType, "returnType!!");
                appendErasedType(sb, returnType);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor functionDescriptor, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return computeJvmDescriptor(functionDescriptor, z, z2);
    }

    public static final boolean forceSingleValueParameterBoxing(CallableDescriptor callableDescriptor) {
        FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava;
        Intrinsics.checkParameterIsNotNull(callableDescriptor, "f");
        if (!(callableDescriptor instanceof FunctionDescriptor)) {
            return false;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
        if (functionDescriptor.getValueParameters().size() != 1 || SpecialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor) callableDescriptor) || (!Intrinsics.areEqual(functionDescriptor.getName().asString(), "remove"))) {
            return false;
        }
        FunctionDescriptor original = functionDescriptor.getOriginal();
        Intrinsics.checkExpressionValueIsNotNull(original, "f.original");
        List<ValueParameterDescriptor> valueParameters = original.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters, "f.original.valueParameters");
        Object single = CollectionsKt.single((List) valueParameters);
        Intrinsics.checkExpressionValueIsNotNull(single, "f.original.valueParameters.single()");
        KotlinType type = ((ValueParameterDescriptor) single).getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "f.original.valueParameters.single().type");
        JvmType mapToJvmType = mapToJvmType(type);
        JvmPrimitiveType jvmPrimitiveType = null;
        if (!(mapToJvmType instanceof JvmType.Primitive)) {
            mapToJvmType = null;
        }
        JvmType.Primitive primitive = (JvmType.Primitive) mapToJvmType;
        if (primitive != null) {
            jvmPrimitiveType = primitive.getJvmPrimitiveType();
        }
        if (jvmPrimitiveType != JvmPrimitiveType.INT || (overriddenBuiltinFunctionWithErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(functionDescriptor)) == null) {
            return false;
        }
        FunctionDescriptor original2 = overriddenBuiltinFunctionWithErasedValueParametersInJava.getOriginal();
        Intrinsics.checkExpressionValueIsNotNull(original2, "overridden.original");
        List<ValueParameterDescriptor> valueParameters2 = original2.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters2, "overridden.original.valueParameters");
        Object single2 = CollectionsKt.single((List) valueParameters2);
        Intrinsics.checkExpressionValueIsNotNull(single2, "overridden.original.valueParameters.single()");
        KotlinType type2 = ((ValueParameterDescriptor) single2).getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "overridden.original.valueParameters.single().type");
        JvmType mapToJvmType2 = mapToJvmType(type2);
        DeclarationDescriptor containingDeclaration = overriddenBuiltinFunctionWithErasedValueParametersInJava.getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "overridden.containingDeclaration");
        if (!Intrinsics.areEqual(DescriptorUtilsKt.getFqNameUnsafe(containingDeclaration), KotlinBuiltIns.FQ_NAMES.mutableCollection.toUnsafe()) || !(mapToJvmType2 instanceof JvmType.Object) || !Intrinsics.areEqual(((JvmType.Object) mapToJvmType2).getInternalName(), "java/lang/Object")) {
            return false;
        }
        return true;
    }

    public static final String getInternalName(ClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "$this$internalName");
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe unsafe = DescriptorUtilsKt.getFqNameSafe(classDescriptor).toUnsafe();
        Intrinsics.checkExpressionValueIsNotNull(unsafe, "fqNameSafe.toUnsafe()");
        ClassId mapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (mapKotlinToJava == null) {
            return TypeSignatureMappingKt.computeInternalName$default(classDescriptor, null, 2, null);
        }
        JvmClassName byClassId = JvmClassName.byClassId(mapKotlinToJava);
        Intrinsics.checkExpressionValueIsNotNull(byClassId, "JvmClassName.byClassId(it)");
        String internalName = byClassId.getInternalName();
        Intrinsics.checkExpressionValueIsNotNull(internalName, "JvmClassName.byClassId(it).internalName");
        return internalName;
    }

    private static final void appendErasedType(StringBuilder sb, KotlinType kotlinType) {
        sb.append(mapToJvmType(kotlinType));
    }

    public static final JvmType mapToJvmType(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$mapToJvmType");
        return (JvmType) TypeSignatureMappingKt.mapType$default(kotlinType, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
    }

    public static final String computeJvmSignature(CallableDescriptor callableDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableDescriptor, "$this$computeJvmSignature");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        if (DescriptorUtils.isLocal(callableDescriptor)) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            containingDeclaration = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        if (classDescriptor != null) {
            Name name = classDescriptor.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "classDescriptor.name");
            if (name.isSpecial()) {
                return null;
            }
            CallableDescriptor original = callableDescriptor.getOriginal();
            if (!(original instanceof SimpleFunctionDescriptor)) {
                original = null;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) original;
            if (simpleFunctionDescriptor != null) {
                return signatureBuildingComponents.signature(classDescriptor, computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null));
            }
        }
        return null;
    }
}
