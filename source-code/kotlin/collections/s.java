package kotlin.collections;

import java.util.List;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.w11;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class s extends r {
    @JvmName(name = "asReversedMutable")
    @NotNull
    public static <T> List<T> D(@NotNull List<T> list) {
        k21.i(list, "<this>");
        return new a0(list);
    }

    /* access modifiers changed from: private */
    public static final int E(List<?> list, int i) {
        if (new w11(0, m.i(list)).f(i)) {
            return m.i(list) - i;
        }
        throw new IndexOutOfBoundsException("Element index " + i + " must be in range [" + new w11(0, m.i(list)) + "].");
    }

    /* access modifiers changed from: private */
    public static final int F(List<?> list, int i) {
        if (new w11(0, list.size()).f(i)) {
            return list.size() - i;
        }
        throw new IndexOutOfBoundsException("Position index " + i + " must be in range [" + new w11(0, list.size()) + "].");
    }
}
