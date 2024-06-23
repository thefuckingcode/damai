package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.og1;
import tb.pd1;

/* compiled from: Taobao */
public final class BuiltinMethodsWithSpecialGenericSignature extends SpecialGenericSignatures {
    @NotNull
    public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE = new BuiltinMethodsWithSpecialGenericSignature();

    private BuiltinMethodsWithSpecialGenericSignature() {
    }

    /* access modifiers changed from: private */
    public final boolean j(CallableMemberDescriptor callableMemberDescriptor) {
        return CollectionsKt___CollectionsKt.J(SpecialGenericSignatures.Companion.d(), pd1.d(callableMemberDescriptor));
    }

    @JvmStatic
    @Nullable
    public static final FunctionDescriptor k(@NotNull FunctionDescriptor functionDescriptor) {
        k21.i(functionDescriptor, "functionDescriptor");
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = INSTANCE;
        og1 name = functionDescriptor.getName();
        k21.h(name, "functionDescriptor.name");
        if (!builtinMethodsWithSpecialGenericSignature.l(name)) {
            return null;
        }
        return (FunctionDescriptor) DescriptorUtilsKt.d(functionDescriptor, false, new BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1(builtinMethodsWithSpecialGenericSignature), 1, null);
    }

    @JvmStatic
    @Nullable
    public static final SpecialGenericSignatures.SpecialSignatureInfo m(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, "<this>");
        SpecialGenericSignatures.a aVar = SpecialGenericSignatures.Companion;
        if (!aVar.c().contains(callableMemberDescriptor.getName())) {
            return null;
        }
        CallableMemberDescriptor d = DescriptorUtilsKt.d(callableMemberDescriptor, false, new BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1(INSTANCE), 1, null);
        String d2 = d == null ? null : pd1.d(d);
        if (d2 == null) {
            return null;
        }
        return aVar.j(d2);
    }

    public final boolean l(@NotNull og1 og1) {
        k21.i(og1, "<this>");
        return SpecialGenericSignatures.Companion.c().contains(og1);
    }
}
