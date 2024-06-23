package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* compiled from: ClassData.kt */
public final class ClassData {
    private final ProtoBuf.Class classProto;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;
    private final SourceElement sourceElement;

    public final NameResolver component1() {
        return this.nameResolver;
    }

    public final ProtoBuf.Class component2() {
        return this.classProto;
    }

    public final BinaryVersion component3() {
        return this.metadataVersion;
    }

    public final SourceElement component4() {
        return this.sourceElement;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassData)) {
            return false;
        }
        ClassData classData = (ClassData) obj;
        return Intrinsics.areEqual(this.nameResolver, classData.nameResolver) && Intrinsics.areEqual(this.classProto, classData.classProto) && Intrinsics.areEqual(this.metadataVersion, classData.metadataVersion) && Intrinsics.areEqual(this.sourceElement, classData.sourceElement);
    }

    public int hashCode() {
        NameResolver nameResolver2 = this.nameResolver;
        int i = 0;
        int hashCode = (nameResolver2 != null ? nameResolver2.hashCode() : 0) * 31;
        ProtoBuf.Class r2 = this.classProto;
        int hashCode2 = (hashCode + (r2 != null ? r2.hashCode() : 0)) * 31;
        BinaryVersion binaryVersion = this.metadataVersion;
        int hashCode3 = (hashCode2 + (binaryVersion != null ? binaryVersion.hashCode() : 0)) * 31;
        SourceElement sourceElement2 = this.sourceElement;
        if (sourceElement2 != null) {
            i = sourceElement2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.nameResolver + ", classProto=" + this.classProto + ", metadataVersion=" + this.metadataVersion + ", sourceElement=" + this.sourceElement + ")";
    }

    public ClassData(NameResolver nameResolver2, ProtoBuf.Class r3, BinaryVersion binaryVersion, SourceElement sourceElement2) {
        Intrinsics.checkParameterIsNotNull(nameResolver2, "nameResolver");
        Intrinsics.checkParameterIsNotNull(r3, "classProto");
        Intrinsics.checkParameterIsNotNull(binaryVersion, "metadataVersion");
        Intrinsics.checkParameterIsNotNull(sourceElement2, "sourceElement");
        this.nameResolver = nameResolver2;
        this.classProto = r3;
        this.metadataVersion = binaryVersion;
        this.sourceElement = sourceElement2;
    }
}
