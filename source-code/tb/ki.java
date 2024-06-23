package tb;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.a;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class ki extends a implements ClassConstructorDescriptor {
    private static final og1 E = og1.i("<init>");
    protected final boolean D;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ki(@NotNull ClassDescriptor classDescriptor, @Nullable ConstructorDescriptor constructorDescriptor, @NotNull Annotations annotations, boolean z, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement) {
        super(classDescriptor, constructorDescriptor, annotations, E, kind, sourceElement);
        if (classDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (kind == null) {
            a(2);
        }
        if (sourceElement == null) {
            a(3);
        }
        this.D = z;
    }

    @NotNull
    public static ki G(@NotNull ClassDescriptor classDescriptor, @NotNull Annotations annotations, boolean z, @NotNull SourceElement sourceElement) {
        if (classDescriptor == null) {
            a(4);
        }
        if (annotations == null) {
            a(5);
        }
        if (sourceElement == null) {
            a(6);
        }
        return new ki(classDescriptor, null, annotations, z, CallableMemberDescriptor.Kind.DECLARATION, sourceElement);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00aa  */
    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (!(i == 19 || i == 25)) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (!(i == 19 || i == 25)) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                        break;
                    default:
                        i2 = 3;
                        break;
                }
                Object[] objArr = new Object[i2];
                switch (i) {
                    case 1:
                    case 5:
                    case 8:
                    case 23:
                        objArr[0] = "annotations";
                        break;
                    case 2:
                    case 22:
                        objArr[0] = "kind";
                        break;
                    case 3:
                    case 6:
                    case 9:
                    case 24:
                        objArr[0] = "source";
                        break;
                    case 4:
                    case 7:
                    default:
                        objArr[0] = "containingDeclaration";
                        break;
                    case 10:
                    case 13:
                        objArr[0] = "unsubstitutedValueParameters";
                        break;
                    case 11:
                    case 14:
                        objArr[0] = "visibility";
                        break;
                    case 12:
                        objArr[0] = "typeParameterDescriptors";
                        break;
                    case 15:
                    case 16:
                    case 17:
                    case 19:
                    case 25:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                        break;
                    case 18:
                        objArr[0] = "originalSubstitutor";
                        break;
                    case 20:
                        objArr[0] = "overriddenDescriptors";
                        break;
                    case 21:
                        objArr[0] = "newOwner";
                        break;
                }
                if (i == 19) {
                    objArr[1] = "getOverriddenDescriptors";
                } else if (i != 25) {
                    switch (i) {
                        case 15:
                            objArr[1] = "getContainingDeclaration";
                            break;
                        case 16:
                            objArr[1] = "getConstructedClass";
                            break;
                        case 17:
                            objArr[1] = "getOriginal";
                            break;
                        default:
                            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                            break;
                    }
                } else {
                    objArr[1] = by0.ARG_COPY;
                }
                switch (i) {
                    case 4:
                    case 5:
                    case 6:
                        objArr[2] = "create";
                        break;
                    case 7:
                    case 8:
                    case 9:
                        objArr[2] = "createSynthesized";
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                        objArr[2] = "initialize";
                        break;
                    case 15:
                    case 16:
                    case 17:
                    case 19:
                    case 25:
                        break;
                    case 18:
                        objArr[2] = "substitute";
                        break;
                    case 20:
                        objArr[2] = "setOverriddenDescriptors";
                        break;
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        objArr[2] = "createSubstitutedCopy";
                        break;
                    default:
                        objArr[2] = "<init>";
                        break;
                }
                String format = String.format(str, objArr);
                if (!(i == 19 || i == 25)) {
                    switch (i) {
                        case 15:
                        case 16:
                        case 17:
                            break;
                        default:
                            throw new IllegalArgumentException(format);
                    }
                }
                throw new IllegalStateException(format);
            }
            i2 = 2;
            Object[] objArr2 = new Object[i2];
            switch (i) {
            }
            if (i == 19) {
            }
            switch (i) {
            }
            String format2 = String.format(str, objArr2);
            switch (i) {
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        switch (i) {
            case 15:
            case 16:
            case 17:
                i2 = 2;
                break;
        }
        Object[] objArr22 = new Object[i2];
        switch (i) {
        }
        if (i == 19) {
        }
        switch (i) {
        }
        String format22 = String.format(str, objArr22);
        switch (i) {
        }
        throw new IllegalStateException(format22);
    }

    @Nullable
    public ReceiverParameterDescriptor E() {
        ClassDescriptor I = getContainingDeclaration();
        if (!I.isInner()) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = I.getContainingDeclaration();
        if (containingDeclaration instanceof ClassDescriptor) {
            return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
        }
        return null;
    }

    @NotNull
    /* renamed from: F */
    public ClassConstructorDescriptor e(DeclarationDescriptor declarationDescriptor, Modality modality, h60 h60, CallableMemberDescriptor.Kind kind, boolean z) {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.copy(declarationDescriptor, modality, h60, kind, z);
        if (classConstructorDescriptor == null) {
            a(25);
        }
        return classConstructorDescriptor;
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: H */
    public ki f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable og1 og1, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(21);
        }
        if (kind == null) {
            a(22);
        }
        if (annotations == null) {
            a(23);
        }
        if (sourceElement == null) {
            a(24);
        }
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind == kind2 || kind == CallableMemberDescriptor.Kind.SYNTHESIZED) {
            return new ki((ClassDescriptor) declarationDescriptor, this, annotations, this.D, kind2, sourceElement);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + StringUtils.LF + "newOwner: " + declarationDescriptor + StringUtils.LF + "kind: " + kind);
    }

    @NotNull
    /* renamed from: I */
    public ClassDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = (ClassDescriptor) super.getContainingDeclaration();
        if (classDescriptor == null) {
            a(15);
        }
        return classDescriptor;
    }

    public ki J(@NotNull List<ValueParameterDescriptor> list, @NotNull h60 h60) {
        if (list == null) {
            a(13);
        }
        if (h60 == null) {
            a(14);
        }
        K(list, h60, getContainingDeclaration().getDeclaredTypeParameters());
        return this;
    }

    public ki K(@NotNull List<ValueParameterDescriptor> list, @NotNull h60 h60, @NotNull List<TypeParameterDescriptor> list2) {
        if (list == null) {
            a(10);
        }
        if (h60 == null) {
            a(11);
        }
        if (list2 == null) {
            a(12);
        }
        super.l(null, E(), list2, list, null, Modality.FINAL, h60);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitConstructorDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    @NotNull
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor I = getContainingDeclaration();
        if (I == null) {
            a(16);
        }
        return I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @NotNull
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            a(19);
        }
        return emptySet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public boolean isPrimary() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            a(20);
        }
    }

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    @Nullable
    public CallableDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            a(18);
        }
        return (ClassConstructorDescriptor) super.substitute(typeSubstitutor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, tb.w30, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, tb.v30
    @NotNull
    public ClassConstructorDescriptor getOriginal() {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.getOriginal();
        if (classConstructorDescriptor == null) {
            a(17);
        }
        return classConstructorDescriptor;
    }
}
