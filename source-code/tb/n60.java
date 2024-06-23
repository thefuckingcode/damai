package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class n60 extends ki implements DeserializedCallableMemberDescriptor {
    @NotNull
    private final ProtoBuf$Constructor F;
    @NotNull
    private final NameResolver G;
    @NotNull
    private final ap2 H;
    @NotNull
    private final fv2 I;
    @Nullable
    private final DeserializedContainerSource J;
    @NotNull
    private DeserializedMemberDescriptor.CoroutinesCompatibilityMode K;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n60(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations annotations, boolean z, CallableMemberDescriptor.Kind kind, ProtoBuf$Constructor protoBuf$Constructor, NameResolver nameResolver, ap2 ap2, fv2 fv2, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement, int i, m40 m40) {
        this(classDescriptor, constructorDescriptor, annotations, z, kind, protoBuf$Constructor, nameResolver, ap2, fv2, deserializedContainerSource, (i & 1024) != 0 ? null : sourceElement);
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: L */
    public n60 f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable og1 og1, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        k21.i(declarationDescriptor, "newOwner");
        k21.i(kind, "kind");
        k21.i(annotations, "annotations");
        k21.i(sourceElement, "source");
        n60 n60 = new n60((ClassDescriptor) declarationDescriptor, (ConstructorDescriptor) functionDescriptor, annotations, this.D, kind, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), sourceElement);
        n60.s(k());
        n60.O(M());
        return n60;
    }

    @NotNull
    public DeserializedMemberDescriptor.CoroutinesCompatibilityMode M() {
        return this.K;
    }

    @NotNull
    /* renamed from: N */
    public ProtoBuf$Constructor getProto() {
        return this.F;
    }

    public void O(@NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        k21.i(coroutinesCompatibilityMode, "<set-?>");
        this.K = coroutinesCompatibilityMode;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @Nullable
    public DeserializedContainerSource getContainerSource() {
        return this.J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public NameResolver getNameResolver() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public ap2 getTypeTable() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public fv2 getVersionRequirementTable() {
        return this.I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public List<ev2> getVersionRequirements() {
        return DeserializedCallableMemberDescriptor.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n60(@NotNull ClassDescriptor classDescriptor, @Nullable ConstructorDescriptor constructorDescriptor, @NotNull Annotations annotations, boolean z, @NotNull CallableMemberDescriptor.Kind kind, @NotNull ProtoBuf$Constructor protoBuf$Constructor, @NotNull NameResolver nameResolver, @NotNull ap2 ap2, @NotNull fv2 fv2, @Nullable DeserializedContainerSource deserializedContainerSource, @Nullable SourceElement sourceElement) {
        super(classDescriptor, constructorDescriptor, annotations, z, kind, sourceElement == null ? SourceElement.NO_SOURCE : sourceElement);
        k21.i(classDescriptor, "containingDeclaration");
        k21.i(annotations, "annotations");
        k21.i(kind, "kind");
        k21.i(protoBuf$Constructor, "proto");
        k21.i(nameResolver, "nameResolver");
        k21.i(ap2, "typeTable");
        k21.i(fv2, "versionRequirementTable");
        this.F = protoBuf$Constructor;
        this.G = nameResolver;
        this.H = ap2;
        this.I = fv2;
        this.J = deserializedContainerSource;
        this.K = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }
}
