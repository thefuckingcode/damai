package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "invoke", "(Lkotlinx/coroutines/experimental/channels/ProducerScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
/* compiled from: Broadcast.kt */
final class BroadcastKt$broadcast$1 extends CoroutineImpl implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    private ProducerScope p$;
    final /* synthetic */ ReceiveChannel receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BroadcastKt$broadcast$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.receiver$0 = receiveChannel;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((ProducerScope) obj, (Continuation<? super Unit>) continuation);
    }

    public final Continuation<Unit> create(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        BroadcastKt$broadcast$1 broadcastKt$broadcast$1 = new BroadcastKt$broadcast$1(this.receiver$0, continuation);
        broadcastKt$broadcast$1.p$ = producerScope;
        return broadcastKt$broadcast$1;
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((BroadcastKt$broadcast$1) create((ProducerScope) producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0082  */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        BroadcastKt$broadcast$1 broadcastKt$broadcast$1;
        ProducerScope producerScope;
        ChannelIterator channelIterator;
        BroadcastKt$broadcast$1 broadcastKt$broadcast$12;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                channelIterator = (ChannelIterator) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    broadcastKt$broadcast$1 = this;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i == 2) {
                channelIterator = (ChannelIterator) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    broadcastKt$broadcast$1 = this;
                    broadcastKt$broadcast$1.L$0 = producerScope;
                    broadcastKt$broadcast$1.L$1 = obj;
                    broadcastKt$broadcast$1.L$2 = channelIterator;
                    broadcastKt$broadcast$1.label = 3;
                    if (producerScope.send(obj, broadcastKt$broadcast$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    broadcastKt$broadcast$12 = broadcastKt$broadcast$1;
                    broadcastKt$broadcast$12.L$0 = producerScope;
                    broadcastKt$broadcast$12.L$1 = channelIterator;
                    broadcastKt$broadcast$12.label = 1;
                    hasNext = channelIterator.hasNext(broadcastKt$broadcast$12);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    broadcastKt$broadcast$1 = broadcastKt$broadcast$12;
                    obj = hasNext;
                    if (!((Boolean) obj).booleanValue()) {
                        broadcastKt$broadcast$1.L$0 = producerScope;
                        broadcastKt$broadcast$1.L$1 = channelIterator;
                        broadcastKt$broadcast$1.label = 2;
                        obj = channelIterator.next(broadcastKt$broadcast$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        broadcastKt$broadcast$1.L$0 = producerScope;
                        broadcastKt$broadcast$1.L$1 = obj;
                        broadcastKt$broadcast$1.L$2 = channelIterator;
                        broadcastKt$broadcast$1.label = 3;
                        if (producerScope.send(obj, broadcastKt$broadcast$1) != coroutine_suspended) {
                        }
                    }
                    return Unit.INSTANCE;
                    return coroutine_suspended;
                    return coroutine_suspended;
                }
                throw th;
            } else if (i == 3) {
                ChannelIterator channelIterator2 = (ChannelIterator) this.L$2;
                ProducerScope producerScope2 = (ProducerScope) this.L$0;
                if (th == null) {
                    producerScope = producerScope2;
                    channelIterator = channelIterator2;
                } else {
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            producerScope = this.p$;
            channelIterator = this.receiver$0.iterator();
        } else {
            throw th;
        }
        broadcastKt$broadcast$12 = this;
        broadcastKt$broadcast$12.L$0 = producerScope;
        broadcastKt$broadcast$12.L$1 = channelIterator;
        broadcastKt$broadcast$12.label = 1;
        hasNext = channelIterator.hasNext(broadcastKt$broadcast$12);
        if (hasNext != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
