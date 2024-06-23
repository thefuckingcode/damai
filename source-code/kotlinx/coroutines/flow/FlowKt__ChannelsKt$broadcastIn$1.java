package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/channels/ProducerScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt$broadcastIn$1", f = "Channels.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
final class FlowKt__ChannelsKt$broadcastIn$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Flow<Object> $this_broadcastIn;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Taobao */
    public static final class a implements FlowCollector<Object> {
        final /* synthetic */ ProducerScope a;

        public a(ProducerScope producerScope) {
            this.a = producerScope;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Object obj, @NotNull Continuation<? super ur2> continuation) {
            Object send = this.a.send(obj, continuation);
            if (send == b.d()) {
                return send;
            }
            return ur2.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__ChannelsKt$broadcastIn$1(Flow<Object> flow, Continuation<? super FlowKt__ChannelsKt$broadcastIn$1> continuation) {
        super(2, continuation);
        this.$this_broadcastIn = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ChannelsKt$broadcastIn$1 flowKt__ChannelsKt$broadcastIn$1 = new FlowKt__ChannelsKt$broadcastIn$1(this.$this_broadcastIn, continuation);
        flowKt__ChannelsKt$broadcastIn$1.L$0 = obj;
        return flowKt__ChannelsKt$broadcastIn$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((FlowKt__ChannelsKt$broadcastIn$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            Flow<Object> flow = this.$this_broadcastIn;
            a aVar = new a((ProducerScope) this.L$0);
            this.label = 1;
            if (flow.collect(aVar, this) == obj2) {
                return obj2;
            }
        } else if (i == 1) {
            k12.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ur2.INSTANCE;
    }
}
