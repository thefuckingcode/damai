package tb;

import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class kh implements Iterable<Character>, KMappedMarker {
    @NotNull
    public static final a Companion = new a(null);
    private final char a;
    private final char b;
    private final int c;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public kh(char c2, char c3, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i != Integer.MIN_VALUE) {
            this.a = c2;
            this.b = (char) ht1.c(c2, c3, i);
            this.c = i;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final char a() {
        return this.a;
    }

    public final char b() {
        return this.b;
    }

    @NotNull
    /* renamed from: c */
    public ih iterator() {
        return new lh(this.a, this.b, this.c);
    }
}
