package tb;

import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class z50 {

    /* compiled from: Taobao */
    private static class a extends ki {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull ClassDescriptor classDescriptor, @NotNull SourceElement sourceElement, boolean z) {
            super(classDescriptor, null, Annotations.Companion.b(), true, CallableMemberDescriptor.Kind.DECLARATION, sourceElement);
            if (classDescriptor == null) {
                a(0);
            }
            if (sourceElement == null) {
                a(1);
            }
            J(Collections.emptyList(), f60.k(classDescriptor, z));
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = "source";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 12 || i == 23 || i == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 12 || i == 23 || i == 25) ? 2 : 3)];
        switch (i) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
                objArr[0] = "owner";
                break;
        }
        if (i == 12) {
            objArr[1] = "createSetter";
        } else if (i == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 12 || i == 23 || i == 25) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static cv1 b(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations) {
        if (propertyDescriptor == null) {
            a(13);
        }
        if (annotations == null) {
            a(14);
        }
        return g(propertyDescriptor, annotations, true, false, false);
    }

    @NotNull
    public static dv1 c(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Annotations annotations2) {
        if (propertyDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (annotations2 == null) {
            a(2);
        }
        return j(propertyDescriptor, annotations, annotations2, true, false, false, propertyDescriptor.getSource());
    }

    @NotNull
    public static SimpleFunctionDescriptor d(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(24);
        }
        Annotations.a aVar = Annotations.Companion;
        fb2 F = fb2.F(classDescriptor, aVar.b(), c.ENUM_VALUE_OF, CallableMemberDescriptor.Kind.SYNTHESIZED, classDescriptor.getSource());
        fb2 H = F.l(null, null, Collections.emptyList(), Collections.singletonList(new ValueParameterDescriptorImpl(F, null, 0, aVar.b(), og1.f("value"), DescriptorUtilsKt.g(classDescriptor).V(), false, false, false, null, classDescriptor.getSource())), classDescriptor.getDefaultType(), Modality.FINAL, g60.PUBLIC);
        if (H == null) {
            a(25);
        }
        return H;
    }

    @NotNull
    public static SimpleFunctionDescriptor e(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(22);
        }
        fb2 H = fb2.F(classDescriptor, Annotations.Companion.b(), c.ENUM_VALUES, CallableMemberDescriptor.Kind.SYNTHESIZED, classDescriptor.getSource()).l(null, null, Collections.emptyList(), Collections.emptyList(), DescriptorUtilsKt.g(classDescriptor).l(Variance.INVARIANT, classDescriptor.getDefaultType()), Modality.FINAL, g60.PUBLIC);
        if (H == null) {
            a(23);
        }
        return H;
    }

    @Nullable
    public static ReceiverParameterDescriptor f(@NotNull CallableDescriptor callableDescriptor, @Nullable g61 g61, @NotNull Annotations annotations) {
        if (callableDescriptor == null) {
            a(29);
        }
        if (annotations == null) {
            a(30);
        }
        if (g61 == null) {
            return null;
        }
        return new lx1(callableDescriptor, new gg0(callableDescriptor, g61, null), annotations);
    }

    @NotNull
    public static cv1 g(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, boolean z, boolean z2, boolean z3) {
        if (propertyDescriptor == null) {
            a(15);
        }
        if (annotations == null) {
            a(16);
        }
        return h(propertyDescriptor, annotations, z, z2, z3, propertyDescriptor.getSource());
    }

    @NotNull
    public static cv1 h(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, boolean z, boolean z2, boolean z3, @NotNull SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            a(17);
        }
        if (annotations == null) {
            a(18);
        }
        if (sourceElement == null) {
            a(19);
        }
        return new cv1(propertyDescriptor, annotations, propertyDescriptor.getModality(), propertyDescriptor.getVisibility(), z, z2, z3, CallableMemberDescriptor.Kind.DECLARATION, null, sourceElement);
    }

    @NotNull
    public static ki i(@NotNull ClassDescriptor classDescriptor, @NotNull SourceElement sourceElement) {
        if (classDescriptor == null) {
            a(20);
        }
        if (sourceElement == null) {
            a(21);
        }
        return new a(classDescriptor, sourceElement, false);
    }

    @NotNull
    public static dv1 j(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Annotations annotations2, boolean z, boolean z2, boolean z3, @NotNull SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            a(3);
        }
        if (annotations == null) {
            a(4);
        }
        if (annotations2 == null) {
            a(5);
        }
        if (sourceElement == null) {
            a(6);
        }
        return k(propertyDescriptor, annotations, annotations2, z, z2, z3, propertyDescriptor.getVisibility(), sourceElement);
    }

    @NotNull
    public static dv1 k(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Annotations annotations2, boolean z, boolean z2, boolean z3, @NotNull h60 h60, @NotNull SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            a(7);
        }
        if (annotations == null) {
            a(8);
        }
        if (annotations2 == null) {
            a(9);
        }
        if (h60 == null) {
            a(10);
        }
        if (sourceElement == null) {
            a(11);
        }
        dv1 dv1 = new dv1(propertyDescriptor, annotations, propertyDescriptor.getModality(), h60, z, z2, z3, CallableMemberDescriptor.Kind.DECLARATION, null, sourceElement);
        dv1.l(dv1.j(dv1, propertyDescriptor.getType(), annotations2));
        return dv1;
    }

    private static boolean l(@NotNull FunctionDescriptor functionDescriptor) {
        if (functionDescriptor == null) {
            a(28);
        }
        return functionDescriptor.getKind() == CallableMemberDescriptor.Kind.SYNTHESIZED && f60.A(functionDescriptor.getContainingDeclaration());
    }

    public static boolean m(@NotNull FunctionDescriptor functionDescriptor) {
        if (functionDescriptor == null) {
            a(27);
        }
        return functionDescriptor.getName().equals(c.ENUM_VALUE_OF) && l(functionDescriptor);
    }

    public static boolean n(@NotNull FunctionDescriptor functionDescriptor) {
        if (functionDescriptor == null) {
            a(26);
        }
        return functionDescriptor.getName().equals(c.ENUM_VALUES) && l(functionDescriptor);
    }
}
