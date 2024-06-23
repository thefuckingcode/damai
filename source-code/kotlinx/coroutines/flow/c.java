package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.BuilderInference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
public final class c {
    @NotNull
    public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> A(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super ur2>, ? extends Object> function3) {
        return FlowKt__MergeKt.b(flow, function3);
    }

    @NotNull
    public static final <T> Flow<T> a(@NotNull Flow<? extends T> flow, int i, @NotNull BufferOverflow bufferOverflow) {
        return f.a(flow, i, bufferOverflow);
    }

    @Nullable
    public static final <T> Object c(@NotNull Flow<? extends T> flow, @NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Throwable> continuation) {
        return FlowKt__ErrorsKt.a(flow, flowCollector, continuation);
    }

    @Nullable
    public static final Object d(@NotNull Flow<?> flow, @NotNull Continuation<? super ur2> continuation) {
        return e.a(flow, continuation);
    }

    @Nullable
    public static final <T> Object e(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super ur2>, ? extends Object> function2, @NotNull Continuation<? super ur2> continuation) {
        return e.b(flow, function2, continuation);
    }

    @Nullable
    public static final <T> Object f(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.a(flow, continuation);
    }

    @Nullable
    public static final <T> Object g(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.b(flow, function2, continuation);
    }

    @NotNull
    public static final <T> Flow<T> h(@NotNull Flow<? extends T> flow) {
        return FlowKt__DistinctKt.a(flow);
    }

    @Nullable
    public static final <T> Object i(@NotNull FlowCollector<? super T> flowCollector, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull Continuation<? super ur2> continuation) {
        return FlowKt__ChannelsKt.b(flowCollector, receiveChannel, continuation);
    }

    @Nullable
    public static final <T> Object j(@NotNull FlowCollector<? super T> flowCollector, @NotNull Flow<? extends T> flow, @NotNull Continuation<? super ur2> continuation) {
        return e.c(flowCollector, flow, continuation);
    }

    public static final void k(@NotNull FlowCollector<?> flowCollector) {
        FlowKt__EmittersKt.b(flowCollector);
    }

    @Nullable
    public static final <T> Object l(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.a(flow, continuation);
    }

    @Nullable
    public static final <T> Object m(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.b(flow, function2, continuation);
    }

    @Nullable
    public static final <T> Object n(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.c(flow, continuation);
    }

    @Nullable
    public static final <T> Object o(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.d(flow, function2, continuation);
    }

    @NotNull
    public static final ReceiveChannel<ur2> p(@NotNull CoroutineScope coroutineScope, long j, long j2) {
        return FlowKt__DelayKt.a(coroutineScope, j, j2);
    }

    @NotNull
    public static final <T> Flow<T> r(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super ur2>, ? extends Object> function2) {
        return d.a(function2);
    }

    @NotNull
    public static final <T> Flow<T> s(T t) {
        return d.b(t);
    }

    @Nullable
    public static final <T> Object t(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.f(flow, continuation);
    }

    @Nullable
    public static final <T> Object u(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.g(flow, continuation);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> v(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.a(flow, function2);
    }

    @Nullable
    public static final <S, T extends S> Object w(@NotNull Flow<? extends T> flow, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, @NotNull Continuation<? super S> continuation) {
        return FlowKt__ReduceKt.h(flow, function3, continuation);
    }

    @Nullable
    public static final <T> Object x(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.i(flow, continuation);
    }

    @Nullable
    public static final <T> Object y(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.j(flow, continuation);
    }

    @Nullable
    public static final <T, C extends Collection<? super T>> Object z(@NotNull Flow<? extends T> flow, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        return FlowKt__CollectionKt.a(flow, c, continuation);
    }
}
