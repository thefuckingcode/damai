package kotlinx.coroutines.experimental.selects;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.internal.AtomicDesc;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H&R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/experimental/selects/SelectInstance;", "R", "", "completion", "Lkotlin/coroutines/experimental/Continuation;", "getCompletion", "()Lkotlin/coroutines/experimental/Continuation;", "isSelected", "", "()Z", "disposeOnSelect", "", "handle", "Lkotlinx/coroutines/experimental/DisposableHandle;", "performAtomicIfNotSelected", "desc", "Lkotlinx/coroutines/experimental/internal/AtomicDesc;", "performAtomicTrySelect", "resumeSelectCancellableWithException", "exception", "", "trySelect", "idempotent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Select.kt */
public interface SelectInstance<R> {
    void disposeOnSelect(DisposableHandle disposableHandle);

    Continuation<R> getCompletion();

    boolean isSelected();

    Object performAtomicIfNotSelected(AtomicDesc atomicDesc);

    Object performAtomicTrySelect(AtomicDesc atomicDesc);

    void resumeSelectCancellableWithException(Throwable th);

    boolean trySelect(Object obj);
}
