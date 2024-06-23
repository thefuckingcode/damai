package kotlinx.coroutines.flow.internal;

import com.youku.live.dago.module.DagoPlayerInteract;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ek1;
import tb.k12;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/channels/ProducerScope;", "", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", f = "Combine.kt", i = {}, l = {DagoPlayerInteract.UNIT_ANCHOR_INFO_WIDTH}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
final class CombineKt$zipImpl$1$1$second$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Flow<Object> $flow2;
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
            SendChannel channel = this.a.getChannel();
            if (obj == null) {
                obj = ek1.NULL;
            }
            Object send = channel.send(obj, continuation);
            return send == b.d() ? send : ur2.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$1$1$second$1(Flow<Object> flow, Continuation<? super CombineKt$zipImpl$1$1$second$1> continuation) {
        super(2, continuation);
        this.$flow2 = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$zipImpl$1$1$second$1 combineKt$zipImpl$1$1$second$1 = new CombineKt$zipImpl$1$1$second$1(this.$flow2, continuation);
        combineKt$zipImpl$1$1$second$1.L$0 = obj;
        return combineKt$zipImpl$1$1$second$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Object> producerScope, Continuation<? super ur2> continuation) {
        return invoke((ProducerScope<Object>) producerScope, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((CombineKt$zipImpl$1$1$second$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            Flow<Object> flow = this.$flow2;
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
