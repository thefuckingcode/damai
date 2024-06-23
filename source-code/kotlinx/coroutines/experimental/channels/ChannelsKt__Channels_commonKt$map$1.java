package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "invoke", "(Lkotlinx/coroutines/experimental/channels/ProducerScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
/* compiled from: Channels.common.kt */
public final class ChannelsKt__Channels_commonKt$map$1 extends CoroutineImpl implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    private ProducerScope p$;
    final /* synthetic */ ReceiveChannel receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$map$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.receiver$0 = receiveChannel;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((ProducerScope) obj, (Continuation<? super Unit>) continuation);
    }

    public final Continuation<Unit> create(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        ChannelsKt__Channels_commonKt$map$1 channelsKt__Channels_commonKt$map$1 = new ChannelsKt__Channels_commonKt$map$1(this.receiver$0, this.$transform, continuation);
        channelsKt__Channels_commonKt$map$1.p$ = producerScope;
        return channelsKt__Channels_commonKt$map$1;
    }

    public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((ChannelsKt__Channels_commonKt$map$1) create((ProducerScope) producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00eb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014b  */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        ReceiveChannel receiveChannel;
        Throwable th2;
        Throwable th3;
        ChannelsKt__Channels_commonKt$map$1 channelsKt__Channels_commonKt$map$1;
        ProducerScope producerScope;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator;
        Throwable th4;
        ReceiveChannel receiveChannel4;
        ProducerScope producerScope2;
        Object obj2;
        Object obj3;
        ReceiveChannel receiveChannel5;
        ReceiveChannel receiveChannel6;
        Object obj4;
        Throwable th5;
        ReceiveChannel receiveChannel7;
        ChannelIterator channelIterator2;
        ChannelsKt__Channels_commonKt$map$1 channelsKt__Channels_commonKt$map$12;
        ProducerScope producerScope3;
        Object obj5;
        ReceiveChannel receiveChannel8;
        ReceiveChannel receiveChannel9;
        Throwable th6;
        ReceiveChannel receiveChannel10;
        ChannelIterator channelIterator3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 3;
        if (i != 0) {
            if (i == 1) {
                channelIterator3 = (ChannelIterator) this.L$5;
                receiveChannel10 = (ReceiveChannel) this.L$4;
                th6 = (Throwable) this.L$3;
                receiveChannel9 = (ReceiveChannel) this.L$2;
                receiveChannel8 = (ReceiveChannel) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    obj5 = obj;
                    channelsKt__Channels_commonKt$map$1 = this;
                    if (!((Boolean) obj5).booleanValue()) {
                        Unit unit = Unit.INSTANCE;
                        receiveChannel9.cancel(th6);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    receiveChannel9.cancel(th6);
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i == 2) {
                channelIterator3 = (ChannelIterator) this.L$5;
                receiveChannel10 = (ReceiveChannel) this.L$4;
                th6 = (Throwable) this.L$3;
                receiveChannel9 = (ReceiveChannel) this.L$2;
                receiveChannel8 = (ReceiveChannel) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    obj3 = obj;
                    channelsKt__Channels_commonKt$map$1 = this;
                } else {
                    throw th;
                }
            } else if (i == 3) {
                producerScope3 = (ProducerScope) this.L$8;
                Object obj6 = this.L$7;
                Object obj7 = this.L$6;
                ChannelIterator channelIterator4 = (ChannelIterator) this.L$5;
                ReceiveChannel receiveChannel11 = (ReceiveChannel) this.L$4;
                Throwable th7 = (Throwable) this.L$3;
                receiveChannel5 = (ReceiveChannel) this.L$2;
                ReceiveChannel receiveChannel12 = (ReceiveChannel) this.L$1;
                ProducerScope producerScope4 = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$map$12 = this;
                    producerScope2 = producerScope4;
                    obj2 = obj;
                    obj3 = obj6;
                    channelIterator2 = channelIterator4;
                    th5 = th7;
                    receiveChannel6 = receiveChannel12;
                    obj4 = obj7;
                    receiveChannel7 = receiveChannel11;
                    channelsKt__Channels_commonKt$map$12.L$0 = producerScope2;
                    channelsKt__Channels_commonKt$map$12.L$1 = receiveChannel6;
                    channelsKt__Channels_commonKt$map$12.L$2 = receiveChannel5;
                    channelsKt__Channels_commonKt$map$12.L$3 = th5;
                    channelsKt__Channels_commonKt$map$12.L$4 = receiveChannel7;
                    channelsKt__Channels_commonKt$map$12.L$5 = channelIterator2;
                    channelsKt__Channels_commonKt$map$12.L$6 = obj4;
                    channelsKt__Channels_commonKt$map$12.L$7 = obj3;
                    channelsKt__Channels_commonKt$map$12.label = 4;
                    if (producerScope3.send(obj2, channelsKt__Channels_commonKt$map$12) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    receiveChannel2 = receiveChannel7;
                    receiveChannel4 = receiveChannel5;
                    channelsKt__Channels_commonKt$map$1 = channelsKt__Channels_commonKt$map$12;
                    channelIterator = channelIterator2;
                    th4 = th5;
                    receiveChannel3 = receiveChannel6;
                    producerScope = producerScope2;
                    i2 = 3;
                    channelsKt__Channels_commonKt$map$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$map$1.L$1 = receiveChannel3;
                    channelsKt__Channels_commonKt$map$1.L$2 = receiveChannel4;
                    channelsKt__Channels_commonKt$map$1.L$3 = th4;
                    channelsKt__Channels_commonKt$map$1.L$4 = receiveChannel2;
                    channelsKt__Channels_commonKt$map$1.L$5 = channelIterator;
                    channelsKt__Channels_commonKt$map$1.label = 1;
                    obj5 = channelIterator.hasNext(channelsKt__Channels_commonKt$map$1);
                    if (obj5 == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                    return coroutine_suspended;
                }
                try {
                    throw th;
                } catch (Throwable th8) {
                    th2 = th8;
                    receiveChannel = receiveChannel5;
                }
            } else if (i == 4) {
                ChannelIterator channelIterator5 = (ChannelIterator) this.L$5;
                ReceiveChannel receiveChannel13 = (ReceiveChannel) this.L$4;
                Throwable th9 = (Throwable) this.L$3;
                receiveChannel = (ReceiveChannel) this.L$2;
                ReceiveChannel receiveChannel14 = (ReceiveChannel) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$map$1 = this;
                    channelIterator = channelIterator5;
                    receiveChannel4 = receiveChannel;
                    receiveChannel3 = receiveChannel14;
                    receiveChannel2 = receiveChannel13;
                    th4 = th9;
                    i2 = 3;
                    try {
                        channelsKt__Channels_commonKt$map$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$map$1.L$1 = receiveChannel3;
                        channelsKt__Channels_commonKt$map$1.L$2 = receiveChannel4;
                        channelsKt__Channels_commonKt$map$1.L$3 = th4;
                        channelsKt__Channels_commonKt$map$1.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$map$1.L$5 = channelIterator;
                        channelsKt__Channels_commonKt$map$1.label = 1;
                        obj5 = channelIterator.hasNext(channelsKt__Channels_commonKt$map$1);
                        if (obj5 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel9 = receiveChannel4;
                        channelIterator3 = channelIterator;
                        th6 = th4;
                        receiveChannel10 = receiveChannel2;
                        receiveChannel8 = receiveChannel3;
                        if (!((Boolean) obj5).booleanValue()) {
                            channelsKt__Channels_commonKt$map$1.L$0 = producerScope;
                            channelsKt__Channels_commonKt$map$1.L$1 = receiveChannel8;
                            channelsKt__Channels_commonKt$map$1.L$2 = receiveChannel9;
                            channelsKt__Channels_commonKt$map$1.L$3 = th6;
                            channelsKt__Channels_commonKt$map$1.L$4 = receiveChannel10;
                            channelsKt__Channels_commonKt$map$1.L$5 = channelIterator3;
                            channelsKt__Channels_commonKt$map$1.label = 2;
                            obj3 = channelIterator3.next(channelsKt__Channels_commonKt$map$1);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        Unit unit22 = Unit.INSTANCE;
                        receiveChannel9.cancel(th6);
                        return Unit.INSTANCE;
                        return coroutine_suspended;
                    } catch (Throwable th10) {
                        th3 = th10;
                        receiveChannel = receiveChannel4;
                        th2 = th3;
                        try {
                            throw th2;
                        } catch (Throwable th11) {
                            receiveChannel.cancel(th2);
                            throw th11;
                        }
                    }
                } else {
                    try {
                        throw th;
                    } catch (Throwable th12) {
                        th3 = th12;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            ProducerScope producerScope5 = this.p$;
            receiveChannel3 = this.receiver$0;
            th4 = null;
            channelIterator = receiveChannel3.iterator();
            channelsKt__Channels_commonKt$map$1 = this;
            producerScope = producerScope5;
            receiveChannel4 = receiveChannel3;
            receiveChannel2 = receiveChannel4;
            channelsKt__Channels_commonKt$map$1.L$0 = producerScope;
            channelsKt__Channels_commonKt$map$1.L$1 = receiveChannel3;
            channelsKt__Channels_commonKt$map$1.L$2 = receiveChannel4;
            channelsKt__Channels_commonKt$map$1.L$3 = th4;
            channelsKt__Channels_commonKt$map$1.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$map$1.L$5 = channelIterator;
            channelsKt__Channels_commonKt$map$1.label = 1;
            obj5 = channelIterator.hasNext(channelsKt__Channels_commonKt$map$1);
            if (obj5 == coroutine_suspended) {
            }
            return coroutine_suspended;
        } else {
            throw th;
        }
        channelIterator2 = channelIterator3;
        producerScope3 = producerScope;
        receiveChannel6 = receiveChannel8;
        th5 = th6;
        receiveChannel7 = receiveChannel10;
        try {
            Function2 function2 = channelsKt__Channels_commonKt$map$1.$transform;
            channelsKt__Channels_commonKt$map$1.L$0 = producerScope3;
            channelsKt__Channels_commonKt$map$1.L$1 = receiveChannel6;
            channelsKt__Channels_commonKt$map$1.L$2 = receiveChannel9;
            channelsKt__Channels_commonKt$map$1.L$3 = th5;
            channelsKt__Channels_commonKt$map$1.L$4 = receiveChannel7;
            channelsKt__Channels_commonKt$map$1.L$5 = channelIterator2;
            channelsKt__Channels_commonKt$map$1.L$6 = obj3;
            channelsKt__Channels_commonKt$map$1.L$7 = obj3;
            channelsKt__Channels_commonKt$map$1.L$8 = producerScope3;
            channelsKt__Channels_commonKt$map$1.label = i2;
            obj2 = function2.invoke(obj3, channelsKt__Channels_commonKt$map$1);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            producerScope2 = producerScope3;
            channelsKt__Channels_commonKt$map$12 = channelsKt__Channels_commonKt$map$1;
            receiveChannel5 = receiveChannel9;
            obj4 = obj3;
            channelsKt__Channels_commonKt$map$12.L$0 = producerScope2;
            channelsKt__Channels_commonKt$map$12.L$1 = receiveChannel6;
            channelsKt__Channels_commonKt$map$12.L$2 = receiveChannel5;
            channelsKt__Channels_commonKt$map$12.L$3 = th5;
            channelsKt__Channels_commonKt$map$12.L$4 = receiveChannel7;
            channelsKt__Channels_commonKt$map$12.L$5 = channelIterator2;
            channelsKt__Channels_commonKt$map$12.L$6 = obj4;
            channelsKt__Channels_commonKt$map$12.L$7 = obj3;
            channelsKt__Channels_commonKt$map$12.label = 4;
            if (producerScope3.send(obj2, channelsKt__Channels_commonKt$map$12) != coroutine_suspended) {
            }
            return coroutine_suspended;
            return coroutine_suspended;
        } catch (Throwable th13) {
            th2 = th13;
            receiveChannel = receiveChannel9;
            throw th2;
        }
    }
}
