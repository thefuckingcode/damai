package kotlinx.coroutines.experimental.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u0004\u0018\u00010\r2\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u000f\u001a\u00020\rH\u0014J \u0010\u0010\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u000f\u001a\u00060\u0005j\u0002`\u0006H\u0014J\"\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u000f\u001a\u00060\u0005j\u0002`\u0006H\u0014J \u0010\u0013\u001a\u00020\u00142\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u000f\u001a\u00060\u0005j\u0002`\u0006H\u0014R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"kotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$describeRemove$1", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "_originalNext", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "affectedNode", "getAffectedNode", "()Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "failure", "", "affected", "next", "finishOnSuccess", "", "onPrepare", "updatedNext", "Lkotlinx/coroutines/experimental/internal/Removed;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: LockFreeLinkedList.kt */
public final class LockFreeLinkedListNode$describeRemove$1 extends LockFreeLinkedListNode.AbstractAtomicDesc {
    private static final AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode$describeRemove$1.class, Object.class, "_originalNext");
    private volatile Object _originalNext = null;
    final /* synthetic */ LockFreeLinkedListNode this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    LockFreeLinkedListNode$describeRemove$1(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.this$0 = lockFreeLinkedListNode;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
    public LockFreeLinkedListNode getAffectedNode() {
        return this.this$0;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
    public LockFreeLinkedListNode getOriginalNext() {
        return (LockFreeLinkedListNode) this._originalNext;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
    public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(obj, "next");
        if (obj instanceof Removed) {
            return LockFreeLinkedListKt.getALREADY_REMOVED();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
    public Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        _originalNext$FU.compareAndSet(this, null, lockFreeLinkedListNode2);
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
    public Removed updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        return lockFreeLinkedListNode2.removed();
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
    public void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        this.this$0.finishRemove(lockFreeLinkedListNode2);
    }
}
