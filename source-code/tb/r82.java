package tb;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class r82 {
    private static final /* synthetic */ AtomicLongFieldUpdater a = AtomicLongFieldUpdater.newUpdater(r82.class, "number");
    @NotNull
    private volatile /* synthetic */ long number = 1;

    public final long a() {
        return a.incrementAndGet(this);
    }
}
