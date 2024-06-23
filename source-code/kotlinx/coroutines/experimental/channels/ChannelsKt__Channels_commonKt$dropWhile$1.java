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
public final class ChannelsKt__Channels_commonKt$dropWhile$1 extends CoroutineImpl implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $predicate;
    Object L$0;
    Object L$1;
    Object L$2;
    private ProducerScope p$;
    final /* synthetic */ ReceiveChannel receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$dropWhile$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
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
        ChannelsKt__Channels_commonKt$dropWhile$1 channelsKt__Channels_commonKt$dropWhile$1 = new ChannelsKt__Channels_commonKt$dropWhile$1(this.receiver$0, this.$predicate, continuation);
        channelsKt__Channels_commonKt$dropWhile$1.p$ = producerScope;
        return channelsKt__Channels_commonKt$dropWhile$1;
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((ChannelsKt__Channels_commonKt$dropWhile$1) create((ProducerScope) producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ea A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0110 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0111  */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        ChannelsKt__Channels_commonKt$dropWhile$1 channelsKt__Channels_commonKt$dropWhile$1;
        ProducerScope producerScope;
        ChannelIterator channelIterator;
        ChannelIterator channelIterator2;
        ProducerScope producerScope2;
        Object obj2;
        ChannelIterator channelIterator3;
        Object invoke;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                if (th == null) {
                    ProducerScope producerScope3 = this.p$;
                    channelIterator3 = this.receiver$0.iterator();
                    channelsKt__Channels_commonKt$dropWhile$1 = this;
                    channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope3;
                    channelsKt__Channels_commonKt$dropWhile$1.L$1 = channelIterator3;
                    channelsKt__Channels_commonKt$dropWhile$1.label = 1;
                    Object hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$dropWhile$1);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    producerScope = producerScope3;
                    obj = hasNext;
                    if (((Boolean) obj).booleanValue()) {
                        channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$dropWhile$1.L$1 = channelIterator3;
                        channelsKt__Channels_commonKt$dropWhile$1.label = 2;
                        obj = channelIterator3.next(channelsKt__Channels_commonKt$dropWhile$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Function2 function2 = channelsKt__Channels_commonKt$dropWhile$1.$predicate;
                        channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$dropWhile$1.L$1 = obj;
                        channelsKt__Channels_commonKt$dropWhile$1.L$2 = channelIterator3;
                        channelsKt__Channels_commonKt$dropWhile$1.label = 3;
                        invoke = function2.invoke(obj, channelsKt__Channels_commonKt$dropWhile$1);
                        if (invoke != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = obj;
                        obj = invoke;
                        if (((Boolean) obj).booleanValue()) {
                            channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                            channelsKt__Channels_commonKt$dropWhile$1.L$1 = obj2;
                            channelsKt__Channels_commonKt$dropWhile$1.label = 4;
                        } else {
                            producerScope3 = producerScope;
                            channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope3;
                            channelsKt__Channels_commonKt$dropWhile$1.L$1 = channelIterator3;
                            channelsKt__Channels_commonKt$dropWhile$1.label = 1;
                            Object hasNext2 = channelIterator3.hasNext(channelsKt__Channels_commonKt$dropWhile$1);
                            if (hasNext2 != coroutine_suspended) {
                            }
                        }
                        channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$dropWhile$1.L$1 = obj2;
                        channelsKt__Channels_commonKt$dropWhile$1.label = 4;
                        if (producerScope.send(obj2, channelsKt__Channels_commonKt$dropWhile$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope2 = producerScope;
                        producerScope = producerScope2;
                        return coroutine_suspended;
                    }
                    channelIterator2 = channelsKt__Channels_commonKt$dropWhile$1.receiver$0.iterator();
                    channelIterator = channelIterator2;
                    channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$dropWhile$1.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$dropWhile$1.label = 5;
                    obj = channelIterator.hasNext(channelsKt__Channels_commonKt$dropWhile$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$dropWhile$1.L$1 = channelIterator;
                        channelsKt__Channels_commonKt$dropWhile$1.label = 6;
                        obj = channelIterator.next(channelsKt__Channels_commonKt$dropWhile$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$dropWhile$1.L$1 = obj;
                        channelsKt__Channels_commonKt$dropWhile$1.L$2 = channelIterator;
                        channelsKt__Channels_commonKt$dropWhile$1.label = 7;
                        if (producerScope.send(obj, channelsKt__Channels_commonKt$dropWhile$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$dropWhile$1.L$1 = channelIterator;
                        channelsKt__Channels_commonKt$dropWhile$1.label = 5;
                        obj = channelIterator.hasNext(channelsKt__Channels_commonKt$dropWhile$1);
                        if (obj == coroutine_suspended) {
                        }
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                    return Unit.INSTANCE;
                    return coroutine_suspended;
                }
                throw th;
            case 1:
                channelIterator3 = (ChannelIterator) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$dropWhile$1 = this;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    channelIterator2 = channelsKt__Channels_commonKt$dropWhile$1.receiver$0.iterator();
                    channelIterator = channelIterator2;
                    channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$dropWhile$1.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$dropWhile$1.label = 5;
                    obj = channelIterator.hasNext(channelsKt__Channels_commonKt$dropWhile$1);
                    if (obj == coroutine_suspended) {
                    }
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            case 2:
                channelIterator3 = (ChannelIterator) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$dropWhile$1 = this;
                    Function2 function22 = channelsKt__Channels_commonKt$dropWhile$1.$predicate;
                    channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$dropWhile$1.L$1 = obj;
                    channelsKt__Channels_commonKt$dropWhile$1.L$2 = channelIterator3;
                    channelsKt__Channels_commonKt$dropWhile$1.label = 3;
                    invoke = function22.invoke(obj, channelsKt__Channels_commonKt$dropWhile$1);
                    if (invoke != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                throw th;
            case 3:
                channelIterator3 = (ChannelIterator) this.L$2;
                Object obj3 = this.L$1;
                ProducerScope producerScope4 = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$dropWhile$1 = this;
                    obj2 = obj3;
                    producerScope = producerScope4;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$dropWhile$1.L$1 = obj2;
                    channelsKt__Channels_commonKt$dropWhile$1.label = 4;
                    if (producerScope.send(obj2, channelsKt__Channels_commonKt$dropWhile$1) != coroutine_suspended) {
                    }
                } else {
                    throw th;
                }
                break;
            case 4:
                producerScope2 = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$dropWhile$1 = this;
                    producerScope = producerScope2;
                    channelIterator2 = channelsKt__Channels_commonKt$dropWhile$1.receiver$0.iterator();
                    channelIterator = channelIterator2;
                    channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$dropWhile$1.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$dropWhile$1.label = 5;
                    obj = channelIterator.hasNext(channelsKt__Channels_commonKt$dropWhile$1);
                    if (obj == coroutine_suspended) {
                    }
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            case 5:
                channelIterator = (ChannelIterator) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$dropWhile$1 = this;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            case 6:
                channelIterator = (ChannelIterator) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$dropWhile$1 = this;
                    channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$dropWhile$1.L$1 = obj;
                    channelsKt__Channels_commonKt$dropWhile$1.L$2 = channelIterator;
                    channelsKt__Channels_commonKt$dropWhile$1.label = 7;
                    if (producerScope.send(obj, channelsKt__Channels_commonKt$dropWhile$1) == coroutine_suspended) {
                    }
                    channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$dropWhile$1.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$dropWhile$1.label = 5;
                    obj = channelIterator.hasNext(channelsKt__Channels_commonKt$dropWhile$1);
                    if (obj == coroutine_suspended) {
                    }
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            case 7:
                channelIterator2 = (ChannelIterator) this.L$2;
                ProducerScope producerScope5 = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$dropWhile$1 = this;
                    producerScope = producerScope5;
                    channelIterator = channelIterator2;
                    channelsKt__Channels_commonKt$dropWhile$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$dropWhile$1.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$dropWhile$1.label = 5;
                    obj = channelIterator.hasNext(channelsKt__Channels_commonKt$dropWhile$1);
                    if (obj == coroutine_suspended) {
                    }
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
