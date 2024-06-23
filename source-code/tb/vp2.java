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
public final class vp2 implements Comparable<vp2> {
    @NotNull
    public static final a Companion = new a(null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ vp2(int i) {
        this.a = i;
    }

    public static final /* synthetic */ vp2 a(int i) {
        return new vp2(i);
    }

    @PublishedApi
    public static int b(int i) {
        return i;
    }

    public static boolean c(int i, Object obj) {
        return (obj instanceof vp2) && i == ((vp2) obj).f();
    }

    public static int d(int i) {
        return i;
    }

    @NotNull
    public static String e(int i) {
        return String.valueOf(((long) i) & 4294967295L);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(vp2 vp2) {
        return bs2.a(f(), vp2.f());
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ int f() {
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
