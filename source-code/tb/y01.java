package tb;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class y01 {
    private static final boolean a(ClassDescriptor classDescriptor) {
        return k21.d(DescriptorUtilsKt.i(classDescriptor), c.RESULT_FQ_NAME);
    }

    public static final boolean b(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "<this>");
        return z01.b(declarationDescriptor) && !a((ClassDescriptor) declarationDescriptor);
    }

    public static final boolean c(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        return k21.d(declarationDescriptor == null ? null : Boolean.valueOf(b(declarationDescriptor)), Boolean.TRUE);
    }

    private static final boolean d(g61 g61) {
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return false;
        }
        return e(TypeUtilsKt.f(typeParameterDescriptor));
    }

    private static final boolean e(g61 g61) {
        return c(g61) || d(g61);
    }

    public static final boolean f(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, "descriptor");
        ClassConstructorDescriptor classConstructorDescriptor = callableMemberDescriptor instanceof ClassConstructorDescriptor ? (ClassConstructorDescriptor) callableMemberDescriptor : null;
        if (classConstructorDescriptor == null || g60.g(classConstructorDescriptor.getVisibility())) {
            return false;
        }
        ClassDescriptor constructedClass = classConstructorDescriptor.getConstructedClass();
        k21.h(constructedClass, "constructorDescriptor.constructedClass");
        if (z01.b(constructedClass) || f60.G(classConstructorDescriptor.getConstructedClass())) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
        k21.h(valueParameters, "constructorDescriptor.valueParameters");
        if ((valueParameters instanceof Collection) && valueParameters.isEmpty()) {
            return false;
        }
        Iterator<T> it = valueParameters.iterator();
        while (it.hasNext()) {
            g61 type = it.next().getType();
            k21.h(type, "it.type");
            if (e(type)) {
                return true;
            }
        }
        return false;
    }
}
