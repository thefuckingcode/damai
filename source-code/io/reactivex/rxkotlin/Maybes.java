package io.reactivex.rxkotlin;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\\\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u00050\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0007Js\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\n2 \b\u0004\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r0\u000fH\bJ\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\n2&\b\u0004\u0010\u000e\u001a \u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\r0\u0012H\bJ§\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\n2,\b\u0004\u0010\u000e\u001a&\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\r0\u0015H\bJÁ\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\n22\b\u0004\u0010\u000e\u001a,\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\r0\u0018H\bJÛ\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\u0019\"\u0004\b\u0007\u0010\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\n28\b\u0004\u0010\u000e\u001a2\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\r0\u001bH\bJõ\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\u0019\"\u0004\b\u0007\u0010\u001c\"\u0004\b\b\u0010\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\n2>\b\u0004\u0010\u000e\u001a8\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\r0\u001eH\bJ\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0016\"\u0004\b\u0006\u0010\u0019\"\u0004\b\u0007\u0010\u001c\"\u0004\b\b\u0010\u001f\"\u0004\b\t\u0010\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0\n2D\b\u0004\u0010\u000e\u001a>\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H\r0!H\bJB\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$0\"0\u0004\"\u0004\b\u0000\u0010#\"\u0004\b\u0001\u0010$2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H#0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H$0\nH\u0007JY\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\u0004\b\u0000\u0010#\"\u0004\b\u0001\u0010$\"\u0004\b\u0002\u0010\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H#0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H$0\n2\u001a\b\u0004\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H\r0%H\b¨\u0006&"}, d2 = {"Lio/reactivex/rxkotlin/Maybes;", "", "()V", "zip", "Lio/reactivex/Maybe;", "Lkotlin/Triple;", "T1", "T2", "T3", "s1", "Lio/reactivex/MaybeSource;", "s2", "s3", "R", "zipper", "Lkotlin/Function3;", "T4", "s4", "Lkotlin/Function4;", "T5", "s5", "Lkotlin/Function5;", "T6", "s6", "Lkotlin/Function6;", "T7", "s7", "Lkotlin/Function7;", "T8", "s8", "Lkotlin/Function8;", "T9", "s9", "Lkotlin/Function9;", "Lkotlin/Pair;", "T", "U", "Lkotlin/Function2;", "rxkotlin"}, k = 1, mv = {1, 1, 11})
/* compiled from: Maybes.kt */
public final class Maybes {
    public static final Maybes INSTANCE = new Maybes();

    private Maybes() {
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T, U, R> Maybe<R> zip(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2, Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, new Maybes$zip$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, BiFunc…-> zipper.invoke(t, u) })");
        return zip;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T, U> Maybe<Pair<T, U>> zip(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Maybe<Pair<T, U>> zip = Maybe.zip(maybeSource, maybeSource2, Maybes$zip$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, BiFunc…on { t, u -> Pair(t,u) })");
        return zip;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, R> Maybe<R> zip(MaybeSource<T1> maybeSource, MaybeSource<T2> maybeSource2, MaybeSource<T3> maybeSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(function3, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, new Maybes$zip$3(function3));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, Fu…per.invoke(t1, t2, t3) })");
        return zip;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3> Maybe<Triple<T1, T2, T3>> zip(MaybeSource<T1> maybeSource, MaybeSource<T2> maybeSource2, MaybeSource<T3> maybeSource3) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Maybe<Triple<T1, T2, T3>> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, Maybes$zip$4.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, Fu…t3 -> Triple(t1,t2,t3) })");
        return zip;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Maybe<R> zip(MaybeSource<T1> maybeSource, MaybeSource<T2> maybeSource2, MaybeSource<T3> maybeSource3, MaybeSource<T4> maybeSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(function4, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, new Maybes$zip$5(function4));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…invoke(t1, t2, t3, t4) })");
        return zip;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, R> Maybe<R> zip(MaybeSource<T1> maybeSource, MaybeSource<T2> maybeSource2, MaybeSource<T3> maybeSource3, MaybeSource<T4> maybeSource4, MaybeSource<T5> maybeSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(maybeSource5, "s5");
        Intrinsics.checkParameterIsNotNull(function5, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, new Maybes$zip$6(function5));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…ke(t1, t2, t3, t4, t5) })");
        return zip;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, R> Maybe<R> zip(MaybeSource<T1> maybeSource, MaybeSource<T2> maybeSource2, MaybeSource<T3> maybeSource3, MaybeSource<T4> maybeSource4, MaybeSource<T5> maybeSource5, MaybeSource<T6> maybeSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(maybeSource5, "s5");
        Intrinsics.checkParameterIsNotNull(maybeSource6, "s6");
        Intrinsics.checkParameterIsNotNull(function6, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, new Maybes$zip$7(function6));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…1, t2, t3, t4, t5, t6) })");
        return zip;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, R> Maybe<R> zip(MaybeSource<T1> maybeSource, MaybeSource<T2> maybeSource2, MaybeSource<T3> maybeSource3, MaybeSource<T4> maybeSource4, MaybeSource<T5> maybeSource5, MaybeSource<T6> maybeSource6, MaybeSource<T7> maybeSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(maybeSource5, "s5");
        Intrinsics.checkParameterIsNotNull(maybeSource6, "s6");
        Intrinsics.checkParameterIsNotNull(maybeSource7, "s7");
        Intrinsics.checkParameterIsNotNull(function7, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, new Maybes$zip$8(function7));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…2, t3, t4, t5, t6, t7) })");
        return zip;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Maybe<R> zip(MaybeSource<T1> maybeSource, MaybeSource<T2> maybeSource2, MaybeSource<T3> maybeSource3, MaybeSource<T4> maybeSource4, MaybeSource<T5> maybeSource5, MaybeSource<T6> maybeSource6, MaybeSource<T7> maybeSource7, MaybeSource<T8> maybeSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(maybeSource5, "s5");
        Intrinsics.checkParameterIsNotNull(maybeSource6, "s6");
        Intrinsics.checkParameterIsNotNull(maybeSource7, "s7");
        Intrinsics.checkParameterIsNotNull(maybeSource8, "s8");
        Intrinsics.checkParameterIsNotNull(function8, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, new Maybes$zip$9(function8));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…3, t4, t5, t6, t7, t8) })");
        return zip;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Maybe<R> zip(MaybeSource<T1> maybeSource, MaybeSource<T2> maybeSource2, MaybeSource<T3> maybeSource3, MaybeSource<T4> maybeSource4, MaybeSource<T5> maybeSource5, MaybeSource<T6> maybeSource6, MaybeSource<T7> maybeSource7, MaybeSource<T8> maybeSource8, MaybeSource<T9> maybeSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(maybeSource5, "s5");
        Intrinsics.checkParameterIsNotNull(maybeSource6, "s6");
        Intrinsics.checkParameterIsNotNull(maybeSource7, "s7");
        Intrinsics.checkParameterIsNotNull(maybeSource8, "s8");
        Intrinsics.checkParameterIsNotNull(maybeSource9, "s9");
        Intrinsics.checkParameterIsNotNull(function9, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, maybeSource9, new Maybes$zip$10(function9));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…4, t5, t6, t7, t8, t9) })");
        return zip;
    }
}
