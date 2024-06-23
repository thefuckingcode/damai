package io.reactivex.rxkotlin;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Action;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007\u001a\u001a\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u001a\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\t\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u000b\u001a\u0012\u0010\b\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\n0\f\u001a\u0012\u0010\b\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\n0\r¨\u0006\u000e"}, d2 = {"concatAll", "Lio/reactivex/Completable;", "kotlin.jvm.PlatformType", "", "Lio/reactivex/CompletableSource;", "mergeAllCompletables", "Lio/reactivex/Flowable;", "Lio/reactivex/Observable;", "toCompletable", "Lkotlin/Function0;", "", "Lio/reactivex/functions/Action;", "Ljava/util/concurrent/Callable;", "Ljava/util/concurrent/Future;", "rxkotlin"}, k = 2, mv = {1, 1, 11})
/* compiled from: completable.kt */
public final class CompletableKt {
    public static final Completable toCompletable(Action action) {
        Intrinsics.checkParameterIsNotNull(action, "$receiver");
        Completable fromAction = Completable.fromAction(action);
        Intrinsics.checkExpressionValueIsNotNull(fromAction, "Completable.fromAction(this)");
        return fromAction;
    }

    public static final Completable toCompletable(Callable<? extends Object> callable) {
        Intrinsics.checkParameterIsNotNull(callable, "$receiver");
        Completable fromCallable = Completable.fromCallable(callable);
        Intrinsics.checkExpressionValueIsNotNull(fromCallable, "Completable.fromCallable(this)");
        return fromCallable;
    }

    public static final Completable toCompletable(Future<? extends Object> future) {
        Intrinsics.checkParameterIsNotNull(future, "$receiver");
        Completable fromFuture = Completable.fromFuture(future);
        Intrinsics.checkExpressionValueIsNotNull(fromFuture, "Completable.fromFuture(this)");
        return fromFuture;
    }

    public static final Completable toCompletable(Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "$receiver");
        Completable fromCallable = Completable.fromCallable(new CompletableKt$sam$java_util_concurrent_Callable$0(function0));
        Intrinsics.checkExpressionValueIsNotNull(fromCallable, "Completable.fromCallable(this)");
        return fromCallable;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static final Completable mergeAllCompletables(Observable<Completable> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        return observable.flatMapCompletable(CompletableKt$mergeAllCompletables$1.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final Completable mergeAllCompletables(Flowable<Completable> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return flowable.flatMapCompletable(CompletableKt$mergeAllCompletables$2.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static final Completable concatAll(Iterable<? extends CompletableSource> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        return Completable.concat(iterable);
    }
}
