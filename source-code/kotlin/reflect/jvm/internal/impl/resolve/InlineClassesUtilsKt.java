package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: inlineClassesUtils.kt */
public final class InlineClassesUtilsKt {
    public static final ValueParameterDescriptor underlyingRepresentation(ClassDescriptor classDescriptor) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        List<ValueParameterDescriptor> valueParameters;
        Intrinsics.checkParameterIsNotNull(classDescriptor, "$this$underlyingRepresentation");
        if (!classDescriptor.isInline() || (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) == null || (valueParameters = unsubstitutedPrimaryConstructor.getValueParameters()) == null) {
            return null;
        }
        return (ValueParameterDescriptor) CollectionsKt.singleOrNull((List) valueParameters);
    }

    public static final boolean isInlineClass(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkParameterIsNotNull(declarationDescriptor, "$this$isInlineClass");
        return (declarationDescriptor instanceof ClassDescriptor) && ((ClassDescriptor) declarationDescriptor).isInline();
    }

    public static final ValueParameterDescriptor unsubstitutedUnderlyingParameter(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$unsubstitutedUnderlyingParameter");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (classDescriptor != null) {
            return underlyingRepresentation(classDescriptor);
        }
        return null;
    }

    public static final boolean isInlineClassType(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$isInlineClassType");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor != null) {
            return isInlineClass(declarationDescriptor);
        }
        return false;
    }

    public static final KotlinType substitutedUnderlyingType(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$substitutedUnderlyingType");
        ValueParameterDescriptor unsubstitutedUnderlyingParameter = unsubstitutedUnderlyingParameter(kotlinType);
        if (unsubstitutedUnderlyingParameter == null) {
            return null;
        }
        MemberScope memberScope = kotlinType.getMemberScope();
        Name name = unsubstitutedUnderlyingParameter.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "parameter.name");
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) CollectionsKt.singleOrNull(memberScope.getContributedVariables(name, NoLookupLocation.FOR_ALREADY_TRACKED));
        if (propertyDescriptor != null) {
            return propertyDescriptor.getType();
        }
        return null;
    }

    public static final boolean isGetterOfUnderlyingPropertyOfInlineClass(CallableDescriptor callableDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableDescriptor, "$this$isGetterOfUnderlyingPropertyOfInlineClass");
        if (callableDescriptor instanceof PropertyGetterDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyGetterDescriptor) callableDescriptor).getCorrespondingProperty();
            Intrinsics.checkExpressionValueIsNotNull(correspondingProperty, "correspondingProperty");
            if (isUnderlyingPropertyOfInlineClass(correspondingProperty)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(VariableDescriptor variableDescriptor) {
        Intrinsics.checkParameterIsNotNull(variableDescriptor, "$this$isUnderlyingPropertyOfInlineClass");
        DeclarationDescriptor containingDeclaration = variableDescriptor.getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "this.containingDeclaration");
        if (!isInlineClass(containingDeclaration)) {
            return false;
        }
        if (containingDeclaration != null) {
            ValueParameterDescriptor underlyingRepresentation = underlyingRepresentation((ClassDescriptor) containingDeclaration);
            return Intrinsics.areEqual(underlyingRepresentation != null ? underlyingRepresentation.getName() : null, variableDescriptor.getName());
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }
}
