package io.reactivex.rxkotlin;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\b\b\u0000\u0010\n*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0002\u001a\u0012\u0010\u000b\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u001a\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\t*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004H\u0002\u001aX\u0010\u000e\u001a\u00020\u0002\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\u001aX\u0010\u000e\u001a\u00020\u0002\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u00132\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\u001a2\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007\u001aX\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\u001aX\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u00172\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\u001aX\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u00132\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\u001aH\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u00192\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"onCompleteStub", "Lkotlin/Function0;", "", "onErrorStub", "Lkotlin/Function1;", "", "onNextStub", "", "asConsumer", "Lio/reactivex/functions/Consumer;", "T", "asOnCompleteAction", "Lio/reactivex/functions/Action;", "asOnErrorConsumer", "blockingSubscribeBy", "Lio/reactivex/Flowable;", "onError", "onComplete", "onNext", "Lio/reactivex/Observable;", "subscribeBy", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/Completable;", "Lio/reactivex/Maybe;", "onSuccess", "Lio/reactivex/Single;", "rxkotlin"}, k = 2, mv = {1, 1, 11})
/* compiled from: subscribers.kt */
public final class SubscribersKt {
    private static final Function0<Unit> onCompleteStub = SubscribersKt$onCompleteStub$1.INSTANCE;
    private static final Function1<Throwable, Unit> onErrorStub = SubscribersKt$onErrorStub$1.INSTANCE;
    private static final Function1<Object, Unit> onNextStub = SubscribersKt$onNextStub$1.INSTANCE;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static final <T> Consumer<T> asConsumer(Function1<? super T, Unit> function1) {
        if (function1 == onNextStub) {
            Consumer<T> emptyConsumer = Functions.emptyConsumer();
            Intrinsics.checkExpressionValueIsNotNull(emptyConsumer, "Functions.emptyConsumer()");
            return emptyConsumer;
        }
        if (function1 != null) {
            function1 = new SubscribersKt$sam$io_reactivex_functions_Consumer$0(function1);
        }
        return (Consumer) function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static final Consumer<Throwable> asOnErrorConsumer(Function1<? super Throwable, Unit> function1) {
        if (function1 == onErrorStub) {
            Consumer<Throwable> consumer = Functions.ON_ERROR_MISSING;
            Intrinsics.checkExpressionValueIsNotNull(consumer, "Functions.ON_ERROR_MISSING");
            return consumer;
        }
        if (function1 != null) {
            function1 = new SubscribersKt$sam$io_reactivex_functions_Consumer$0(function1);
        }
        return (Consumer) function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Action$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static final Action asOnCompleteAction(Function0<Unit> function0) {
        if (function0 == onCompleteStub) {
            Action action = Functions.EMPTY_ACTION;
            Intrinsics.checkExpressionValueIsNotNull(action, "Functions.EMPTY_ACTION");
            return action;
        }
        if (function0 != null) {
            function0 = new SubscribersKt$sam$io_reactivex_functions_Action$0(function0);
        }
        return (Action) function0;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static /* bridge */ /* synthetic */ Disposable subscribeBy$default(Observable observable, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = onErrorStub;
        }
        if ((i & 2) != 0) {
            function0 = onCompleteStub;
        }
        if ((i & 4) != 0) {
            function12 = onNextStub;
        }
        return subscribeBy(observable, function1, function0, function12);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static final <T> Disposable subscribeBy(Observable<T> observable, Function1<? super Throwable, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        Disposable subscribe = observable.subscribe(asConsumer(function12), asOnErrorConsumer(function1), asOnCompleteAction(function0));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return subscribe;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static /* bridge */ /* synthetic */ Disposable subscribeBy$default(Flowable flowable, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = onErrorStub;
        }
        if ((i & 2) != 0) {
            function0 = onCompleteStub;
        }
        if ((i & 4) != 0) {
            function12 = onNextStub;
        }
        return subscribeBy(flowable, function1, function0, function12);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final <T> Disposable subscribeBy(Flowable<T> flowable, Function1<? super Throwable, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        Disposable subscribe = flowable.subscribe(asConsumer(function12), asOnErrorConsumer(function1), asOnCompleteAction(function0));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return subscribe;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static /* bridge */ /* synthetic */ Disposable subscribeBy$default(Single single, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = onErrorStub;
        }
        if ((i & 2) != 0) {
            function12 = onNextStub;
        }
        return subscribeBy(single, function1, function12);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static final <T> Disposable subscribeBy(Single<T> single, Function1<? super Throwable, Unit> function1, Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(single, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function12, "onSuccess");
        Disposable subscribe = single.subscribe(asConsumer(function12), asOnErrorConsumer(function1));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onSuccess.asCo…rror.asOnErrorConsumer())");
        return subscribe;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static /* bridge */ /* synthetic */ Disposable subscribeBy$default(Maybe maybe, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = onErrorStub;
        }
        if ((i & 2) != 0) {
            function0 = onCompleteStub;
        }
        if ((i & 4) != 0) {
            function12 = onNextStub;
        }
        return subscribeBy(maybe, function1, function0, function12);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static final <T> Disposable subscribeBy(Maybe<T> maybe, Function1<? super Throwable, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(maybe, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onSuccess");
        Disposable subscribe = maybe.subscribe(asConsumer(function12), asOnErrorConsumer(function1), asOnCompleteAction(function0));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onSuccess.asCo…ete.asOnCompleteAction())");
        return subscribe;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static /* bridge */ /* synthetic */ Disposable subscribeBy$default(Completable completable, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = onErrorStub;
        }
        if ((i & 2) != 0) {
            function0 = onCompleteStub;
        }
        return subscribeBy(completable, function1, function0);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static final Disposable subscribeBy(Completable completable, Function1<? super Throwable, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(completable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Function1<Throwable, Unit> function12 = onErrorStub;
        if (function1 == function12 && function0 == onCompleteStub) {
            Disposable subscribe = completable.subscribe();
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe()");
            return subscribe;
        } else if (function1 == function12) {
            Disposable subscribe2 = completable.subscribe(new SubscribersKt$sam$io_reactivex_functions_Action$0(function0));
            Intrinsics.checkExpressionValueIsNotNull(subscribe2, "subscribe(onComplete)");
            return subscribe2;
        } else {
            Disposable subscribe3 = completable.subscribe(asOnCompleteAction(function0), new SubscribersKt$sam$io_reactivex_functions_Consumer$0(function1));
            Intrinsics.checkExpressionValueIsNotNull(subscribe3, "subscribe(onComplete.asO…ion(), Consumer(onError))");
            return subscribe3;
        }
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    public static /* bridge */ /* synthetic */ void blockingSubscribeBy$default(Observable observable, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = onErrorStub;
        }
        if ((i & 2) != 0) {
            function0 = onCompleteStub;
        }
        if ((i & 4) != 0) {
            function12 = onNextStub;
        }
        blockingSubscribeBy(observable, function1, function0, function12);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    public static final <T> void blockingSubscribeBy(Observable<T> observable, Function1<? super Throwable, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        observable.blockingSubscribe(asConsumer(function12), asOnErrorConsumer(function1), asOnCompleteAction(function0));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static /* bridge */ /* synthetic */ void blockingSubscribeBy$default(Flowable flowable, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = onErrorStub;
        }
        if ((i & 2) != 0) {
            function0 = onCompleteStub;
        }
        if ((i & 4) != 0) {
            function12 = onNextStub;
        }
        blockingSubscribeBy(flowable, function1, function0, function12);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static final <T> void blockingSubscribeBy(Flowable<T> flowable, Function1<? super Throwable, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        flowable.blockingSubscribe(asConsumer(function12), asOnErrorConsumer(function1), asOnCompleteAction(function0));
    }
}
