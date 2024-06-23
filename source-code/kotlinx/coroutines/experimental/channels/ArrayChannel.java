package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.cache.CacheEntity;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.channels.AbstractChannel;
import kotlinx.coroutines.experimental.channels.AbstractSendChannel;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import kotlinx.coroutines.experimental.selects.SelectKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\u0015\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020\b2\u0006\u0010\u001e\u001a\u00028\u00002\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0014¢\u0006\u0002\u0010#J\n\u0010$\u001a\u0004\u0018\u00010\bH\u0014J\u0016\u0010%\u001a\u0004\u0018\u00010\b2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0014R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0012\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ArrayChannel;", "E", "Lkotlinx/coroutines/experimental/channels/AbstractChannel;", "capacity", "", "(I)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "getCapacity", "()I", CacheEntity.HEAD, "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/experimental/internal/ReentrantLock;", "size", "cleanupSendQueueOnCancel", "", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/selects/SelectInstance;)Ljava/lang/Object;", "pollInternal", "pollSelectInternal", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: ArrayChannel.kt */
public class ArrayChannel<E> extends AbstractChannel<E> {
    private final Object[] buffer;
    private final int capacity;
    private int head;
    private final ReentrantLock lock;
    private volatile int size;

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractChannel
    public final boolean isBufferAlwaysEmpty() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayChannel(int i) {
        this.capacity = i;
        if (i < 1 ? false : true) {
            this.lock = new ReentrantLock();
            this.buffer = new Object[i];
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractChannel
    public final boolean isBufferEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public final boolean isBufferFull() {
        return this.size == this.capacity;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public Object offerInternal(E e) {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed;
        Object tryResumeReceive;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (i < this.capacity) {
                this.size = i + 1;
                if (i == 0) {
                    do {
                        takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                        if (takeFirstReceiveOrPeekClosed != null) {
                            if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                                this.size = i;
                                if (takeFirstReceiveOrPeekClosed == null) {
                                    Intrinsics.throwNpe();
                                }
                                reentrantLock.unlock();
                                return takeFirstReceiveOrPeekClosed;
                            }
                            if (takeFirstReceiveOrPeekClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e, null);
                        }
                    } while (tryResumeReceive == null);
                    this.size = i;
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    if (takeFirstReceiveOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    takeFirstReceiveOrPeekClosed.completeResumeReceive(tryResumeReceive);
                    if (takeFirstReceiveOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    return takeFirstReceiveOrPeekClosed.getOfferResult();
                }
                this.buffer[(this.head + i) % this.capacity] = e;
                Object obj = AbstractChannelKt.OFFER_SUCCESS;
                reentrantLock.unlock();
                return obj;
            }
            Object obj2 = AbstractChannelKt.OFFER_FAILED;
            reentrantLock.unlock();
            return obj2;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public Object offerSelectInternal(E e, SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (i < this.capacity) {
                this.size = i + 1;
                if (i == 0) {
                    AbstractSendChannel.TryOfferDesc<E> describeTryOffer = describeTryOffer(e);
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryOffer);
                    if (performAtomicTrySelect == null) {
                        this.size = i;
                        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) describeTryOffer.getResult();
                        Object obj = describeTryOffer.resumeToken;
                        if (obj != null) {
                            Unit unit = Unit.INSTANCE;
                            reentrantLock.unlock();
                            if (receiveOrClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            if (obj == null) {
                                Intrinsics.throwNpe();
                            }
                            receiveOrClosed.completeResumeReceive(obj);
                            if (receiveOrClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            return receiveOrClosed.getOfferResult();
                        }
                        throw new IllegalStateException("Check failed.".toString());
                    } else if (performAtomicTrySelect != AbstractChannelKt.OFFER_FAILED) {
                        if (performAtomicTrySelect == SelectKt.getALREADY_SELECTED() || (performAtomicTrySelect instanceof Closed)) {
                            this.size = i;
                            reentrantLock.unlock();
                            return performAtomicTrySelect;
                        }
                        throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + performAtomicTrySelect).toString());
                    }
                }
                if (!selectInstance.trySelect(null)) {
                    this.size = i;
                    Object already_selected = SelectKt.getALREADY_SELECTED();
                    reentrantLock.unlock();
                    return already_selected;
                }
                this.buffer[(this.head + i) % this.capacity] = e;
                Object obj2 = AbstractChannelKt.OFFER_SUCCESS;
                reentrantLock.unlock();
                return obj2;
            }
            Object obj3 = AbstractChannelKt.OFFER_FAILED;
            reentrantLock.unlock();
            return obj3;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractChannel
    public Object pollInternal() {
        Object obj = null;
        Send send = null;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object[] objArr = this.buffer;
            int i2 = this.head;
            Object obj2 = objArr[i2];
            objArr[i2] = null;
            this.size = i - 1;
            Object obj3 = AbstractChannelKt.POLL_FAILED;
            if (i == this.capacity) {
                Object obj4 = null;
                while (true) {
                    Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        obj = obj4;
                        break;
                    }
                    if (takeFirstSendOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    obj4 = takeFirstSendOrPeekClosed.tryResumeSend(null);
                    if (obj4 != null) {
                        if (takeFirstSendOrPeekClosed == null) {
                            Intrinsics.throwNpe();
                        }
                        obj3 = takeFirstSendOrPeekClosed.getPollResult();
                        obj = obj4;
                        send = takeFirstSendOrPeekClosed;
                    } else {
                        send = takeFirstSendOrPeekClosed;
                    }
                }
            }
            if (obj3 != AbstractChannelKt.POLL_FAILED && !(obj3 instanceof Closed)) {
                this.size = i;
                this.buffer[(this.head + i) % this.capacity] = obj3;
            }
            this.head = (this.head + 1) % this.capacity;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            if (obj != null) {
                if (send == null) {
                    Intrinsics.throwNpe();
                }
                send.completeResumeSend(obj);
            }
            return obj2;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00eb  */
    @Override // kotlinx.coroutines.experimental.channels.AbstractChannel
    public Object pollSelectInternal(SelectInstance<?> selectInstance) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Send send = null;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object[] objArr = this.buffer;
            int i2 = this.head;
            Object obj2 = objArr[i2];
            objArr[i2] = null;
            this.size = i - 1;
            Object obj3 = AbstractChannelKt.POLL_FAILED;
            if (i == this.capacity) {
                AbstractChannel.TryPollDesc<E> describeTryPoll = describeTryPoll();
                Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryPoll);
                if (performAtomicTrySelect == null) {
                    send = (Send) describeTryPoll.getResult();
                    Object obj4 = describeTryPoll.resumeToken;
                    if (obj4 != null) {
                        if (send == null) {
                            Intrinsics.throwNpe();
                        }
                        obj = obj4;
                        obj3 = send.getPollResult();
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else if (performAtomicTrySelect != AbstractChannelKt.POLL_FAILED) {
                    if (performAtomicTrySelect == SelectKt.getALREADY_SELECTED()) {
                        this.size = i;
                        this.buffer[this.head] = obj2;
                        reentrantLock.unlock();
                        return performAtomicTrySelect;
                    } else if (performAtomicTrySelect instanceof Closed) {
                        send = (Send) performAtomicTrySelect;
                        obj = ((Closed) performAtomicTrySelect).tryResumeSend(null);
                        obj3 = performAtomicTrySelect;
                    } else {
                        throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + performAtomicTrySelect).toString());
                    }
                }
                if (obj3 == AbstractChannelKt.POLL_FAILED && !(obj3 instanceof Closed)) {
                    this.size = i;
                    this.buffer[(this.head + i) % this.capacity] = obj3;
                } else if (!selectInstance.trySelect(null)) {
                    this.size = i;
                    this.buffer[this.head] = obj2;
                    Object already_selected = SelectKt.getALREADY_SELECTED();
                    reentrantLock.unlock();
                    return already_selected;
                }
                this.head = (this.head + 1) % this.capacity;
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                if (obj != null) {
                    if (send == null) {
                        Intrinsics.throwNpe();
                    }
                    send.completeResumeSend(obj);
                }
                return obj2;
            }
            obj = null;
            if (obj3 == AbstractChannelKt.POLL_FAILED) {
            }
            if (!selectInstance.trySelect(null)) {
            }
            this.head = (this.head + 1) % this.capacity;
            Unit unit2 = Unit.INSTANCE;
            reentrantLock.unlock();
            if (obj != null) {
            }
            return obj2;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractChannel
    public void cleanupSendQueueOnCancel() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            for (int i2 = 0; i2 < i; i2++) {
                this.buffer[this.head] = 0;
                this.head = (this.head + 1) % this.capacity;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.cleanupSendQueueOnCancel();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public String getBufferDebugString() {
        return "(buffer:capacity=" + this.buffer.length + ",size=" + this.size + ')';
    }
}
