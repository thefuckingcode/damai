package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j41;
import tb.k12;
import tb.p30;
import tb.pr2;

/* compiled from: Taobao */
public final class TimeoutKt {
    @NotNull
    public static final TimeoutCancellationException a(long j, @NotNull Job job) {
        return new TimeoutCancellationException("Timed out waiting for " + j + " ms", job);
    }

    private static final <U, T extends U> Object b(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        j41.e(timeoutCoroutine, DelayKt.c(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.getContext()));
        return pr2.f(timeoutCoroutine, timeoutCoroutine, function2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Nullable
    public static final <T> Object c(long j, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        TimeoutKt$withTimeoutOrNull$1 timeoutKt$withTimeoutOrNull$1;
        int i;
        TimeoutCancellationException e;
        Ref$ObjectRef ref$ObjectRef;
        if (continuation instanceof TimeoutKt$withTimeoutOrNull$1) {
            timeoutKt$withTimeoutOrNull$1 = (TimeoutKt$withTimeoutOrNull$1) continuation;
            int i2 = timeoutKt$withTimeoutOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                timeoutKt$withTimeoutOrNull$1.label = i2 - Integer.MIN_VALUE;
                Object obj = timeoutKt$withTimeoutOrNull$1.result;
                Object obj2 = b.d();
                i = timeoutKt$withTimeoutOrNull$1.label;
                if (i != 0) {
                    k12.b(obj);
                    if (j <= 0) {
                        return null;
                    }
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    try {
                        timeoutKt$withTimeoutOrNull$1.L$0 = function2;
                        timeoutKt$withTimeoutOrNull$1.L$1 = ref$ObjectRef2;
                        timeoutKt$withTimeoutOrNull$1.J$0 = j;
                        timeoutKt$withTimeoutOrNull$1.label = 1;
                        T t = (T) new TimeoutCoroutine(j, timeoutKt$withTimeoutOrNull$1);
                        ref$ObjectRef2.element = t;
                        Object b = b(t, function2);
                        if (b == b.d()) {
                            p30.c(timeoutKt$withTimeoutOrNull$1);
                        }
                        return b == obj2 ? obj2 : b;
                    } catch (TimeoutCancellationException e2) {
                        e = e2;
                        ref$ObjectRef = ref$ObjectRef2;
                        if (e.coroutine == ref$ObjectRef.element) {
                            return null;
                        }
                        throw e;
                    }
                } else if (i == 1) {
                    ref$ObjectRef = (Ref$ObjectRef) timeoutKt$withTimeoutOrNull$1.L$1;
                    Function2 function22 = (Function2) timeoutKt$withTimeoutOrNull$1.L$0;
                    try {
                        k12.b(obj);
                        return obj;
                    } catch (TimeoutCancellationException e3) {
                        e = e3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        timeoutKt$withTimeoutOrNull$1 = new TimeoutKt$withTimeoutOrNull$1(continuation);
        Object obj3 = timeoutKt$withTimeoutOrNull$1.result;
        Object obj22 = b.d();
        i = timeoutKt$withTimeoutOrNull$1.label;
        if (i != 0) {
        }
    }
}
