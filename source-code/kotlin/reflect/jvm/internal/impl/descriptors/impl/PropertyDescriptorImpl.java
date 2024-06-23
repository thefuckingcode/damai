package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

public class PropertyDescriptorImpl extends VariableDescriptorWithInitializerImpl implements PropertyDescriptor {
    private FieldDescriptor backingField;
    private FieldDescriptor delegateField;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private PropertyGetterDescriptorImpl getter;
    private final boolean isActual;
    private final boolean isConst;
    private final boolean isDelegated;
    private final boolean isExpect;
    private final boolean isExternal;
    private final CallableMemberDescriptor.Kind kind;
    private final boolean lateInit;
    private final Modality modality;
    private final PropertyDescriptor original;
    private Collection<? extends PropertyDescriptor> overriddenProperties;
    private PropertySetterDescriptor setter;
    private boolean setterProjectedOut;
    private List<TypeParameterDescriptor> typeParameters;
    private Visibility visibility;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0113  */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        if (!(i == 23 || i == 33 || i == 34 || i == 36 || i == 37)) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (!(i == 23 || i == 33 || i == 34 || i == 36 || i == 37)) {
                switch (i) {
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        break;
                    default:
                        i2 = 3;
                        break;
                }
                Object[] objArr = new Object[i2];
                switch (i) {
                    case 1:
                    case 8:
                        objArr[0] = "annotations";
                        break;
                    case 2:
                    case 9:
                        objArr[0] = "modality";
                        break;
                    case 3:
                    case 10:
                    case 16:
                        objArr[0] = "visibility";
                        break;
                    case 4:
                    case 11:
                        objArr[0] = SerializableCookie.NAME;
                        break;
                    case 5:
                    case 12:
                    case 30:
                        objArr[0] = "kind";
                        break;
                    case 6:
                    case 13:
                    case 32:
                        objArr[0] = "source";
                        break;
                    case 7:
                    default:
                        objArr[0] = "containingDeclaration";
                        break;
                    case 14:
                        objArr[0] = "outType";
                        break;
                    case 15:
                        objArr[0] = "typeParameters";
                        break;
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 23:
                    case 33:
                    case 34:
                    case 36:
                    case 37:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                        break;
                    case 22:
                        objArr[0] = "originalSubstitutor";
                        break;
                    case 24:
                        objArr[0] = "copyConfiguration";
                        break;
                    case 25:
                        objArr[0] = "substitutor";
                        break;
                    case 26:
                        objArr[0] = "accessorDescriptor";
                        break;
                    case 27:
                        objArr[0] = "newOwner";
                        break;
                    case 28:
                        objArr[0] = "newModality";
                        break;
                    case 29:
                        objArr[0] = "newVisibility";
                        break;
                    case 31:
                        objArr[0] = "newName";
                        break;
                    case 35:
                        objArr[0] = "overriddenDescriptors";
                        break;
                }
                if (i == 23) {
                    objArr[1] = "getSourceToUseForCopy";
                } else if (i == 33) {
                    objArr[1] = "getOriginal";
                } else if (i == 34) {
                    objArr[1] = "getKind";
                } else if (i == 36) {
                    objArr[1] = "getOverriddenDescriptors";
                } else if (i != 37) {
                    switch (i) {
                        case 17:
                            objArr[1] = "getTypeParameters";
                            break;
                        case 18:
                            objArr[1] = "getReturnType";
                            break;
                        case 19:
                            objArr[1] = "getModality";
                            break;
                        case 20:
                            objArr[1] = "getVisibility";
                            break;
                        case 21:
                            objArr[1] = "getAccessors";
                            break;
                        default:
                            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                            break;
                    }
                } else {
                    objArr[1] = "copy";
                }
                switch (i) {
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        objArr[2] = "create";
                        break;
                    case 14:
                    case 15:
                        objArr[2] = "setType";
                        break;
                    case 16:
                        objArr[2] = "setVisibility";
                        break;
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 23:
                    case 33:
                    case 34:
                    case 36:
                    case 37:
                        break;
                    case 22:
                        objArr[2] = "substitute";
                        break;
                    case 24:
                        objArr[2] = "doSubstitute";
                        break;
                    case 25:
                    case 26:
                        objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                        break;
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                        objArr[2] = "createSubstitutedCopy";
                        break;
                    case 35:
                        objArr[2] = "setOverriddenDescriptors";
                        break;
                    default:
                        objArr[2] = "<init>";
                        break;
                }
                String format = String.format(str, objArr);
                if (!(i == 23 || i == 33 || i == 34 || i == 36 || i == 37)) {
                    switch (i) {
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
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
            if (i == 23) {
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
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                i2 = 2;
                break;
        }
        Object[] objArr22 = new Object[i2];
        switch (i) {
        }
        if (i == 23) {
        }
        switch (i) {
        }
        String format22 = String.format(str, objArr22);
        switch (i) {
        }
        throw new IllegalStateException(format22);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected PropertyDescriptorImpl(DeclarationDescriptor declarationDescriptor, PropertyDescriptor propertyDescriptor, Annotations annotations, Modality modality2, Visibility visibility2, boolean z, Name name, CallableMemberDescriptor.Kind kind2, SourceElement sourceElement, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        super(declarationDescriptor, annotations, name, null, z, sourceElement);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (modality2 == null) {
            $$$reportNull$$$0(2);
        }
        if (visibility2 == null) {
            $$$reportNull$$$0(3);
        }
        if (name == null) {
            $$$reportNull$$$0(4);
        }
        if (kind2 == null) {
            $$$reportNull$$$0(5);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(6);
        }
        this.overriddenProperties = null;
        this.modality = modality2;
        this.visibility = visibility2;
        this.original = propertyDescriptor == null ? this : propertyDescriptor;
        this.kind = kind2;
        this.lateInit = z2;
        this.isConst = z3;
        this.isExpect = z4;
        this.isActual = z5;
        this.isExternal = z6;
        this.isDelegated = z7;
    }

    public static PropertyDescriptorImpl create(DeclarationDescriptor declarationDescriptor, Annotations annotations, Modality modality2, Visibility visibility2, boolean z, Name name, CallableMemberDescriptor.Kind kind2, SourceElement sourceElement, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(7);
        }
        if (annotations == null) {
            $$$reportNull$$$0(8);
        }
        if (modality2 == null) {
            $$$reportNull$$$0(9);
        }
        if (visibility2 == null) {
            $$$reportNull$$$0(10);
        }
        if (name == null) {
            $$$reportNull$$$0(11);
        }
        if (kind2 == null) {
            $$$reportNull$$$0(12);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(13);
        }
        return new PropertyDescriptorImpl(declarationDescriptor, null, annotations, modality2, visibility2, z, name, kind2, sourceElement, z2, z3, z4, z5, z6, z7);
    }

    public void setType(KotlinType kotlinType, List<? extends TypeParameterDescriptor> list, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(14);
        }
        if (list == null) {
            $$$reportNull$$$0(15);
        }
        setOutType(kotlinType);
        this.typeParameters = new ArrayList(list);
        this.extensionReceiverParameter = receiverParameterDescriptor2;
        this.dispatchReceiverParameter = receiverParameterDescriptor;
    }

    public void initialize(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor) {
        initialize(propertyGetterDescriptorImpl, propertySetterDescriptor, null, null);
    }

    public void initialize(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor, FieldDescriptor fieldDescriptor, FieldDescriptor fieldDescriptor2) {
        this.getter = propertyGetterDescriptorImpl;
        this.setter = propertySetterDescriptor;
        this.backingField = fieldDescriptor;
        this.delegateField = fieldDescriptor2;
    }

    public void setSetterProjectedOut(boolean z) {
        this.setterProjectedOut = z;
    }

    public void setVisibility(Visibility visibility2) {
        if (visibility2 == null) {
            $$$reportNull$$$0(16);
        }
        this.visibility = visibility2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.typeParameters;
        if (list == null) {
            $$$reportNull$$$0(17);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType type = getType();
        if (type == null) {
            $$$reportNull$$$0(18);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality modality2 = this.modality;
        if (modality2 == null) {
            $$$reportNull$$$0(19);
        }
        return modality2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Visibility getVisibility() {
        Visibility visibility2 = this.visibility;
        if (visibility2 == null) {
            $$$reportNull$$$0(20);
        }
        return visibility2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public PropertyGetterDescriptorImpl getGetter() {
        return this.getter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public PropertySetterDescriptor getSetter() {
        return this.setter;
    }

    public boolean isSetterProjectedOut() {
        return this.setterProjectedOut;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return this.lateInit;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        return this.isConst;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public boolean isDelegated() {
        return this.isDelegated;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList arrayList = new ArrayList(2);
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.getter;
        if (propertyGetterDescriptorImpl != null) {
            arrayList.add(propertyGetterDescriptorImpl);
        }
        PropertySetterDescriptor propertySetterDescriptor = this.setter;
        if (propertySetterDescriptor != null) {
            arrayList.add(propertySetterDescriptor);
        }
        return arrayList;
    }

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public CallableDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(22);
        }
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        return newCopyBuilder().setSubstitution(typeSubstitutor.getSubstitution()).setOriginal(getOriginal()).build();
    }

    public class CopyConfiguration {
        private boolean copyOverrides;
        private ReceiverParameterDescriptor dispatchReceiverParameter;
        private CallableMemberDescriptor.Kind kind;
        private Modality modality;
        private Name name;
        private List<TypeParameterDescriptor> newTypeParameters;
        private PropertyDescriptor original = null;
        private DeclarationDescriptor owner;
        private boolean preserveSourceElement = false;
        private TypeSubstitution substitution;
        private Visibility visibility;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 17 || i == 11 || i == 12 || i == 14 || i == 15) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 17 || i == 11 || i == 12 || i == 14 || i == 15) ? 2 : 3)];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "modality";
                    break;
                case 6:
                    objArr[0] = "visibility";
                    break;
                case 8:
                    objArr[0] = "kind";
                    break;
                case 10:
                    objArr[0] = "typeParameters";
                    break;
                case 13:
                    objArr[0] = "substitution";
                    break;
                case 16:
                    objArr[0] = SerializableCookie.NAME;
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i == 1) {
                objArr[1] = "setOwner";
            } else if (i == 2) {
                objArr[1] = "setOriginal";
            } else if (i == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i == 5) {
                objArr[1] = "setModality";
            } else if (i == 7) {
                objArr[1] = "setVisibility";
            } else if (i == 9) {
                objArr[1] = "setKind";
            } else if (i == 17) {
                objArr[1] = "setName";
            } else if (i == 11) {
                objArr[1] = "setTypeParameters";
            } else if (i == 12) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i == 14) {
                objArr[1] = "setSubstitution";
            } else if (i != 15) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                case 17:
                    break;
                case 4:
                    objArr[2] = "setModality";
                    break;
                case 6:
                    objArr[2] = "setVisibility";
                    break;
                case 8:
                    objArr[2] = "setKind";
                    break;
                case 10:
                    objArr[2] = "setTypeParameters";
                    break;
                case 13:
                    objArr[2] = "setSubstitution";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            if (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 17 || i == 11 || i == 12 || i == 14 || i == 15) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        public CopyConfiguration() {
            this.owner = PropertyDescriptorImpl.this.getContainingDeclaration();
            this.modality = PropertyDescriptorImpl.this.getModality();
            this.visibility = PropertyDescriptorImpl.this.getVisibility();
            this.kind = PropertyDescriptorImpl.this.getKind();
            this.substitution = TypeSubstitution.EMPTY;
            this.copyOverrides = true;
            this.dispatchReceiverParameter = PropertyDescriptorImpl.this.dispatchReceiverParameter;
            this.newTypeParameters = null;
            this.name = PropertyDescriptorImpl.this.getName();
        }

        public CopyConfiguration setOwner(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(0);
            }
            this.owner = declarationDescriptor;
            return this;
        }

        public CopyConfiguration setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
            this.original = (PropertyDescriptor) callableMemberDescriptor;
            return this;
        }

        public CopyConfiguration setModality(Modality modality2) {
            if (modality2 == null) {
                $$$reportNull$$$0(4);
            }
            this.modality = modality2;
            return this;
        }

        public CopyConfiguration setVisibility(Visibility visibility2) {
            if (visibility2 == null) {
                $$$reportNull$$$0(6);
            }
            this.visibility = visibility2;
            return this;
        }

        public CopyConfiguration setKind(CallableMemberDescriptor.Kind kind2) {
            if (kind2 == null) {
                $$$reportNull$$$0(8);
            }
            this.kind = kind2;
            return this;
        }

        public CopyConfiguration setSubstitution(TypeSubstitution typeSubstitution) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(13);
            }
            this.substitution = typeSubstitution;
            return this;
        }

        public CopyConfiguration setCopyOverrides(boolean z) {
            this.copyOverrides = z;
            return this;
        }

        public PropertyDescriptor build() {
            return PropertyDescriptorImpl.this.doSubstitute(this);
        }

        /* access modifiers changed from: package-private */
        public PropertyGetterDescriptor getOriginalGetter() {
            PropertyDescriptor propertyDescriptor = this.original;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getGetter();
        }

        /* access modifiers changed from: package-private */
        public PropertySetterDescriptor getOriginalSetter() {
            PropertyDescriptor propertyDescriptor = this.original;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getSetter();
        }
    }

    public CopyConfiguration newCopyBuilder() {
        return new CopyConfiguration();
    }

    private SourceElement getSourceToUseForCopy(boolean z, PropertyDescriptor propertyDescriptor) {
        SourceElement sourceElement;
        if (z) {
            if (propertyDescriptor == null) {
                propertyDescriptor = getOriginal();
            }
            sourceElement = propertyDescriptor.getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(23);
        }
        return sourceElement;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public PropertyDescriptor doSubstitute(CopyConfiguration copyConfiguration) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl;
        if (copyConfiguration == null) {
            $$$reportNull$$$0(24);
        }
        PropertyDescriptorImpl createSubstitutedCopy = createSubstitutedCopy(copyConfiguration.owner, copyConfiguration.modality, copyConfiguration.visibility, copyConfiguration.original, copyConfiguration.kind, copyConfiguration.name, getSourceToUseForCopy(copyConfiguration.preserveSourceElement, copyConfiguration.original));
        List<TypeParameterDescriptor> typeParameters2 = copyConfiguration.newTypeParameters == null ? getTypeParameters() : copyConfiguration.newTypeParameters;
        ArrayList arrayList = new ArrayList(typeParameters2.size());
        TypeSubstitutor substituteTypeParameters = DescriptorSubstitutor.substituteTypeParameters(typeParameters2, copyConfiguration.substitution, createSubstitutedCopy, arrayList);
        KotlinType substitute = substituteTypeParameters.substitute(getType(), Variance.OUT_VARIANCE);
        FieldDescriptorImpl fieldDescriptorImpl = null;
        if (substitute == null) {
            return null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = copyConfiguration.dispatchReceiverParameter;
        if (receiverParameterDescriptor2 != 0) {
            receiverParameterDescriptor = receiverParameterDescriptor2.substitute(substituteTypeParameters);
            if (receiverParameterDescriptor == null) {
                return null;
            }
        } else {
            receiverParameterDescriptor = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor3 = this.extensionReceiverParameter;
        if (receiverParameterDescriptor3 != null) {
            KotlinType substitute2 = substituteTypeParameters.substitute(receiverParameterDescriptor3.getType(), Variance.IN_VARIANCE);
            if (substitute2 == null) {
                return null;
            }
            receiverParameterDescriptorImpl = new ReceiverParameterDescriptorImpl(createSubstitutedCopy, new ExtensionReceiver(createSubstitutedCopy, substitute2, this.extensionReceiverParameter.getValue()), this.extensionReceiverParameter.getAnnotations());
        } else {
            receiverParameterDescriptorImpl = null;
        }
        createSubstitutedCopy.setType(substitute, arrayList, receiverParameterDescriptor, receiverParameterDescriptorImpl);
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.getter == null ? null : new PropertyGetterDescriptorImpl(createSubstitutedCopy, this.getter.getAnnotations(), copyConfiguration.modality, normalizeVisibility(this.getter.getVisibility(), copyConfiguration.kind), this.getter.isDefault(), this.getter.isExternal(), this.getter.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalGetter(), SourceElement.NO_SOURCE);
        if (propertyGetterDescriptorImpl != null) {
            KotlinType returnType = this.getter.getReturnType();
            propertyGetterDescriptorImpl.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(substituteTypeParameters, this.getter));
            propertyGetterDescriptorImpl.initialize(returnType != null ? substituteTypeParameters.substitute(returnType, Variance.OUT_VARIANCE) : null);
        }
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = this.setter == null ? null : new PropertySetterDescriptorImpl(createSubstitutedCopy, this.setter.getAnnotations(), copyConfiguration.modality, normalizeVisibility(this.setter.getVisibility(), copyConfiguration.kind), this.setter.isDefault(), this.setter.isExternal(), this.setter.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalSetter(), SourceElement.NO_SOURCE);
        if (propertySetterDescriptorImpl != null) {
            List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(propertySetterDescriptorImpl, this.setter.getValueParameters(), substituteTypeParameters, false, false, null);
            if (substitutedValueParameters == null) {
                createSubstitutedCopy.setSetterProjectedOut(true);
                substitutedValueParameters = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(propertySetterDescriptorImpl, DescriptorUtilsKt.getBuiltIns(copyConfiguration.owner).getNothingType(), this.setter.getValueParameters().get(0).getAnnotations()));
            }
            if (substitutedValueParameters.size() == 1) {
                propertySetterDescriptorImpl.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(substituteTypeParameters, this.setter));
                propertySetterDescriptorImpl.initialize(substitutedValueParameters.get(0));
            } else {
                throw new IllegalStateException();
            }
        }
        FieldDescriptor fieldDescriptor = this.backingField;
        FieldDescriptorImpl fieldDescriptorImpl2 = fieldDescriptor == null ? null : new FieldDescriptorImpl(fieldDescriptor.getAnnotations(), createSubstitutedCopy);
        FieldDescriptor fieldDescriptor2 = this.delegateField;
        if (fieldDescriptor2 != null) {
            fieldDescriptorImpl = new FieldDescriptorImpl(fieldDescriptor2.getAnnotations(), createSubstitutedCopy);
        }
        createSubstitutedCopy.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, fieldDescriptorImpl2, fieldDescriptorImpl);
        if (copyConfiguration.copyOverrides) {
            SmartSet create = SmartSet.create();
            for (PropertyDescriptor propertyDescriptor : getOverriddenDescriptors()) {
                create.add(propertyDescriptor.substitute(substituteTypeParameters));
            }
            createSubstitutedCopy.setOverriddenDescriptors(create);
        }
        if (isConst() && this.compileTimeInitializer != null) {
            createSubstitutedCopy.setCompileTimeInitializer(this.compileTimeInitializer);
        }
        return createSubstitutedCopy;
    }

    private static Visibility normalizeVisibility(Visibility visibility2, CallableMemberDescriptor.Kind kind2) {
        return (kind2 != CallableMemberDescriptor.Kind.FAKE_OVERRIDE || !Visibilities.isPrivate(visibility2.normalize())) ? visibility2 : Visibilities.INVISIBLE_FAKE;
    }

    private static FunctionDescriptor getSubstitutedInitialSignatureDescriptor(TypeSubstitutor typeSubstitutor, PropertyAccessorDescriptor propertyAccessorDescriptor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(25);
        }
        if (propertyAccessorDescriptor == null) {
            $$$reportNull$$$0(26);
        }
        if (propertyAccessorDescriptor.getInitialSignatureDescriptor() != null) {
            return propertyAccessorDescriptor.getInitialSignatureDescriptor().substitute(typeSubstitutor);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public PropertyDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, Modality modality2, Visibility visibility2, PropertyDescriptor propertyDescriptor, CallableMemberDescriptor.Kind kind2, Name name, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(27);
        }
        if (modality2 == null) {
            $$$reportNull$$$0(28);
        }
        if (visibility2 == null) {
            $$$reportNull$$$0(29);
        }
        if (kind2 == null) {
            $$$reportNull$$$0(30);
        }
        if (name == null) {
            $$$reportNull$$$0(31);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(32);
        }
        return new PropertyDescriptorImpl(declarationDescriptor, propertyDescriptor, getAnnotations(), modality2, visibility2, isVar(), name, kind2, sourceElement, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertyDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.original;
        PropertyDescriptor original2 = propertyDescriptor == this ? this : propertyDescriptor.getOriginal();
        if (original2 == null) {
            $$$reportNull$$$0(33);
        }
        return original2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind2 = this.kind;
        if (kind2 == null) {
            $$$reportNull$$$0(34);
        }
        return kind2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.isExpect;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.isActual;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public FieldDescriptor getBackingField() {
        return this.backingField;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public FieldDescriptor getDelegateField() {
        return this.delegateField;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            $$$reportNull$$$0(35);
        }
        this.overriddenProperties = collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> collection = this.overriddenProperties;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            $$$reportNull$$$0(36);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public PropertyDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality2, Visibility visibility2, CallableMemberDescriptor.Kind kind2, boolean z) {
        PropertyDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setOriginal(null).setModality(modality2).setVisibility(visibility2).setKind(kind2).setCopyOverrides(z).build();
        if (build == null) {
            $$$reportNull$$$0(37);
        }
        return build;
    }
}
