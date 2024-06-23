package kotlinx.coroutines.experimental.channels;

import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutinesKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CancelHandler;
import kotlinx.coroutines.experimental.CancellableContinuation;
import kotlinx.coroutines.experimental.CancellableContinuationImpl;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;
import kotlinx.coroutines.experimental.selects.SelectClause1;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import kotlinx.coroutines.experimental.selects.SelectKt;

public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {
    /* access modifiers changed from: protected */
    public abstract boolean isBufferAlwaysEmpty();

    /* access modifiers changed from: protected */
    public abstract boolean isBufferEmpty();

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }

    public Object pollInternal() {
        Send takeFirstSendOrPeekClosed;
        Object tryResumeSend;
        do {
            takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
            if (takeFirstSendOrPeekClosed == null) {
                return AbstractChannelKt.POLL_FAILED;
            }
            tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend(null);
        } while (tryResumeSend == null);
        takeFirstSendOrPeekClosed.completeResumeSend(tryResumeSend);
        return takeFirstSendOrPeekClosed.getPollResult();
    }

    public Object pollSelectInternal(SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        TryPollDesc<E> describeTryPoll = describeTryPoll();
        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryPoll);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        Send send = (Send) describeTryPoll.getResult();
        Object obj = describeTryPoll.resumeToken;
        if (obj == null) {
            Intrinsics.throwNpe();
        }
        send.completeResumeSend(obj);
        return describeTryPoll.pollResult;
    }

    public final boolean getHasReceiveOrClosed() {
        return getQueue().getNextNode() instanceof ReceiveOrClosed;
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public final boolean isClosedForReceive() {
        return getClosedForReceive() != null && isBufferEmpty();
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public final boolean isEmpty() {
        return !(getQueue().getNextNode() instanceof Send) && isBufferEmpty();
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public final Object receive(Continuation<? super E> continuation) {
        Object pollInternal = pollInternal();
        if (pollInternal != AbstractChannelKt.POLL_FAILED) {
            return receiveResult(pollInternal);
        }
        return receiveSuspend(continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private final E receiveResult(Object obj) {
        if (!(obj instanceof Closed)) {
            return obj;
        }
        throw ((Closed) obj).getReceiveException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    private final boolean enqueueReceive(Receive<? super E> receive) {
        boolean z = false;
        if (isBufferAlwaysEmpty()) {
            LockFreeLinkedListHead queue = getQueue();
            while (true) {
                Object prev = queue.getPrev();
                if (prev != null) {
                    LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
                    if (!(lockFreeLinkedListNode instanceof Send)) {
                        if (lockFreeLinkedListNode.addNext(receive, queue)) {
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
                onReceiveEnqueued();
            }
            return z;
        }
        LockFreeLinkedListHead queue2 = getQueue();
        Receive<? super E> receive2 = receive;
        AbstractChannel$enqueueReceive$$inlined$addLastIfPrevAndIf$1 abstractChannel$enqueueReceive$$inlined$addLastIfPrevAndIf$1 = new AbstractChannel$enqueueReceive$$inlined$addLastIfPrevAndIf$1(receive2, receive2, this);
        while (true) {
            Object prev2 = queue2.getPrev();
            if (prev2 != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) prev2;
                if (!(!(lockFreeLinkedListNode2 instanceof Send))) {
                    break;
                }
                int tryCondAddNext = lockFreeLinkedListNode2.tryCondAddNext(receive2, queue2, abstractChannel$enqueueReceive$$inlined$addLastIfPrevAndIf$1);
                if (tryCondAddNext != 1) {
                    if (tryCondAddNext == 2) {
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
        }
        return z;
        z = true;
        if (z) {
        }
        return z;
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public final Object receiveOrNull(Continuation<? super E> continuation) {
        Object pollInternal = pollInternal();
        if (pollInternal != AbstractChannelKt.POLL_FAILED) {
            return receiveOrNullResult(pollInternal);
        }
        return receiveOrNullSuspend(continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private final E receiveOrNullResult(Object obj) {
        if (!(obj instanceof Closed)) {
            return obj;
        }
        Closed closed = (Closed) obj;
        if (closed.closeCause == null) {
            return null;
        }
        throw closed.closeCause;
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public final E poll() {
        Object pollInternal = pollInternal();
        if (pollInternal == AbstractChannelKt.POLL_FAILED) {
            return null;
        }
        return receiveOrNullResult(pollInternal);
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public boolean cancel(Throwable th) {
        boolean close = close(th);
        cleanupSendQueueOnCancel();
        return close;
    }

    public void cleanupSendQueueOnCancel() {
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend != null) {
            while (true) {
                Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                if (takeFirstSendOrPeekClosed == null) {
                    throw new IllegalStateException("Cannot happen".toString());
                } else if (takeFirstSendOrPeekClosed instanceof Closed) {
                    if (!(takeFirstSendOrPeekClosed == closedForSend)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    return;
                } else {
                    takeFirstSendOrPeekClosed.resumeSendClosed(closedForSend);
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return new Itr(this);
    }

    public final TryPollDesc<E> describeTryPoll() {
        return new TryPollDesc<>(getQueue());
    }

    public static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        public E pollResult;
        public Object resumeToken;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TryPollDesc(LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListHead, "queue");
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            if (lockFreeLinkedListNode instanceof Closed) {
                return lockFreeLinkedListNode;
            }
            if (!(lockFreeLinkedListNode instanceof Send)) {
                return AbstractChannelKt.POLL_FAILED;
            }
            return null;
        }

        public boolean validatePrepared(Send send) {
            Intrinsics.checkParameterIsNotNull(send, "node");
            Object tryResumeSend = send.tryResumeSend(this);
            if (tryResumeSend == null) {
                return false;
            }
            this.resumeToken = tryResumeSend;
            this.pollResult = (E) send.getPollResult();
            return true;
        }
    }

    public final class TryEnqueueReceiveDesc<E, R> extends LockFreeLinkedListNode.AddLastDesc<AbstractChannel<E>.ReceiveSelect> {
        final /* synthetic */ AbstractChannel this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TryEnqueueReceiveDesc(AbstractChannel abstractChannel, SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, boolean z) {
            super(abstractChannel.getQueue(), new ReceiveSelect(abstractChannel, selectInstance, function2, z));
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            Intrinsics.checkParameterIsNotNull(function2, "block");
            this.this$0 = abstractChannel;
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            if (lockFreeLinkedListNode instanceof Send) {
                return AbstractChannelKt.ENQUEUE_FAILED;
            }
            return null;
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc, kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AddLastDesc
        public Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            if (!this.this$0.isBufferEmpty()) {
                return AbstractChannelKt.ENQUEUE_FAILED;
            }
            return super.onPrepare(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc, kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AddLastDesc
        public void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            super.finishOnSuccess(lockFreeLinkedListNode, lockFreeLinkedListNode2);
            this.this$0.onReceiveEnqueued();
            ((ReceiveSelect) this.node).removeOnSelectCompletion();
        }
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public final SelectClause1<E> getOnReceive() {
        return new AbstractChannel$onReceive$1(this);
    }

    /* access modifiers changed from: public */
    private final <R> void registerSelectReceive(SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (!isEmpty()) {
                Object pollSelectInternal = pollSelectInternal(selectInstance);
                if (pollSelectInternal != SelectKt.getALREADY_SELECTED()) {
                    if (pollSelectInternal != AbstractChannelKt.POLL_FAILED) {
                        if (!(pollSelectInternal instanceof Closed)) {
                            UndispatchedKt.startCoroutineUndispatched(function2, pollSelectInternal, selectInstance.getCompletion());
                            return;
                        }
                        throw ((Closed) pollSelectInternal).getReceiveException();
                    }
                } else {
                    return;
                }
            } else if (function2 != null) {
                Object performAtomicIfNotSelected = selectInstance.performAtomicIfNotSelected(new TryEnqueueReceiveDesc(this, selectInstance, function2, false));
                if (performAtomicIfNotSelected != null && performAtomicIfNotSelected != SelectKt.getALREADY_SELECTED()) {
                    if (performAtomicIfNotSelected != AbstractChannelKt.ENQUEUE_FAILED) {
                        throw new IllegalStateException(("performAtomicIfNotSelected(TryEnqueueReceiveDesc) returned " + performAtomicIfNotSelected).toString());
                    }
                } else {
                    return;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type suspend (E?) -> R");
            }
        }
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public final SelectClause1<E> getOnReceiveOrNull() {
        return new AbstractChannel$onReceiveOrNull$1(this);
    }

    /* access modifiers changed from: public */
    private final <R> void registerSelectReceiveOrNull(SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (isEmpty()) {
                Object performAtomicIfNotSelected = selectInstance.performAtomicIfNotSelected(new TryEnqueueReceiveDesc(this, selectInstance, function2, true));
                if (performAtomicIfNotSelected != null && performAtomicIfNotSelected != SelectKt.getALREADY_SELECTED()) {
                    if (performAtomicIfNotSelected != AbstractChannelKt.ENQUEUE_FAILED) {
                        throw new IllegalStateException(("performAtomicIfNotSelected(TryEnqueueReceiveDesc) returned " + performAtomicIfNotSelected).toString());
                    }
                } else {
                    return;
                }
            } else {
                Object pollSelectInternal = pollSelectInternal(selectInstance);
                if (pollSelectInternal != SelectKt.getALREADY_SELECTED()) {
                    if (pollSelectInternal != AbstractChannelKt.POLL_FAILED) {
                        if (pollSelectInternal instanceof Closed) {
                            Closed closed = (Closed) pollSelectInternal;
                            if (closed.closeCause != null) {
                                throw closed.closeCause;
                            } else if (selectInstance.trySelect(null)) {
                                UndispatchedKt.startCoroutineUndispatched(function2, null, selectInstance.getCompletion());
                                return;
                            } else {
                                return;
                            }
                        } else {
                            UndispatchedKt.startCoroutineUndispatched(function2, pollSelectInternal, selectInstance.getCompletion());
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = super.takeFirstReceiveOrPeekClosed();
        if (takeFirstReceiveOrPeekClosed != null && !(takeFirstReceiveOrPeekClosed instanceof Closed)) {
            onReceiveDequeued();
        }
        return takeFirstReceiveOrPeekClosed;
    }

    private final void removeReceiveOnCancel(CancellableContinuation<?> cancellableContinuation, Receive<?> receive) {
        cancellableContinuation.invokeOnCancellation(new RemoveReceiveOnCancel(this, receive));
    }

    public final class RemoveReceiveOnCancel extends CancelHandler {
        private final Receive<?> receive;
        final /* synthetic */ AbstractChannel this$0;

        public RemoveReceiveOnCancel(AbstractChannel abstractChannel, Receive<?> receive2) {
            Intrinsics.checkParameterIsNotNull(receive2, "receive");
            this.this$0 = abstractChannel;
            this.receive = receive2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.experimental.CancelHandlerBase
        public void invoke(Throwable th) {
            if (this.receive.remove()) {
                this.this$0.onReceiveDequeued();
            }
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.receive + ']';
        }
    }

    /* access modifiers changed from: private */
    public static final class Itr<E> implements ChannelIterator<E> {
        private final AbstractChannel<E> channel;
        private Object result = AbstractChannelKt.POLL_FAILED;

        public Itr(AbstractChannel<E> abstractChannel) {
            Intrinsics.checkParameterIsNotNull(abstractChannel, "channel");
            this.channel = abstractChannel;
        }

        public final AbstractChannel<E> getChannel() {
            return this.channel;
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        @Override // kotlinx.coroutines.experimental.channels.ChannelIterator
        public Object hasNext(Continuation<? super Boolean> continuation) {
            if (this.result != AbstractChannelKt.POLL_FAILED) {
                return Boolean.valueOf(hasNextResult(this.result));
            }
            Object pollInternal = this.channel.pollInternal();
            this.result = pollInternal;
            if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                return Boolean.valueOf(hasNextResult(this.result));
            }
            return hasNextSuspend(continuation);
        }

        private final boolean hasNextResult(Object obj) {
            if (!(obj instanceof Closed)) {
                return true;
            }
            Closed closed = (Closed) obj;
            if (closed.closeCause == null) {
                return false;
            }
            throw closed.getReceiveException();
        }

        @Override // kotlinx.coroutines.experimental.channels.ChannelIterator
        public Object next(Continuation<? super E> continuation) {
            Object obj = this.result;
            if (obj instanceof Closed) {
                throw ((Closed) obj).getReceiveException();
            } else if (obj == AbstractChannelKt.POLL_FAILED) {
                return this.channel.receive(continuation);
            } else {
                this.result = AbstractChannelKt.POLL_FAILED;
                return obj;
            }
        }

        public final /* synthetic */ Object hasNextSuspend(Continuation<? super Boolean> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 0);
            CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            ReceiveHasNext receiveHasNext = new ReceiveHasNext(this, cancellableContinuationImpl2);
            while (true) {
                ReceiveHasNext receiveHasNext2 = receiveHasNext;
                if (!getChannel().enqueueReceive(receiveHasNext2)) {
                    Object pollInternal = getChannel().pollInternal();
                    setResult(pollInternal);
                    if (!(pollInternal instanceof Closed)) {
                        if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                            cancellableContinuationImpl2.resume(true);
                            break;
                        }
                    } else {
                        Closed closed = (Closed) pollInternal;
                        if (closed.closeCause == null) {
                            cancellableContinuationImpl2.resume(false);
                        } else {
                            cancellableContinuationImpl2.resumeWithException(closed.getReceiveException());
                        }
                    }
                } else {
                    cancellableContinuationImpl2.initCancellability();
                    getChannel().removeReceiveOnCancel(cancellableContinuationImpl2, receiveHasNext2);
                    break;
                }
            }
            return cancellableContinuationImpl.getResult();
        }
    }

    public static final class ReceiveElement<E> extends Receive<E> {
        public final CancellableContinuation<E> cont;
        public final boolean nullOnClose;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.experimental.CancellableContinuation<? super E> */
        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveElement(CancellableContinuation<? super E> cancellableContinuation, boolean z) {
            Intrinsics.checkParameterIsNotNull(cancellableContinuation, "cont");
            this.cont = cancellableContinuation;
            this.nullOnClose = z;
        }

        @Override // kotlinx.coroutines.experimental.channels.ReceiveOrClosed
        public Object tryResumeReceive(E e, Object obj) {
            return this.cont.tryResume(e, obj);
        }

        @Override // kotlinx.coroutines.experimental.channels.ReceiveOrClosed
        public void completeResumeReceive(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "token");
            this.cont.completeResume(obj);
        }

        @Override // kotlinx.coroutines.experimental.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            Intrinsics.checkParameterIsNotNull(closed, "closed");
            if (closed.closeCause != null || !this.nullOnClose) {
                this.cont.resumeWithException(closed.getReceiveException());
            } else {
                this.cont.resume(null);
            }
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveElement[" + this.cont + ",nullOnClose=" + this.nullOnClose + ']';
        }
    }

    public static final class ReceiveHasNext<E> extends Receive<E> {
        public final CancellableContinuation<Boolean> cont;
        public final Itr<E> iterator;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.experimental.CancellableContinuation<? super java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveHasNext(Itr<E> itr, CancellableContinuation<? super Boolean> cancellableContinuation) {
            Intrinsics.checkParameterIsNotNull(itr, "iterator");
            Intrinsics.checkParameterIsNotNull(cancellableContinuation, "cont");
            this.iterator = itr;
            this.cont = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.experimental.channels.ReceiveOrClosed
        public Object tryResumeReceive(E e, Object obj) {
            Object tryResume = this.cont.tryResume(true, obj);
            if (tryResume != null) {
                if (obj != null) {
                    return new IdempotentTokenValue(tryResume, e);
                }
                this.iterator.setResult(e);
            }
            return tryResume;
        }

        @Override // kotlinx.coroutines.experimental.channels.ReceiveOrClosed
        public void completeResumeReceive(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "token");
            if (obj instanceof IdempotentTokenValue) {
                IdempotentTokenValue idempotentTokenValue = (IdempotentTokenValue) obj;
                this.iterator.setResult(idempotentTokenValue.value);
                this.cont.completeResume(idempotentTokenValue.token);
                return;
            }
            this.cont.completeResume(obj);
        }

        @Override // kotlinx.coroutines.experimental.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            Object obj;
            Intrinsics.checkParameterIsNotNull(closed, "closed");
            if (closed.closeCause == null) {
                obj = CancellableContinuation.DefaultImpls.tryResume$default(this.cont, false, null, 2, null);
            } else {
                obj = this.cont.tryResumeWithException(closed.getReceiveException());
            }
            if (obj != null) {
                this.iterator.setResult(closed);
                this.cont.completeResume(obj);
            }
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveHasNext[" + this.cont + ']';
        }
    }

    /* access modifiers changed from: private */
    public final class ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {
        public final Function2<E, Continuation<? super R>, Object> block;
        public final boolean nullOnClose;
        public final SelectInstance<R> select;
        final /* synthetic */ AbstractChannel this$0;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.experimental.selects.SelectInstance<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.experimental.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveSelect(AbstractChannel abstractChannel, SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, boolean z) {
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            Intrinsics.checkParameterIsNotNull(function2, "block");
            this.this$0 = abstractChannel;
            this.select = selectInstance;
            this.block = function2;
            this.nullOnClose = z;
        }

        @Override // kotlinx.coroutines.experimental.channels.ReceiveOrClosed
        public Object tryResumeReceive(E e, Object obj) {
            if (this.select.trySelect(obj)) {
                return e != null ? e : AbstractChannelKt.NULL_VALUE;
            }
            return null;
        }

        @Override // kotlinx.coroutines.experimental.channels.ReceiveOrClosed
        public void completeResumeReceive(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "token");
            if (obj == AbstractChannelKt.NULL_VALUE) {
                obj = null;
            }
            CoroutinesKt.startCoroutine(this.block, obj, this.select.getCompletion());
        }

        @Override // kotlinx.coroutines.experimental.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            Intrinsics.checkParameterIsNotNull(closed, "closed");
            if (!this.select.trySelect(null)) {
                return;
            }
            if (closed.closeCause != null || !this.nullOnClose) {
                this.select.resumeSelectCancellableWithException(closed.getReceiveException());
            } else {
                CoroutinesKt.startCoroutine(this.block, null, this.select.getCompletion());
            }
        }

        public final void removeOnSelectCompletion() {
            this.select.disposeOnSelect(this);
        }

        @Override // kotlinx.coroutines.experimental.DisposableHandle
        public void dispose() {
            if (remove()) {
                this.this$0.onReceiveDequeued();
            }
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveSelect[" + this.select + ",nullOnClose=" + this.nullOnClose + ']';
        }
    }

    private static final class IdempotentTokenValue<E> {
        public final Object token;
        public final E value;

        public IdempotentTokenValue(Object obj, E e) {
            Intrinsics.checkParameterIsNotNull(obj, "token");
            this.token = obj;
            this.value = e;
        }
    }

    public final /* synthetic */ Object receiveSuspend(Continuation<? super E> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 0);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ReceiveElement receiveElement = new ReceiveElement(cancellableContinuationImpl2, false);
        while (true) {
            ReceiveElement receiveElement2 = receiveElement;
            if (!enqueueReceive(receiveElement2)) {
                Object pollInternal = pollInternal();
                if (!(pollInternal instanceof Closed)) {
                    if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                        cancellableContinuationImpl2.resume(pollInternal);
                        break;
                    }
                } else {
                    cancellableContinuationImpl2.resumeWithException(((Closed) pollInternal).getReceiveException());
                    break;
                }
            } else {
                cancellableContinuationImpl2.initCancellability();
                removeReceiveOnCancel(cancellableContinuationImpl2, receiveElement2);
                break;
            }
        }
        return cancellableContinuationImpl.getResult();
    }

    public final /* synthetic */ Object receiveOrNullSuspend(Continuation<? super E> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 0);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ReceiveElement receiveElement = new ReceiveElement(cancellableContinuationImpl2, true);
        while (true) {
            ReceiveElement receiveElement2 = receiveElement;
            if (!enqueueReceive(receiveElement2)) {
                Object pollInternal = pollInternal();
                if (!(pollInternal instanceof Closed)) {
                    if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                        cancellableContinuationImpl2.resume(pollInternal);
                        break;
                    }
                } else {
                    Closed closed = (Closed) pollInternal;
                    if (closed.closeCause == null) {
                        cancellableContinuationImpl2.resume(null);
                    } else {
                        cancellableContinuationImpl2.resumeWithException(closed.closeCause);
                    }
                }
            } else {
                cancellableContinuationImpl2.initCancellability();
                removeReceiveOnCancel(cancellableContinuationImpl2, receiveElement2);
                break;
            }
        }
        return cancellableContinuationImpl.getResult();
    }
}
