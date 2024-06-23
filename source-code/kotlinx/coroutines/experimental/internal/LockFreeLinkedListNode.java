package kotlinx.coroutines.experimental.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0004BCDEB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0000j\u0002`\u0010J%\u0010\u001a\u001a\u00020\t2\n\u0010\u0019\u001a\u00060\u0000j\u0002`\u00102\u000e\b\u0004\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001cH\bJ-\u0010\u001d\u001a\u00020\t2\n\u0010\u0019\u001a\u00060\u0000j\u0002`\u00102\u0016\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0010\u0012\u0004\u0012\u00020\t0\u001fH\bJ=\u0010 \u001a\u00020\t2\n\u0010\u0019\u001a\u00060\u0000j\u0002`\u00102\u0016\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0010\u0012\u0004\u0012\u00020\t0\u001f2\u000e\b\u0004\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001cH\bJ \u0010!\u001a\u00020\t2\n\u0010\u0019\u001a\u00060\u0000j\u0002`\u00102\n\u0010\f\u001a\u00060\u0000j\u0002`\u0010H\u0001J\u0012\u0010\"\u001a\u00020\t2\n\u0010\u0019\u001a\u00060\u0000j\u0002`\u0010J&\u0010#\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00102\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u00102\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J'\u0010&\u001a\b\u0012\u0004\u0012\u0002H(0'\"\f\b\u0000\u0010(*\u00060\u0000j\u0002`\u00102\u0006\u0010\u0019\u001a\u0002H(¢\u0006\u0002\u0010)J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00100-J\f\u0010.\u001a\u00060\u0000j\u0002`\u0010H\u0002J\u0014\u0010/\u001a\u00020\u00182\n\u0010\f\u001a\u00060\u0000j\u0002`\u0010H\u0002J\u0014\u00100\u001a\u00020\u00182\n\u0010\f\u001a\u00060\u0000j\u0002`\u0010H\u0002J\b\u00101\u001a\u00020\u0018H\u0001J%\u00102\u001a\u0002032\n\u0010\u0019\u001a\u00060\u0000j\u0002`\u00102\u000e\b\u0004\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001cH\bJ\f\u00104\u001a\u00060\u0000j\u0002`\u0010H\u0002J\b\u00105\u001a\u00020\tH\u0016J\u0018\u00106\u001a\u0004\u0018\u0001H(\"\u0006\b\u0000\u0010(\u0018\u0001H\b¢\u0006\u0002\u0010\u000eJ,\u00107\u001a\u0004\u0018\u0001H(\"\u0006\b\u0000\u0010(\u0018\u00012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u00020\t0\u001fH\b¢\u0006\u0002\u00108J\u000e\u00109\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0010J\b\u0010:\u001a\u00020\u0007H\u0002J\b\u0010;\u001a\u00020<H\u0016J(\u0010=\u001a\u00020>2\n\u0010\u0019\u001a\u00060\u0000j\u0002`\u00102\n\u0010\f\u001a\u00060\u0000j\u0002`\u00102\u0006\u0010?\u001a\u000203H\u0001J%\u0010@\u001a\u00020\u00182\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00102\n\u0010\f\u001a\u00060\u0000j\u0002`\u0010H\u0000¢\u0006\u0002\bAR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\f\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u000f\u001a\u00060\u0000j\u0002`\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0015\u0010\u0015\u001a\u00060\u0000j\u0002`\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012¨\u0006F"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "", "()V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "_removedRef", "Lkotlinx/coroutines/experimental/internal/Removed;", "isFresh", "", "()Z", "isRemoved", "next", "getNext", "()Ljava/lang/Object;", "nextNode", "Lkotlinx/coroutines/experimental/internal/Node;", "getNextNode", "()Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "prev", "getPrev", "prevNode", "getPrevNode", "addLast", "", "node", "addLastIf", "condition", "Lkotlin/Function0;", "addLastIfPrev", "predicate", "Lkotlin/Function1;", "addLastIfPrevAndIf", "addNext", "addOneIfEmpty", "correctPrev", "op", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "describeAddLast", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "T", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "describeRemove", "Lkotlinx/coroutines/experimental/internal/AtomicDesc;", "describeRemoveFirst", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "findHead", "finishAdd", "finishRemove", "helpDelete", "makeCondAddOp", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$CondAddOp;", "markPrev", "remove", "removeFirstIfIsInstanceOf", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removed", "toString", "", "tryCondAddNext", "", "condAdd", "validateNode", "validateNode$kotlinx_coroutines_core", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: LockFreeLinkedList.kt */
public class LockFreeLinkedListNode {
    static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    private static final AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final Removed removed() {
        Removed removed = (Removed) this._removedRef;
        if (removed != null) {
            return removed;
        }
        Removed removed2 = new Removed(this);
        _removedRef$FU.lazySet(this, removed2);
        return removed2;
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/experimental/internal/AtomicOp;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "newNode", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: LockFreeLinkedList.kt */
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode newNode;
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "newNode");
            this.newNode = lockFreeLinkedListNode;
        }

        public void complete(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            boolean z = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z ? this.newNode : this.oldNext;
            if (lockFreeLinkedListNode2 != null && LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.newNode;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.oldNext;
                if (lockFreeLinkedListNode4 == null) {
                    Intrinsics.throwNpe();
                }
                lockFreeLinkedListNode3.finishAdd(lockFreeLinkedListNode4);
            }
        }
    }

    public final CondAddOp makeCondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode, Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function0, "condition");
        return new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
    }

    public final boolean isFresh() {
        return this._next == this;
    }

    public final boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    public final LockFreeLinkedListNode getPrevNode() {
        return LockFreeLinkedListKt.unwrap(getPrev());
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        _next$FU.lazySet(lockFreeLinkedListNode, this);
        while (getNext() == this) {
            if (_next$FU.compareAndSet(this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.finishAdd(this);
                return true;
            }
        }
        return false;
    }

    public final void addLast(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Object prev;
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        do {
            prev = getPrev();
            if (prev == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (!((LockFreeLinkedListNode) prev).addNext(lockFreeLinkedListNode, this));
    }

    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> describeAddLast(T t) {
        Intrinsics.checkParameterIsNotNull(t, "node");
        return new AddLastDesc<>(this, t);
    }

    public final boolean addLastIfPrev(LockFreeLinkedListNode lockFreeLinkedListNode, Function1<? super LockFreeLinkedListNode, Boolean> function1) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        do {
            Object prev = getPrev();
            if (prev != null) {
                lockFreeLinkedListNode2 = (LockFreeLinkedListNode) prev;
                if (!function1.invoke(lockFreeLinkedListNode2).booleanValue()) {
                    return false;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (!lockFreeLinkedListNode2.addNext(lockFreeLinkedListNode, this));
        return true;
    }

    public final boolean addNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.finishAdd(lockFreeLinkedListNode2);
        return true;
    }

    public final int tryCondAddNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, CondAddOp condAddOp) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        Intrinsics.checkParameterIsNotNull(condAddOp, "condAdd");
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.oldNext = lockFreeLinkedListNode2;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedListNode2, condAddOp)) {
            return 0;
        }
        return condAddOp.perform(this) == null ? 1 : 2;
    }

    public boolean remove() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            next = getNext();
            if ((next instanceof Removed) || next == this) {
                return false;
            }
            if (next != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (!_next$FU.compareAndSet(this, next, lockFreeLinkedListNode.removed()));
        finishRemove(lockFreeLinkedListNode);
        return true;
    }

    public AtomicDesc describeRemove() {
        if (isRemoved()) {
            return null;
        }
        return new LockFreeLinkedListNode$describeRemove$1(this);
    }

    public final LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            Object next = getNext();
            if (next != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode == this) {
                    return null;
                }
                if (lockFreeLinkedListNode.remove()) {
                    return lockFreeLinkedListNode;
                }
                lockFreeLinkedListNode.helpDelete();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
    }

    public final RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst() {
        return new RemoveFirstDesc<>(this);
    }

    private final <T> T removeFirstIfIsInstanceOf() {
        while (true) {
            Object next = getNext();
            if (next != null) {
                T t = (T) ((LockFreeLinkedListNode) next);
                if (t == this) {
                    return null;
                }
                Intrinsics.reifiedOperationMarker(3, "T");
                if (!(t instanceof Object)) {
                    return null;
                }
                if (t.remove()) {
                    return t;
                }
                t.helpDelete();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode, java.lang.Object] */
    private final <T> T removeFirstIfIsInstanceOfOrPeekIf(Function1<? super T, Boolean> function1) {
        while (true) {
            Object next = getNext();
            if (next != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode == this) {
                    return null;
                }
                Intrinsics.reifiedOperationMarker(3, "T");
                if (!(lockFreeLinkedListNode instanceof Object)) {
                    return null;
                }
                if (function1.invoke(lockFreeLinkedListNode).booleanValue() || lockFreeLinkedListNode.remove()) {
                    return lockFreeLinkedListNode;
                }
                lockFreeLinkedListNode.helpDelete();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0019\u0012\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J \u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0014J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0014J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0013\u001a\u00020\u0015H\u0014J\u0014\u0010\u0018\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0004J \u0010\u001b\u001a\u00020\u00152\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0014R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038DX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\u0006\u001a\u00028\u00008\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038DX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0005\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "T", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "queue", "node", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "_affectedNode", "Lkotlinx/atomicfu/AtomicRef;", "affectedNode", "getAffectedNode", "()Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "finishOnSuccess", "", "affected", "next", "onPrepare", "", "retry", "", "takeAffectedNode", "op", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "updatedNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: LockFreeLinkedList.kt */
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        private static final AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        private volatile Object _affectedNode;
        public final T node;
        public final LockFreeLinkedListNode queue;

        public AddLastDesc(LockFreeLinkedListNode lockFreeLinkedListNode, T t) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "queue");
            Intrinsics.checkParameterIsNotNull(t, "node");
            this.queue = lockFreeLinkedListNode;
            this.node = t;
            if (t._next == t && t._prev == t) {
                this._affectedNode = null;
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor) {
            Intrinsics.checkParameterIsNotNull(opDescriptor, "op");
            while (true) {
                Object obj = this.queue._prev;
                if (obj != null) {
                    LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                    Object obj2 = lockFreeLinkedListNode._next;
                    LockFreeLinkedListNode lockFreeLinkedListNode2 = this.queue;
                    if (obj2 == lockFreeLinkedListNode2 || obj2 == opDescriptor) {
                        return lockFreeLinkedListNode;
                    }
                    if (obj2 instanceof OpDescriptor) {
                        ((OpDescriptor) obj2).perform(lockFreeLinkedListNode);
                    } else {
                        LockFreeLinkedListNode correctPrev = lockFreeLinkedListNode2.correctPrev(lockFreeLinkedListNode, opDescriptor);
                        if (correctPrev != null) {
                            return correctPrev;
                        }
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode getOriginalNext() {
            return this.queue;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            return obj != this.queue;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            _affectedNode$FU.compareAndSet(this, null, lockFreeLinkedListNode);
            return null;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            LockFreeLinkedListNode._prev$FU.compareAndSet(this.node, this.node, lockFreeLinkedListNode);
            LockFreeLinkedListNode._next$FU.compareAndSet(this.node, this.node, this.queue);
            return this.node;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            this.node.finishAdd(this.queue);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0017\u001a\u00020\u0015H\u0014J \u0010\u0018\u001a\u00020\u00192\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0017\u001a\u00060\u0004j\u0002`\u0005H\u0004J\"\u0010\u001a\u001a\u0004\u0018\u00010\u00152\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0017\u001a\u00060\u0004j\u0002`\u0005H\u0004J\u001c\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0017\u001a\u00020\u0015H\u0004J\u0014\u0010\u001d\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0004J \u0010 \u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0017\u001a\u00060\u0004j\u0002`\u0005H\u0004J\u0015\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010#R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0003\u001a\u00060\u0004j\u0002`\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00028\u00008FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "T", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "queue", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "_affectedNode", "Lkotlinx/atomicfu/AtomicRef;", "_originalNext", "affectedNode", "getAffectedNode", "()Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "result", "result$annotations", "()V", "getResult", "()Ljava/lang/Object;", "failure", "", "affected", "next", "finishOnSuccess", "", "onPrepare", "retry", "", "takeAffectedNode", "op", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "updatedNext", "validatePrepared", "node", "(Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: LockFreeLinkedList.kt */
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        private static final AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
        private static final AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        private volatile Object _affectedNode = null;
        private volatile Object _originalNext = null;
        public final LockFreeLinkedListNode queue;

        public static /* synthetic */ void result$annotations() {
        }

        /* access modifiers changed from: protected */
        public boolean validatePrepared(T t) {
            return true;
        }

        public RemoveFirstDesc(LockFreeLinkedListNode lockFreeLinkedListNode) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "queue");
            this.queue = lockFreeLinkedListNode;
        }

        public final T getResult() {
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode == null) {
                Intrinsics.throwNpe();
            }
            return (T) affectedNode;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor) {
            Intrinsics.checkParameterIsNotNull(opDescriptor, "op");
            Object next = this.queue.getNext();
            if (next != null) {
                return (LockFreeLinkedListNode) next;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode getOriginalNext() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            if (lockFreeLinkedListNode == this.queue) {
                return LockFreeLinkedListKt.getLIST_EMPTY();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            if (!(obj instanceof Removed)) {
                return false;
            }
            lockFreeLinkedListNode.helpDelete();
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode$RemoveFirstDesc<T> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            if (!(!(lockFreeLinkedListNode instanceof LockFreeLinkedListHead))) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!validatePrepared(lockFreeLinkedListNode)) {
                return LockFreeLinkedListKt.REMOVE_PREPARED;
            } else {
                _affectedNode$FU.compareAndSet(this, null, lockFreeLinkedListNode);
                _originalNext$FU.compareAndSet(this, null, lockFreeLinkedListNode2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            return lockFreeLinkedListNode2.removed();
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            lockFreeLinkedListNode.finishRemove(lockFreeLinkedListNode2);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u000fH\u0014J \u0010\u0012\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$J\"\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u000fH\u0014J\u0014\u0010\u0017\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u0018H\u0014J \u0010\u0019\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$R\u001a\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/experimental/internal/AtomicDesc;", "()V", "affectedNode", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "getAffectedNode", "()Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "complete", "", "op", "Lkotlinx/coroutines/experimental/internal/AtomicOp;", "failure", "", "affected", "next", "finishOnSuccess", "onPrepare", "prepare", "retry", "", "takeAffectedNode", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "updatedNext", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: LockFreeLinkedList.kt */
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        /* access modifiers changed from: protected */
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            return null;
        }

        /* access modifiers changed from: protected */
        public abstract void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        /* access modifiers changed from: protected */
        public abstract LockFreeLinkedListNode getAffectedNode();

        /* access modifiers changed from: protected */
        public abstract LockFreeLinkedListNode getOriginalNext();

        /* access modifiers changed from: protected */
        public abstract Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        /* access modifiers changed from: protected */
        public boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        /* access modifiers changed from: protected */
        public LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor) {
            Intrinsics.checkParameterIsNotNull(opDescriptor, "op");
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode == null) {
                Intrinsics.throwNpe();
            }
            return affectedNode;
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc$PrepareOp;", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "next", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "op", "Lkotlinx/coroutines/experimental/internal/AtomicOp;", "desc", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/experimental/internal/AtomicOp;Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
        /* compiled from: LockFreeLinkedList.kt */
        private static final class PrepareOp extends OpDescriptor {
            public final AbstractAtomicDesc desc;
            public final LockFreeLinkedListNode next;
            public final AtomicOp<LockFreeLinkedListNode> op;

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.experimental.internal.AtomicOp<? super kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode> */
            /* JADX WARN: Multi-variable type inference failed */
            public PrepareOp(LockFreeLinkedListNode lockFreeLinkedListNode, AtomicOp<? super LockFreeLinkedListNode> atomicOp, AbstractAtomicDesc abstractAtomicDesc) {
                Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "next");
                Intrinsics.checkParameterIsNotNull(atomicOp, "op");
                Intrinsics.checkParameterIsNotNull(abstractAtomicDesc, "desc");
                this.next = lockFreeLinkedListNode;
                this.op = atomicOp;
                this.desc = abstractAtomicDesc;
            }

            @Override // kotlinx.coroutines.experimental.internal.OpDescriptor
            public Object perform(Object obj) {
                if (obj != null) {
                    LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                    Object onPrepare = this.desc.onPrepare(lockFreeLinkedListNode, this.next);
                    if (onPrepare != null) {
                        if (onPrepare == LockFreeLinkedListKt.REMOVE_PREPARED) {
                            if (LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.next.removed())) {
                                lockFreeLinkedListNode.helpDelete();
                            }
                        } else {
                            this.op.tryDecide(onPrepare);
                            LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.next);
                        }
                        return onPrepare;
                    }
                    LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.op.isDecided() ? this.next : this.op);
                    return null;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }

        @Override // kotlinx.coroutines.experimental.internal.AtomicDesc
        public final Object prepare(AtomicOp<?> atomicOp) {
            Object perform;
            Intrinsics.checkParameterIsNotNull(atomicOp, "op");
            while (true) {
                LockFreeLinkedListNode takeAffectedNode = takeAffectedNode(atomicOp);
                Object obj = takeAffectedNode._next;
                if (obj == atomicOp || atomicOp.isDecided()) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(takeAffectedNode);
                } else {
                    Object failure = failure(takeAffectedNode, obj);
                    if (failure != null) {
                        return failure;
                    }
                    if (retry(takeAffectedNode, obj)) {
                        continue;
                    } else if (obj != null) {
                        PrepareOp prepareOp = new PrepareOp((LockFreeLinkedListNode) obj, atomicOp, this);
                        if (LockFreeLinkedListNode._next$FU.compareAndSet(takeAffectedNode, obj, prepareOp) && (perform = prepareOp.perform(takeAffectedNode)) != LockFreeLinkedListKt.REMOVE_PREPARED) {
                            return perform;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                    }
                }
            }
        }

        @Override // kotlinx.coroutines.experimental.internal.AtomicDesc
        public final void complete(AtomicOp<?> atomicOp, Object obj) {
            Intrinsics.checkParameterIsNotNull(atomicOp, "op");
            boolean z = obj == null;
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode != null) {
                LockFreeLinkedListNode originalNext = getOriginalNext();
                if (originalNext != null) {
                    if (LockFreeLinkedListNode._next$FU.compareAndSet(affectedNode, atomicOp, z ? updatedNext(affectedNode, originalNext) : originalNext) && z) {
                        finishOnSuccess(affectedNode, originalNext);
                    }
                } else if (!(!z)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else if (!(!z)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void finishRemove(LockFreeLinkedListNode lockFreeLinkedListNode) {
        helpDelete();
        lockFreeLinkedListNode.correctPrev(LockFreeLinkedListKt.unwrap(this._prev), null);
    }

    private final LockFreeLinkedListNode findHead() {
        boolean z;
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
        while (!(lockFreeLinkedListNode2 instanceof LockFreeLinkedListHead)) {
            lockFreeLinkedListNode2 = lockFreeLinkedListNode2.getNextNode();
            if (lockFreeLinkedListNode2 != lockFreeLinkedListNode) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (!z) {
                throw new IllegalStateException("Cannot loop to this while looking for list head".toString());
            }
        }
        return lockFreeLinkedListNode2;
    }

    public final void helpDelete() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode = null;
        LockFreeLinkedListNode markPrev = markPrev();
        Object obj = this._next;
        if (obj != null) {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = ((Removed) obj).ref;
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = lockFreeLinkedListNode;
                while (true) {
                    Object next2 = lockFreeLinkedListNode2.getNext();
                    if (next2 instanceof Removed) {
                        lockFreeLinkedListNode2.markPrev();
                        lockFreeLinkedListNode2 = ((Removed) next2).ref;
                    } else {
                        next = markPrev.getNext();
                        if (next instanceof Removed) {
                            if (lockFreeLinkedListNode3 != null) {
                                break;
                            }
                            markPrev = LockFreeLinkedListKt.unwrap(markPrev._prev);
                        } else if (next != this) {
                            if (next != null) {
                                LockFreeLinkedListNode lockFreeLinkedListNode4 = (LockFreeLinkedListNode) next;
                                if (lockFreeLinkedListNode4 != lockFreeLinkedListNode2) {
                                    lockFreeLinkedListNode3 = markPrev;
                                    markPrev = lockFreeLinkedListNode4;
                                } else {
                                    return;
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                            }
                        } else if (_next$FU.compareAndSet(markPrev, this, lockFreeLinkedListNode2)) {
                            return;
                        }
                    }
                }
                markPrev.markPrev();
                _next$FU.compareAndSet(lockFreeLinkedListNode3, markPrev, ((Removed) next).ref);
                markPrev = lockFreeLinkedListNode3;
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Removed");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final LockFreeLinkedListNode correctPrev(LockFreeLinkedListNode lockFreeLinkedListNode, OpDescriptor opDescriptor) {
        Object obj;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = null;
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode3 = lockFreeLinkedListNode2;
            while (true) {
                obj = lockFreeLinkedListNode._next;
                if (obj == opDescriptor) {
                    return lockFreeLinkedListNode;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(lockFreeLinkedListNode);
                } else if (!(obj instanceof Removed)) {
                    Object obj2 = this._prev;
                    if (obj2 instanceof Removed) {
                        return null;
                    }
                    if (obj != this) {
                        if (obj != null) {
                            lockFreeLinkedListNode3 = lockFreeLinkedListNode;
                            lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                        }
                    } else if (obj2 == lockFreeLinkedListNode) {
                        return null;
                    } else {
                        if (_prev$FU.compareAndSet(this, obj2, lockFreeLinkedListNode) && !(lockFreeLinkedListNode._prev instanceof Removed)) {
                            return null;
                        }
                    }
                } else if (lockFreeLinkedListNode3 != null) {
                    break;
                } else {
                    lockFreeLinkedListNode = LockFreeLinkedListKt.unwrap(lockFreeLinkedListNode._prev);
                }
            }
            lockFreeLinkedListNode.markPrev();
            _next$FU.compareAndSet(lockFreeLinkedListNode3, lockFreeLinkedListNode, ((Removed) obj).ref);
            lockFreeLinkedListNode = lockFreeLinkedListNode3;
        }
    }

    public final void validateNode$kotlinx_coroutines_core(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "prev");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        boolean z = true;
        if (lockFreeLinkedListNode == this._prev) {
            if (lockFreeLinkedListNode2 != this._next) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }

    public final Object getNext() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public final Object getPrev() {
        while (true) {
            Object obj = this._prev;
            if (obj instanceof Removed) {
                return obj;
            }
            if (obj != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                if (lockFreeLinkedListNode.getNext() == this) {
                    return obj;
                }
                correctPrev(lockFreeLinkedListNode, null);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
    }

    public final boolean addLastIf(LockFreeLinkedListNode lockFreeLinkedListNode, Function0<Boolean> function0) {
        int tryCondAddNext;
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function0, "condition");
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
        do {
            Object prev = getPrev();
            if (prev != null) {
                tryCondAddNext = ((LockFreeLinkedListNode) prev).tryCondAddNext(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
                if (tryCondAddNext == 1) {
                    return true;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    public final boolean addLastIfPrevAndIf(LockFreeLinkedListNode lockFreeLinkedListNode, Function1<? super LockFreeLinkedListNode, Boolean> function1, Function0<Boolean> function0) {
        int tryCondAddNext;
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Intrinsics.checkParameterIsNotNull(function0, "condition");
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
        do {
            Object prev = getPrev();
            if (prev != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) prev;
                if (!function1.invoke(lockFreeLinkedListNode2).booleanValue()) {
                    return false;
                }
                tryCondAddNext = lockFreeLinkedListNode2.tryCondAddNext(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
                if (tryCondAddNext == 1) {
                    return true;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Object obj;
        do {
            obj = lockFreeLinkedListNode._prev;
            if ((obj instanceof Removed) || getNext() != lockFreeLinkedListNode) {
                return;
            }
        } while (!_prev$FU.compareAndSet(lockFreeLinkedListNode, obj, this));
        if (!(getNext() instanceof Removed)) {
            return;
        }
        if (obj != null) {
            lockFreeLinkedListNode.correctPrev((LockFreeLinkedListNode) obj, null);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }

    private final LockFreeLinkedListNode markPrev() {
        Object obj;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            obj = this._prev;
            if (obj instanceof Removed) {
                return ((Removed) obj).ref;
            }
            if (obj == this) {
                lockFreeLinkedListNode = findHead();
            } else if (obj != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (!_prev$FU.compareAndSet(this, obj, lockFreeLinkedListNode.removed()));
        return (LockFreeLinkedListNode) obj;
    }
}
