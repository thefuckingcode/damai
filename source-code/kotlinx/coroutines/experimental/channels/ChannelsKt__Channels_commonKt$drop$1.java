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
public final class ChannelsKt__Channels_commonKt$drop$1 extends CoroutineImpl implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    private ProducerScope p$;
    final /* synthetic */ ReceiveChannel receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$drop$1(ReceiveChannel receiveChannel, int i, Continuation continuation) {
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
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1 = new ChannelsKt__Channels_commonKt$drop$1(this.receiver$0, this.$n, continuation);
        channelsKt__Channels_commonKt$drop$1.p$ = producerScope;
        return channelsKt__Channels_commonKt$drop$1;
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((ChannelsKt__Channels_commonKt$drop$1) create((ProducerScope) producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0101 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0102  */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1;
        ProducerScope producerScope;
        int i;
        ChannelIterator channelIterator;
        int i2;
        ProducerScope producerScope2;
        ChannelIterator channelIterator2;
        int i3;
        int i4;
        ChannelIterator channelIterator3;
        ProducerScope producerScope3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 != 0) {
            if (i5 == 1) {
                channelIterator3 = (ChannelIterator) this.L$1;
                int i6 = this.I$0;
                producerScope3 = (ProducerScope) this.L$0;
                if (th == null) {
                    i2 = i6;
                    channelsKt__Channels_commonKt$drop$1 = this;
                    if (!((Boolean) obj).booleanValue()) {
                        channelsKt__Channels_commonKt$drop$1.L$0 = producerScope3;
                        channelsKt__Channels_commonKt$drop$1.I$0 = i2;
                        channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator3;
                        channelsKt__Channels_commonKt$drop$1.label = 2;
                        if (channelIterator3.next(channelsKt__Channels_commonKt$drop$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope2 = producerScope3;
                        i3 = i2;
                        channelIterator2 = channelIterator3;
                        i4 = i3 - 1;
                        if (i4 != 0) {
                        }
                        i2 = i4;
                        channelIterator = channelsKt__Channels_commonKt$drop$1.receiver$0.iterator();
                        producerScope = producerScope2;
                        i = i2;
                        channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$drop$1.I$0 = i;
                        channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
                        channelsKt__Channels_commonKt$drop$1.label = 3;
                        obj = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
                        if (obj == coroutine_suspended) {
                        }
                        if (((Boolean) obj).booleanValue()) {
                        }
                        return Unit.INSTANCE;
                        return coroutine_suspended;
                    }
                    producerScope2 = producerScope3;
                    channelIterator = channelsKt__Channels_commonKt$drop$1.receiver$0.iterator();
                    producerScope = producerScope2;
                    i = i2;
                    channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$drop$1.I$0 = i;
                    channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$drop$1.label = 3;
                    obj = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
                    if (obj == coroutine_suspended) {
                    }
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i5 == 2) {
                ChannelIterator channelIterator4 = (ChannelIterator) this.L$1;
                i3 = this.I$0;
                ProducerScope producerScope4 = (ProducerScope) this.L$0;
                if (th == null) {
                    channelIterator2 = channelIterator4;
                    producerScope2 = producerScope4;
                    channelsKt__Channels_commonKt$drop$1 = this;
                    i4 = i3 - 1;
                    if (i4 != 0) {
                        i2 = i4;
                    } else {
                        channelIterator3 = channelIterator2;
                        i2 = i4;
                    }
                    i2 = i4;
                    channelIterator = channelsKt__Channels_commonKt$drop$1.receiver$0.iterator();
                    producerScope = producerScope2;
                    i = i2;
                    channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$drop$1.I$0 = i;
                    channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$drop$1.label = 3;
                    obj = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
                    if (obj == coroutine_suspended) {
                    }
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i5 == 3) {
                channelIterator = (ChannelIterator) this.L$1;
                i = this.I$0;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$drop$1 = this;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i5 == 4) {
                channelIterator = (ChannelIterator) this.L$1;
                i = this.I$0;
                producerScope = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$drop$1 = this;
                    channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$drop$1.I$0 = i;
                    channelsKt__Channels_commonKt$drop$1.L$1 = obj;
                    channelsKt__Channels_commonKt$drop$1.L$2 = channelIterator;
                    channelsKt__Channels_commonKt$drop$1.label = 5;
                    if (producerScope.send(obj, channelsKt__Channels_commonKt$drop$1) == coroutine_suspended) {
                    }
                    channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$drop$1.I$0 = i;
                    channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$drop$1.label = 3;
                    obj = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
                    if (obj == coroutine_suspended) {
                    }
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else if (i5 == 5) {
                ChannelIterator channelIterator5 = (ChannelIterator) this.L$2;
                int i7 = this.I$0;
                ProducerScope producerScope5 = (ProducerScope) this.L$0;
                if (th == null) {
                    channelsKt__Channels_commonKt$drop$1 = this;
                    producerScope = producerScope5;
                    i = i7;
                    channelIterator = channelIterator5;
                    channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$drop$1.I$0 = i;
                    channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$drop$1.label = 3;
                    obj = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$drop$1.I$0 = i;
                        channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
                        channelsKt__Channels_commonKt$drop$1.label = 4;
                        obj = channelIterator.next(channelsKt__Channels_commonKt$drop$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$drop$1.I$0 = i;
                        channelsKt__Channels_commonKt$drop$1.L$1 = obj;
                        channelsKt__Channels_commonKt$drop$1.L$2 = channelIterator;
                        channelsKt__Channels_commonKt$drop$1.label = 5;
                        if (producerScope.send(obj, channelsKt__Channels_commonKt$drop$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                        channelsKt__Channels_commonKt$drop$1.I$0 = i;
                        channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
                        channelsKt__Channels_commonKt$drop$1.label = 3;
                        obj = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
                        if (obj == coroutine_suspended) {
                        }
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                    return Unit.INSTANCE;
                }
                throw th;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            producerScope2 = this.p$;
            i2 = this.$n;
            if (!(i2 >= 0)) {
                throw new IllegalArgumentException(("Requested element count " + this.$n + " is less than zero.").toString());
            } else if (i2 > 0) {
                channelIterator3 = this.receiver$0.iterator();
                channelsKt__Channels_commonKt$drop$1 = this;
            } else {
                channelsKt__Channels_commonKt$drop$1 = this;
                channelIterator = channelsKt__Channels_commonKt$drop$1.receiver$0.iterator();
                producerScope = producerScope2;
                i = i2;
                channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                channelsKt__Channels_commonKt$drop$1.I$0 = i;
                channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
                channelsKt__Channels_commonKt$drop$1.label = 3;
                obj = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
                if (obj == coroutine_suspended) {
                }
                if (((Boolean) obj).booleanValue()) {
                }
                return Unit.INSTANCE;
            }
        } else {
            throw th;
        }
        channelsKt__Channels_commonKt$drop$1.L$0 = producerScope2;
        channelsKt__Channels_commonKt$drop$1.I$0 = i2;
        channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator3;
        channelsKt__Channels_commonKt$drop$1.label = 1;
        Object hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$drop$1);
        if (hasNext == coroutine_suspended) {
            return coroutine_suspended;
        }
        producerScope3 = producerScope2;
        obj = hasNext;
        if (!((Boolean) obj).booleanValue()) {
            producerScope2 = producerScope3;
        }
        producerScope2 = producerScope3;
        channelIterator = channelsKt__Channels_commonKt$drop$1.receiver$0.iterator();
        producerScope = producerScope2;
        i = i2;
        channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
        channelsKt__Channels_commonKt$drop$1.I$0 = i;
        channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
        channelsKt__Channels_commonKt$drop$1.label = 3;
        obj = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
        if (obj == coroutine_suspended) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
        return Unit.INSTANCE;
        return coroutine_suspended;
    }
}
