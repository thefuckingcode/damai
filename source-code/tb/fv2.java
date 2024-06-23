package tb;

import java.util.List;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class fv2 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final fv2 b = new fv2(m.g());
    @NotNull
    private final List<ProtoBuf$VersionRequirement> a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final fv2 a(@NotNull ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            k21.i(protoBuf$VersionRequirementTable, "table");
            if (protoBuf$VersionRequirementTable.getRequirementCount() == 0) {
                return b();
            }
            List<ProtoBuf$VersionRequirement> requirementList = protoBuf$VersionRequirementTable.getRequirementList();
            k21.h(requirementList, "table.requirementList");
            return new fv2(requirementList, null);
        }

        @NotNull
        public final fv2 b() {
            return fv2.b;
        }
    }

    private fv2(List<ProtoBuf$VersionRequirement> list) {
        this.a = list;
    }

    public /* synthetic */ fv2(List list, m40 m40) {
        this(list);
    }

    @Nullable
    public final ProtoBuf$VersionRequirement b(int i) {
        return (ProtoBuf$VersionRequirement) k.S(this.a, i);
    }
}
