package tb;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.g;

/* compiled from: Taobao */
public final /* synthetic */ class rk implements ThreadFactory {
    public final /* synthetic */ AtomicInteger a;

    public /* synthetic */ rk(AtomicInteger atomicInteger) {
        this.a = atomicInteger;
    }

    public final Thread newThread(Runnable runnable) {
        return g.b(this.a, runnable);
    }
}
