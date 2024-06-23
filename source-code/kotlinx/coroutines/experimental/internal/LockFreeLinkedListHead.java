package kotlinx.coroutines.experimental.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J-\u0010\b\u001a\u00020\t\"\u000e\b\u0000\u0010\n\u0018\u0001*\u00060\u0001j\u0002`\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\rH\bJ\u0006\u0010\u000e\u001a\u00020\u0007J\r\u0010\u000f\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0010R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "()V", "isEmpty", "", "()Z", "describeRemove", "", "forEach", "", "T", "Lkotlinx/coroutines/experimental/internal/Node;", "block", "Lkotlin/Function1;", "remove", "validate", "validate$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: LockFreeLinkedList.kt */
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public final boolean isEmpty() {
        return getNext() == this;
    }

    private final <T extends LockFreeLinkedListNode> void forEach(Function1<? super T, Unit> function1) {
        Object next = getNext();
        if (next != null) {
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                Intrinsics.reifiedOperationMarker(3, "T");
                if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                    function1.invoke(lockFreeLinkedListNode);
                }
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }

    @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
    public final Void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
    public final Void describeRemove() {
        throw new UnsupportedOperationException();
    }

    public final void validate$kotlinx_coroutines_core() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this;
        Object next = getNext();
        if (next != null) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            LockFreeLinkedListHead lockFreeLinkedListHead2 = lockFreeLinkedListHead;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            while (!Intrinsics.areEqual(lockFreeLinkedListNode2, this)) {
                LockFreeLinkedListNode nextNode = lockFreeLinkedListNode2.getNextNode();
                lockFreeLinkedListNode2.validateNode$kotlinx_coroutines_core(lockFreeLinkedListHead2, nextNode);
                lockFreeLinkedListHead2 = lockFreeLinkedListNode2;
                lockFreeLinkedListNode2 = nextNode;
            }
            Object next2 = getNext();
            if (next2 != null) {
                validateNode$kotlinx_coroutines_core(lockFreeLinkedListHead2, (LockFreeLinkedListNode) next2);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }
}
