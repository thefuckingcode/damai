package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b11;
import tb.k12;
import tb.ur2;

/* compiled from: Taobao */
public final class FlowKt__CountKt$count$$inlined$collect$2 implements FlowCollector<T> {
    final /* synthetic */ Function2 a;
    final /* synthetic */ Ref$IntRef b;

    public FlowKt__CountKt$count$$inlined$collect$2(Function2 function2, Ref$IntRef ref$IntRef) {
        this.a = function2;
        this.b = ref$IntRef;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
        AnonymousClass1 r0;
        Object obj;
        int i;
        FlowKt__CountKt$count$$inlined$collect$2 flowKt__CountKt$count$$inlined$collect$2;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            int i2 = r0.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                r0.label = i2 - Integer.MIN_VALUE;
                obj = r0.result;
                Object obj2 = b.d();
                i = r0.label;
                if (i != 0) {
                    k12.b(obj);
                    Function2 function2 = this.a;
                    r0.L$0 = this;
                    r0.label = 1;
                    b11.c(6);
                    obj = function2.invoke(t, r0);
                    b11.c(7);
                    if (obj == obj2) {
                        return obj2;
                    }
                    flowKt__CountKt$count$$inlined$collect$2 = this;
                } else if (i == 1) {
                    flowKt__CountKt$count$$inlined$collect$2 = (FlowKt__CountKt$count$$inlined$collect$2) r0.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) obj).booleanValue()) {
                    flowKt__CountKt$count$$inlined$collect$2.b.element++;
                }
                return ur2.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2.AnonymousClass1 */
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__CountKt$count$$inlined$collect$2 this$0;

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
        obj = r0.result;
        Object obj22 = b.d();
        i = r0.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
        return ur2.INSTANCE;
    }
}
