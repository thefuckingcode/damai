package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i50;
import tb.mf;
import tb.ur2;

/* compiled from: Taobao */
public interface SimpleLock {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        @NotNull
        public final i50 a(@Nullable Runnable runnable, @Nullable Function1<? super InterruptedException, ur2> function1) {
            if (runnable == null || function1 == null) {
                return new i50(null, 1, null);
            }
            return new mf(runnable, function1);
        }
    }

    void lock();

    void unlock();
}
