package tb;

import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ia1 extends ga1 implements ClosedRange<Long> {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    static {
        new ia1(1, 0);
    }

    public ia1(long j, long j2) {
        super(j, j2, 1);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Long l) {
        return d(l.longValue());
    }

    public boolean d(long j) {
        return a() <= j && j <= b();
    }

    @NotNull
    /* renamed from: e */
    public Long getEndInclusive() {
        return Long.valueOf(b());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ia1) {
            if (!isEmpty() || !((ia1) obj).isEmpty()) {
                ia1 ia1 = (ia1) obj;
                if (!(a() == ia1.a() && b() == ia1.b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f */
    public Long getStart() {
        return Long.valueOf(a());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (a() ^ (a() >>> 32))) + (b() ^ (b() >>> 32)));
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return a() > b();
    }

    @NotNull
    public String toString() {
        return a() + ".." + b();
    }
}
