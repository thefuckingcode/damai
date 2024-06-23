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
public final class ip2 implements Comparable<ip2> {
    @NotNull
    public static final a Companion = new a(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ ip2(byte b) {
        this.a = b;
    }

    public static final /* synthetic */ ip2 a(byte b) {
        return new ip2(b);
    }

    @PublishedApi
    public static byte b(byte b) {
        return b;
    }

    public static boolean c(byte b, Object obj) {
        return (obj instanceof ip2) && b == ((ip2) obj).f();
    }

    public static int d(byte b) {
        return b;
    }

    @NotNull
    public static String e(byte b) {
        return String.valueOf(b & 255);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ip2 ip2) {
        return k21.k(f() & 255, ip2.f() & 255);
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ byte f() {
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
