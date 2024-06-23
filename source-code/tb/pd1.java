package tb;

import java.util.List;
import kotlin.collections.k;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import tb.j51;

public final class pd1 {
    private static final void a(StringBuilder sb, g61 g61) {
        sb.append(g(g61));
    }

    public static final String b(FunctionDescriptor functionDescriptor, boolean z, boolean z2) {
        String str;
        k21.i(functionDescriptor, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z2) {
            if (functionDescriptor instanceof ConstructorDescriptor) {
                str = "<init>";
            } else {
                str = functionDescriptor.getName().b();
                k21.h(str, "name.asString()");
            }
            sb.append(str);
        }
        sb.append(jl1.BRACKET_START_STR);
        ReceiverParameterDescriptor extensionReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            g61 type = extensionReceiverParameter.getType();
            k21.h(type, "it.type");
            a(sb, type);
        }
        for (ValueParameterDescriptor valueParameterDescriptor : functionDescriptor.getValueParameters()) {
            g61 type2 = valueParameterDescriptor.getType();
            k21.h(type2, "parameter.type");
            a(sb, type2);
        }
        sb.append(jl1.BRACKET_END_STR);
        if (z) {
            if (y50.c(functionDescriptor)) {
                sb.append("V");
            } else {
                g61 returnType = functionDescriptor.getReturnType();
                k21.f(returnType);
                a(sb, returnType);
            }
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String c(FunctionDescriptor functionDescriptor, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return b(functionDescriptor, z, z2);
    }

    public static final String d(CallableDescriptor callableDescriptor) {
        k21.i(callableDescriptor, "<this>");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        if (f60.E(callableDescriptor)) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null || classDescriptor.getName().g()) {
            return null;
        }
        CallableDescriptor original = callableDescriptor.getOriginal();
        SimpleFunctionDescriptor simpleFunctionDescriptor = original instanceof SimpleFunctionDescriptor ? (SimpleFunctionDescriptor) original : null;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        return od1.a(signatureBuildingComponents, classDescriptor, c(simpleFunctionDescriptor, false, false, 3, null));
    }

    public static final boolean e(CallableDescriptor callableDescriptor) {
        k21.i(callableDescriptor, "f");
        if (!(callableDescriptor instanceof FunctionDescriptor)) {
            return false;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
        if (!k21.d(functionDescriptor.getName().b(), "remove") || functionDescriptor.getValueParameters().size() != 1 || SpecialBuiltinMembers.h((CallableMemberDescriptor) callableDescriptor)) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getOriginal().getValueParameters();
        k21.h(valueParameters, "f.original.valueParameters");
        g61 type = ((ValueParameterDescriptor) k.o0(valueParameters)).getType();
        k21.h(type, "f.original.valueParameters.single().type");
        j51 g = g(type);
        JvmPrimitiveType jvmPrimitiveType = null;
        j51.d dVar = g instanceof j51.d ? (j51.d) g : null;
        if (dVar != null) {
            jvmPrimitiveType = dVar.i();
        }
        if (jvmPrimitiveType != JvmPrimitiveType.INT) {
            return false;
        }
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        FunctionDescriptor k = BuiltinMethodsWithSpecialGenericSignature.k(functionDescriptor);
        if (k == null) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters2 = k.getOriginal().getValueParameters();
        k21.h(valueParameters2, "overridden.original.valueParameters");
        g61 type2 = ((ValueParameterDescriptor) k.o0(valueParameters2)).getType();
        k21.h(type2, "overridden.original.valueParameters.single().type");
        j51 g2 = g(type2);
        DeclarationDescriptor containingDeclaration = k.getContainingDeclaration();
        k21.h(containingDeclaration, "overridden.containingDeclaration");
        if (!k21.d(DescriptorUtilsKt.j(containingDeclaration), c.a.mutableCollection.j()) || !(g2 instanceof j51.c) || !k21.d(((j51.c) g2).i(), "java/lang/Object")) {
            return false;
        }
        return true;
    }

    public static final String f(ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "<this>");
        w31 w31 = w31.INSTANCE;
        fn0 j = DescriptorUtilsKt.i(classDescriptor).j();
        k21.h(j, "fqNameSafe.toUnsafe()");
        oi o = w31.o(j);
        if (o == null) {
            return y50.b(classDescriptor, null, 2, null);
        }
        String f = a51.b(o).f();
        k21.h(f, "byClassId(it).internalName");
        return f;
    }

    public static final j51 g(g61 g61) {
        k21.i(g61, "<this>");
        return (j51) y50.e(g61, k51.INSTANCE, ro2.DEFAULT, qo2.INSTANCE, null, null, 32, null);
    }
}
