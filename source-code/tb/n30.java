package tb;

import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class n30 {
    @NotNull
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    @NotNull
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";
    private static final boolean a = false;
    private static final boolean b;
    private static final boolean c;
    @NotNull
    private static final AtomicLong d = new AtomicLong(0);

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r0.equals("auto") != false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r0.equals("on") != false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r0.equals("") != false) goto L_0x0042;
     */
    static {
        boolean z;
        String d2 = mh2.d(DEBUG_PROPERTY_NAME);
        boolean z2 = false;
        if (d2 != null) {
            int hashCode = d2.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode != 109935) {
                        if (hashCode == 3005871) {
                        }
                    } else if (d2.equals("off")) {
                        z = false;
                        b = z;
                        if (z && mh2.e(STACKTRACE_RECOVERY_PROPERTY_NAME, true)) {
                            z2 = true;
                        }
                        c = z2;
                    }
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + ((Object) d2) + '\'').toString());
            }
            z = true;
            b = z;
            z2 = true;
            c = z2;
        }
        z = a();
        b = z;
        z2 = true;
        c = z2;
    }

    public static final boolean a() {
        return a;
    }

    @NotNull
    public static final AtomicLong b() {
        return d;
    }

    public static final boolean c() {
        return b;
    }

    public static final boolean d() {
        return c;
    }
}
