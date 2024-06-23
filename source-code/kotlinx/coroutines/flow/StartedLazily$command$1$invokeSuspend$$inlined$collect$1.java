package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.ur2;

/* compiled from: Taobao */
public final class StartedLazily$command$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Integer> {
    final /* synthetic */ Ref$BooleanRef a;
    final /* synthetic */ FlowCollector b;

    public StartedLazily$command$1$invokeSuspend$$inlined$collect$1(Ref$BooleanRef ref$BooleanRef, FlowCollector flowCollector) {
        this.a = ref$BooleanRef;
        this.b = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(Integer num, @NotNull Continuation<? super ur2> continuation) {
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
                    if (num.intValue() > 0) {
                        Ref$BooleanRef ref$BooleanRef = this.a;
                        if (!ref$BooleanRef.element) {
                            ref$BooleanRef.element = true;
                            FlowCollector flowCollector = this.b;
                            SharingCommand sharingCommand = SharingCommand.START;
                            r0.label = 1;
                            if (flowCollector.emit(sharingCommand, r0) == obj2) {
                                return obj2;
                            }
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
            /* class kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1.AnonymousClass1 */
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ StartedLazily$command$1$invokeSuspend$$inlined$collect$1 this$0;

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
