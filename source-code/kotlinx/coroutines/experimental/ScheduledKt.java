package kotlinx.coroutines.experimental;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a_\u0010\t\u001a\u0004\u0018\u00010\n\"\u0004\b\u0000\u0010\u000b\"\b\b\u0001\u0010\f*\u0002H\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\f0\r2'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000f¢\u0006\u0002\b\u0012H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aH\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0002\u001a\u00020\u00152'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000f¢\u0006\u0002\b\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aK\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aV\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000f¢\u0006\u0002\b\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001aJ\u0010\u001a\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0002\u001a\u00020\u00152'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000f¢\u0006\u0002\b\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aM\u0010\u001a\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aX\u0010\u001a\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000f¢\u0006\u0002\b\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u0002\u0004\n\u0002\b\t¨\u0006\u001b"}, d2 = {"TimeoutCancellationException", "Lkotlinx/coroutines/experimental/TimeoutCancellationException;", "time", "", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlinx/coroutines/experimental/timeunit/TimeUnit;", "coroutine", "Lkotlinx/coroutines/experimental/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/experimental/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "Lkotlin/coroutines/experimental/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/experimental/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "", "(ILkotlin/jvm/functions/Function2;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "(JLjava/util/concurrent/TimeUnit;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "(JLjava/util/concurrent/TimeUnit;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Scheduled.kt */
public final class ScheduledKt {
    public static final <T> Object withTimeout(int i, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return withTimeout((long) i, TimeUnit.MILLISECONDS, function2, continuation);
    }

    public static /* bridge */ /* synthetic */ Object withTimeout$default(long j, TimeUnit timeUnit, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return withTimeout(j, timeUnit, function2, continuation);
    }

    public static final <T> Object withTimeout(long j, TimeUnit timeUnit, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (j > 0) {
            return setupTimeout(new TimeoutCoroutine(j, timeUnit, CoroutineIntrinsics.normalizeContinuation(continuation)), function2);
        }
        throw new CancellationException("Timed out immediately");
    }

    /* access modifiers changed from: private */
    public static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        JobKt.disposeOnCompletion(timeoutCoroutine, DelayKt.getDelay(timeoutCoroutine.cont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine.unit, timeoutCoroutine));
        return UndispatchedKt.startUndispatchedOrReturn(timeoutCoroutine, timeoutCoroutine, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "for binary compatibility only")
    public static /* bridge */ /* synthetic */ Object withTimeout$default(long j, TimeUnit timeUnit, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return withTimeout(j, timeUnit, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "for binary compatibility only")
    public static final /* synthetic */ <T> Object withTimeout(long j, TimeUnit timeUnit, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        return withTimeout(j, timeUnit, new ScheduledKt$withTimeout$5(function1, null), continuation);
    }

    public static final <T> Object withTimeoutOrNull(int i, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return withTimeoutOrNull((long) i, TimeUnit.MILLISECONDS, function2, continuation);
    }

    public static /* bridge */ /* synthetic */ Object withTimeoutOrNull$default(long j, TimeUnit timeUnit, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return withTimeoutOrNull(j, timeUnit, function2, continuation);
    }

    public static final <T> Object withTimeoutOrNull(long j, TimeUnit timeUnit, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (j <= 0) {
            return null;
        }
        return setupTimeout(new TimeoutOrNullCoroutine(j, timeUnit, CoroutineIntrinsics.normalizeContinuation(continuation)), function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "for binary compatibility only")
    public static /* bridge */ /* synthetic */ Object withTimeoutOrNull$default(long j, TimeUnit timeUnit, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return withTimeoutOrNull(j, timeUnit, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "for binary compatibility only")
    public static final /* synthetic */ <T> Object withTimeoutOrNull(long j, TimeUnit timeUnit, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        return withTimeoutOrNull(j, timeUnit, new ScheduledKt$withTimeoutOrNull$5(function1, null), continuation);
    }

    public static final TimeoutCancellationException TimeoutCancellationException(long j, TimeUnit timeUnit, Job job) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(job, "coroutine");
        return new TimeoutCancellationException("Timed out waiting for " + j + ' ' + timeUnit, job);
    }
}
