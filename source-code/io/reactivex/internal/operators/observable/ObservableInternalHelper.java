package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.SingleSource;
import io.reactivex.d;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import tb.jm;
import tb.k22;
import tb.vj1;

/* compiled from: Taobao */
public final class ObservableInternalHelper {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class BufferedReplayCallable<T> implements Callable<jm<T>> {
        private final int bufferSize;
        private final d<T> parent;

        BufferedReplayCallable(d<T> dVar, int i) {
            this.parent = dVar;
            this.bufferSize = i;
        }

        @Override // java.util.concurrent.Callable
        public jm<T> call() {
            return this.parent.replay(this.bufferSize);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class BufferedTimedReplayCallable<T> implements Callable<jm<T>> {
        private final int bufferSize;
        private final d<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        BufferedTimedReplayCallable(d<T> dVar, int i, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.parent = dVar;
            this.bufferSize = i;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        @Override // java.util.concurrent.Callable
        public jm<T> call() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum ErrorMapperFilter implements Function<vj1<Object>, Throwable>, Predicate<vj1<Object>> {
        INSTANCE;

        public Throwable apply(vj1<Object> vj1) throws Exception {
            return vj1.d();
        }

        public boolean test(vj1<Object> vj1) throws Exception {
            return vj1.g();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<U> apply(T t) throws Exception {
            return new ObservableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Iterable"));
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
    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<R> apply(T t) throws Exception {
            return new ObservableMap((ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.combiner, t));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {
        final Function<? super T, ? extends ObservableSource<U>> itemDelay;

        ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.itemDelay = function;
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<T> apply(T t) throws Exception {
            return new ObservableTake((ObservableSource) ObjectHelper.requireNonNull(this.itemDelay.apply(t), "The itemDelay returned a null ObservableSource"), 1).map(Functions.justFunction(t)).defaultIfEmpty(t);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ObservableMapper<T, R> implements Function<T, d<R>> {
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;

        ObservableMapper(Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.mapper = function;
        }

        @Override // io.reactivex.functions.Function
        public d<R> apply(T t) throws Exception {
            return k22.n(new SingleToObservable((SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null SingleSource")));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ObserverOnComplete<T> implements Action {
        final Observer<T> observer;

        ObserverOnComplete(Observer<T> observer2) {
            this.observer = observer2;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.observer.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ObserverOnError<T> implements Consumer<Throwable> {
        final Observer<T> observer;

        ObserverOnError(Observer<T> observer2) {
            this.observer = observer2;
        }

        public void accept(Throwable th) throws Exception {
            this.observer.onError(th);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ObserverOnNext<T> implements Consumer<T> {
        final Observer<T> observer;

        ObserverOnNext(Observer<T> observer2) {
            this.observer = observer2;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws Exception {
            this.observer.onNext(t);
        }
    }

    /* compiled from: Taobao */
    static final class RepeatWhenOuterHandler implements Function<d<vj1<Object>>, ObservableSource<?>> {
        private final Function<? super d<Object>, ? extends ObservableSource<?>> handler;

        RepeatWhenOuterHandler(Function<? super d<Object>, ? extends ObservableSource<?>> function) {
            this.handler = function;
        }

        public ObservableSource<?> apply(d<vj1<Object>> dVar) throws Exception {
            return (ObservableSource) this.handler.apply(dVar.map(MapToInt.INSTANCE));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ReplayCallable<T> implements Callable<jm<T>> {
        private final d<T> parent;

        ReplayCallable(d<T> dVar) {
            this.parent = dVar;
        }

        @Override // java.util.concurrent.Callable
        public jm<T> call() {
            return this.parent.replay();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ReplayFunction<T, R> implements Function<d<T>, ObservableSource<R>> {
        private final Scheduler scheduler;
        private final Function<? super d<T>, ? extends ObservableSource<R>> selector;

        ReplayFunction(Function<? super d<T>, ? extends ObservableSource<R>> function, Scheduler scheduler2) {
            this.selector = function;
            this.scheduler = scheduler2;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((d) ((d) obj));
        }

        public ObservableSource<R> apply(d<T> dVar) throws Exception {
            return d.wrap((ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(dVar), "The selector returned a null ObservableSource")).observeOn(this.scheduler);
        }
    }

    /* compiled from: Taobao */
    static final class RetryWhenInner implements Function<d<vj1<Object>>, ObservableSource<?>> {
        private final Function<? super d<Throwable>, ? extends ObservableSource<?>> handler;

        RetryWhenInner(Function<? super d<Throwable>, ? extends ObservableSource<?>> function) {
            this.handler = function;
        }

        public ObservableSource<?> apply(d<vj1<Object>> dVar) throws Exception {
            ErrorMapperFilter errorMapperFilter = ErrorMapperFilter.INSTANCE;
            return (ObservableSource) this.handler.apply(dVar.takeWhile(errorMapperFilter).map(errorMapperFilter));
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
    public static final class TimedReplayCallable<T> implements Callable<jm<T>> {
        private final d<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        TimedReplayCallable(d<T> dVar, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.parent = dVar;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        @Override // java.util.concurrent.Callable
        public jm<T> call() {
            return this.parent.replay(this.time, this.unit, this.scheduler);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
        private final Function<? super Object[], ? extends R> zipper;

        ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.zipper = function;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((List) ((List) obj));
        }

        public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> list) {
            return d.zipIterable(list, this.zipper, false, d.bufferSize());
        }
    }

    private ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    private static <T, R> Function<T, d<R>> convertSingleMapperToObservableMapper(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return new ObservableMapper(function);
    }

    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Action observerOnComplete(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static Function<d<vj1<Object>>, ObservableSource<?>> repeatWhenHandler(Function<? super d<Object>, ? extends ObservableSource<?>> function) {
        return new RepeatWhenOuterHandler(function);
    }

    public static <T> Callable<jm<T>> replayCallable(d<T> dVar) {
        return new ReplayCallable(dVar);
    }

    public static <T, R> Function<d<T>, ObservableSource<R>> replayFunction(Function<? super d<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T> Function<d<vj1<Object>>, ObservableSource<?>> retryWhenHandler(Function<? super d<Throwable>, ? extends ObservableSource<?>> function) {
        return new RetryWhenInner(function);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T, R> d<R> switchMapSingle(d<T> dVar, Function<? super T, ? extends SingleSource<? extends R>> function) {
        return dVar.switchMap(convertSingleMapperToObservableMapper(function), 1);
    }

    public static <T, R> d<R> switchMapSingleDelayError(d<T> dVar, Function<? super T, ? extends SingleSource<? extends R>> function) {
        return dVar.switchMapDelayError(convertSingleMapperToObservableMapper(function), 1);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    public static <T> Callable<jm<T>> replayCallable(d<T> dVar, int i) {
        return new BufferedReplayCallable(dVar, i);
    }

    public static <T> Callable<jm<T>> replayCallable(d<T> dVar, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplayCallable(dVar, i, j, timeUnit, scheduler);
    }

    public static <T> Callable<jm<T>> replayCallable(d<T> dVar, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplayCallable(dVar, j, timeUnit, scheduler);
    }
}
