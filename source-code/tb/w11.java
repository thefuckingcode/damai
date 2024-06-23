package tb;

import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class w11 extends u11 implements ClosedRange<Integer> {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final w11 d = new w11(1, 0);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final w11 a() {
            return w11.d;
        }
    }

    public w11(int i, int i2) {
        super(i, i2, 1);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Integer num) {
        return f(num.intValue());
    }

    @Override // tb.u11
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof w11) {
            if (!isEmpty() || !((w11) obj).isEmpty()) {
                w11 w11 = (w11) obj;
                if (!(a() == w11.a() && b() == w11.b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i) {
        return a() <= i && i <= b();
    }

    @NotNull
    /* renamed from: g */
    public Integer getEndInclusive() {
        return Integer.valueOf(b());
    }

    @NotNull
    /* renamed from: h */
    public Integer getStart() {
        return Integer.valueOf(a());
    }

    @Override // tb.u11
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // tb.u11, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // tb.u11
    @NotNull
    public String toString() {
        return a() + ".." + b();
    }
}
