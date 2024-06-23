package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b11;
import tb.k12;
import tb.ur2;

/* compiled from: Taobao */
public final class FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 implements FlowCollector<Object> {
    final /* synthetic */ Function3 a;
    final /* synthetic */ FlowCollector b;

    public FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1(Function3 function3, FlowCollector flowCollector) {
        this.a = function3;
        this.b = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(Object obj, @NotNull Continuation<? super ur2> continuation) {
        AnonymousClass1 r0;
        Object obj2;
        int i;
        FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            int i2 = r0.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                r0.label = i2 - Integer.MIN_VALUE;
                obj2 = r0.result;
                Object obj3 = b.d();
                i = r0.label;
                if (i != 0) {
                    k12.b(obj2);
                    Function3 function3 = this.a;
                    FlowCollector flowCollector = this.b;
                    r0.L$0 = this;
                    r0.label = 1;
                    b11.c(6);
                    obj2 = function3.invoke(flowCollector, obj, r0);
                    b11.c(7);
                    if (obj2 == obj3) {
                        return obj3;
                    }
                    flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = this;
                } else if (i == 1) {
                    flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = (FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) r0.L$0;
                    k12.b(obj2);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj2).booleanValue()) {
                    return ur2.INSTANCE;
                }
                throw new AbortFlowException(flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1.AnonymousClass1 */
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        };
        obj2 = r0.result;
        Object obj32 = b.d();
        i = r0.label;
        if (i != 0) {
        }
        if (!((Boolean) obj2).booleanValue()) {
        }
    }
}
