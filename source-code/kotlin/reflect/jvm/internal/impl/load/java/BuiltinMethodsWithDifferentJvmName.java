package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.og1;
import tb.pd1;

/* compiled from: Taobao */
public final class BuiltinMethodsWithDifferentJvmName extends SpecialGenericSignatures {
    @NotNull
    public static final BuiltinMethodsWithDifferentJvmName INSTANCE = new BuiltinMethodsWithDifferentJvmName();

    private BuiltinMethodsWithDifferentJvmName() {
    }

    @NotNull
    public final List<og1> i(@NotNull og1 og1) {
        k21.i(og1, "name");
        List<og1> list = SpecialGenericSignatures.Companion.e().get(og1);
        return list == null ? m.g() : list;
    }

    @Nullable
    public final og1 j(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        k21.i(simpleFunctionDescriptor, "functionDescriptor");
        Map<String, og1> i = SpecialGenericSignatures.Companion.i();
        String d = pd1.d(simpleFunctionDescriptor);
        if (d == null) {
            return null;
        }
        return i.get(d);
    }

    public final boolean k(@NotNull og1 og1) {
        k21.i(og1, "<this>");
        return SpecialGenericSignatures.Companion.f().contains(og1);
    }

    public final boolean l(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        k21.i(simpleFunctionDescriptor, "functionDescriptor");
        return b.e0(simpleFunctionDescriptor) && DescriptorUtilsKt.d(simpleFunctionDescriptor, false, new BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1(simpleFunctionDescriptor), 1, null) != null;
    }

    public final boolean m(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        k21.i(simpleFunctionDescriptor, "<this>");
        return k21.d(simpleFunctionDescriptor.getName().b(), "removeAt") && k21.d(pd1.d(simpleFunctionDescriptor), SpecialGenericSignatures.Companion.g().b());
    }
}
