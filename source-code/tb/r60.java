package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class r60 extends bv1 implements DeserializedCallableMemberDescriptor {
    @NotNull
    private final ProtoBuf$Property A;
    @NotNull
    private final NameResolver B;
    @NotNull
    private final ap2 C;
    @NotNull
    private final fv2 D;
    @Nullable
    private final DeserializedContainerSource E;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r60(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull h60 h60, boolean z, @NotNull og1 og1, @NotNull CallableMemberDescriptor.Kind kind, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, @NotNull ProtoBuf$Property protoBuf$Property, @NotNull NameResolver nameResolver, @NotNull ap2 ap2, @NotNull fv2 fv2, @Nullable DeserializedContainerSource deserializedContainerSource) {
        super(declarationDescriptor, propertyDescriptor, annotations, modality, h60, z, og1, kind, SourceElement.NO_SOURCE, z2, z3, z6, false, z4, z5);
        k21.i(declarationDescriptor, "containingDeclaration");
        k21.i(annotations, "annotations");
        k21.i(modality, "modality");
        k21.i(h60, "visibility");
        k21.i(og1, "name");
        k21.i(kind, "kind");
        k21.i(protoBuf$Property, "proto");
        k21.i(nameResolver, "nameResolver");
        k21.i(ap2, "typeTable");
        k21.i(fv2, "versionRequirementTable");
        this.A = protoBuf$Property;
        this.B = nameResolver;
        this.C = ap2;
        this.D = fv2;
        this.E = deserializedContainerSource;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @Nullable
    public DeserializedContainerSource getContainerSource() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public NameResolver getNameResolver() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public ap2 getTypeTable() {
        return this.C;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public fv2 getVersionRequirementTable() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @NotNull
    public List<ev2> getVersionRequirements() {
        return DeserializedCallableMemberDescriptor.a.a(this);
    }

    /* access modifiers changed from: protected */
    @Override // tb.bv1
    @NotNull
    public bv1 i(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull h60 h60, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull og1 og1, @NotNull SourceElement sourceElement) {
        k21.i(declarationDescriptor, "newOwner");
        k21.i(modality, "newModality");
        k21.i(h60, "newVisibility");
        k21.i(kind, "kind");
        k21.i(og1, "newName");
        k21.i(sourceElement, "source");
        return new r60(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, h60, isVar(), og1, kind, isLateInit(), isConst(), isExternal(), isDelegated(), isExpect(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
    }

    @Override // tb.bv1, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        Boolean g = bj0.IS_EXTERNAL_PROPERTY.d(getProto().getFlags());
        k21.h(g, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return g.booleanValue();
    }

    @NotNull
    /* renamed from: v */
    public ProtoBuf$Property getProto() {
        return this.A;
    }

    public final void w(@Nullable cv1 cv1, @Nullable PropertySetterDescriptor propertySetterDescriptor, @Nullable FieldDescriptor fieldDescriptor, @Nullable FieldDescriptor fieldDescriptor2, @NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        k21.i(coroutinesCompatibilityMode, "isExperimentalCoroutineInReleaseEnvironment");
        super.o(cv1, propertySetterDescriptor, fieldDescriptor, fieldDescriptor2);
        ur2 ur2 = ur2.INSTANCE;
    }
}
