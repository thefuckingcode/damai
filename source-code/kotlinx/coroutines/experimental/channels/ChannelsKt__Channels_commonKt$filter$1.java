package kotlinx.coroutines.experimental.channels;

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
public final class ChannelsKt__Channels_commonKt$filter$1 extends CoroutineImpl implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $predicate;
    Object L$0;
    Object L$1;
    Object L$2;
    private ProducerScope p$;
    final /* synthetic */ ReceiveChannel receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$filter$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.receiver$0 = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((ProducerScope) obj, (Continuation<? super Unit>) continuation);
    }

    public final Continuation<Unit> create(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        ChannelsKt__Channels_commonKt$filter$1 channelsKt__Channels_commonKt$filter$1 = new ChannelsKt__Channels_commonKt$filter$1(this.receiver$0, this.$predicate, continuation);
        channelsKt__Channels_commonKt$filter$1.p$ = producerScope;
        return channelsKt__Channels_commonKt$filter$1;
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((ChannelsKt__Channels_commonKt$filter$1) create((ProducerScope) producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00aa  */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        ChannelIterator channelIterator;
        ProducerScope producerScope;
        ChannelsKt__Channels_commonKt$filter$1 channelsKt__Channels_commonKt$filter$1;
        ProducerScope producerScope2;
        ChannelsKt__Channels_commonKt$filter$1 channelsKt__Channels_commonKt$filter$12;
        ChannelIterator channelIterator2;
        Object invoke;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                channelIterator2 = (ChannelIterator) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$filter$12 = this;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i == 2) {
                channelIterator2 = (ChannelIterator) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$filter$12 = this;
                    Function2 function2 = channelsKt__Channels_commonKt$filter$12.$predicate;
                    channelsKt__Channels_commonKt$filter$12.L$0 = producerScope;
                    channelsKt__Channels_commonKt$filter$12.L$1 = obj;
                    channelsKt__Channels_commonKt$filter$12.L$2 = channelIterator2;
                    channelsKt__Channels_commonKt$filter$12.label = 3;
                    invoke = function2.invoke(obj, channelsKt__Channels_commonKt$filter$12);
                    if (invoke != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                throw th;
            } else if (i == 3) {
                ChannelIterator channelIterator3 = (ChannelIterator) this.L$2;
                Object obj2 = this.L$1;
                ProducerScope producerScope3 = (ProducerScope) this.L$0;
                if (th == null) {
                    channelIterator = channelIterator3;
                    channelsKt__Channels_commonKt$filter$1 = this;
                    Object obj3 = obj2;
                    producerScope = producerScope3;
                    if (((Boolean) obj).booleanValue()) {
                        channelsKt__Channels_commonKt$filter$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$filter$1.L$1 = obj3;
                        channelsKt__Channels_commonKt$filter$1.L$2 = channelIterator;
                        channelsKt__Channels_commonKt$filter$1.label = 4;
                        if (producerScope.send(obj3, channelsKt__Channels_commonKt$filter$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    producerScope2 = producerScope;
                    channelsKt__Channels_commonKt$filter$1.L$0 = producerScope2;
                    channelsKt__Channels_commonKt$filter$1.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$filter$1.label = 1;
                    hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$filter$1);
                    if (hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    producerScope = producerScope2;
                    obj = hasNext;
                    channelIterator2 = channelIterator;
                    channelsKt__Channels_commonKt$filter$12 = channelsKt__Channels_commonKt$filter$1;
                    if (!((Boolean) obj).booleanValue()) {
                        channelsKt__Channels_commonKt$filter$12.L$0 = producerScope;
                        channelsKt__Channels_commonKt$filter$12.L$1 = channelIterator2;
                        channelsKt__Channels_commonKt$filter$12.label = 2;
                        obj = channelIterator2.next(channelsKt__Channels_commonKt$filter$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Function2 function22 = channelsKt__Channels_commonKt$filter$12.$predicate;
                        channelsKt__Channels_commonKt$filter$12.L$0 = producerScope;
                        channelsKt__Channels_commonKt$filter$12.L$1 = obj;
                        channelsKt__Channels_commonKt$filter$12.L$2 = channelIterator2;
                        channelsKt__Channels_commonKt$filter$12.label = 3;
                        invoke = function22.invoke(obj, channelsKt__Channels_commonKt$filter$12);
                        if (invoke != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj3 = obj;
                        obj = invoke;
                        channelsKt__Channels_commonKt$filter$1 = channelsKt__Channels_commonKt$filter$12;
                        channelIterator = channelIterator2;
                        if (((Boolean) obj).booleanValue()) {
                        }
                        producerScope2 = producerScope;
                        channelsKt__Channels_commonKt$filter$1.L$0 = producerScope2;
                        channelsKt__Channels_commonKt$filter$1.L$1 = channelIterator;
                        channelsKt__Channels_commonKt$filter$1.label = 1;
                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$filter$1);
                        if (hasNext == coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                    return coroutine_suspended;
                }
                throw th;
            } else if (i == 4) {
                ChannelIterator channelIterator4 = (ChannelIterator) this.L$2;
                ProducerScope producerScope4 = (ProducerScope) this.L$0;
                if (th == null) {
                    channelIterator = channelIterator4;
                    producerScope2 = producerScope4;
                } else {
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            producerScope2 = this.p$;
            channelIterator = this.receiver$0.iterator();
        } else {
            throw th;
        }
        channelsKt__Channels_commonKt$filter$1 = this;
        channelsKt__Channels_commonKt$filter$1.L$0 = producerScope2;
        channelsKt__Channels_commonKt$filter$1.L$1 = channelIterator;
        channelsKt__Channels_commonKt$filter$1.label = 1;
        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$filter$1);
        if (hasNext == coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
