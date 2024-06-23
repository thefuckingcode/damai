package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

public final class InlineClassAwareCallerKt {
    public static /* synthetic */ Caller createInlineClassAwareCallerIfNeeded$default(Caller caller, CallableMemberDescriptor callableMemberDescriptor, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return createInlineClassAwareCallerIfNeeded(caller, callableMemberDescriptor, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.reflect.jvm.internal.calls.Caller<? extends M extends java.lang.reflect.Member> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClassType(r0) != true) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        if (hasInlineClassReceiver(r6) == false) goto L_0x006d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    public static final <M extends Member> Caller<M> createInlineClassAwareCallerIfNeeded(Caller<? extends M> caller, CallableMemberDescriptor callableMemberDescriptor, boolean z) {
        boolean z2;
        Intrinsics.checkParameterIsNotNull(caller, "$this$createInlineClassAwareCallerIfNeeded");
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "descriptor");
        boolean z3 = false;
        if (!InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(callableMemberDescriptor)) {
            List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(valueParameters, "descriptor.valueParameters");
            List<ValueParameterDescriptor> list = valueParameters;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    Intrinsics.checkExpressionValueIsNotNull(next, "it");
                    KotlinType type = next.getType();
                    Intrinsics.checkExpressionValueIsNotNull(type, "it.type");
                    if (InlineClassesUtilsKt.isInlineClassType(type)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                KotlinType returnType = callableMemberDescriptor.getReturnType();
                if (returnType != null) {
                }
                if (!(caller instanceof BoundCaller)) {
                }
                return !z3 ? new InlineClassAwareCaller(callableMemberDescriptor, caller, z) : caller;
            }
        }
        z3 = true;
        if (!z3) {
        }
    }

    private static final boolean hasInlineClassReceiver(CallableMemberDescriptor callableMemberDescriptor) {
        KotlinType expectedReceiverType = getExpectedReceiverType(callableMemberDescriptor);
        return expectedReceiverType != null && InlineClassesUtilsKt.isInlineClassType(expectedReceiverType);
    }

    public static final Method getUnboxMethod(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(cls, "$this$getUnboxMethod");
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    public static final Method getBoxMethod(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(cls, "$this$getBoxMethod");
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", getUnboxMethod(cls, callableMemberDescriptor).getReturnType());
            Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    public static final Class<?> toInlineClass(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$toInlineClass");
        return toInlineClass(kotlinType.getConstructor().getDeclarationDescriptor());
    }

    public static final Class<?> toInlineClass(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor.isInline()) {
                Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
                if (javaClass != null) {
                    return javaClass;
                }
                throw new KotlinReflectionInternalError("Class object for the class " + classDescriptor.getName() + " cannot be found (classId=" + DescriptorUtilsKt.getClassId((ClassifierDescriptor) declarationDescriptor) + ')');
            }
        }
        return null;
    }

    private static final KotlinType getExpectedReceiverType(CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiverParameter = callableMemberDescriptor.getDispatchReceiverParameter();
        SimpleType simpleType = null;
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        if (dispatchReceiverParameter == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof ConstructorDescriptor) {
            return dispatchReceiverParameter.getType();
        }
        DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            containingDeclaration = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        if (classDescriptor != null) {
            simpleType = classDescriptor.getDefaultType();
        }
        return simpleType;
    }

    public static final Object coerceToExpectedReceiverType(Object obj, CallableMemberDescriptor callableMemberDescriptor) {
        KotlinType expectedReceiverType;
        Class<?> inlineClass;
        Method unboxMethod;
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "descriptor");
        return (((callableMemberDescriptor instanceof PropertyDescriptor) && InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((VariableDescriptor) callableMemberDescriptor)) || (expectedReceiverType = getExpectedReceiverType(callableMemberDescriptor)) == null || (inlineClass = toInlineClass(expectedReceiverType)) == null || (unboxMethod = getUnboxMethod(inlineClass, callableMemberDescriptor)) == null) ? obj : unboxMethod.invoke(obj, new Object[0]);
    }
}
