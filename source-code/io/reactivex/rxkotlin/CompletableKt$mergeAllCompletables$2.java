package io.reactivex.rxkotlin;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "it", "apply"}, k = 3, mv = {1, 1, 11})
/* compiled from: completable.kt */
final class CompletableKt$mergeAllCompletables$2<T, R> implements Function<Completable, CompletableSource> {
    public static final CompletableKt$mergeAllCompletables$2 INSTANCE = new CompletableKt$mergeAllCompletables$2();

    CompletableKt$mergeAllCompletables$2() {
    }

    public final Completable apply(Completable completable) {
        Intrinsics.checkParameterIsNotNull(completable, "it");
        return completable;
    }
}
