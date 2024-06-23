package kotlinx.coroutines.experimental.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutinesKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CancellableContinuation;
import kotlinx.coroutines.experimental.CancellableContinuationImpl;
import kotlinx.coroutines.experimental.CancellableContinuationKt;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.internal.AtomicDesc;
import kotlinx.coroutines.experimental.internal.AtomicOp;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.internal.OpDescriptor;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;
import kotlinx.coroutines.experimental.selects.SelectClause2;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import kotlinx.coroutines.experimental.selects.SelectKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\b()*+,-./B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u001b\u0010\u0015\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016JR\u0010\u0018\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\"\u0010\u001c\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001dH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003H\u0002J\b\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010'\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\"\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\t¨\u00060"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl;", "Lkotlinx/coroutines/experimental/sync/Mutex;", "Lkotlinx/coroutines/experimental/selects/SelectClause2;", "", "locked", "", "(Z)V", "_resumeNext", "Lkotlinx/atomicfu/AtomicRef;", "_state", "isLocked", "()Z", "isLockedEmptyQueueState", "isLockedEmptyQueueState$kotlinx_coroutines_core", "onLock", "getOnLock", "()Lkotlinx/coroutines/experimental/selects/SelectClause2;", "finishResumeNext", "", "holdsLock", "owner", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "lockSuspend", "registerSelectClause2", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "startResumeNext", "waiter", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockWaiter;", "token", "toString", "", "tryLock", "unlock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "ResumeReq", "TryEnqueueLockDesc", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Mutex.kt */
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {
    private static final AtomicReferenceFieldUpdater _resumeNext$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_resumeNext");
    static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    private volatile Object _resumeNext;
    volatile Object _state;

    public MutexImpl(boolean z) {
        this._state = z ? MutexKt.EmptyLocked : MutexKt.EmptyUnlocked;
        this._resumeNext = MutexKt.RESUME_QUIESCENT;
    }

    public final boolean isLockedEmptyQueueState$kotlinx_coroutines_core() {
        Object obj = this._state;
        return (obj instanceof LockedQueue) && ((LockedQueue) obj).isEmpty();
    }

    @Override // kotlinx.coroutines.experimental.sync.Mutex
    public Object lock(Object obj, Continuation<? super Unit> continuation) {
        if (tryLock(obj)) {
            return Unit.INSTANCE;
        }
        return lockSuspend(obj, continuation);
    }

    @Override // kotlinx.coroutines.experimental.sync.Mutex
    public SelectClause2<Object, Mutex> getOnLock() {
        return this;
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectClause2
    public <R> void registerSelectClause2(SelectInstance<? super R> selectInstance, Object obj, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        while (!selectInstance.isSelected()) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                if (empty.locked != MutexKt.UNLOCKED) {
                    _state$FU.compareAndSet(this, obj2, new LockedQueue(empty.locked));
                } else {
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(new TryLockDesc(this, obj));
                    if (performAtomicTrySelect == null) {
                        UndispatchedKt.startCoroutineUndispatched(function2, this, selectInstance.getCompletion());
                        return;
                    } else if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED()) {
                        if (performAtomicTrySelect != MutexKt.LOCK_FAIL) {
                            throw new IllegalStateException(("performAtomicTrySelect(TryLockDesc) returned " + performAtomicTrySelect).toString());
                        }
                    } else {
                        return;
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj2;
                if (lockedQueue.owner != obj) {
                    TryEnqueueLockDesc tryEnqueueLockDesc = new TryEnqueueLockDesc(this, obj, lockedQueue, selectInstance, function2);
                    Object performAtomicIfNotSelected = selectInstance.performAtomicIfNotSelected(tryEnqueueLockDesc);
                    if (performAtomicIfNotSelected == null) {
                        selectInstance.disposeOnSelect((DisposableHandle) tryEnqueueLockDesc.node);
                        return;
                    } else if (performAtomicIfNotSelected != SelectKt.getALREADY_SELECTED()) {
                        if (performAtomicIfNotSelected != MutexKt.ENQUEUE_FAIL) {
                            throw new IllegalStateException(("performAtomicIfNotSelected(TryEnqueueLockDesc) returned " + performAtomicIfNotSelected).toString());
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00052\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/experimental/internal/AtomicDesc;", "mutex", "Lkotlinx/coroutines/experimental/sync/MutexImpl;", "owner", "", "(Lkotlinx/coroutines/experimental/sync/MutexImpl;Ljava/lang/Object;)V", "complete", "", "op", "Lkotlinx/coroutines/experimental/internal/AtomicOp;", "failure", "prepare", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Mutex.kt */
    private static final class TryLockDesc extends AtomicDesc {
        public final MutexImpl mutex;
        public final Object owner;

        public TryLockDesc(MutexImpl mutexImpl, Object obj) {
            Intrinsics.checkParameterIsNotNull(mutexImpl, "mutex");
            this.mutex = mutexImpl;
            this.owner = obj;
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "op", "Lkotlinx/coroutines/experimental/internal/AtomicOp;", "(Lkotlinx/coroutines/experimental/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/experimental/internal/AtomicOp;)V", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
        /* compiled from: Mutex.kt */
        private final class PrepareOp extends OpDescriptor {
            private final AtomicOp<?> op;
            final /* synthetic */ TryLockDesc this$0;

            public PrepareOp(TryLockDesc tryLockDesc, AtomicOp<?> atomicOp) {
                Intrinsics.checkParameterIsNotNull(atomicOp, "op");
                this.this$0 = tryLockDesc;
                this.op = atomicOp;
            }

            @Override // kotlinx.coroutines.experimental.internal.OpDescriptor
            public Object perform(Object obj) {
                Object obj2 = this.op.isDecided() ? MutexKt.EmptyUnlocked : this.op;
                if (obj != null) {
                    MutexImpl._state$FU.compareAndSet((MutexImpl) obj, this, obj2);
                    return null;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.sync.MutexImpl");
            }
        }

        @Override // kotlinx.coroutines.experimental.internal.AtomicDesc
        public Object prepare(AtomicOp<?> atomicOp) {
            Intrinsics.checkParameterIsNotNull(atomicOp, "op");
            PrepareOp prepareOp = new PrepareOp(this, atomicOp);
            if (!MutexImpl._state$FU.compareAndSet(this.mutex, MutexKt.EmptyUnlocked, prepareOp)) {
                return MutexKt.LOCK_FAIL;
            }
            return prepareOp.perform(this.mutex);
        }

        @Override // kotlinx.coroutines.experimental.internal.AtomicDesc
        public void complete(AtomicOp<?> atomicOp, Object obj) {
            Empty empty;
            Intrinsics.checkParameterIsNotNull(atomicOp, "op");
            if (obj != null) {
                empty = MutexKt.EmptyUnlocked;
            } else {
                Object obj2 = this.owner;
                empty = obj2 == null ? MutexKt.EmptyLocked : new Empty(obj2);
            }
            MutexImpl._state$FU.compareAndSet(this.mutex, atomicOp, empty);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004BT\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0014R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$TryEnqueueLockDesc;", "R", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockSelect;", "Lkotlinx/coroutines/experimental/internal/AddLastDesc;", "mutex", "Lkotlinx/coroutines/experimental/sync/MutexImpl;", "owner", "", "queue", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockedQueue;", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/sync/Mutex;", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/experimental/sync/MutexImpl$LockedQueue;Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "onPrepare", "affected", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Mutex.kt */
    private static final class TryEnqueueLockDesc<R> extends LockFreeLinkedListNode.AddLastDesc<LockSelect<R>> {
        public final MutexImpl mutex;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TryEnqueueLockDesc(MutexImpl mutexImpl, Object obj, LockedQueue lockedQueue, SelectInstance<? super R> selectInstance, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
            super(lockedQueue, new LockSelect(obj, mutexImpl, selectInstance, function2));
            Intrinsics.checkParameterIsNotNull(mutexImpl, "mutex");
            Intrinsics.checkParameterIsNotNull(lockedQueue, "queue");
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            Intrinsics.checkParameterIsNotNull(function2, "block");
            this.mutex = mutexImpl;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc, kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AddLastDesc
        public Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            if (this.mutex._state != this.queue) {
                return MutexKt.ENQUEUE_FAIL;
            }
            return super.onPrepare(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        }
    }

    @Override // kotlinx.coroutines.experimental.sync.Mutex
    public boolean holdsLock(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "owner");
        Object obj2 = this._state;
        if (obj2 instanceof Empty) {
            if (((Empty) obj2).locked == obj) {
                return true;
            }
        } else if (!(obj2 instanceof LockedQueue) || ((LockedQueue) obj2).owner != obj) {
            return false;
        } else {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0004\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$ResumeReq;", "", "waiter", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockWaiter;", "token", "(Lkotlinx/coroutines/experimental/sync/MutexImpl$LockWaiter;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Mutex.kt */
    public static final class ResumeReq {
        public final Object token;
        public final LockWaiter waiter;

        public ResumeReq(LockWaiter lockWaiter, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockWaiter, "waiter");
            Intrinsics.checkParameterIsNotNull(obj, "token");
            this.waiter = lockWaiter;
            this.token = obj;
        }
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Mutex.kt */
    public static final class LockedQueue extends LockFreeLinkedListHead {
        public Object owner;

        public LockedQueue(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "owner");
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H&J\u0006\u0010\t\u001a\u00020\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H&R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/DisposableHandle;", "owner", "", "(Ljava/lang/Object;)V", "completeResumeLockWaiter", "", "token", "dispose", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Mutex.kt */
    public static abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
        public final Object owner;

        public abstract void completeResumeLockWaiter(Object obj);

        public abstract Object tryResumeLockWaiter();

        public LockWaiter(Object obj) {
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.experimental.DisposableHandle
        public final void dispose() {
            remove();
        }
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockWaiter;", "owner", "", "cont", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/CancellableContinuation;)V", "completeResumeLockWaiter", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Mutex.kt */
    public static final class LockCont extends LockWaiter {
        public final CancellableContinuation<Unit> cont;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.experimental.CancellableContinuation<? super kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LockCont(Object obj, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(obj);
            Intrinsics.checkParameterIsNotNull(cancellableContinuation, "cont");
            this.cont = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.experimental.sync.MutexImpl.LockWaiter
        public Object tryResumeLockWaiter() {
            return CancellableContinuation.DefaultImpls.tryResume$default(this.cont, Unit.INSTANCE, null, 2, null);
        }

        @Override // kotlinx.coroutines.experimental.sync.MutexImpl.LockWaiter
        public void completeResumeLockWaiter(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "token");
            this.cont.completeResume(obj);
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockCont[" + this.owner + ", " + this.cont + ']';
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BL\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016R1\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n8\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockWaiter;", "owner", "", "mutex", "Lkotlinx/coroutines/experimental/sync/Mutex;", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/sync/Mutex;Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "completeResumeLockWaiter", "", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Mutex.kt */
    private static final class LockSelect<R> extends LockWaiter {
        public final Function2<Mutex, Continuation<? super R>, Object> block;
        public final Mutex mutex;
        public final SelectInstance<R> select;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlinx.coroutines.experimental.selects.SelectInstance<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.experimental.sync.Mutex, ? super kotlin.coroutines.experimental.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LockSelect(Object obj, Mutex mutex2, SelectInstance<? super R> selectInstance, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
            super(obj);
            Intrinsics.checkParameterIsNotNull(mutex2, "mutex");
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            Intrinsics.checkParameterIsNotNull(function2, "block");
            this.mutex = mutex2;
            this.select = selectInstance;
            this.block = function2;
        }

        @Override // kotlinx.coroutines.experimental.sync.MutexImpl.LockWaiter
        public Object tryResumeLockWaiter() {
            if (this.select.trySelect(null)) {
                return MutexKt.SELECT_SUCCESS;
            }
            return null;
        }

        @Override // kotlinx.coroutines.experimental.sync.MutexImpl.LockWaiter
        public void completeResumeLockWaiter(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "token");
            if (obj == MutexKt.SELECT_SUCCESS) {
                CoroutinesKt.startCoroutine(this.block, this.mutex, this.select.getCompletion());
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockSelect[" + this.owner + ", " + this.mutex + ", " + this.select + ']';
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "queue", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/experimental/sync/MutexImpl$LockedQueue;)V", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Mutex.kt */
    private static final class UnlockOp extends OpDescriptor {
        public final LockedQueue queue;

        public UnlockOp(LockedQueue lockedQueue) {
            Intrinsics.checkParameterIsNotNull(lockedQueue, "queue");
            this.queue = lockedQueue;
        }

        @Override // kotlinx.coroutines.experimental.internal.OpDescriptor
        public Object perform(Object obj) {
            Object obj2 = this.queue.isEmpty() ? MutexKt.EmptyUnlocked : this.queue;
            if (obj != null) {
                MutexImpl mutexImpl = (MutexImpl) obj;
                MutexImpl._state$FU.compareAndSet(mutexImpl, this, obj2);
                if (mutexImpl._state == this.queue) {
                    return MutexKt.UNLOCK_FAIL;
                }
                return null;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.sync.MutexImpl");
        }
    }

    @Override // kotlinx.coroutines.experimental.sync.Mutex
    public boolean isLocked() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                return ((Empty) obj).locked != MutexKt.UNLOCKED;
            }
            if (obj instanceof LockedQueue) {
                return true;
            }
            if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.experimental.sync.Mutex
    public boolean tryLock(Object obj) {
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof Empty) {
                if (((Empty) obj2).locked != MutexKt.UNLOCKED) {
                    return false;
                }
                if (_state$FU.compareAndSet(this, obj2, obj == null ? MutexKt.EmptyLocked : new Empty(obj))) {
                    return true;
                }
            } else if (obj2 instanceof LockedQueue) {
                if (((LockedQueue) obj2).owner == obj) {
                    z = false;
                }
                if (z) {
                    return false;
                }
                throw new IllegalStateException(("Already locked by " + obj).toString());
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object lockSuspend(Object obj, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 0);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        LockCont lockCont = new LockCont(obj, cancellableContinuationImpl2);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                if (empty.locked != MutexKt.UNLOCKED) {
                    _state$FU.compareAndSet(this, obj2, new LockedQueue(empty.locked));
                } else {
                    if (_state$FU.compareAndSet(this, obj2, obj == null ? MutexKt.EmptyLocked : new Empty(obj))) {
                        cancellableContinuationImpl2.resume(Unit.INSTANCE);
                        break;
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj2;
                boolean z = true;
                if (lockedQueue.owner != obj) {
                    LockCont lockCont2 = lockCont;
                    MutexImpl$lockSuspend$$inlined$suspendAtomicCancellableCoroutine$lambda$1 mutexImpl$lockSuspend$$inlined$suspendAtomicCancellableCoroutine$lambda$1 = new MutexImpl$lockSuspend$$inlined$suspendAtomicCancellableCoroutine$lambda$1(lockCont2, lockCont2, obj2, cancellableContinuationImpl2, lockCont, this, obj);
                    while (true) {
                        Object prev = lockedQueue.getPrev();
                        if (prev != null) {
                            int tryCondAddNext = ((LockFreeLinkedListNode) prev).tryCondAddNext(lockCont2, lockedQueue, mutexImpl$lockSuspend$$inlined$suspendAtomicCancellableCoroutine$lambda$1);
                            if (tryCondAddNext != 1) {
                                if (tryCondAddNext == 2) {
                                    z = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                        }
                    }
                    if (z) {
                        cancellableContinuationImpl2.initCancellability();
                        CancellableContinuationKt.removeOnCancellation(cancellableContinuationImpl2, lockCont2);
                        break;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
        return cancellableContinuationImpl.getResult();
    }

    @Override // kotlinx.coroutines.experimental.sync.Mutex
    public void unlock(Object obj) {
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof Empty) {
                if (obj == null) {
                    if (((Empty) obj2).locked == MutexKt.UNLOCKED) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    Empty empty = (Empty) obj2;
                    if (empty.locked != obj) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException(("Mutex is locked by " + empty.locked + " but expected " + obj).toString());
                    }
                }
                if (_state$FU.compareAndSet(this, obj2, MutexKt.EmptyUnlocked)) {
                    return;
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else if (obj2 instanceof LockedQueue) {
                if (obj != null) {
                    LockedQueue lockedQueue = (LockedQueue) obj2;
                    if (lockedQueue.owner != obj) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException(("Mutex is locked by " + lockedQueue.owner + " but expected " + obj).toString());
                    }
                }
                LockedQueue lockedQueue2 = (LockedQueue) obj2;
                LockFreeLinkedListNode removeFirstOrNull = lockedQueue2.removeFirstOrNull();
                if (removeFirstOrNull == null) {
                    UnlockOp unlockOp = new UnlockOp(lockedQueue2);
                    if (_state$FU.compareAndSet(this, obj2, unlockOp) && unlockOp.perform(this) == null) {
                        return;
                    }
                } else {
                    LockWaiter lockWaiter = (LockWaiter) removeFirstOrNull;
                    Object tryResumeLockWaiter = lockWaiter.tryResumeLockWaiter();
                    if (tryResumeLockWaiter != null) {
                        Object obj3 = lockWaiter.owner;
                        if (obj3 == null) {
                            obj3 = MutexKt.LOCKED;
                        }
                        lockedQueue2.owner = obj3;
                        if (startResumeNext(lockWaiter, tryResumeLockWaiter)) {
                            lockWaiter.completeResumeLockWaiter(tryResumeLockWaiter);
                            finishResumeNext();
                            return;
                        }
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    private final boolean startResumeNext(LockWaiter lockWaiter, Object obj) {
        Object obj2;
        do {
            obj2 = this._resumeNext;
            if (obj2 == MutexKt.RESUME_QUIESCENT) {
                this._resumeNext = MutexKt.RESUME_ACTIVE;
                return true;
            } else if (obj2 != MutexKt.RESUME_ACTIVE) {
                throw new IllegalStateException("Cannot happen".toString());
            }
        } while (!_resumeNext$FU.compareAndSet(this, obj2, new ResumeReq(lockWaiter, obj)));
        return false;
    }

    private final void finishResumeNext() {
        while (true) {
            Object obj = this._resumeNext;
            if (obj == MutexKt.RESUME_ACTIVE) {
                if (_resumeNext$FU.compareAndSet(this, obj, MutexKt.RESUME_QUIESCENT)) {
                    return;
                }
            } else if (obj instanceof ResumeReq) {
                this._resumeNext = MutexKt.RESUME_ACTIVE;
                ResumeReq resumeReq = (ResumeReq) obj;
                resumeReq.waiter.completeResumeLockWaiter(resumeReq.token);
            } else {
                throw new IllegalStateException("Cannot happen".toString());
            }
        }
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                return "Mutex[" + ((Empty) obj).locked + ']';
            } else if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else if (obj instanceof LockedQueue) {
                return "Mutex[" + ((LockedQueue) obj).owner + ']';
            } else {
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
        }
    }
}
