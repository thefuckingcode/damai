package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.ed2;
import tb.g61;
import tb.gj0;
import tb.h60;
import tb.ib2;
import tb.k21;
import tb.m40;
import tb.og1;
import tb.z50;

/* compiled from: Taobao */
public final class TypeAliasConstructorDescriptorImpl extends a implements TypeAliasConstructorDescriptor {
    @NotNull
    public static final a Companion = new a(null);
    static final /* synthetic */ KProperty<Object>[] H = {dz1.i(new PropertyReference1Impl(dz1.b(TypeAliasConstructorDescriptorImpl.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    @NotNull
    private final StorageManager D;
    @NotNull
    private final TypeAliasDescriptor E;
    @NotNull
    private final NullableLazyValue F;
    @NotNull
    private ClassConstructorDescriptor G;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        /* access modifiers changed from: private */
        public final TypeSubstitutor c(TypeAliasDescriptor typeAliasDescriptor) {
            if (typeAliasDescriptor.getClassDescriptor() == null) {
                return null;
            }
            return TypeSubstitutor.f(typeAliasDescriptor.getExpandedType());
        }

        @Nullable
        public final TypeAliasConstructorDescriptor b(@NotNull StorageManager storageManager, @NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull ClassConstructorDescriptor classConstructorDescriptor) {
            ClassConstructorDescriptor substitute;
            k21.i(storageManager, "storageManager");
            k21.i(typeAliasDescriptor, "typeAliasDescriptor");
            k21.i(classConstructorDescriptor, "constructor");
            TypeSubstitutor c = c(typeAliasDescriptor);
            ReceiverParameterDescriptor receiverParameterDescriptor = null;
            if (c == null || (substitute = classConstructorDescriptor.substitute(c)) == null) {
                return null;
            }
            Annotations annotations = classConstructorDescriptor.getAnnotations();
            CallableMemberDescriptor.Kind kind = classConstructorDescriptor.getKind();
            k21.h(kind, "constructor.kind");
            SourceElement source = typeAliasDescriptor.getSource();
            k21.h(source, "typeAliasDescriptor.source");
            TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = new TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, substitute, null, annotations, kind, source, null);
            List<ValueParameterDescriptor> i = a.i(typeAliasConstructorDescriptorImpl, classConstructorDescriptor.getValueParameters(), c);
            if (i == null) {
                return null;
            }
            ib2 c2 = gj0.c(substitute.getReturnType().f());
            ib2 defaultType = typeAliasDescriptor.getDefaultType();
            k21.h(defaultType, "typeAliasDescriptor.defaultType");
            ib2 j = ed2.j(c2, defaultType);
            ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor.getDispatchReceiverParameter();
            if (dispatchReceiverParameter != null) {
                receiverParameterDescriptor = z50.f(typeAliasConstructorDescriptorImpl, c.n(dispatchReceiverParameter.getType(), Variance.INVARIANT), Annotations.Companion.b());
            }
            typeAliasConstructorDescriptorImpl.l(receiverParameterDescriptor, null, typeAliasDescriptor.getDeclaredTypeParameters(), i, j, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return typeAliasConstructorDescriptorImpl;
        }
    }

    private TypeAliasConstructorDescriptorImpl(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations annotations, CallableMemberDescriptor.Kind kind, SourceElement sourceElement) {
        super(typeAliasDescriptor, typeAliasConstructorDescriptor, annotations, og1.i("<init>"), kind, sourceElement);
        this.D = storageManager;
        this.E = typeAliasDescriptor;
        p(I().isActual());
        this.F = storageManager.createNullableLazyValue(new TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(this, classConstructorDescriptor));
        this.G = classConstructorDescriptor;
    }

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations annotations, CallableMemberDescriptor.Kind kind, SourceElement sourceElement, m40 m40) {
        this(storageManager, typeAliasDescriptor, classConstructorDescriptor, typeAliasConstructorDescriptor, annotations, kind, sourceElement);
    }

    @NotNull
    /* renamed from: E */
    public TypeAliasConstructorDescriptor e(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull h60 h60, @NotNull CallableMemberDescriptor.Kind kind, boolean z) {
        k21.i(declarationDescriptor, "newOwner");
        k21.i(modality, "modality");
        k21.i(h60, "visibility");
        k21.i(kind, "kind");
        FunctionDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(h60).setKind(kind).setCopyOverrides(z).build();
        Objects.requireNonNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) build;
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: F */
    public TypeAliasConstructorDescriptorImpl f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable og1 og1, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        k21.i(declarationDescriptor, "newOwner");
        k21.i(kind, "kind");
        k21.i(annotations, "annotations");
        k21.i(sourceElement, "source");
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind != kind2) {
            CallableMemberDescriptor.Kind kind3 = CallableMemberDescriptor.Kind.SYNTHESIZED;
        }
        return new TypeAliasConstructorDescriptorImpl(this.D, I(), getUnderlyingConstructorDescriptor(), this, annotations, kind2, sourceElement);
    }

    @NotNull
    /* renamed from: G */
    public TypeAliasDescriptor getContainingDeclaration() {
        return I();
    }

    @NotNull
    /* renamed from: H */
    public TypeAliasConstructorDescriptor getOriginal() {
        return (TypeAliasConstructorDescriptor) super.getOriginal();
    }

    @NotNull
    public TypeAliasDescriptor I() {
        return this.E;
    }

    @Nullable
    /* renamed from: J */
    public TypeAliasConstructorDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        k21.i(typeSubstitutor, "substitutor");
        FunctionDescriptor substitute = super.substitute(typeSubstitutor);
        Objects.requireNonNull(substitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = (TypeAliasConstructorDescriptorImpl) substitute;
        TypeSubstitutor f = TypeSubstitutor.f(typeAliasConstructorDescriptorImpl.getReturnType());
        k21.h(f, "create(substitutedTypeAliasConstructor.returnType)");
        ClassConstructorDescriptor substitute2 = getUnderlyingConstructorDescriptor().getOriginal().substitute(f);
        if (substitute2 == null) {
            return null;
        }
        typeAliasConstructorDescriptorImpl.G = substitute2;
        return typeAliasConstructorDescriptorImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    @NotNull
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor constructedClass = getUnderlyingConstructorDescriptor().getConstructedClass();
        k21.h(constructedClass, "underlyingConstructorDescriptor.constructedClass");
        return constructedClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    @NotNull
    public g61 getReturnType() {
        g61 returnType = super.getReturnType();
        k21.f(returnType);
        return returnType;
    }

    @NotNull
    public final StorageManager getStorageManager() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor
    @NotNull
    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }
}
