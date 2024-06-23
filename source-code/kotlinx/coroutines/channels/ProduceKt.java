package kotlinx.coroutines.channels;

import kotlin.BuilderInference;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dt1;
import tb.k12;
import tb.p30;
import tb.qn;
import tb.ur2;
import tb.wg;

/* compiled from: Taobao */
public final class ProduceKt {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @ExperimentalCoroutinesApi
    @Nullable
    public static final Object a(@NotNull ProducerScope<?> producerScope, @NotNull Function0<ur2> function0, @NotNull Continuation<? super ur2> continuation) {
        ProduceKt$awaitClose$1 produceKt$awaitClose$1;
        int i;
        if (continuation instanceof ProduceKt$awaitClose$1) {
            produceKt$awaitClose$1 = (ProduceKt$awaitClose$1) continuation;
            int i2 = produceKt$awaitClose$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                produceKt$awaitClose$1.label = i2 - Integer.MIN_VALUE;
                Object obj = produceKt$awaitClose$1.result;
                Object obj2 = b.d();
                i = produceKt$awaitClose$1.label;
                if (i != 0) {
                    k12.b(obj);
                    if (produceKt$awaitClose$1.getContext().get(Job.Key) == producerScope) {
                        produceKt$awaitClose$1.L$0 = producerScope;
                        produceKt$awaitClose$1.L$1 = function0;
                        produceKt$awaitClose$1.label = 1;
                        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(produceKt$awaitClose$1), 1);
                        cancellableContinuationImpl.initCancellability();
                        producerScope.invokeOnClose(new ProduceKt$awaitClose$4$1(cancellableContinuationImpl));
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == b.d()) {
                            p30.c(produceKt$awaitClose$1);
                        }
                        if (result == obj2) {
                            return obj2;
                        }
                    } else {
                        throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
                    }
                } else if (i == 1) {
                    function0 = (Function0) produceKt$awaitClose$1.L$1;
                    ProducerScope producerScope2 = (ProducerScope) produceKt$awaitClose$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (Throwable th) {
                        function0.invoke();
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function0.invoke();
                return ur2.INSTANCE;
            }
        }
        produceKt$awaitClose$1 = new ProduceKt$awaitClose$1(continuation);
        Object obj3 = produceKt$awaitClose$1.result;
        Object obj22 = b.d();
        i = produceKt$awaitClose$1.label;
        if (i != 0) {
        }
        function0.invoke();
        return ur2.INSTANCE;
    }

    public static /* synthetic */ Object b(ProducerScope producerScope, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = ProduceKt$awaitClose$2.INSTANCE;
        }
        return a(producerScope, function0, continuation);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <E> ReceiveChannel<E> c(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super ur2>, ? extends Object> function2) {
        return d(coroutineScope, coroutineContext, i, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, function2);
    }

    @NotNull
    public static final <E> ReceiveChannel<E> d(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow, @NotNull CoroutineStart coroutineStart, @Nullable Function1<? super Throwable, ur2> function1, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super ur2>, ? extends Object> function2) {
        dt1 dt1 = new dt1(qn.c(coroutineScope, coroutineContext), wg.b(i, bufferOverflow, null, 4, null));
        if (function1 != null) {
            dt1.invokeOnCompletion(function1);
        }
        dt1.start(coroutineStart, dt1, function2);
        return dt1;
    }

    public static /* synthetic */ ReceiveChannel e(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return c(coroutineScope, coroutineContext, i, function2);
    }

    public static /* synthetic */ ReceiveChannel f(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        int i3 = (i2 & 2) != 0 ? 0 : i;
        if ((i2 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i2 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((i2 & 16) != 0) {
            function1 = null;
        }
        return d(coroutineScope, coroutineContext, i3, bufferOverflow, coroutineStart, function1, function2);
    }
}
