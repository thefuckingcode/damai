package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.h;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class nb {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final int[] a;
    private final int b;
    private final int c;
    private final int d;
    @NotNull
    private final List<Integer> e;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public nb(@NotNull int... iArr) {
        k21.i(iArr, "numbers");
        this.a = iArr;
        Integer num = ArraysKt___ArraysKt.y(iArr, 0);
        int i = -1;
        this.b = num == null ? -1 : num.intValue();
        Integer num2 = ArraysKt___ArraysKt.y(iArr, 1);
        this.c = num2 == null ? -1 : num2.intValue();
        Integer num3 = ArraysKt___ArraysKt.y(iArr, 2);
        this.d = num3 != null ? num3.intValue() : i;
        this.e = iArr.length > 3 ? CollectionsKt___CollectionsKt.y0(h.c(iArr).subList(3, iArr.length)) : m.g();
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final boolean c(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.c;
        if (i5 > i2) {
            return true;
        }
        if (i5 >= i2 && this.d >= i3) {
            return true;
        }
        return false;
    }

    public final boolean d(@NotNull nb nbVar) {
        k21.i(nbVar, "version");
        return c(nbVar.b, nbVar.c, nbVar.d);
    }

    public final boolean e(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 < i) {
            return true;
        }
        if (i4 > i) {
            return false;
        }
        int i5 = this.c;
        if (i5 < i2) {
            return true;
        }
        if (i5 <= i2 && this.d <= i3) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != null && k21.d(getClass(), obj.getClass())) {
            nb nbVar = (nb) obj;
            return this.b == nbVar.b && this.c == nbVar.c && this.d == nbVar.d && k21.d(this.e, nbVar.e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public final boolean f(@NotNull nb nbVar) {
        k21.i(nbVar, "ourVersion");
        int i = this.b;
        if (i == 0) {
            if (nbVar.b == 0 && this.c == nbVar.c) {
                return true;
            }
            return false;
        } else if (i == nbVar.b && this.c <= nbVar.c) {
            return true;
        }
        return false;
    }

    @NotNull
    public final int[] g() {
        return this.a;
    }

    public int hashCode() {
        int i = this.b;
        int i2 = i + (i * 31) + this.c;
        int i3 = i2 + (i2 * 31) + this.d;
        return i3 + (i3 * 31) + this.e.hashCode();
    }

    @NotNull
    public String toString() {
        int[] g = g();
        ArrayList arrayList = new ArrayList();
        int length = g.length;
        for (int i = 0; i < length; i++) {
            int i2 = g[i];
            if (!(i2 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList.isEmpty() ? "unknown" : CollectionsKt___CollectionsKt.Z(arrayList, ".", null, null, 0, null, null, 62, null);
    }
}
