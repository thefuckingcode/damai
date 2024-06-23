package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: VersionRequirement.kt */
public final class VersionRequirementTable {
    public static final Companion Companion = new Companion(null);
    private static final VersionRequirementTable EMPTY = new VersionRequirementTable(CollectionsKt.emptyList());
    private final List<ProtoBuf.VersionRequirement> infos;

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> list) {
        this.infos = list;
    }

    public /* synthetic */ VersionRequirementTable(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    public final ProtoBuf.VersionRequirement get(int i) {
        return (ProtoBuf.VersionRequirement) CollectionsKt.getOrNull(this.infos, i);
    }

    /* compiled from: VersionRequirement.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.EMPTY;
        }

        public final VersionRequirementTable create(ProtoBuf.VersionRequirementTable versionRequirementTable) {
            Intrinsics.checkParameterIsNotNull(versionRequirementTable, "table");
            if (versionRequirementTable.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<ProtoBuf.VersionRequirement> requirementList = versionRequirementTable.getRequirementList();
            Intrinsics.checkExpressionValueIsNotNull(requirementList, "table.requirementList");
            return new VersionRequirementTable(requirementList, null);
        }
    }
}
