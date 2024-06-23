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
public final class yp2 implements Comparable<yp2> {
    @NotNull
    public static final a Companion = new a(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ yp2(long j) {
        this.a = j;
    }

    public static final /* synthetic */ yp2 a(long j) {
        return new yp2(j);
    }

    @PublishedApi
    public static long b(long j) {
        return j;
    }

    public static boolean c(long j, Object obj) {
        return (obj instanceof yp2) && j == ((yp2) obj).f();
    }

    public static int d(long j) {
        return (int) (j ^ (j >>> 32));
    }

    @NotNull
    public static String e(long j) {
        return bs2.c(j);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(yp2 yp2) {
        return bs2.b(f(), yp2.f());
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ long f() {
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
