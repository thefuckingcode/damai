package tb;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class t60 extends AbstractTypeAliasDescriptor implements DeserializedMemberDescriptor {
    @NotNull
    private final StorageManager h;
    @NotNull
    private final ProtoBuf$TypeAlias i;
    @NotNull
    private final NameResolver j;
    @NotNull
    private final ap2 k;
    @NotNull
    private final fv2 l;
    @Nullable
    private final DeserializedContainerSource m;
    private Collection<? extends TypeAliasConstructorDescriptor> n;
    private ib2 o;
    private ib2 p;
    private List<? extends TypeParameterDescriptor> q;
    private ib2 r;
    @NotNull
    private DeserializedMemberDescriptor.CoroutinesCompatibilityMode s = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;

    /* JADX WARNING: Illegal instructions before constructor call */
    public t60(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull h60 h60, @NotNull ProtoBuf$TypeAlias protoBuf$TypeAlias, @NotNull NameResolver nameResolver, @NotNull ap2 ap2, @NotNull fv2 fv2, @Nullable DeserializedContainerSource deserializedContainerSource) {
        super(declarationDescriptor, annotations, og1, r4, h60);
        k21.i(storageManager, "storageManager");
        k21.i(declarationDescriptor, "containingDeclaration");
        k21.i(annotations, "annotations");
        k21.i(og1, "name");
        k21.i(h60, "visibility");
        k21.i(protoBuf$TypeAlias, "proto");
        k21.i(nameResolver, "nameResolver");
        k21.i(ap2, "typeTable");
        k21.i(fv2, "versionRequirementTable");
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        k21.h(sourceElement, "NO_SOURCE");
        this.h = storageManager;
        this.i = protoBuf$TypeAlias;
        this.j = nameResolver;
        this.k = ap2;
        this.l = fv2;
        this.m = deserializedContainerSource;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> */
    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    @NotNull
    public List<TypeParameterDescriptor> g() {
        List list = this.q;
        if (list != null) {
            return list;
        }
        k21.A("typeConstructorParameters");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    @Nullable
    public ClassDescriptor getClassDescriptor() {
        if (h61.a(getExpandedType())) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = getExpandedType().c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @Nullable
    public DeserializedContainerSource getContainerSource() {
        return this.m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public ib2 getDefaultType() {
        ib2 ib2 = this.r;
        if (ib2 != null) {
            return ib2;
        }
        k21.A("defaultTypeImpl");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    @NotNull
    public ib2 getExpandedType() {
        ib2 ib2 = this.p;
        if (ib2 != null) {
            return ib2;
        }
        k21.A("expandedType");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public NameResolver getNameResolver() {
        return this.j;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    @NotNull
    public StorageManager getStorageManager() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public ap2 getTypeTable() {
        return this.k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    @NotNull
    public ib2 getUnderlyingType() {
        ib2 ib2 = this.o;
        if (ib2 != null) {
            return ib2;
        }
        k21.A("underlyingType");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public fv2 getVersionRequirementTable() {
        return this.l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public List<ev2> getVersionRequirements() {
        return DeserializedMemberDescriptor.a.a(this);
    }

    @NotNull
    public DeserializedMemberDescriptor.CoroutinesCompatibilityMode i() {
        return this.s;
    }

    @NotNull
    /* renamed from: j */
    public ProtoBuf$TypeAlias getProto() {
        return this.i;
    }

    public final void k(@NotNull List<? extends TypeParameterDescriptor> list, @NotNull ib2 ib2, @NotNull ib2 ib22, @NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        k21.i(list, "declaredTypeParameters");
        k21.i(ib2, "underlyingType");
        k21.i(ib22, "expandedType");
        k21.i(coroutinesCompatibilityMode, "isExperimentalCoroutineInReleaseEnvironment");
        h(list);
        this.o = ib2;
        this.p = ib22;
        this.q = TypeParameterUtilsKt.d(this);
        this.r = d();
        this.n = f();
        this.s = coroutinesCompatibilityMode;
    }

    @NotNull
    /* renamed from: l */
    public TypeAliasDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        k21.i(typeSubstitutor, "substitutor");
        if (typeSubstitutor.k()) {
            return this;
        }
        StorageManager storageManager = getStorageManager();
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        k21.h(containingDeclaration, "containingDeclaration");
        Annotations annotations = getAnnotations();
        k21.h(annotations, "annotations");
        og1 name = getName();
        k21.h(name, "name");
        t60 t60 = new t60(storageManager, containingDeclaration, annotations, name, getVisibility(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
        List<TypeParameterDescriptor> declaredTypeParameters = getDeclaredTypeParameters();
        ib2 underlyingType = getUnderlyingType();
        Variance variance = Variance.INVARIANT;
        g61 n2 = typeSubstitutor.n(underlyingType, variance);
        k21.h(n2, "substitutor.safeSubstitute(underlyingType, Variance.INVARIANT)");
        ib2 a = yo2.a(n2);
        g61 n3 = typeSubstitutor.n(getExpandedType(), variance);
        k21.h(n3, "substitutor.safeSubstitute(expandedType, Variance.INVARIANT)");
        t60.k(declaredTypeParameters, a, yo2.a(n3), i());
        return t60;
    }
}
