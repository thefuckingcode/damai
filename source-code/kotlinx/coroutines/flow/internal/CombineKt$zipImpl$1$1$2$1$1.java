package kotlinx.coroutines.flow.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ek1;
import tb.fh;
import tb.k12;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@"}, d2 = {"T1", "T2", "R", "Ltb/ur2;", AdvanceSetting.NETWORK_TYPE, "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {132, 135, 135}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
final class CombineKt$zipImpl$1$1$2$1$1 extends SuspendLambda implements Function2<ur2, Continuation<? super ur2>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $second;
    final /* synthetic */ FlowCollector<Object> $this_unsafeFlow;
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
    final /* synthetic */ Object $value;
    Object L$0;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function3<java.lang.Object, java.lang.Object, ? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$1$1$2$1$1(ReceiveChannel<? extends Object> receiveChannel, FlowCollector<Object> flowCollector, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> function3, Object obj, Continuation<? super CombineKt$zipImpl$1$1$2$1$1> continuation) {
        super(2, continuation);
        this.$second = receiveChannel;
        this.$this_unsafeFlow = flowCollector;
        this.$transform = function3;
        this.$value = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CombineKt$zipImpl$1$1$2$1$1(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull ur2 ur2, @Nullable Continuation<? super ur2> continuation) {
        return ((CombineKt$zipImpl$1$1$2$1$1) create(ur2, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector<Object> flowCollector;
        Object obj2;
        Object obj3 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            ReceiveChannel<Object> receiveChannel = this.$second;
            this.label = 1;
            obj2 = receiveChannel.m928receiveCatchingJP2dKIU(this);
            if (obj2 == obj3) {
                return obj3;
            }
        } else if (i == 1) {
            k12.b(obj);
            obj2 = ((fh) obj).l();
        } else if (i == 2) {
            flowCollector = (FlowCollector) this.L$0;
            k12.b(obj);
            this.L$0 = null;
            this.label = 3;
            if (flowCollector.emit(obj, this) == obj3) {
                return obj3;
            }
            return ur2.INSTANCE;
        } else if (i == 3) {
            k12.b(obj);
            return ur2.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        flowCollector = this.$this_unsafeFlow;
        if (obj2 instanceof fh.c) {
            Throwable e = fh.e(obj2);
            if (e == null) {
                throw new AbortFlowException(flowCollector);
            }
            throw e;
        }
        Function3<Object, Object, Continuation<Object>, Object> function3 = this.$transform;
        Object obj4 = this.$value;
        if (obj2 == ek1.NULL) {
            obj2 = null;
        }
        this.L$0 = flowCollector;
        this.label = 2;
        obj = function3.invoke(obj4, obj2, this);
        if (obj == obj3) {
            return obj3;
        }
        this.L$0 = null;
        this.label = 3;
        if (flowCollector.emit(obj, this) == obj3) {
        }
        return ur2.INSTANCE;
    }
}
