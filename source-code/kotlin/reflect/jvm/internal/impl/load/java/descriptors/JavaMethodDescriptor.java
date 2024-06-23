package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fb2;
import tb.g61;
import tb.gl1;
import tb.h60;
import tb.og1;
import tb.vt2;
import tb.xu2;
import tb.z50;

/* compiled from: Taobao */
public class JavaMethodDescriptor extends fb2 implements JavaCallableMemberDescriptor {
    public static final CallableDescriptor.UserDataKey<ValueParameterDescriptor> ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = new a();
    private ParameterNamesStatus D;
    private final boolean E;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum ParameterNamesStatus {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);
        
        public final boolean isStable;
        public final boolean isSynthesized;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", gl1.TYPE_OPEN_URL_METHOD_GET));
        }

        private ParameterNamesStatus(boolean z, boolean z2) {
            this.isStable = z;
            this.isSynthesized = z2;
        }

        @NotNull
        public static ParameterNamesStatus get(boolean z, boolean z2) {
            ParameterNamesStatus parameterNamesStatus = z ? z2 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z2 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            if (parameterNamesStatus == null) {
                $$$reportNull$$$0(0);
            }
            return parameterNamesStatus;
        }
    }

    /* compiled from: Taobao */
    static class a implements CallableDescriptor.UserDataKey<ValueParameterDescriptor> {
        a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected JavaMethodDescriptor(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable SimpleFunctionDescriptor simpleFunctionDescriptor, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, boolean z) {
        super(declarationDescriptor, simpleFunctionDescriptor, annotations, og1, kind, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (og1 == null) {
            a(2);
        }
        if (kind == null) {
            a(3);
        }
        if (sourceElement == null) {
            a(4);
        }
        this.D = null;
        this.E = z;
    }

    @NotNull
    public static JavaMethodDescriptor J(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull SourceElement sourceElement, boolean z) {
        if (declarationDescriptor == null) {
            a(5);
        }
        if (annotations == null) {
            a(6);
        }
        if (og1 == null) {
            a(7);
        }
        if (sourceElement == null) {
            a(8);
        }
        return new JavaMethodDescriptor(declarationDescriptor, null, annotations, og1, CallableMemberDescriptor.Kind.DECLARATION, sourceElement, z);
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 12 || i == 17 || i == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 12 || i == 17 || i == 20) ? 2 : 3)];
        switch (i) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 12) {
            objArr[1] = "initialize";
        } else if (i == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 12 || i == 17 || i == 20) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @Override // tb.fb2
    @NotNull
    public fb2 I(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull List<ValueParameterDescriptor> list2, @Nullable g61 g61, @Nullable Modality modality, @NotNull h60 h60, @Nullable Map<? extends CallableDescriptor.UserDataKey<?>, ?> map) {
        if (list == null) {
            a(9);
        }
        if (list2 == null) {
            a(10);
        }
        if (h60 == null) {
            a(11);
        }
        fb2 I = super.I(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, g61, modality, h60, map);
        z(OperatorChecks.INSTANCE.a(I).a());
        if (I == null) {
            a(12);
        }
        return I;
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: K */
    public JavaMethodDescriptor f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable og1 og1, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(13);
        }
        if (kind == null) {
            a(14);
        }
        if (annotations == null) {
            a(15);
        }
        if (sourceElement == null) {
            a(16);
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (og1 == null) {
            og1 = getName();
        }
        JavaMethodDescriptor javaMethodDescriptor = new JavaMethodDescriptor(declarationDescriptor, simpleFunctionDescriptor, annotations, og1, kind, sourceElement, this.E);
        javaMethodDescriptor.M(k(), hasSynthesizedParameterNames());
        return javaMethodDescriptor;
    }

    @NotNull
    /* renamed from: L */
    public JavaMethodDescriptor enhance(@Nullable g61 g61, @NotNull List<xu2> list, @NotNull g61 g612, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        if (list == null) {
            a(18);
        }
        if (g612 == null) {
            a(19);
        }
        List<ValueParameterDescriptor> a2 = vt2.a(list, getValueParameters(), this);
        if (g61 == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = z50.f(this, g61, Annotations.Companion.b());
        }
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) newCopyBuilder().setValueParameters(a2).setReturnType(g612).setExtensionReceiverParameter(receiverParameterDescriptor).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        if (pair != null) {
            javaMethodDescriptor.o(pair.getFirst(), pair.getSecond());
        }
        if (javaMethodDescriptor == null) {
            a(20);
        }
        return javaMethodDescriptor;
    }

    public void M(boolean z, boolean z2) {
        this.D = ParameterNamesStatus.get(z, z2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public boolean hasSynthesizedParameterNames() {
        return this.D.isSynthesized;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public boolean k() {
        return this.D.isStable;
    }
}
