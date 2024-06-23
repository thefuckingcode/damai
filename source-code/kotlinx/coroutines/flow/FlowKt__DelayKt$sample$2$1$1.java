package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ek1;
import tb.fh;
import tb.k12;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@"}, d2 = {"T", "Ltb/fh;", "", "result", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<fh<? extends Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    final /* synthetic */ ReceiveChannel<ur2> $ticker;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2$1$1(Ref$ObjectRef<Object> ref$ObjectRef, ReceiveChannel<ur2> receiveChannel, Continuation<? super FlowKt__DelayKt$sample$2$1$1> continuation) {
        super(2, continuation);
        this.$lastValue = ref$ObjectRef;
        this.$ticker = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, continuation);
        flowKt__DelayKt$sample$2$1$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(fh<? extends Object> fhVar, Continuation<? super ur2> continuation) {
        return m934invokeWpGqRn0(fhVar.l(), continuation);
    }

    @Nullable
    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m934invokeWpGqRn0(@NotNull Object obj, @Nullable Continuation<? super ur2> continuation) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(fh.b(obj), continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            k12.b(obj);
            T t = (T) ((fh) this.L$0).l();
            Ref$ObjectRef<Object> ref$ObjectRef = this.$lastValue;
            boolean z = t instanceof fh.c;
            if (!z) {
                ref$ObjectRef.element = t;
            }
            ReceiveChannel<ur2> receiveChannel = this.$ticker;
            if (z) {
                Throwable e = fh.e(t);
                if (e == null) {
                    receiveChannel.cancel((CancellationException) new ChildCancelledException());
                    ref$ObjectRef.element = (T) ek1.DONE;
                } else {
                    throw e;
                }
            }
            return ur2.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
