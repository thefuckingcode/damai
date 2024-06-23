package tb;

import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class ga1 implements Iterable<Long>, KMappedMarker {
    @NotNull
    public static final a Companion = new a(null);
    private final long a;
    private final long b;
    private final long c;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public ga1(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j3 != Long.MIN_VALUE) {
            this.a = j;
            this.b = ht1.d(j, j2, j3);
            this.c = j3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final long a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    @NotNull
    /* renamed from: c */
    public fa1 iterator() {
        return new ha1(this.a, this.b, this.c);
    }
}
