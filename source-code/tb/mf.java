package tb;

import com.taobao.orange.OConstant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class mf extends i50 {
    @NotNull
    private final Runnable b;
    @NotNull
    private final Function1<InterruptedException, ur2> c;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.InterruptedException, tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public mf(@NotNull Lock lock, @NotNull Runnable runnable, @NotNull Function1<? super InterruptedException, ur2> function1) {
        super(lock);
        k21.i(lock, OConstant.DIMEN_FILE_LOCK);
        k21.i(runnable, "checkCancelled");
        k21.i(function1, "interruptedExceptionHandler");
        this.b = runnable;
        this.c = function1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock, tb.i50
    public void lock() {
        while (!a().tryLock(50, TimeUnit.MILLISECONDS)) {
            try {
                this.b.run();
            } catch (InterruptedException e) {
                this.c.invoke(e);
                return;
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public mf(@NotNull Runnable runnable, @NotNull Function1<? super InterruptedException, ur2> function1) {
        this(new ReentrantLock(), runnable, function1);
        k21.i(runnable, "checkCancelled");
        k21.i(function1, "interruptedExceptionHandler");
    }
}
