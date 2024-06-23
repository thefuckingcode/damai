package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: IncompatibleVersionErrorData.kt */
public final class IncompatibleVersionErrorData<T extends BinaryVersion> {
    private final T actualVersion;
    private final ClassId classId;
    private final T expectedVersion;
    private final String filePath;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics.areEqual(this.actualVersion, incompatibleVersionErrorData.actualVersion) && Intrinsics.areEqual(this.expectedVersion, incompatibleVersionErrorData.expectedVersion) && Intrinsics.areEqual(this.filePath, incompatibleVersionErrorData.filePath) && Intrinsics.areEqual(this.classId, incompatibleVersionErrorData.classId);
    }

    public int hashCode() {
        T t = this.actualVersion;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        T t2 = this.expectedVersion;
        int hashCode2 = (hashCode + (t2 != null ? t2.hashCode() : 0)) * 31;
        String str = this.filePath;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        ClassId classId2 = this.classId;
        if (classId2 != null) {
            i = classId2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ")";
    }

    public IncompatibleVersionErrorData(T t, T t2, String str, ClassId classId2) {
        Intrinsics.checkParameterIsNotNull(t, "actualVersion");
        Intrinsics.checkParameterIsNotNull(t2, "expectedVersion");
        Intrinsics.checkParameterIsNotNull(str, "filePath");
        Intrinsics.checkParameterIsNotNull(classId2, "classId");
        this.actualVersion = t;
        this.expectedVersion = t2;
        this.filePath = str;
        this.classId = classId2;
    }
}
