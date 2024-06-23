package kotlinx.coroutines.experimental.sync;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CancellableContinuation;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.sync.MutexImpl;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016¨\u0006\b¸\u0006\n"}, d2 = {"kotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$CondAddOp;", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "prepare", "", "affected", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "kotlinx-coroutines-core", "kotlinx/coroutines/experimental/sync/MutexImpl$$special$$inlined$addLastIf$1", "kotlinx/coroutines/experimental/sync/MutexImpl$$special$$inlined$loop$lambda$1"}, k = 1, mv = {1, 1, 10})
/* compiled from: LockFreeLinkedList.kt */
public final class MutexImpl$lockSuspend$$inlined$suspendAtomicCancellableCoroutine$lambda$1 extends LockFreeLinkedListNode.CondAddOp {
    final /* synthetic */ CancellableContinuation $cont$inlined;
    final /* synthetic */ LockFreeLinkedListNode $node;
    final /* synthetic */ Object $owner$inlined;
    final /* synthetic */ Object $state$inlined;
    final /* synthetic */ MutexImpl.LockCont $waiter$inlined;
    final /* synthetic */ MutexImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutexImpl$lockSuspend$$inlined$suspendAtomicCancellableCoroutine$lambda$1(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, Object obj, CancellableContinuation cancellableContinuation, MutexImpl.LockCont lockCont, MutexImpl mutexImpl, Object obj2) {
        super(lockFreeLinkedListNode2);
        this.$node = lockFreeLinkedListNode;
        this.$state$inlined = obj;
        this.$cont$inlined = cancellableContinuation;
        this.$waiter$inlined = lockCont;
        this.this$0 = mutexImpl;
        this.$owner$inlined = obj2;
    }

    public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        if (this.this$0._state == this.$state$inlined) {
            return null;
        }
        return LockFreeLinkedListKt.getCONDITION_FALSE();
    }
}
