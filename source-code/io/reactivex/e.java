package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BiConsumerSingleObserver;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.observers.FutureSingleObserver;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.maybe.MaybeFilterSingle;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.single.SingleAmb;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleContains;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDefer;
import io.reactivex.internal.operators.single.SingleDelay;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithSingle;
import io.reactivex.internal.operators.single.SingleDetach;
import io.reactivex.internal.operators.single.SingleDoAfterSuccess;
import io.reactivex.internal.operators.single.SingleDoAfterTerminate;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleDoOnError;
import io.reactivex.internal.operators.single.SingleDoOnEvent;
import io.reactivex.internal.operators.single.SingleDoOnSubscribe;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleEquals;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleFromPublisher;
import io.reactivex.internal.operators.single.SingleFromUnsafeSource;
import io.reactivex.internal.operators.single.SingleHide;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleLift;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleNever;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.SingleZipIterable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.a;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public abstract class e<T> implements SingleSource<T> {
    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> amb(Iterable<? extends SingleSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return k22.o(new SingleAmb(null, iterable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> ambArray(SingleSource<? extends T>... singleSourceArr) {
        if (singleSourceArr.length == 0) {
            return error(SingleInternalHelper.emptyThrower());
        }
        if (singleSourceArr.length == 1) {
            return wrap(singleSourceArr[0]);
        }
        return k22.o(new SingleAmb(singleSourceArr, null));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> concat(Iterable<? extends SingleSource<? extends T>> iterable) {
        return concat(b.fromIterable(iterable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> concatArray(SingleSource<? extends T>... singleSourceArr) {
        return k22.l(new FlowableConcatMap(b.fromArray(singleSourceArr), SingleInternalHelper.toFlowable(), 2, ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> create(SingleOnSubscribe<T> singleOnSubscribe) {
        ObjectHelper.requireNonNull(singleOnSubscribe, "source is null");
        return k22.o(new SingleCreate(singleOnSubscribe));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> defer(Callable<? extends SingleSource<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, "singleSupplier is null");
        return k22.o(new SingleDefer(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<Boolean> equals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, "first is null");
        ObjectHelper.requireNonNull(singleSource2, "second is null");
        return k22.o(new SingleEquals(singleSource, singleSource2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return k22.o(new SingleError(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, "callable is null");
        return k22.o(new SingleFromCallable(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> fromFuture(Future<? extends T> future) {
        return toSingle(b.fromFuture(future));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> fromObservable(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "observableSource is null");
        return k22.o(new ObservableSingleSingle(observableSource, null));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static <T> e<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "publisher is null");
        return k22.o(new SingleFromPublisher(publisher));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> just(T t) {
        ObjectHelper.requireNonNull(t, "value is null");
        return k22.o(new SingleJust(t));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> merge(Iterable<? extends SingleSource<? extends T>> iterable) {
        return merge(b.fromIterable(iterable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public static <T> b<T> mergeDelayError(Iterable<? extends SingleSource<? extends T>> iterable) {
        return mergeDelayError(b.fromIterable(iterable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> never() {
        return k22.o(SingleNever.INSTANCE);
    }

    private e<T> timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.o(new SingleTimeout(this, j, timeUnit, scheduler, singleSource));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static e<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, a.a());
    }

    private static <T> e<T> toSingle(b<T> bVar) {
        return k22.o(new FlowableSingleSingle(bVar, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> unsafeCreate(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "onSubscribe is null");
        if (!(singleSource instanceof e)) {
            return k22.o(new SingleFromUnsafeSource(singleSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, U> e<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer) {
        return using(callable, function, consumer, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> wrap(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "source is null");
        if (singleSource instanceof e) {
            return k22.o((e) singleSource);
        }
        return k22.o(new SingleFromUnsafeSource(singleSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> e<R> zip(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return k22.o(new SingleZipIterable(iterable, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> e<R> zipArray(Function<? super Object[], ? extends R> function, SingleSource<? extends T>... singleSourceArr) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(singleSourceArr, "sources is null");
        if (singleSourceArr.length == 0) {
            return error(new NoSuchElementException());
        }
        return k22.o(new SingleZipArray(singleSourceArr, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> ambWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return ambArray(this, singleSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> R as(@NonNull SingleConverter<T, ? extends R> singleConverter) {
        return (R) ((SingleConverter) ObjectHelper.requireNonNull(singleConverter, "converter is null")).apply(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return (T) blockingMultiObserver.blockingGet();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> cache() {
        return k22.o(new SingleCache(this));
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: io.reactivex.e<R>, io.reactivex.e<U> */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> e<U> cast(Class<? extends U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return (e<R>) map(Functions.castFunction(cls));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> e<R> compose(SingleTransformer<? super T, ? extends R> singleTransformer) {
        return wrap(((SingleTransformer) ObjectHelper.requireNonNull(singleTransformer, "transformer is null")).apply(this));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final b<T> concatWith(SingleSource<? extends T> singleSource) {
        return concat(this, singleSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<Boolean> contains(Object obj) {
        return contains(obj, ObjectHelper.equalsPredicate());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final e<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, a.a(), false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> delaySubscription(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return k22.o(new SingleDelayWithCompletable(this, completableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> doAfterSuccess(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "doAfterSuccess is null");
        return k22.o(new SingleDoAfterSuccess(this, consumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> doAfterTerminate(Action action) {
        ObjectHelper.requireNonNull(action, "onAfterTerminate is null");
        return k22.o(new SingleDoAfterTerminate(this, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> doFinally(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return k22.o(new SingleDoFinally(this, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> doOnDispose(Action action) {
        ObjectHelper.requireNonNull(action, "onDispose is null");
        return k22.o(new SingleDoOnDispose(this, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> doOnError(Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onError is null");
        return k22.o(new SingleDoOnError(this, consumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> doOnEvent(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, "onEvent is null");
        return k22.o(new SingleDoOnEvent(this, biConsumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        return k22.o(new SingleDoOnSubscribe(this, consumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> doOnSuccess(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        return k22.o(new SingleDoOnSuccess(this, consumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final c<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return k22.m(new MaybeFilterSingle(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> e<R> flatMap(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return k22.o(new SingleFlatMap(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return k22.k(new SingleFlatMapCompletable(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> c<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return k22.m(new SingleFlatMapMaybe(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return toObservable().flatMap(function);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> b<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        return toFlowable().flatMap(function);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> b<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return k22.l(new SingleFlatMapIterableFlowable(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return k22.n(new SingleFlatMapIterableObservable(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> hide() {
        return k22.o(new SingleHide(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> e<R> lift(SingleOperator<? extends R, ? super T> singleOperator) {
        ObjectHelper.requireNonNull(singleOperator, "onLift is null");
        return k22.o(new SingleLift(this, singleOperator));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> e<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return k22.o(new SingleMap(this, function));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final b<T> mergeWith(SingleSource<? extends T> singleSource) {
        return merge(this, singleSource);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final e<T> observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.o(new SingleObserveOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> onErrorResumeNext(e<? extends T> eVar) {
        ObjectHelper.requireNonNull(eVar, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(Functions.justFunction(eVar));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> onErrorReturn(Function<Throwable, ? extends T> function) {
        ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return k22.o(new SingleOnErrorReturn(this, function, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> onErrorReturnItem(T t) {
        ObjectHelper.requireNonNull(t, "value is null");
        return k22.o(new SingleOnErrorReturn(this, null, t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final e<T> onTerminateDetach() {
        return k22.o(new SingleDetach(this));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final b<T> repeat() {
        return toFlowable().repeat();
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final b<T> repeatUntil(BooleanSupplier booleanSupplier) {
        return toFlowable().repeatUntil(booleanSupplier);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final b<T> repeatWhen(Function<? super b<Object>, ? extends Publisher<?>> function) {
        return toFlowable().repeatWhen(function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> retry() {
        return toSingle(toFlowable().retry());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> retryWhen(Function<? super b<Throwable>, ? extends Publisher<?>> function) {
        return toSingle(toFlowable().retryWhen(function));
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING);
    }

    /* access modifiers changed from: protected */
    public abstract void subscribeActual(@NonNull SingleObserver<? super T> singleObserver);

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final e<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.o(new SingleSubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends SingleObserver<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> takeUntil(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return takeUntil(new CompletableToFlowable(completableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final e<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, a.a(), null);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R to(Function<? super e<T>, R> function) {
        try {
            return (R) ((Function) ObjectHelper.requireNonNull(function, "convert is null")).apply(this);
        } catch (Throwable th) {
            ff0.b(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a toCompletable() {
        return k22.k(new CompletableFromSingle(this));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final b<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).fuseToFlowable();
        }
        return k22.l(new SingleToFlowable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureSingleObserver());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final c<T> toMaybe() {
        if (this instanceof FuseToMaybe) {
            return ((FuseToMaybe) this).fuseToMaybe();
        }
        return k22.m(new MaybeFromSingle(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).fuseToObservable();
        }
        return k22.n(new SingleToObservable(this));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    @Experimental
    public final e<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.o(new SingleUnsubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> e<R> zipWith(SingleSource<U> singleSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return zip(this, singleSource, biFunction);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concat(ObservableSource<? extends SingleSource<? extends T>> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        return k22.n(new ObservableConcatMap(observableSource, SingleInternalHelper.toObservable(), 2, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return toSingle(b.fromFuture(future, j, timeUnit));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> merge(Publisher<? extends SingleSource<? extends T>> publisher) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        return k22.l(new FlowableFlatMapPublisher(publisher, SingleInternalHelper.toFlowable(), false, Integer.MAX_VALUE, b.bufferSize()));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public static <T> b<T> mergeDelayError(Publisher<? extends SingleSource<? extends T>> publisher) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        return k22.l(new FlowableFlatMapPublisher(publisher, SingleInternalHelper.toFlowable(), true, Integer.MAX_VALUE, b.bufferSize()));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static e<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.o(new SingleTimer(j, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, U> e<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z) {
        ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        ObjectHelper.requireNonNull(function, "singleFunction is null");
        ObjectHelper.requireNonNull(consumer, "disposer is null");
        return k22.o(new SingleUsing(callable, function, consumer, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<Boolean> contains(Object obj, BiPredicate<Object, Object> biPredicate) {
        ObjectHelper.requireNonNull(obj, "value is null");
        ObjectHelper.requireNonNull(biPredicate, "comparer is null");
        return k22.o(new SingleContains(this, obj, biPredicate));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    @Experimental
    public final e<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, a.a(), z);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final b<T> repeat(long j) {
        return toFlowable().repeat(j);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> retry(long j) {
        return toSingle(toFlowable().retry(j));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, "onCallback is null");
        BiConsumerSingleObserver biConsumerSingleObserver = new BiConsumerSingleObserver(biConsumer);
        subscribe(biConsumerSingleObserver);
        return biConsumerSingleObserver;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final e<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, scheduler, null);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> error(Throwable th) {
        ObjectHelper.requireNonNull(th, "error is null");
        return error(Functions.justCallable(th));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static <T> e<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return toSingle(b.fromFuture(future, j, timeUnit, scheduler));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final e<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> e<T> delaySubscription(SingleSource<U> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return k22.o(new SingleDelayWithSingle(this, singleSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> onErrorResumeNext(Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        ObjectHelper.requireNonNull(function, "resumeFunctionInCaseOfError is null");
        return k22.o(new SingleResumeNext(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return toSingle(toFlowable().retry(biPredicate));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <E> e<T> takeUntil(Publisher<E> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return k22.o(new SingleTakeUntil(this, publisher));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.cancel();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final e<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return timeout0(j, timeUnit, scheduler, singleSource);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> concat(Publisher<? extends SingleSource<? extends T>> publisher) {
        return concat(publisher, 2);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static <T> e<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        return toSingle(b.fromFuture(future, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<T> merge(SingleSource<? extends SingleSource<? extends T>> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "source is null");
        return k22.o(new SingleFlatMap(singleSource, Functions.identity()));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public static <T> b<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return mergeDelayError(b.fromArray(singleSource, singleSource2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> e<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), singleSource, singleSource2);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    @Experimental
    public final e<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.o(new SingleDelay(this, j, timeUnit, scheduler, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final e<T> retry(long j, Predicate<? super Throwable> predicate) {
        return toSingle(toFlowable().retry(j, predicate));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> concat(Publisher<? extends SingleSource<? extends T>> publisher, int i) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return k22.l(new FlowableConcatMapPublisher(publisher, SingleInternalHelper.toFlowable(), i, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> e<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return k22.o(new SingleDelayWithObservable(this, observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> retry(Predicate<? super Throwable> predicate) {
        return toSingle(toFlowable().retry(predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.ON_ERROR_MISSING);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E> e<T> takeUntil(SingleSource<? extends E> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return takeUntil(new SingleToFlowable(singleSource));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final e<T> timeout(long j, TimeUnit timeUnit, SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return timeout0(j, timeUnit, a.a(), singleSource);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return merge(b.fromArray(singleSource, singleSource2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(consumer, consumer2);
        subscribe(consumerSingleObserver);
        return consumerSingleObserver;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public static <T> b<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return mergeDelayError(b.fromArray(singleSource, singleSource2, singleSource3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> e<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return zipArray(Functions.toFunction(function3), singleSource, singleSource2, singleSource3);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> e<T> delaySubscription(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return k22.o(new SingleDelayWithPublisher(this, publisher));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return concat(b.fromArray(singleSource, singleSource2));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return merge(b.fromArray(singleSource, singleSource2, singleSource3));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final e<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, a.a());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final e<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(d.timer(j, timeUnit, scheduler));
    }

    @Override // io.reactivex.SingleSource
    @SchedulerSupport("none")
    public final void subscribe(SingleObserver<? super T> singleObserver) {
        ObjectHelper.requireNonNull(singleObserver, "subscriber is null");
        SingleObserver<? super T> A = k22.A(this, singleObserver);
        ObjectHelper.requireNonNull(A, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            subscribeActual(A);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            ff0.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return concat(b.fromArray(singleSource, singleSource2, singleSource3));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public static <T> b<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return mergeDelayError(b.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> e<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return zipArray(Functions.toFunction(function4), singleSource, singleSource2, singleSource3, singleSource4);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return merge(b.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> b<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return concat(b.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> e<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        return zipArray(Functions.toFunction(function5), singleSource, singleSource2, singleSource3, singleSource4, singleSource5);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> e<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        return zipArray(Functions.toFunction(function6), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> e<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        ObjectHelper.requireNonNull(singleSource7, "source7 is null");
        return zipArray(Functions.toFunction(function7), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> e<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        ObjectHelper.requireNonNull(singleSource7, "source7 is null");
        ObjectHelper.requireNonNull(singleSource8, "source8 is null");
        return zipArray(Functions.toFunction(function8), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> e<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, SingleSource<? extends T9> singleSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        ObjectHelper.requireNonNull(singleSource7, "source7 is null");
        ObjectHelper.requireNonNull(singleSource8, "source8 is null");
        ObjectHelper.requireNonNull(singleSource9, "source9 is null");
        return zipArray(Functions.toFunction(function9), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9);
    }
}
