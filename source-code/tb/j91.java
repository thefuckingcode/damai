package tb;

import android.util.Log;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class j91 {
    @NotNull
    public static final j91 INSTANCE = new j91();
    private static boolean a = true;

    private j91() {
    }

    @JvmStatic
    public static final void a(@Nullable String str, @Nullable String str2) {
        if (a && str2 != null) {
            Log.d(str, str2);
        }
    }

    @JvmStatic
    public static final void b(@Nullable String str, @Nullable String str2) {
        if (a && str2 != null) {
            Log.e(str, str2);
        }
    }

    @JvmStatic
    public static final void c(@Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        if (a) {
            Log.e(str, str2, th);
        }
    }
}
