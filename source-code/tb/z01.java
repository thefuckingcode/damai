package tb;

import java.util.List;
import kotlin.collections.k;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class z01 {
    static {
        new en0("kotlin.jvm.JvmInline");
    }

    public static final boolean a(@NotNull CallableDescriptor callableDescriptor) {
        k21.i(callableDescriptor, "<this>");
        if (callableDescriptor instanceof PropertyGetterDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyGetterDescriptor) callableDescriptor).getCorrespondingProperty();
            k21.h(correspondingProperty, "correspondingProperty");
            if (d(correspondingProperty)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "<this>");
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor.isInline() || classDescriptor.isValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        return b(declarationDescriptor);
    }

    public static final boolean d(@NotNull VariableDescriptor variableDescriptor) {
        k21.i(variableDescriptor, "<this>");
        if (variableDescriptor.getExtensionReceiverParameter() != null) {
            return false;
        }
        DeclarationDescriptor containingDeclaration = variableDescriptor.getContainingDeclaration();
        k21.h(containingDeclaration, "this.containingDeclaration");
        if (!b(containingDeclaration)) {
            return false;
        }
        ValueParameterDescriptor f = f((ClassDescriptor) containingDeclaration);
        return k21.d(f == null ? null : f.getName(), variableDescriptor.getName());
    }

    @Nullable
    public static final g61 e(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        ValueParameterDescriptor g = g(g61);
        if (g == null) {
            return null;
        }
        return TypeSubstitutor.f(g61).q(g.getType(), Variance.INVARIANT);
    }

    @Nullable
    public static final ValueParameterDescriptor f(@NotNull ClassDescriptor classDescriptor) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        List<ValueParameterDescriptor> valueParameters;
        k21.i(classDescriptor, "<this>");
        if (!b(classDescriptor) || (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) == null || (valueParameters = unsubstitutedPrimaryConstructor.getValueParameters()) == null) {
            return null;
        }
        return (ValueParameterDescriptor) k.q0(valueParameters);
    }

    @Nullable
    public static final ValueParameterDescriptor g(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (classDescriptor == null) {
            return null;
        }
        return f(classDescriptor);
    }
}
