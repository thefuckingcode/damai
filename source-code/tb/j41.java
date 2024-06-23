package tb;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class j41 {
    @NotNull
    public static final CompletableJob a(@Nullable Job job) {
        return k41.a(job);
    }

    public static final void c(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        k41.c(coroutineContext, cancellationException);
    }

    @NotNull
    public static final DisposableHandle e(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        return k41.e(job, disposableHandle);
    }

    public static final void f(@NotNull CoroutineContext coroutineContext) {
        k41.f(coroutineContext);
    }

    public static final void g(@NotNull Job job) {
        k41.g(job);
    }

    @NotNull
    public static final Job h(@NotNull CoroutineContext coroutineContext) {
        return k41.h(coroutineContext);
    }

    public static final boolean i(@NotNull CoroutineContext coroutineContext) {
        return k41.i(coroutineContext);
    }
}
