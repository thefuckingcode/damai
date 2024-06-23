package io.reactivex.rxkotlin;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a>\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u0007\u001aU\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u001a\b\u0004\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00070\tH\b¨\u0006\n"}, d2 = {"zipWith", "Lio/reactivex/Maybe;", "Lkotlin/Pair;", "T", "U", "other", "Lio/reactivex/MaybeSource;", "R", "zipper", "Lkotlin/Function2;", "rxkotlin"}, k = 2, mv = {1, 1, 11})
/* compiled from: Maybes.kt */
public final class MaybesKt {
    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static final <T, U, R> Maybe<R> zipWith(Maybe<T> maybe, MaybeSource<U> maybeSource, Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(maybe, "$receiver");
        Intrinsics.checkParameterIsNotNull(maybeSource, "other");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Maybe<R> zipWith = maybe.zipWith(maybeSource, new MaybesKt$zipWith$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return zipWith;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public static final <T, U> Maybe<Pair<T, U>> zipWith(Maybe<T> maybe, MaybeSource<U> maybeSource) {
        Intrinsics.checkParameterIsNotNull(maybe, "$receiver");
        Intrinsics.checkParameterIsNotNull(maybeSource, "other");
        Maybe<R> zipWith = maybe.zipWith(maybeSource, MaybesKt$zipWith$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunction { t, u -> Pair(t,u) })");
        return zipWith;
    }
}
