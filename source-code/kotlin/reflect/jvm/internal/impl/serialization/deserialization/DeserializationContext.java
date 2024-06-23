package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionSpecificBehaviorKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.Typography;

public final class DeserializationContext {
    private final DeserializationComponents components;
    private final DeserializedContainerSource containerSource;
    private final DeclarationDescriptor containingDeclaration;
    private final MemberDeserializer memberDeserializer;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;
    private final TypeDeserializer typeDeserializer;
    private final TypeTable typeTable;
    private final VersionRequirementTable versionRequirementTable;

    public DeserializationContext(DeserializationComponents deserializationComponents, NameResolver nameResolver2, DeclarationDescriptor declarationDescriptor, TypeTable typeTable2, VersionRequirementTable versionRequirementTable2, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource, TypeDeserializer typeDeserializer2, List<ProtoBuf.TypeParameter> list) {
        String str;
        Intrinsics.checkParameterIsNotNull(deserializationComponents, "components");
        Intrinsics.checkParameterIsNotNull(nameResolver2, "nameResolver");
        Intrinsics.checkParameterIsNotNull(declarationDescriptor, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(typeTable2, "typeTable");
        Intrinsics.checkParameterIsNotNull(versionRequirementTable2, "versionRequirementTable");
        Intrinsics.checkParameterIsNotNull(binaryVersion, "metadataVersion");
        Intrinsics.checkParameterIsNotNull(list, "typeParameters");
        this.components = deserializationComponents;
        this.nameResolver = nameResolver2;
        this.containingDeclaration = declarationDescriptor;
        this.typeTable = typeTable2;
        this.versionRequirementTable = versionRequirementTable2;
        this.metadataVersion = binaryVersion;
        this.containerSource = deserializedContainerSource;
        this.typeDeserializer = new TypeDeserializer(this, typeDeserializer2, list, "Deserializer for \"" + declarationDescriptor.getName() + Typography.quote, (deserializedContainerSource == null || (str = deserializedContainerSource.getPresentableString()) == null) ? "[container not found]" : str, false, 32, null);
        this.memberDeserializer = new MemberDeserializer(this);
    }

    public final DeserializationComponents getComponents() {
        return this.components;
    }

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    public final VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    public final DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public final TypeDeserializer getTypeDeserializer() {
        return this.typeDeserializer;
    }

    public final MemberDeserializer getMemberDeserializer() {
        return this.memberDeserializer;
    }

    public final StorageManager getStorageManager() {
        return this.components.getStorageManager();
    }

    public static /* synthetic */ DeserializationContext childContext$default(DeserializationContext deserializationContext, DeclarationDescriptor declarationDescriptor, List list, NameResolver nameResolver2, TypeTable typeTable2, VersionRequirementTable versionRequirementTable2, BinaryVersion binaryVersion, int i, Object obj) {
        if ((i & 4) != 0) {
            nameResolver2 = deserializationContext.nameResolver;
        }
        if ((i & 8) != 0) {
            typeTable2 = deserializationContext.typeTable;
        }
        if ((i & 16) != 0) {
            versionRequirementTable2 = deserializationContext.versionRequirementTable;
        }
        if ((i & 32) != 0) {
            binaryVersion = deserializationContext.metadataVersion;
        }
        return deserializationContext.childContext(declarationDescriptor, list, nameResolver2, typeTable2, versionRequirementTable2, binaryVersion);
    }

    public final DeserializationContext childContext(DeclarationDescriptor declarationDescriptor, List<ProtoBuf.TypeParameter> list, NameResolver nameResolver2, TypeTable typeTable2, VersionRequirementTable versionRequirementTable2, BinaryVersion binaryVersion) {
        Intrinsics.checkParameterIsNotNull(declarationDescriptor, "descriptor");
        Intrinsics.checkParameterIsNotNull(list, "typeParameterProtos");
        Intrinsics.checkParameterIsNotNull(nameResolver2, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable2, "typeTable");
        VersionRequirementTable versionRequirementTable3 = versionRequirementTable2;
        Intrinsics.checkParameterIsNotNull(versionRequirementTable3, "versionRequirementTable");
        Intrinsics.checkParameterIsNotNull(binaryVersion, "metadataVersion");
        DeserializationComponents deserializationComponents = this.components;
        if (!VersionSpecificBehaviorKt.isVersionRequirementTableWrittenCorrectly(binaryVersion)) {
            versionRequirementTable3 = this.versionRequirementTable;
        }
        return new DeserializationContext(deserializationComponents, nameResolver2, declarationDescriptor, typeTable2, versionRequirementTable3, binaryVersion, this.containerSource, this.typeDeserializer, list);
    }
}
