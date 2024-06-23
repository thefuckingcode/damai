package tb;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.5")
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* compiled from: Taobao */
public final class dq2 implements Comparable<dq2> {
    @NotNull
    public static final a Companion = new a(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ dq2(short s) {
        this.a = s;
    }

    public static final /* synthetic */ dq2 a(short s) {
        return new dq2(s);
    }

    @PublishedApi
    public static short b(short s) {
        return s;
    }

    public static boolean c(short s, Object obj) {
        return (obj instanceof dq2) && s == ((dq2) obj).f();
    }

    public static int d(short s) {
        return s;
    }

    @NotNull
    public static String e(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(dq2 dq2) {
        return k21.k(f() & MAX_VALUE, dq2.f() & MAX_VALUE);
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ short f() {
        return this.a;
    }

    public int hashCode() {
        return d(this.a);
    }

    @NotNull
    public String toString() {
        return e(this.a);
    }
}
