package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import tb.po2;
import tb.ur2;

public final class SafeCollectorKt {
    private static final Function3<FlowCollector<Object>, Object, Continuation<? super ur2>, Object> a = ((Function3) po2.e(SafeCollectorKt$emitFun$1.INSTANCE, 3));
}
