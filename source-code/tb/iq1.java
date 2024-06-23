package tb;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class iq1 {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private static iq1 b;
    @NotNull
    private final Map<Integer, WeakReference<b>> a = new LinkedHashMap();

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final synchronized iq1 a() {
            iq1 iq1;
            if (iq1.b == null) {
                iq1.b = new iq1();
            }
            iq1 = iq1.b;
            k21.f(iq1);
            return iq1;
        }
    }

    /* compiled from: Taobao */
    public static abstract class b {
        public boolean a(@NotNull Activity activity) {
            k21.i(activity, "activity");
            return false;
        }

        public void b(@NotNull Activity activity) {
            k21.i(activity, "activity");
        }

        public void c(@NotNull Activity activity) {
            k21.i(activity, "activity");
        }
    }

    public final void c(@Nullable b bVar) {
        if (bVar != null) {
            d().put(Integer.valueOf(bVar.hashCode()), new WeakReference<>(bVar));
        }
    }

    @NotNull
    public final Map<Integer, WeakReference<b>> d() {
        return this.a;
    }

    public final void e(@Nullable b bVar) {
        if (bVar != null) {
            d().remove(Integer.valueOf(bVar.hashCode()));
        }
    }
}
