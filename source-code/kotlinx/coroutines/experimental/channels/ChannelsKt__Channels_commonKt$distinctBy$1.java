package kotlinx.coroutines.experimental.channels;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "K", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "invoke", "(Lkotlinx/coroutines/experimental/channels/ProducerScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
/* compiled from: Channels.common.kt */
public final class ChannelsKt__Channels_commonKt$distinctBy$1 extends CoroutineImpl implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $selector;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    private ProducerScope p$;
    final /* synthetic */ ReceiveChannel receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$distinctBy$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.receiver$0 = receiveChannel;
        this.$selector = function2;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((ProducerScope) obj, (Continuation<? super Unit>) continuation);
    }

    public final Continuation<Unit> create(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        ChannelsKt__Channels_commonKt$distinctBy$1 channelsKt__Channels_commonKt$distinctBy$1 = new ChannelsKt__Channels_commonKt$distinctBy$1(this.receiver$0, this.$selector, continuation);
        channelsKt__Channels_commonKt$distinctBy$1.p$ = producerScope;
        return channelsKt__Channels_commonKt$distinctBy$1;
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((ChannelsKt__Channels_commonKt$distinctBy$1) create((ProducerScope) producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d7  */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        ChannelsKt__Channels_commonKt$distinctBy$1 channelsKt__Channels_commonKt$distinctBy$1;
        ProducerScope producerScope;
        HashSet hashSet;
        ChannelIterator channelIterator;
        ChannelsKt__Channels_commonKt$distinctBy$1 channelsKt__Channels_commonKt$distinctBy$12;
        HashSet hashSet2;
        ProducerScope producerScope2;
        ProducerScope producerScope3;
        Object obj2;
        ProducerScope producerScope4;
        Object invoke;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                channelIterator = (ChannelIterator) this.L$2;
                HashSet hashSet3 = (HashSet) this.L$1;
                producerScope4 = (ProducerScope) this.L$0;
                if (th == null) {
                    hashSet2 = hashSet3;
                    channelsKt__Channels_commonKt$distinctBy$12 = this;
                    if (!((Boolean) obj).booleanValue()) {
                        channelsKt__Channels_commonKt$distinctBy$12.L$0 = producerScope4;
                        channelsKt__Channels_commonKt$distinctBy$12.L$1 = hashSet2;
                        channelsKt__Channels_commonKt$distinctBy$12.L$2 = channelIterator;
                        channelsKt__Channels_commonKt$distinctBy$12.label = 2;
                        obj = channelIterator.next(channelsKt__Channels_commonKt$distinctBy$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Function2 function2 = channelsKt__Channels_commonKt$distinctBy$12.$selector;
                        channelsKt__Channels_commonKt$distinctBy$12.L$0 = producerScope4;
                        channelsKt__Channels_commonKt$distinctBy$12.L$1 = hashSet2;
                        channelsKt__Channels_commonKt$distinctBy$12.L$2 = obj;
                        channelsKt__Channels_commonKt$distinctBy$12.L$3 = channelIterator;
                        channelsKt__Channels_commonKt$distinctBy$12.label = 3;
                        invoke = function2.invoke(obj, channelsKt__Channels_commonKt$distinctBy$12);
                        if (invoke != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i == 2) {
                channelIterator = (ChannelIterator) this.L$2;
                HashSet hashSet4 = (HashSet) this.L$1;
                producerScope4 = (ProducerScope) this.L$0;
                if (th == null) {
                    hashSet2 = hashSet4;
                    channelsKt__Channels_commonKt$distinctBy$12 = this;
                    Function2 function22 = channelsKt__Channels_commonKt$distinctBy$12.$selector;
                    channelsKt__Channels_commonKt$distinctBy$12.L$0 = producerScope4;
                    channelsKt__Channels_commonKt$distinctBy$12.L$1 = hashSet2;
                    channelsKt__Channels_commonKt$distinctBy$12.L$2 = obj;
                    channelsKt__Channels_commonKt$distinctBy$12.L$3 = channelIterator;
                    channelsKt__Channels_commonKt$distinctBy$12.label = 3;
                    invoke = function22.invoke(obj, channelsKt__Channels_commonKt$distinctBy$12);
                    if (invoke != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = obj;
                    obj = invoke;
                    producerScope3 = producerScope4;
                    hashSet = hashSet2;
                    channelsKt__Channels_commonKt$distinctBy$1 = channelsKt__Channels_commonKt$distinctBy$12;
                    if (hashSet.contains(obj)) {
                        producerScope = producerScope3;
                        channelsKt__Channels_commonKt$distinctBy$12 = channelsKt__Channels_commonKt$distinctBy$1;
                        hashSet2 = hashSet;
                    }
                    channelsKt__Channels_commonKt$distinctBy$1.L$0 = producerScope3;
                    channelsKt__Channels_commonKt$distinctBy$1.L$1 = hashSet;
                    channelsKt__Channels_commonKt$distinctBy$1.L$2 = obj2;
                    channelsKt__Channels_commonKt$distinctBy$1.L$3 = channelIterator;
                    channelsKt__Channels_commonKt$distinctBy$1.L$4 = obj;
                    channelsKt__Channels_commonKt$distinctBy$1.label = 4;
                    if (producerScope3.send(obj2, channelsKt__Channels_commonKt$distinctBy$1) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                    return coroutine_suspended;
                }
                throw th;
            } else if (i == 3) {
                channelIterator = (ChannelIterator) this.L$3;
                Object obj3 = this.L$2;
                HashSet hashSet5 = (HashSet) this.L$1;
                producerScope3 = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$distinctBy$1 = this;
                    obj2 = obj3;
                    hashSet = hashSet5;
                    if (hashSet.contains(obj)) {
                        channelsKt__Channels_commonKt$distinctBy$1.L$0 = producerScope3;
                        channelsKt__Channels_commonKt$distinctBy$1.L$1 = hashSet;
                        channelsKt__Channels_commonKt$distinctBy$1.L$2 = obj2;
                        channelsKt__Channels_commonKt$distinctBy$1.L$3 = channelIterator;
                        channelsKt__Channels_commonKt$distinctBy$1.L$4 = obj;
                        channelsKt__Channels_commonKt$distinctBy$1.label = 4;
                        if (producerScope3.send(obj2, channelsKt__Channels_commonKt$distinctBy$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope2 = producerScope3;
                        hashSet.add(obj);
                        producerScope = producerScope2;
                        channelsKt__Channels_commonKt$distinctBy$12 = channelsKt__Channels_commonKt$distinctBy$1;
                        hashSet2 = hashSet;
                        return coroutine_suspended;
                    }
                    producerScope = producerScope3;
                    channelsKt__Channels_commonKt$distinctBy$12 = channelsKt__Channels_commonKt$distinctBy$1;
                    hashSet2 = hashSet;
                } else {
                    throw th;
                }
            } else if (i == 4) {
                obj = this.L$4;
                channelIterator = (ChannelIterator) this.L$3;
                hashSet = (HashSet) this.L$1;
                producerScope2 = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$distinctBy$1 = this;
                    hashSet.add(obj);
                    producerScope = producerScope2;
                    channelsKt__Channels_commonKt$distinctBy$12 = channelsKt__Channels_commonKt$distinctBy$1;
                    hashSet2 = hashSet;
                } else {
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            producerScope = this.p$;
            hashSet2 = new HashSet();
            channelIterator = this.receiver$0.iterator();
            channelsKt__Channels_commonKt$distinctBy$12 = this;
        } else {
            throw th;
        }
        channelsKt__Channels_commonKt$distinctBy$12.L$0 = producerScope;
        channelsKt__Channels_commonKt$distinctBy$12.L$1 = hashSet2;
        channelsKt__Channels_commonKt$distinctBy$12.L$2 = channelIterator;
        channelsKt__Channels_commonKt$distinctBy$12.label = 1;
        Object hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$distinctBy$12);
        if (hasNext == coroutine_suspended) {
            return coroutine_suspended;
        }
        producerScope4 = producerScope;
        obj = hasNext;
        if (!((Boolean) obj).booleanValue()) {
        }
        return Unit.INSTANCE;
        return coroutine_suspended;
    }
}
