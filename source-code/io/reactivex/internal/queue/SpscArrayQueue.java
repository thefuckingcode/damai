package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: Taobao */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex = new AtomicLong();
    final int lookAheadStep;
    final int mask = (length() - 1);
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;

    public SpscArrayQueue(int i) {
        super(Pow2.roundToPowerOfTwo(i));
        this.lookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    /* access modifiers changed from: package-private */
    public int calcElementOffset(long j) {
        return this.mask & ((int) j);
    }

    /* access modifiers changed from: package-private */
    public int calcElementOffset(long j, int i) {
        return ((int) j) & i;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    /* access modifiers changed from: package-private */
    public E lvElement(int i) {
        return get(i);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        int i = this.mask;
        long j = this.producerIndex.get();
        int calcElementOffset = calcElementOffset(j, i);
        if (j >= this.producerLookAhead) {
            long j2 = ((long) this.lookAheadStep) + j;
            if (lvElement(calcElementOffset(j2, i)) == null) {
                this.producerLookAhead = j2;
            } else if (lvElement(calcElementOffset) != null) {
                return false;
            }
        }
        soElement(calcElementOffset, e);
        soProducerIndex(j + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue, io.reactivex.internal.fuseable.SimplePlainQueue
    @Nullable
    public E poll() {
        long j = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j + 1);
        soElement(calcElementOffset, null);
        return lvElement;
    }

    /* access modifiers changed from: package-private */
    public void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    /* access modifiers changed from: package-private */
    public void soElement(int i, E e) {
        lazySet(i, e);
    }

    /* access modifiers changed from: package-private */
    public void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E e, E e2) {
        return offer(e) && offer(e2);
    }
}
