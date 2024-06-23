package tb;

import android.app.Application;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class xi2 {
    @NotNull
    public static final xi2 INSTANCE = new xi2();
    @JvmField
    @Nullable
    public static Application a;
    private static boolean b = true;
    @Nullable
    private static String c;
    private static boolean d;

    private xi2() {
    }

    public static final boolean a() {
        return b;
    }

    @Nullable
    public static final String b() {
        return c;
    }

    public static final void d(@Nullable String str) {
        c = str;
    }

    public final boolean c() {
        return d;
    }

    public final void e(boolean z) {
        d = z;
    }
}
