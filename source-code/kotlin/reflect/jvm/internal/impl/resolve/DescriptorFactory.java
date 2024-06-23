package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public class DescriptorFactory {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
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

    /* access modifiers changed from: private */
    public static class DefaultClassConstructorDescriptor extends ClassConstructorDescriptorImpl {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
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

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DefaultClassConstructorDescriptor(ClassDescriptor classDescriptor, SourceElement sourceElement) {
            super(classDescriptor, null, Annotations.Companion.getEMPTY(), true, CallableMemberDescriptor.Kind.DECLARATION, sourceElement);
            if (classDescriptor == null) {
                $$$reportNull$$$0(0);
            }
            if (sourceElement == null) {
                $$$reportNull$$$0(1);
            }
            initialize(Collections.emptyList(), DescriptorUtils.getDefaultConstructorVisibility(classDescriptor));
        }
    }

    public static PropertySetterDescriptorImpl createDefaultSetter(PropertyDescriptor propertyDescriptor, Annotations annotations, Annotations annotations2) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (annotations2 == null) {
            $$$reportNull$$$0(2);
        }
        return createSetter(propertyDescriptor, annotations, annotations2, true, false, false, propertyDescriptor.getSource());
    }

    public static PropertySetterDescriptorImpl createSetter(PropertyDescriptor propertyDescriptor, Annotations annotations, Annotations annotations2, boolean z, boolean z2, boolean z3, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(3);
        }
        if (annotations == null) {
            $$$reportNull$$$0(4);
        }
        if (annotations2 == null) {
            $$$reportNull$$$0(5);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(6);
        }
        return createSetter(propertyDescriptor, annotations, annotations2, z, z2, z3, propertyDescriptor.getVisibility(), sourceElement);
    }

    public static PropertySetterDescriptorImpl createSetter(PropertyDescriptor propertyDescriptor, Annotations annotations, Annotations annotations2, boolean z, boolean z2, boolean z3, Visibility visibility, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(7);
        }
        if (annotations == null) {
            $$$reportNull$$$0(8);
        }
        if (annotations2 == null) {
            $$$reportNull$$$0(9);
        }
        if (visibility == null) {
            $$$reportNull$$$0(10);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(11);
        }
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(propertyDescriptor, annotations, propertyDescriptor.getModality(), visibility, z, z2, z3, CallableMemberDescriptor.Kind.DECLARATION, null, sourceElement);
        propertySetterDescriptorImpl.initialize(PropertySetterDescriptorImpl.createSetterParameter(propertySetterDescriptorImpl, propertyDescriptor.getType(), annotations2));
        return propertySetterDescriptorImpl;
    }

    public static PropertyGetterDescriptorImpl createDefaultGetter(PropertyDescriptor propertyDescriptor, Annotations annotations) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(13);
        }
        if (annotations == null) {
            $$$reportNull$$$0(14);
        }
        return createGetter(propertyDescriptor, annotations, true, false, false);
    }

    public static PropertyGetterDescriptorImpl createGetter(PropertyDescriptor propertyDescriptor, Annotations annotations, boolean z, boolean z2, boolean z3) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(15);
        }
        if (annotations == null) {
            $$$reportNull$$$0(16);
        }
        return createGetter(propertyDescriptor, annotations, z, z2, z3, propertyDescriptor.getSource());
    }

    public static PropertyGetterDescriptorImpl createGetter(PropertyDescriptor propertyDescriptor, Annotations annotations, boolean z, boolean z2, boolean z3, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(17);
        }
        if (annotations == null) {
            $$$reportNull$$$0(18);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(19);
        }
        return new PropertyGetterDescriptorImpl(propertyDescriptor, annotations, propertyDescriptor.getModality(), propertyDescriptor.getVisibility(), z, z2, z3, CallableMemberDescriptor.Kind.DECLARATION, null, sourceElement);
    }

    public static ClassConstructorDescriptorImpl createPrimaryConstructorForObject(ClassDescriptor classDescriptor, SourceElement sourceElement) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(20);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(21);
        }
        return new DefaultClassConstructorDescriptor(classDescriptor, sourceElement);
    }

    public static SimpleFunctionDescriptor createEnumValuesMethod(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(22);
        }
        SimpleFunctionDescriptorImpl initialize = SimpleFunctionDescriptorImpl.create(classDescriptor, Annotations.Companion.getEMPTY(), DescriptorUtils.ENUM_VALUES, CallableMemberDescriptor.Kind.SYNTHESIZED, classDescriptor.getSource()).initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.emptyList(), (KotlinType) DescriptorUtilsKt.getBuiltIns(classDescriptor).getArrayType(Variance.INVARIANT, classDescriptor.getDefaultType()), Modality.FINAL, Visibilities.PUBLIC);
        if (initialize == null) {
            $$$reportNull$$$0(23);
        }
        return initialize;
    }

    public static SimpleFunctionDescriptor createEnumValueOfMethod(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(24);
        }
        SimpleFunctionDescriptorImpl create = SimpleFunctionDescriptorImpl.create(classDescriptor, Annotations.Companion.getEMPTY(), DescriptorUtils.ENUM_VALUE_OF, CallableMemberDescriptor.Kind.SYNTHESIZED, classDescriptor.getSource());
        SimpleFunctionDescriptorImpl initialize = create.initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.singletonList(new ValueParameterDescriptorImpl(create, null, 0, Annotations.Companion.getEMPTY(), Name.identifier("value"), DescriptorUtilsKt.getBuiltIns(classDescriptor).getStringType(), false, false, false, null, classDescriptor.getSource())), (KotlinType) classDescriptor.getDefaultType(), Modality.FINAL, Visibilities.PUBLIC);
        if (initialize == null) {
            $$$reportNull$$$0(25);
        }
        return initialize;
    }

    public static boolean isEnumValuesMethod(FunctionDescriptor functionDescriptor) {
        if (functionDescriptor == null) {
            $$$reportNull$$$0(26);
        }
        return functionDescriptor.getName().equals(DescriptorUtils.ENUM_VALUES) && isEnumSpecialMethod(functionDescriptor);
    }

    public static boolean isEnumValueOfMethod(FunctionDescriptor functionDescriptor) {
        if (functionDescriptor == null) {
            $$$reportNull$$$0(27);
        }
        return functionDescriptor.getName().equals(DescriptorUtils.ENUM_VALUE_OF) && isEnumSpecialMethod(functionDescriptor);
    }

    private static boolean isEnumSpecialMethod(FunctionDescriptor functionDescriptor) {
        if (functionDescriptor == null) {
            $$$reportNull$$$0(28);
        }
        return functionDescriptor.getKind() == CallableMemberDescriptor.Kind.SYNTHESIZED && DescriptorUtils.isEnumClass(functionDescriptor.getContainingDeclaration());
    }

    public static ReceiverParameterDescriptor createExtensionReceiverParameterForCallable(CallableDescriptor callableDescriptor, KotlinType kotlinType, Annotations annotations) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(29);
        }
        if (annotations == null) {
            $$$reportNull$$$0(30);
        }
        if (kotlinType == null) {
            return null;
        }
        return new ReceiverParameterDescriptorImpl(callableDescriptor, new ExtensionReceiver(callableDescriptor, kotlinType, null), annotations);
    }
}
