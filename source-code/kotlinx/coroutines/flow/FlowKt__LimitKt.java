package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.qj0;
import tb.ur2;

/* compiled from: Taobao */
final /* synthetic */ class FlowKt__LimitKt {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object b(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super ur2> continuation) {
        FlowKt__LimitKt$collectWhile$1 flowKt__LimitKt$collectWhile$1;
        int i;
        AbortFlowException e;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof FlowKt__LimitKt$collectWhile$1) {
            flowKt__LimitKt$collectWhile$1 = (FlowKt__LimitKt$collectWhile$1) continuation;
            int i2 = flowKt__LimitKt$collectWhile$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$collectWhile$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__LimitKt$collectWhile$1.result;
                Object obj2 = b.d();
                i = flowKt__LimitKt$collectWhile$1.label;
                if (i != 0) {
                    k12.b(obj);
                    FlowCollector<? super Object> flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1(function2);
                    try {
                        flowKt__LimitKt$collectWhile$1.L$0 = flowKt__LimitKt$collectWhile$collector$1;
                        flowKt__LimitKt$collectWhile$1.label = 1;
                        if (flow.collect(flowKt__LimitKt$collectWhile$collector$1, flowKt__LimitKt$collectWhile$1) == obj2) {
                            return obj2;
                        }
                    } catch (AbortFlowException e2) {
                        e = e2;
                        flowCollector = flowKt__LimitKt$collectWhile$collector$1;
                        qj0.a(e, flowCollector);
                        return ur2.INSTANCE;
                    }
                } else if (i == 1) {
                    flowCollector = (FlowKt__LimitKt$collectWhile$collector$1) flowKt__LimitKt$collectWhile$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (AbortFlowException e3) {
                        e = e3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ur2.INSTANCE;
            }
        }
        flowKt__LimitKt$collectWhile$1 = new FlowKt__LimitKt$collectWhile$1(continuation);
        Object obj3 = flowKt__LimitKt$collectWhile$1.result;
        Object obj22 = b.d();
        i = flowKt__LimitKt$collectWhile$1.label;
        if (i != 0) {
        }
        return ur2.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    public static final <T> Object c(FlowCollector<? super T> flowCollector, T t, Continuation<? super ur2> continuation) {
        FlowKt__LimitKt$emitAbort$1 flowKt__LimitKt$emitAbort$1;
        int i;
        if (continuation instanceof FlowKt__LimitKt$emitAbort$1) {
            flowKt__LimitKt$emitAbort$1 = (FlowKt__LimitKt$emitAbort$1) continuation;
            int i2 = flowKt__LimitKt$emitAbort$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$emitAbort$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__LimitKt$emitAbort$1.result;
                Object obj2 = b.d();
                i = flowKt__LimitKt$emitAbort$1.label;
                if (i != 0) {
                    k12.b(obj);
                    flowKt__LimitKt$emitAbort$1.L$0 = flowCollector;
                    flowKt__LimitKt$emitAbort$1.label = 1;
                    if (flowCollector.emit(t, flowKt__LimitKt$emitAbort$1) == obj2) {
                        return obj2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    flowCollector = (FlowCollector) flowKt__LimitKt$emitAbort$1.L$0;
                    k12.b(obj);
                }
                throw new AbortFlowException(flowCollector);
            }
        }
        flowKt__LimitKt$emitAbort$1 = new FlowKt__LimitKt$emitAbort$1(continuation);
        Object obj3 = flowKt__LimitKt$emitAbort$1.result;
        Object obj22 = b.d();
        i = flowKt__LimitKt$emitAbort$1.label;
        if (i != 0) {
        }
        throw new AbortFlowException(flowCollector);
    }
}
