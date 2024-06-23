package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class i60 {
    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1 || i == 2) {
            objArr[0] = "companionObject";
        } else if (i != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean b(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        FieldDescriptor backingField;
        if (callableMemberDescriptor == null) {
            a(3);
        }
        if (!(callableMemberDescriptor instanceof PropertyDescriptor) || (backingField = ((PropertyDescriptor) callableMemberDescriptor).getBackingField()) == null || !backingField.getAnnotations().hasAnnotation(t41.JVM_FIELD_ANNOTATION_FQ_NAME)) {
            return callableMemberDescriptor.getAnnotations().hasAnnotation(t41.JVM_FIELD_ANNOTATION_FQ_NAME);
        }
        return true;
    }

    public static boolean c(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(1);
        }
        return f60.x(declarationDescriptor) && f60.w(declarationDescriptor.getContainingDeclaration()) && !d((ClassDescriptor) declarationDescriptor);
    }

    public static boolean d(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(2);
        }
        return yk.a(xk.INSTANCE, classDescriptor);
    }

    public static boolean e(@NotNull PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor == null) {
            a(0);
        }
        if (propertyDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return false;
        }
        if (c(propertyDescriptor.getContainingDeclaration())) {
            return true;
        }
        if (!f60.x(propertyDescriptor.getContainingDeclaration()) || !b(propertyDescriptor)) {
            return false;
        }
        return true;
    }
}
