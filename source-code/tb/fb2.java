package tb;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.reflect.jvm.internal.impl.descriptors.impl.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class fb2 extends a implements SimpleFunctionDescriptor {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected fb2(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable SimpleFunctionDescriptor simpleFunctionDescriptor, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement) {
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
    }

    @NotNull
    public static fb2 F(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(5);
        }
        if (annotations == null) {
            a(6);
        }
        if (og1 == null) {
            a(7);
        }
        if (kind == null) {
            a(8);
        }
        if (sourceElement == null) {
            a(9);
        }
        return new fb2(declarationDescriptor, null, annotations, og1, kind, sourceElement);
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 13 || i == 17 || i == 18 || i == 23 || i == 24) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 13 || i == 17 || i == 18 || i == 23 || i == 24) ? 2 : 3)];
        switch (i) {
            case 1:
            case 6:
            case 21:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 20:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 22:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 15:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 16:
                objArr[0] = "visibility";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 19:
                objArr[0] = "newOwner";
                break;
        }
        if (i == 13 || i == 17) {
            objArr[1] = "initialize";
        } else if (i == 18) {
            objArr[1] = "getOriginal";
        } else if (i == 23) {
            objArr[1] = by0.ARG_COPY;
        } else if (i != 24) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
                objArr[2] = "initialize";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 13 || i == 17 || i == 18 || i == 23 || i == 24) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    /* renamed from: E */
    public SimpleFunctionDescriptor e(DeclarationDescriptor declarationDescriptor, Modality modality, h60 h60, CallableMemberDescriptor.Kind kind, boolean z) {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) super.copy(declarationDescriptor, modality, h60, kind, z);
        if (simpleFunctionDescriptor == null) {
            a(23);
        }
        return simpleFunctionDescriptor;
    }

    @NotNull
    /* renamed from: G */
    public SimpleFunctionDescriptor getOriginal() {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) super.getOriginal();
        if (simpleFunctionDescriptor == null) {
            a(18);
        }
        return simpleFunctionDescriptor;
    }

    @NotNull
    /* renamed from: H */
    public fb2 l(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull List<ValueParameterDescriptor> list2, @Nullable g61 g61, @Nullable Modality modality, @NotNull h60 h60) {
        if (list == null) {
            a(10);
        }
        if (list2 == null) {
            a(11);
        }
        if (h60 == null) {
            a(12);
        }
        fb2 I = I(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, g61, modality, h60, null);
        if (I == null) {
            a(13);
        }
        return I;
    }

    @NotNull
    public fb2 I(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull List<ValueParameterDescriptor> list2, @Nullable g61 g61, @Nullable Modality modality, @NotNull h60 h60, @Nullable Map<? extends CallableDescriptor.UserDataKey<?>, ?> map) {
        if (list == null) {
            a(14);
        }
        if (list2 == null) {
            a(15);
        }
        if (h60 == null) {
            a(16);
        }
        super.l(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, g61, modality, h60);
        if (map != null && !map.isEmpty()) {
            this.C = new LinkedHashMap(map);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    @NotNull
    public a f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable og1 og1, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(19);
        }
        if (kind == null) {
            a(20);
        }
        if (annotations == null) {
            a(21);
        }
        if (sourceElement == null) {
            a(22);
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (og1 == null) {
            og1 = getName();
        }
        return new fb2(declarationDescriptor, simpleFunctionDescriptor, annotations, og1, kind, sourceElement);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor>, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder() {
        FunctionDescriptor.CopyBuilder newCopyBuilder = super.newCopyBuilder();
        if (newCopyBuilder == null) {
            a(24);
        }
        return newCopyBuilder;
    }
}
