package kotlinx.coroutines.flow;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ek1;
import tb.k12;
import tb.p30;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/FlowCollector;", "downstream", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {355}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", RemoteMessageConst.Notification.TICKER}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: Taobao */
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ Flow<Object> $this_sample;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2(long j, Flow<Object> flow, Continuation<? super FlowKt__DelayKt$sample$2> continuation) {
        super(3, continuation);
        this.$periodMillis = j;
        this.$this_sample = flow;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<Object> flowCollector, @Nullable Continuation<? super ur2> continuation) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, continuation);
        flowKt__DelayKt$sample$2.L$0 = coroutineScope;
        flowKt__DelayKt$sample$2.L$1 = flowCollector;
        return flowKt__DelayKt$sample$2.invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        ReceiveChannel receiveChannel;
        Ref$ObjectRef ref$ObjectRef;
        ReceiveChannel receiveChannel2;
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ReceiveChannel e = ProduceKt.e(coroutineScope, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ReceiveChannel receiveChannel3 = FlowKt__DelayKt.b(coroutineScope, this.$periodMillis, 0, 2, null);
            flowCollector = (FlowCollector) this.L$1;
            receiveChannel = e;
            ref$ObjectRef = ref$ObjectRef2;
            receiveChannel2 = receiveChannel3;
        } else if (i == 1) {
            receiveChannel2 = (ReceiveChannel) this.L$3;
            ref$ObjectRef = (Ref$ObjectRef) this.L$2;
            receiveChannel = (ReceiveChannel) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            k12.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (ref$ObjectRef.element != ek1.DONE) {
            this.L$0 = flowCollector;
            this.L$1 = receiveChannel;
            this.L$2 = ref$ObjectRef;
            this.L$3 = receiveChannel2;
            this.label = 1;
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(this);
            try {
                selectBuilderImpl.invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$sample$2$1$1(ref$ObjectRef, receiveChannel2, null));
                selectBuilderImpl.invoke(receiveChannel2.getOnReceive(), new FlowKt__DelayKt$sample$2$1$2(ref$ObjectRef, flowCollector, null));
            } catch (Throwable th) {
                selectBuilderImpl.z(th);
            }
            Object y = selectBuilderImpl.y();
            if (y == b.d()) {
                p30.c(this);
                continue;
            }
            if (y == obj2) {
                return obj2;
            }
        }
        return ur2.INSTANCE;
    }
}
