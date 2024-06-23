package tb;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class yp0 {
    private static final up0 a(up0 up0, up0 up02, String str) {
        if (k21.d(up02.n().n().d(), str)) {
            return up02;
        }
        List<up0> d = up02.d();
        if (d == null) {
            return null;
        }
        Iterator<T> it = d.iterator();
        while (it.hasNext()) {
            up0 a = a(up0, it.next(), str);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    private static final View b(up0 up0, up0 up02, String str) {
        if (k21.d(up02.n().n().d(), str)) {
            return up02.p();
        }
        List<up0> d = up02.d();
        if (d == null) {
            return null;
        }
        Iterator<T> it = d.iterator();
        while (it.hasNext()) {
            View b = b(up0, it.next(), str);
            if (b != null) {
                return b;
            }
        }
        return null;
    }

    @Nullable
    public static final up0 c(@NotNull up0 up0, @NotNull String str) {
        k21.i(up0, "<this>");
        k21.i(str, "id");
        return a(up0, up0, str);
    }

    @Nullable
    public static final View d(@NotNull up0 up0, @NotNull String str) {
        k21.i(up0, "<this>");
        k21.i(str, "id");
        return b(up0, up0, str);
    }
}
