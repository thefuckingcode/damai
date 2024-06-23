package tb;

import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class g50 extends wf0 {
    @NotNull
    public static final g50 INSTANCE;
    @NotNull
    private static final CoroutineDispatcher f;

    static {
        g50 g50 = new g50();
        INSTANCE = g50;
        f = new h71(g50, oh2.d("kotlinx.coroutines.io.parallelism", ww1.a(64, mh2.a()), 0, 0, 12, null), "Dispatchers.IO", 1);
    }

    private g50() {
        super(0, 0, null, 7, null);
    }

    @NotNull
    public final CoroutineDispatcher c() {
        return f;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return lj2.DEFAULT_DISPATCHER_NAME;
    }
}
