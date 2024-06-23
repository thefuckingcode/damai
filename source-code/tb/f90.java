package tb;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.x;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class f90 {
    @NotNull
    public static final f90 INSTANCE = new f90();
    @NotNull
    private static final CoroutineDispatcher a = qn.a();
    @NotNull
    private static final CoroutineDispatcher b = g50.INSTANCE.c();

    static {
        x xVar = x.INSTANCE;
    }

    private f90() {
    }

    @NotNull
    public static final CoroutineDispatcher a() {
        return a;
    }

    @NotNull
    public static final CoroutineDispatcher b() {
        return b;
    }

    @NotNull
    public static final xa1 c() {
        return ya1.dispatcher;
    }
}
