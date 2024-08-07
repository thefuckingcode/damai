package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.o82;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
final class ChannelLimitedFlowMerge$collectTo$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ur2>, Object> {
    final /* synthetic */ o82<Object> $collector;
    final /* synthetic */ Flow<Object> $flow;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelLimitedFlowMerge$collectTo$2$1(Flow<Object> flow, o82<Object> o82, Continuation<? super ChannelLimitedFlowMerge$collectTo$2$1> continuation) {
        super(2, continuation);
        this.$flow = flow;
        this.$collector = o82;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChannelLimitedFlowMerge$collectTo$2$1(this.$flow, this.$collector, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelLimitedFlowMerge$collectTo$2$1) create(coroutineScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            Flow<Object> flow = this.$flow;
            o82<Object> o82 = this.$collector;
            this.label = 1;
            if (flow.collect(o82, this) == obj2) {
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
