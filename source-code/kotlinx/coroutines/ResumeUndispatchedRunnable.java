package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/ResumeUndispatchedRunnable;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Ltb/ur2;", "run", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
final class ResumeUndispatchedRunnable implements Runnable {
    @NotNull
    private final CancellableContinuation<ur2> continuation;
    @NotNull
    private final CoroutineDispatcher dispatcher;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    public ResumeUndispatchedRunnable(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CancellableContinuation<? super ur2> cancellableContinuation) {
        this.dispatcher = coroutineDispatcher;
        this.continuation = cancellableContinuation;
    }

    public void run() {
        this.continuation.resumeUndispatched(this.dispatcher, ur2.INSTANCE);
    }
}
