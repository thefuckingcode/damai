package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import org.jetbrains.annotations.NotNull;
import tb.mh2;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class FlowKt__MergeKt {
    static {
        mh2.b(c.DEFAULT_CONCURRENCY_PROPERTY_NAME, 16, 1, Integer.MAX_VALUE);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> a(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return c.A(flow, new FlowKt__MergeKt$mapLatest$1(function2, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> b(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super ur2>, ? extends Object> function3) {
        return new ChannelFlowTransformLatest(function3, flow, null, 0, null, 28, null);
    }
}
