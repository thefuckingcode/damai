package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b11;
import tb.ek1;
import tb.k12;
import tb.ur2;

/* compiled from: Taobao */
public final class FlowKt__ReduceKt$reduce$$inlined$collect$1 implements FlowCollector<T> {
    final /* synthetic */ Ref$ObjectRef a;
    final /* synthetic */ Function3 b;

    public FlowKt__ReduceKt$reduce$$inlined$collect$1(Ref$ObjectRef ref$ObjectRef, Function3 function3) {
        this.a = ref$ObjectRef;
        this.b = function3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
        AnonymousClass1 r0;
        int i;
        Ref$ObjectRef ref$ObjectRef;
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
                    ref$ObjectRef = this.a;
                    T t2 = ref$ObjectRef.element;
                    if (t2 != ek1.NULL) {
                        Function3 function3 = this.b;
                        r0.L$0 = ref$ObjectRef;
                        r0.label = 1;
                        b11.c(6);
                        t = (T) function3.invoke(t2, t, r0);
                        b11.c(7);
                        if (t == obj2) {
                            return obj2;
                        }
                    }
                } else if (i == 1) {
                    k12.b(obj);
                    ref$ObjectRef = (Ref$ObjectRef) r0.L$0;
                    t = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ref$ObjectRef.element = t;
                return ur2.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1.AnonymousClass1 */
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__ReduceKt$reduce$$inlined$collect$1 this$0;

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
        ref$ObjectRef.element = t;
        return ur2.INSTANCE;
    }
}
