package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aX\u0010\u0000\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0007\u001ao\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\t*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072 \b\u0004\u0010\n\u001a\u001a\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\t0\u000bH\b\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\f\"\u0004\b\u0004\u0010\t*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00072&\b\u0004\u0010\n\u001a \u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\t0\u000eH\b\u001a£\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\f\"\u0004\b\u0004\u0010\u000f\"\u0004\b\u0005\u0010\t*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00072,\b\u0004\u0010\n\u001a&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\t0\u0011H\b\u001a>\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00130\u00120\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0007H\u0007\u001aU\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u0010\t*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00072\u001a\b\u0004\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\t0\u0015H\b\u001a>\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00130\u00120\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0007H\u0007\u001aU\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u0010\t*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00072\u001a\b\u0004\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\t0\u0015H\b¨\u0006\u0018"}, d2 = {"withLatestFrom", "Lio/reactivex/Flowable;", "Lkotlin/Triple;", "T", "T1", "T2", "o1", "Lorg/reactivestreams/Publisher;", "o2", "R", "combiner", "Lkotlin/Function3;", "T3", "o3", "Lkotlin/Function4;", "T4", "o4", "Lkotlin/Function5;", "Lkotlin/Pair;", "U", "other", "Lkotlin/Function2;", "zipWith", "zipper", "rxkotlin"}, k = 2, mv = {1, 1, 11})
/* compiled from: Flowables.kt */
public final class FlowablesKt {
    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, U, R> Flowable<R> withLatestFrom(Flowable<T> flowable, Publisher<U> publisher, Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "other");
        Intrinsics.checkParameterIsNotNull(function2, "combiner");
        Flowable<R> withLatestFrom = flowable.withLatestFrom(publisher, new FlowablesKt$withLatestFrom$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi…combiner.invoke(t, u)  })");
        return withLatestFrom;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, U> Flowable<Pair<T, U>> withLatestFrom(Flowable<T> flowable, Publisher<U> publisher) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "other");
        Flowable<R> withLatestFrom = flowable.withLatestFrom(publisher, FlowablesKt$withLatestFrom$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi…on{ t, u -> Pair(t,u)  })");
        return withLatestFrom;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, T1, T2, R> Flowable<R> withLatestFrom(Flowable<T> flowable, Publisher<T1> publisher, Publisher<T2> publisher2, Function3<? super T, ? super T1, ? super T2, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "o1");
        Intrinsics.checkParameterIsNotNull(publisher2, "o2");
        Intrinsics.checkParameterIsNotNull(function3, "combiner");
        Flowable<R> withLatestFrom = flowable.withLatestFrom(publisher, publisher2, new FlowablesKt$withLatestFrom$3(function3));
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, F…iner.invoke(t, t1, t2) })");
        return withLatestFrom;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, T1, T2> Flowable<Triple<T, T1, T2>> withLatestFrom(Flowable<T> flowable, Publisher<T1> publisher, Publisher<T2> publisher2) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "o1");
        Intrinsics.checkParameterIsNotNull(publisher2, "o2");
        Flowable<R> withLatestFrom = flowable.withLatestFrom(publisher, publisher2, FlowablesKt$withLatestFrom$4.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, F…2 -> Triple(t, t1, t2) })");
        return withLatestFrom;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, T1, T2, T3, R> Flowable<R> withLatestFrom(Flowable<T> flowable, Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Function4<? super T, ? super T1, ? super T2, ? super T3, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "o1");
        Intrinsics.checkParameterIsNotNull(publisher2, "o2");
        Intrinsics.checkParameterIsNotNull(publisher3, "o3");
        Intrinsics.checkParameterIsNotNull(function4, "combiner");
        Flowable<R> withLatestFrom = flowable.withLatestFrom(publisher, publisher2, publisher3, new FlowablesKt$withLatestFrom$5(function4));
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, o….invoke(t, t1, t2, t3) })");
        return withLatestFrom;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, T1, T2, T3, T4, R> Flowable<R> withLatestFrom(Flowable<T> flowable, Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Publisher<T4> publisher4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "o1");
        Intrinsics.checkParameterIsNotNull(publisher2, "o2");
        Intrinsics.checkParameterIsNotNull(publisher3, "o3");
        Intrinsics.checkParameterIsNotNull(publisher4, "o4");
        Intrinsics.checkParameterIsNotNull(function5, "combiner");
        Flowable<R> withLatestFrom = flowable.withLatestFrom(publisher, publisher2, publisher3, publisher4, new FlowablesKt$withLatestFrom$6(function5));
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, o…oke(t, t1, t2, t3, t4) })");
        return withLatestFrom;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, U, R> Flowable<R> zipWith(Flowable<T> flowable, Publisher<U> publisher, Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "other");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Flowable<R> zipWith = flowable.zipWith(publisher, new FlowablesKt$zipWith$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return zipWith;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, U> Flowable<Pair<T, U>> zipWith(Flowable<T> flowable, Publisher<U> publisher) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "other");
        Flowable<R> zipWith = flowable.zipWith(publisher, FlowablesKt$zipWith$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunction { t, u -> Pair(t,u) })");
        return zipWith;
    }
}
