package tb;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.me0;

/* compiled from: Taobao */
public class ke0 extends fb2 {

    /* compiled from: Taobao */
    class a implements FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> {
        a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:102:0x0151  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0080  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0109  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x010e  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0111  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0116  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x011b  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0120  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0123  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0126  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0129  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x012c  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x012f  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x0132  */
        private static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (!(i == 1 || i == 3 || i == 5 || i == 10 || i == 12 || i == 14 || i == 16 || i == 18 || i == 30 || i == 7 || i == 8)) {
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
                if (!(i == 1 || i == 3 || i == 5 || i == 10 || i == 12 || i == 14 || i == 16 || i == 18 || i == 30 || i == 7 || i == 8)) {
                    switch (i) {
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                            break;
                        default:
                            i2 = 3;
                            break;
                    }
                    Object[] objArr = new Object[i2];
                    switch (i) {
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12:
                        case 14:
                        case 16:
                        case 18:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 30:
                            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                            break;
                        case 2:
                            objArr[0] = "modality";
                            break;
                        case 4:
                            objArr[0] = "visibility";
                            break;
                        case 6:
                            objArr[0] = "kind";
                            break;
                        case 9:
                            objArr[0] = "name";
                            break;
                        case 11:
                        case 17:
                            objArr[0] = PushConstants.PARAMS;
                            break;
                        case 13:
                            objArr[0] = "substitution";
                            break;
                        case 15:
                            objArr[0] = "userDataKey";
                            break;
                        case 19:
                            objArr[0] = "type";
                            break;
                        case 29:
                            objArr[0] = "additionalAnnotations";
                            break;
                        default:
                            objArr[0] = "owner";
                            break;
                    }
                    if (i == 1) {
                        objArr[1] = "setOwner";
                    } else if (i == 3) {
                        objArr[1] = "setModality";
                    } else if (i == 5) {
                        objArr[1] = "setVisibility";
                    } else if (i == 10) {
                        objArr[1] = "setName";
                    } else if (i == 12) {
                        objArr[1] = "setValueParameters";
                    } else if (i == 14) {
                        objArr[1] = "setSubstitution";
                    } else if (i == 16) {
                        objArr[1] = "putUserData";
                    } else if (i == 18) {
                        objArr[1] = "setTypeParameters";
                    } else if (i == 30) {
                        objArr[1] = "setAdditionalAnnotations";
                    } else if (i == 7) {
                        objArr[1] = "setKind";
                    } else if (i != 8) {
                        switch (i) {
                            case 20:
                                objArr[1] = "setReturnType";
                                break;
                            case 21:
                                objArr[1] = "setExtensionReceiverParameter";
                                break;
                            case 22:
                                objArr[1] = "setDispatchReceiverParameter";
                                break;
                            case 23:
                                objArr[1] = "setOriginal";
                                break;
                            case 24:
                                objArr[1] = "setSignatureChange";
                                break;
                            case 25:
                                objArr[1] = "setPreserveSourceElement";
                                break;
                            case 26:
                                objArr[1] = "setDropOriginalInContainingParts";
                                break;
                            case 27:
                                objArr[1] = "setHiddenToOvercomeSignatureClash";
                                break;
                            case 28:
                                objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                                break;
                            default:
                                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                                break;
                        }
                    } else {
                        objArr[1] = "setCopyOverrides";
                    }
                    switch (i) {
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12:
                        case 14:
                        case 16:
                        case 18:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 30:
                            break;
                        case 2:
                            objArr[2] = "setModality";
                            break;
                        case 4:
                            objArr[2] = "setVisibility";
                            break;
                        case 6:
                            objArr[2] = "setKind";
                            break;
                        case 9:
                            objArr[2] = "setName";
                            break;
                        case 11:
                            objArr[2] = "setValueParameters";
                            break;
                        case 13:
                            objArr[2] = "setSubstitution";
                            break;
                        case 15:
                            objArr[2] = "putUserData";
                            break;
                        case 17:
                            objArr[2] = "setTypeParameters";
                            break;
                        case 19:
                            objArr[2] = "setReturnType";
                            break;
                        case 29:
                            objArr[2] = "setAdditionalAnnotations";
                            break;
                        default:
                            objArr[2] = "setOwner";
                            break;
                    }
                    String format = String.format(str, objArr);
                    if (!(i == 1 || i == 3 || i == 5 || i == 10 || i == 12 || i == 14 || i == 16 || i == 18 || i == 30 || i == 7 || i == 8)) {
                        switch (i) {
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
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
                if (i == 1) {
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
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                    i2 = 2;
                    break;
            }
            Object[] objArr22 = new Object[i2];
            switch (i) {
            }
            if (i == 1) {
            }
            switch (i) {
            }
            String format22 = String.format(str, objArr22);
            switch (i) {
            }
            throw new IllegalStateException(format22);
        }

        @Nullable
        /* renamed from: b */
        public SimpleFunctionDescriptor build() {
            return ke0.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setAdditionalAnnotations(@NotNull Annotations annotations) {
            if (annotations == null) {
                a(29);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setCopyOverrides(boolean z) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDropOriginalInContainingParts() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenToOvercomeSignatureClash() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setKind(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                a(6);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setModality(@NotNull Modality modality) {
            if (modality == null) {
                a(2);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setName(@NotNull og1 og1) {
            if (og1 == null) {
                a(9);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOriginal(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOwner(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                a(0);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setPreserveSourceElement() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setReturnType(@NotNull g61 g61) {
            if (g61 == null) {
                a(19);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSignatureChange() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSubstitution(@NotNull xo2 xo2) {
            if (xo2 == null) {
                a(13);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setTypeParameters(@NotNull List<TypeParameterDescriptor> list) {
            if (list == null) {
                a(17);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setValueParameters(@NotNull List<ValueParameterDescriptor> list) {
            if (list == null) {
                a(11);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setVisibility(@NotNull h60 h60) {
            if (h60 == null) {
                a(4);
            }
            return this;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ke0(@NotNull ClassDescriptor classDescriptor, @NotNull me0.d dVar) {
        super(classDescriptor, null, Annotations.Companion.b(), og1.i("<ERROR FUNCTION>"), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE);
        if (classDescriptor == null) {
            a(0);
        }
        if (dVar == null) {
            a(1);
        }
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 6 || i == 7) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "ownerScope";
                break;
            case 2:
                objArr[0] = "newOwner";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "annotations";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
            case 8:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 6) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = by0.ARG_COPY;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 6:
            case 7:
                break;
            case 8:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 6 || i == 7) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @Override // tb.fb2
    @NotNull
    /* renamed from: E */
    public SimpleFunctionDescriptor e(DeclarationDescriptor declarationDescriptor, Modality modality, h60 h60, CallableMemberDescriptor.Kind kind, boolean z) {
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, tb.fb2
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.impl.a f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable og1 og1, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(2);
        }
        if (kind == null) {
            a(3);
        }
        if (annotations == null) {
            a(4);
        }
        if (sourceElement == null) {
            a(5);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, tb.fb2, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder() {
        return new a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            a(8);
        }
    }
}
