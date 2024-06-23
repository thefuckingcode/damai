package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.qc;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class FlowKt__CountKt {

    /* compiled from: Taobao */
    public static final class a implements FlowCollector<T> {
        final /* synthetic */ Ref$IntRef a;

        public a(Ref$IntRef ref$IntRef) {
            this.a = ref$IntRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
            this.a.element++;
            return ur2.INSTANCE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object a(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super Integer> continuation) {
        FlowKt__CountKt$count$1 flowKt__CountKt$count$1;
        int i;
        Ref$IntRef ref$IntRef;
        if (continuation instanceof FlowKt__CountKt$count$1) {
            flowKt__CountKt$count$1 = (FlowKt__CountKt$count$1) continuation;
            int i2 = flowKt__CountKt$count$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__CountKt$count$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__CountKt$count$1.result;
                Object obj2 = b.d();
                i = flowKt__CountKt$count$1.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                    FlowCollector<? super Object> aVar = new a(ref$IntRef2);
                    flowKt__CountKt$count$1.L$0 = ref$IntRef2;
                    flowKt__CountKt$count$1.label = 1;
                    if (flow.collect(aVar, flowKt__CountKt$count$1) == obj2) {
                        return obj2;
                    }
                    ref$IntRef = ref$IntRef2;
                } else if (i == 1) {
                    ref$IntRef = (Ref$IntRef) flowKt__CountKt$count$1.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return qc.b(ref$IntRef.element);
            }
        }
        flowKt__CountKt$count$1 = new FlowKt__CountKt$count$1(continuation);
        Object obj3 = flowKt__CountKt$count$1.result;
        Object obj22 = b.d();
        i = flowKt__CountKt$count$1.label;
        if (i != 0) {
        }
        return qc.b(ref$IntRef.element);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object b(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Integer> continuation) {
        FlowKt__CountKt$count$3 flowKt__CountKt$count$3;
        int i;
        Ref$IntRef ref$IntRef;
        if (continuation instanceof FlowKt__CountKt$count$3) {
            flowKt__CountKt$count$3 = (FlowKt__CountKt$count$3) continuation;
            int i2 = flowKt__CountKt$count$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__CountKt$count$3.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__CountKt$count$3.result;
                Object obj2 = b.d();
                i = flowKt__CountKt$count$3.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                    FlowCollector<? super Object> flowKt__CountKt$count$$inlined$collect$2 = new FlowKt__CountKt$count$$inlined$collect$2(function2, ref$IntRef2);
                    flowKt__CountKt$count$3.L$0 = ref$IntRef2;
                    flowKt__CountKt$count$3.label = 1;
                    if (flow.collect(flowKt__CountKt$count$$inlined$collect$2, flowKt__CountKt$count$3) == obj2) {
                        return obj2;
                    }
                    ref$IntRef = ref$IntRef2;
                } else if (i == 1) {
                    ref$IntRef = (Ref$IntRef) flowKt__CountKt$count$3.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return qc.b(ref$IntRef.element);
            }
        }
        flowKt__CountKt$count$3 = new FlowKt__CountKt$count$3(continuation);
        Object obj3 = flowKt__CountKt$count$3.result;
        Object obj22 = b.d();
        i = flowKt__CountKt$count$3.label;
        if (i != 0) {
        }
        return qc.b(ref$IntRef.element);
    }
}
