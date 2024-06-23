package tb;

import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import com.youku.upsplayer.util.YKUpsConvert;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.DurationUnit;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.6")
@JvmInline
@WasExperimental(markerClass = {ExperimentalTime.class})
/* compiled from: Taobao */
public final class gc0 implements Comparable<gc0> {
    @NotNull
    public static final a Companion = new a(null);
    private static final long b = e(0);
    private static final long c = jc0.b(jc0.MAX_MILLIS);
    private static final long d = jc0.b(-4611686018427387903L);
    private final long a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final long a() {
            return gc0.b;
        }
    }

    @NotNull
    public static String A(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == c) {
            return "Infinity";
        }
        if (j == d) {
            return "-Infinity";
        }
        boolean x = x(j);
        StringBuilder sb = new StringBuilder();
        if (x) {
            sb.append('-');
        }
        long g = g(j);
        long i = i(g);
        int h = h(g);
        int n = n(g);
        int p = p(g);
        int o = o(g);
        int i2 = 0;
        boolean z = i != 0;
        boolean z2 = h != 0;
        boolean z3 = n != 0;
        boolean z4 = (p == 0 && o == 0) ? false : true;
        if (z) {
            sb.append(i);
            sb.append('d');
            i2 = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i3 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            sb.append(h);
            sb.append('h');
            i2 = i3;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i4 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            sb.append(n);
            sb.append('m');
            i2 = i4;
        }
        if (z4) {
            int i5 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            if (p != 0 || z || z2 || z3) {
                b(j, sb, p, o, 9, "s", false);
            } else if (o >= 1000000) {
                b(j, sb, o / 1000000, o % 1000000, 6, "ms", false);
            } else if (o >= 1000) {
                b(j, sb, o / 1000, o % 1000, 3, "us", false);
            } else {
                sb.append(o);
                sb.append(NotificationStyle.NOTIFICATION_STYLE);
            }
            i2 = i5;
        }
        if (x && i2 > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final long B(long j) {
        return jc0.a(-r(j), ((int) j) & 1);
    }

    private static final void b(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String str2 = StringsKt__StringsKt.q0(String.valueOf(i2), i3, YKUpsConvert.CHAR_ZERO);
            int i4 = -1;
            int length = str2.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (str2.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (z || i6 >= 3) {
                sb.append((CharSequence) str2, 0, ((i6 + 2) / 3) * 3);
                k21.h(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) str2, 0, i6);
                k21.h(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    public static int d(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return k21.l(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return x(j) ? -i : i;
    }

    public static long e(long j) {
        if (ic0.a()) {
            if (v(j)) {
                if (!new ia1(-4611686018426999999L, jc0.MAX_NANOS).d(r(j))) {
                    throw new AssertionError(r(j) + " ns is out of nanoseconds range");
                }
            } else if (!new ia1(-4611686018427387903L, jc0.MAX_MILLIS).d(r(j))) {
                throw new AssertionError(r(j) + " ms is out of milliseconds range");
            } else if (new ia1(-4611686018426L, 4611686018426L).d(r(j))) {
                throw new AssertionError(r(j) + " ms is denormalized");
            }
        }
        return j;
    }

    public static boolean f(long j, Object obj) {
        return (obj instanceof gc0) && j == ((gc0) obj).C();
    }

    public static final long g(long j) {
        return x(j) ? B(j) : j;
    }

    public static final int h(long j) {
        if (w(j)) {
            return 0;
        }
        return (int) (j(j) % ((long) 24));
    }

    public static final long i(long j) {
        return y(j, DurationUnit.DAYS);
    }

    public static final long j(long j) {
        return y(j, DurationUnit.HOURS);
    }

    public static final long k(long j) {
        return (!u(j) || !t(j)) ? y(j, DurationUnit.MILLISECONDS) : r(j);
    }

    public static final long l(long j) {
        return y(j, DurationUnit.MINUTES);
    }

    public static final long m(long j) {
        return y(j, DurationUnit.SECONDS);
    }

    public static final int n(long j) {
        if (w(j)) {
            return 0;
        }
        return (int) (l(j) % ((long) 60));
    }

    public static final int o(long j) {
        long j2;
        if (w(j)) {
            return 0;
        }
        if (u(j)) {
            j2 = jc0.c(r(j) % ((long) 1000));
        } else {
            j2 = r(j) % ((long) xt2.SECOND_IN_NANOS);
        }
        return (int) j2;
    }

    public static final int p(long j) {
        if (w(j)) {
            return 0;
        }
        return (int) (m(j) % ((long) 60));
    }

    private static final DurationUnit q(long j) {
        return v(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    private static final long r(long j) {
        return j >> 1;
    }

    public static int s(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static final boolean t(long j) {
        return !w(j);
    }

    private static final boolean u(long j) {
        return (((int) j) & 1) == 1;
    }

    private static final boolean v(long j) {
        return (((int) j) & 1) == 0;
    }

    public static final boolean w(long j) {
        return j == c || j == d;
    }

    public static final boolean x(long j) {
        return j < 0;
    }

    public static final long y(long j, @NotNull DurationUnit durationUnit) {
        k21.i(durationUnit, "unit");
        if (j == c) {
            return AbsPerformance.LONG_NIL;
        }
        if (j == d) {
            return Long.MIN_VALUE;
        }
        return kc0.a(r(j), q(j), durationUnit);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @ExperimentalTime
    public static final long z(long j) {
        return k(j);
    }

    public final /* synthetic */ long C() {
        return this.a;
    }

    public int c(long j) {
        return d(this.a, j);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(gc0 gc0) {
        return c(gc0.C());
    }

    public boolean equals(Object obj) {
        return f(this.a, obj);
    }

    public int hashCode() {
        return s(this.a);
    }

    @NotNull
    public String toString() {
        return A(this.a);
    }
}
