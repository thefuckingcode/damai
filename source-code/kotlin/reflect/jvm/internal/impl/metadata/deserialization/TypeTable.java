package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: TypeTable.kt */
public final class TypeTable {
    private final List<ProtoBuf.Type> types;

    public TypeTable(ProtoBuf.TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        ArrayList typeList = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            List<ProtoBuf.Type> typeList2 = typeTable.getTypeList();
            Intrinsics.checkExpressionValueIsNotNull(typeList2, "typeTable.typeList");
            List<ProtoBuf.Type> list = typeList2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                if (i >= firstNullable) {
                    t2 = t2.toBuilder().setNullable(true).build();
                }
                arrayList.add(t2);
                i = i2;
            }
            typeList = arrayList;
        } else {
            Intrinsics.checkExpressionValueIsNotNull(typeList, "originalTypes");
        }
        this.types = typeList;
    }

    public final ProtoBuf.Type get(int i) {
        return this.types.get(i);
    }
}
