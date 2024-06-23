package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bg2;
import tb.fk1;
import tb.g61;
import tb.k21;
import tb.ka1;
import tb.mc;
import tb.nh;
import tb.nj0;
import tb.om;
import tb.pb0;
import tb.qa2;
import tb.w7;
import tb.z11;
import tb.zd;

/* compiled from: Taobao */
public final class ConstantValueFactory {
    @NotNull
    public static final ConstantValueFactory INSTANCE = new ConstantValueFactory();

    private ConstantValueFactory() {
    }

    private final w7 a(List<?> list, PrimitiveType primitiveType) {
        List<Object> list2 = CollectionsKt___CollectionsKt.y0(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            om<?> c = c(obj);
            if (c != null) {
                arrayList.add(c);
            }
        }
        return new w7(arrayList, new ConstantValueFactory$createArrayValue$3(primitiveType));
    }

    @NotNull
    public final w7 b(@NotNull List<? extends om<?>> list, @NotNull g61 g61) {
        k21.i(list, "value");
        k21.i(g61, "type");
        return new w7(list, new ConstantValueFactory$createArrayValue$1(g61));
    }

    @Nullable
    public final om<?> c(@Nullable Object obj) {
        if (obj instanceof Byte) {
            return new zd(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new qa2(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new z11(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new ka1(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new nh(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new nj0(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new pb0(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new mc(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new bg2((String) obj);
        }
        if (obj instanceof byte[]) {
            return a(ArraysKt___ArraysKt.R((byte[]) obj), PrimitiveType.BYTE);
        }
        if (obj instanceof short[]) {
            return a(ArraysKt___ArraysKt.Y((short[]) obj), PrimitiveType.SHORT);
        }
        if (obj instanceof int[]) {
            return a(ArraysKt___ArraysKt.V((int[]) obj), PrimitiveType.INT);
        }
        if (obj instanceof long[]) {
            return a(ArraysKt___ArraysKt.W((long[]) obj), PrimitiveType.LONG);
        }
        if (obj instanceof char[]) {
            return a(ArraysKt___ArraysKt.S((char[]) obj), PrimitiveType.CHAR);
        }
        if (obj instanceof float[]) {
            return a(ArraysKt___ArraysKt.U((float[]) obj), PrimitiveType.FLOAT);
        }
        if (obj instanceof double[]) {
            return a(ArraysKt___ArraysKt.T((double[]) obj), PrimitiveType.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return a(ArraysKt___ArraysKt.Z((boolean[]) obj), PrimitiveType.BOOLEAN);
        }
        if (obj == null) {
            return new fk1();
        }
        return null;
    }
}
