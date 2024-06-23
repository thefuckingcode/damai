package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.b;
import io.reactivex.flowables.a;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.EmptyComponent;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, a<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super Consumer<Object>, ? extends Map<K, Object>> mapFactory;
    final Function<? super T, ? extends V> valueSelector;

    /* compiled from: Taobao */
    static final class EvictionAction<K, V> implements Consumer<GroupedUnicast<K, V>> {
        final Queue<GroupedUnicast<K, V>> evictedGroups;

        EvictionAction(Queue<GroupedUnicast<K, V>> queue) {
            this.evictedGroups = queue;
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) throws Exception {
            accept((GroupedUnicast) ((GroupedUnicast) obj));
        }

        public void accept(GroupedUnicast<K, V> groupedUnicast) {
            this.evictedGroups.offer(groupedUnicast);
        }
    }

    /* compiled from: Taobao */
    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<a<K, V>> implements FlowableSubscriber<T> {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final Subscriber<? super a<K, V>> actual;
        final int bufferSize;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final Queue<GroupedUnicast<K, V>> evictedGroups;
        final AtomicInteger groupCount = new AtomicInteger(1);
        final Map<Object, GroupedUnicast<K, V>> groups;
        final Function<? super T, ? extends K> keySelector;
        boolean outputFused;
        final SpscLinkedArrayQueue<a<K, V>> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription s;
        final Function<? super T, ? extends V> valueSelector;

        public GroupBySubscriber(Subscriber<? super a<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Map<Object, GroupedUnicast<K, V>> map, Queue<GroupedUnicast<K, V>> queue2) {
            this.actual = subscriber;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i;
            this.delayError = z;
            this.groups = map;
            this.evictedGroups = queue2;
            this.queue = new SpscLinkedArrayQueue<>(i);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
                this.s.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.cancelled.get()) {
                spscLinkedArrayQueue.clear();
                return true;
            } else if (this.delayError) {
                if (!z || !z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th2 = this.error;
                if (th2 != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                if (this.outputFused) {
                    drainFused();
                } else {
                    drainNormal();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void drainFused() {
            Throwable th;
            SpscLinkedArrayQueue<a<K, V>> spscLinkedArrayQueue = this.queue;
            Subscriber<? super a<K, V>> subscriber = this.actual;
            int i = 1;
            while (!this.cancelled.get()) {
                boolean z = this.done;
                if (!z || this.delayError || (th = this.error) == null) {
                    subscriber.onNext(null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    } else {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                } else {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
            }
            spscLinkedArrayQueue.clear();
        }

        /* access modifiers changed from: package-private */
        public void drainNormal() {
            int i;
            SpscLinkedArrayQueue<a<K, V>> spscLinkedArrayQueue = this.queue;
            Subscriber<? super a<K, V>> subscriber = this.actual;
            int i2 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z = this.done;
                    a<K, V> poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (!checkTerminated(z, z2, subscriber, spscLinkedArrayQueue)) {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j2++;
                    } else {
                        return;
                    }
                }
                if (i != 0 || !checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    if (j2 != 0) {
                        if (j != AbsPerformance.LONG_NIL) {
                            this.requested.addAndGet(-j2);
                        }
                        this.s.request(j2);
                    }
                    i2 = addAndGet(-i2);
                } else {
                    return;
                }
            } while (i2 != 0);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                for (GroupedUnicast<K, V> groupedUnicast : this.groups.values()) {
                    groupedUnicast.onComplete();
                }
                this.groups.clear();
                Queue<GroupedUnicast<K, V>> queue2 = this.evictedGroups;
                if (queue2 != null) {
                    queue2.clear();
                }
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            for (GroupedUnicast<K, V> groupedUnicast : this.groups.values()) {
                groupedUnicast.onError(th);
            }
            this.groups.clear();
            Queue<GroupedUnicast<K, V>> queue2 = this.evictedGroups;
            if (queue2 != null) {
                queue2.clear();
            }
            this.error = th;
            this.done = true;
            drain();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupedUnicast */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Object obj;
            if (!this.done) {
                SpscLinkedArrayQueue<a<K, V>> spscLinkedArrayQueue = this.queue;
                try {
                    Object apply = this.keySelector.apply(t);
                    boolean z = false;
                    if (apply != null) {
                        obj = apply;
                    } else {
                        obj = NULL_KEY;
                    }
                    GroupedUnicast<K, V> groupedUnicast = this.groups.get(obj);
                    if (groupedUnicast == null) {
                        if (!this.cancelled.get()) {
                            groupedUnicast = GroupedUnicast.createWith(apply, this.bufferSize, this, this.delayError);
                            this.groups.put(obj, groupedUnicast);
                            this.groupCount.getAndIncrement();
                            z = true;
                        } else {
                            return;
                        }
                    }
                    try {
                        groupedUnicast.onNext(ObjectHelper.requireNonNull(this.valueSelector.apply(t), "The valueSelector returned null"));
                        if (this.evictedGroups != null) {
                            while (true) {
                                GroupedUnicast<K, V> poll = this.evictedGroups.poll();
                                if (poll == null) {
                                    break;
                                }
                                poll.onComplete();
                            }
                        }
                        if (z) {
                            spscLinkedArrayQueue.offer(groupedUnicast);
                            drain();
                        }
                    } catch (Throwable th) {
                        ff0.b(th);
                        this.s.cancel();
                        onError(th);
                    }
                } catch (Throwable th2) {
                    ff0.b(th2);
                    this.s.cancel();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request((long) this.bufferSize);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public a<K, V> poll() {
            return this.queue.poll();
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) NULL_KEY;
            }
            this.groups.remove(k);
            if (this.groupCount.decrementAndGet() == 0) {
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class GroupedUnicast<K, T> extends a<K, T> {
        final State<T, K> state;

        protected GroupedUnicast(K k, State<T, K> state2) {
            super(k);
            this.state = state2;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K k, int i, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new GroupedUnicast<>(k, new State(i, groupBySubscriber, k, z));
        }

        public void onComplete() {
            this.state.onComplete();
        }

        public void onError(Throwable th) {
            this.state.onError(th);
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.b
        public void subscribeActual(Subscriber<? super T> subscriber) {
            this.state.subscribe(subscriber);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<Subscriber<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once = new AtomicBoolean();
        boolean outputFused;
        final GroupBySubscriber<?, K, T> parent;
        int produced;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();

        State(int i, GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean z) {
            this.queue = new SpscLinkedArrayQueue<>(i);
            this.parent = groupBySubscriber;
            this.key = k;
            this.delayError = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                this.parent.cancel(this.key);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        subscriber.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                if (this.outputFused) {
                    drainFused();
                } else {
                    drainNormal();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void drainFused() {
            Throwable th;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            Subscriber<? super T> subscriber = this.actual.get();
            int i = 1;
            while (true) {
                if (subscriber != null) {
                    if (this.cancelled.get()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (!z || this.delayError || (th = this.error) == null) {
                        subscriber.onNext(null);
                        if (z) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                subscriber.onError(th2);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(th);
                        return;
                    }
                }
                i = addAndGet(-i);
                if (i != 0) {
                    if (subscriber == null) {
                        subscriber = this.actual.get();
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void drainNormal() {
            int i;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            boolean z = this.delayError;
            Subscriber<? super T> subscriber = this.actual.get();
            int i2 = 1;
            while (true) {
                if (subscriber != null) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z2 = this.done;
                        T poll = spscLinkedArrayQueue.poll();
                        boolean z3 = poll == null;
                        if (!checkTerminated(z2, z3, subscriber, z)) {
                            if (z3) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (i == 0 && checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, z)) {
                        return;
                    }
                    if (j2 != 0) {
                        if (j != AbsPerformance.LONG_NIL) {
                            this.requested.addAndGet(-j2);
                        }
                        this.parent.s.request(j2);
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 != 0) {
                    if (subscriber == null) {
                        subscriber = this.actual.get();
                    }
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T poll = this.queue.poll();
            if (poll != null) {
                this.produced++;
                return poll;
            }
            int i = this.produced;
            if (i == 0) {
                return null;
            }
            this.produced = 0;
            this.parent.s.request((long) i);
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            if (this.once.compareAndSet(false, true)) {
                subscriber.onSubscribe(this);
                this.actual.lazySet(subscriber);
                drain();
                return;
            }
            EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
        }
    }

    public FlowableGroupBy(b<T> bVar, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        super(bVar);
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = i;
        this.delayError = z;
        this.mapFactory = function3;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super a<K, V>> subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map map;
        try {
            if (this.mapFactory == null) {
                concurrentLinkedQueue = null;
                map = new ConcurrentHashMap();
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                map = (Map) this.mapFactory.apply(new EvictionAction(concurrentLinkedQueue));
            }
            this.source.subscribe((FlowableSubscriber) new GroupBySubscriber(subscriber, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, map, concurrentLinkedQueue));
        } catch (Exception e) {
            ff0.b(e);
            subscriber.onSubscribe(EmptyComponent.INSTANCE);
            subscriber.onError(e);
        }
    }
}
