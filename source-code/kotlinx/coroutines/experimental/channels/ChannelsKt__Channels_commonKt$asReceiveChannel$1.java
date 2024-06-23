package kotlinx.coroutines.experimental.channels;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "invoke", "(Lkotlinx/coroutines/experimental/channels/ProducerScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
/* compiled from: Channels.common.kt */
public final class ChannelsKt__Channels_commonKt$asReceiveChannel$1 extends CoroutineImpl implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    private ProducerScope p$;
    final /* synthetic */ Iterable receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$asReceiveChannel$1(Iterable iterable, Continuation continuation) {
        super(2, continuation);
        this.receiver$0 = iterable;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((ProducerScope) obj, (Continuation<? super Unit>) continuation);
    }

    public final Continuation<Unit> create(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        ChannelsKt__Channels_commonKt$asReceiveChannel$1 channelsKt__Channels_commonKt$asReceiveChannel$1 = new ChannelsKt__Channels_commonKt$asReceiveChannel$1(this.receiver$0, continuation);
        channelsKt__Channels_commonKt$asReceiveChannel$1.p$ = producerScope;
        return channelsKt__Channels_commonKt$asReceiveChannel$1;
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((ChannelsKt__Channels_commonKt$asReceiveChannel$1) create((ProducerScope) producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        ProducerScope producerScope;
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                it = (Iterator) this.L$2;
                producerScope = (ProducerScope) this.L$0;
                if (th != null) {
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            ProducerScope producerScope2 = this.p$;
            it = this.receiver$0.iterator();
            producerScope = producerScope2;
        } else {
            throw th;
        }
        while (it.hasNext()) {
            Object next = it.next();
            this.L$0 = producerScope;
            this.L$1 = next;
            this.L$2 = it;
            this.label = 1;
            if (producerScope.send(next, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
