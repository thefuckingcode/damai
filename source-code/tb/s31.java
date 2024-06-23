package tb;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j51;

/* compiled from: Taobao */
public final class s31 implements ExternalOverridabilityCondition {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        private final boolean b(FunctionDescriptor functionDescriptor) {
            if (functionDescriptor.getValueParameters().size() != 1) {
                return false;
            }
            DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            ClassDescriptor classDescriptor = null;
            ClassDescriptor classDescriptor2 = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
            if (classDescriptor2 == null) {
                return false;
            }
            List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
            k21.h(valueParameters, "f.valueParameters");
            ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) k.o0(valueParameters)).getType().c().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                classDescriptor = (ClassDescriptor) declarationDescriptor;
            }
            if (classDescriptor != null && b.x0(classDescriptor2) && k21.d(DescriptorUtilsKt.i(classDescriptor2), DescriptorUtilsKt.i(classDescriptor))) {
                return true;
            }
            return false;
        }

        private final j51 c(FunctionDescriptor functionDescriptor, ValueParameterDescriptor valueParameterDescriptor) {
            if (pd1.e(functionDescriptor) || b(functionDescriptor)) {
                g61 type = valueParameterDescriptor.getType();
                k21.h(type, "valueParameterDescriptor.type");
                return pd1.g(TypeUtilsKt.k(type));
            }
            g61 type2 = valueParameterDescriptor.getType();
            k21.h(type2, "valueParameterDescriptor.type");
            return pd1.g(type2);
        }

        public final boolean a(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
            k21.i(callableDescriptor, "superDescriptor");
            k21.i(callableDescriptor2, "subDescriptor");
            if ((callableDescriptor2 instanceof JavaMethodDescriptor) && (callableDescriptor instanceof FunctionDescriptor)) {
                JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
                javaMethodDescriptor.getValueParameters().size();
                FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
                functionDescriptor.getValueParameters().size();
                List<ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getOriginal().getValueParameters();
                k21.h(valueParameters, "subDescriptor.original.valueParameters");
                List<ValueParameterDescriptor> valueParameters2 = functionDescriptor.getOriginal().getValueParameters();
                k21.h(valueParameters2, "superDescriptor.original.valueParameters");
                for (Pair pair : CollectionsKt___CollectionsKt.F0(valueParameters, valueParameters2)) {
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.component1();
                    ValueParameterDescriptor valueParameterDescriptor2 = (ValueParameterDescriptor) pair.component2();
                    k21.h(valueParameterDescriptor, "subParameter");
                    boolean z = c((FunctionDescriptor) callableDescriptor2, valueParameterDescriptor) instanceof j51.d;
                    k21.h(valueParameterDescriptor2, "superParameter");
                    if (z != (c(functionDescriptor, valueParameterDescriptor2) instanceof j51.d)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private final boolean a(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if ((callableDescriptor instanceof CallableMemberDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && !b.e0(callableDescriptor2)) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
            FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor2;
            og1 name = functionDescriptor.getName();
            k21.h(name, "subDescriptor.name");
            if (!builtinMethodsWithSpecialGenericSignature.l(name)) {
                BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.INSTANCE;
                og1 name2 = functionDescriptor.getName();
                k21.h(name2, "subDescriptor.name");
                if (!builtinMethodsWithDifferentJvmName.k(name2)) {
                    return false;
                }
            }
            CallableMemberDescriptor e = SpecialBuiltinMembers.e((CallableMemberDescriptor) callableDescriptor);
            Boolean valueOf = Boolean.valueOf(functionDescriptor.isHiddenToOvercomeSignatureClash());
            boolean z = callableDescriptor instanceof FunctionDescriptor;
            FunctionDescriptor functionDescriptor2 = z ? (FunctionDescriptor) callableDescriptor : null;
            if ((!k21.d(valueOf, functionDescriptor2 == null ? null : Boolean.valueOf(functionDescriptor2.isHiddenToOvercomeSignatureClash()))) && (e == null || !functionDescriptor.isHiddenToOvercomeSignatureClash())) {
                return true;
            }
            if ((classDescriptor instanceof JavaClassDescriptor) && functionDescriptor.getInitialSignatureDescriptor() == null && e != null && !SpecialBuiltinMembers.f(classDescriptor, e)) {
                if ((e instanceof FunctionDescriptor) && z && BuiltinMethodsWithSpecialGenericSignature.k((FunctionDescriptor) e) != null) {
                    String c = pd1.c(functionDescriptor, false, false, 2, null);
                    FunctionDescriptor original = ((FunctionDescriptor) callableDescriptor).getOriginal();
                    k21.h(original, "superDescriptor.original");
                    if (k21.d(c, pd1.c(original, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Result isOverridable(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor) {
        k21.i(callableDescriptor, "superDescriptor");
        k21.i(callableDescriptor2, "subDescriptor");
        if (a(callableDescriptor, callableDescriptor2, classDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        if (Companion.a(callableDescriptor, callableDescriptor2)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
