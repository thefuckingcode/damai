package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.calls.BoundCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

public final class x01 {
    public static final Object a(Object obj, CallableMemberDescriptor callableMemberDescriptor) {
        g61 e;
        Class<?> i;
        Method f;
        k21.i(callableMemberDescriptor, "descriptor");
        return (((callableMemberDescriptor instanceof PropertyDescriptor) && z01.d((VariableDescriptor) callableMemberDescriptor)) || (e = e(callableMemberDescriptor)) == null || (i = i(e)) == null || (f = f(i, callableMemberDescriptor)) == null) ? obj : f.invoke(obj, new Object[0]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.reflect.jvm.internal.calls.Caller<? extends M extends java.lang.reflect.Member> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        if (tb.z01.c(r0) != true) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
        if (g(r6) == false) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    public static final <M extends Member> Caller<M> b(Caller<? extends M> caller, CallableMemberDescriptor callableMemberDescriptor, boolean z) {
        boolean z2;
        k21.i(caller, "$this$createInlineClassAwareCallerIfNeeded");
        k21.i(callableMemberDescriptor, "descriptor");
        boolean z3 = false;
        if (!z01.a(callableMemberDescriptor)) {
            List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
            k21.h(valueParameters, "descriptor.valueParameters");
            if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
                Iterator<T> it = valueParameters.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    k21.h(next, AdvanceSetting.NETWORK_TYPE);
                    g61 type = next.getType();
                    k21.h(type, "it.type");
                    if (z01.c(type)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                g61 returnType = callableMemberDescriptor.getReturnType();
                if (returnType != null) {
                }
                if (!(caller instanceof BoundCaller)) {
                }
                return !z3 ? new w01(callableMemberDescriptor, caller, z) : caller;
            }
        }
        z3 = true;
        if (!z3) {
        }
    }

    public static /* synthetic */ Caller c(Caller caller, CallableMemberDescriptor callableMemberDescriptor, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return b(caller, callableMemberDescriptor, z);
    }

    public static final Method d(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(cls, "$this$getBoxMethod");
        k21.i(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", f(cls, callableMemberDescriptor).getReturnType());
            k21.h(declaredMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    private static final g61 e(CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiverParameter = callableMemberDescriptor.getDispatchReceiverParameter();
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
            return classDescriptor.getDefaultType();
        }
        return null;
    }

    public static final Method f(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(cls, "$this$getUnboxMethod");
        k21.i(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            k21.h(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    private static final boolean g(CallableMemberDescriptor callableMemberDescriptor) {
        g61 e = e(callableMemberDescriptor);
        return e != null && z01.c(e);
    }

    public static final Class<?> h(DeclarationDescriptor declarationDescriptor) {
        if (!(declarationDescriptor instanceof ClassDescriptor) || !z01.b(declarationDescriptor)) {
            return null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        Class<?> n = wt2.n(classDescriptor);
        if (n != null) {
            return n;
        }
        throw new KotlinReflectionInternalError("Class object for the class " + classDescriptor.getName() + " cannot be found (classId=" + DescriptorUtilsKt.h((ClassifierDescriptor) declarationDescriptor) + ')');
    }

    public static final Class<?> i(g61 g61) {
        k21.i(g61, "$this$toInlineClass");
        return h(g61.c().getDeclarationDescriptor());
    }
}
