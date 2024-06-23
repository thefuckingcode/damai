package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "E", "R", "V", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "invoke", "(Lkotlinx/coroutines/experimental/channels/ProducerScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
/* compiled from: Channels.common.kt */
public final class ChannelsKt__Channels_commonKt$zip$2 extends CoroutineImpl implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $other;
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
    Object L$9;
    private ProducerScope p$;
    final /* synthetic */ ReceiveChannel receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$zip$2(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.receiver$0 = receiveChannel;
        this.$other = receiveChannel2;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((ProducerScope) obj, (Continuation<? super Unit>) continuation);
    }

    public final Continuation<Unit> create(ProducerScope<? super V> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$2 = new ChannelsKt__Channels_commonKt$zip$2(this.receiver$0, this.$other, this.$transform, continuation);
        channelsKt__Channels_commonKt$zip$2.p$ = producerScope;
        return channelsKt__Channels_commonKt$zip$2;
    }

    public final Object invoke(ProducerScope<? super V> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((ChannelsKt__Channels_commonKt$zip$2) create((ProducerScope) producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01c5 A[RETURN] */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$2;
        ProducerScope producerScope;
        ChannelIterator channelIterator;
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        Throwable th2;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator2;
        ProducerScope producerScope2;
        ReceiveChannel receiveChannel4;
        Throwable th3;
        ChannelIterator channelIterator3;
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$22;
        Object obj2;
        Object obj3;
        Object obj4;
        Object invoke;
        ChannelIterator channelIterator4;
        Throwable th4;
        ReceiveChannel receiveChannel5;
        Object obj5;
        ProducerScope producerScope3;
        Object obj6;
        ProducerScope producerScope4;
        Throwable th5;
        Object obj7;
        Throwable th6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 4;
        int i3 = 3;
        int i4 = 2;
        if (i != 0) {
            if (i == 1) {
                channelIterator2 = (ChannelIterator) this.L$6;
                receiveChannel3 = (ReceiveChannel) this.L$5;
                th2 = (Throwable) this.L$4;
                receiveChannel2 = (ReceiveChannel) this.L$3;
                receiveChannel = (ReceiveChannel) this.L$2;
                channelIterator = (ChannelIterator) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    obj7 = obj;
                    channelsKt__Channels_commonKt$zip$2 = this;
                    if (!((Boolean) obj7).booleanValue()) {
                        channelsKt__Channels_commonKt$zip$2.L$0 = producerScope;
                        channelsKt__Channels_commonKt$zip$2.L$1 = channelIterator;
                        channelsKt__Channels_commonKt$zip$2.L$2 = receiveChannel;
                        channelsKt__Channels_commonKt$zip$2.L$3 = receiveChannel2;
                        channelsKt__Channels_commonKt$zip$2.L$4 = th2;
                        channelsKt__Channels_commonKt$zip$2.L$5 = receiveChannel3;
                        channelsKt__Channels_commonKt$zip$2.L$6 = channelIterator2;
                        channelsKt__Channels_commonKt$zip$2.label = i4;
                        obj2 = channelIterator2.next(channelsKt__Channels_commonKt$zip$2);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelIterator3 = channelIterator2;
                        channelsKt__Channels_commonKt$zip$22 = channelsKt__Channels_commonKt$zip$2;
                        channelIterator4 = channelIterator;
                        producerScope4 = producerScope;
                        receiveChannel4 = receiveChannel;
                        th5 = th2;
                        channelsKt__Channels_commonKt$zip$22.L$0 = producerScope4;
                        channelsKt__Channels_commonKt$zip$22.L$1 = channelIterator4;
                        channelsKt__Channels_commonKt$zip$22.L$2 = receiveChannel4;
                        channelsKt__Channels_commonKt$zip$22.L$3 = receiveChannel2;
                        channelsKt__Channels_commonKt$zip$22.L$4 = th5;
                        channelsKt__Channels_commonKt$zip$22.L$5 = receiveChannel3;
                        channelsKt__Channels_commonKt$zip$22.L$6 = channelIterator3;
                        channelsKt__Channels_commonKt$zip$22.L$7 = obj2;
                        channelsKt__Channels_commonKt$zip$22.L$8 = obj2;
                        channelsKt__Channels_commonKt$zip$22.label = i3;
                        obj6 = channelIterator4.hasNext(channelsKt__Channels_commonKt$zip$22);
                        if (obj6 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                        return coroutine_suspended;
                    }
                    Unit unit = Unit.INSTANCE;
                    receiveChannel2.cancel(th2);
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i == 2) {
                ChannelIterator channelIterator5 = (ChannelIterator) this.L$6;
                receiveChannel3 = (ReceiveChannel) this.L$5;
                Throwable th7 = (Throwable) this.L$4;
                receiveChannel2 = (ReceiveChannel) this.L$3;
                ReceiveChannel receiveChannel6 = (ReceiveChannel) this.L$2;
                ChannelIterator channelIterator6 = (ChannelIterator) this.L$1;
                ProducerScope producerScope5 = (ProducerScope) this.L$0;
                if (th == null) {
                    obj2 = obj;
                    channelIterator4 = channelIterator6;
                    producerScope4 = producerScope5;
                    receiveChannel4 = receiveChannel6;
                    th5 = th7;
                    channelIterator3 = channelIterator5;
                    channelsKt__Channels_commonKt$zip$22 = this;
                    channelsKt__Channels_commonKt$zip$22.L$0 = producerScope4;
                    channelsKt__Channels_commonKt$zip$22.L$1 = channelIterator4;
                    channelsKt__Channels_commonKt$zip$22.L$2 = receiveChannel4;
                    channelsKt__Channels_commonKt$zip$22.L$3 = receiveChannel2;
                    channelsKt__Channels_commonKt$zip$22.L$4 = th5;
                    channelsKt__Channels_commonKt$zip$22.L$5 = receiveChannel3;
                    channelsKt__Channels_commonKt$zip$22.L$6 = channelIterator3;
                    channelsKt__Channels_commonKt$zip$22.L$7 = obj2;
                    channelsKt__Channels_commonKt$zip$22.L$8 = obj2;
                    channelsKt__Channels_commonKt$zip$22.label = i3;
                    obj6 = channelIterator4.hasNext(channelsKt__Channels_commonKt$zip$22);
                    if (obj6 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    producerScope3 = producerScope4;
                    th4 = th5;
                    receiveChannel5 = receiveChannel3;
                    obj5 = obj2;
                    if (((Boolean) obj6).booleanValue()) {
                        channelsKt__Channels_commonKt$zip$22.L$0 = producerScope3;
                        channelsKt__Channels_commonKt$zip$22.L$1 = channelIterator4;
                        channelsKt__Channels_commonKt$zip$22.L$2 = receiveChannel4;
                        channelsKt__Channels_commonKt$zip$22.L$3 = receiveChannel2;
                        channelsKt__Channels_commonKt$zip$22.L$4 = th4;
                        channelsKt__Channels_commonKt$zip$22.L$5 = receiveChannel5;
                        channelsKt__Channels_commonKt$zip$22.L$6 = channelIterator3;
                        channelsKt__Channels_commonKt$zip$22.L$7 = obj5;
                        channelsKt__Channels_commonKt$zip$22.L$8 = obj2;
                        channelsKt__Channels_commonKt$zip$22.label = i2;
                        obj4 = channelIterator4.next(channelsKt__Channels_commonKt$zip$22);
                        if (obj4 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    receiveChannel3 = receiveChannel5;
                    receiveChannel = receiveChannel4;
                    producerScope = producerScope3;
                    channelsKt__Channels_commonKt$zip$2 = channelsKt__Channels_commonKt$zip$22;
                    channelIterator2 = channelIterator3;
                    th2 = th4;
                    channelIterator = channelIterator4;
                    i2 = 4;
                    i3 = 3;
                    i4 = 2;
                    return coroutine_suspended;
                }
                throw th;
            } else if (i == 3) {
                Object obj8 = this.L$8;
                obj5 = this.L$7;
                channelIterator3 = (ChannelIterator) this.L$6;
                ReceiveChannel receiveChannel7 = (ReceiveChannel) this.L$5;
                Throwable th8 = (Throwable) this.L$4;
                ReceiveChannel receiveChannel8 = (ReceiveChannel) this.L$3;
                receiveChannel4 = (ReceiveChannel) this.L$2;
                channelIterator4 = (ChannelIterator) this.L$1;
                ProducerScope producerScope6 = (ProducerScope) this.L$0;
                if (th == null) {
                    obj6 = obj;
                    producerScope3 = producerScope6;
                    obj2 = obj8;
                    channelsKt__Channels_commonKt$zip$22 = this;
                    receiveChannel5 = receiveChannel7;
                    receiveChannel2 = receiveChannel8;
                    th4 = th8;
                    if (((Boolean) obj6).booleanValue()) {
                        receiveChannel3 = receiveChannel5;
                        receiveChannel = receiveChannel4;
                        producerScope = producerScope3;
                        channelsKt__Channels_commonKt$zip$2 = channelsKt__Channels_commonKt$zip$22;
                        channelIterator2 = channelIterator3;
                        th2 = th4;
                        channelIterator = channelIterator4;
                        i2 = 4;
                        i3 = 3;
                        i4 = 2;
                    }
                    channelsKt__Channels_commonKt$zip$22.L$0 = producerScope3;
                    channelsKt__Channels_commonKt$zip$22.L$1 = channelIterator4;
                    channelsKt__Channels_commonKt$zip$22.L$2 = receiveChannel4;
                    channelsKt__Channels_commonKt$zip$22.L$3 = receiveChannel2;
                    channelsKt__Channels_commonKt$zip$22.L$4 = th4;
                    channelsKt__Channels_commonKt$zip$22.L$5 = receiveChannel5;
                    channelsKt__Channels_commonKt$zip$22.L$6 = channelIterator3;
                    channelsKt__Channels_commonKt$zip$22.L$7 = obj5;
                    channelsKt__Channels_commonKt$zip$22.L$8 = obj2;
                    channelsKt__Channels_commonKt$zip$22.label = i2;
                    obj4 = channelIterator4.next(channelsKt__Channels_commonKt$zip$22);
                    if (obj4 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    producerScope2 = producerScope3;
                    obj3 = obj5;
                    receiveChannel3 = receiveChannel5;
                    th3 = th4;
                    channelIterator = channelIterator4;
                    invoke = channelsKt__Channels_commonKt$zip$22.$transform.invoke(obj2, obj4);
                    channelsKt__Channels_commonKt$zip$22.L$0 = producerScope2;
                    channelsKt__Channels_commonKt$zip$22.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$zip$22.L$2 = receiveChannel4;
                    channelsKt__Channels_commonKt$zip$22.L$3 = receiveChannel2;
                    channelsKt__Channels_commonKt$zip$22.L$4 = th3;
                    channelsKt__Channels_commonKt$zip$22.L$5 = receiveChannel3;
                    channelsKt__Channels_commonKt$zip$22.L$6 = channelIterator3;
                    channelsKt__Channels_commonKt$zip$22.L$7 = obj3;
                    channelsKt__Channels_commonKt$zip$22.L$8 = obj2;
                    channelsKt__Channels_commonKt$zip$22.L$9 = obj4;
                    channelsKt__Channels_commonKt$zip$22.label = 5;
                    if (producerScope2.send(invoke, channelsKt__Channels_commonKt$zip$22) == coroutine_suspended) {
                    }
                    channelsKt__Channels_commonKt$zip$2 = channelsKt__Channels_commonKt$zip$22;
                    channelIterator2 = channelIterator3;
                    th2 = th3;
                    receiveChannel = receiveChannel4;
                    producerScope = producerScope2;
                    i2 = 4;
                    i3 = 3;
                    i4 = 2;
                    return coroutine_suspended;
                }
                throw th;
            } else if (i == 4) {
                Object obj9 = this.L$8;
                Object obj10 = this.L$7;
                channelIterator3 = (ChannelIterator) this.L$6;
                ReceiveChannel receiveChannel9 = (ReceiveChannel) this.L$5;
                th3 = (Throwable) this.L$4;
                ReceiveChannel receiveChannel10 = (ReceiveChannel) this.L$3;
                receiveChannel4 = (ReceiveChannel) this.L$2;
                ChannelIterator channelIterator7 = (ChannelIterator) this.L$1;
                ProducerScope producerScope7 = (ProducerScope) this.L$0;
                if (th == null) {
                    obj4 = obj;
                    obj3 = obj10;
                    receiveChannel3 = receiveChannel9;
                    receiveChannel2 = receiveChannel10;
                    channelIterator = channelIterator7;
                    producerScope2 = producerScope7;
                    obj2 = obj9;
                    channelsKt__Channels_commonKt$zip$22 = this;
                    invoke = channelsKt__Channels_commonKt$zip$22.$transform.invoke(obj2, obj4);
                    channelsKt__Channels_commonKt$zip$22.L$0 = producerScope2;
                    channelsKt__Channels_commonKt$zip$22.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$zip$22.L$2 = receiveChannel4;
                    channelsKt__Channels_commonKt$zip$22.L$3 = receiveChannel2;
                    channelsKt__Channels_commonKt$zip$22.L$4 = th3;
                    channelsKt__Channels_commonKt$zip$22.L$5 = receiveChannel3;
                    channelsKt__Channels_commonKt$zip$22.L$6 = channelIterator3;
                    channelsKt__Channels_commonKt$zip$22.L$7 = obj3;
                    channelsKt__Channels_commonKt$zip$22.L$8 = obj2;
                    channelsKt__Channels_commonKt$zip$22.L$9 = obj4;
                    channelsKt__Channels_commonKt$zip$22.label = 5;
                    if (producerScope2.send(invoke, channelsKt__Channels_commonKt$zip$22) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    channelsKt__Channels_commonKt$zip$2 = channelsKt__Channels_commonKt$zip$22;
                    channelIterator2 = channelIterator3;
                    th2 = th3;
                    receiveChannel = receiveChannel4;
                    producerScope = producerScope2;
                    i2 = 4;
                    i3 = 3;
                    i4 = 2;
                } else {
                    try {
                        throw th;
                    } catch (Throwable th9) {
                        th6 = th9;
                        receiveChannel2 = receiveChannel10;
                    }
                }
            } else if (i == 5) {
                ChannelIterator channelIterator8 = (ChannelIterator) this.L$6;
                receiveChannel3 = (ReceiveChannel) this.L$5;
                Throwable th10 = (Throwable) this.L$4;
                receiveChannel2 = (ReceiveChannel) this.L$3;
                ReceiveChannel receiveChannel11 = (ReceiveChannel) this.L$2;
                channelIterator = (ChannelIterator) this.L$1;
                ProducerScope producerScope8 = (ProducerScope) this.L$0;
                if (th == null) {
                    producerScope2 = producerScope8;
                    receiveChannel4 = receiveChannel11;
                    th3 = th10;
                    channelIterator3 = channelIterator8;
                    channelsKt__Channels_commonKt$zip$22 = this;
                    channelsKt__Channels_commonKt$zip$2 = channelsKt__Channels_commonKt$zip$22;
                    channelIterator2 = channelIterator3;
                    th2 = th3;
                    receiveChannel = receiveChannel4;
                    producerScope = producerScope2;
                    i2 = 4;
                    i3 = 3;
                    i4 = 2;
                } else {
                    try {
                        throw th;
                    } catch (Throwable th11) {
                        th6 = th11;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            ProducerScope producerScope9 = this.p$;
            ChannelIterator it = this.$other.iterator();
            receiveChannel2 = this.receiver$0;
            th2 = null;
            channelsKt__Channels_commonKt$zip$2 = this;
            producerScope = producerScope9;
            channelIterator = it;
            receiveChannel3 = receiveChannel2;
            channelIterator2 = receiveChannel2.iterator();
            receiveChannel = receiveChannel3;
        } else {
            throw th;
        }
        channelsKt__Channels_commonKt$zip$2.L$0 = producerScope;
        channelsKt__Channels_commonKt$zip$2.L$1 = channelIterator;
        channelsKt__Channels_commonKt$zip$2.L$2 = receiveChannel;
        channelsKt__Channels_commonKt$zip$2.L$3 = receiveChannel2;
        channelsKt__Channels_commonKt$zip$2.L$4 = th2;
        channelsKt__Channels_commonKt$zip$2.L$5 = receiveChannel3;
        channelsKt__Channels_commonKt$zip$2.L$6 = channelIterator2;
        channelsKt__Channels_commonKt$zip$2.label = 1;
        obj7 = channelIterator2.hasNext(channelsKt__Channels_commonKt$zip$2);
        if (obj7 == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((Boolean) obj7).booleanValue()) {
            Unit unit2 = Unit.INSTANCE;
            receiveChannel2.cancel(th2);
        }
        Unit unit22 = Unit.INSTANCE;
        receiveChannel2.cancel(th2);
        return Unit.INSTANCE;
        try {
            throw th6;
        } catch (Throwable th12) {
            receiveChannel2.cancel(th6);
            throw th12;
        }
    }
}
