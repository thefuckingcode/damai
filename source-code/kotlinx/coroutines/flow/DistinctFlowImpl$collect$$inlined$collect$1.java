package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ek1;
import tb.k12;
import tb.ur2;

/* compiled from: Taobao */
public final class DistinctFlowImpl$collect$$inlined$collect$1 implements FlowCollector<T> {
    final /* synthetic */ DistinctFlowImpl a;
    final /* synthetic */ Ref$ObjectRef b;
    final /* synthetic */ FlowCollector c;

    public DistinctFlowImpl$collect$$inlined$collect$1(DistinctFlowImpl distinctFlowImpl, Ref$ObjectRef ref$ObjectRef, FlowCollector flowCollector) {
        this.a = distinctFlowImpl;
        this.b = ref$ObjectRef;
        this.c = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
        AnonymousClass1 r0;
        int i;
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
                    T t2 = (T) this.a.b.invoke(t);
                    T t3 = this.b.element;
                    if (t3 == ek1.NULL || !this.a.c.invoke(t3, t2).booleanValue()) {
                        this.b.element = t2;
                        FlowCollector flowCollector = this.c;
                        r0.label = 1;
                        if (flowCollector.emit(t, r0) == obj2) {
                            return obj2;
                        }
                    }
                } else if (i == 1) {
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ur2.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1.AnonymousClass1 */
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ DistinctFlowImpl$collect$$inlined$collect$1 this$0;

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
