package tb;

import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class mh extends kh implements ClosedRange<Character> {
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
        new mh(1, 0);
    }

    public mh(char c, char c2) {
        super(c, c2, 1);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Character ch) {
        return d(ch.charValue());
    }

    public boolean d(char c) {
        return k21.k(a(), c) <= 0 && k21.k(c, b()) <= 0;
    }

    @NotNull
    /* renamed from: e */
    public Character getEndInclusive() {
        return Character.valueOf(b());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof mh) {
            if (!isEmpty() || !((mh) obj).isEmpty()) {
                mh mhVar = (mh) obj;
                if (!(a() == mhVar.a() && b() == mhVar.b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f */
    public Character getStart() {
        return Character.valueOf(a());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return k21.k(a(), b()) > 0;
    }

    @NotNull
    public String toString() {
        return a() + ".." + b();
    }
}
