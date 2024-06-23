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
public final class ChannelsKt__Channels_commonKt$take$1 extends CoroutineImpl implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    private ProducerScope p$;
    final /* synthetic */ ReceiveChannel receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$take$1(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        super(2, continuation);
        this.receiver$0 = receiveChannel;
        this.$n = i;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((ProducerScope) obj, (Continuation<? super Unit>) continuation);
    }

    public final Continuation<Unit> create(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        ChannelsKt__Channels_commonKt$take$1 channelsKt__Channels_commonKt$take$1 = new ChannelsKt__Channels_commonKt$take$1(this.receiver$0, this.$n, continuation);
        channelsKt__Channels_commonKt$take$1.p$ = producerScope;
        return channelsKt__Channels_commonKt$take$1;
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((ChannelsKt__Channels_commonKt$take$1) create((ProducerScope) producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        ChannelIterator channelIterator;
        ChannelsKt__Channels_commonKt$take$1 channelsKt__Channels_commonKt$take$1;
        ProducerScope producerScope;
        int i;
        int i2;
        ChannelIterator channelIterator2;
        ChannelsKt__Channels_commonKt$take$1 channelsKt__Channels_commonKt$take$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                channelIterator2 = (ChannelIterator) this.L$1;
                i2 = this.I$0;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$take$12 = this;
                    if (!((Boolean) obj).booleanValue()) {
                        channelsKt__Channels_commonKt$take$12.L$0 = producerScope;
                        channelsKt__Channels_commonKt$take$12.I$0 = i2;
                        channelsKt__Channels_commonKt$take$12.L$1 = channelIterator2;
                        channelsKt__Channels_commonKt$take$12.label = 2;
                        obj = channelIterator2.next(channelsKt__Channels_commonKt$take$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelsKt__Channels_commonKt$take$12.L$0 = producerScope;
                        channelsKt__Channels_commonKt$take$12.I$0 = i2;
                        channelsKt__Channels_commonKt$take$12.L$1 = obj;
                        channelsKt__Channels_commonKt$take$12.L$2 = channelIterator2;
                        channelsKt__Channels_commonKt$take$12.label = 3;
                        if (producerScope.send(obj, channelsKt__Channels_commonKt$take$12) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i3 == 2) {
                channelIterator2 = (ChannelIterator) this.L$1;
                i2 = this.I$0;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$take$12 = this;
                    channelsKt__Channels_commonKt$take$12.L$0 = producerScope;
                    channelsKt__Channels_commonKt$take$12.I$0 = i2;
                    channelsKt__Channels_commonKt$take$12.L$1 = obj;
                    channelsKt__Channels_commonKt$take$12.L$2 = channelIterator2;
                    channelsKt__Channels_commonKt$take$12.label = 3;
                    if (producerScope.send(obj, channelsKt__Channels_commonKt$take$12) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    channelsKt__Channels_commonKt$take$1 = channelsKt__Channels_commonKt$take$12;
                    channelIterator = channelIterator2;
                    i = i2;
                    i2 = i - 1;
                    if (i2 == 0) {
                    }
                    return Unit.INSTANCE;
                    return coroutine_suspended;
                }
                throw th;
            } else if (i3 == 3) {
                ChannelIterator channelIterator3 = (ChannelIterator) this.L$2;
                i = this.I$0;
                ProducerScope producerScope2 = (ProducerScope) this.L$0;
                if (th == null) {
                    channelIterator = channelIterator3;
                    producerScope = producerScope2;
                    channelsKt__Channels_commonKt$take$1 = this;
                    i2 = i - 1;
                    if (i2 == 0) {
                        channelIterator2 = channelIterator;
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            ProducerScope producerScope3 = this.p$;
            int i4 = this.$n;
            if (i4 == 0) {
                return Unit.INSTANCE;
            }
            if (i4 >= 0) {
                channelIterator2 = this.receiver$0.iterator();
                producerScope = producerScope3;
                i2 = i4;
                channelsKt__Channels_commonKt$take$1 = this;
            } else {
                throw new IllegalArgumentException(("Requested element count " + this.$n + " is less than zero.").toString());
            }
        } else {
            throw th;
        }
        channelsKt__Channels_commonKt$take$1.L$0 = producerScope;
        channelsKt__Channels_commonKt$take$1.I$0 = i2;
        channelsKt__Channels_commonKt$take$1.L$1 = channelIterator2;
        channelsKt__Channels_commonKt$take$1.label = 1;
        Object hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$take$1);
        if (hasNext == coroutine_suspended) {
            return coroutine_suspended;
        }
        channelsKt__Channels_commonKt$take$12 = channelsKt__Channels_commonKt$take$1;
        obj = hasNext;
        if (!((Boolean) obj).booleanValue()) {
        }
        return Unit.INSTANCE;
        return coroutine_suspended;
    }
}
