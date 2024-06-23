package tb;

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
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class s60 extends fb2 implements DeserializedCallableMemberDescriptor {
    @NotNull
    private final ProtoBuf$Function D;
    @NotNull
    private final NameResolver E;
    @NotNull
    private final ap2 F;
    @NotNull
    private final fv2 G;
    @Nullable
    private final DeserializedContainerSource H;
    @NotNull
    private DeserializedMemberDescriptor.CoroutinesCompatibilityMode I;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s60(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations annotations, og1 og1, CallableMemberDescriptor.Kind kind, ProtoBuf$Function protoBuf$Function, NameResolver nameResolver, ap2 ap2, fv2 fv2, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement, int i, m40 m40) {
        this(declarationDescriptor, simpleFunctionDescriptor, annotations, og1, kind, protoBuf$Function, nameResolver, ap2, fv2, deserializedContainerSource, (i & 1024) != 0 ? null : sourceElement);
    }

    @NotNull
    public DeserializedMemberDescriptor.CoroutinesCompatibilityMode J() {
        return this.I;
    }

    @NotNull
    /* renamed from: K */
    public ProtoBuf$Function getProto() {
        return this.D;
    }

    @NotNull
    public final fb2 L(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull List<? extends ValueParameterDescriptor> list2, @Nullable g61 g61, @Nullable Modality modality, @NotNull h60 h60, @NotNull Map<? extends CallableDescriptor.UserDataKey<?>, ?> map, @NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        k21.i(list, "typeParameters");
        k21.i(list2, "unsubstitutedValueParameters");
        k21.i(h60, "visibility");
        k21.i(map, "userDataMap");
        k21.i(coroutinesCompatibilityMode, "isExperimentalCoroutineInReleaseEnvironment");
        fb2 I2 = super.I(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, g61, modality, h60, map);
        k21.h(I2, "super.initialize(\n            extensionReceiverParameter,\n            dispatchReceiverParameter,\n            typeParameters,\n            unsubstitutedValueParameters,\n            unsubstitutedReturnType,\n            modality,\n            visibility,\n            userDataMap\n        )");
        this.I = coroutinesCompatibilityMode;
        return I2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, tb.fb2
    @NotNull
    public a f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable og1 og1, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        og1 og12;
        k21.i(declarationDescriptor, "newOwner");
        k21.i(kind, "kind");
        k21.i(annotations, "annotations");
        k21.i(sourceElement, "source");
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (og1 == null) {
            og1 name = getName();
            k21.h(name, "name");
            og12 = name;
        } else {
            og12 = og1;
        }
        s60 s60 = new s60(declarationDescriptor, simpleFunctionDescriptor, annotations, og12, kind, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), sourceElement);
        s60.s(k());
        s60.I = J();
        return s60;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @Nullable
    public DeserializedContainerSource getContainerSource() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public NameResolver getNameResolver() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public ap2 getTypeTable() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public fv2 getVersionRequirementTable() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public List<ev2> getVersionRequirements() {
        return DeserializedCallableMemberDescriptor.a.a(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s60(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable SimpleFunctionDescriptor simpleFunctionDescriptor, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull CallableMemberDescriptor.Kind kind, @NotNull ProtoBuf$Function protoBuf$Function, @NotNull NameResolver nameResolver, @NotNull ap2 ap2, @NotNull fv2 fv2, @Nullable DeserializedContainerSource deserializedContainerSource, @Nullable SourceElement sourceElement) {
        super(declarationDescriptor, simpleFunctionDescriptor, annotations, og1, kind, sourceElement == null ? SourceElement.NO_SOURCE : sourceElement);
        k21.i(declarationDescriptor, "containingDeclaration");
        k21.i(annotations, "annotations");
        k21.i(og1, "name");
        k21.i(kind, "kind");
        k21.i(protoBuf$Function, "proto");
        k21.i(nameResolver, "nameResolver");
        k21.i(ap2, "typeTable");
        k21.i(fv2, "versionRequirementTable");
        this.D = protoBuf$Function;
        this.E = nameResolver;
        this.F = ap2;
        this.G = fv2;
        this.H = deserializedContainerSource;
        this.I = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }
}
