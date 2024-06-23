package io.reactivex.internal.operators.parallel;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.a;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class ParallelSortedJoin<T> extends b<T> {
    final Comparator<? super T> comparator;
    final a<List<T>> source;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i) {
            this.parent = sortedJoinSubscription;
            this.index = i;
        }

        /* access modifiers changed from: package-private */
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((List) ((List) obj));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                subscription.request(AbsPerformance.LONG_NIL);
            }
        }

        public void onNext(List<T> list) {
            this.parent.innerNext(list, this.index);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final int[] indexes;
        final List<T>[] lists;
        final AtomicInteger remaining = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();
        final SortedJoinInnerSubscriber<T>[] subscribers;

        SortedJoinSubscription(Subscriber<? super T> subscriber, int i, Comparator<? super T> comparator2) {
            this.actual = subscriber;
            this.comparator = comparator2;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                sortedJoinInnerSubscriberArr[i2] = new SortedJoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = sortedJoinInnerSubscriberArr;
            this.lists = new List[i];
            this.indexes = new int[i];
            this.remaining.lazySet(i);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    Arrays.fill(this.lists, (Object) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelAll() {
            for (SortedJoinInnerSubscriber<T> sortedJoinInnerSubscriber : this.subscribers) {
                sortedJoinInnerSubscriber.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a3, code lost:
            if (r15 != 0) goto L_0x00e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a7, code lost:
            if (r16.cancelled == false) goto L_0x00ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a9, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ad, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ae, code lost:
            r10 = r16.error.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b7, code lost:
            if (r10 == null) goto L_0x00c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b9, code lost:
            cancelAll();
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onError(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c2, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c3, code lost:
            r5 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c4, code lost:
            if (r5 >= r4) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ce, code lost:
            if (r0[r5] == r3[r5].size()) goto L_0x00d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d0, code lost:
            r13 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d2, code lost:
            r5 = r5 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d5, code lost:
            r13 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d6, code lost:
            if (r13 == false) goto L_0x00e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d8, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00df, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e4, code lost:
            if (r11 == 0) goto L_0x00f5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ed, code lost:
            if (r7 == com.youku.live.livesdk.monitor.performance.AbsPerformance.LONG_NIL) goto L_0x00f5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ef, code lost:
            r16.requested.addAndGet(-r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f5, code lost:
            r5 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f9, code lost:
            if (r5 != r6) goto L_0x0103;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00fb, code lost:
            r5 = addAndGet(-r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0100, code lost:
            if (r5 != 0) goto L_0x0103;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0102, code lost:
            return;
         */
        public void drain() {
            int i;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.actual;
                List<T>[] listArr = this.lists;
                int[] iArr = this.indexes;
                int length = iArr.length;
                int i2 = 1;
                while (true) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        int i3 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i3 == 0) {
                            break;
                        } else if (this.cancelled) {
                            Arrays.fill(listArr, (Object) null);
                            return;
                        } else {
                            Throwable th = this.error.get();
                            if (th != null) {
                                cancelAll();
                                Arrays.fill(listArr, (Object) null);
                                subscriber.onError(th);
                                return;
                            }
                            int i4 = -1;
                            T t = null;
                            for (int i5 = 0; i5 < length; i5++) {
                                List<T> list = listArr[i5];
                                int i6 = iArr[i5];
                                if (list.size() != i6) {
                                    if (t == null) {
                                        t = list.get(i6);
                                    } else {
                                        T t2 = list.get(i6);
                                        try {
                                            if (this.comparator.compare(t, t2) > 0) {
                                                t = t2;
                                            }
                                        } catch (Throwable th2) {
                                            ff0.b(th2);
                                            cancelAll();
                                            Arrays.fill(listArr, (Object) null);
                                            if (!this.error.compareAndSet(null, th2)) {
                                                k22.u(th2);
                                            }
                                            subscriber.onError(this.error.get());
                                            return;
                                        }
                                    }
                                    i4 = i5;
                                }
                            }
                            if (t == null) {
                                Arrays.fill(listArr, (Object) null);
                                subscriber.onComplete();
                                return;
                            }
                            subscriber.onNext(t);
                            iArr[i4] = iArr[i4] + 1;
                            j2++;
                        }
                    }
                    i2 = i;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                drain();
            } else if (th != this.error.get()) {
                k22.u(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void innerNext(List<T> list, int i) {
            this.lists[i] = list;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }
    }

    public ParallelSortedJoin(a<List<T>> aVar, Comparator<? super T> comparator2) {
        this.source = aVar;
        this.comparator = comparator2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.source.parallelism(), this.comparator);
        subscriber.onSubscribe(sortedJoinSubscription);
        this.source.subscribe(sortedJoinSubscription.subscribers);
    }
}
