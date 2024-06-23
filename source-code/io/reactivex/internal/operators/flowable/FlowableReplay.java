package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.em2;
import tb.ff0;
import tb.im;
import tb.k22;

/* compiled from: Taobao */
public final class FlowableReplay<T> extends im<T> implements HasUpstreamPublisher<T>, Disposable {
    static final Callable DEFAULT_UNBOUNDED_FACTORY = new DefaultUnboundedFactory();
    final Callable<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final b<T> source;

    /* compiled from: Taobao */
    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        BoundedReplayBuffer() {
            Node node = new Node(null, 0);
            this.tail = node;
            set(node);
        }

        /* access modifiers changed from: package-private */
        public final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        /* access modifiers changed from: package-private */
        public final void collect(Collection<? super T> collection) {
            Node head = getHead();
            while (true) {
                head = (Node) head.get();
                if (head != null) {
                    Object leaveTransform = leaveTransform(head.value);
                    if (!NotificationLite.isComplete(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                        collection.add((Object) NotificationLite.getValue(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.complete());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        /* access modifiers changed from: package-private */
        public Object enterTransform(Object obj) {
            return obj;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(Throwable th) {
            Object enterTransform = enterTransform(NotificationLite.error(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        /* access modifiers changed from: package-private */
        public Node getHead() {
            return (Node) get();
        }

        /* access modifiers changed from: package-private */
        public boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isComplete(leaveTransform(obj));
        }

        /* access modifiers changed from: package-private */
        public boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isError(leaveTransform(obj));
        }

        /* access modifiers changed from: package-private */
        public Object leaveTransform(Object obj) {
            return obj;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T t) {
            Object enterTransform = enterTransform(NotificationLite.next(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        /* access modifiers changed from: package-private */
        public final void removeFirst() {
            Node node = (Node) ((Node) get()).get();
            if (node != null) {
                this.size--;
                setFirst(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        /* access modifiers changed from: package-private */
        public final void removeSome(int i) {
            Node node = (Node) get();
            while (i > 0) {
                node = (Node) node.get();
                i--;
                this.size--;
            }
            setFirst(node);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            if (r14.isDisposed() == false) goto L_0x0014;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            r2 = r14.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            if (r2 != com.youku.live.livesdk.monitor.performance.AbsPerformance.LONG_NIL) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r5 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r14.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
            if (r5 != null) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
            r5 = getHead();
            r14.index = r5;
            io.reactivex.internal.util.BackpressureHelper.add(r14.totalRequested, r5.index);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
            if (r2 == 0) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
            r10 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r5.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
            if (r10 == null) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
            r5 = leaveTransform(r10.value);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
            if (io.reactivex.internal.util.NotificationLite.accept(r5, r14.child) == false) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
            r14.index = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
            r8 = r8 + 1;
            r2 = r2 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
            if (r14.isDisposed() == false) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0065, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
            r5 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0068, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0069, code lost:
            tb.ff0.b(r0);
            r14.index = null;
            r14.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0075, code lost:
            if (io.reactivex.internal.util.NotificationLite.isError(r5) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007d, code lost:
            r14.child.onError(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
            if (r8 == 0) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0087, code lost:
            r14.index = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0089, code lost:
            if (r4 != false) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x008b, code lost:
            r14.produced(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x008e, code lost:
            monitor-enter(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0091, code lost:
            if (r14.missed != false) goto L_0x0097;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0093, code lost:
            r14.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0095, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0096, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0097, code lost:
            r14.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0099, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            return;
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void replay(InnerSubscription<T> innerSubscription) {
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
            }
        }

        /* access modifiers changed from: package-private */
        public final void setFirst(Node node) {
            set(node);
        }

        /* access modifiers changed from: package-private */
        public void truncate() {
        }

        /* access modifiers changed from: package-private */
        public void truncateFinal() {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ConnectableFlowableReplay<T> extends im<T> {
        private final im<T> co;
        private final b<T> observable;

        ConnectableFlowableReplay(im<T> imVar, b<T> bVar) {
            this.co = imVar;
            this.observable = bVar;
        }

        @Override // tb.im
        public void connect(Consumer<? super Disposable> consumer) {
            this.co.connect(consumer);
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.b
        public void subscribeActual(Subscriber<? super T> subscriber) {
            this.observable.subscribe(subscriber);
        }
    }

    /* compiled from: Taobao */
    static final class DefaultUnboundedFactory implements Callable<Object> {
        DefaultUnboundedFactory() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(CANCELLED) != CANCELLED) {
                this.parent.remove(this);
                this.parent.manageRequests();
            }
        }

        /* access modifiers changed from: package-private */
        public <U> U index() {
            return (U) this.index;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == CANCELLED;
        }

        public long produced(long j) {
            return BackpressureHelper.producedCancel(this, j);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            long j2;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 != CANCELLED) {
                        if (j2 >= 0 && j == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, BackpressureHelper.addCap(j2, j)));
                BackpressureHelper.add(this.totalRequested, j);
                this.parent.manageRequests();
                this.parent.buffer.replay(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class MultiCastPublisher<R, U> implements Publisher<R> {
        private final Callable<? extends im<U>> connectableFactory;
        private final Function<? super b<U>, ? extends Publisher<R>> selector;

        /* compiled from: Taobao */
        final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> srw;

            DisposableConsumer(SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.srw = subscriberResourceWrapper;
            }

            public void accept(Disposable disposable) {
                this.srw.setResource(disposable);
            }
        }

        MultiCastPublisher(Callable<? extends im<U>> callable, Function<? super b<U>, ? extends Publisher<R>> function) {
            this.connectableFactory = callable;
            this.selector = function;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super R> subscriber) {
            try {
                im imVar = (im) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.selector.apply(imVar), "The selector returned a null Publisher");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                    publisher.subscribe(subscriberResourceWrapper);
                    imVar.connect(new DisposableConsumer(subscriberResourceWrapper));
                } catch (Throwable th) {
                    ff0.b(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                ff0.b(th2);
                EmptySubscription.error(th2, subscriber);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    /* compiled from: Taobao */
    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerSubscription<T> innerSubscription);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;

        ReplayBufferTask(int i) {
            this.bufferSize = i;
        }

        @Override // java.util.concurrent.Callable
        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ReplayPublisher<T> implements Publisher<T> {
        private final Callable<? extends ReplayBuffer<T>> bufferFactory;
        private final AtomicReference<ReplaySubscriber<T>> curr;

        ReplayPublisher(AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
            this.curr = atomicReference;
            this.bufferFactory = callable;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            ReplaySubscriber<T> replaySubscriber;
            while (true) {
                replaySubscriber = this.curr.get();
                if (replaySubscriber != null) {
                    break;
                }
                try {
                    ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>((ReplayBuffer) this.bufferFactory.call());
                    if (this.curr.compareAndSet(null, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                } catch (Throwable th) {
                    ff0.b(th);
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
            InnerSubscription<T> innerSubscription = new InnerSubscription<>(replaySubscriber, subscriber);
            subscriber.onSubscribe(innerSubscription);
            replaySubscriber.add(innerSubscription);
            if (innerSubscription.isDisposed()) {
                replaySubscriber.remove(innerSubscription);
                return;
            }
            replaySubscriber.manageRequests();
            replaySubscriber.buffer.replay(innerSubscription);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final ReplayBuffer<T> buffer;
        boolean done;
        final AtomicInteger management = new AtomicInteger();
        long maxChildRequested;
        long maxUpstreamRequested;
        final AtomicBoolean shouldConnect = new AtomicBoolean();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);

        ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
        }

        /* access modifiers changed from: package-private */
        public boolean add(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            Objects.requireNonNull(innerSubscription);
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[(length + 1)];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.subscribers.set(TERMINATED);
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        /* access modifiers changed from: package-private */
        public void manageRequests() {
            if (this.management.getAndIncrement() == 0) {
                int i = 1;
                while (!isDisposed()) {
                    InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                    long j = this.maxChildRequested;
                    long j2 = j;
                    for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                        j2 = Math.max(j2, innerSubscription.totalRequested.get());
                    }
                    long j3 = this.maxUpstreamRequested;
                    Subscription subscription = (Subscription) get();
                    long j4 = j2 - j;
                    if (j4 != 0) {
                        this.maxChildRequested = j2;
                        if (subscription == null) {
                            long j5 = j3 + j4;
                            if (j5 < 0) {
                                j5 = AbsPerformance.LONG_NIL;
                            }
                            this.maxUpstreamRequested = j5;
                        } else if (j3 != 0) {
                            this.maxUpstreamRequested = 0;
                            subscription.request(j3 + j4);
                        } else {
                            subscription.request(j4);
                        }
                    } else if (!(j3 == 0 || subscription == null)) {
                        this.maxUpstreamRequested = 0;
                        subscription.request(j3);
                    }
                    i = this.management.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(th);
                for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(innerSubscription);
                }
                return;
            }
            k22.u(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                manageRequests();
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void remove(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerSubscriptionArr[i2].equals(innerSubscription)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerSubscriptionArr2 = EMPTY;
                        } else {
                            InnerSubscription<T>[] innerSubscriptionArr3 = new InnerSubscription[(length - 1)];
                            System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                            System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                            innerSubscriptionArr2 = innerSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ScheduledReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        ScheduledReplayBufferTask(int i, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.bufferSize = i;
            this.maxAge = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        @Override // java.util.concurrent.Callable
        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final Scheduler scheduler;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.scheduler = scheduler2;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            return new em2(obj, this.scheduler.now(this.unit), this.unit);
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Node getHead() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node = (Node) get();
            Object obj = node.get();
            while (true) {
                node = (Node) obj;
                if (node != null) {
                    em2 em2 = (em2) node.value;
                    if (NotificationLite.isComplete(em2.b()) || NotificationLite.isError(em2.b()) || em2.a() > now) {
                        break;
                    }
                    obj = node.get();
                } else {
                    break;
                }
            }
            return node;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Object leaveTransform(Object obj) {
            return ((em2) obj).b();
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void truncate() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            int i = 0;
            while (true) {
                node = node2;
                if (node != null) {
                    int i2 = this.size;
                    if (i2 <= this.limit) {
                        if (((em2) node.value).a() > now) {
                            break;
                        }
                        i++;
                        this.size--;
                        node2 = (Node) node.get();
                    } else {
                        i++;
                        this.size = i2 - 1;
                        node2 = (Node) node.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void truncateFinal() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            int i = 0;
            while (true) {
                node = node2;
                if (node != null && this.size > 1 && ((em2) node.value).a() <= now) {
                    i++;
                    this.size--;
                    node2 = (Node) node.get();
                } else if (i == 0) {
                    setFirst(node);
                    return;
                } else {
                    return;
                }
            }
            if (i == 0) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* compiled from: Taobao */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r15.isDisposed() == false) goto L_0x0016;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
            r1 = r14.size;
            r2 = (java.lang.Integer) r15.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            if (r2 == null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
            r2 = r2.intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            r4 = r15.get();
            r8 = r4;
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r8 == 0) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
            if (r2 >= r1) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
            r12 = get(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
            if (io.reactivex.internal.util.NotificationLite.accept(r12, r0) == false) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
            if (r15.isDisposed() == false) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
            r2 = r2 + 1;
            r8 = r8 - 1;
            r10 = r10 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x004e, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
            tb.ff0.b(r1);
            r15.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
            if (io.reactivex.internal.util.NotificationLite.isError(r12) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0061, code lost:
            r0.onError(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0067, code lost:
            if (r10 == 0) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0069, code lost:
            r15.index = java.lang.Integer.valueOf(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
            if (r4 == com.youku.live.livesdk.monitor.performance.AbsPerformance.LONG_NIL) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0078, code lost:
            r15.produced(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007b, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x007e, code lost:
            if (r15.missed != false) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0080, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0082, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0083, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0084, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0086, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
            r0 = r15.child;
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void replay(InnerSubscription<T> innerSubscription) {
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
            }
        }
    }

    private FlowableReplay(Publisher<T> publisher, b<T> bVar, AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
        this.onSubscribe = publisher;
        this.source = bVar;
        this.current = atomicReference;
        this.bufferFactory = callable;
    }

    public static <T> im<T> create(b<T> bVar, int i) {
        if (i == Integer.MAX_VALUE) {
            return createFrom(bVar);
        }
        return create(bVar, new ReplayBufferTask(i));
    }

    public static <T> im<T> createFrom(b<? extends T> bVar) {
        return create(bVar, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <U, R> b<R> multicastSelector(Callable<? extends im<U>> callable, Function<? super b<U>, ? extends Publisher<R>> function) {
        return b.unsafeCreate(new MultiCastPublisher(callable, function));
    }

    public static <T> im<T> observeOn(im<T> imVar, Scheduler scheduler) {
        return k22.q(new ConnectableFlowableReplay(imVar, imVar.observeOn(scheduler)));
    }

    @Override // tb.im
    public void connect(Consumer<? super Disposable> consumer) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.current.get();
            if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                break;
            }
            try {
                ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>((ReplayBuffer) this.bufferFactory.call());
                if (this.current.compareAndSet(replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break;
                }
            } catch (Throwable th) {
                ff0.b(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        boolean z = !replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true);
        try {
            consumer.accept(replaySubscriber);
            if (z) {
                this.source.subscribe((FlowableSubscriber) replaySubscriber);
            }
        } catch (Throwable th2) {
            if (z) {
                replaySubscriber.shouldConnect.compareAndSet(true, false);
            }
            ff0.b(th2);
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.current.lazySet(null);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        ReplaySubscriber<T> replaySubscriber = this.current.get();
        return replaySubscriber == null || replaySubscriber.isDisposed();
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.onSubscribe.subscribe(subscriber);
    }

    public static <T> im<T> create(b<T> bVar, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return create(bVar, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> im<T> create(b<T> bVar, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return create(bVar, new ScheduledReplayBufferTask(i, j, timeUnit, scheduler));
    }

    static <T> im<T> create(b<T> bVar, Callable<? extends ReplayBuffer<T>> callable) {
        AtomicReference atomicReference = new AtomicReference();
        return k22.q(new FlowableReplay(new ReplayPublisher(atomicReference, callable), bVar, atomicReference, callable));
    }
}
