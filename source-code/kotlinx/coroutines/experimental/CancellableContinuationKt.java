package kotlinx.coroutines.experimental;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\b\u001a=\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0016\u0010\n\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000b\u001a\u00020\f\u001a\u0018\u0010\r\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0018\u0010\u000e\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010\u0011\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000f\u001a\u00020\u0010\u0002\u0004\n\u0002\b\t¨\u0006\u0012"}, d2 = {"suspendAtomicCancellableCoroutine", "T", "holdCancellability", "", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "suspendCancellableCoroutine", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/experimental/DisposableHandle;", "disposeOnCompletion", "removeOnCancel", "node", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "removeOnCancellation", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: CancellableContinuation.kt */
public final class CancellableContinuationKt {
    private static final <T> Object suspendCancellableCoroutine(boolean z, Function1<? super CancellableContinuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 1);
        if (!z) {
            cancellableContinuationImpl.initCancellability();
        }
        function1.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        InlineMarker.mark(1);
        return result;
    }

    private static final <T> Object suspendAtomicCancellableCoroutine(boolean z, Function1<? super CancellableContinuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 0);
        if (!z) {
            cancellableContinuationImpl.initCancellability();
        }
        function1.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        InlineMarker.mark(1);
        return result;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Disposable handlers on cancellation are no longer supported", replaceWith = @ReplaceWith(expression = "removeOnCancellation(handler)", imports = {}))
    public static final DisposableHandle removeOnCancel(CancellableContinuation<?> cancellableContinuation, LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "$receiver");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        removeOnCancellation(cancellableContinuation, lockFreeLinkedListNode);
        return NonDisposableHandle.INSTANCE;
    }

    public static final void removeOnCancellation(CancellableContinuation<?> cancellableContinuation, LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "$receiver");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        cancellableContinuation.invokeOnCancellation(new RemoveOnCancel(lockFreeLinkedListNode));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Disposable handlers on regular completion are no longer supported", replaceWith = @ReplaceWith(expression = "disposeOnCancellation(handler)", imports = {}))
    public static final DisposableHandle disposeOnCompletion(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "$receiver");
        Intrinsics.checkParameterIsNotNull(disposableHandle, "handle");
        disposeOnCancellation(cancellableContinuation, disposableHandle);
        return NonDisposableHandle.INSTANCE;
    }

    public static final void disposeOnCancellation(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "$receiver");
        Intrinsics.checkParameterIsNotNull(disposableHandle, "handle");
        cancellableContinuation.invokeOnCancellation(new DisposeOnCancel(disposableHandle));
    }

    static /* bridge */ /* synthetic */ Object suspendCancellableCoroutine$default(boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 1);
        if (!z) {
            cancellableContinuationImpl.initCancellability();
        }
        function1.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        InlineMarker.mark(1);
        return result;
    }

    static /* bridge */ /* synthetic */ Object suspendAtomicCancellableCoroutine$default(boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 0);
        if (!z) {
            cancellableContinuationImpl.initCancellability();
        }
        function1.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        InlineMarker.mark(1);
        return result;
    }
}
