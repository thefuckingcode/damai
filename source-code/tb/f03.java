package tb;

import android.util.Log;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class f03 {
    @NotNull
    public static final f03 INSTANCE = new f03();
    private static boolean a;

    private f03() {
    }

    public final void a(@Nullable String str, @Nullable String str2) {
        if (a) {
            boolean z = false;
            if (!(str == null || (o.y(str)))) {
                if (str2 == null || (o.y(str2))) {
                    z = true;
                }
                if (!z) {
                    Log.d(str, str2);
                }
            }
        }
    }

    public final void b(@Nullable String str, @Nullable String str2) {
        if (a) {
            boolean z = false;
            if (!(str == null || (o.y(str)))) {
                if (str2 == null || (o.y(str2))) {
                    z = true;
                }
                if (!z) {
                    Log.w(str, str2);
                }
            }
        }
    }
}
