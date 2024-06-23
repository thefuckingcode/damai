package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.Emitter;
import io.reactivex.Scheduler;
import io.reactivex.b;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.im;

/* compiled from: Taobao */
public final class FlowableInternalHelper {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class BufferedReplayCallable<T> implements Callable<im<T>> {
        private final int bufferSize;
        private final b<T> parent;

        BufferedReplayCallable(b<T> bVar, int i) {
            this.parent = bVar;
            this.bufferSize = i;
        }

        @Override // java.util.concurrent.Callable
        public im<T> call() {
            return this.parent.replay(this.bufferSize);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class BufferedTimedReplay<T> implements Callable<im<T>> {
        private final int bufferSize;
        private final b<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        BufferedTimedReplay(b<T> bVar, int i, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.parent = bVar;
            this.bufferSize = i;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        @Override // java.util.concurrent.Callable
        public im<T> call() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class FlatMapIntoIterable<T, U> implements Function<T, Publisher<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }

        @Override // io.reactivex.functions.Function
        public Publisher<U> apply(T t) throws Exception {
            return new FlowableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final T t;

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t2) {
            this.combiner = biFunction;
            this.t = t2;
        }

        @Override // io.reactivex.functions.Function
        public R apply(U u) throws Exception {
            return (R) this.combiner.apply(this.t, u);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, Publisher<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends Publisher<? extends U>> mapper;

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends Publisher<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }

        @Override // io.reactivex.functions.Function
        public Publisher<R> apply(T t) throws Exception {
            return new FlowableMapPublisher((Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher"), new FlatMapWithCombinerInner(this.combiner, t));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ItemDelayFunction<T, U> implements Function<T, Publisher<T>> {
        final Function<? super T, ? extends Publisher<U>> itemDelay;

        ItemDelayFunction(Function<? super T, ? extends Publisher<U>> function) {
            this.itemDelay = function;
        }

        @Override // io.reactivex.functions.Function
        public Publisher<T> apply(T t) throws Exception {
            return new FlowableTakePublisher((Publisher) ObjectHelper.requireNonNull(this.itemDelay.apply(t), "The itemDelay returned a null Publisher"), 1).map(Functions.justFunction(t)).defaultIfEmpty(t);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ReplayCallable<T> implements Callable<im<T>> {
        private final b<T> parent;

        ReplayCallable(b<T> bVar) {
            this.parent = bVar;
        }

        @Override // java.util.concurrent.Callable
        public im<T> call() {
            return this.parent.replay();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ReplayFunction<T, R> implements Function<b<T>, Publisher<R>> {
        private final Scheduler scheduler;
        private final Function<? super b<T>, ? extends Publisher<R>> selector;

        ReplayFunction(Function<? super b<T>, ? extends Publisher<R>> function, Scheduler scheduler2) {
            this.selector = function;
            this.scheduler = scheduler2;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((b) ((b) obj));
        }

        public Publisher<R> apply(b<T> bVar) throws Exception {
            return b.fromPublisher((Publisher) ObjectHelper.requireNonNull(this.selector.apply(bVar), "The selector returned a null Publisher")).observeOn(this.scheduler);
        }
    }

    /* compiled from: Taobao */
    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        public void accept(Subscription subscription) throws Exception {
            subscription.request(AbsPerformance.LONG_NIL);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> consumer;

        SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.consumer = biConsumer;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply(obj, (Emitter) ((Emitter) obj2));
        }

        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.consumer.accept(s, emitter);
            return s;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> consumer;

        SimpleGenerator(Consumer<Emitter<T>> consumer2) {
            this.consumer = consumer2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply(obj, (Emitter) ((Emitter) obj2));
        }

        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.consumer.accept(emitter);
            return s;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class SubscriberOnComplete<T> implements Action {
        final Subscriber<T> subscriber;

        SubscriberOnComplete(Subscriber<T> subscriber2) {
            this.subscriber = subscriber2;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.subscriber.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class SubscriberOnError<T> implements Consumer<Throwable> {
        final Subscriber<T> subscriber;

        SubscriberOnError(Subscriber<T> subscriber2) {
            this.subscriber = subscriber2;
        }

        public void accept(Throwable th) throws Exception {
            this.subscriber.onError(th);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class SubscriberOnNext<T> implements Consumer<T> {
        final Subscriber<T> subscriber;

        SubscriberOnNext(Subscriber<T> subscriber2) {
            this.subscriber = subscriber2;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws Exception {
            this.subscriber.onNext(t);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class TimedReplay<T> implements Callable<im<T>> {
        private final b<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        TimedReplay(b<T> bVar, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.parent = bVar;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        @Override // java.util.concurrent.Callable
        public im<T> call() {
            return this.parent.replay(this.time, this.unit, this.scheduler);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ZipIterableFunction<T, R> implements Function<List<Publisher<? extends T>>, Publisher<? extends R>> {
        private final Function<? super Object[], ? extends R> zipper;

        ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.zipper = function;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((List) ((List) obj));
        }

        public Publisher<? extends R> apply(List<Publisher<? extends T>> list) {
            return b.zipIterable(list, this.zipper, false, b.bufferSize());
        }
    }

    private FlowableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, Publisher<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, Publisher<R>> flatMapWithCombiner(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, Publisher<T>> itemDelay(Function<? super T, ? extends Publisher<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Callable<im<T>> replayCallable(b<T> bVar) {
        return new ReplayCallable(bVar);
    }

    public static <T, R> Function<b<T>, Publisher<R>> replayFunction(Function<? super b<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T> Action subscriberOnComplete(Subscriber<T> subscriber) {
        return new SubscriberOnComplete(subscriber);
    }

    public static <T> Consumer<Throwable> subscriberOnError(Subscriber<T> subscriber) {
        return new SubscriberOnError(subscriber);
    }

    public static <T> Consumer<T> subscriberOnNext(Subscriber<T> subscriber) {
        return new SubscriberOnNext(subscriber);
    }

    public static <T, R> Function<List<Publisher<? extends T>>, Publisher<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    public static <T> Callable<im<T>> replayCallable(b<T> bVar, int i) {
        return new BufferedReplayCallable(bVar, i);
    }

    public static <T> Callable<im<T>> replayCallable(b<T> bVar, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplay(bVar, i, j, timeUnit, scheduler);
    }

    public static <T> Callable<im<T>> replayCallable(b<T> bVar, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplay(bVar, j, timeUnit, scheduler);
    }
}
