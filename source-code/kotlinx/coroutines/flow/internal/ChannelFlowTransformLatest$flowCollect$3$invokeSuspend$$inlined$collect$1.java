package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.f;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.ur2;

/* compiled from: Taobao */
public final class ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 implements FlowCollector<T> {
    final /* synthetic */ Ref$ObjectRef a;
    final /* synthetic */ CoroutineScope b;
    final /* synthetic */ ChannelFlowTransformLatest c;
    final /* synthetic */ FlowCollector d;

    public ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1(Ref$ObjectRef ref$ObjectRef, CoroutineScope coroutineScope, ChannelFlowTransformLatest channelFlowTransformLatest, FlowCollector flowCollector) {
        this.a = ref$ObjectRef;
        this.b = coroutineScope;
        this.c = channelFlowTransformLatest;
        this.d = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
        AnonymousClass1 r0;
        int i;
        ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1;
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
                    T t2 = this.a.element;
                    if (t2 != null) {
                        t2.cancel(new ChildCancelledException());
                        r0.L$0 = this;
                        r0.L$1 = t;
                        r0.L$2 = t2;
                        r0.label = 1;
                        if (t2.join(r0) == obj2) {
                            return obj2;
                        }
                    }
                    channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 = this;
                } else if (i == 1) {
                    Job job = (Job) r0.L$2;
                    t = (T) r0.L$1;
                    channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 = (ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1) r0.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.a.element = (T) f.b(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.b, null, CoroutineStart.UNDISPATCHED, new ChannelFlowTransformLatest$flowCollect$3$1$2(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.c, channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.d, t, null), 1, null);
                return ur2.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.AnonymousClass1 */
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 this$0;

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
        channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.a.element = (T) f.b(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.b, null, CoroutineStart.UNDISPATCHED, new ChannelFlowTransformLatest$flowCollect$3$1$2(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.c, channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.d, t, null), 1, null);
        return ur2.INSTANCE;
    }
}
