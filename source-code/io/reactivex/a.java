package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAmb;
import io.reactivex.internal.operators.completable.CompletableCache;
import io.reactivex.internal.operators.completable.CompletableConcat;
import io.reactivex.internal.operators.completable.CompletableConcatArray;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDefer;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableDetach;
import io.reactivex.internal.operators.completable.CompletableDisposeOn;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableDoOnEvent;
import io.reactivex.internal.operators.completable.CompletableEmpty;
import io.reactivex.internal.operators.completable.CompletableError;
import io.reactivex.internal.operators.completable.CompletableErrorSupplier;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.internal.operators.completable.CompletableFromCallable;
import io.reactivex.internal.operators.completable.CompletableFromObservable;
import io.reactivex.internal.operators.completable.CompletableFromPublisher;
import io.reactivex.internal.operators.completable.CompletableFromRunnable;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableFromUnsafeSource;
import io.reactivex.internal.operators.completable.CompletableHide;
import io.reactivex.internal.operators.completable.CompletableLift;
import io.reactivex.internal.operators.completable.CompletableMerge;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorIterable;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.internal.operators.completable.CompletableNever;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.internal.operators.completable.CompletablePeek;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.CompletableTimeout;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.completable.CompletableToObservable;
import io.reactivex.internal.operators.completable.CompletableToSingle;
import io.reactivex.internal.operators.completable.CompletableUsing;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public abstract class a implements CompletableSource {
    @SchedulerSupport("none")
    @CheckReturnValue
    public static a amb(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return k22.k(new CompletableAmb(null, iterable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a ambArray(CompletableSource... completableSourceArr) {
        ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return k22.k(new CompletableAmb(completableSourceArr, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a complete() {
        return k22.k(CompletableEmpty.INSTANCE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a concat(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return k22.k(new CompletableConcatIterable(iterable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a concatArray(CompletableSource... completableSourceArr) {
        ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return k22.k(new CompletableConcatArray(completableSourceArr));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a create(CompletableOnSubscribe completableOnSubscribe) {
        ObjectHelper.requireNonNull(completableOnSubscribe, "source is null");
        return k22.k(new CompletableCreate(completableOnSubscribe));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a defer(Callable<? extends CompletableSource> callable) {
        ObjectHelper.requireNonNull(callable, "completableSupplier");
        return k22.k(new CompletableDefer(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    private a doOnLifecycle(Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(action2, "onTerminate is null");
        ObjectHelper.requireNonNull(action3, "onAfterTerminate is null");
        ObjectHelper.requireNonNull(action4, "onDispose is null");
        return k22.k(new CompletablePeek(this, consumer, consumer2, action, action2, action3, action4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return k22.k(new CompletableErrorSupplier(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a fromAction(Action action) {
        ObjectHelper.requireNonNull(action, "run is null");
        return k22.k(new CompletableFromAction(action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a fromCallable(Callable<?> callable) {
        ObjectHelper.requireNonNull(callable, "callable is null");
        return k22.k(new CompletableFromCallable(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a fromFuture(Future<?> future) {
        ObjectHelper.requireNonNull(future, "future is null");
        return fromAction(Functions.futureAction(future));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> a fromObservable(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "observable is null");
        return k22.k(new CompletableFromObservable(observableSource));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static <T> a fromPublisher(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, "publisher is null");
        return k22.k(new CompletableFromPublisher(publisher));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a fromRunnable(Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "run is null");
        return k22.k(new CompletableFromRunnable(runnable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> a fromSingle(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "single is null");
        return k22.k(new CompletableFromSingle(singleSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a merge(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return k22.k(new CompletableMergeIterable(iterable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    private static a merge0(Publisher<? extends CompletableSource> publisher, int i, boolean z) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return k22.k(new CompletableMerge(publisher, i, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a mergeArray(CompletableSource... completableSourceArr) {
        ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return k22.k(new CompletableMergeArray(completableSourceArr));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a mergeArrayDelayError(CompletableSource... completableSourceArr) {
        ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        return k22.k(new CompletableMergeDelayErrorArray(completableSourceArr));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a mergeDelayError(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return k22.k(new CompletableMergeDelayErrorIterable(iterable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a never() {
        return k22.k(CompletableNever.INSTANCE);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    private a timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.k(new CompletableTimeout(this, j, timeUnit, scheduler, completableSource));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static a timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, io.reactivex.schedulers.a.a());
    }

    private static NullPointerException toNpe(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a unsafeCreate(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "source is null");
        if (!(completableSource instanceof a)) {
            return k22.k(new CompletableFromUnsafeSource(completableSource));
        }
        throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <R> a using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer) {
        return using(callable, function, consumer, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a wrap(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "source is null");
        if (completableSource instanceof a) {
            return k22.k((a) completableSource);
        }
        return k22.k(new CompletableFromUnsafeSource(completableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a ambWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return ambArray(this, completableSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> d<T> andThen(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "next is null");
        return k22.n(new ObservableDelaySubscriptionOther(observableSource, toObservable()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> R as(@NonNull CompletableConverter<? extends R> completableConverter) {
        return (R) ((CompletableConverter) ObjectHelper.requireNonNull(completableConverter, "converter is null")).apply(this);
    }

    @SchedulerSupport("none")
    public final void blockingAwait() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        blockingMultiObserver.blockingGet();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Throwable blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.blockingGetError();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a cache() {
        return k22.k(new CompletableCache(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a compose(CompletableTransformer completableTransformer) {
        return wrap(((CompletableTransformer) ObjectHelper.requireNonNull(completableTransformer, "transformer is null")).apply(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a concatWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return concatArray(this, completableSource);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final a delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, io.reactivex.schedulers.a.a(), false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a doAfterTerminate(Action action) {
        Consumer<? super Disposable> emptyConsumer = Functions.emptyConsumer();
        Consumer<? super Throwable> emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action2, action, action2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a doFinally(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return k22.k(new CompletableDoFinally(this, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a doOnComplete(Action action) {
        Consumer<? super Disposable> emptyConsumer = Functions.emptyConsumer();
        Consumer<? super Throwable> emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action, action2, action2, action2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a doOnDispose(Action action) {
        Consumer<? super Disposable> emptyConsumer = Functions.emptyConsumer();
        Consumer<? super Throwable> emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action2, action2, action);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a doOnError(Consumer<? super Throwable> consumer) {
        Consumer<? super Disposable> emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, consumer, action, action, action, action);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a doOnEvent(Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onEvent is null");
        return k22.k(new CompletableDoOnEvent(this, consumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a doOnSubscribe(Consumer<? super Disposable> consumer) {
        Consumer<? super Throwable> emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnLifecycle(consumer, emptyConsumer, action, action, action, action);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a doOnTerminate(Action action) {
        Consumer<? super Disposable> emptyConsumer = Functions.emptyConsumer();
        Consumer<? super Throwable> emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action, action2, action2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a hide() {
        return k22.k(new CompletableHide(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a lift(CompletableOperator completableOperator) {
        ObjectHelper.requireNonNull(completableOperator, "onLift is null");
        return k22.k(new CompletableLift(this, completableOperator));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a mergeWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return mergeArray(this, completableSource);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final a observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.k(new CompletableObserveOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a onErrorComplete() {
        return onErrorComplete(Functions.alwaysTrue());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a onErrorResumeNext(Function<? super Throwable, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, "errorMapper is null");
        return k22.k(new CompletableResumeNext(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final a onTerminateDetach() {
        return k22.k(new CompletableDetach(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a repeat() {
        return fromPublisher(toFlowable().repeat());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a repeatUntil(BooleanSupplier booleanSupplier) {
        return fromPublisher(toFlowable().repeatUntil(booleanSupplier));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a repeatWhen(Function<? super b<Object>, ? extends Publisher<?>> function) {
        return fromPublisher(toFlowable().repeatWhen(function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a retry() {
        return fromPublisher(toFlowable().retry());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a retryWhen(Function<? super b<Throwable>, ? extends Publisher<?>> function) {
        return fromPublisher(toFlowable().retryWhen(function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a startWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return concatArray(completableSource, this);
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        subscribe(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    /* access modifiers changed from: protected */
    public abstract void subscribeActual(CompletableObserver completableObserver);

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final a subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.k(new CompletableSubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends CompletableObserver> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<Void> test() {
        TestObserver<Void> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final a timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, io.reactivex.schedulers.a.a(), null);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> U to(Function<? super a, U> function) {
        try {
            return (U) ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
        } catch (Throwable th) {
            ff0.b(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> b<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).fuseToFlowable();
        }
        return k22.l(new CompletableToFlowable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> c<T> toMaybe() {
        if (this instanceof FuseToMaybe) {
            return ((FuseToMaybe) this).fuseToMaybe();
        }
        return k22.m(new MaybeFromCompletable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> d<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).fuseToObservable();
        }
        return k22.n(new CompletableToObservable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> e<T> toSingle(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, "completionValueSupplier is null");
        return k22.o(new CompletableToSingle(this, callable, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> e<T> toSingleDefault(T t) {
        ObjectHelper.requireNonNull(t, "completionValue is null");
        return k22.o(new CompletableToSingle(this, null, t));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final a unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.k(new CompletableDisposeOn(this, scheduler));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static a timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.k(new CompletableTimer(j, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <R> a using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z) {
        ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        ObjectHelper.requireNonNull(function, "completableFunction is null");
        ObjectHelper.requireNonNull(consumer, "disposer is null");
        return k22.k(new CompletableUsing(callable, function, consumer, z));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final a delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a onErrorComplete(Predicate<? super Throwable> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return k22.k(new CompletableOnErrorComplete(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a repeat(long j) {
        return fromPublisher(toFlowable().repeat(j));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return fromPublisher(toFlowable().retry(biPredicate));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final a timeout(long j, TimeUnit timeUnit, CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return timeout0(j, timeUnit, io.reactivex.schedulers.a.a(), completableSource);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static a concat(Publisher<? extends CompletableSource> publisher) {
        return concat(publisher, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static a error(Throwable th) {
        ObjectHelper.requireNonNull(th, "error is null");
        return k22.k(new CompletableError(th));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static a merge(Publisher<? extends CompletableSource> publisher) {
        return merge0(publisher, Integer.MAX_VALUE, false);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static a mergeDelayError(Publisher<? extends CompletableSource> publisher) {
        return merge0(publisher, Integer.MAX_VALUE, true);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> b<T> andThen(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, "next is null");
        return k22.l(new FlowableDelaySubscriptionOther(publisher, toFlowable()));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final a delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return k22.k(new CompletableDelay(this, j, timeUnit, scheduler, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a retry(long j) {
        return fromPublisher(toFlowable().retry(j));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> d<T> startWith(d<T> dVar) {
        ObjectHelper.requireNonNull(dVar, "other is null");
        return dVar.concatWith(toObservable());
    }

    @Override // io.reactivex.CompletableSource
    @SchedulerSupport("none")
    public final void subscribe(CompletableObserver completableObserver) {
        ObjectHelper.requireNonNull(completableObserver, "s is null");
        try {
            subscribeActual(k22.x(this, completableObserver));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            ff0.b(th);
            k22.u(th);
            throw toNpe(th);
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<Void> test(boolean z) {
        TestObserver<Void> testObserver = new TestObserver<>();
        if (z) {
            testObserver.cancel();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static a concat(Publisher<? extends CompletableSource> publisher, int i) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return k22.k(new CompletableConcat(publisher, i));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static a merge(Publisher<? extends CompletableSource> publisher, int i) {
        return merge0(publisher, i, false);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static a mergeDelayError(Publisher<? extends CompletableSource> publisher, int i) {
        return merge0(publisher, i, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final boolean blockingAwait(long j, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.blockingAwait(j, timeUnit);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Throwable blockingGet(long j, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.blockingGetError(j, timeUnit);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final a retry(long j, Predicate<? super Throwable> predicate) {
        return fromPublisher(toFlowable().retry(j, predicate));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final a timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, scheduler, null);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> e<T> andThen(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "next is null");
        return k22.o(new SingleDelayWithCompletable(singleSource, this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a retry(Predicate<? super Throwable> predicate) {
        return fromPublisher(toFlowable().retry(predicate));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> b<T> startWith(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return toFlowable().startWith((Publisher) publisher);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final a timeout(long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return timeout0(j, timeUnit, scheduler, completableSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> c<T> andThen(MaybeSource<T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "next is null");
        return k22.m(new MaybeDelayWithCompletable(maybeSource, this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final a andThen(CompletableSource completableSource) {
        return concatWith(completableSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Action action, Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(consumer, action);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Action action) {
        ObjectHelper.requireNonNull(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(action);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }
}
