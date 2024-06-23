package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmName;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f60;
import tb.ib2;
import tb.io2;
import tb.k21;
import tb.nd;
import tb.og1;

@JvmName(name = "SpecialBuiltinMembers")
/* compiled from: Taobao */
public final class SpecialBuiltinMembers {
    public static final boolean a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, "<this>");
        return d(callableMemberDescriptor) != null;
    }

    @Nullable
    public static final String b(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        og1 j;
        k21.i(callableMemberDescriptor, "callableMemberDescriptor");
        CallableMemberDescriptor c = c(callableMemberDescriptor);
        CallableMemberDescriptor o = c == null ? null : DescriptorUtilsKt.o(c);
        if (o == null) {
            return null;
        }
        if (o instanceof PropertyDescriptor) {
            return ClassicBuiltinSpecialProperties.INSTANCE.a(o);
        }
        if (!(o instanceof SimpleFunctionDescriptor) || (j = BuiltinMethodsWithDifferentJvmName.INSTANCE.j((SimpleFunctionDescriptor) o)) == null) {
            return null;
        }
        return j.b();
    }

    private static final CallableMemberDescriptor c(CallableMemberDescriptor callableMemberDescriptor) {
        if (b.e0(callableMemberDescriptor)) {
            return d(callableMemberDescriptor);
        }
        return null;
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T d(@NotNull T t) {
        k21.i(t, "<this>");
        if (!SpecialGenericSignatures.Companion.f().contains(t.getName()) && !nd.INSTANCE.d().contains(DescriptorUtilsKt.o(t).getName())) {
            return null;
        }
        if (t instanceof PropertyDescriptor ? true : t instanceof PropertyAccessorDescriptor) {
            return (T) DescriptorUtilsKt.d(t, false, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1.INSTANCE, 1, null);
        }
        if (t instanceof SimpleFunctionDescriptor) {
            return (T) DescriptorUtilsKt.d(t, false, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$2.INSTANCE, 1, null);
        }
        return null;
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T e(@NotNull T t) {
        k21.i(t, "<this>");
        T t2 = (T) d(t);
        if (t2 != null) {
            return t2;
        }
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        og1 name = t.getName();
        k21.h(name, "name");
        if (!builtinMethodsWithSpecialGenericSignature.l(name)) {
            return null;
        }
        return (T) DescriptorUtilsKt.d(t, false, SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2.INSTANCE, 1, null);
    }

    public static final boolean f(@NotNull ClassDescriptor classDescriptor, @NotNull CallableDescriptor callableDescriptor) {
        k21.i(classDescriptor, "<this>");
        k21.i(callableDescriptor, "specialCallableDescriptor");
        ib2 defaultType = ((ClassDescriptor) callableDescriptor.getContainingDeclaration()).getDefaultType();
        k21.h(defaultType, "specialCallableDescriptor.containingDeclaration as ClassDescriptor).defaultType");
        ClassDescriptor s = f60.s(classDescriptor);
        while (true) {
            boolean z = false;
            if (s == null) {
                return false;
            }
            if (!(s instanceof JavaClassDescriptor)) {
                if (io2.b(s.getDefaultType(), defaultType) != null) {
                    z = true;
                }
                if (z) {
                    return !b.e0(s);
                }
            }
            s = f60.s(s);
        }
    }

    public static final boolean g(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, "<this>");
        return DescriptorUtilsKt.o(callableMemberDescriptor).getContainingDeclaration() instanceof JavaClassDescriptor;
    }

    public static final boolean h(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, "<this>");
        return g(callableMemberDescriptor) || b.e0(callableMemberDescriptor);
    }
}
