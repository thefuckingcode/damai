package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.model.HttpHeaders;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.experimental.channels.BroadcastChannel;
import kotlinx.coroutines.experimental.channels.SubscriptionReceiveChannel;
import kotlinx.coroutines.experimental.internal.ConcurrentKt;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import kotlinx.coroutines.experimental.selects.SelectKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00015B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\u0015H\u0002J\u0015\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010(J\u0015\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010+J!\u0010,\u001a\u00020\t2\u0006\u0010*\u001a\u00028\u00002\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.H\u0014¢\u0006\u0002\u0010/J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0016J-\u00102\u001a\u00020#2\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001dH\u0010R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178TX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00178TX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u0012\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ArrayBroadcastChannel;", "E", "Lkotlinx/coroutines/experimental/channels/AbstractSendChannel;", "Lkotlinx/coroutines/experimental/channels/BroadcastChannel;", "capacity", "", "(I)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/experimental/internal/ReentrantLock;", "getCapacity", "()I", CacheEntity.HEAD, "", "isBufferAlwaysFull", "", "()Z", "isBufferFull", "size", "subs", "", "Lkotlinx/coroutines/experimental/channels/ArrayBroadcastChannel$Subscriber;", "tail", "cancel", "cause", "", "checkSubOffers", "", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "computeMinHead", "elementAt", "index", "(J)Ljava/lang/Object;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/selects/SelectInstance;)Ljava/lang/Object;", "openSubscription", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "updateHead", "addSub", "removeSub", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: ArrayBroadcastChannel.kt */
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    private final Object[] buffer;
    private final ReentrantLock bufferLock;
    private final int capacity;
    private volatile long head;
    private volatile int size;
    private final List<Subscriber<E>> subs;
    private volatile long tail;

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.experimental.channels.BroadcastChannel
    @Deprecated(message = "Renamed to `openSubscription`", replaceWith = @ReplaceWith(expression = "openSubscription()", imports = {}))
    public SubscriptionReceiveChannel<E> open() {
        return BroadcastChannel.DefaultImpls.open(this);
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayBroadcastChannel(int i) {
        this.capacity = i;
        if (i < 1 ? false : true) {
            this.bufferLock = new ReentrantLock();
            this.buffer = new Object[i];
            this.subs = ConcurrentKt.subscriberList();
            return;
        }
        throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + i + " was specified").toString());
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public boolean isBufferFull() {
        return this.size >= this.capacity;
    }

    @Override // kotlinx.coroutines.experimental.channels.BroadcastChannel, kotlinx.coroutines.experimental.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        Subscriber subscriber = new Subscriber(this);
        updateHead$default(this, subscriber, null, 2, null);
        return subscriber;
    }

    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel, kotlinx.coroutines.experimental.channels.SendChannel
    public boolean close(Throwable th) {
        if (!super.close(th)) {
            return false;
        }
        checkSubOffers();
        return true;
    }

    @Override // kotlinx.coroutines.experimental.channels.BroadcastChannel
    public boolean cancel(Throwable th) {
        boolean close = close(th);
        for (Subscriber<E> subscriber : this.subs) {
            subscriber.cancel(th);
        }
        return close;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public Object offerInternal(E e) {
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = this.size;
            if (i >= this.capacity) {
                Object obj = AbstractChannelKt.OFFER_FAILED;
                reentrantLock.unlock();
                return obj;
            }
            long j = this.tail;
            this.buffer[(int) (j % ((long) this.capacity))] = e;
            this.size = i + 1;
            this.tail = j + 1;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public Object offerSelectInternal(E e, SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = this.size;
            if (i >= this.capacity) {
                Object obj = AbstractChannelKt.OFFER_FAILED;
                reentrantLock.unlock();
                return obj;
            } else if (!selectInstance.trySelect(null)) {
                Object already_selected = SelectKt.getALREADY_SELECTED();
                reentrantLock.unlock();
                return already_selected;
            } else {
                long j = this.tail;
                this.buffer[(int) (j % ((long) this.capacity))] = e;
                this.size = i + 1;
                this.tail = j + 1;
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                checkSubOffers();
                return AbstractChannelKt.OFFER_SUCCESS;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void checkSubOffers() {
        boolean z = false;
        boolean z2 = false;
        for (Subscriber<E> subscriber : this.subs) {
            if (subscriber.checkOffer()) {
                z = true;
            }
            z2 = true;
        }
        if (z || !z2) {
            updateHead$default(this, null, null, 3, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.experimental.channels.ArrayBroadcastChannel */
    /* JADX WARN: Multi-variable type inference failed */
    static /* bridge */ /* synthetic */ void updateHead$default(ArrayBroadcastChannel arrayBroadcastChannel, Subscriber subscriber, Subscriber subscriber2, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriber = null;
        }
        if ((i & 2) != 0) {
            subscriber2 = null;
        }
        arrayBroadcastChannel.updateHead(subscriber, subscriber2);
    }

    private final void updateHead(Subscriber<E> subscriber, Subscriber<E> subscriber2) {
        Send takeFirstSendOrPeekClosed;
        Object tryResumeSend;
        while (true) {
            ReentrantLock reentrantLock = this.bufferLock;
            reentrantLock.lock();
            if (subscriber != null) {
                try {
                    subscriber.subHead = this.tail;
                    boolean isEmpty = this.subs.isEmpty();
                    this.subs.add(subscriber);
                    if (!isEmpty) {
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (subscriber2 != null) {
                this.subs.remove(subscriber2);
                if (this.head != subscriber2.subHead) {
                    reentrantLock.unlock();
                    return;
                }
            }
            long computeMinHead = computeMinHead();
            long j = this.tail;
            long j2 = this.head;
            long coerceAtMost = RangesKt.coerceAtMost(computeMinHead, j);
            if (coerceAtMost <= j2) {
                reentrantLock.unlock();
                return;
            }
            int i = this.size;
            while (j2 < coerceAtMost) {
                Object[] objArr = this.buffer;
                int i2 = this.capacity;
                objArr[(int) (j2 % ((long) i2))] = null;
                boolean z = i >= i2;
                j2++;
                this.head = j2;
                i--;
                this.size = i;
                if (z) {
                    do {
                        takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                        if (takeFirstSendOrPeekClosed != null && !(takeFirstSendOrPeekClosed instanceof Closed)) {
                            if (takeFirstSendOrPeekClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend(null);
                        }
                    } while (tryResumeSend == null);
                    Object[] objArr2 = this.buffer;
                    int i3 = (int) (j % ((long) this.capacity));
                    if (takeFirstSendOrPeekClosed != null) {
                        objArr2[i3] = takeFirstSendOrPeekClosed.getPollResult();
                        this.size = i + 1;
                        this.tail = j + 1;
                        Unit unit = Unit.INSTANCE;
                        reentrantLock.unlock();
                        if (takeFirstSendOrPeekClosed == null) {
                            Intrinsics.throwNpe();
                        }
                        takeFirstSendOrPeekClosed.completeResumeSend(tryResumeSend);
                        checkSubOffers();
                        subscriber = null;
                        subscriber2 = null;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.Send");
                    }
                }
            }
            reentrantLock.unlock();
            return;
        }
    }

    private final long computeMinHead() {
        long j = LongCompanionObject.MAX_VALUE;
        for (Subscriber<E> subscriber : this.subs) {
            j = RangesKt.coerceAtMost(j, subscriber.subHead);
        }
        return j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final E elementAt(long j) {
        return (E) this.buffer[(int) (j % ((long) this.capacity))];
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlinx/coroutines/experimental/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/experimental/channels/AbstractChannel;", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "Lkotlinx/coroutines/experimental/channels/SubscriptionReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/experimental/channels/ArrayBroadcastChannel;", "(Lkotlinx/coroutines/experimental/channels/ArrayBroadcastChannel;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "subHead", "", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/experimental/internal/ReentrantLock;", "cancel", "cause", "", "checkOffer", "clearBuffer", "", "needsToCheckOfferWithoutLock", "peekUnderLock", "", "pollInternal", "pollSelectInternal", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ArrayBroadcastChannel.kt */
    public static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E>, SubscriptionReceiveChannel<E> {
        private final ArrayBroadcastChannel<E> broadcastChannel;
        public volatile long subHead;
        private final ReentrantLock subLock = new ReentrantLock();

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.channels.AbstractChannel
        public boolean isBufferAlwaysEmpty() {
            return false;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, kotlinx.coroutines.experimental.channels.SubscriptionReceiveChannel
        @Deprecated(message = "Use `cancel`", replaceWith = @ReplaceWith(expression = "cancel()", imports = {}))
        public void close() {
            SubscriptionReceiveChannel.DefaultImpls.close(this);
        }

        public Subscriber(ArrayBroadcastChannel<E> arrayBroadcastChannel) {
            Intrinsics.checkParameterIsNotNull(arrayBroadcastChannel, "broadcastChannel");
            this.broadcastChannel = arrayBroadcastChannel;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.channels.AbstractChannel
        public boolean isBufferEmpty() {
            return this.subHead >= ((ArrayBroadcastChannel) this.broadcastChannel).tail;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
        public boolean isBufferAlwaysFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
        public boolean isBufferFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel, kotlinx.coroutines.experimental.channels.AbstractChannel
        public boolean cancel(Throwable th) {
            boolean close = close(th);
            if (close) {
                ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, this, 1, null);
            }
            clearBuffer();
            return close;
        }

        private final void clearBuffer() {
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                this.subHead = ((ArrayBroadcastChannel) this.broadcastChannel).tail;
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean checkOffer() {
            E e = null;
            boolean z = false;
            while (true) {
                if (!needsToCheckOfferWithoutLock() || !this.subLock.tryLock()) {
                    break;
                }
                try {
                    E e2 = (E) peekUnderLock();
                    if (e2 != AbstractChannelKt.POLL_FAILED) {
                        if (!(e2 instanceof Closed)) {
                            ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                            if (takeFirstReceiveOrPeekClosed == null || (takeFirstReceiveOrPeekClosed instanceof Closed)) {
                                break;
                            }
                            Object tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e2, null);
                            if (tryResumeReceive != null) {
                                this.subHead++;
                                z = true;
                                this.subLock.unlock();
                                if (takeFirstReceiveOrPeekClosed == null) {
                                    Intrinsics.throwNpe();
                                }
                                takeFirstReceiveOrPeekClosed.completeResumeReceive(tryResumeReceive);
                            }
                        } else {
                            e = e2;
                            break;
                        }
                    }
                } finally {
                    this.subLock.unlock();
                }
            }
            this.subLock.unlock();
            if (e != null) {
                close(e.closeCause);
            }
            return z;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0029  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
        @Override // kotlinx.coroutines.experimental.channels.AbstractChannel
        public Object pollInternal() {
            boolean z;
            Closed closed;
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                boolean z2 = true;
                if (!(peekUnderLock instanceof Closed)) {
                    if (peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                        this.subHead++;
                        z = true;
                        reentrantLock.unlock();
                        closed = (Closed) (peekUnderLock instanceof Closed ? null : peekUnderLock);
                        if (closed != null) {
                            close(closed.closeCause);
                        }
                        if (!checkOffer()) {
                            z2 = z;
                        }
                        if (z2) {
                            ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
                        }
                        return peekUnderLock;
                    }
                }
                z = false;
                reentrantLock.unlock();
                closed = (Closed) (peekUnderLock instanceof Closed ? null : peekUnderLock);
                if (closed != null) {
                }
                if (!checkOffer()) {
                }
                if (z2) {
                }
                return peekUnderLock;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.experimental.channels.AbstractChannel
        public Object pollSelectInternal(SelectInstance<?> selectInstance) {
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                boolean z = true;
                boolean z2 = false;
                if (!(peekUnderLock instanceof Closed)) {
                    if (peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                        if (!selectInstance.trySelect(null)) {
                            peekUnderLock = SelectKt.getALREADY_SELECTED();
                        } else {
                            this.subHead++;
                            z2 = true;
                        }
                    }
                }
                reentrantLock.unlock();
                Closed closed = (Closed) (!(peekUnderLock instanceof Closed) ? null : peekUnderLock);
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (!checkOffer()) {
                    z = z2;
                }
                if (z) {
                    ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
                }
                return peekUnderLock;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        private final boolean needsToCheckOfferWithoutLock() {
            if (getClosedForReceive() != null) {
                return false;
            }
            if (!isBufferEmpty() || this.broadcastChannel.getClosedForReceive() != null) {
                return true;
            }
            return false;
        }

        private final Object peekUnderLock() {
            long j = this.subHead;
            Closed<?> closedForReceive = this.broadcastChannel.getClosedForReceive();
            if (j >= ((ArrayBroadcastChannel) this.broadcastChannel).tail) {
                if (closedForReceive == null) {
                    closedForReceive = getClosedForReceive();
                }
                return closedForReceive != null ? closedForReceive : AbstractChannelKt.POLL_FAILED;
            }
            Object elementAt = this.broadcastChannel.elementAt(j);
            Closed<?> closedForReceive2 = getClosedForReceive();
            return closedForReceive2 != null ? closedForReceive2 : elementAt;
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public String getBufferDebugString() {
        return "(buffer:capacity=" + this.buffer.length + ",size=" + this.size + ')';
    }
}
