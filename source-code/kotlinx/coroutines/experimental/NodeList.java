package kotlinx.coroutines.experimental;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/experimental/NodeList;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/experimental/Incomplete;", "active", "", "(Z)V", "_active", "Lkotlinx/atomicfu/AtomicInt;", "isActive", "()Z", "list", "getList", "()Lkotlinx/coroutines/experimental/NodeList;", "toString", "", "tryMakeActive", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: JobSupport.kt */
public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    private static final AtomicIntegerFieldUpdater _active$FU = AtomicIntegerFieldUpdater.newUpdater(NodeList.class, "_active");
    private volatile int _active;

    @Override // kotlinx.coroutines.experimental.Incomplete
    public NodeList getList() {
        return this;
    }

    public NodeList(boolean z) {
        this._active = z ? 1 : 0;
    }

    @Override // kotlinx.coroutines.experimental.Incomplete
    public boolean isActive() {
        return this._active != 0;
    }

    public final int tryMakeActive() {
        if (this._active != 0) {
            return 0;
        }
        return _active$FU.compareAndSet(this, 0, 1) ? 1 : -1;
    }

    @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List");
        sb.append(isActive() ? "{Active}" : "{New}");
        sb.append("[");
        Object next = getNext();
        if (next != null) {
            boolean z = true;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(jobNode);
                }
            }
            sb.append("]");
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }
}
