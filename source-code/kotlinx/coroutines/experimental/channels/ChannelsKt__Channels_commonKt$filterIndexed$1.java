package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "invoke", "(Lkotlinx/coroutines/experimental/channels/ProducerScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
/* compiled from: Channels.common.kt */
public final class ChannelsKt__Channels_commonKt$filterIndexed$1 extends CoroutineImpl implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3 $predicate;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    private ProducerScope p$;
    final /* synthetic */ ReceiveChannel receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$filterIndexed$1(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.receiver$0 = receiveChannel;
        this.$predicate = function3;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((ProducerScope) obj, (Continuation<? super Unit>) continuation);
    }

    public final Continuation<Unit> create(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        ChannelsKt__Channels_commonKt$filterIndexed$1 channelsKt__Channels_commonKt$filterIndexed$1 = new ChannelsKt__Channels_commonKt$filterIndexed$1(this.receiver$0, this.$predicate, continuation);
        channelsKt__Channels_commonKt$filterIndexed$1.p$ = producerScope;
        return channelsKt__Channels_commonKt$filterIndexed$1;
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((ChannelsKt__Channels_commonKt$filterIndexed$1) create((ProducerScope) producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ba  */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        int i;
        ProducerScope producerScope;
        ChannelsKt__Channels_commonKt$filterIndexed$1 channelsKt__Channels_commonKt$filterIndexed$1;
        ChannelIterator channelIterator;
        ProducerScope producerScope2;
        Object invoke;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                channelIterator = (ChannelIterator) this.L$1;
                int i3 = this.I$0;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    i = i3;
                    channelsKt__Channels_commonKt$filterIndexed$1 = this;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i2 == 2) {
                channelIterator = (ChannelIterator) this.L$1;
                int i4 = this.I$0;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    i = i4;
                    channelsKt__Channels_commonKt$filterIndexed$1 = this;
                    Function3 function3 = channelsKt__Channels_commonKt$filterIndexed$1.$predicate;
                    Integer valueOf = Integer.valueOf(i);
                    i++;
                    channelsKt__Channels_commonKt$filterIndexed$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$filterIndexed$1.I$0 = i;
                    channelsKt__Channels_commonKt$filterIndexed$1.L$1 = obj;
                    channelsKt__Channels_commonKt$filterIndexed$1.L$2 = channelIterator;
                    channelsKt__Channels_commonKt$filterIndexed$1.label = 3;
                    invoke = function3.invoke(valueOf, obj, channelsKt__Channels_commonKt$filterIndexed$1);
                    if (invoke != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                throw th;
            } else if (i2 == 3) {
                channelIterator = (ChannelIterator) this.L$2;
                Object obj2 = this.L$1;
                int i5 = this.I$0;
                ProducerScope producerScope3 = (ProducerScope) this.L$0;
                if (th == null) {
                    i = i5;
                    producerScope = producerScope3;
                    Object obj3 = obj2;
                    channelsKt__Channels_commonKt$filterIndexed$1 = this;
                    if (((Boolean) obj).booleanValue()) {
                        channelsKt__Channels_commonKt$filterIndexed$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$filterIndexed$1.I$0 = i;
                        channelsKt__Channels_commonKt$filterIndexed$1.L$1 = obj3;
                        channelsKt__Channels_commonKt$filterIndexed$1.L$2 = channelIterator;
                        channelsKt__Channels_commonKt$filterIndexed$1.label = 4;
                        if (producerScope.send(obj3, channelsKt__Channels_commonKt$filterIndexed$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    producerScope2 = producerScope;
                    channelsKt__Channels_commonKt$filterIndexed$1.L$0 = producerScope2;
                    channelsKt__Channels_commonKt$filterIndexed$1.I$0 = i;
                    channelsKt__Channels_commonKt$filterIndexed$1.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$filterIndexed$1.label = 1;
                    hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$filterIndexed$1);
                    if (hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    producerScope = producerScope2;
                    obj = hasNext;
                    if (!((Boolean) obj).booleanValue()) {
                        channelsKt__Channels_commonKt$filterIndexed$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$filterIndexed$1.I$0 = i;
                        channelsKt__Channels_commonKt$filterIndexed$1.L$1 = channelIterator;
                        channelsKt__Channels_commonKt$filterIndexed$1.label = 2;
                        obj = channelIterator.next(channelsKt__Channels_commonKt$filterIndexed$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Function3 function32 = channelsKt__Channels_commonKt$filterIndexed$1.$predicate;
                        Integer valueOf2 = Integer.valueOf(i);
                        i++;
                        channelsKt__Channels_commonKt$filterIndexed$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$filterIndexed$1.I$0 = i;
                        channelsKt__Channels_commonKt$filterIndexed$1.L$1 = obj;
                        channelsKt__Channels_commonKt$filterIndexed$1.L$2 = channelIterator;
                        channelsKt__Channels_commonKt$filterIndexed$1.label = 3;
                        invoke = function32.invoke(valueOf2, obj, channelsKt__Channels_commonKt$filterIndexed$1);
                        if (invoke != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj3 = obj;
                        obj = invoke;
                        if (((Boolean) obj).booleanValue()) {
                        }
                        producerScope2 = producerScope;
                        channelsKt__Channels_commonKt$filterIndexed$1.L$0 = producerScope2;
                        channelsKt__Channels_commonKt$filterIndexed$1.I$0 = i;
                        channelsKt__Channels_commonKt$filterIndexed$1.L$1 = channelIterator;
                        channelsKt__Channels_commonKt$filterIndexed$1.label = 1;
                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$filterIndexed$1);
                        if (hasNext == coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                    return coroutine_suspended;
                }
                throw th;
            } else if (i2 == 4) {
                ChannelIterator channelIterator2 = (ChannelIterator) this.L$2;
                int i6 = this.I$0;
                ProducerScope producerScope4 = (ProducerScope) this.L$0;
                if (th == null) {
                    i = i6;
                    channelIterator = channelIterator2;
                    producerScope2 = producerScope4;
                } else {
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            producerScope2 = this.p$;
            i = 0;
            channelIterator = this.receiver$0.iterator();
        } else {
            throw th;
        }
        channelsKt__Channels_commonKt$filterIndexed$1 = this;
        channelsKt__Channels_commonKt$filterIndexed$1.L$0 = producerScope2;
        channelsKt__Channels_commonKt$filterIndexed$1.I$0 = i;
        channelsKt__Channels_commonKt$filterIndexed$1.L$1 = channelIterator;
        channelsKt__Channels_commonKt$filterIndexed$1.label = 1;
        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$filterIndexed$1);
        if (hasNext == coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
