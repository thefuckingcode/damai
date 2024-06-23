package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;", "invoke", "(Lkotlinx/coroutines/experimental/channels/ProducerScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
/* compiled from: Channels.common.kt */
public final class ChannelsKt__Channels_commonKt$withIndex$1 extends CoroutineImpl implements Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    private ProducerScope p$;
    final /* synthetic */ ReceiveChannel receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$withIndex$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.receiver$0 = receiveChannel;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((ProducerScope) obj, (Continuation<? super Unit>) continuation);
    }

    public final Continuation<Unit> create(ProducerScope<? super IndexedValue<? extends E>> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        ChannelsKt__Channels_commonKt$withIndex$1 channelsKt__Channels_commonKt$withIndex$1 = new ChannelsKt__Channels_commonKt$withIndex$1(this.receiver$0, continuation);
        channelsKt__Channels_commonKt$withIndex$1.p$ = producerScope;
        return channelsKt__Channels_commonKt$withIndex$1;
    }

    public final Object invoke(ProducerScope<? super IndexedValue<? extends E>> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((ChannelsKt__Channels_commonKt$withIndex$1) create((ProducerScope) producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073  */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        ChannelsKt__Channels_commonKt$withIndex$1 channelsKt__Channels_commonKt$withIndex$1;
        ProducerScope producerScope;
        int i;
        ChannelIterator channelIterator;
        int i2;
        ChannelsKt__Channels_commonKt$withIndex$1 channelsKt__Channels_commonKt$withIndex$12;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                channelIterator = (ChannelIterator) this.L$1;
                i = this.I$0;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$withIndex$1 = this;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i3 == 2) {
                channelIterator = (ChannelIterator) this.L$1;
                i = this.I$0;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$withIndex$1 = this;
                } else {
                    throw th;
                }
            } else if (i3 == 3) {
                ChannelIterator channelIterator2 = (ChannelIterator) this.L$2;
                int i4 = this.I$0;
                ProducerScope producerScope2 = (ProducerScope) this.L$0;
                if (th == null) {
                    i2 = i4;
                    producerScope = producerScope2;
                    channelIterator = channelIterator2;
                    channelsKt__Channels_commonKt$withIndex$12 = this;
                    channelsKt__Channels_commonKt$withIndex$12.L$0 = producerScope;
                    channelsKt__Channels_commonKt$withIndex$12.I$0 = i2;
                    channelsKt__Channels_commonKt$withIndex$12.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$withIndex$12.label = 1;
                    hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$withIndex$12);
                    if (hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    channelsKt__Channels_commonKt$withIndex$1 = channelsKt__Channels_commonKt$withIndex$12;
                    obj = hasNext;
                    i = i2;
                    if (!((Boolean) obj).booleanValue()) {
                        channelsKt__Channels_commonKt$withIndex$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$withIndex$1.I$0 = i;
                        channelsKt__Channels_commonKt$withIndex$1.L$1 = channelIterator;
                        channelsKt__Channels_commonKt$withIndex$1.label = 2;
                        obj = channelIterator.next(channelsKt__Channels_commonKt$withIndex$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                    return coroutine_suspended;
                }
                throw th;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            ProducerScope producerScope3 = this.p$;
            i2 = 0;
            channelIterator = this.receiver$0.iterator();
            producerScope = producerScope3;
            channelsKt__Channels_commonKt$withIndex$12 = this;
            channelsKt__Channels_commonKt$withIndex$12.L$0 = producerScope;
            channelsKt__Channels_commonKt$withIndex$12.I$0 = i2;
            channelsKt__Channels_commonKt$withIndex$12.L$1 = channelIterator;
            channelsKt__Channels_commonKt$withIndex$12.label = 1;
            hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$withIndex$12);
            if (hasNext == coroutine_suspended) {
            }
            return coroutine_suspended;
        } else {
            throw th;
        }
        int i5 = i + 1;
        IndexedValue indexedValue = new IndexedValue(i, obj);
        channelsKt__Channels_commonKt$withIndex$1.L$0 = producerScope;
        channelsKt__Channels_commonKt$withIndex$1.I$0 = i5;
        channelsKt__Channels_commonKt$withIndex$1.L$1 = obj;
        channelsKt__Channels_commonKt$withIndex$1.L$2 = channelIterator;
        channelsKt__Channels_commonKt$withIndex$1.label = 3;
        if (producerScope.send(indexedValue, channelsKt__Channels_commonKt$withIndex$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        channelsKt__Channels_commonKt$withIndex$12 = channelsKt__Channels_commonKt$withIndex$1;
        producerScope = producerScope;
        i2 = i5;
        channelsKt__Channels_commonKt$withIndex$12.L$0 = producerScope;
        channelsKt__Channels_commonKt$withIndex$12.I$0 = i2;
        channelsKt__Channels_commonKt$withIndex$12.L$1 = channelIterator;
        channelsKt__Channels_commonKt$withIndex$12.label = 1;
        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$withIndex$12);
        if (hasNext == coroutine_suspended) {
        }
        return coroutine_suspended;
        return coroutine_suspended;
    }
}
