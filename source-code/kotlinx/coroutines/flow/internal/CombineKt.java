package kotlinx.coroutines.flow.internal;

import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pj0;
import tb.ur2;

/* compiled from: Taobao */
public final class CombineKt {
    @PublishedApi
    @Nullable
    public static final <R, T> Object a(@NotNull FlowCollector<? super R> flowCollector, @NotNull Flow<? extends T>[] flowArr, @NotNull Function0<T[]> function0, @NotNull Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super ur2>, ? extends Object> function3, @NotNull Continuation<? super ur2> continuation) {
        Object a = pj0.a(new CombineKt$combineInternal$2(flowArr, function0, function3, flowCollector, null), continuation);
        return a == b.d() ? a : ur2.INSTANCE;
    }
}
