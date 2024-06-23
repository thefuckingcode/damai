package tb;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class q71 {
    @NotNull
    public static final <E> E[] d(int i) {
        if (i >= 0) {
            return (E[]) new Object[i];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    @NotNull
    public static final <T> T[] e(@NotNull T[] tArr, int i) {
        k21.i(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i);
        k21.h(tArr2, "copyOf(this, newSize)");
        k21.g(tArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilderKt.copyOfUninitializedElements>");
        return tArr2;
    }

    public static final <E> void f(@NotNull E[] eArr, int i) {
        k21.i(eArr, "<this>");
        eArr[i] = null;
    }

    public static final <E> void g(@NotNull E[] eArr, int i, int i2) {
        k21.i(eArr, "<this>");
        while (i < i2) {
            f(eArr, i);
            i++;
        }
    }

    /* access modifiers changed from: private */
    public static final <T> boolean h(T[] tArr, int i, int i2, List<?> list) {
        if (i2 != list.size()) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!k21.d(tArr[i + i3], list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final <T> int i(T[] tArr, int i, int i2) {
        int i3 = 1;
        for (int i4 = 0; i4 < i2; i4++) {
            T t = tArr[i + i4];
            i3 = (i3 * 31) + (t != null ? t.hashCode() : 0);
        }
        return i3;
    }

    /* access modifiers changed from: private */
    public static final <T> String j(T[] tArr, int i, int i2) {
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append(jl1.ARRAY_START_STR);
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append((Object) tArr[i + i3]);
        }
        sb.append(jl1.ARRAY_END_STR);
        String sb2 = sb.toString();
        k21.h(sb2, "sb.toString()");
        return sb2;
    }
}
