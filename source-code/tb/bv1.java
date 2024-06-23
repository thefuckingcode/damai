package tb;

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
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.c;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class bv1 extends c implements PropertyDescriptor {
    private final Modality h;
    private h60 i;
    private Collection<? extends PropertyDescriptor> j;
    private final PropertyDescriptor k;
    private final CallableMemberDescriptor.Kind l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private ReceiverParameterDescriptor s;
    private ReceiverParameterDescriptor t;
    private List<TypeParameterDescriptor> u;
    private cv1 v;
    private PropertySetterDescriptor w;
    private boolean x;
    private FieldDescriptor y;
    private FieldDescriptor z;

    /* compiled from: Taobao */
    public class a {
        private DeclarationDescriptor a;
        private Modality b;
        private h60 c;
        private PropertyDescriptor d = null;
        private boolean e = false;
        private CallableMemberDescriptor.Kind f;
        private xo2 g;
        private boolean h;
        private ReceiverParameterDescriptor i;
        private List<TypeParameterDescriptor> j;
        private og1 k;
        private g61 l;

        public a() {
            this.a = bv1.this.getContainingDeclaration();
            this.b = bv1.this.getModality();
            this.c = bv1.this.getVisibility();
            this.f = bv1.this.getKind();
            this.g = xo2.EMPTY;
            this.h = true;
            this.i = bv1.this.s;
            this.j = null;
            this.k = bv1.this.getName();
            this.l = bv1.this.getType();
        }

        private static /* synthetic */ void a(int i2) {
            String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? 2 : 3)];
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i2 == 1) {
                objArr[1] = "setOwner";
            } else if (i2 == 2) {
                objArr[1] = "setOriginal";
            } else if (i2 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i2 == 5) {
                objArr[1] = "setReturnType";
            } else if (i2 == 7) {
                objArr[1] = "setModality";
            } else if (i2 == 9) {
                objArr[1] = "setVisibility";
            } else if (i2 == 11) {
                objArr[1] = "setKind";
            } else if (i2 == 19) {
                objArr[1] = "setName";
            } else if (i2 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i2 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i2 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i2 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @Nullable
        public PropertyDescriptor n() {
            return bv1.this.j(this);
        }

        /* access modifiers changed from: package-private */
        public PropertyGetterDescriptor o() {
            PropertyDescriptor propertyDescriptor = this.d;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getGetter();
        }

        /* access modifiers changed from: package-private */
        public PropertySetterDescriptor p() {
            PropertyDescriptor propertyDescriptor = this.d;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getSetter();
        }

        @NotNull
        public a q(boolean z) {
            this.h = z;
            return this;
        }

        @NotNull
        public a r(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                a(10);
            }
            this.f = kind;
            return this;
        }

        @NotNull
        public a s(@NotNull Modality modality) {
            if (modality == null) {
                a(6);
            }
            this.b = modality;
            return this;
        }

        @NotNull
        public a t(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.d = (PropertyDescriptor) callableMemberDescriptor;
            return this;
        }

        @NotNull
        public a u(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                a(0);
            }
            this.a = declarationDescriptor;
            return this;
        }

        @NotNull
        public a v(@NotNull xo2 xo2) {
            if (xo2 == null) {
                a(15);
            }
            this.g = xo2;
            return this;
        }

        @NotNull
        public a w(@NotNull h60 h60) {
            if (h60 == null) {
                a(8);
            }
            this.c = h60;
            return this;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected bv1(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull h60 h60, boolean z2, @NotNull og1 og1, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        super(declarationDescriptor, annotations, og1, null, z2, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (modality == null) {
            a(2);
        }
        if (h60 == null) {
            a(3);
        }
        if (og1 == null) {
            a(4);
        }
        if (kind == null) {
            a(5);
        }
        if (sourceElement == null) {
            a(6);
        }
        this.j = null;
        this.h = modality;
        this.i = h60;
        this.k = propertyDescriptor == null ? this : propertyDescriptor;
        this.l = kind;
        this.m = z3;
        this.n = z4;
        this.o = z5;
        this.p = z6;
        this.q = z7;
        this.r = z8;
    }

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
    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        if (!(i2 == 23 || i2 == 33 || i2 == 34 || i2 == 36 || i2 == 37)) {
            switch (i2) {
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
            if (!(i2 == 23 || i2 == 33 || i2 == 34 || i2 == 36 || i2 == 37)) {
                switch (i2) {
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        break;
                    default:
                        i3 = 3;
                        break;
                }
                Object[] objArr = new Object[i3];
                switch (i2) {
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
                        objArr[0] = "name";
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
                if (i2 == 23) {
                    objArr[1] = "getSourceToUseForCopy";
                } else if (i2 == 33) {
                    objArr[1] = "getOriginal";
                } else if (i2 == 34) {
                    objArr[1] = "getKind";
                } else if (i2 == 36) {
                    objArr[1] = "getOverriddenDescriptors";
                } else if (i2 != 37) {
                    switch (i2) {
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
                    objArr[1] = by0.ARG_COPY;
                }
                switch (i2) {
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
                if (!(i2 == 23 || i2 == 33 || i2 == 34 || i2 == 36 || i2 == 37)) {
                    switch (i2) {
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
            i3 = 2;
            Object[] objArr2 = new Object[i3];
            switch (i2) {
            }
            if (i2 == 23) {
            }
            switch (i2) {
            }
            String format2 = String.format(str, objArr2);
            switch (i2) {
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        switch (i2) {
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                i3 = 2;
                break;
        }
        Object[] objArr22 = new Object[i3];
        switch (i2) {
        }
        if (i2 == 23) {
        }
        switch (i2) {
        }
        String format22 = String.format(str, objArr22);
        switch (i2) {
        }
        throw new IllegalStateException(format22);
    }

    @NotNull
    public static bv1 h(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull h60 h60, boolean z2, @NotNull og1 og1, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        if (declarationDescriptor == null) {
            a(7);
        }
        if (annotations == null) {
            a(8);
        }
        if (modality == null) {
            a(9);
        }
        if (h60 == null) {
            a(10);
        }
        if (og1 == null) {
            a(11);
        }
        if (kind == null) {
            a(12);
        }
        if (sourceElement == null) {
            a(13);
        }
        return new bv1(declarationDescriptor, null, annotations, modality, h60, z2, og1, kind, sourceElement, z3, z4, z5, z6, z7, z8);
    }

    @NotNull
    private SourceElement l(boolean z2, @Nullable PropertyDescriptor propertyDescriptor) {
        SourceElement sourceElement;
        if (z2) {
            if (propertyDescriptor == null) {
                propertyDescriptor = getOriginal();
            }
            sourceElement = propertyDescriptor.getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        if (sourceElement == null) {
            a(23);
        }
        return sourceElement;
    }

    private static FunctionDescriptor m(@NotNull TypeSubstitutor typeSubstitutor, @NotNull PropertyAccessorDescriptor propertyAccessorDescriptor) {
        if (typeSubstitutor == null) {
            a(25);
        }
        if (propertyAccessorDescriptor == null) {
            a(26);
        }
        if (propertyAccessorDescriptor.getInitialSignatureDescriptor() != null) {
            return propertyAccessorDescriptor.getInitialSignatureDescriptor().substitute(typeSubstitutor);
        }
        return null;
    }

    private static h60 r(h60 h60, CallableMemberDescriptor.Kind kind) {
        return (kind != CallableMemberDescriptor.Kind.FAKE_OVERRIDE || !g60.g(h60.f())) ? h60 : g60.INVISIBLE_FAKE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertyDescriptor(this, d);
    }

    @NotNull
    /* renamed from: g */
    public PropertyDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, h60 h60, CallableMemberDescriptor.Kind kind, boolean z2) {
        PropertyDescriptor n2 = q().u(declarationDescriptor).t(null).s(modality).w(h60).r(kind).q(z2).n();
        if (n2 == null) {
            a(37);
        }
        return n2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @NotNull
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList arrayList = new ArrayList(2);
        cv1 cv1 = this.v;
        if (cv1 != null) {
            arrayList.add(cv1);
        }
        PropertySetterDescriptor propertySetterDescriptor = this.w;
        if (propertySetterDescriptor != null) {
            arrayList.add(propertySetterDescriptor);
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public FieldDescriptor getBackingField() {
        return this.y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public FieldDescriptor getDelegateField() {
        return this.z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.b
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.b
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.l;
        if (kind == null) {
            a(34);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = this.h;
        if (modality == null) {
            a(19);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> collection = this.j;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            a(36);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.b
    @NotNull
    public g61 getReturnType() {
        g61 type = getType();
        if (type == null) {
            a(18);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public PropertySetterDescriptor getSetter() {
        return this.w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.b
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.u;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.b
    @Nullable
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public h60 getVisibility() {
        h60 h60 = this.i;
        if (h60 == null) {
            a(20);
        }
        return h60;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public bv1 i(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull h60 h60, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull og1 og1, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(27);
        }
        if (modality == null) {
            a(28);
        }
        if (h60 == null) {
            a(29);
        }
        if (kind == null) {
            a(30);
        }
        if (og1 == null) {
            a(31);
        }
        if (sourceElement == null) {
            a(32);
        }
        return new bv1(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, h60, isVar(), og1, kind, sourceElement, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public boolean isDelegated() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return this.m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Nullable
    public PropertyDescriptor j(@NotNull a aVar) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        lx1 lx1;
        NullableLazyValue<om<?>> nullableLazyValue;
        if (aVar == null) {
            a(24);
        }
        bv1 i2 = i(aVar.a, aVar.b, aVar.c, aVar.d, aVar.f, aVar.k, l(aVar.e, aVar.d));
        List<TypeParameterDescriptor> typeParameters = aVar.j == null ? getTypeParameters() : aVar.j;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor b = d60.b(typeParameters, aVar.g, i2, arrayList);
        g61 g61 = aVar.l;
        Variance variance = Variance.OUT_VARIANCE;
        g61 q2 = b.q(g61, variance);
        lh0 lh0 = null;
        if (q2 == null) {
            return null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = aVar.i;
        if (receiverParameterDescriptor2 != 0) {
            receiverParameterDescriptor = receiverParameterDescriptor2.substitute(b);
            if (receiverParameterDescriptor == null) {
                return null;
            }
        } else {
            receiverParameterDescriptor = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor3 = this.t;
        if (receiverParameterDescriptor3 != null) {
            g61 q3 = b.q(receiverParameterDescriptor3.getType(), Variance.IN_VARIANCE);
            if (q3 == null) {
                return null;
            }
            lx1 = new lx1(i2, new gg0(i2, q3, this.t.getValue()), this.t.getAnnotations());
        } else {
            lx1 = null;
        }
        i2.t(q2, arrayList, receiverParameterDescriptor, lx1);
        cv1 cv1 = this.v == null ? null : new cv1(i2, this.v.getAnnotations(), aVar.b, r(this.v.getVisibility(), aVar.f), this.v.isDefault(), this.v.isExternal(), this.v.isInline(), aVar.f, aVar.o(), SourceElement.NO_SOURCE);
        if (cv1 != null) {
            g61 returnType = this.v.getReturnType();
            cv1.h(m(b, this.v));
            cv1.k(returnType != null ? b.q(returnType, variance) : null);
        }
        dv1 dv1 = this.w == null ? null : new dv1(i2, this.w.getAnnotations(), aVar.b, r(this.w.getVisibility(), aVar.f), this.w.isDefault(), this.w.isExternal(), this.w.isInline(), aVar.f, aVar.p(), SourceElement.NO_SOURCE);
        if (dv1 != null) {
            List<ValueParameterDescriptor> j2 = kotlin.reflect.jvm.internal.impl.descriptors.impl.a.j(dv1, this.w.getValueParameters(), b, false, false, null);
            if (j2 == null) {
                i2.s(true);
                j2 = Collections.singletonList(dv1.j(dv1, DescriptorUtilsKt.g(aVar.a).H(), this.w.getValueParameters().get(0).getAnnotations()));
            }
            if (j2.size() == 1) {
                dv1.h(m(b, this.w));
                dv1.l(j2.get(0));
            } else {
                throw new IllegalStateException();
            }
        }
        FieldDescriptor fieldDescriptor = this.y;
        lh0 lh02 = fieldDescriptor == null ? null : new lh0(fieldDescriptor.getAnnotations(), i2);
        FieldDescriptor fieldDescriptor2 = this.z;
        if (fieldDescriptor2 != null) {
            lh0 = new lh0(fieldDescriptor2.getAnnotations(), i2);
        }
        i2.o(cv1, dv1, lh02, lh0);
        if (aVar.h) {
            bc2 a2 = bc2.a();
            for (PropertyDescriptor propertyDescriptor : getOverriddenDescriptors()) {
                a2.add(propertyDescriptor.substitute(b));
            }
            i2.setOverriddenDescriptors(a2);
        }
        if (isConst() && (nullableLazyValue = this.g) != null) {
            i2.e(nullableLazyValue);
        }
        return i2;
    }

    @Nullable
    /* renamed from: k */
    public cv1 getGetter() {
        return this.v;
    }

    public void n(@Nullable cv1 cv1, @Nullable PropertySetterDescriptor propertySetterDescriptor) {
        o(cv1, propertySetterDescriptor, null, null);
    }

    public void o(@Nullable cv1 cv1, @Nullable PropertySetterDescriptor propertySetterDescriptor, @Nullable FieldDescriptor fieldDescriptor, @Nullable FieldDescriptor fieldDescriptor2) {
        this.v = cv1;
        this.w = propertySetterDescriptor;
        this.y = fieldDescriptor;
        this.z = fieldDescriptor2;
    }

    public boolean p() {
        return this.x;
    }

    @NotNull
    public a q() {
        return new a();
    }

    public void s(boolean z2) {
        this.x = z2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            a(35);
        }
        this.j = collection;
    }

    public void t(@NotNull g61 g61, @NotNull List<? extends TypeParameterDescriptor> list, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2) {
        if (g61 == null) {
            a(14);
        }
        if (list == null) {
            a(15);
        }
        d(g61);
        this.u = new ArrayList(list);
        this.t = receiverParameterDescriptor2;
        this.s = receiverParameterDescriptor;
    }

    public void u(@NotNull h60 h60) {
        if (h60 == null) {
            a(16);
        }
        this.i = h60;
    }

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public CallableDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            a(22);
        }
        if (typeSubstitutor.k()) {
            return this;
        }
        return q().v(typeSubstitutor.j()).t(getOriginal()).n();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, tb.w30, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, tb.v30
    @NotNull
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.k;
        PropertyDescriptor original = propertyDescriptor == this ? this : propertyDescriptor.getOriginal();
        if (original == null) {
            a(33);
        }
        return original;
    }
}
