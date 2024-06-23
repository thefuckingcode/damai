package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.ur2;

/* compiled from: Taobao */
public final class FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 implements FlowCollector<T> {
    final /* synthetic */ FlowCollector a;
    final /* synthetic */ Ref$ObjectRef b;

    public FlowKt__ErrorsKt$catchImpl$$inlined$collect$1(FlowCollector flowCollector, Ref$ObjectRef ref$ObjectRef) {
        this.a = flowCollector;
        this.b = ref$ObjectRef;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
        AnonymousClass1 r0;
        int i;
        T th;
        FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 flowKt__ErrorsKt$catchImpl$$inlined$collect$1;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            int i2 = r0.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                r0.label = i2 - Integer.MIN_VALUE;
                Object obj = r0.result;
                Object obj2 = b.d();
                i = r0.label;
                if (i != 0) {
                    k12.b(obj);
                    try {
                        FlowCollector flowCollector = this.a;
                        r0.L$0 = this;
                        r0.label = 1;
                        if (flowCollector.emit(t, r0) == obj2) {
                            return obj2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        flowKt__ErrorsKt$catchImpl$$inlined$collect$1 = this;
                        flowKt__ErrorsKt$catchImpl$$inlined$collect$1.b.element = th;
                        throw th;
                    }
                } else if (i == 1) {
                    flowKt__ErrorsKt$catchImpl$$inlined$collect$1 = (FlowKt__ErrorsKt$catchImpl$$inlined$collect$1) r0.L$0;
                    try {
                        k12.b(obj);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ur2.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1.AnonymousClass1 */
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 this$0;

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
        Object obj3 = r0.result;
        Object obj22 = b.d();
        i = r0.label;
        if (i != 0) {
        }
        return ur2.INSTANCE;
    }
}
