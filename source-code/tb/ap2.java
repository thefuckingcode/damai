package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ap2 {
    @NotNull
    private final List<ProtoBuf$Type> a;

    public ap2(@NotNull ProtoBuf$TypeTable protoBuf$TypeTable) {
        k21.i(protoBuf$TypeTable, "typeTable");
        List<ProtoBuf$Type> typeList = protoBuf$TypeTable.getTypeList();
        if (protoBuf$TypeTable.hasFirstNullable()) {
            int firstNullable = protoBuf$TypeTable.getFirstNullable();
            List<ProtoBuf$Type> typeList2 = protoBuf$TypeTable.getTypeList();
            k21.h(typeList2, "typeTable.typeList");
            ArrayList arrayList = new ArrayList(n.q(typeList2, 10));
            int i = 0;
            for (T t : typeList2) {
                int i2 = i + 1;
                if (i < 0) {
                    m.p();
                }
                T t2 = t;
                if (i >= firstNullable) {
                    t2 = t2.toBuilder().setNullable(true).build();
                }
                arrayList.add(t2);
                i = i2;
            }
            typeList = arrayList;
        }
        k21.h(typeList, "run {\n        val originalTypes = typeTable.typeList\n        if (typeTable.hasFirstNullable()) {\n            val firstNullable = typeTable.firstNullable\n            typeTable.typeList.mapIndexed { i, type ->\n                if (i >= firstNullable) {\n                    type.toBuilder().setNullable(true).build()\n                } else type\n            }\n        } else originalTypes\n    }");
        this.a = typeList;
    }

    @NotNull
    public final ProtoBuf$Type a(int i) {
        return this.a.get(i);
    }
}
