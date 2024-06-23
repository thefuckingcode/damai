package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.model.HttpHeaders;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutinesKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CancellableContinuationImpl;
import kotlinx.coroutines.experimental.CancellableContinuationKt;
import kotlinx.coroutines.experimental.DebugKt;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;
import kotlinx.coroutines.experimental.selects.SelectClause2;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import kotlinx.coroutines.experimental.selects.SelectKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0006OPQRSTB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0012\u0010\"\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0004J\b\u0010&\u001a\u00020'H\u0002J!\u0010(\u001a\u000e\u0012\u0002\b\u00030)j\u0006\u0012\u0002\b\u0003`*2\u0006\u0010+\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010,J!\u0010-\u001a\u000e\u0012\u0002\b\u00030)j\u0006\u0012\u0002\b\u0003`*2\u0006\u0010+\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010,J\u001b\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/2\u0006\u0010+\u001a\u00028\u0000H\u0004¢\u0006\u0002\u00100J\u0012\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0002J\u0013\u00105\u001a\u00020\u000f2\u0006\u0010+\u001a\u00028\u0000¢\u0006\u0002\u00106J\u0015\u00107\u001a\u0002022\u0006\u0010+\u001a\u00028\u0000H\u0014¢\u0006\u0002\u00108J!\u00109\u001a\u0002022\u0006\u0010+\u001a\u00028\u00002\n\u0010:\u001a\u0006\u0012\u0002\b\u00030;H\u0014¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\u00020\u001f2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0014JV\u0010?\u001a\u00020\u001f\"\u0004\b\u0001\u0010@2\f\u0010:\u001a\b\u0012\u0004\u0012\u0002H@0;2\u0006\u0010+\u001a\u00028\u00002(\u0010A\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H@0C\u0012\u0006\u0012\u0004\u0018\u0001020BH\u0002ø\u0001\u0000¢\u0006\u0002\u0010DJ\u0019\u00103\u001a\u00020\u001f2\u0006\u0010+\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010EJ\u001b\u0010F\u001a\b\u0012\u0002\b\u0003\u0018\u00010G2\u0006\u0010+\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010HJ\u001b\u0010I\u001a\b\u0012\u0002\b\u0003\u0018\u00010G2\u0006\u0010+\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010HJ\u0019\u0010J\u001a\u00020\u001f2\u0006\u0010+\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010EJ\u0010\u0010K\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010GH\u0014J\n\u0010L\u001a\u0004\u0018\u00010MH\u0004J\b\u0010N\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R#\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007\u0002\u0004\n\u0002\b\t¨\u0006U"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel;", "E", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "()V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "closedForReceive", "Lkotlinx/coroutines/experimental/channels/Closed;", "getClosedForReceive", "()Lkotlinx/coroutines/experimental/channels/Closed;", "closedForSend", "getClosedForSend", "isBufferAlwaysFull", "", "()Z", "isBufferFull", "isClosedForSend", "isFull", "onSend", "Lkotlinx/coroutines/experimental/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/experimental/selects/SelectClause2;", "queue", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "queueDebugStateString", "getQueueDebugStateString", "afterClose", "", "cause", "", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "conflatePreviousSendBuffered", "node", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "countQueueSize", "", "describeSendBuffered", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/experimental/internal/AddLastDesc;", "element", "(Ljava/lang/Object;)Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "describeSendConflated", "describeTryOffer", "Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$TryOfferDesc;", "(Ljava/lang/Object;)Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$TryOfferDesc;", "enqueueSend", "", "send", "Lkotlinx/coroutines/experimental/channels/SendElement;", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/selects/SelectInstance;)Ljava/lang/Object;", "onClosed", "closed", "registerSelectSend", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "sendBuffered", "Lkotlinx/coroutines/experimental/channels/ReceiveOrClosed;", "(Ljava/lang/Object;)Lkotlinx/coroutines/experimental/channels/ReceiveOrClosed;", "sendConflated", "sendSuspend", "takeFirstReceiveOrPeekClosed", "takeFirstSendOrPeekClosed", "Lkotlinx/coroutines/experimental/channels/Send;", "toString", "SendBuffered", "SendBufferedDesc", "SendConflatedDesc", "SendSelect", "TryEnqueueSendDesc", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: AbstractChannel.kt */
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    private final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();

    /* access modifiers changed from: protected */
    public void afterClose(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public String getBufferDebugString() {
        return "";
    }

    /* access modifiers changed from: protected */
    public abstract boolean isBufferAlwaysFull();

    /* access modifiers changed from: protected */
    public abstract boolean isBufferFull();

    /* access modifiers changed from: protected */
    public void onClosed(Closed<? super E> closed) {
        Intrinsics.checkParameterIsNotNull(closed, "closed");
    }

    /* access modifiers changed from: protected */
    public final LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    /* access modifiers changed from: protected */
    public Object offerInternal(E e) {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed;
        Object tryResumeReceive;
        do {
            takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
            if (takeFirstReceiveOrPeekClosed == null) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e, null);
        } while (tryResumeReceive == null);
        takeFirstReceiveOrPeekClosed.completeResumeReceive(tryResumeReceive);
        return takeFirstReceiveOrPeekClosed.getOfferResult();
    }

    /* access modifiers changed from: protected */
    public Object offerSelectInternal(E e, SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        TryOfferDesc<E> describeTryOffer = describeTryOffer(e);
        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryOffer);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) describeTryOffer.getResult();
        Object obj = describeTryOffer.resumeToken;
        if (obj == null) {
            Intrinsics.throwNpe();
        }
        receiveOrClosed.completeResumeReceive(obj);
        return receiveOrClosed.getOfferResult();
    }

    /* access modifiers changed from: protected */
    public final Closed<?> getClosedForSend() {
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (!(prevNode instanceof Closed)) {
            prevNode = null;
        }
        return (Closed) prevNode;
    }

    /* access modifiers changed from: protected */
    public final Closed<?> getClosedForReceive() {
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (!(nextNode instanceof Closed)) {
            nextNode = null;
        }
        return (Closed) nextNode;
    }

    /* access modifiers changed from: protected */
    public final Send takeFirstSendOrPeekClosed() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            Object next = lockFreeLinkedListHead.getNext();
            if (next != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof Send)) {
                    if ((((Send) lockFreeLinkedListNode) instanceof Closed) || lockFreeLinkedListNode.remove()) {
                        break;
                    }
                    lockFreeLinkedListNode.helpDelete();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
        lockFreeLinkedListNode = null;
        return (Send) lockFreeLinkedListNode;
    }

    /* access modifiers changed from: protected */
    public final ReceiveOrClosed<?> sendBuffered(E e) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        SendBuffered sendBuffered = new SendBuffered(e);
        do {
            Object prev = lockFreeLinkedListHead.getPrev();
            if (prev != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
                if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                    return (ReceiveOrClosed) lockFreeLinkedListNode;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (!lockFreeLinkedListNode.addNext(sendBuffered, lockFreeLinkedListHead));
        return null;
    }

    /* access modifiers changed from: protected */
    public final ReceiveOrClosed<?> sendConflated(E e) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        SendBuffered sendBuffered = new SendBuffered(e);
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        do {
            Object prev = lockFreeLinkedListHead.getPrev();
            if (prev != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
                if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                    return (ReceiveOrClosed) lockFreeLinkedListNode;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (!lockFreeLinkedListNode.addNext(sendBuffered, lockFreeLinkedListHead));
        conflatePreviousSendBuffered(sendBuffered);
        return null;
    }

    /* access modifiers changed from: protected */
    public final void conflatePreviousSendBuffered(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        LockFreeLinkedListNode prevNode = lockFreeLinkedListNode.getPrevNode();
        if (!(prevNode instanceof SendBuffered)) {
            prevNode = null;
        }
        SendBuffered sendBuffered = (SendBuffered) prevNode;
        if (sendBuffered != null) {
            sendBuffered.remove();
        }
    }

    /* access modifiers changed from: protected */
    public final LockFreeLinkedListNode.AddLastDesc<?> describeSendBuffered(E e) {
        return new SendBufferedDesc(this.queue, e);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0014¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendBufferedDesc;", "E", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/experimental/internal/AddLastDesc;", "queue", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "failure", "", "affected", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AbstractChannel.kt */
    private static class SendBufferedDesc<E> extends LockFreeLinkedListNode.AddLastDesc<SendBuffered<? extends E>> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendBufferedDesc(LockFreeLinkedListHead lockFreeLinkedListHead, E e) {
            super(lockFreeLinkedListHead, new SendBuffered(e));
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListHead, "queue");
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final LockFreeLinkedListNode.AddLastDesc<?> describeSendConflated(E e) {
        return new SendConflatedDesc(this.queue, e);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendConflatedDesc;", "E", "Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendBufferedDesc;", "queue", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "finishOnSuccess", "", "affected", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AbstractChannel.kt */
    private static final class SendConflatedDesc<E> extends SendBufferedDesc<E> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendConflatedDesc(LockFreeLinkedListHead lockFreeLinkedListHead, E e) {
            super(lockFreeLinkedListHead, e);
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListHead, "queue");
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc, kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AddLastDesc
        public void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            super.finishOnSuccess(lockFreeLinkedListNode, lockFreeLinkedListNode2);
            if (!(lockFreeLinkedListNode instanceof SendBuffered)) {
                lockFreeLinkedListNode = null;
            }
            SendBuffered sendBuffered = (SendBuffered) lockFreeLinkedListNode;
            if (sendBuffered != null) {
                sendBuffered.remove();
            }
        }
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public final boolean isClosedForSend() {
        return getClosedForSend() != null;
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public final boolean isFull() {
        return !(this.queue.getNextNode() instanceof ReceiveOrClosed) && isBufferFull();
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public final Object send(E e, Continuation<? super Unit> continuation) {
        if (offer(e)) {
            return Unit.INSTANCE;
        }
        return sendSuspend(e, continuation);
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public final boolean offer(E e) {
        Object offerInternal = offerInternal(e);
        if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
            return true;
        }
        if (offerInternal == AbstractChannelKt.OFFER_FAILED) {
            return false;
        }
        if (offerInternal instanceof Closed) {
            throw ((Closed) offerInternal).getSendException();
        }
        throw new IllegalStateException(("offerInternal returned " + offerInternal).toString());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final Object enqueueSend(SendElement sendElement) {
        boolean z;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        if (isBufferAlwaysFull()) {
            LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
            do {
                Object prev = lockFreeLinkedListHead.getPrev();
                if (prev != null) {
                    lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
                    if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                        return lockFreeLinkedListNode;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                }
            } while (!lockFreeLinkedListNode.addNext(sendElement, lockFreeLinkedListHead));
            return null;
        }
        LockFreeLinkedListHead lockFreeLinkedListHead2 = this.queue;
        SendElement sendElement2 = sendElement;
        AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 = new AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1(sendElement2, sendElement2, this);
        while (true) {
            Object prev2 = lockFreeLinkedListHead2.getPrev();
            if (prev2 != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) prev2;
                if (!(lockFreeLinkedListNode2 instanceof ReceiveOrClosed)) {
                    int tryCondAddNext = lockFreeLinkedListNode2.tryCondAddNext(sendElement2, lockFreeLinkedListHead2, abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1);
                    z = true;
                    if (tryCondAddNext != 1) {
                        if (tryCondAddNext == 2) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    return lockFreeLinkedListNode2;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
        if (!z) {
            return AbstractChannelKt.ENQUEUE_FAILED;
        }
        return null;
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean close(Throwable th) {
        Closed<? super E> closed = new Closed<>(th);
        while (true) {
            ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
            boolean z = false;
            if (takeFirstReceiveOrPeekClosed == null) {
                LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
                while (true) {
                    Object prev = lockFreeLinkedListHead.getPrev();
                    if (prev != null) {
                        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
                        if (!(lockFreeLinkedListNode instanceof Closed)) {
                            if (!(lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                                if (lockFreeLinkedListNode.addNext(closed, lockFreeLinkedListHead)) {
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                    }
                }
                if (z) {
                    onClosed(closed);
                    afterClose(th);
                    return true;
                }
            } else if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                return false;
            } else {
                ((Receive) takeFirstReceiveOrPeekClosed).resumeReceiveClosed(closed);
            }
        }
    }

    /* access modifiers changed from: protected */
    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            Object next = lockFreeLinkedListHead.getNext();
            if (next != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                    if ((((ReceiveOrClosed) lockFreeLinkedListNode) instanceof Closed) || lockFreeLinkedListNode.remove()) {
                        break;
                    }
                    lockFreeLinkedListNode.helpDelete();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
        lockFreeLinkedListNode = null;
        return (ReceiveOrClosed) lockFreeLinkedListNode;
    }

    /* access modifiers changed from: protected */
    public final TryOfferDesc<E> describeTryOffer(E e) {
        return new TryOfferDesc<>(e, this.queue);
    }

    /* access modifiers changed from: protected */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0014R\u0012\u0010\u0005\u001a\u00028\u00018\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$TryOfferDesc;", "E", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/experimental/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/experimental/internal/RemoveFirstDesc;", "element", "queue", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;)V", "Ljava/lang/Object;", "resumeToken", "", "failure", "affected", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "next", "validatePrepared", "", "node", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AbstractChannel.kt */
    public static final class TryOfferDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>> {
        public final E element;
        public Object resumeToken;

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.RemoveFirstDesc
        public /* bridge */ /* synthetic */ boolean validatePrepared(Object obj) {
            return validatePrepared((ReceiveOrClosed) ((ReceiveOrClosed) obj));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TryOfferDesc(E e, LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListHead, "queue");
            this.element = e;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            if (!(lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            if (lockFreeLinkedListNode instanceof Closed) {
                return lockFreeLinkedListNode;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean validatePrepared(ReceiveOrClosed<? super E> receiveOrClosed) {
            Intrinsics.checkParameterIsNotNull(receiveOrClosed, "node");
            Object tryResumeReceive = receiveOrClosed.tryResumeReceive(this.element, this);
            if (tryResumeReceive == null) {
                return false;
            }
            this.resumeToken = tryResumeReceive;
            return true;
        }
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004BH\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012(\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\tø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0014J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014\u0002\u0004\n\u0002\b\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$TryEnqueueSendDesc;", "R", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendSelect;", "Lkotlinx/coroutines/experimental/internal/AddLastDesc;", "element", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "Lkotlin/coroutines/experimental/Continuation;", "", "(Lkotlinx/coroutines/experimental/channels/AbstractSendChannel;Ljava/lang/Object;Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "failure", "affected", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "next", "finishOnSuccess", "", "onPrepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AbstractChannel.kt */
    public final class TryEnqueueSendDesc<R> extends LockFreeLinkedListNode.AddLastDesc<SendSelect<E, R>> {
        final /* synthetic */ AbstractSendChannel this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TryEnqueueSendDesc(AbstractSendChannel abstractSendChannel, E e, SelectInstance<? super R> selectInstance, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            super(abstractSendChannel.getQueue(), new SendSelect(e, abstractSendChannel, selectInstance, function2));
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            Intrinsics.checkParameterIsNotNull(function2, "block");
            this.this$0 = abstractSendChannel;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            if (!(lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                return null;
            }
            if (!(lockFreeLinkedListNode instanceof Closed)) {
                lockFreeLinkedListNode = null;
            }
            Closed closed = (Closed) lockFreeLinkedListNode;
            return closed != null ? closed : AbstractChannelKt.ENQUEUE_FAILED;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc, kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AddLastDesc
        public Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            if (!this.this$0.isBufferFull()) {
                return AbstractChannelKt.ENQUEUE_FAILED;
            }
            return super.onPrepare(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AbstractAtomicDesc, kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.AddLastDesc
        public void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            super.finishOnSuccess(lockFreeLinkedListNode, lockFreeLinkedListNode2);
            ((SendSelect) this.node).disposeOnSelect();
        }
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public final SelectClause2<E, SendChannel<E>> getOnSend() {
        return new AbstractSendChannel$onSend$1(this);
    }

    /* access modifiers changed from: private */
    public final <R> void registerSelectSend(SelectInstance<? super R> selectInstance, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (isFull()) {
                Object performAtomicIfNotSelected = selectInstance.performAtomicIfNotSelected(new TryEnqueueSendDesc(this, e, selectInstance, function2));
                if (performAtomicIfNotSelected != null && performAtomicIfNotSelected != SelectKt.getALREADY_SELECTED()) {
                    if (performAtomicIfNotSelected != AbstractChannelKt.ENQUEUE_FAILED) {
                        if (performAtomicIfNotSelected instanceof Closed) {
                            throw ((Closed) performAtomicIfNotSelected).getSendException();
                        }
                        throw new IllegalStateException(("performAtomicIfNotSelected(TryEnqueueSendDesc) returned " + performAtomicIfNotSelected).toString());
                    }
                } else {
                    return;
                }
            } else {
                Object offerSelectInternal = offerSelectInternal(e, selectInstance);
                if (offerSelectInternal != SelectKt.getALREADY_SELECTED()) {
                    if (offerSelectInternal != AbstractChannelKt.OFFER_FAILED) {
                        if (offerSelectInternal == AbstractChannelKt.OFFER_SUCCESS) {
                            UndispatchedKt.startCoroutineUndispatched(function2, this, selectInstance.getCompletion());
                            return;
                        } else if (offerSelectInternal instanceof Closed) {
                            throw ((Closed) offerSelectInternal).getSendException();
                        } else {
                            throw new IllegalStateException(("offerSelectInternal returned " + offerSelectInternal).toString());
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public String toString() {
        return DebugKt.getClassSimpleName(this) + '@' + DebugKt.getHexAddress(this) + '{' + getQueueDebugStateString() + '}' + getBufferDebugString();
    }

    private final String getQueueDebugStateString() {
        String str;
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (nextNode == this.queue) {
            return "EmptyQueue";
        }
        if (nextNode instanceof Closed) {
            str = nextNode.toString();
        } else if (nextNode instanceof Receive) {
            str = "ReceiveQueued";
        } else if (nextNode instanceof Send) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + nextNode;
        }
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (prevNode == nextNode) {
            return str;
        }
        String str2 = str + ",queueSize=" + countQueueSize();
        if (!(prevNode instanceof Closed)) {
            return str2;
        }
        return str2 + ",closedForSend=" + prevNode;
    }

    private final int countQueueSize() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        Object next = lockFreeLinkedListHead.getNext();
        if (next != null) {
            int i = 0;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                    i++;
                }
            }
            return i;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u00042\u00020\u0005BX\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\u0012(\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\rø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u0014\u0010\u0018\u001a\u00020\u00142\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016R7\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r8\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendSelect;", "E", "R", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/channels/Send;", "Lkotlinx/coroutines/experimental/DisposableHandle;", "pollResult", "", "channel", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/channels/SendChannel;Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "token", "dispose", "disposeOnSelect", "resumeSendClosed", "closed", "Lkotlinx/coroutines/experimental/channels/Closed;", "toString", "", "tryResumeSend", "idempotent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AbstractChannel.kt */
    private static final class SendSelect<E, R> extends LockFreeLinkedListNode implements Send, DisposableHandle {
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> block;
        public final SendChannel<E> channel;
        private final Object pollResult;
        public final SelectInstance<R> select;

        @Override // kotlinx.coroutines.experimental.channels.Send
        public Object getPollResult() {
            return this.pollResult;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.experimental.channels.SendChannel<? super E> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlinx.coroutines.experimental.selects.SelectInstance<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.experimental.channels.SendChannel<? super E>, ? super kotlin.coroutines.experimental.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        public SendSelect(Object obj, SendChannel<? super E> sendChannel, SelectInstance<? super R> selectInstance, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            Intrinsics.checkParameterIsNotNull(sendChannel, "channel");
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            Intrinsics.checkParameterIsNotNull(function2, "block");
            this.pollResult = obj;
            this.channel = sendChannel;
            this.select = selectInstance;
            this.block = function2;
        }

        @Override // kotlinx.coroutines.experimental.channels.Send
        public Object tryResumeSend(Object obj) {
            if (this.select.trySelect(obj)) {
                return AbstractChannelKt.SELECT_STARTED;
            }
            return null;
        }

        @Override // kotlinx.coroutines.experimental.channels.Send
        public void completeResumeSend(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "token");
            if (obj == AbstractChannelKt.SELECT_STARTED) {
                CoroutinesKt.startCoroutine(this.block, this.channel, this.select.getCompletion());
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public final void disposeOnSelect() {
            this.select.disposeOnSelect(this);
        }

        @Override // kotlinx.coroutines.experimental.DisposableHandle
        public void dispose() {
            remove();
        }

        @Override // kotlinx.coroutines.experimental.channels.Send
        public void resumeSendClosed(Closed<?> closed) {
            Intrinsics.checkParameterIsNotNull(closed, "closed");
            if (this.select.trySelect(null)) {
                this.select.resumeSelectCancellableWithException(closed.getSendException());
            }
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
        public String toString() {
            return "SendSelect(" + getPollResult() + ")[" + this.channel + ", " + this.select + ']';
        }
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0014\u0010\u000e\u001a\u00020\f2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016R\u0012\u0010\u0004\u001a\u00028\u00018\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "token", "resumeSendClosed", "closed", "Lkotlinx/coroutines/experimental/channels/Closed;", "tryResumeSend", "idempotent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AbstractChannel.kt */
    public static final class SendBuffered<E> extends LockFreeLinkedListNode implements Send {
        public final E element;

        @Override // kotlinx.coroutines.experimental.channels.Send
        public void resumeSendClosed(Closed<?> closed) {
            Intrinsics.checkParameterIsNotNull(closed, "closed");
        }

        public SendBuffered(E e) {
            this.element = e;
        }

        @Override // kotlinx.coroutines.experimental.channels.Send
        public Object getPollResult() {
            return this.element;
        }

        @Override // kotlinx.coroutines.experimental.channels.Send
        public Object tryResumeSend(Object obj) {
            return AbstractChannelKt.SEND_RESUMED;
        }

        @Override // kotlinx.coroutines.experimental.channels.Send
        public void completeResumeSend(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "token");
            if (!(obj == AbstractChannelKt.SEND_RESUMED)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object sendSuspend(E e, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 0);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        SendElement sendElement = new SendElement(e, cancellableContinuationImpl2);
        while (true) {
            Object enqueueSend = enqueueSend(sendElement);
            if (enqueueSend == null) {
                cancellableContinuationImpl2.initCancellability();
                CancellableContinuationKt.removeOnCancellation(cancellableContinuationImpl2, sendElement);
                break;
            } else if (enqueueSend instanceof Closed) {
                cancellableContinuationImpl2.resumeWithException(((Closed) enqueueSend).getSendException());
                break;
            } else {
                Object offerInternal = offerInternal(e);
                if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                    cancellableContinuationImpl2.resume(Unit.INSTANCE);
                    break;
                } else if (offerInternal != AbstractChannelKt.OFFER_FAILED) {
                    if (offerInternal instanceof Closed) {
                        cancellableContinuationImpl2.resumeWithException(((Closed) offerInternal).getSendException());
                    } else {
                        throw new IllegalStateException(("offerInternal returned " + offerInternal).toString());
                    }
                }
            }
        }
        return cancellableContinuationImpl.getResult();
    }
}
