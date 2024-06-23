package kotlin.reflect.jvm.internal.impl.load.java;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;

public final class JvmAbi {
    public static final FqName JVM_FIELD_ANNOTATION_FQ_NAME = new FqName("kotlin.jvm.JvmField");
    public static final ClassId REFLECTION_FACTORY_IMPL = ClassId.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 1 || i == 3 || i == 7 || i == 9) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 3 || i == 7 || i == 9) ? 2 : 3)];
        switch (i) {
            case 1:
            case 3:
            case 7:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi";
                break;
            case 2:
                objArr[0] = "typeAliasName";
                break;
            case 4:
            case 5:
                objArr[0] = SerializableCookie.NAME;
                break;
            case 6:
            case 8:
                objArr[0] = "propertyName";
                break;
            case 10:
                objArr[0] = "propertyDescriptor";
                break;
            case 11:
            case 12:
                objArr[0] = "companionObject";
                break;
            case 13:
                objArr[0] = "memberDescriptor";
                break;
            default:
                objArr[0] = "baseName";
                break;
        }
        if (i == 1) {
            objArr[1] = "getSyntheticMethodNameForAnnotatedProperty";
        } else if (i == 3) {
            objArr[1] = "getSyntheticMethodNameForAnnotatedTypeAlias";
        } else if (i == 7) {
            objArr[1] = "getterName";
        } else if (i != 9) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi";
        } else {
            objArr[1] = "setterName";
        }
        switch (i) {
            case 1:
            case 3:
            case 7:
            case 9:
                break;
            case 2:
                objArr[2] = "getSyntheticMethodNameForAnnotatedTypeAlias";
                break;
            case 4:
                objArr[2] = "isGetterName";
                break;
            case 5:
                objArr[2] = "isSetterName";
                break;
            case 6:
                objArr[2] = "getterName";
                break;
            case 8:
                objArr[2] = "setterName";
                break;
            case 10:
                objArr[2] = "isPropertyWithBackingFieldInOuterClass";
                break;
            case 11:
                objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
                break;
            case 12:
                objArr[2] = "isMappedIntrinsicCompanionObject";
                break;
            case 13:
                objArr[2] = "hasJvmFieldAnnotation";
                break;
            default:
                objArr[2] = "getSyntheticMethodNameForAnnotatedProperty";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 1 || i == 3 || i == 7 || i == 9) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    public static boolean isGetterName(String str) {
        if (str == null) {
            $$$reportNull$$$0(4);
        }
        return str.startsWith("get") || str.startsWith("is");
    }

    public static boolean isSetterName(String str) {
        if (str == null) {
            $$$reportNull$$$0(5);
        }
        return str.startsWith("set");
    }

    public static String getterName(String str) {
        if (str == null) {
            $$$reportNull$$$0(6);
        }
        if (!startsWithIsPrefix(str)) {
            str = "get" + CapitalizeDecapitalizeKt.capitalizeAsciiOnly(str);
        }
        if (str == null) {
            $$$reportNull$$$0(7);
        }
        return str;
    }

    public static String setterName(String str) {
        if (str == null) {
            $$$reportNull$$$0(8);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("set");
        sb.append(startsWithIsPrefix(str) ? str.substring(2) : CapitalizeDecapitalizeKt.capitalizeAsciiOnly(str));
        String sb2 = sb.toString();
        if (sb2 == null) {
            $$$reportNull$$$0(9);
        }
        return sb2;
    }

    public static boolean startsWithIsPrefix(String str) {
        if (!str.startsWith("is") || str.length() == 2) {
            return false;
        }
        char charAt = str.charAt(2);
        if ('a' > charAt || charAt > 'z') {
            return true;
        }
        return false;
    }

    public static boolean isPropertyWithBackingFieldInOuterClass(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(10);
        }
        if (propertyDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return false;
        }
        if (isClassCompanionObjectWithBackingFieldsInOuter(propertyDescriptor.getContainingDeclaration())) {
            return true;
        }
        if (!DescriptorUtils.isCompanionObject(propertyDescriptor.getContainingDeclaration()) || !hasJvmFieldAnnotation(propertyDescriptor)) {
            return false;
        }
        return true;
    }

    public static boolean isClassCompanionObjectWithBackingFieldsInOuter(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(11);
        }
        return DescriptorUtils.isCompanionObject(declarationDescriptor) && DescriptorUtils.isClassOrEnumClass(declarationDescriptor.getContainingDeclaration()) && !isMappedIntrinsicCompanionObject((ClassDescriptor) declarationDescriptor);
    }

    public static boolean isMappedIntrinsicCompanionObject(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(12);
        }
        return CompanionObjectMapping.INSTANCE.isMappedIntrinsicCompanionObject(classDescriptor);
    }

    public static boolean hasJvmFieldAnnotation(CallableMemberDescriptor callableMemberDescriptor) {
        FieldDescriptor backingField;
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(13);
        }
        if (!(callableMemberDescriptor instanceof PropertyDescriptor) || (backingField = ((PropertyDescriptor) callableMemberDescriptor).getBackingField()) == null || !backingField.getAnnotations().hasAnnotation(JVM_FIELD_ANNOTATION_FQ_NAME)) {
            return callableMemberDescriptor.getAnnotations().hasAnnotation(JVM_FIELD_ANNOTATION_FQ_NAME);
        }
        return true;
    }
}
