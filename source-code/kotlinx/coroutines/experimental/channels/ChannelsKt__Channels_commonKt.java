package kotlinx.coroutines.experimental.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.experimental.Unconfined;
import kotlinx.coroutines.experimental.channels.ReceiveChannel;

public final /* synthetic */ class ChannelsKt__Channels_commonKt {
    public static /* bridge */ /* synthetic */ ReceiveChannel asReceiveChannel$default(Iterable iterable, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.asReceiveChannel(iterable, coroutineContext);
    }

    public static final <E> ReceiveChannel<E> asReceiveChannel(Iterable<? extends E> iterable, CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return ProduceKt.produce$default(coroutineContext, 0, null, null, new ChannelsKt__Channels_commonKt$asReceiveChannel$1(iterable, null), 14, null);
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel asReceiveChannel$default(Sequence sequence, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.asReceiveChannel(sequence, coroutineContext);
    }

    public static final <E> ReceiveChannel<E> asReceiveChannel(Sequence<? extends E> sequence, CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(sequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return ProduceKt.produce$default(coroutineContext, 0, null, null, new ChannelsKt__Channels_commonKt$asReceiveChannel$2(sequence, null), 14, null);
    }

    public static final <E, R> R consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(broadcastChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        try {
            return (R) function1.invoke(openSubscription);
        } finally {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default(openSubscription, null, 1, null);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00da A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    public static final /* synthetic */ <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$3;
        int label;
        ReceiveChannel<E> receiveChannel;
        ChannelIterator<E> channelIterator;
        BroadcastChannel<E> broadcastChannel2;
        Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function22;
        BroadcastChannel<E> broadcastChannel3;
        BroadcastChannel<E> broadcastChannel4;
        ReceiveChannel<E> receiveChannel2;
        BroadcastChannel<E> broadcastChannel5;
        Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function23;
        Object obj;
        ReceiveChannel<E> receiveChannel3;
        BroadcastChannel<E> broadcastChannel6;
        BroadcastChannel<E> broadcastChannel7;
        ChannelIterator channelIterator2;
        ChannelIterator<E> channelIterator3;
        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$32;
        BroadcastChannel<E> broadcastChannel8;
        Object hasNext;
        ChannelIterator<E> channelIterator4;
        ReceiveChannel<E> receiveChannel4;
        Throwable th;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$3) {
            channelsKt__Channels_commonKt$consumeEach$3 = (ChannelsKt__Channels_commonKt$consumeEach$3) continuation;
            if ((channelsKt__Channels_commonKt$consumeEach$3.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEach$3.setLabel(channelsKt__Channels_commonKt$consumeEach$3.getLabel() - Integer.MIN_VALUE);
                Object obj2 = channelsKt__Channels_commonKt$consumeEach$3.data;
                Throwable th2 = channelsKt__Channels_commonKt$consumeEach$3.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$consumeEach$3.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        receiveChannel = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$5;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$4;
                        broadcastChannel4 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$3.L$3;
                        broadcastChannel3 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$3.L$2;
                        function22 = (Function2) channelsKt__Channels_commonKt$consumeEach$3.L$1;
                        broadcastChannel2 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$3.L$0;
                        channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$3.L$6;
                        if (th2 != null) {
                            throw th2;
                        }
                        if (!((Boolean) obj2).booleanValue()) {
                            channelsKt__Channels_commonKt$consumeEach$3.L$0 = broadcastChannel2;
                            channelsKt__Channels_commonKt$consumeEach$3.L$1 = function22;
                            channelsKt__Channels_commonKt$consumeEach$3.L$2 = broadcastChannel3;
                            channelsKt__Channels_commonKt$consumeEach$3.L$3 = broadcastChannel4;
                            channelsKt__Channels_commonKt$consumeEach$3.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$consumeEach$3.L$5 = receiveChannel;
                            channelsKt__Channels_commonKt$consumeEach$3.L$6 = channelIterator2;
                            channelsKt__Channels_commonKt$consumeEach$3.setLabel(2);
                            obj2 = channelIterator2.next(channelsKt__Channels_commonKt$consumeEach$3);
                            channelIterator = channelIterator2;
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            channelsKt__Channels_commonKt$consumeEach$3.L$0 = broadcastChannel2;
                            channelsKt__Channels_commonKt$consumeEach$3.L$1 = function22;
                            channelsKt__Channels_commonKt$consumeEach$3.L$2 = broadcastChannel3;
                            channelsKt__Channels_commonKt$consumeEach$3.L$3 = broadcastChannel4;
                            channelsKt__Channels_commonKt$consumeEach$3.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$consumeEach$3.L$5 = receiveChannel;
                            channelsKt__Channels_commonKt$consumeEach$3.L$6 = channelIterator;
                            channelsKt__Channels_commonKt$consumeEach$3.L$7 = obj2;
                            channelsKt__Channels_commonKt$consumeEach$3.L$8 = obj2;
                            channelsKt__Channels_commonKt$consumeEach$3.setLabel(3);
                            if (function22.invoke(obj2, channelsKt__Channels_commonKt$consumeEach$3) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        Unit unit = Unit.INSTANCE;
                        ReceiveChannel.DefaultImpls.cancel$default(receiveChannel2, null, 1, null);
                        return unit;
                    } else if (label == 2) {
                        receiveChannel = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$5;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$4;
                        broadcastChannel4 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$3.L$3;
                        broadcastChannel3 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$3.L$2;
                        function22 = (Function2) channelsKt__Channels_commonKt$consumeEach$3.L$1;
                        broadcastChannel2 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$3.L$0;
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$3.L$6;
                        if (th2 != null) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                th = th3;
                                receiveChannel4 = receiveChannel2;
                            }
                        }
                        channelsKt__Channels_commonKt$consumeEach$3.L$0 = broadcastChannel2;
                        channelsKt__Channels_commonKt$consumeEach$3.L$1 = function22;
                        channelsKt__Channels_commonKt$consumeEach$3.L$2 = broadcastChannel3;
                        channelsKt__Channels_commonKt$consumeEach$3.L$3 = broadcastChannel4;
                        channelsKt__Channels_commonKt$consumeEach$3.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$consumeEach$3.L$5 = receiveChannel;
                        channelsKt__Channels_commonKt$consumeEach$3.L$6 = channelIterator;
                        channelsKt__Channels_commonKt$consumeEach$3.L$7 = obj2;
                        channelsKt__Channels_commonKt$consumeEach$3.L$8 = obj2;
                        channelsKt__Channels_commonKt$consumeEach$3.setLabel(3);
                        if (function22.invoke(obj2, channelsKt__Channels_commonKt$consumeEach$3) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        broadcastChannel5 = broadcastChannel3;
                        function23 = function22;
                        obj = coroutine_suspended;
                        receiveChannel3 = receiveChannel;
                        broadcastChannel6 = broadcastChannel2;
                        broadcastChannel7 = broadcastChannel4;
                        channelIterator4 = channelIterator;
                        return coroutine_suspended;
                    } else if (label == 3) {
                        Object obj3 = channelsKt__Channels_commonKt$consumeEach$3.L$8;
                        Object obj4 = channelsKt__Channels_commonKt$consumeEach$3.L$7;
                        ChannelIterator<E> channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$3.L$6;
                        ReceiveChannel<E> receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$5;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$4;
                        BroadcastChannel<E> broadcastChannel9 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$3.L$3;
                        BroadcastChannel<E> broadcastChannel10 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$3.L$2;
                        Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function24 = (Function2) channelsKt__Channels_commonKt$consumeEach$3.L$1;
                        BroadcastChannel<E> broadcastChannel11 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$3.L$0;
                        if (th2 == null) {
                            function23 = function24;
                            obj = coroutine_suspended;
                            receiveChannel3 = receiveChannel5;
                            broadcastChannel6 = broadcastChannel11;
                            broadcastChannel7 = broadcastChannel9;
                            receiveChannel2 = receiveChannel4;
                            broadcastChannel5 = broadcastChannel10;
                            channelIterator4 = channelIterator5;
                        } else {
                            try {
                                throw th2;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th2 == null) {
                    ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
                    ChannelIterator<E> it = openSubscription.iterator();
                    receiveChannel2 = openSubscription;
                    channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
                    obj = coroutine_suspended;
                    broadcastChannel5 = broadcastChannel;
                    broadcastChannel8 = broadcastChannel5;
                    receiveChannel3 = receiveChannel2;
                    channelIterator3 = it;
                    function23 = function2;
                    broadcastChannel6 = broadcastChannel8;
                    channelsKt__Channels_commonKt$consumeEach$32.L$0 = broadcastChannel6;
                    channelsKt__Channels_commonKt$consumeEach$32.L$1 = function23;
                    channelsKt__Channels_commonKt$consumeEach$32.L$2 = broadcastChannel5;
                    channelsKt__Channels_commonKt$consumeEach$32.L$3 = broadcastChannel8;
                    channelsKt__Channels_commonKt$consumeEach$32.L$4 = receiveChannel2;
                    channelsKt__Channels_commonKt$consumeEach$32.L$5 = receiveChannel3;
                    channelsKt__Channels_commonKt$consumeEach$32.L$6 = channelIterator3;
                    channelsKt__Channels_commonKt$consumeEach$32.setLabel(1);
                    hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$consumeEach$32);
                    if (hasNext == obj) {
                        return obj;
                    }
                    broadcastChannel2 = broadcastChannel6;
                    receiveChannel = receiveChannel3;
                    coroutine_suspended = obj;
                    broadcastChannel3 = broadcastChannel5;
                    obj2 = hasNext;
                    function22 = function23;
                    broadcastChannel4 = broadcastChannel8;
                    channelsKt__Channels_commonKt$consumeEach$3 = channelsKt__Channels_commonKt$consumeEach$32;
                    channelIterator2 = channelIterator3;
                    if (!((Boolean) obj2).booleanValue()) {
                        Unit unit2 = Unit.INSTANCE;
                        ReceiveChannel.DefaultImpls.cancel$default(receiveChannel2, null, 1, null);
                    }
                    Unit unit22 = Unit.INSTANCE;
                    ReceiveChannel.DefaultImpls.cancel$default(receiveChannel2, null, 1, null);
                    return unit22;
                    return obj;
                } else {
                    throw th2;
                }
                channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
                broadcastChannel8 = broadcastChannel7;
                channelIterator3 = channelIterator4;
                channelsKt__Channels_commonKt$consumeEach$32.L$0 = broadcastChannel6;
                channelsKt__Channels_commonKt$consumeEach$32.L$1 = function23;
                channelsKt__Channels_commonKt$consumeEach$32.L$2 = broadcastChannel5;
                channelsKt__Channels_commonKt$consumeEach$32.L$3 = broadcastChannel8;
                channelsKt__Channels_commonKt$consumeEach$32.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$consumeEach$32.L$5 = receiveChannel3;
                channelsKt__Channels_commonKt$consumeEach$32.L$6 = channelIterator3;
                channelsKt__Channels_commonKt$consumeEach$32.setLabel(1);
                hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$consumeEach$32);
                if (hasNext == obj) {
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$consumeEach$3 = new ChannelsKt__Channels_commonKt$consumeEach$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$consumeEach$3.data;
        Throwable th22 = channelsKt__Channels_commonKt$consumeEach$3.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$consumeEach$3.getLabel();
        if (label == 0) {
        }
        channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
        broadcastChannel8 = broadcastChannel7;
        channelIterator3 = channelIterator4;
        channelsKt__Channels_commonKt$consumeEach$32.L$0 = broadcastChannel6;
        channelsKt__Channels_commonKt$consumeEach$32.L$1 = function23;
        channelsKt__Channels_commonKt$consumeEach$32.L$2 = broadcastChannel5;
        channelsKt__Channels_commonKt$consumeEach$32.L$3 = broadcastChannel8;
        channelsKt__Channels_commonKt$consumeEach$32.L$4 = receiveChannel2;
        channelsKt__Channels_commonKt$consumeEach$32.L$5 = receiveChannel3;
        channelsKt__Channels_commonKt$consumeEach$32.L$6 = channelIterator3;
        channelsKt__Channels_commonKt$consumeEach$32.setLabel(1);
        hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$consumeEach$32);
        if (hasNext == obj) {
        }
        return obj;
        ReceiveChannel.DefaultImpls.cancel$default(receiveChannel4, null, 1, null);
        throw th;
    }

    public static final Function1<Throwable, Unit> consumes(ReceiveChannel<?> receiveChannel) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        return new ChannelsKt__Channels_commonKt$consumes$1(receiveChannel);
    }

    public static final Function1<Throwable, Unit> consumesAll(ReceiveChannel<?>... receiveChannelArr) {
        Intrinsics.checkParameterIsNotNull(receiveChannelArr, "channels");
        return new ChannelsKt__Channels_commonKt$consumesAll$1(receiveChannelArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r2.cancel(r3);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    public static final <E, R> R consume(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Throwable th = null;
        R r = (R) function1.invoke(receiveChannel);
        InlineMarker.finallyStart(1);
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(1);
        return r;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e8 A[Catch:{ all -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6 A[Catch:{ all -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    public static final /* synthetic */ <E> Object consumeEach(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$7 channelsKt__Channels_commonKt$consumeEach$7;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function22;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th2;
        ChannelsKt__Channels_commonKt$consumeEach$7 channelsKt__Channels_commonKt$consumeEach$72;
        Object obj;
        ChannelIterator channelIterator2;
        Object obj2;
        Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function23;
        ReceiveChannel<? extends E> receiveChannel7;
        ReceiveChannel<? extends E> receiveChannel8;
        ReceiveChannel<? extends E> receiveChannel9;
        Throwable th3;
        ChannelsKt__Channels_commonKt$consumeEach$7 channelsKt__Channels_commonKt$consumeEach$73;
        ReceiveChannel<? extends E> receiveChannel10;
        ChannelIterator channelIterator3;
        ReceiveChannel<? extends E> receiveChannel11;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$7) {
            channelsKt__Channels_commonKt$consumeEach$7 = (ChannelsKt__Channels_commonKt$consumeEach$7) continuation;
            if ((channelsKt__Channels_commonKt$consumeEach$7.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEach$7.setLabel(channelsKt__Channels_commonKt$consumeEach$7.getLabel() - Integer.MIN_VALUE);
                Object obj3 = channelsKt__Channels_commonKt$consumeEach$7.data;
                Throwable th4 = channelsKt__Channels_commonKt$consumeEach$7.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$consumeEach$7.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$7.L$6;
                        receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$5;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$consumeEach$7.L$4;
                        ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$3;
                        ReceiveChannel<? extends E> receiveChannel13 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$2;
                        function22 = (Function2) channelsKt__Channels_commonKt$consumeEach$7.L$1;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$0;
                        if (th4 == null) {
                            receiveChannel11 = receiveChannel13;
                            th3 = th5;
                            channelsKt__Channels_commonKt$consumeEach$73 = channelsKt__Channels_commonKt$consumeEach$7;
                            receiveChannel2 = receiveChannel12;
                            channelIterator3 = channelIterator4;
                            if (!((Boolean) obj3).booleanValue()) {
                                channelsKt__Channels_commonKt$consumeEach$73.L$0 = receiveChannel5;
                                channelsKt__Channels_commonKt$consumeEach$73.L$1 = function22;
                                channelsKt__Channels_commonKt$consumeEach$73.L$2 = receiveChannel11;
                                channelsKt__Channels_commonKt$consumeEach$73.L$3 = receiveChannel2;
                                channelsKt__Channels_commonKt$consumeEach$73.L$4 = th3;
                                channelsKt__Channels_commonKt$consumeEach$73.L$5 = receiveChannel10;
                                channelsKt__Channels_commonKt$consumeEach$73.L$6 = channelIterator3;
                                channelsKt__Channels_commonKt$consumeEach$73.setLabel(2);
                                Object next = channelIterator3.next(channelsKt__Channels_commonKt$consumeEach$73);
                                if (next == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                channelIterator = channelIterator3;
                                receiveChannel4 = receiveChannel2;
                                obj = next;
                                receiveChannel3 = receiveChannel10;
                                receiveChannel6 = receiveChannel11;
                                channelsKt__Channels_commonKt$consumeEach$72 = channelsKt__Channels_commonKt$consumeEach$73;
                                th2 = th3;
                                channelsKt__Channels_commonKt$consumeEach$72.L$0 = receiveChannel5;
                                channelsKt__Channels_commonKt$consumeEach$72.L$1 = function22;
                                channelsKt__Channels_commonKt$consumeEach$72.L$2 = receiveChannel6;
                                channelsKt__Channels_commonKt$consumeEach$72.L$3 = receiveChannel4;
                                channelsKt__Channels_commonKt$consumeEach$72.L$4 = th2;
                                channelsKt__Channels_commonKt$consumeEach$72.L$5 = receiveChannel3;
                                channelsKt__Channels_commonKt$consumeEach$72.L$6 = channelIterator;
                                channelsKt__Channels_commonKt$consumeEach$72.L$7 = obj;
                                channelsKt__Channels_commonKt$consumeEach$72.L$8 = obj;
                                channelsKt__Channels_commonKt$consumeEach$72.setLabel(3);
                                if (function22.invoke(obj, channelsKt__Channels_commonKt$consumeEach$72) != coroutine_suspended) {
                                }
                                return coroutine_suspended;
                                return coroutine_suspended;
                            }
                            Unit unit = Unit.INSTANCE;
                            receiveChannel2.cancel(th3);
                            return unit;
                        }
                        throw th4;
                    } else if (label == 2) {
                        ChannelIterator<? extends E> channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$7.L$6;
                        ReceiveChannel<? extends E> receiveChannel14 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$5;
                        th2 = (Throwable) channelsKt__Channels_commonKt$consumeEach$7.L$4;
                        ReceiveChannel<? extends E> receiveChannel15 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$3;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$2;
                        function22 = (Function2) channelsKt__Channels_commonKt$consumeEach$7.L$1;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$0;
                        if (th4 == null) {
                            channelsKt__Channels_commonKt$consumeEach$72 = channelsKt__Channels_commonKt$consumeEach$7;
                            obj = obj3;
                            receiveChannel3 = receiveChannel14;
                            channelIterator = channelIterator5;
                            receiveChannel4 = receiveChannel15;
                            channelsKt__Channels_commonKt$consumeEach$72.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$consumeEach$72.L$1 = function22;
                            channelsKt__Channels_commonKt$consumeEach$72.L$2 = receiveChannel6;
                            channelsKt__Channels_commonKt$consumeEach$72.L$3 = receiveChannel4;
                            channelsKt__Channels_commonKt$consumeEach$72.L$4 = th2;
                            channelsKt__Channels_commonKt$consumeEach$72.L$5 = receiveChannel3;
                            channelsKt__Channels_commonKt$consumeEach$72.L$6 = channelIterator;
                            channelsKt__Channels_commonKt$consumeEach$72.L$7 = obj;
                            channelsKt__Channels_commonKt$consumeEach$72.L$8 = obj;
                            channelsKt__Channels_commonKt$consumeEach$72.setLabel(3);
                            if (function22.invoke(obj, channelsKt__Channels_commonKt$consumeEach$72) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel2 = receiveChannel4;
                            channelIterator2 = channelIterator;
                            obj2 = coroutine_suspended;
                            function23 = function22;
                            receiveChannel7 = receiveChannel5;
                            receiveChannel8 = receiveChannel3;
                            receiveChannel9 = receiveChannel6;
                            th3 = th2;
                            channelsKt__Channels_commonKt$consumeEach$73 = channelsKt__Channels_commonKt$consumeEach$72;
                            return coroutine_suspended;
                        }
                        try {
                            throw th4;
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel2 = receiveChannel15;
                        }
                    } else if (label == 3) {
                        Object obj4 = channelsKt__Channels_commonKt$consumeEach$7.L$8;
                        Object obj5 = channelsKt__Channels_commonKt$consumeEach$7.L$7;
                        ChannelIterator channelIterator6 = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$7.L$6;
                        ReceiveChannel<? extends E> receiveChannel16 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$5;
                        Throwable th7 = (Throwable) channelsKt__Channels_commonKt$consumeEach$7.L$4;
                        ReceiveChannel<? extends E> receiveChannel17 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$3;
                        ReceiveChannel<? extends E> receiveChannel18 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$2;
                        Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function24 = (Function2) channelsKt__Channels_commonKt$consumeEach$7.L$1;
                        ReceiveChannel<? extends E> receiveChannel19 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$7.L$0;
                        if (th4 == null) {
                            receiveChannel8 = receiveChannel16;
                            receiveChannel7 = receiveChannel19;
                            th3 = th7;
                            receiveChannel9 = receiveChannel18;
                            obj2 = coroutine_suspended;
                            function23 = function24;
                            channelsKt__Channels_commonKt$consumeEach$73 = channelsKt__Channels_commonKt$consumeEach$7;
                            receiveChannel2 = receiveChannel17;
                            channelIterator2 = channelIterator6;
                        } else {
                            try {
                                throw th4;
                            } catch (Throwable th8) {
                                th = th8;
                                receiveChannel2 = receiveChannel17;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th4 == null) {
                    try {
                        th3 = null;
                        channelsKt__Channels_commonKt$consumeEach$73 = channelsKt__Channels_commonKt$consumeEach$7;
                        obj2 = coroutine_suspended;
                        receiveChannel9 = receiveChannel;
                        receiveChannel2 = receiveChannel9;
                        function23 = function2;
                        receiveChannel7 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel8 = receiveChannel7;
                    } catch (Throwable th9) {
                        receiveChannel2 = receiveChannel;
                        th = th9;
                        try {
                            throw th;
                        } catch (Throwable th10) {
                            receiveChannel2.cancel(th);
                            throw th10;
                        }
                    }
                } else {
                    throw th4;
                }
                channelsKt__Channels_commonKt$consumeEach$73.L$0 = receiveChannel7;
                channelsKt__Channels_commonKt$consumeEach$73.L$1 = function23;
                channelsKt__Channels_commonKt$consumeEach$73.L$2 = receiveChannel9;
                channelsKt__Channels_commonKt$consumeEach$73.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$consumeEach$73.L$4 = th3;
                channelsKt__Channels_commonKt$consumeEach$73.L$5 = receiveChannel8;
                channelsKt__Channels_commonKt$consumeEach$73.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$consumeEach$73.setLabel(1);
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$consumeEach$73);
                if (hasNext != obj2) {
                    return obj2;
                }
                receiveChannel5 = receiveChannel7;
                receiveChannel10 = receiveChannel8;
                receiveChannel11 = receiveChannel9;
                obj3 = hasNext;
                function22 = function23;
                coroutine_suspended = obj2;
                channelIterator3 = channelIterator2;
                if (!((Boolean) obj3).booleanValue()) {
                    Unit unit2 = Unit.INSTANCE;
                    receiveChannel2.cancel(th3);
                }
                Unit unit22 = Unit.INSTANCE;
                receiveChannel2.cancel(th3);
                return unit22;
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$consumeEach$7 = new ChannelsKt__Channels_commonKt$consumeEach$7(continuation);
        Object obj32 = channelsKt__Channels_commonKt$consumeEach$7.data;
        Throwable th42 = channelsKt__Channels_commonKt$consumeEach$7.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$consumeEach$7.getLabel();
        if (label == 0) {
        }
        try {
            channelsKt__Channels_commonKt$consumeEach$73.L$0 = receiveChannel7;
            channelsKt__Channels_commonKt$consumeEach$73.L$1 = function23;
            channelsKt__Channels_commonKt$consumeEach$73.L$2 = receiveChannel9;
            channelsKt__Channels_commonKt$consumeEach$73.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$consumeEach$73.L$4 = th3;
            channelsKt__Channels_commonKt$consumeEach$73.L$5 = receiveChannel8;
            channelsKt__Channels_commonKt$consumeEach$73.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$consumeEach$73.setLabel(1);
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$consumeEach$73);
            if (hasNext != obj2) {
            }
            return obj2;
        } catch (Throwable th11) {
            th = th11;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3 A[Catch:{ all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d6 A[Catch:{ all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0036  */
    public static final <E> Object elementAt(ReceiveChannel<? extends E> receiveChannel, int i, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$elementAt$1 channelsKt__Channels_commonKt$elementAt$1;
        int label;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        int i2;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th3;
        ChannelsKt__Channels_commonKt$elementAt$1 channelsKt__Channels_commonKt$elementAt$12;
        int i3;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator channelIterator;
        ChannelIterator<? extends E> channelIterator2;
        Object obj;
        int i4;
        Throwable th4;
        int i5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        Object hasNext;
        ChannelIterator<? extends E> channelIterator3;
        if (continuation instanceof ChannelsKt__Channels_commonKt$elementAt$1) {
            channelsKt__Channels_commonKt$elementAt$1 = (ChannelsKt__Channels_commonKt$elementAt$1) continuation;
            if ((channelsKt__Channels_commonKt$elementAt$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$elementAt$1.setLabel(channelsKt__Channels_commonKt$elementAt$1.getLabel() - Integer.MIN_VALUE);
                Object obj2 = channelsKt__Channels_commonKt$elementAt$1.data;
                Throwable th5 = channelsKt__Channels_commonKt$elementAt$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$elementAt$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$elementAt$1.L$5;
                        i3 = channelsKt__Channels_commonKt$elementAt$1.I$1;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$4;
                        th3 = (Throwable) channelsKt__Channels_commonKt$elementAt$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$2;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$1;
                        i2 = channelsKt__Channels_commonKt$elementAt$1.I$0;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$0;
                        if (th5 == null) {
                            receiveChannel5 = receiveChannel8;
                            channelsKt__Channels_commonKt$elementAt$12 = channelsKt__Channels_commonKt$elementAt$1;
                            receiveChannel2 = receiveChannel9;
                            channelIterator = channelIterator4;
                            if (!((Boolean) obj2).booleanValue()) {
                                channelsKt__Channels_commonKt$elementAt$12.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$elementAt$12.I$0 = i2;
                                channelsKt__Channels_commonKt$elementAt$12.L$1 = receiveChannel4;
                                channelsKt__Channels_commonKt$elementAt$12.L$2 = receiveChannel2;
                                channelsKt__Channels_commonKt$elementAt$12.L$3 = th3;
                                channelsKt__Channels_commonKt$elementAt$12.L$4 = receiveChannel5;
                                channelsKt__Channels_commonKt$elementAt$12.I$1 = i3;
                                channelsKt__Channels_commonKt$elementAt$12.L$5 = channelIterator;
                                channelsKt__Channels_commonKt$elementAt$12.setLabel(2);
                                obj2 = channelIterator.next(channelsKt__Channels_commonKt$elementAt$12);
                                channelIterator3 = channelIterator;
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i2 + '.');
                        }
                        throw th5;
                    } else if (label == 2) {
                        ChannelIterator<? extends E> channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$elementAt$1.L$5;
                        i3 = channelsKt__Channels_commonKt$elementAt$1.I$1;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$4;
                        th3 = (Throwable) channelsKt__Channels_commonKt$elementAt$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$2;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$1;
                        i2 = channelsKt__Channels_commonKt$elementAt$1.I$0;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$0;
                        if (th5 == null) {
                            receiveChannel5 = receiveChannel10;
                            channelsKt__Channels_commonKt$elementAt$12 = channelsKt__Channels_commonKt$elementAt$1;
                            receiveChannel2 = receiveChannel11;
                            channelIterator3 = channelIterator5;
                        } else {
                            try {
                                throw th5;
                            } catch (Throwable th6) {
                                th = th6;
                                receiveChannel2 = receiveChannel11;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th5 == null) {
                    Throwable th7 = null;
                    if (i >= 0) {
                        try {
                            receiveChannel5 = receiveChannel;
                            channelsKt__Channels_commonKt$elementAt$12 = channelsKt__Channels_commonKt$elementAt$1;
                            obj = coroutine_suspended;
                            channelIterator2 = receiveChannel.iterator();
                            i4 = 0;
                            receiveChannel2 = receiveChannel5;
                            i5 = i;
                            th4 = th7;
                            receiveChannel7 = receiveChannel2;
                            receiveChannel6 = receiveChannel7;
                        } catch (Throwable th8) {
                            th2 = th8;
                            receiveChannel2 = receiveChannel;
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th9) {
                                receiveChannel2.cancel(th);
                                throw th9;
                            }
                        }
                        try {
                            channelsKt__Channels_commonKt$elementAt$12.L$0 = receiveChannel7;
                            channelsKt__Channels_commonKt$elementAt$12.I$0 = i5;
                            channelsKt__Channels_commonKt$elementAt$12.L$1 = receiveChannel6;
                            channelsKt__Channels_commonKt$elementAt$12.L$2 = receiveChannel2;
                            channelsKt__Channels_commonKt$elementAt$12.L$3 = th4;
                            channelsKt__Channels_commonKt$elementAt$12.L$4 = receiveChannel5;
                            channelsKt__Channels_commonKt$elementAt$12.I$1 = i4;
                            channelsKt__Channels_commonKt$elementAt$12.L$5 = channelIterator2;
                            channelsKt__Channels_commonKt$elementAt$12.setLabel(1);
                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$elementAt$12);
                            if (hasNext != obj) {
                                return obj;
                            }
                            receiveChannel3 = receiveChannel7;
                            channelIterator = channelIterator2;
                            receiveChannel4 = receiveChannel6;
                            obj2 = hasNext;
                            i2 = i5;
                            coroutine_suspended = obj;
                            th3 = th4;
                            i3 = i4;
                            if (!((Boolean) obj2).booleanValue()) {
                            }
                            throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i2 + '.');
                            return obj;
                        } catch (Throwable th10) {
                            th2 = th10;
                            th = th2;
                            throw th;
                        }
                    } else {
                        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                    }
                } else {
                    throw th5;
                }
                obj = coroutine_suspended;
                i5 = i2;
                receiveChannel7 = receiveChannel3;
                int i6 = i3 + 1;
                if (i5 != i3) {
                    receiveChannel2.cancel(th3);
                } else {
                    th4 = th3;
                    receiveChannel6 = receiveChannel4;
                    channelIterator2 = channelIterator3;
                    i4 = i6;
                    channelsKt__Channels_commonKt$elementAt$12.L$0 = receiveChannel7;
                    channelsKt__Channels_commonKt$elementAt$12.I$0 = i5;
                    channelsKt__Channels_commonKt$elementAt$12.L$1 = receiveChannel6;
                    channelsKt__Channels_commonKt$elementAt$12.L$2 = receiveChannel2;
                    channelsKt__Channels_commonKt$elementAt$12.L$3 = th4;
                    channelsKt__Channels_commonKt$elementAt$12.L$4 = receiveChannel5;
                    channelsKt__Channels_commonKt$elementAt$12.I$1 = i4;
                    channelsKt__Channels_commonKt$elementAt$12.L$5 = channelIterator2;
                    channelsKt__Channels_commonKt$elementAt$12.setLabel(1);
                    hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$elementAt$12);
                    if (hasNext != obj) {
                    }
                    return obj;
                }
                receiveChannel2.cancel(th3);
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$elementAt$1 = new ChannelsKt__Channels_commonKt$elementAt$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$elementAt$1.data;
        Throwable th52 = channelsKt__Channels_commonKt$elementAt$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$elementAt$1.getLabel();
        if (label == 0) {
        }
        obj = coroutine_suspended2;
        i5 = i2;
        receiveChannel7 = receiveChannel3;
        int i62 = i3 + 1;
        if (i5 != i3) {
        }
        receiveChannel2.cancel(th3);
        return obj22;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    public static final <E> Object elementAtOrNull(ReceiveChannel<? extends E> receiveChannel, int i, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$elementAtOrNull$1 channelsKt__Channels_commonKt$elementAtOrNull$1;
        int label;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        int i2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        int i3;
        ChannelIterator channelIterator;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th3;
        Object obj;
        ChannelsKt__Channels_commonKt$elementAtOrNull$1 channelsKt__Channels_commonKt$elementAtOrNull$12;
        int i4;
        ChannelIterator<? extends E> channelIterator2;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelIterator<? extends E> channelIterator3;
        int i5;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$elementAtOrNull$1) {
            channelsKt__Channels_commonKt$elementAtOrNull$1 = (ChannelsKt__Channels_commonKt$elementAtOrNull$1) continuation;
            if ((channelsKt__Channels_commonKt$elementAtOrNull$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$elementAtOrNull$1.setLabel(channelsKt__Channels_commonKt$elementAtOrNull$1.getLabel() - Integer.MIN_VALUE);
                Object obj2 = channelsKt__Channels_commonKt$elementAtOrNull$1.data;
                Throwable th4 = channelsKt__Channels_commonKt$elementAtOrNull$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$elementAtOrNull$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$elementAtOrNull$1.L$4;
                        i2 = channelsKt__Channels_commonKt$elementAtOrNull$1.I$1;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$3;
                        th2 = (Throwable) channelsKt__Channels_commonKt$elementAtOrNull$1.L$2;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$1;
                        i3 = channelsKt__Channels_commonKt$elementAtOrNull$1.I$0;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$0;
                        if (th4 == null) {
                            channelIterator = channelIterator4;
                            receiveChannel3 = receiveChannel8;
                            if (!((Boolean) obj2).booleanValue()) {
                                channelsKt__Channels_commonKt$elementAtOrNull$1.L$0 = receiveChannel4;
                                channelsKt__Channels_commonKt$elementAtOrNull$1.I$0 = i3;
                                channelsKt__Channels_commonKt$elementAtOrNull$1.L$1 = receiveChannel3;
                                channelsKt__Channels_commonKt$elementAtOrNull$1.L$2 = th2;
                                channelsKt__Channels_commonKt$elementAtOrNull$1.L$3 = receiveChannel5;
                                channelsKt__Channels_commonKt$elementAtOrNull$1.I$1 = i2;
                                channelsKt__Channels_commonKt$elementAtOrNull$1.L$4 = channelIterator;
                                channelsKt__Channels_commonKt$elementAtOrNull$1.setLabel(2);
                                obj2 = channelIterator.next(channelsKt__Channels_commonKt$elementAtOrNull$1);
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                th3 = th2;
                                obj = coroutine_suspended;
                                channelsKt__Channels_commonKt$elementAtOrNull$12 = channelsKt__Channels_commonKt$elementAtOrNull$1;
                                i4 = i3;
                                channelIterator2 = channelIterator;
                                receiveChannel6 = receiveChannel3;
                                return coroutine_suspended;
                            }
                            receiveChannel3.cancel(th2);
                            return null;
                        }
                        throw th4;
                    } else if (label == 2) {
                        ChannelIterator<? extends E> channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$elementAtOrNull$1.L$4;
                        i2 = channelsKt__Channels_commonKt$elementAtOrNull$1.I$1;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$3;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$elementAtOrNull$1.L$2;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$1;
                        int i6 = channelsKt__Channels_commonKt$elementAtOrNull$1.I$0;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$0;
                        if (th4 == null) {
                            th3 = th5;
                            obj = coroutine_suspended;
                            channelsKt__Channels_commonKt$elementAtOrNull$12 = channelsKt__Channels_commonKt$elementAtOrNull$1;
                            i4 = i6;
                            channelIterator2 = channelIterator5;
                        } else {
                            try {
                                throw th4;
                            } catch (Throwable th6) {
                                th = th6;
                                receiveChannel2 = receiveChannel6;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th4 == null) {
                    Throwable th7 = null;
                    if (i < 0) {
                        receiveChannel.cancel(th7);
                        return null;
                    }
                    try {
                        th3 = th7;
                        obj = coroutine_suspended;
                        channelIterator3 = receiveChannel.iterator();
                        i5 = 0;
                        receiveChannel7 = receiveChannel;
                        channelsKt__Channels_commonKt$elementAtOrNull$12 = channelsKt__Channels_commonKt$elementAtOrNull$1;
                        i4 = i;
                        receiveChannel2 = receiveChannel7;
                    } catch (Throwable th8) {
                        receiveChannel2 = receiveChannel;
                        th = th8;
                        try {
                            throw th;
                        } catch (Throwable th9) {
                            receiveChannel2.cancel(th);
                            throw th9;
                        }
                    }
                    try {
                        channelsKt__Channels_commonKt$elementAtOrNull$12.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.I$0 = i4;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.L$1 = receiveChannel2;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.L$2 = th3;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.L$3 = receiveChannel7;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.I$1 = i5;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.L$4 = channelIterator3;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.setLabel(1);
                        hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$elementAtOrNull$12);
                        if (hasNext != obj) {
                            return obj;
                        }
                        receiveChannel4 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        i2 = i5;
                        receiveChannel5 = receiveChannel7;
                        obj2 = hasNext;
                        i3 = i4;
                        channelsKt__Channels_commonKt$elementAtOrNull$1 = channelsKt__Channels_commonKt$elementAtOrNull$12;
                        coroutine_suspended = obj;
                        th2 = th3;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj2).booleanValue()) {
                            receiveChannel3.cancel(th2);
                        }
                        receiveChannel3.cancel(th2);
                        return null;
                        return obj;
                    } catch (Throwable th10) {
                        th = th10;
                        throw th;
                    }
                } else {
                    throw th4;
                }
                receiveChannel = receiveChannel4;
                int i7 = i2 + 1;
                if (i4 != i2) {
                    receiveChannel6.cancel(th3);
                } else {
                    receiveChannel7 = receiveChannel5;
                    receiveChannel2 = receiveChannel6;
                    channelIterator3 = channelIterator2;
                    i5 = i7;
                    channelsKt__Channels_commonKt$elementAtOrNull$12.L$0 = receiveChannel;
                    channelsKt__Channels_commonKt$elementAtOrNull$12.I$0 = i4;
                    channelsKt__Channels_commonKt$elementAtOrNull$12.L$1 = receiveChannel2;
                    channelsKt__Channels_commonKt$elementAtOrNull$12.L$2 = th3;
                    channelsKt__Channels_commonKt$elementAtOrNull$12.L$3 = receiveChannel7;
                    channelsKt__Channels_commonKt$elementAtOrNull$12.I$1 = i5;
                    channelsKt__Channels_commonKt$elementAtOrNull$12.L$4 = channelIterator3;
                    channelsKt__Channels_commonKt$elementAtOrNull$12.setLabel(1);
                    hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$elementAtOrNull$12);
                    if (hasNext != obj) {
                    }
                    return obj;
                }
                receiveChannel6.cancel(th3);
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$elementAtOrNull$1 = new ChannelsKt__Channels_commonKt$elementAtOrNull$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$elementAtOrNull$1.data;
        Throwable th42 = channelsKt__Channels_commonKt$elementAtOrNull$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$elementAtOrNull$1.getLabel();
        if (label == 0) {
        }
        receiveChannel = receiveChannel4;
        int i72 = i2 + 1;
        if (i4 != i2) {
        }
        receiveChannel6.cancel(th3);
        return obj22;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    public static final <E> Object first(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$first$1 channelsKt__Channels_commonKt$first$1;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Object obj;
        if (continuation instanceof ChannelsKt__Channels_commonKt$first$1) {
            channelsKt__Channels_commonKt$first$1 = (ChannelsKt__Channels_commonKt$first$1) continuation;
            if ((channelsKt__Channels_commonKt$first$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$first$1.setLabel(channelsKt__Channels_commonKt$first$1.getLabel() - Integer.MIN_VALUE);
                Object obj2 = channelsKt__Channels_commonKt$first$1.data;
                Throwable th4 = channelsKt__Channels_commonKt$first$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$first$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$first$1.L$4;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$3;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$first$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$1;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$0;
                        if (th4 == null) {
                            obj = obj2;
                            th3 = th5;
                        } else {
                            try {
                                throw th4;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        }
                    } else if (label == 2) {
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$first$1.L$4;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$3;
                        th2 = (Throwable) channelsKt__Channels_commonKt$first$1.L$2;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$1;
                        ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$0;
                        if (th4 != null) {
                            try {
                                throw th4;
                            } catch (Throwable th7) {
                                th = th7;
                                receiveChannel2 = receiveChannel3;
                            }
                        }
                        receiveChannel3.cancel(th2);
                        return obj2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th4 == null) {
                    th3 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$first$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$first$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$first$1.L$2 = th3;
                        channelsKt__Channels_commonKt$first$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$first$1.L$4 = it;
                        channelsKt__Channels_commonKt$first$1.setLabel(1);
                        Object hasNext = it.hasNext(channelsKt__Channels_commonKt$first$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel4 = receiveChannel2;
                        channelIterator = it;
                        obj = hasNext;
                        receiveChannel5 = receiveChannel4;
                    } catch (Throwable th8) {
                        receiveChannel2 = receiveChannel;
                        th = th8;
                        try {
                            throw th;
                        } catch (Throwable th9) {
                            receiveChannel2.cancel(th);
                            throw th9;
                        }
                    }
                } else {
                    throw th4;
                }
                if (!((Boolean) obj).booleanValue()) {
                    channelsKt__Channels_commonKt$first$1.L$0 = receiveChannel4;
                    channelsKt__Channels_commonKt$first$1.L$1 = receiveChannel2;
                    channelsKt__Channels_commonKt$first$1.L$2 = th3;
                    channelsKt__Channels_commonKt$first$1.L$3 = receiveChannel5;
                    channelsKt__Channels_commonKt$first$1.L$4 = channelIterator;
                    channelsKt__Channels_commonKt$first$1.setLabel(2);
                    Object next = channelIterator.next(channelsKt__Channels_commonKt$first$1);
                    if (next == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    receiveChannel3 = receiveChannel2;
                    obj2 = next;
                    th2 = th3;
                    receiveChannel3.cancel(th2);
                    return obj2;
                }
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
        }
        channelsKt__Channels_commonKt$first$1 = new ChannelsKt__Channels_commonKt$first$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$first$1.data;
        Throwable th42 = channelsKt__Channels_commonKt$first$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$first$1.getLabel();
        if (label == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    public static final <E> Object firstOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$firstOrNull$1 channelsKt__Channels_commonKt$firstOrNull$1;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Object obj;
        if (continuation instanceof ChannelsKt__Channels_commonKt$firstOrNull$1) {
            channelsKt__Channels_commonKt$firstOrNull$1 = (ChannelsKt__Channels_commonKt$firstOrNull$1) continuation;
            if ((channelsKt__Channels_commonKt$firstOrNull$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$firstOrNull$1.setLabel(channelsKt__Channels_commonKt$firstOrNull$1.getLabel() - Integer.MIN_VALUE);
                Object obj2 = channelsKt__Channels_commonKt$firstOrNull$1.data;
                Throwable th4 = channelsKt__Channels_commonKt$firstOrNull$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$firstOrNull$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$firstOrNull$1.L$4;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$3;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$firstOrNull$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$1;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$0;
                        if (th4 == null) {
                            obj = obj2;
                            th3 = th5;
                        } else {
                            try {
                                throw th4;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        }
                    } else if (label == 2) {
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$firstOrNull$1.L$4;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$3;
                        th2 = (Throwable) channelsKt__Channels_commonKt$firstOrNull$1.L$2;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$1;
                        ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$0;
                        if (th4 != null) {
                            try {
                                throw th4;
                            } catch (Throwable th7) {
                                th = th7;
                                receiveChannel2 = receiveChannel3;
                            }
                        }
                        receiveChannel3.cancel(th2);
                        return obj2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th4 == null) {
                    th3 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$firstOrNull$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$2 = th3;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$4 = it;
                        channelsKt__Channels_commonKt$firstOrNull$1.setLabel(1);
                        Object hasNext = it.hasNext(channelsKt__Channels_commonKt$firstOrNull$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel4 = receiveChannel2;
                        channelIterator = it;
                        obj = hasNext;
                        receiveChannel5 = receiveChannel4;
                    } catch (Throwable th8) {
                        receiveChannel2 = receiveChannel;
                        th = th8;
                        try {
                            throw th;
                        } catch (Throwable th9) {
                            receiveChannel2.cancel(th);
                            throw th9;
                        }
                    }
                } else {
                    throw th4;
                }
                if (((Boolean) obj).booleanValue()) {
                    receiveChannel2.cancel(th3);
                    return null;
                }
                channelsKt__Channels_commonKt$firstOrNull$1.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$firstOrNull$1.L$1 = receiveChannel2;
                channelsKt__Channels_commonKt$firstOrNull$1.L$2 = th3;
                channelsKt__Channels_commonKt$firstOrNull$1.L$3 = receiveChannel5;
                channelsKt__Channels_commonKt$firstOrNull$1.L$4 = channelIterator;
                channelsKt__Channels_commonKt$firstOrNull$1.setLabel(2);
                Object next = channelIterator.next(channelsKt__Channels_commonKt$firstOrNull$1);
                if (next == coroutine_suspended) {
                    return coroutine_suspended;
                }
                receiveChannel3 = receiveChannel2;
                obj2 = next;
                th2 = th3;
                receiveChannel3.cancel(th2);
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$firstOrNull$1 = new ChannelsKt__Channels_commonKt$firstOrNull$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$firstOrNull$1.data;
        Throwable th42 = channelsKt__Channels_commonKt$firstOrNull$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$firstOrNull$1.getLabel();
        if (label == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c5 A[Catch:{ all -> 0x0113 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d7 A[Catch:{ all -> 0x0113 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    public static final <E> Object indexOf(ReceiveChannel<? extends E> receiveChannel, E e, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$indexOf$1 channelsKt__Channels_commonKt$indexOf$1;
        Object obj;
        int label;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Object obj2;
        Ref.IntRef intRef;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator channelIterator;
        ChannelIterator<? extends E> channelIterator2;
        Object obj3;
        Throwable th4;
        ChannelsKt__Channels_commonKt$indexOf$1 channelsKt__Channels_commonKt$indexOf$12;
        Ref.IntRef intRef2;
        Object obj4;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ReceiveChannel<? extends E> receiveChannel8;
        Object hasNext;
        Object obj5;
        ChannelIterator<? extends E> channelIterator3;
        if (continuation instanceof ChannelsKt__Channels_commonKt$indexOf$1) {
            channelsKt__Channels_commonKt$indexOf$1 = (ChannelsKt__Channels_commonKt$indexOf$1) continuation;
            if ((channelsKt__Channels_commonKt$indexOf$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$indexOf$1.setLabel(channelsKt__Channels_commonKt$indexOf$1.getLabel() - Integer.MIN_VALUE);
                obj = channelsKt__Channels_commonKt$indexOf$1.data;
                Throwable th5 = channelsKt__Channels_commonKt$indexOf$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$indexOf$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$indexOf$1.L$7;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$6;
                        th3 = (Throwable) channelsKt__Channels_commonKt$indexOf$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$4;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$3;
                        intRef = (Ref.IntRef) channelsKt__Channels_commonKt$indexOf$1.L$2;
                        Object obj6 = channelsKt__Channels_commonKt$indexOf$1.L$1;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$0;
                        if (th5 == null) {
                            receiveChannel2 = receiveChannel9;
                            channelIterator = channelIterator4;
                            obj2 = obj6;
                            if (!((Boolean) obj).booleanValue()) {
                                channelsKt__Channels_commonKt$indexOf$1.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$indexOf$1.L$1 = obj2;
                                channelsKt__Channels_commonKt$indexOf$1.L$2 = intRef;
                                channelsKt__Channels_commonKt$indexOf$1.L$3 = receiveChannel4;
                                channelsKt__Channels_commonKt$indexOf$1.L$4 = receiveChannel2;
                                channelsKt__Channels_commonKt$indexOf$1.L$5 = th3;
                                channelsKt__Channels_commonKt$indexOf$1.L$6 = receiveChannel5;
                                channelsKt__Channels_commonKt$indexOf$1.L$7 = channelIterator;
                                channelsKt__Channels_commonKt$indexOf$1.setLabel(2);
                                obj = channelIterator.next(channelsKt__Channels_commonKt$indexOf$1);
                                channelIterator3 = channelIterator;
                                obj5 = obj2;
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                            receiveChannel2.cancel(th3);
                            return -1;
                        }
                        throw th5;
                    } else if (label == 2) {
                        ChannelIterator<? extends E> channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$indexOf$1.L$7;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$6;
                        th3 = (Throwable) channelsKt__Channels_commonKt$indexOf$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$4;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$3;
                        intRef = (Ref.IntRef) channelsKt__Channels_commonKt$indexOf$1.L$2;
                        Object obj7 = channelsKt__Channels_commonKt$indexOf$1.L$1;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$0;
                        if (th5 == null) {
                            receiveChannel2 = receiveChannel10;
                            channelIterator3 = channelIterator5;
                            obj5 = obj7;
                        } else {
                            try {
                                throw th5;
                            } catch (Throwable th6) {
                                th = th6;
                                receiveChannel2 = receiveChannel10;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th5 == null) {
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = 0;
                    try {
                        intRef2 = intRef3;
                        channelsKt__Channels_commonKt$indexOf$12 = channelsKt__Channels_commonKt$indexOf$1;
                        th4 = null;
                        obj3 = coroutine_suspended;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel8 = receiveChannel;
                        receiveChannel7 = receiveChannel8;
                        receiveChannel2 = receiveChannel7;
                        receiveChannel6 = receiveChannel2;
                        obj4 = e;
                    } catch (Throwable th7) {
                        th2 = th7;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th8) {
                            receiveChannel2.cancel(th);
                            throw th8;
                        }
                    }
                    try {
                        channelsKt__Channels_commonKt$indexOf$12.L$0 = receiveChannel8;
                        channelsKt__Channels_commonKt$indexOf$12.L$1 = obj4;
                        channelsKt__Channels_commonKt$indexOf$12.L$2 = intRef2;
                        channelsKt__Channels_commonKt$indexOf$12.L$3 = receiveChannel7;
                        channelsKt__Channels_commonKt$indexOf$12.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$indexOf$12.L$5 = th4;
                        channelsKt__Channels_commonKt$indexOf$12.L$6 = receiveChannel6;
                        channelsKt__Channels_commonKt$indexOf$12.L$7 = channelIterator2;
                        channelsKt__Channels_commonKt$indexOf$12.setLabel(1);
                        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$indexOf$12);
                        if (hasNext != obj3) {
                            return obj3;
                        }
                        receiveChannel3 = receiveChannel8;
                        obj = hasNext;
                        obj2 = obj4;
                        channelIterator = channelIterator2;
                        intRef = intRef2;
                        receiveChannel5 = receiveChannel6;
                        coroutine_suspended = obj3;
                        receiveChannel4 = receiveChannel7;
                        channelsKt__Channels_commonKt$indexOf$1 = channelsKt__Channels_commonKt$indexOf$12;
                        th3 = th4;
                        if (!((Boolean) obj).booleanValue()) {
                            Unit unit2 = Unit.INSTANCE;
                            receiveChannel2.cancel(th3);
                        }
                        Unit unit22 = Unit.INSTANCE;
                        receiveChannel2.cancel(th3);
                        return -1;
                        return obj3;
                    } catch (Throwable th9) {
                        th2 = th9;
                        th = th2;
                        throw th;
                    }
                } else {
                    throw th5;
                }
                th4 = th3;
                channelsKt__Channels_commonKt$indexOf$12 = channelsKt__Channels_commonKt$indexOf$1;
                receiveChannel7 = receiveChannel4;
                obj3 = coroutine_suspended;
                receiveChannel6 = receiveChannel5;
                intRef2 = intRef;
                channelIterator2 = channelIterator3;
                obj4 = obj5;
                if (!Intrinsics.areEqual(obj4, obj)) {
                    Integer valueOf = Integer.valueOf(intRef2.element);
                } else {
                    intRef2.element++;
                    receiveChannel8 = receiveChannel3;
                    channelsKt__Channels_commonKt$indexOf$12.L$0 = receiveChannel8;
                    channelsKt__Channels_commonKt$indexOf$12.L$1 = obj4;
                    channelsKt__Channels_commonKt$indexOf$12.L$2 = intRef2;
                    channelsKt__Channels_commonKt$indexOf$12.L$3 = receiveChannel7;
                    channelsKt__Channels_commonKt$indexOf$12.L$4 = receiveChannel2;
                    channelsKt__Channels_commonKt$indexOf$12.L$5 = th4;
                    channelsKt__Channels_commonKt$indexOf$12.L$6 = receiveChannel6;
                    channelsKt__Channels_commonKt$indexOf$12.L$7 = channelIterator2;
                    channelsKt__Channels_commonKt$indexOf$12.setLabel(1);
                    hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$indexOf$12);
                    if (hasNext != obj3) {
                    }
                    return obj3;
                }
                Integer valueOf2 = Integer.valueOf(intRef2.element);
                receiveChannel2.cancel(th4);
                return valueOf2;
            }
        }
        channelsKt__Channels_commonKt$indexOf$1 = new ChannelsKt__Channels_commonKt$indexOf$1(continuation);
        obj = channelsKt__Channels_commonKt$indexOf$1.data;
        Throwable th52 = channelsKt__Channels_commonKt$indexOf$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$indexOf$1.getLabel();
        if (label == 0) {
        }
        th4 = th3;
        channelsKt__Channels_commonKt$indexOf$12 = channelsKt__Channels_commonKt$indexOf$1;
        receiveChannel7 = receiveChannel4;
        obj3 = coroutine_suspended2;
        receiveChannel6 = receiveChannel5;
        intRef2 = intRef;
        channelIterator2 = channelIterator3;
        obj4 = obj5;
        if (!Intrinsics.areEqual(obj4, obj)) {
        }
        Integer valueOf22 = Integer.valueOf(intRef2.element);
        receiveChannel2.cancel(th4);
        return valueOf22;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    public static final <E> Object last(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$last$1 channelsKt__Channels_commonKt$last$1;
        Object obj;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator channelIterator;
        Throwable th2;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th3;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        Throwable th4;
        if (continuation instanceof ChannelsKt__Channels_commonKt$last$1) {
            channelsKt__Channels_commonKt$last$1 = (ChannelsKt__Channels_commonKt$last$1) continuation;
            if ((channelsKt__Channels_commonKt$last$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$last$1.setLabel(channelsKt__Channels_commonKt$last$1.getLabel() - Integer.MIN_VALUE);
                obj = channelsKt__Channels_commonKt$last$1.data;
                Throwable th5 = channelsKt__Channels_commonKt$last$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$last$1.getLabel();
                if (label == 0) {
                    if (label != 1) {
                        if (label == 2) {
                            channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$last$1.L$4;
                            receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$3;
                            th3 = (Throwable) channelsKt__Channels_commonKt$last$1.L$2;
                            receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$1;
                            receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$0;
                            if (th5 != null) {
                                throw th5;
                            }
                        } else if (label == 3) {
                            obj2 = channelsKt__Channels_commonKt$last$1.L$5;
                            channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$last$1.L$4;
                            receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$3;
                            Throwable th6 = (Throwable) channelsKt__Channels_commonKt$last$1.L$2;
                            ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$1;
                            ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$0;
                            if (th5 == null) {
                                th2 = th6;
                                receiveChannel2 = receiveChannel8;
                                receiveChannel3 = receiveChannel9;
                                if (!((Boolean) obj).booleanValue()) {
                                    channelsKt__Channels_commonKt$last$1.L$0 = receiveChannel3;
                                    channelsKt__Channels_commonKt$last$1.L$1 = receiveChannel2;
                                    channelsKt__Channels_commonKt$last$1.L$2 = th2;
                                    channelsKt__Channels_commonKt$last$1.L$3 = receiveChannel4;
                                    channelsKt__Channels_commonKt$last$1.L$4 = channelIterator;
                                    channelsKt__Channels_commonKt$last$1.L$5 = obj2;
                                    channelsKt__Channels_commonKt$last$1.setLabel(4);
                                    obj = channelIterator.next(channelsKt__Channels_commonKt$last$1);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    channelIterator2 = channelIterator;
                                    receiveChannel5 = receiveChannel4;
                                    th3 = th2;
                                    return coroutine_suspended;
                                }
                                receiveChannel2.cancel(th2);
                                return obj2;
                            }
                            try {
                                throw th5;
                            } catch (Throwable th7) {
                                th = th7;
                                receiveChannel2 = receiveChannel8;
                            }
                        } else if (label == 4) {
                            Object obj3 = channelsKt__Channels_commonKt$last$1.L$5;
                            channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$last$1.L$4;
                            receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$3;
                            th3 = (Throwable) channelsKt__Channels_commonKt$last$1.L$2;
                            receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$1;
                            receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$0;
                            if (th5 != null) {
                                try {
                                    throw th5;
                                } catch (Throwable th8) {
                                    th = th8;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        channelsKt__Channels_commonKt$last$1.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$last$1.L$1 = receiveChannel2;
                        channelsKt__Channels_commonKt$last$1.L$2 = th3;
                        channelsKt__Channels_commonKt$last$1.L$3 = receiveChannel5;
                        channelsKt__Channels_commonKt$last$1.L$4 = channelIterator2;
                        channelsKt__Channels_commonKt$last$1.L$5 = obj;
                        channelsKt__Channels_commonKt$last$1.setLabel(3);
                        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$last$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelIterator = channelIterator2;
                        obj2 = obj;
                        obj = hasNext;
                        th2 = th3;
                        receiveChannel4 = receiveChannel5;
                        if (!((Boolean) obj).booleanValue()) {
                            receiveChannel2.cancel(th2);
                        }
                        receiveChannel2.cancel(th2);
                        return obj2;
                        return coroutine_suspended;
                    }
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$last$1.L$4;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$3;
                    th4 = (Throwable) channelsKt__Channels_commonKt$last$1.L$2;
                    receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$1;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$0;
                    if (th5 != null) {
                        throw th5;
                    }
                } else if (th5 == null) {
                    Throwable th9 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$last$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$last$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$last$1.L$2 = th9;
                        channelsKt__Channels_commonKt$last$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$last$1.L$4 = it;
                        channelsKt__Channels_commonKt$last$1.setLabel(1);
                        Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$last$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel7 = receiveChannel;
                        receiveChannel6 = receiveChannel7;
                        th4 = th9;
                        obj = hasNext2;
                        receiveChannel5 = receiveChannel6;
                        channelIterator2 = it;
                    } catch (Throwable th10) {
                        receiveChannel2 = receiveChannel;
                        th = th10;
                        try {
                            throw th;
                        } catch (Throwable th11) {
                            receiveChannel2.cancel(th);
                            throw th11;
                        }
                    }
                } else {
                    throw th5;
                }
                if (!((Boolean) obj).booleanValue()) {
                    channelsKt__Channels_commonKt$last$1.L$0 = receiveChannel6;
                    channelsKt__Channels_commonKt$last$1.L$1 = receiveChannel7;
                    channelsKt__Channels_commonKt$last$1.L$2 = th4;
                    channelsKt__Channels_commonKt$last$1.L$3 = receiveChannel5;
                    channelsKt__Channels_commonKt$last$1.L$4 = channelIterator2;
                    channelsKt__Channels_commonKt$last$1.setLabel(2);
                    obj = channelIterator2.next(channelsKt__Channels_commonKt$last$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    th3 = th4;
                    receiveChannel2 = receiveChannel7;
                    receiveChannel3 = receiveChannel6;
                    channelsKt__Channels_commonKt$last$1.L$0 = receiveChannel3;
                    channelsKt__Channels_commonKt$last$1.L$1 = receiveChannel2;
                    channelsKt__Channels_commonKt$last$1.L$2 = th3;
                    channelsKt__Channels_commonKt$last$1.L$3 = receiveChannel5;
                    channelsKt__Channels_commonKt$last$1.L$4 = channelIterator2;
                    channelsKt__Channels_commonKt$last$1.L$5 = obj;
                    channelsKt__Channels_commonKt$last$1.setLabel(3);
                    hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$last$1);
                    if (hasNext != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
        }
        channelsKt__Channels_commonKt$last$1 = new ChannelsKt__Channels_commonKt$last$1(continuation);
        obj = channelsKt__Channels_commonKt$last$1.data;
        Throwable th52 = channelsKt__Channels_commonKt$last$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$last$1.getLabel();
        if (label == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00da A[Catch:{ all -> 0x0127 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00db A[Catch:{ all -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ee A[Catch:{ all -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0110 A[Catch:{ all -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    public static final <E> Object lastIndexOf(ReceiveChannel<? extends E> receiveChannel, E e, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$lastIndexOf$1 channelsKt__Channels_commonKt$lastIndexOf$1;
        Object obj;
        int label;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Object obj2;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator channelIterator;
        ChannelIterator<? extends E> channelIterator2;
        Throwable th4;
        Object obj3;
        Ref.IntRef intRef3;
        ChannelsKt__Channels_commonKt$lastIndexOf$1 channelsKt__Channels_commonKt$lastIndexOf$12;
        Ref.IntRef intRef4;
        Object obj4;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ReceiveChannel<? extends E> receiveChannel8;
        Object hasNext;
        Object obj5;
        ChannelIterator<? extends E> channelIterator3;
        if (continuation instanceof ChannelsKt__Channels_commonKt$lastIndexOf$1) {
            channelsKt__Channels_commonKt$lastIndexOf$1 = (ChannelsKt__Channels_commonKt$lastIndexOf$1) continuation;
            if ((channelsKt__Channels_commonKt$lastIndexOf$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$lastIndexOf$1.setLabel(channelsKt__Channels_commonKt$lastIndexOf$1.getLabel() - Integer.MIN_VALUE);
                obj = channelsKt__Channels_commonKt$lastIndexOf$1.data;
                Throwable th5 = channelsKt__Channels_commonKt$lastIndexOf$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$lastIndexOf$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$lastIndexOf$1.L$8;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$7;
                        th3 = (Throwable) channelsKt__Channels_commonKt$lastIndexOf$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$5;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$4;
                        intRef2 = (Ref.IntRef) channelsKt__Channels_commonKt$lastIndexOf$1.L$3;
                        intRef = (Ref.IntRef) channelsKt__Channels_commonKt$lastIndexOf$1.L$2;
                        Object obj6 = channelsKt__Channels_commonKt$lastIndexOf$1.L$1;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$0;
                        if (th5 == null) {
                            receiveChannel2 = receiveChannel9;
                            channelIterator = channelIterator4;
                            obj2 = obj6;
                            if (!((Boolean) obj).booleanValue()) {
                                channelsKt__Channels_commonKt$lastIndexOf$1.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$lastIndexOf$1.L$1 = obj2;
                                channelsKt__Channels_commonKt$lastIndexOf$1.L$2 = intRef;
                                channelsKt__Channels_commonKt$lastIndexOf$1.L$3 = intRef2;
                                channelsKt__Channels_commonKt$lastIndexOf$1.L$4 = receiveChannel4;
                                channelsKt__Channels_commonKt$lastIndexOf$1.L$5 = receiveChannel2;
                                channelsKt__Channels_commonKt$lastIndexOf$1.L$6 = th3;
                                channelsKt__Channels_commonKt$lastIndexOf$1.L$7 = receiveChannel5;
                                channelsKt__Channels_commonKt$lastIndexOf$1.L$8 = channelIterator;
                                channelsKt__Channels_commonKt$lastIndexOf$1.setLabel(2);
                                obj = channelIterator.next(channelsKt__Channels_commonKt$lastIndexOf$1);
                                channelIterator3 = channelIterator;
                                obj5 = obj2;
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                            receiveChannel2.cancel(th3);
                            return Integer.valueOf(intRef.element);
                        }
                        throw th5;
                    } else if (label == 2) {
                        ChannelIterator<? extends E> channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$lastIndexOf$1.L$8;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$7;
                        th3 = (Throwable) channelsKt__Channels_commonKt$lastIndexOf$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$5;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$4;
                        intRef2 = (Ref.IntRef) channelsKt__Channels_commonKt$lastIndexOf$1.L$3;
                        intRef = (Ref.IntRef) channelsKt__Channels_commonKt$lastIndexOf$1.L$2;
                        Object obj7 = channelsKt__Channels_commonKt$lastIndexOf$1.L$1;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$0;
                        if (th5 == null) {
                            receiveChannel2 = receiveChannel10;
                            channelIterator3 = channelIterator5;
                            obj5 = obj7;
                        } else {
                            try {
                                throw th5;
                            } catch (Throwable th6) {
                                th = th6;
                                receiveChannel2 = receiveChannel10;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th5 == null) {
                    Ref.IntRef intRef5 = new Ref.IntRef();
                    intRef5.element = -1;
                    Ref.IntRef intRef6 = new Ref.IntRef();
                    intRef6.element = 0;
                    try {
                        channelsKt__Channels_commonKt$lastIndexOf$12 = channelsKt__Channels_commonKt$lastIndexOf$1;
                        intRef3 = intRef6;
                        obj3 = coroutine_suspended;
                        th4 = null;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel7 = receiveChannel;
                        receiveChannel2 = receiveChannel7;
                        receiveChannel6 = receiveChannel2;
                        obj4 = e;
                        intRef4 = intRef5;
                        receiveChannel8 = receiveChannel6;
                        channelsKt__Channels_commonKt$lastIndexOf$12.L$0 = receiveChannel8;
                        channelsKt__Channels_commonKt$lastIndexOf$12.L$1 = obj4;
                        channelsKt__Channels_commonKt$lastIndexOf$12.L$2 = intRef4;
                        channelsKt__Channels_commonKt$lastIndexOf$12.L$3 = intRef3;
                        channelsKt__Channels_commonKt$lastIndexOf$12.L$4 = receiveChannel7;
                        channelsKt__Channels_commonKt$lastIndexOf$12.L$5 = receiveChannel2;
                        channelsKt__Channels_commonKt$lastIndexOf$12.L$6 = th4;
                        channelsKt__Channels_commonKt$lastIndexOf$12.L$7 = receiveChannel6;
                        channelsKt__Channels_commonKt$lastIndexOf$12.L$8 = channelIterator2;
                        channelsKt__Channels_commonKt$lastIndexOf$12.setLabel(1);
                        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$lastIndexOf$12);
                        if (hasNext == obj3) {
                            return obj3;
                        }
                        receiveChannel3 = receiveChannel8;
                        obj = hasNext;
                        obj2 = obj4;
                        channelIterator = channelIterator2;
                        intRef = intRef4;
                        receiveChannel5 = receiveChannel6;
                        coroutine_suspended = obj3;
                        receiveChannel4 = receiveChannel7;
                        channelsKt__Channels_commonKt$lastIndexOf$1 = channelsKt__Channels_commonKt$lastIndexOf$12;
                        th3 = th4;
                        intRef2 = intRef3;
                        if (!((Boolean) obj).booleanValue()) {
                            Unit unit2 = Unit.INSTANCE;
                        }
                        Unit unit22 = Unit.INSTANCE;
                        receiveChannel2.cancel(th3);
                        return Integer.valueOf(intRef.element);
                        return obj3;
                    } catch (Throwable th7) {
                        th2 = th7;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th8) {
                            receiveChannel2.cancel(th);
                            throw th8;
                        }
                    }
                } else {
                    throw th5;
                }
                intRef3 = intRef2;
                th4 = th3;
                channelsKt__Channels_commonKt$lastIndexOf$12 = channelsKt__Channels_commonKt$lastIndexOf$1;
                receiveChannel7 = receiveChannel4;
                obj3 = coroutine_suspended;
                receiveChannel6 = receiveChannel5;
                intRef4 = intRef;
                channelIterator2 = channelIterator3;
                obj4 = obj5;
                if (Intrinsics.areEqual(obj4, obj)) {
                    intRef4.element = intRef3.element;
                }
                intRef3.element++;
                receiveChannel8 = receiveChannel3;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$0 = receiveChannel8;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$1 = obj4;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$2 = intRef4;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$3 = intRef3;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$4 = receiveChannel7;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$6 = th4;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$7 = receiveChannel6;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$lastIndexOf$12.setLabel(1);
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$lastIndexOf$12);
                if (hasNext == obj3) {
                }
                return obj3;
            }
        }
        channelsKt__Channels_commonKt$lastIndexOf$1 = new ChannelsKt__Channels_commonKt$lastIndexOf$1(continuation);
        obj = channelsKt__Channels_commonKt$lastIndexOf$1.data;
        Throwable th52 = channelsKt__Channels_commonKt$lastIndexOf$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$lastIndexOf$1.getLabel();
        if (label == 0) {
        }
        try {
            intRef3 = intRef2;
            th4 = th3;
            channelsKt__Channels_commonKt$lastIndexOf$12 = channelsKt__Channels_commonKt$lastIndexOf$1;
            receiveChannel7 = receiveChannel4;
            obj3 = coroutine_suspended2;
            receiveChannel6 = receiveChannel5;
            intRef4 = intRef;
            channelIterator2 = channelIterator3;
            obj4 = obj5;
            if (Intrinsics.areEqual(obj4, obj)) {
            }
            channelsKt__Channels_commonKt$lastIndexOf$12.L$0 = receiveChannel8;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$1 = obj4;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$2 = intRef4;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$3 = intRef3;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$4 = receiveChannel7;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$6 = th4;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$7 = receiveChannel6;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$lastIndexOf$12.setLabel(1);
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$lastIndexOf$12);
            if (hasNext == obj3) {
            }
            return obj3;
        } catch (Throwable th9) {
            th2 = th9;
            th = th2;
            throw th;
        }
        intRef3.element++;
        receiveChannel8 = receiveChannel3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    public static final <E> Object lastOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$lastOrNull$1 channelsKt__Channels_commonKt$lastOrNull$1;
        Object obj;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator channelIterator;
        Throwable th2;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th3;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        Throwable th4;
        if (continuation instanceof ChannelsKt__Channels_commonKt$lastOrNull$1) {
            channelsKt__Channels_commonKt$lastOrNull$1 = (ChannelsKt__Channels_commonKt$lastOrNull$1) continuation;
            if ((channelsKt__Channels_commonKt$lastOrNull$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$lastOrNull$1.setLabel(channelsKt__Channels_commonKt$lastOrNull$1.getLabel() - Integer.MIN_VALUE);
                obj = channelsKt__Channels_commonKt$lastOrNull$1.data;
                Throwable th5 = channelsKt__Channels_commonKt$lastOrNull$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$lastOrNull$1.getLabel();
                if (label == 0) {
                    if (label != 1) {
                        if (label == 2) {
                            channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$lastOrNull$1.L$4;
                            receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$3;
                            th3 = (Throwable) channelsKt__Channels_commonKt$lastOrNull$1.L$2;
                            receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$1;
                            receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$0;
                            if (th5 != null) {
                                throw th5;
                            }
                        } else if (label == 3) {
                            obj2 = channelsKt__Channels_commonKt$lastOrNull$1.L$5;
                            channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$lastOrNull$1.L$4;
                            receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$3;
                            Throwable th6 = (Throwable) channelsKt__Channels_commonKt$lastOrNull$1.L$2;
                            ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$1;
                            ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$0;
                            if (th5 == null) {
                                th2 = th6;
                                receiveChannel2 = receiveChannel8;
                                receiveChannel3 = receiveChannel9;
                                if (!((Boolean) obj).booleanValue()) {
                                    channelsKt__Channels_commonKt$lastOrNull$1.L$0 = receiveChannel3;
                                    channelsKt__Channels_commonKt$lastOrNull$1.L$1 = receiveChannel2;
                                    channelsKt__Channels_commonKt$lastOrNull$1.L$2 = th2;
                                    channelsKt__Channels_commonKt$lastOrNull$1.L$3 = receiveChannel4;
                                    channelsKt__Channels_commonKt$lastOrNull$1.L$4 = channelIterator;
                                    channelsKt__Channels_commonKt$lastOrNull$1.L$5 = obj2;
                                    channelsKt__Channels_commonKt$lastOrNull$1.setLabel(4);
                                    obj = channelIterator.next(channelsKt__Channels_commonKt$lastOrNull$1);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    channelIterator2 = channelIterator;
                                    receiveChannel5 = receiveChannel4;
                                    th3 = th2;
                                    return coroutine_suspended;
                                }
                                receiveChannel2.cancel(th2);
                                return obj2;
                            }
                            try {
                                throw th5;
                            } catch (Throwable th7) {
                                th = th7;
                                receiveChannel2 = receiveChannel8;
                            }
                        } else if (label == 4) {
                            Object obj3 = channelsKt__Channels_commonKt$lastOrNull$1.L$5;
                            channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$lastOrNull$1.L$4;
                            receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$3;
                            th3 = (Throwable) channelsKt__Channels_commonKt$lastOrNull$1.L$2;
                            receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$1;
                            receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$0;
                            if (th5 != null) {
                                try {
                                    throw th5;
                                } catch (Throwable th8) {
                                    th = th8;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        channelsKt__Channels_commonKt$lastOrNull$1.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$1 = receiveChannel2;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$2 = th3;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$3 = receiveChannel5;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$4 = channelIterator2;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$5 = obj;
                        channelsKt__Channels_commonKt$lastOrNull$1.setLabel(3);
                        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$lastOrNull$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelIterator = channelIterator2;
                        obj2 = obj;
                        obj = hasNext;
                        th2 = th3;
                        receiveChannel4 = receiveChannel5;
                        if (!((Boolean) obj).booleanValue()) {
                            receiveChannel2.cancel(th2);
                        }
                        receiveChannel2.cancel(th2);
                        return obj2;
                        return coroutine_suspended;
                    }
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$lastOrNull$1.L$4;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$3;
                    th4 = (Throwable) channelsKt__Channels_commonKt$lastOrNull$1.L$2;
                    receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$1;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$0;
                    if (th5 != null) {
                        try {
                            throw th5;
                        } catch (Throwable th9) {
                            th = th9;
                            receiveChannel2 = receiveChannel7;
                        }
                    }
                } else if (th5 == null) {
                    Throwable th10 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$lastOrNull$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$2 = th10;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$4 = it;
                        channelsKt__Channels_commonKt$lastOrNull$1.setLabel(1);
                        Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$lastOrNull$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel7 = receiveChannel;
                        receiveChannel6 = receiveChannel7;
                        th4 = th10;
                        obj = hasNext2;
                        receiveChannel5 = receiveChannel6;
                        channelIterator2 = it;
                    } catch (Throwable th11) {
                        receiveChannel2 = receiveChannel;
                        th = th11;
                        try {
                            throw th;
                        } catch (Throwable th12) {
                            receiveChannel2.cancel(th);
                            throw th12;
                        }
                    }
                } else {
                    throw th5;
                }
                if (((Boolean) obj).booleanValue()) {
                    receiveChannel7.cancel(th4);
                    return null;
                }
                channelsKt__Channels_commonKt$lastOrNull$1.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$lastOrNull$1.L$1 = receiveChannel7;
                channelsKt__Channels_commonKt$lastOrNull$1.L$2 = th4;
                channelsKt__Channels_commonKt$lastOrNull$1.L$3 = receiveChannel5;
                channelsKt__Channels_commonKt$lastOrNull$1.L$4 = channelIterator2;
                channelsKt__Channels_commonKt$lastOrNull$1.setLabel(2);
                obj = channelIterator2.next(channelsKt__Channels_commonKt$lastOrNull$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                th3 = th4;
                receiveChannel2 = receiveChannel7;
                receiveChannel3 = receiveChannel6;
                channelsKt__Channels_commonKt$lastOrNull$1.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$lastOrNull$1.L$1 = receiveChannel2;
                channelsKt__Channels_commonKt$lastOrNull$1.L$2 = th3;
                channelsKt__Channels_commonKt$lastOrNull$1.L$3 = receiveChannel5;
                channelsKt__Channels_commonKt$lastOrNull$1.L$4 = channelIterator2;
                channelsKt__Channels_commonKt$lastOrNull$1.L$5 = obj;
                channelsKt__Channels_commonKt$lastOrNull$1.setLabel(3);
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$lastOrNull$1);
                if (hasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        channelsKt__Channels_commonKt$lastOrNull$1 = new ChannelsKt__Channels_commonKt$lastOrNull$1(continuation);
        obj = channelsKt__Channels_commonKt$lastOrNull$1.data;
        Throwable th52 = channelsKt__Channels_commonKt$lastOrNull$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$lastOrNull$1.getLabel();
        if (label == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00eb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    public static final <E> Object single(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$single$1 channelsKt__Channels_commonKt$single$1;
        Object obj;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th2;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel6;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel7;
        Throwable th4;
        if (continuation instanceof ChannelsKt__Channels_commonKt$single$1) {
            channelsKt__Channels_commonKt$single$1 = (ChannelsKt__Channels_commonKt$single$1) continuation;
            if ((channelsKt__Channels_commonKt$single$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$single$1.setLabel(channelsKt__Channels_commonKt$single$1.getLabel() - Integer.MIN_VALUE);
                obj = channelsKt__Channels_commonKt$single$1.data;
                Throwable th5 = channelsKt__Channels_commonKt$single$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$single$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$single$1.L$4;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$3;
                        th4 = (Throwable) channelsKt__Channels_commonKt$single$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$1;
                        receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$0;
                        if (th5 != null) {
                            try {
                                throw th5;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        }
                    } else if (label == 2) {
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$single$1.L$4;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$3;
                        th3 = (Throwable) channelsKt__Channels_commonKt$single$1.L$2;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$1;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$0;
                        if (th5 != null) {
                            try {
                                throw th5;
                            } catch (Throwable th7) {
                                th = th7;
                                receiveChannel2 = receiveChannel5;
                            }
                        }
                        channelsKt__Channels_commonKt$single$1.L$0 = receiveChannel4;
                        channelsKt__Channels_commonKt$single$1.L$1 = receiveChannel5;
                        channelsKt__Channels_commonKt$single$1.L$2 = th3;
                        channelsKt__Channels_commonKt$single$1.L$3 = receiveChannel6;
                        channelsKt__Channels_commonKt$single$1.L$4 = channelIterator;
                        channelsKt__Channels_commonKt$single$1.L$5 = obj;
                        channelsKt__Channels_commonKt$single$1.setLabel(3);
                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$single$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        th2 = th3;
                        receiveChannel3 = receiveChannel5;
                        obj = hasNext;
                        obj2 = obj;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } else if (label == 3) {
                        obj2 = channelsKt__Channels_commonKt$single$1.L$5;
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$single$1.L$4;
                        ReceiveChannel receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$3;
                        th2 = (Throwable) channelsKt__Channels_commonKt$single$1.L$2;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$1;
                        ReceiveChannel receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$0;
                        if (th5 != null) {
                            try {
                                throw th5;
                            } catch (Throwable th8) {
                                th = th8;
                                receiveChannel2 = receiveChannel3;
                            }
                        }
                        if (((Boolean) obj).booleanValue()) {
                            receiveChannel3.cancel(th2);
                            return obj2;
                        }
                        throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th5 == null) {
                    Throwable th9 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$single$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$single$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$single$1.L$2 = th9;
                        channelsKt__Channels_commonKt$single$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$single$1.L$4 = it;
                        channelsKt__Channels_commonKt$single$1.setLabel(1);
                        Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$single$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel7 = receiveChannel2;
                        th4 = th9;
                        obj = hasNext2;
                        receiveChannel6 = receiveChannel7;
                        channelIterator = it;
                    } catch (Throwable th10) {
                        receiveChannel2 = receiveChannel;
                        th = th10;
                        try {
                            throw th;
                        } catch (Throwable th11) {
                            receiveChannel2.cancel(th);
                            throw th11;
                        }
                    }
                } else {
                    throw th5;
                }
                if (!((Boolean) obj).booleanValue()) {
                    channelsKt__Channels_commonKt$single$1.L$0 = receiveChannel7;
                    channelsKt__Channels_commonKt$single$1.L$1 = receiveChannel2;
                    channelsKt__Channels_commonKt$single$1.L$2 = th4;
                    channelsKt__Channels_commonKt$single$1.L$3 = receiveChannel6;
                    channelsKt__Channels_commonKt$single$1.L$4 = channelIterator;
                    channelsKt__Channels_commonKt$single$1.setLabel(2);
                    obj = channelIterator.next(channelsKt__Channels_commonKt$single$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    th3 = th4;
                    receiveChannel5 = receiveChannel2;
                    receiveChannel4 = receiveChannel7;
                    channelsKt__Channels_commonKt$single$1.L$0 = receiveChannel4;
                    channelsKt__Channels_commonKt$single$1.L$1 = receiveChannel5;
                    channelsKt__Channels_commonKt$single$1.L$2 = th3;
                    channelsKt__Channels_commonKt$single$1.L$3 = receiveChannel6;
                    channelsKt__Channels_commonKt$single$1.L$4 = channelIterator;
                    channelsKt__Channels_commonKt$single$1.L$5 = obj;
                    channelsKt__Channels_commonKt$single$1.setLabel(3);
                    hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$single$1);
                    if (hasNext != coroutine_suspended) {
                    }
                } else {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
            }
        }
        channelsKt__Channels_commonKt$single$1 = new ChannelsKt__Channels_commonKt$single$1(continuation);
        obj = channelsKt__Channels_commonKt$single$1.data;
        Throwable th52 = channelsKt__Channels_commonKt$single$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$single$1.getLabel();
        if (label == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    public static final <E> Object singleOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$singleOrNull$1 channelsKt__Channels_commonKt$singleOrNull$1;
        Object obj;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th2;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel6;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel7;
        Throwable th4;
        if (continuation instanceof ChannelsKt__Channels_commonKt$singleOrNull$1) {
            channelsKt__Channels_commonKt$singleOrNull$1 = (ChannelsKt__Channels_commonKt$singleOrNull$1) continuation;
            if ((channelsKt__Channels_commonKt$singleOrNull$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$singleOrNull$1.setLabel(channelsKt__Channels_commonKt$singleOrNull$1.getLabel() - Integer.MIN_VALUE);
                obj = channelsKt__Channels_commonKt$singleOrNull$1.data;
                Throwable th5 = channelsKt__Channels_commonKt$singleOrNull$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$singleOrNull$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$singleOrNull$1.L$4;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$3;
                        th4 = (Throwable) channelsKt__Channels_commonKt$singleOrNull$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$1;
                        receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$0;
                        if (th5 != null) {
                            try {
                                throw th5;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        }
                    } else if (label == 2) {
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$singleOrNull$1.L$4;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$3;
                        th3 = (Throwable) channelsKt__Channels_commonKt$singleOrNull$1.L$2;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$1;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$0;
                        if (th5 != null) {
                            try {
                                throw th5;
                            } catch (Throwable th7) {
                                th = th7;
                                receiveChannel2 = receiveChannel5;
                            }
                        }
                        channelsKt__Channels_commonKt$singleOrNull$1.L$0 = receiveChannel4;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$1 = receiveChannel5;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$2 = th3;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$3 = receiveChannel6;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$4 = channelIterator;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$5 = obj;
                        channelsKt__Channels_commonKt$singleOrNull$1.setLabel(3);
                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$singleOrNull$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        th2 = th3;
                        receiveChannel3 = receiveChannel5;
                        obj = hasNext;
                        obj2 = obj;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                    } else if (label == 3) {
                        obj2 = channelsKt__Channels_commonKt$singleOrNull$1.L$5;
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$singleOrNull$1.L$4;
                        ReceiveChannel receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$3;
                        th2 = (Throwable) channelsKt__Channels_commonKt$singleOrNull$1.L$2;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$1;
                        ReceiveChannel receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$0;
                        if (th5 != null) {
                            try {
                                throw th5;
                            } catch (Throwable th8) {
                                th = th8;
                                receiveChannel2 = receiveChannel3;
                            }
                        }
                        if (!((Boolean) obj).booleanValue()) {
                            receiveChannel3.cancel(th2);
                            return null;
                        }
                        receiveChannel3.cancel(th2);
                        return obj2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th5 == null) {
                    Throwable th9 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$singleOrNull$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$2 = th9;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$4 = it;
                        channelsKt__Channels_commonKt$singleOrNull$1.setLabel(1);
                        Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$singleOrNull$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel7 = receiveChannel2;
                        th4 = th9;
                        obj = hasNext2;
                        receiveChannel6 = receiveChannel7;
                        channelIterator = it;
                    } catch (Throwable th10) {
                        receiveChannel2 = receiveChannel;
                        th = th10;
                        try {
                            throw th;
                        } catch (Throwable th11) {
                            receiveChannel2.cancel(th);
                            throw th11;
                        }
                    }
                } else {
                    throw th5;
                }
                if (((Boolean) obj).booleanValue()) {
                    receiveChannel2.cancel(th4);
                    return null;
                }
                channelsKt__Channels_commonKt$singleOrNull$1.L$0 = receiveChannel7;
                channelsKt__Channels_commonKt$singleOrNull$1.L$1 = receiveChannel2;
                channelsKt__Channels_commonKt$singleOrNull$1.L$2 = th4;
                channelsKt__Channels_commonKt$singleOrNull$1.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$singleOrNull$1.L$4 = channelIterator;
                channelsKt__Channels_commonKt$singleOrNull$1.setLabel(2);
                obj = channelIterator.next(channelsKt__Channels_commonKt$singleOrNull$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                th3 = th4;
                receiveChannel5 = receiveChannel2;
                receiveChannel4 = receiveChannel7;
                channelsKt__Channels_commonKt$singleOrNull$1.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$singleOrNull$1.L$1 = receiveChannel5;
                channelsKt__Channels_commonKt$singleOrNull$1.L$2 = th3;
                channelsKt__Channels_commonKt$singleOrNull$1.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$singleOrNull$1.L$4 = channelIterator;
                channelsKt__Channels_commonKt$singleOrNull$1.L$5 = obj;
                channelsKt__Channels_commonKt$singleOrNull$1.setLabel(3);
                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$singleOrNull$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__Channels_commonKt$singleOrNull$1 = new ChannelsKt__Channels_commonKt$singleOrNull$1(continuation);
        obj = channelsKt__Channels_commonKt$singleOrNull$1.data;
        Throwable th52 = channelsKt__Channels_commonKt$singleOrNull$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$singleOrNull$1.getLabel();
        if (label == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.drop(receiveChannel, i, coroutineContext);
    }

    public static final <E> ReceiveChannel<E> drop(ReceiveChannel<? extends E> receiveChannel, int i, CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$drop$1(receiveChannel, i, null), 6, null);
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.dropWhile(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> dropWhile(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$dropWhile$1(receiveChannel, function2, null), 6, null);
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.filter(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$filter$1(receiveChannel, function2, null), 6, null);
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.filterIndexed(receiveChannel, coroutineContext, function3);
    }

    public static final <E> ReceiveChannel<E> filterIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "predicate");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$filterIndexed$1(receiveChannel, function3, null), 6, null);
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.filterNot(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> filterNot(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        return ChannelsKt.filter(receiveChannel, coroutineContext, new ChannelsKt__Channels_commonKt$filterNot$1(function2, null));
    }

    public static final /* synthetic */ <E> ReceiveChannel<E> filterNot(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        return filterNot$default(receiveChannel, null, function2, 1, null);
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        ReceiveChannel<E> receiveChannel2 = filter$default(receiveChannel, null, new ChannelsKt__Channels_commonKt$filterNotNull$1(null), 1, null);
        if (receiveChannel2 != null) {
            return receiveChannel2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ReceiveChannel<E>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.Collection] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b3 A[Catch:{ all -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3 A[Catch:{ all -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E, C extends Collection<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterNotNullTo$1 channelsKt__Channels_commonKt$filterNotNullTo$1;
        int label;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        Object obj;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$filterNotNullTo$1 channelsKt__Channels_commonKt$filterNotNullTo$12;
        Throwable th2;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> channelIterator2;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator channelIterator3;
        ReceiveChannel<? extends E> receiveChannel7;
        Object obj3;
        ReceiveChannel<? extends E> receiveChannel8;
        Throwable th3;
        C c2;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterNotNullTo$1) {
            channelsKt__Channels_commonKt$filterNotNullTo$1 = (ChannelsKt__Channels_commonKt$filterNotNullTo$1) continuation;
            if ((channelsKt__Channels_commonKt$filterNotNullTo$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterNotNullTo$1.setLabel(channelsKt__Channels_commonKt$filterNotNullTo$1.getLabel() - Integer.MIN_VALUE);
                Object obj4 = channelsKt__Channels_commonKt$filterNotNullTo$1.data;
                Throwable th4 = channelsKt__Channels_commonKt$filterNotNullTo$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$filterNotNullTo$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$filterNotNullTo$1.L$6;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$5;
                        th3 = (Throwable) channelsKt__Channels_commonKt$filterNotNullTo$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$3;
                        receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$2;
                        ?? r8 = (Collection) channelsKt__Channels_commonKt$filterNotNullTo$1.L$1;
                        receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$0;
                        if (th4 == null) {
                            c2 = r8;
                            obj3 = obj4;
                            receiveChannel2 = receiveChannel9;
                            channelIterator3 = channelIterator4;
                            if (!((Boolean) obj3).booleanValue()) {
                                channelsKt__Channels_commonKt$filterNotNullTo$1.L$0 = receiveChannel7;
                                channelsKt__Channels_commonKt$filterNotNullTo$1.L$1 = c2;
                                channelsKt__Channels_commonKt$filterNotNullTo$1.L$2 = receiveChannel8;
                                channelsKt__Channels_commonKt$filterNotNullTo$1.L$3 = receiveChannel2;
                                channelsKt__Channels_commonKt$filterNotNullTo$1.L$4 = th3;
                                channelsKt__Channels_commonKt$filterNotNullTo$1.L$5 = receiveChannel6;
                                channelsKt__Channels_commonKt$filterNotNullTo$1.L$6 = channelIterator3;
                                channelsKt__Channels_commonKt$filterNotNullTo$1.setLabel(2);
                                Object next = channelIterator3.next(channelsKt__Channels_commonKt$filterNotNullTo$1);
                                if (next == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = coroutine_suspended;
                                th2 = th3;
                                channelsKt__Channels_commonKt$filterNotNullTo$12 = channelsKt__Channels_commonKt$filterNotNullTo$1;
                                receiveChannel5 = receiveChannel6;
                                receiveChannel3 = receiveChannel8;
                                channelIterator = channelIterator3;
                                receiveChannel = receiveChannel7;
                                receiveChannel4 = receiveChannel2;
                                obj4 = next;
                                collection = c2;
                                if (obj4 != null) {
                                }
                                receiveChannel2 = receiveChannel4;
                                channelIterator2 = channelIterator;
                                obj2 = obj;
                                return coroutine_suspended;
                            }
                            Unit unit = Unit.INSTANCE;
                            receiveChannel2.cancel(th3);
                            return c2;
                        }
                        throw th4;
                    } else if (label == 2) {
                        ChannelIterator<? extends E> channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$filterNotNullTo$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$5;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$filterNotNullTo$1.L$4;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$2;
                        Collection collection2 = (Collection) channelsKt__Channels_commonKt$filterNotNullTo$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$0;
                        if (th4 == null) {
                            collection = collection2;
                            obj = coroutine_suspended;
                            th2 = th5;
                            channelsKt__Channels_commonKt$filterNotNullTo$12 = channelsKt__Channels_commonKt$filterNotNullTo$1;
                            receiveChannel5 = receiveChannel10;
                            receiveChannel3 = receiveChannel11;
                            channelIterator = channelIterator5;
                            receiveChannel = receiveChannel12;
                            if (obj4 != null) {
                                collection.add(obj4);
                            }
                            receiveChannel2 = receiveChannel4;
                            channelIterator2 = channelIterator;
                            obj2 = obj;
                        } else {
                            try {
                                throw th4;
                            } catch (Throwable th6) {
                                th = th6;
                                receiveChannel2 = receiveChannel4;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th4 == null) {
                    Throwable th7 = null;
                    try {
                        channelsKt__Channels_commonKt$filterNotNullTo$12 = channelsKt__Channels_commonKt$filterNotNullTo$1;
                        channelIterator2 = receiveChannel.iterator();
                        obj2 = coroutine_suspended;
                        receiveChannel5 = receiveChannel;
                        collection = c;
                        th2 = th7;
                        receiveChannel3 = receiveChannel5;
                        receiveChannel2 = receiveChannel3;
                    } catch (Throwable th8) {
                        receiveChannel2 = receiveChannel;
                        th = th8;
                        try {
                            throw th;
                        } catch (Throwable th9) {
                            receiveChannel2.cancel(th);
                            throw th9;
                        }
                    }
                } else {
                    throw th4;
                }
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$0 = receiveChannel;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$1 = collection;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$2 = receiveChannel3;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$4 = th2;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$filterNotNullTo$12.setLabel(1);
                obj3 = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$12);
                if (obj3 != obj2) {
                    return obj2;
                }
                receiveChannel7 = receiveChannel;
                channelIterator3 = channelIterator2;
                receiveChannel8 = receiveChannel3;
                receiveChannel6 = receiveChannel5;
                channelsKt__Channels_commonKt$filterNotNullTo$1 = channelsKt__Channels_commonKt$filterNotNullTo$12;
                th3 = th2;
                coroutine_suspended = obj2;
                c2 = collection;
                if (!((Boolean) obj3).booleanValue()) {
                    Unit unit2 = Unit.INSTANCE;
                    receiveChannel2.cancel(th3);
                }
                Unit unit22 = Unit.INSTANCE;
                receiveChannel2.cancel(th3);
                return c2;
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$filterNotNullTo$1 = new ChannelsKt__Channels_commonKt$filterNotNullTo$1(continuation);
        Object obj42 = channelsKt__Channels_commonKt$filterNotNullTo$1.data;
        Throwable th42 = channelsKt__Channels_commonKt$filterNotNullTo$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$filterNotNullTo$1.getLabel();
        if (label == 0) {
        }
        try {
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$0 = receiveChannel;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$1 = collection;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$2 = receiveChannel3;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$4 = th2;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$filterNotNullTo$12.setLabel(1);
            obj3 = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$12);
            if (obj3 != obj2) {
            }
            return obj2;
        } catch (Throwable th10) {
            th = th10;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00dd A[Catch:{ all -> 0x0143 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00de A[Catch:{ all -> 0x0143 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ec A[Catch:{ all -> 0x0143 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0127 A[Catch:{ all -> 0x0143 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    public static final <E, C extends SendChannel<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterNotNullTo$3 channelsKt__Channels_commonKt$filterNotNullTo$3;
        Object obj;
        Object coroutine_suspended;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ReceiveChannel<? extends E> receiveChannel8;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel9;
        Object obj3;
        Object obj4;
        ChannelsKt__Channels_commonKt$filterNotNullTo$3 channelsKt__Channels_commonKt$filterNotNullTo$32;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel10;
        Object obj5;
        ReceiveChannel<? extends E> receiveChannel11;
        ChannelsKt__Channels_commonKt$filterNotNullTo$3 channelsKt__Channels_commonKt$filterNotNullTo$33;
        Throwable th4;
        ChannelIterator<? extends E> channelIterator3;
        Object hasNext;
        ChannelIterator<? extends E> channelIterator4;
        C c2;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterNotNullTo$3) {
            channelsKt__Channels_commonKt$filterNotNullTo$3 = (ChannelsKt__Channels_commonKt$filterNotNullTo$3) continuation;
            if ((channelsKt__Channels_commonKt$filterNotNullTo$3.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterNotNullTo$3.setLabel(channelsKt__Channels_commonKt$filterNotNullTo$3.getLabel() - Integer.MIN_VALUE);
                obj = channelsKt__Channels_commonKt$filterNotNullTo$3.data;
                Throwable th5 = channelsKt__Channels_commonKt$filterNotNullTo$3.exception;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$filterNotNullTo$3.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ChannelIterator channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$filterNotNullTo$3.L$6;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$5;
                        Throwable th6 = (Throwable) channelsKt__Channels_commonKt$filterNotNullTo$3.L$4;
                        ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$3;
                        ReceiveChannel<? extends E> receiveChannel13 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$2;
                        obj5 = (SendChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$1;
                        receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$0;
                        if (th5 == null) {
                            receiveChannel11 = receiveChannel13;
                            th3 = th6;
                            channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                            receiveChannel2 = receiveChannel12;
                            channelIterator2 = channelIterator5;
                            if (!((Boolean) obj).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                            }
                            Unit unit2 = Unit.INSTANCE;
                            receiveChannel2.cancel(th3);
                            return obj5;
                        }
                        throw th5;
                    } else if (label == 2) {
                        ChannelIterator<? extends E> channelIterator6 = (ChannelIterator) channelsKt__Channels_commonKt$filterNotNullTo$3.L$6;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$5;
                        th4 = (Throwable) channelsKt__Channels_commonKt$filterNotNullTo$3.L$4;
                        ReceiveChannel<? extends E> receiveChannel14 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$3;
                        ReceiveChannel<? extends E> receiveChannel15 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$2;
                        obj5 = (SendChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$1;
                        receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$0;
                        if (th5 == null) {
                            channelsKt__Channels_commonKt$filterNotNullTo$33 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                            receiveChannel2 = receiveChannel14;
                            receiveChannel5 = receiveChannel15;
                            channelIterator4 = channelIterator6;
                        } else {
                            try {
                                throw th5;
                            } catch (Throwable th7) {
                                th = th7;
                                receiveChannel2 = receiveChannel14;
                            }
                        }
                    } else if (label == 3) {
                        Object obj6 = channelsKt__Channels_commonKt$filterNotNullTo$3.L$8;
                        Object obj7 = channelsKt__Channels_commonKt$filterNotNullTo$3.L$7;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$5;
                        th2 = (Throwable) channelsKt__Channels_commonKt$filterNotNullTo$3.L$4;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$3;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$2;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$0;
                        obj2 = (SendChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$1;
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterNotNullTo$3.L$6;
                        if (th5 != null) {
                            try {
                                throw th5;
                            } catch (Throwable th8) {
                                th = th8;
                                receiveChannel2 = receiveChannel6;
                            }
                        }
                        receiveChannel7 = receiveChannel3;
                        receiveChannel8 = receiveChannel4;
                        th3 = th2;
                        receiveChannel9 = receiveChannel5;
                        obj3 = coroutine_suspended;
                        obj4 = obj2;
                        channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                        receiveChannel2 = receiveChannel6;
                        channelIterator3 = channelIterator;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$0 = receiveChannel8;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$1 = obj4;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$2 = receiveChannel9;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$3 = receiveChannel2;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$4 = th3;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$5 = receiveChannel7;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$6 = channelIterator3;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.setLabel(1);
                        hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$32);
                        if (hasNext == obj3) {
                            return obj3;
                        }
                        receiveChannel10 = receiveChannel8;
                        receiveChannel3 = receiveChannel7;
                        receiveChannel11 = receiveChannel9;
                        obj = hasNext;
                        obj5 = obj4;
                        coroutine_suspended = obj3;
                        channelIterator2 = channelIterator3;
                        if (!((Boolean) obj).booleanValue()) {
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$0 = receiveChannel10;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$1 = obj5;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$2 = receiveChannel11;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$3 = receiveChannel2;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$4 = th3;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$5 = receiveChannel3;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$6 = channelIterator2;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.setLabel(2);
                            obj = channelIterator2.next(channelsKt__Channels_commonKt$filterNotNullTo$32);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel5 = receiveChannel11;
                            channelsKt__Channels_commonKt$filterNotNullTo$33 = channelsKt__Channels_commonKt$filterNotNullTo$32;
                            th4 = th3;
                            channelIterator4 = channelIterator2;
                            return coroutine_suspended;
                        }
                        Unit unit22 = Unit.INSTANCE;
                        receiveChannel2.cancel(th3);
                        return obj5;
                        return obj3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th5 == null) {
                    try {
                        th3 = null;
                        channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                        obj3 = coroutine_suspended;
                        receiveChannel9 = receiveChannel;
                        receiveChannel2 = receiveChannel9;
                        obj4 = c;
                        receiveChannel8 = receiveChannel2;
                        channelIterator3 = receiveChannel.iterator();
                        receiveChannel7 = receiveChannel8;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$0 = receiveChannel8;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$1 = obj4;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$2 = receiveChannel9;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$3 = receiveChannel2;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$4 = th3;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$5 = receiveChannel7;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$6 = channelIterator3;
                        channelsKt__Channels_commonKt$filterNotNullTo$32.setLabel(1);
                        hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$32);
                        if (hasNext == obj3) {
                        }
                        return obj3;
                    } catch (Throwable th9) {
                        receiveChannel2 = receiveChannel;
                        th = th9;
                        try {
                            throw th;
                        } catch (Throwable th10) {
                            receiveChannel2.cancel(th);
                            throw th10;
                        }
                    }
                } else {
                    throw th5;
                }
                try {
                    c2 = obj5;
                    receiveChannel4 = receiveChannel10;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$0 = receiveChannel8;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$1 = obj4;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$2 = receiveChannel9;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$3 = receiveChannel2;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$4 = th3;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$5 = receiveChannel7;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$6 = channelIterator3;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.setLabel(1);
                    hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$32);
                    if (hasNext == obj3) {
                    }
                    return obj3;
                } catch (Throwable th11) {
                    th = th11;
                    throw th;
                }
                if (obj == null) {
                    channelsKt__Channels_commonKt$filterNotNullTo$33.L$0 = receiveChannel4;
                    channelsKt__Channels_commonKt$filterNotNullTo$33.L$1 = c2;
                    channelsKt__Channels_commonKt$filterNotNullTo$33.L$2 = receiveChannel5;
                    channelsKt__Channels_commonKt$filterNotNullTo$33.L$3 = receiveChannel2;
                    channelsKt__Channels_commonKt$filterNotNullTo$33.L$4 = th4;
                    channelsKt__Channels_commonKt$filterNotNullTo$33.L$5 = receiveChannel3;
                    channelsKt__Channels_commonKt$filterNotNullTo$33.L$6 = channelIterator4;
                    channelsKt__Channels_commonKt$filterNotNullTo$33.L$7 = obj;
                    channelsKt__Channels_commonKt$filterNotNullTo$33.L$8 = obj;
                    channelsKt__Channels_commonKt$filterNotNullTo$33.setLabel(3);
                    if (c2.send(obj, channelsKt__Channels_commonKt$filterNotNullTo$33) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    th2 = th4;
                    receiveChannel6 = receiveChannel2;
                    channelsKt__Channels_commonKt$filterNotNullTo$3 = channelsKt__Channels_commonKt$filterNotNullTo$33;
                    obj2 = c2;
                    channelIterator = channelIterator4;
                    receiveChannel7 = receiveChannel3;
                    receiveChannel8 = receiveChannel4;
                    th3 = th2;
                    receiveChannel9 = receiveChannel5;
                    obj3 = coroutine_suspended;
                    obj4 = obj2;
                    channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                    receiveChannel2 = receiveChannel6;
                    channelIterator3 = channelIterator;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$0 = receiveChannel8;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$1 = obj4;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$2 = receiveChannel9;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$3 = receiveChannel2;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$4 = th3;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$5 = receiveChannel7;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$6 = channelIterator3;
                    channelsKt__Channels_commonKt$filterNotNullTo$32.setLabel(1);
                    hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$32);
                    if (hasNext == obj3) {
                    }
                    return obj3;
                    return coroutine_suspended;
                }
                receiveChannel9 = receiveChannel5;
                obj3 = coroutine_suspended;
                obj4 = c2;
                th3 = th4;
                channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$33;
                receiveChannel7 = receiveChannel3;
                receiveChannel8 = receiveChannel4;
                channelIterator3 = channelIterator4;
            }
        }
        channelsKt__Channels_commonKt$filterNotNullTo$3 = new ChannelsKt__Channels_commonKt$filterNotNullTo$3(continuation);
        obj = channelsKt__Channels_commonKt$filterNotNullTo$3.data;
        Throwable th52 = channelsKt__Channels_commonKt$filterNotNullTo$3.exception;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$filterNotNullTo$3.getLabel();
        if (label == 0) {
        }
        c2 = obj5;
        receiveChannel4 = receiveChannel10;
        if (obj == null) {
            receiveChannel9 = receiveChannel5;
            obj3 = coroutine_suspended;
            obj4 = c2;
            th3 = th4;
            channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$33;
            receiveChannel7 = receiveChannel3;
            receiveChannel8 = receiveChannel4;
            channelIterator3 = channelIterator4;
            channelsKt__Channels_commonKt$filterNotNullTo$32.L$0 = receiveChannel8;
            channelsKt__Channels_commonKt$filterNotNullTo$32.L$1 = obj4;
            channelsKt__Channels_commonKt$filterNotNullTo$32.L$2 = receiveChannel9;
            channelsKt__Channels_commonKt$filterNotNullTo$32.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$filterNotNullTo$32.L$4 = th3;
            channelsKt__Channels_commonKt$filterNotNullTo$32.L$5 = receiveChannel7;
            channelsKt__Channels_commonKt$filterNotNullTo$32.L$6 = channelIterator3;
            channelsKt__Channels_commonKt$filterNotNullTo$32.setLabel(1);
            hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$32);
            if (hasNext == obj3) {
            }
            return obj3;
        }
        channelsKt__Channels_commonKt$filterNotNullTo$33.L$0 = receiveChannel4;
        channelsKt__Channels_commonKt$filterNotNullTo$33.L$1 = c2;
        channelsKt__Channels_commonKt$filterNotNullTo$33.L$2 = receiveChannel5;
        channelsKt__Channels_commonKt$filterNotNullTo$33.L$3 = receiveChannel2;
        channelsKt__Channels_commonKt$filterNotNullTo$33.L$4 = th4;
        channelsKt__Channels_commonKt$filterNotNullTo$33.L$5 = receiveChannel3;
        channelsKt__Channels_commonKt$filterNotNullTo$33.L$6 = channelIterator4;
        channelsKt__Channels_commonKt$filterNotNullTo$33.L$7 = obj;
        channelsKt__Channels_commonKt$filterNotNullTo$33.L$8 = obj;
        channelsKt__Channels_commonKt$filterNotNullTo$33.setLabel(3);
        if (c2.send(obj, channelsKt__Channels_commonKt$filterNotNullTo$33) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.take(receiveChannel, i, coroutineContext);
    }

    public static final <E> ReceiveChannel<E> take(ReceiveChannel<? extends E> receiveChannel, int i, CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$take$1(receiveChannel, i, null), 6, null);
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.takeWhile(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> takeWhile(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$takeWhile$1(receiveChannel, function2, null), 6, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0057, code lost:
        throw r8;
     */
    private static final <E, K, V> Object associate(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends Pair<? extends K, ? extends V>> function1, Continuation<? super Map<K, ? extends V>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                Pair pair = (Pair) function1.invoke((Object) it.next(continuation));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return linkedHashMap;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        throw r8;
     */
    private static final <E, K> Object associateBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Continuation<? super Map<K, ? extends E>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                linkedHashMap.put(function1.invoke(obj), obj);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return linkedHashMap;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0051, code lost:
        throw r8;
     */
    private static final <E, K, V> Object associateBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super Map<K, ? extends V>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                linkedHashMap.put(function1.invoke(obj), function12.invoke(obj));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return linkedHashMap;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v5, types: [kotlinx.coroutines.experimental.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r8v12, types: [kotlinx.coroutines.experimental.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e8 A[Catch:{ all -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6 A[Catch:{ all -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$toChannel$1 channelsKt__Channels_commonKt$toChannel$1;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        SendChannel sendChannel;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th2;
        ChannelsKt__Channels_commonKt$toChannel$1 channelsKt__Channels_commonKt$toChannel$12;
        Object obj;
        ChannelIterator channelIterator2;
        Object obj2;
        C c2;
        ReceiveChannel<? extends E> receiveChannel7;
        ReceiveChannel<? extends E> receiveChannel8;
        ReceiveChannel<? extends E> receiveChannel9;
        Throwable th3;
        ChannelsKt__Channels_commonKt$toChannel$1 channelsKt__Channels_commonKt$toChannel$13;
        ReceiveChannel<? extends E> receiveChannel10;
        ChannelIterator channelIterator3;
        C c3;
        ReceiveChannel<? extends E> receiveChannel11;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$toChannel$1) {
            channelsKt__Channels_commonKt$toChannel$1 = (ChannelsKt__Channels_commonKt$toChannel$1) continuation;
            if ((channelsKt__Channels_commonKt$toChannel$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$toChannel$1.setLabel(channelsKt__Channels_commonKt$toChannel$1.getLabel() - Integer.MIN_VALUE);
                Object obj3 = channelsKt__Channels_commonKt$toChannel$1.data;
                Throwable th4 = channelsKt__Channels_commonKt$toChannel$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$toChannel$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$toChannel$1.L$6;
                        receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$5;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$toChannel$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel13 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$2;
                        ?? r9 = (SendChannel) channelsKt__Channels_commonKt$toChannel$1.L$1;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$0;
                        if (th4 == null) {
                            receiveChannel11 = receiveChannel13;
                            th3 = th5;
                            channelsKt__Channels_commonKt$toChannel$13 = channelsKt__Channels_commonKt$toChannel$1;
                            receiveChannel2 = receiveChannel12;
                            c3 = r9;
                            channelIterator3 = channelIterator4;
                            if (!((Boolean) obj3).booleanValue()) {
                                channelsKt__Channels_commonKt$toChannel$13.L$0 = receiveChannel5;
                                channelsKt__Channels_commonKt$toChannel$13.L$1 = c3;
                                channelsKt__Channels_commonKt$toChannel$13.L$2 = receiveChannel11;
                                channelsKt__Channels_commonKt$toChannel$13.L$3 = receiveChannel2;
                                channelsKt__Channels_commonKt$toChannel$13.L$4 = th3;
                                channelsKt__Channels_commonKt$toChannel$13.L$5 = receiveChannel10;
                                channelsKt__Channels_commonKt$toChannel$13.L$6 = channelIterator3;
                                channelsKt__Channels_commonKt$toChannel$13.setLabel(2);
                                Object next = channelIterator3.next(channelsKt__Channels_commonKt$toChannel$13);
                                if (next == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                channelIterator = channelIterator3;
                                receiveChannel4 = receiveChannel2;
                                obj = next;
                                receiveChannel3 = receiveChannel10;
                                receiveChannel6 = receiveChannel11;
                                channelsKt__Channels_commonKt$toChannel$12 = channelsKt__Channels_commonKt$toChannel$13;
                                th2 = th3;
                                sendChannel = c3;
                                channelsKt__Channels_commonKt$toChannel$12.L$0 = receiveChannel5;
                                channelsKt__Channels_commonKt$toChannel$12.L$1 = sendChannel;
                                channelsKt__Channels_commonKt$toChannel$12.L$2 = receiveChannel6;
                                channelsKt__Channels_commonKt$toChannel$12.L$3 = receiveChannel4;
                                channelsKt__Channels_commonKt$toChannel$12.L$4 = th2;
                                channelsKt__Channels_commonKt$toChannel$12.L$5 = receiveChannel3;
                                channelsKt__Channels_commonKt$toChannel$12.L$6 = channelIterator;
                                channelsKt__Channels_commonKt$toChannel$12.L$7 = obj;
                                channelsKt__Channels_commonKt$toChannel$12.L$8 = obj;
                                channelsKt__Channels_commonKt$toChannel$12.setLabel(3);
                                if (sendChannel.send(obj, channelsKt__Channels_commonKt$toChannel$12) != coroutine_suspended) {
                                }
                                return coroutine_suspended;
                                return coroutine_suspended;
                            }
                            Unit unit = Unit.INSTANCE;
                            receiveChannel2.cancel(th3);
                            return c3;
                        }
                        throw th4;
                    } else if (label == 2) {
                        ChannelIterator<? extends E> channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$toChannel$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel14 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$5;
                        th2 = (Throwable) channelsKt__Channels_commonKt$toChannel$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel15 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$3;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$2;
                        SendChannel sendChannel2 = (SendChannel) channelsKt__Channels_commonKt$toChannel$1.L$1;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$0;
                        if (th4 == null) {
                            channelsKt__Channels_commonKt$toChannel$12 = channelsKt__Channels_commonKt$toChannel$1;
                            obj = obj3;
                            receiveChannel3 = receiveChannel14;
                            channelIterator = channelIterator5;
                            receiveChannel4 = receiveChannel15;
                            sendChannel = sendChannel2;
                            channelsKt__Channels_commonKt$toChannel$12.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$toChannel$12.L$1 = sendChannel;
                            channelsKt__Channels_commonKt$toChannel$12.L$2 = receiveChannel6;
                            channelsKt__Channels_commonKt$toChannel$12.L$3 = receiveChannel4;
                            channelsKt__Channels_commonKt$toChannel$12.L$4 = th2;
                            channelsKt__Channels_commonKt$toChannel$12.L$5 = receiveChannel3;
                            channelsKt__Channels_commonKt$toChannel$12.L$6 = channelIterator;
                            channelsKt__Channels_commonKt$toChannel$12.L$7 = obj;
                            channelsKt__Channels_commonKt$toChannel$12.L$8 = obj;
                            channelsKt__Channels_commonKt$toChannel$12.setLabel(3);
                            if (sendChannel.send(obj, channelsKt__Channels_commonKt$toChannel$12) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel2 = receiveChannel4;
                            channelIterator2 = channelIterator;
                            obj2 = coroutine_suspended;
                            c2 = sendChannel;
                            receiveChannel7 = receiveChannel5;
                            receiveChannel8 = receiveChannel3;
                            receiveChannel9 = receiveChannel6;
                            th3 = th2;
                            channelsKt__Channels_commonKt$toChannel$13 = channelsKt__Channels_commonKt$toChannel$12;
                            return coroutine_suspended;
                        }
                        try {
                            throw th4;
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel2 = receiveChannel15;
                        }
                    } else if (label == 3) {
                        Object obj4 = channelsKt__Channels_commonKt$toChannel$1.L$8;
                        Object obj5 = channelsKt__Channels_commonKt$toChannel$1.L$7;
                        ChannelIterator channelIterator6 = (ChannelIterator) channelsKt__Channels_commonKt$toChannel$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel16 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$5;
                        Throwable th7 = (Throwable) channelsKt__Channels_commonKt$toChannel$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel17 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel18 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$2;
                        ?? r8 = (SendChannel) channelsKt__Channels_commonKt$toChannel$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel19 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$0;
                        if (th4 == null) {
                            receiveChannel8 = receiveChannel16;
                            receiveChannel7 = receiveChannel19;
                            th3 = th7;
                            receiveChannel9 = receiveChannel18;
                            obj2 = coroutine_suspended;
                            c2 = r8;
                            channelsKt__Channels_commonKt$toChannel$13 = channelsKt__Channels_commonKt$toChannel$1;
                            receiveChannel2 = receiveChannel17;
                            channelIterator2 = channelIterator6;
                        } else {
                            try {
                                throw th4;
                            } catch (Throwable th8) {
                                th = th8;
                                receiveChannel2 = receiveChannel17;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th4 == null) {
                    try {
                        th3 = null;
                        channelsKt__Channels_commonKt$toChannel$13 = channelsKt__Channels_commonKt$toChannel$1;
                        obj2 = coroutine_suspended;
                        receiveChannel9 = receiveChannel;
                        receiveChannel2 = receiveChannel9;
                        c2 = c;
                        receiveChannel7 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel8 = receiveChannel7;
                    } catch (Throwable th9) {
                        receiveChannel2 = receiveChannel;
                        th = th9;
                        try {
                            throw th;
                        } catch (Throwable th10) {
                            receiveChannel2.cancel(th);
                            throw th10;
                        }
                    }
                } else {
                    throw th4;
                }
                channelsKt__Channels_commonKt$toChannel$13.L$0 = receiveChannel7;
                channelsKt__Channels_commonKt$toChannel$13.L$1 = c2;
                channelsKt__Channels_commonKt$toChannel$13.L$2 = receiveChannel9;
                channelsKt__Channels_commonKt$toChannel$13.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$toChannel$13.L$4 = th3;
                channelsKt__Channels_commonKt$toChannel$13.L$5 = receiveChannel8;
                channelsKt__Channels_commonKt$toChannel$13.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$toChannel$13.setLabel(1);
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$toChannel$13);
                if (hasNext != obj2) {
                    return obj2;
                }
                receiveChannel5 = receiveChannel7;
                receiveChannel10 = receiveChannel8;
                receiveChannel11 = receiveChannel9;
                obj3 = hasNext;
                c3 = c2;
                coroutine_suspended = obj2;
                channelIterator3 = channelIterator2;
                if (!((Boolean) obj3).booleanValue()) {
                    Unit unit2 = Unit.INSTANCE;
                    receiveChannel2.cancel(th3);
                }
                Unit unit22 = Unit.INSTANCE;
                receiveChannel2.cancel(th3);
                return c3;
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$toChannel$1 = new ChannelsKt__Channels_commonKt$toChannel$1(continuation);
        Object obj32 = channelsKt__Channels_commonKt$toChannel$1.data;
        Throwable th42 = channelsKt__Channels_commonKt$toChannel$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$toChannel$1.getLabel();
        if (label == 0) {
        }
        try {
            channelsKt__Channels_commonKt$toChannel$13.L$0 = receiveChannel7;
            channelsKt__Channels_commonKt$toChannel$13.L$1 = c2;
            channelsKt__Channels_commonKt$toChannel$13.L$2 = receiveChannel9;
            channelsKt__Channels_commonKt$toChannel$13.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$toChannel$13.L$4 = th3;
            channelsKt__Channels_commonKt$toChannel$13.L$5 = receiveChannel8;
            channelsKt__Channels_commonKt$toChannel$13.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$toChannel$13.setLabel(1);
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$toChannel$13);
            if (hasNext != obj2) {
            }
            return obj2;
        } catch (Throwable th11) {
            th = th11;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.Collection] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b3 A[Catch:{ all -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3 A[Catch:{ all -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$toCollection$1 channelsKt__Channels_commonKt$toCollection$1;
        int label;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        Object obj;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$toCollection$1 channelsKt__Channels_commonKt$toCollection$12;
        Throwable th2;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> channelIterator2;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator channelIterator3;
        ReceiveChannel<? extends E> receiveChannel7;
        Object obj3;
        ReceiveChannel<? extends E> receiveChannel8;
        Throwable th3;
        C c2;
        C c3;
        if (continuation instanceof ChannelsKt__Channels_commonKt$toCollection$1) {
            channelsKt__Channels_commonKt$toCollection$1 = (ChannelsKt__Channels_commonKt$toCollection$1) continuation;
            if ((channelsKt__Channels_commonKt$toCollection$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$toCollection$1.setLabel(channelsKt__Channels_commonKt$toCollection$1.getLabel() - Integer.MIN_VALUE);
                Object obj4 = channelsKt__Channels_commonKt$toCollection$1.data;
                Throwable th4 = channelsKt__Channels_commonKt$toCollection$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$toCollection$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$toCollection$1.L$6;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$5;
                        th3 = (Throwable) channelsKt__Channels_commonKt$toCollection$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$3;
                        receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$2;
                        ?? r8 = (Collection) channelsKt__Channels_commonKt$toCollection$1.L$1;
                        receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$0;
                        if (th4 == null) {
                            c2 = r8;
                            obj3 = obj4;
                            receiveChannel2 = receiveChannel9;
                            channelIterator3 = channelIterator4;
                            if (!((Boolean) obj3).booleanValue()) {
                                channelsKt__Channels_commonKt$toCollection$1.L$0 = receiveChannel7;
                                channelsKt__Channels_commonKt$toCollection$1.L$1 = c2;
                                channelsKt__Channels_commonKt$toCollection$1.L$2 = receiveChannel8;
                                channelsKt__Channels_commonKt$toCollection$1.L$3 = receiveChannel2;
                                channelsKt__Channels_commonKt$toCollection$1.L$4 = th3;
                                channelsKt__Channels_commonKt$toCollection$1.L$5 = receiveChannel6;
                                channelsKt__Channels_commonKt$toCollection$1.L$6 = channelIterator3;
                                channelsKt__Channels_commonKt$toCollection$1.setLabel(2);
                                Object next = channelIterator3.next(channelsKt__Channels_commonKt$toCollection$1);
                                if (next == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = coroutine_suspended;
                                th2 = th3;
                                channelsKt__Channels_commonKt$toCollection$12 = channelsKt__Channels_commonKt$toCollection$1;
                                receiveChannel5 = receiveChannel6;
                                receiveChannel3 = receiveChannel8;
                                channelIterator = channelIterator3;
                                receiveChannel = receiveChannel7;
                                receiveChannel4 = receiveChannel2;
                                obj4 = next;
                                collection = c2;
                                collection.add(obj4);
                                receiveChannel2 = receiveChannel4;
                                channelIterator2 = channelIterator;
                                obj2 = obj;
                                c3 = collection;
                                return coroutine_suspended;
                            }
                            Unit unit = Unit.INSTANCE;
                            receiveChannel2.cancel(th3);
                            return c2;
                        }
                        throw th4;
                    } else if (label == 2) {
                        ChannelIterator<? extends E> channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$toCollection$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$5;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$toCollection$1.L$4;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$2;
                        Collection collection2 = (Collection) channelsKt__Channels_commonKt$toCollection$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$0;
                        if (th4 == null) {
                            collection = collection2;
                            obj = coroutine_suspended;
                            th2 = th5;
                            channelsKt__Channels_commonKt$toCollection$12 = channelsKt__Channels_commonKt$toCollection$1;
                            receiveChannel5 = receiveChannel10;
                            receiveChannel3 = receiveChannel11;
                            channelIterator = channelIterator5;
                            receiveChannel = receiveChannel12;
                            collection.add(obj4);
                            receiveChannel2 = receiveChannel4;
                            channelIterator2 = channelIterator;
                            obj2 = obj;
                            c3 = collection;
                        } else {
                            try {
                                throw th4;
                            } catch (Throwable th6) {
                                th = th6;
                                receiveChannel2 = receiveChannel4;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th4 == null) {
                    Throwable th7 = null;
                    try {
                        channelsKt__Channels_commonKt$toCollection$12 = channelsKt__Channels_commonKt$toCollection$1;
                        channelIterator2 = receiveChannel.iterator();
                        obj2 = coroutine_suspended;
                        receiveChannel5 = receiveChannel;
                        c3 = c;
                        th2 = th7;
                        receiveChannel3 = receiveChannel5;
                        receiveChannel2 = receiveChannel3;
                    } catch (Throwable th8) {
                        receiveChannel2 = receiveChannel;
                        th = th8;
                        try {
                            throw th;
                        } catch (Throwable th9) {
                            receiveChannel2.cancel(th);
                            throw th9;
                        }
                    }
                } else {
                    throw th4;
                }
                channelsKt__Channels_commonKt$toCollection$12.L$0 = receiveChannel;
                channelsKt__Channels_commonKt$toCollection$12.L$1 = c3;
                channelsKt__Channels_commonKt$toCollection$12.L$2 = receiveChannel3;
                channelsKt__Channels_commonKt$toCollection$12.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$toCollection$12.L$4 = th2;
                channelsKt__Channels_commonKt$toCollection$12.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$toCollection$12.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$toCollection$12.setLabel(1);
                obj3 = channelIterator2.hasNext(channelsKt__Channels_commonKt$toCollection$12);
                if (obj3 != obj2) {
                    return obj2;
                }
                receiveChannel7 = receiveChannel;
                channelIterator3 = channelIterator2;
                receiveChannel8 = receiveChannel3;
                receiveChannel6 = receiveChannel5;
                channelsKt__Channels_commonKt$toCollection$1 = channelsKt__Channels_commonKt$toCollection$12;
                th3 = th2;
                coroutine_suspended = obj2;
                c2 = c3;
                if (!((Boolean) obj3).booleanValue()) {
                    Unit unit2 = Unit.INSTANCE;
                    receiveChannel2.cancel(th3);
                }
                Unit unit22 = Unit.INSTANCE;
                receiveChannel2.cancel(th3);
                return c2;
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$toCollection$1 = new ChannelsKt__Channels_commonKt$toCollection$1(continuation);
        Object obj42 = channelsKt__Channels_commonKt$toCollection$1.data;
        Throwable th42 = channelsKt__Channels_commonKt$toCollection$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$toCollection$1.getLabel();
        if (label == 0) {
        }
        try {
            channelsKt__Channels_commonKt$toCollection$12.L$0 = receiveChannel;
            channelsKt__Channels_commonKt$toCollection$12.L$1 = c3;
            channelsKt__Channels_commonKt$toCollection$12.L$2 = receiveChannel3;
            channelsKt__Channels_commonKt$toCollection$12.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$toCollection$12.L$4 = th2;
            channelsKt__Channels_commonKt$toCollection$12.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$toCollection$12.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$toCollection$12.setLabel(1);
            obj3 = channelIterator2.hasNext(channelsKt__Channels_commonKt$toCollection$12);
            if (obj3 != obj2) {
            }
            return obj2;
        } catch (Throwable th10) {
            th = th10;
            throw th;
        }
    }

    public static final <E> Object toList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt.toMutableList(receiveChannel, continuation);
    }

    public static final <K, V> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt.toMap(receiveChannel, new LinkedHashMap(), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.Map] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b3 A[Catch:{ all -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3 A[Catch:{ all -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$toMap$2 channelsKt__Channels_commonKt$toMap$2;
        int label;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel3;
        Object obj;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel4;
        ChannelsKt__Channels_commonKt$toMap$2 channelsKt__Channels_commonKt$toMap$22;
        Throwable th2;
        Map map;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel5;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator2;
        Object obj2;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel6;
        ChannelIterator channelIterator3;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel7;
        Object obj3;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel8;
        Throwable th3;
        M m2;
        M m3;
        if (continuation instanceof ChannelsKt__Channels_commonKt$toMap$2) {
            channelsKt__Channels_commonKt$toMap$2 = (ChannelsKt__Channels_commonKt$toMap$2) continuation;
            if ((channelsKt__Channels_commonKt$toMap$2.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$toMap$2.setLabel(channelsKt__Channels_commonKt$toMap$2.getLabel() - Integer.MIN_VALUE);
                Object obj4 = channelsKt__Channels_commonKt$toMap$2.data;
                Throwable th4 = channelsKt__Channels_commonKt$toMap$2.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$toMap$2.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$toMap$2.L$6;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$5;
                        th3 = (Throwable) channelsKt__Channels_commonKt$toMap$2.L$4;
                        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$3;
                        receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$2;
                        ?? r8 = (Map) channelsKt__Channels_commonKt$toMap$2.L$1;
                        receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$0;
                        if (th4 == null) {
                            m2 = r8;
                            obj3 = obj4;
                            receiveChannel2 = receiveChannel9;
                            channelIterator3 = channelIterator4;
                            if (!((Boolean) obj3).booleanValue()) {
                                channelsKt__Channels_commonKt$toMap$2.L$0 = receiveChannel7;
                                channelsKt__Channels_commonKt$toMap$2.L$1 = m2;
                                channelsKt__Channels_commonKt$toMap$2.L$2 = receiveChannel8;
                                channelsKt__Channels_commonKt$toMap$2.L$3 = receiveChannel2;
                                channelsKt__Channels_commonKt$toMap$2.L$4 = th3;
                                channelsKt__Channels_commonKt$toMap$2.L$5 = receiveChannel6;
                                channelsKt__Channels_commonKt$toMap$2.L$6 = channelIterator3;
                                channelsKt__Channels_commonKt$toMap$2.setLabel(2);
                                Object next = channelIterator3.next(channelsKt__Channels_commonKt$toMap$2);
                                if (next == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = coroutine_suspended;
                                th2 = th3;
                                channelsKt__Channels_commonKt$toMap$22 = channelsKt__Channels_commonKt$toMap$2;
                                receiveChannel5 = receiveChannel6;
                                receiveChannel3 = receiveChannel8;
                                channelIterator = channelIterator3;
                                receiveChannel = receiveChannel7;
                                receiveChannel4 = receiveChannel2;
                                obj4 = next;
                                map = m2;
                                Pair pair = (Pair) obj4;
                                map.put(pair.getFirst(), pair.getSecond());
                                receiveChannel2 = receiveChannel4;
                                channelIterator2 = channelIterator;
                                obj2 = obj;
                                m3 = map;
                                return coroutine_suspended;
                            }
                            Unit unit = Unit.INSTANCE;
                            receiveChannel2.cancel(th3);
                            return m2;
                        }
                        throw th4;
                    } else if (label == 2) {
                        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$toMap$2.L$6;
                        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$5;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$toMap$2.L$4;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$3;
                        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$2;
                        Map map2 = (Map) channelsKt__Channels_commonKt$toMap$2.L$1;
                        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$0;
                        if (th4 == null) {
                            map = map2;
                            obj = coroutine_suspended;
                            th2 = th5;
                            channelsKt__Channels_commonKt$toMap$22 = channelsKt__Channels_commonKt$toMap$2;
                            receiveChannel5 = receiveChannel10;
                            receiveChannel3 = receiveChannel11;
                            channelIterator = channelIterator5;
                            receiveChannel = receiveChannel12;
                            Pair pair2 = (Pair) obj4;
                            map.put(pair2.getFirst(), pair2.getSecond());
                            receiveChannel2 = receiveChannel4;
                            channelIterator2 = channelIterator;
                            obj2 = obj;
                            m3 = map;
                        } else {
                            try {
                                throw th4;
                            } catch (Throwable th6) {
                                th = th6;
                                receiveChannel2 = receiveChannel4;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th4 == null) {
                    Throwable th7 = null;
                    try {
                        channelsKt__Channels_commonKt$toMap$22 = channelsKt__Channels_commonKt$toMap$2;
                        channelIterator2 = receiveChannel.iterator();
                        obj2 = coroutine_suspended;
                        receiveChannel5 = receiveChannel;
                        m3 = m;
                        th2 = th7;
                        receiveChannel3 = receiveChannel5;
                        receiveChannel2 = receiveChannel3;
                    } catch (Throwable th8) {
                        receiveChannel2 = receiveChannel;
                        th = th8;
                        try {
                            throw th;
                        } catch (Throwable th9) {
                            receiveChannel2.cancel(th);
                            throw th9;
                        }
                    }
                } else {
                    throw th4;
                }
                channelsKt__Channels_commonKt$toMap$22.L$0 = receiveChannel;
                channelsKt__Channels_commonKt$toMap$22.L$1 = m3;
                channelsKt__Channels_commonKt$toMap$22.L$2 = receiveChannel3;
                channelsKt__Channels_commonKt$toMap$22.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$toMap$22.L$4 = th2;
                channelsKt__Channels_commonKt$toMap$22.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$toMap$22.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$toMap$22.setLabel(1);
                obj3 = channelIterator2.hasNext(channelsKt__Channels_commonKt$toMap$22);
                if (obj3 != obj2) {
                    return obj2;
                }
                receiveChannel7 = receiveChannel;
                channelIterator3 = channelIterator2;
                receiveChannel8 = receiveChannel3;
                receiveChannel6 = receiveChannel5;
                channelsKt__Channels_commonKt$toMap$2 = channelsKt__Channels_commonKt$toMap$22;
                th3 = th2;
                coroutine_suspended = obj2;
                m2 = m3;
                if (!((Boolean) obj3).booleanValue()) {
                    Unit unit2 = Unit.INSTANCE;
                    receiveChannel2.cancel(th3);
                }
                Unit unit22 = Unit.INSTANCE;
                receiveChannel2.cancel(th3);
                return m2;
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$toMap$2 = new ChannelsKt__Channels_commonKt$toMap$2(continuation);
        Object obj42 = channelsKt__Channels_commonKt$toMap$2.data;
        Throwable th42 = channelsKt__Channels_commonKt$toMap$2.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$toMap$2.getLabel();
        if (label == 0) {
        }
        try {
            channelsKt__Channels_commonKt$toMap$22.L$0 = receiveChannel;
            channelsKt__Channels_commonKt$toMap$22.L$1 = m3;
            channelsKt__Channels_commonKt$toMap$22.L$2 = receiveChannel3;
            channelsKt__Channels_commonKt$toMap$22.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$toMap$22.L$4 = th2;
            channelsKt__Channels_commonKt$toMap$22.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$toMap$22.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$toMap$22.setLabel(1);
            obj3 = channelIterator2.hasNext(channelsKt__Channels_commonKt$toMap$22);
            if (obj3 != obj2) {
            }
            return obj2;
        } catch (Throwable th10) {
            th = th10;
            throw th;
        }
    }

    public static final <E> Object toMutableList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new ArrayList(), continuation);
    }

    public static final <E> Object toSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<? extends E>> continuation) {
        return ChannelsKt.toMutableSet(receiveChannel, continuation);
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.flatMap(receiveChannel, coroutineContext, function2);
    }

    public static final <E, R> ReceiveChannel<R> flatMap(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$flatMap$1(receiveChannel, function2, null), 6, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.LinkedHashMap */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r7.cancel(r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        throw r9;
     */
    private static final <E, K> Object groupBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Continuation<? super Map<K, ? extends List<? extends E>>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                Object invoke = function1.invoke(obj);
                Object obj2 = linkedHashMap.get(invoke);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(invoke, obj2);
                }
                ((List) obj2).add(obj);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return linkedHashMap;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.LinkedHashMap */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r7.cancel(r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        throw r9;
     */
    private static final <E, K, V> Object groupBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super Map<K, ? extends List<? extends V>>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                Object invoke = function1.invoke(obj);
                Object obj2 = linkedHashMap.get(invoke);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(invoke, obj2);
                }
                ((List) obj2).add(function12.invoke(obj));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return linkedHashMap;
            }
        }
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.map(receiveChannel, coroutineContext, function2);
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$map$1(receiveChannel, function2, null), 6, null);
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "transform");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$mapIndexed$1(receiveChannel, function3, null), 6, null);
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexedNotNull(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "transform");
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3));
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.mapNotNull(receiveChannel, coroutineContext, function2);
    }

    public static final <E, R> ReceiveChannel<R> mapNotNull(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        return ChannelsKt.filterNotNull(ChannelsKt.map(receiveChannel, coroutineContext, function2));
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.withIndex(receiveChannel, coroutineContext);
    }

    public static final <E> ReceiveChannel<IndexedValue<E>> withIndex(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$withIndex$1(receiveChannel, null), 6, null);
    }

    public static final <E> ReceiveChannel<E> distinct(ReceiveChannel<? extends E> receiveChannel) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        return distinctBy$default(receiveChannel, null, new ChannelsKt__Channels_commonKt$distinct$1(null), 1, null);
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "selector");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$distinctBy$1(receiveChannel, function2, null), 6, null);
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new LinkedHashSet(), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    public static final <E> Object any(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$any$1 channelsKt__Channels_commonKt$any$1;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th2;
        Object obj;
        if (continuation instanceof ChannelsKt__Channels_commonKt$any$1) {
            channelsKt__Channels_commonKt$any$1 = (ChannelsKt__Channels_commonKt$any$1) continuation;
            if ((channelsKt__Channels_commonKt$any$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$any$1.setLabel(channelsKt__Channels_commonKt$any$1.getLabel() - Integer.MIN_VALUE);
                Object obj2 = channelsKt__Channels_commonKt$any$1.data;
                Throwable th3 = channelsKt__Channels_commonKt$any$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$any$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$any$1.L$3;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$any$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$any$1.L$1;
                        ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$any$1.L$0;
                        if (th3 == null) {
                            obj = obj2;
                            th2 = th4;
                            receiveChannel = receiveChannel2;
                        } else {
                            try {
                                throw th3;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th3 == null) {
                    th2 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$any$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$any$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$any$1.L$2 = th2;
                        channelsKt__Channels_commonKt$any$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$any$1.setLabel(1);
                        obj = it.hasNext(channelsKt__Channels_commonKt$any$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th6) {
                        receiveChannel2 = receiveChannel;
                        th = th6;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            receiveChannel2.cancel(th);
                            throw th7;
                        }
                    }
                } else {
                    throw th3;
                }
                receiveChannel.cancel(th2);
                return obj;
            }
        }
        channelsKt__Channels_commonKt$any$1 = new ChannelsKt__Channels_commonKt$any$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$any$1.data;
        Throwable th32 = channelsKt__Channels_commonKt$any$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$any$1.getLabel();
        if (label == 0) {
        }
        receiveChannel.cancel(th2);
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3 A[Catch:{ all -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1 A[Catch:{ all -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    public static final <E> Object count(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$count$1 channelsKt__Channels_commonKt$count$1;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        Throwable th2;
        ChannelsKt__Channels_commonKt$count$1 channelsKt__Channels_commonKt$count$12;
        Ref.IntRef intRef;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel5;
        Ref.IntRef intRef2;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator<? extends E> channelIterator3;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$count$1) {
            channelsKt__Channels_commonKt$count$1 = (ChannelsKt__Channels_commonKt$count$1) continuation;
            if ((channelsKt__Channels_commonKt$count$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$count$1.setLabel(channelsKt__Channels_commonKt$count$1.getLabel() - Integer.MIN_VALUE);
                Object obj2 = channelsKt__Channels_commonKt$count$1.data;
                Throwable th3 = channelsKt__Channels_commonKt$count$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$count$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$count$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$5;
                        th2 = (Throwable) channelsKt__Channels_commonKt$count$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$2;
                        Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$count$1.L$1;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$0;
                        if (th3 == null) {
                            receiveChannel4 = receiveChannel7;
                            channelsKt__Channels_commonKt$count$12 = channelsKt__Channels_commonKt$count$1;
                            receiveChannel2 = receiveChannel8;
                            receiveChannel6 = receiveChannel9;
                            intRef2 = intRef3;
                            channelIterator2 = channelIterator4;
                            if (!((Boolean) obj2).booleanValue()) {
                                channelsKt__Channels_commonKt$count$12.L$0 = receiveChannel5;
                                channelsKt__Channels_commonKt$count$12.L$1 = intRef2;
                                channelsKt__Channels_commonKt$count$12.L$2 = receiveChannel6;
                                channelsKt__Channels_commonKt$count$12.L$3 = receiveChannel2;
                                channelsKt__Channels_commonKt$count$12.L$4 = th2;
                                channelsKt__Channels_commonKt$count$12.L$5 = receiveChannel4;
                                channelsKt__Channels_commonKt$count$12.L$6 = channelIterator2;
                                channelsKt__Channels_commonKt$count$12.setLabel(2);
                                if (channelIterator2.next(channelsKt__Channels_commonKt$count$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                receiveChannel3 = receiveChannel6;
                                obj = coroutine_suspended;
                                intRef = intRef2;
                                channelIterator = channelIterator2;
                                receiveChannel = receiveChannel5;
                                intRef.element++;
                                channelIterator3 = channelIterator;
                                return coroutine_suspended;
                            }
                            Unit unit = Unit.INSTANCE;
                            receiveChannel2.cancel(th2);
                            return Integer.valueOf(intRef2.element);
                        }
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            th = th4;
                            receiveChannel2 = receiveChannel8;
                        }
                    } else if (label == 2) {
                        ChannelIterator<? extends E> channelIterator5 = (ChannelIterator) channelsKt__Channels_commonKt$count$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$5;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$count$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$2;
                        Ref.IntRef intRef4 = (Ref.IntRef) channelsKt__Channels_commonKt$count$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel13 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$0;
                        if (th3 == null) {
                            receiveChannel4 = receiveChannel10;
                            receiveChannel3 = receiveChannel12;
                            obj = coroutine_suspended;
                            intRef = intRef4;
                            channelIterator = channelIterator5;
                            receiveChannel = receiveChannel13;
                            channelsKt__Channels_commonKt$count$12 = channelsKt__Channels_commonKt$count$1;
                            receiveChannel2 = receiveChannel11;
                            th2 = th5;
                            intRef.element++;
                            channelIterator3 = channelIterator;
                        } else {
                            try {
                                throw th3;
                            } catch (Throwable th6) {
                                th = th6;
                                receiveChannel2 = receiveChannel11;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th3 == null) {
                    Ref.IntRef intRef5 = new Ref.IntRef();
                    intRef5.element = 0;
                    try {
                        th2 = null;
                        obj = coroutine_suspended;
                        channelIterator3 = receiveChannel.iterator();
                        receiveChannel4 = receiveChannel;
                        intRef = intRef5;
                        channelsKt__Channels_commonKt$count$12 = channelsKt__Channels_commonKt$count$1;
                        receiveChannel3 = receiveChannel4;
                        receiveChannel2 = receiveChannel3;
                    } catch (Throwable th7) {
                        receiveChannel2 = receiveChannel;
                        th = th7;
                        try {
                            throw th;
                        } catch (Throwable th8) {
                            receiveChannel2.cancel(th);
                            throw th8;
                        }
                    }
                } else {
                    throw th3;
                }
                channelsKt__Channels_commonKt$count$12.L$0 = receiveChannel;
                channelsKt__Channels_commonKt$count$12.L$1 = intRef;
                channelsKt__Channels_commonKt$count$12.L$2 = receiveChannel3;
                channelsKt__Channels_commonKt$count$12.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$count$12.L$4 = th2;
                channelsKt__Channels_commonKt$count$12.L$5 = receiveChannel4;
                channelsKt__Channels_commonKt$count$12.L$6 = channelIterator3;
                channelsKt__Channels_commonKt$count$12.setLabel(1);
                hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$count$12);
                if (hasNext != obj) {
                    return obj;
                }
                receiveChannel5 = receiveChannel;
                channelIterator2 = channelIterator3;
                intRef2 = intRef;
                coroutine_suspended = obj;
                receiveChannel6 = receiveChannel3;
                obj2 = hasNext;
                if (!((Boolean) obj2).booleanValue()) {
                    Unit unit2 = Unit.INSTANCE;
                }
                Unit unit22 = Unit.INSTANCE;
                receiveChannel2.cancel(th2);
                return Integer.valueOf(intRef2.element);
                return obj;
            }
        }
        channelsKt__Channels_commonKt$count$1 = new ChannelsKt__Channels_commonKt$count$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$count$1.data;
        Throwable th32 = channelsKt__Channels_commonKt$count$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$count$1.getLabel();
        if (label == 0) {
        }
        try {
            channelsKt__Channels_commonKt$count$12.L$0 = receiveChannel;
            channelsKt__Channels_commonKt$count$12.L$1 = intRef;
            channelsKt__Channels_commonKt$count$12.L$2 = receiveChannel3;
            channelsKt__Channels_commonKt$count$12.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$count$12.L$4 = th2;
            channelsKt__Channels_commonKt$count$12.L$5 = receiveChannel4;
            channelsKt__Channels_commonKt$count$12.L$6 = channelIterator3;
            channelsKt__Channels_commonKt$count$12.setLabel(1);
            hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$count$12);
            if (hasNext != obj) {
            }
            return obj;
        } catch (Throwable th9) {
            th = th9;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x012c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    public static final <E> Object maxWith(ReceiveChannel<? extends E> receiveChannel, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$maxWith$1 channelsKt__Channels_commonKt$maxWith$1;
        Object obj;
        Object coroutine_suspended;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator channelIterator;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel3;
        Comparator<? super E> comparator2;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel6;
        Comparator<? super E> comparator3;
        Throwable th3;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel7;
        Comparator<? super E> comparator4;
        ReceiveChannel<? extends E> receiveChannel8;
        if (continuation instanceof ChannelsKt__Channels_commonKt$maxWith$1) {
            channelsKt__Channels_commonKt$maxWith$1 = (ChannelsKt__Channels_commonKt$maxWith$1) continuation;
            if ((channelsKt__Channels_commonKt$maxWith$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$maxWith$1.setLabel(channelsKt__Channels_commonKt$maxWith$1.getLabel() - Integer.MIN_VALUE);
                obj = channelsKt__Channels_commonKt$maxWith$1.data;
                Throwable th4 = channelsKt__Channels_commonKt$maxWith$1.exception;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$maxWith$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$maxWith$1.L$5;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$4;
                        th3 = (Throwable) channelsKt__Channels_commonKt$maxWith$1.L$3;
                        receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$2;
                        comparator4 = (Comparator) channelsKt__Channels_commonKt$maxWith$1.L$1;
                        receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$0;
                        if (th4 != null) {
                            try {
                                throw th4;
                            } catch (Throwable th5) {
                                th = th5;
                                receiveChannel2 = receiveChannel8;
                            }
                        }
                        if (((Boolean) obj).booleanValue()) {
                            receiveChannel8.cancel(th3);
                            return null;
                        }
                        channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel7;
                        channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator4;
                        channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel8;
                        channelsKt__Channels_commonKt$maxWith$1.L$3 = th3;
                        channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel5;
                        channelsKt__Channels_commonKt$maxWith$1.L$5 = channelIterator2;
                        channelsKt__Channels_commonKt$maxWith$1.setLabel(2);
                        obj = channelIterator2.next(channelsKt__Channels_commonKt$maxWith$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel8;
                        comparator3 = comparator4;
                        receiveChannel6 = receiveChannel7;
                        channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel6;
                        channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator3;
                        channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel2;
                        channelsKt__Channels_commonKt$maxWith$1.L$3 = th3;
                        channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel5;
                        channelsKt__Channels_commonKt$maxWith$1.L$5 = channelIterator2;
                        channelsKt__Channels_commonKt$maxWith$1.L$6 = obj;
                        channelsKt__Channels_commonKt$maxWith$1.setLabel(3);
                        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$maxWith$1);
                        if (hasNext != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    } else if (label == 2) {
                        channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$maxWith$1.L$5;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$4;
                        th3 = (Throwable) channelsKt__Channels_commonKt$maxWith$1.L$3;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$2;
                        comparator3 = (Comparator) channelsKt__Channels_commonKt$maxWith$1.L$1;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$0;
                        if (th4 != null) {
                            try {
                                throw th4;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        }
                        channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel6;
                        channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator3;
                        channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel2;
                        channelsKt__Channels_commonKt$maxWith$1.L$3 = th3;
                        channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel5;
                        channelsKt__Channels_commonKt$maxWith$1.L$5 = channelIterator2;
                        channelsKt__Channels_commonKt$maxWith$1.L$6 = obj;
                        channelsKt__Channels_commonKt$maxWith$1.setLabel(3);
                        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$maxWith$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel3 = receiveChannel6;
                        comparator2 = comparator3;
                        channelIterator = channelIterator2;
                        obj2 = obj;
                        obj = hasNext;
                        th2 = th3;
                        receiveChannel4 = receiveChannel5;
                        if (!((Boolean) obj).booleanValue()) {
                            receiveChannel2.cancel(th2);
                        }
                        receiveChannel2.cancel(th2);
                        return obj2;
                        return coroutine_suspended;
                    } else if (label == 3) {
                        obj2 = channelsKt__Channels_commonKt$maxWith$1.L$6;
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$maxWith$1.L$5;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$4;
                        Throwable th7 = (Throwable) channelsKt__Channels_commonKt$maxWith$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$2;
                        comparator2 = (Comparator) channelsKt__Channels_commonKt$maxWith$1.L$1;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$0;
                        if (th4 == null) {
                            th2 = th7;
                            receiveChannel2 = receiveChannel9;
                            if (!((Boolean) obj).booleanValue()) {
                                channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator2;
                                channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel2;
                                channelsKt__Channels_commonKt$maxWith$1.L$3 = th2;
                                channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel4;
                                channelsKt__Channels_commonKt$maxWith$1.L$5 = channelIterator;
                                channelsKt__Channels_commonKt$maxWith$1.L$6 = obj2;
                                channelsKt__Channels_commonKt$maxWith$1.setLabel(4);
                                obj = channelIterator.next(channelsKt__Channels_commonKt$maxWith$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            receiveChannel2.cancel(th2);
                            return obj2;
                        }
                        throw th4;
                    } else if (label == 4) {
                        obj2 = channelsKt__Channels_commonKt$maxWith$1.L$6;
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$maxWith$1.L$5;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$4;
                        Throwable th8 = (Throwable) channelsKt__Channels_commonKt$maxWith$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$2;
                        comparator2 = (Comparator) channelsKt__Channels_commonKt$maxWith$1.L$1;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$0;
                        if (th4 == null) {
                            th2 = th8;
                            receiveChannel2 = receiveChannel10;
                        } else {
                            try {
                                throw th4;
                            } catch (Throwable th9) {
                                th = th9;
                                receiveChannel2 = receiveChannel10;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th4 == null) {
                    Throwable th10 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator;
                        channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel;
                        channelsKt__Channels_commonKt$maxWith$1.L$3 = th10;
                        channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel;
                        channelsKt__Channels_commonKt$maxWith$1.L$5 = it;
                        channelsKt__Channels_commonKt$maxWith$1.setLabel(1);
                        Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$maxWith$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel8 = receiveChannel;
                        receiveChannel7 = receiveChannel8;
                        comparator4 = comparator;
                        receiveChannel5 = receiveChannel7;
                        channelIterator2 = it;
                        th3 = th10;
                        obj = hasNext2;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } catch (Throwable th11) {
                        receiveChannel2 = receiveChannel;
                        th = th11;
                        try {
                            throw th;
                        } catch (Throwable th12) {
                            receiveChannel2.cancel(th);
                            throw th12;
                        }
                    }
                } else {
                    throw th4;
                }
                comparator3 = comparator2;
                receiveChannel6 = receiveChannel3;
                if (comparator3.compare(obj2, obj) >= 0) {
                    obj = obj2;
                }
                channelIterator2 = channelIterator;
                receiveChannel5 = receiveChannel4;
                th3 = th2;
                channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator3;
                channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel2;
                channelsKt__Channels_commonKt$maxWith$1.L$3 = th3;
                channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$maxWith$1.L$5 = channelIterator2;
                channelsKt__Channels_commonKt$maxWith$1.L$6 = obj;
                channelsKt__Channels_commonKt$maxWith$1.setLabel(3);
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$maxWith$1);
                if (hasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        channelsKt__Channels_commonKt$maxWith$1 = new ChannelsKt__Channels_commonKt$maxWith$1(continuation);
        obj = channelsKt__Channels_commonKt$maxWith$1.data;
        Throwable th42 = channelsKt__Channels_commonKt$maxWith$1.exception;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$maxWith$1.getLabel();
        if (label == 0) {
        }
        comparator3 = comparator2;
        receiveChannel6 = receiveChannel3;
        if (comparator3.compare(obj2, obj) >= 0) {
        }
        channelIterator2 = channelIterator;
        receiveChannel5 = receiveChannel4;
        th3 = th2;
        channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel6;
        channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator3;
        channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel2;
        channelsKt__Channels_commonKt$maxWith$1.L$3 = th3;
        channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel5;
        channelsKt__Channels_commonKt$maxWith$1.L$5 = channelIterator2;
        channelsKt__Channels_commonKt$maxWith$1.L$6 = obj;
        channelsKt__Channels_commonKt$maxWith$1.setLabel(3);
        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$maxWith$1);
        if (hasNext != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x012c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    public static final <E> Object minWith(ReceiveChannel<? extends E> receiveChannel, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$minWith$1 channelsKt__Channels_commonKt$minWith$1;
        Object obj;
        Object coroutine_suspended;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator channelIterator;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel3;
        Comparator<? super E> comparator2;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel6;
        Comparator<? super E> comparator3;
        Throwable th3;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel7;
        Comparator<? super E> comparator4;
        ReceiveChannel<? extends E> receiveChannel8;
        if (continuation instanceof ChannelsKt__Channels_commonKt$minWith$1) {
            channelsKt__Channels_commonKt$minWith$1 = (ChannelsKt__Channels_commonKt$minWith$1) continuation;
            if ((channelsKt__Channels_commonKt$minWith$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$minWith$1.setLabel(channelsKt__Channels_commonKt$minWith$1.getLabel() - Integer.MIN_VALUE);
                obj = channelsKt__Channels_commonKt$minWith$1.data;
                Throwable th4 = channelsKt__Channels_commonKt$minWith$1.exception;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$minWith$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$minWith$1.L$5;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$4;
                        th3 = (Throwable) channelsKt__Channels_commonKt$minWith$1.L$3;
                        receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$2;
                        comparator4 = (Comparator) channelsKt__Channels_commonKt$minWith$1.L$1;
                        receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$0;
                        if (th4 != null) {
                            try {
                                throw th4;
                            } catch (Throwable th5) {
                                th = th5;
                                receiveChannel2 = receiveChannel8;
                            }
                        }
                        if (((Boolean) obj).booleanValue()) {
                            receiveChannel8.cancel(th3);
                            return null;
                        }
                        channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel7;
                        channelsKt__Channels_commonKt$minWith$1.L$1 = comparator4;
                        channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel8;
                        channelsKt__Channels_commonKt$minWith$1.L$3 = th3;
                        channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel5;
                        channelsKt__Channels_commonKt$minWith$1.L$5 = channelIterator2;
                        channelsKt__Channels_commonKt$minWith$1.setLabel(2);
                        obj = channelIterator2.next(channelsKt__Channels_commonKt$minWith$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel8;
                        comparator3 = comparator4;
                        receiveChannel6 = receiveChannel7;
                        channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel6;
                        channelsKt__Channels_commonKt$minWith$1.L$1 = comparator3;
                        channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel2;
                        channelsKt__Channels_commonKt$minWith$1.L$3 = th3;
                        channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel5;
                        channelsKt__Channels_commonKt$minWith$1.L$5 = channelIterator2;
                        channelsKt__Channels_commonKt$minWith$1.L$6 = obj;
                        channelsKt__Channels_commonKt$minWith$1.setLabel(3);
                        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$minWith$1);
                        if (hasNext != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    } else if (label == 2) {
                        channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$minWith$1.L$5;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$4;
                        th3 = (Throwable) channelsKt__Channels_commonKt$minWith$1.L$3;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$2;
                        comparator3 = (Comparator) channelsKt__Channels_commonKt$minWith$1.L$1;
                        receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$0;
                        if (th4 != null) {
                            try {
                                throw th4;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        }
                        channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel6;
                        channelsKt__Channels_commonKt$minWith$1.L$1 = comparator3;
                        channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel2;
                        channelsKt__Channels_commonKt$minWith$1.L$3 = th3;
                        channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel5;
                        channelsKt__Channels_commonKt$minWith$1.L$5 = channelIterator2;
                        channelsKt__Channels_commonKt$minWith$1.L$6 = obj;
                        channelsKt__Channels_commonKt$minWith$1.setLabel(3);
                        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$minWith$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel3 = receiveChannel6;
                        comparator2 = comparator3;
                        channelIterator = channelIterator2;
                        obj2 = obj;
                        obj = hasNext;
                        th2 = th3;
                        receiveChannel4 = receiveChannel5;
                        if (!((Boolean) obj).booleanValue()) {
                            receiveChannel2.cancel(th2);
                        }
                        receiveChannel2.cancel(th2);
                        return obj2;
                        return coroutine_suspended;
                    } else if (label == 3) {
                        obj2 = channelsKt__Channels_commonKt$minWith$1.L$6;
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$minWith$1.L$5;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$4;
                        Throwable th7 = (Throwable) channelsKt__Channels_commonKt$minWith$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$2;
                        comparator2 = (Comparator) channelsKt__Channels_commonKt$minWith$1.L$1;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$0;
                        if (th4 == null) {
                            th2 = th7;
                            receiveChannel2 = receiveChannel9;
                            if (!((Boolean) obj).booleanValue()) {
                                channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$minWith$1.L$1 = comparator2;
                                channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel2;
                                channelsKt__Channels_commonKt$minWith$1.L$3 = th2;
                                channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel4;
                                channelsKt__Channels_commonKt$minWith$1.L$5 = channelIterator;
                                channelsKt__Channels_commonKt$minWith$1.L$6 = obj2;
                                channelsKt__Channels_commonKt$minWith$1.setLabel(4);
                                obj = channelIterator.next(channelsKt__Channels_commonKt$minWith$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            receiveChannel2.cancel(th2);
                            return obj2;
                        }
                        throw th4;
                    } else if (label == 4) {
                        obj2 = channelsKt__Channels_commonKt$minWith$1.L$6;
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$minWith$1.L$5;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$4;
                        Throwable th8 = (Throwable) channelsKt__Channels_commonKt$minWith$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$2;
                        comparator2 = (Comparator) channelsKt__Channels_commonKt$minWith$1.L$1;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$0;
                        if (th4 == null) {
                            th2 = th8;
                            receiveChannel2 = receiveChannel10;
                        } else {
                            try {
                                throw th4;
                            } catch (Throwable th9) {
                                th = th9;
                                receiveChannel2 = receiveChannel10;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th4 == null) {
                    Throwable th10 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$minWith$1.L$1 = comparator;
                        channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel;
                        channelsKt__Channels_commonKt$minWith$1.L$3 = th10;
                        channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel;
                        channelsKt__Channels_commonKt$minWith$1.L$5 = it;
                        channelsKt__Channels_commonKt$minWith$1.setLabel(1);
                        Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$minWith$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel8 = receiveChannel;
                        receiveChannel7 = receiveChannel8;
                        comparator4 = comparator;
                        receiveChannel5 = receiveChannel7;
                        channelIterator2 = it;
                        th3 = th10;
                        obj = hasNext2;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } catch (Throwable th11) {
                        receiveChannel2 = receiveChannel;
                        th = th11;
                        try {
                            throw th;
                        } catch (Throwable th12) {
                            receiveChannel2.cancel(th);
                            throw th12;
                        }
                    }
                } else {
                    throw th4;
                }
                comparator3 = comparator2;
                receiveChannel6 = receiveChannel3;
                if (comparator3.compare(obj2, obj) <= 0) {
                    obj = obj2;
                }
                channelIterator2 = channelIterator;
                receiveChannel5 = receiveChannel4;
                th3 = th2;
                channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$minWith$1.L$1 = comparator3;
                channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel2;
                channelsKt__Channels_commonKt$minWith$1.L$3 = th3;
                channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$minWith$1.L$5 = channelIterator2;
                channelsKt__Channels_commonKt$minWith$1.L$6 = obj;
                channelsKt__Channels_commonKt$minWith$1.setLabel(3);
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$minWith$1);
                if (hasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        channelsKt__Channels_commonKt$minWith$1 = new ChannelsKt__Channels_commonKt$minWith$1(continuation);
        obj = channelsKt__Channels_commonKt$minWith$1.data;
        Throwable th42 = channelsKt__Channels_commonKt$minWith$1.exception;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$minWith$1.getLabel();
        if (label == 0) {
        }
        comparator3 = comparator2;
        receiveChannel6 = receiveChannel3;
        if (comparator3.compare(obj2, obj) <= 0) {
        }
        channelIterator2 = channelIterator;
        receiveChannel5 = receiveChannel4;
        th3 = th2;
        channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel6;
        channelsKt__Channels_commonKt$minWith$1.L$1 = comparator3;
        channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel2;
        channelsKt__Channels_commonKt$minWith$1.L$3 = th3;
        channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel5;
        channelsKt__Channels_commonKt$minWith$1.L$5 = channelIterator2;
        channelsKt__Channels_commonKt$minWith$1.L$6 = obj;
        channelsKt__Channels_commonKt$minWith$1.setLabel(3);
        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$minWith$1);
        if (hasNext != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073 A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074 A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    public static final <E> Object none(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$none$1 channelsKt__Channels_commonKt$none$1;
        int label;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th2;
        Object obj;
        if (continuation instanceof ChannelsKt__Channels_commonKt$none$1) {
            channelsKt__Channels_commonKt$none$1 = (ChannelsKt__Channels_commonKt$none$1) continuation;
            if ((channelsKt__Channels_commonKt$none$1.getLabel() & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$none$1.setLabel(channelsKt__Channels_commonKt$none$1.getLabel() - Integer.MIN_VALUE);
                Object obj2 = channelsKt__Channels_commonKt$none$1.data;
                Throwable th3 = channelsKt__Channels_commonKt$none$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = channelsKt__Channels_commonKt$none$1.getLabel();
                boolean z = true;
                if (label == 0) {
                    if (label == 1) {
                        ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$none$1.L$3;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$none$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$none$1.L$1;
                        ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$none$1.L$0;
                        if (th3 == null) {
                            obj = obj2;
                            th2 = th4;
                            receiveChannel = receiveChannel2;
                        } else {
                            try {
                                throw th3;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th3 == null) {
                    th2 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$none$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$none$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$none$1.L$2 = th2;
                        channelsKt__Channels_commonKt$none$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$none$1.setLabel(1);
                        obj = it.hasNext(channelsKt__Channels_commonKt$none$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th6) {
                        receiveChannel2 = receiveChannel;
                        th = th6;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            receiveChannel2.cancel(th);
                            throw th7;
                        }
                    }
                } else {
                    throw th3;
                }
                if (!((Boolean) obj).booleanValue()) {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                receiveChannel.cancel(th2);
                return valueOf;
            }
        }
        channelsKt__Channels_commonKt$none$1 = new ChannelsKt__Channels_commonKt$none$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$none$1.data;
        Throwable th32 = channelsKt__Channels_commonKt$none$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = channelsKt__Channels_commonKt$none$1.getLabel();
        boolean z2 = true;
        if (label == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
        Boolean valueOf2 = Boolean.valueOf(z2);
        receiveChannel.cancel(th2);
        return valueOf2;
    }

    public static final <E> ReceiveChannel<E> requireNoNulls(ReceiveChannel<? extends E> receiveChannel) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        return map$default(receiveChannel, null, new ChannelsKt__Channels_commonKt$requireNoNulls$1(receiveChannel, null), 1, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.ArrayList */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r7.cancel(r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        throw r9;
     */
    private static final <E> Object partition(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Pair<? extends List<? extends E>, ? extends List<? extends E>>> continuation) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                if (function1.invoke(obj).booleanValue()) {
                    arrayList.add(obj);
                } else {
                    arrayList2.add(obj);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return new Pair(arrayList, arrayList2);
            }
        }
    }

    public static final <E, R> ReceiveChannel<Pair<E, R>> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(receiveChannel2, "other");
        return zip$default(receiveChannel, receiveChannel2, null, ChannelsKt__Channels_commonKt$zip$1.INSTANCE, 2, null);
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Unconfined.INSTANCE;
        }
        return ChannelsKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext coroutineContext, Function2<? super E, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(receiveChannel2, "other");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        return ProduceKt.produce$default(coroutineContext, 0, null, ChannelsKt.consumesAll(receiveChannel, receiveChannel2), new ChannelsKt__Channels_commonKt$zip$2(receiveChannel, receiveChannel2, function2, null), 6, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.coroutines.experimental.Continuation<? super kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    private static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        try {
            ChannelIterator<E> it = openSubscription.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    return Unit.INSTANCE;
                }
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                function1.invoke((Object) it.next(continuation));
            }
        } finally {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default(openSubscription, null, 1, null);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        throw r7;
     */
    private static final <E> Object consumeEach(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                function1.invoke((Object) it.next(continuation));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return unit;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r8.cancel(r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        throw r10;
     */
    private static final <E> Object consumeEachIndexed(ReceiveChannel<? extends E> receiveChannel, Function1<? super IndexedValue<? extends E>, Unit> function1, Continuation<? super Unit> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                function1.invoke(new IndexedValue(i, next));
                i++;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r7.cancel(r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        throw r9;
     */
    private static final <E> Object elementAtOrElse(ReceiveChannel<? extends E> receiveChannel, int i, Function1<? super Integer, ? extends E> function1, Continuation<? super E> continuation) {
        Object invoke;
        int i2;
        Throwable th = null;
        if (i >= 0) {
            ChannelIterator<? extends E> it = receiveChannel.iterator();
            int i3 = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    invoke = function1.invoke(Integer.valueOf(i));
                    i2 = 2;
                    InlineMarker.finallyStart(2);
                    break;
                }
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                int i4 = i3 + 1;
                if (i == i3) {
                    InlineMarker.finallyStart(3);
                    receiveChannel.cancel(th);
                    InlineMarker.finallyEnd(3);
                    return next;
                }
                i3 = i4;
            }
        } else {
            invoke = function1.invoke(Integer.valueOf(i));
            i2 = 4;
            InlineMarker.finallyStart(4);
        }
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(i2);
        return invoke;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0057, code lost:
        throw r8;
     */
    private static final <E> Object find(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        Object obj;
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return null;
            }
        } while (!function1.invoke(obj).booleanValue());
        InlineMarker.finallyStart(2);
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(2);
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        throw r8;
     */
    private static final <E> Object findLast(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        Object obj = null;
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                if (function1.invoke(next).booleanValue()) {
                    obj = next;
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return obj;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        throw r7;
     */
    private static final <E> Object first(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        Object obj;
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
            }
        } while (!function1.invoke(obj).booleanValue());
        InlineMarker.finallyStart(2);
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(2);
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
        throw r8;
     */
    private static final <E> Object firstOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        Object obj;
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return null;
            }
        } while (!function1.invoke(obj).booleanValue());
        InlineMarker.finallyStart(2);
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(2);
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        throw r8;
     */
    private static final <E> Object indexOfFirst(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                if (function1.invoke((Object) it.next(continuation)).booleanValue()) {
                    Integer valueOf = Integer.valueOf(i);
                    InlineMarker.finallyStart(2);
                    receiveChannel.cancel(th);
                    InlineMarker.finallyEnd(2);
                    return valueOf;
                }
                i++;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return -1;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r7.cancel(r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        throw r9;
     */
    private static final <E> Object indexOfLast(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = -1;
        int i2 = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                if (function1.invoke((Object) it.next(continuation)).booleanValue()) {
                    i = i2;
                }
                i2++;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return Integer.valueOf(i);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r8.cancel(r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        throw r10;
     */
    private static final <E> Object last(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        Object obj = null;
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        boolean z = false;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (!((Boolean) hasNext).booleanValue()) {
                break;
            }
            InlineMarker.mark(0);
            Object next = it.next(continuation);
            InlineMarker.mark(1);
            if (function1.invoke(next).booleanValue()) {
                obj = next;
                z = true;
            }
        }
        Unit unit = Unit.INSTANCE;
        InlineMarker.finallyStart(1);
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(1);
        if (z) {
            return obj;
        }
        throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        throw r8;
     */
    private static final <E> Object lastOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        Object obj = null;
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                if (function1.invoke(next).booleanValue()) {
                    obj = next;
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return obj;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r8.cancel(r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        throw r10;
     */
    private static final <E> Object single(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        Object obj = null;
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        boolean z = false;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                if (function1.invoke(next).booleanValue()) {
                    if (!z) {
                        obj = next;
                        z = true;
                    } else {
                        throw new IllegalArgumentException("ReceiveChannel contains more than one matching element.");
                    }
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                if (z) {
                    return obj;
                }
                throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r9.cancel(r10);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        throw r11;
     */
    private static final <E> Object singleOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        Object obj = null;
        boolean z = false;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                if (function1.invoke(next).booleanValue()) {
                    if (z) {
                        InlineMarker.finallyStart(2);
                        receiveChannel.cancel(th);
                        InlineMarker.finallyEnd(2);
                        return null;
                    }
                    obj = next;
                    z = true;
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                if (!z) {
                    return null;
                }
                return obj;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: C extends java.util.Collection<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r8.cancel(r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0063, code lost:
        throw r10;
     */
    private static final <E, C extends Collection<? super E>> Object filterIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, Boolean> function2, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                int i2 = i + 1;
                IndexedValue indexedValue = new IndexedValue(i, next);
                int component1 = indexedValue.component1();
                Object obj = (Object) indexedValue.component2();
                if (function2.invoke(Integer.valueOf(component1), obj).booleanValue()) {
                    c.add(obj);
                }
                i = i2;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: C extends kotlinx.coroutines.experimental.channels.SendChannel<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0062, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0063, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r8.cancel(r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006d, code lost:
        throw r10;
     */
    private static final <E, C extends SendChannel<? super E>> Object filterIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, Boolean> function2, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                int i2 = i + 1;
                IndexedValue indexedValue = new IndexedValue(i, next);
                int component1 = indexedValue.component1();
                Object obj = (Object) indexedValue.component2();
                if (function2.invoke(Integer.valueOf(component1), obj).booleanValue()) {
                    InlineMarker.mark(0);
                    c.send(obj, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                }
                i = i2;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: C extends java.util.Collection<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        throw r7;
     */
    private static final <E, C extends Collection<? super E>> Object filterNotTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                if (!function1.invoke(obj).booleanValue()) {
                    c.add(obj);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: C extends kotlinx.coroutines.experimental.channels.SendChannel<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        throw r8;
     */
    private static final <E, C extends SendChannel<? super E>> Object filterNotTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                if (!function1.invoke(obj).booleanValue()) {
                    InlineMarker.mark(0);
                    c.send(obj, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: C extends java.util.Collection<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        throw r7;
     */
    private static final <E, C extends Collection<? super E>> Object filterTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                if (function1.invoke(obj).booleanValue()) {
                    c.add(obj);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: C extends kotlinx.coroutines.experimental.channels.SendChannel<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        throw r8;
     */
    private static final <E, C extends SendChannel<? super E>> Object filterTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                if (function1.invoke(obj).booleanValue()) {
                    InlineMarker.mark(0);
                    c.send(obj, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, ? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        throw r7;
     */
    private static final <E, K, M extends Map<? super K, ? super E>> Object associateByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Continuation<? super M> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                m.put(function1.invoke(obj), obj);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return m;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        throw r7;
     */
    private static final <E, K, V, M extends Map<? super K, ? super V>> Object associateByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super M> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                m.put(function1.invoke(obj), function12.invoke(obj));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return m;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
        throw r7;
     */
    private static final <E, K, V, M extends Map<? super K, ? super V>> Object associateTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends Pair<? extends K, ? extends V>> function1, Continuation<? super M> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                Pair pair = (Pair) function1.invoke((Object) it.next(continuation));
                m.put(pair.getFirst(), pair.getSecond());
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return m;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: M extends java.util.Map<? super K, java.util.List<E>> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        throw r8;
     */
    private static final <E, K, M extends Map<? super K, List<E>>> Object groupByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Continuation<? super M> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                Object invoke = function1.invoke(obj);
                Object obj2 = m.get(invoke);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    m.put(invoke, obj2);
                }
                ((List) obj2).add(obj);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return m;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: M extends java.util.Map<? super K, java.util.List<V>> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        throw r8;
     */
    private static final <E, K, V, M extends Map<? super K, List<V>>> Object groupByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super M> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object obj = (Object) it.next(continuation);
                InlineMarker.mark(1);
                Object invoke = function1.invoke(obj);
                Object obj2 = m.get(invoke);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    m.put(invoke, obj2);
                }
                ((List) obj2).add(function12.invoke(obj));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return m;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: C extends java.util.Collection<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r8.cancel(r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        throw r10;
     */
    private static final <E, R, C extends Collection<? super R>> Object mapIndexedNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                int i2 = i + 1;
                IndexedValue indexedValue = new IndexedValue(i, next);
                Object invoke = function2.invoke(Integer.valueOf(indexedValue.component1()), (Object) indexedValue.component2());
                if (invoke != null) {
                    c.add(invoke);
                }
                i = i2;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: C extends kotlinx.coroutines.experimental.channels.SendChannel<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r8.cancel(r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        throw r10;
     */
    private static final <E, R, C extends SendChannel<? super R>> Object mapIndexedNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                int i2 = i + 1;
                IndexedValue indexedValue = new IndexedValue(i, next);
                Object invoke = function2.invoke(Integer.valueOf(indexedValue.component1()), (Object) indexedValue.component2());
                if (invoke != null) {
                    InlineMarker.mark(0);
                    c.send(invoke, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                }
                i = i2;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: C extends java.util.Collection<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r7.cancel(r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        throw r9;
     */
    private static final <E, R, C extends Collection<? super R>> Object mapIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                c.add(function2.invoke(Integer.valueOf(i), (Object) it.next(continuation)));
                i++;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: C extends kotlinx.coroutines.experimental.channels.SendChannel<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r7.cancel(r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        throw r9;
     */
    private static final <E, R, C extends SendChannel<? super R>> Object mapIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                int i2 = i + 1;
                Object invoke = function2.invoke(Integer.valueOf(i), (Object) it.next(continuation));
                InlineMarker.mark(0);
                c.send(invoke, continuation);
                InlineMarker.mark(2);
                InlineMarker.mark(1);
                i = i2;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: C extends java.util.Collection<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        throw r7;
     */
    private static final <E, R, C extends Collection<? super R>> Object mapNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                Object invoke = function1.invoke((Object) it.next(continuation));
                if (invoke != null) {
                    c.add(invoke);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: C extends kotlinx.coroutines.experimental.channels.SendChannel<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        throw r7;
     */
    private static final <E, R, C extends SendChannel<? super R>> Object mapNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                Object invoke = function1.invoke((Object) it.next(continuation));
                if (invoke != null) {
                    InlineMarker.mark(0);
                    c.send(invoke, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: C extends java.util.Collection<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        throw r7;
     */
    private static final <E, R, C extends Collection<? super R>> Object mapTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                c.add(function1.invoke((Object) it.next(continuation)));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: C extends kotlinx.coroutines.experimental.channels.SendChannel<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
        throw r7;
     */
    private static final <E, R, C extends SendChannel<? super R>> Object mapTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                Object invoke = function1.invoke((Object) it.next(continuation));
                InlineMarker.mark(0);
                c.send(invoke, continuation);
                InlineMarker.mark(2);
                InlineMarker.mark(1);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return c;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        throw r7;
     */
    private static final <E> Object all(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return true;
            }
        } while (function1.invoke((Object) it.next(continuation)).booleanValue());
        InlineMarker.finallyStart(2);
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(2);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        throw r7;
     */
    private static final <E> Object any(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return false;
            }
        } while (!function1.invoke((Object) it.next(continuation)).booleanValue());
        InlineMarker.finallyStart(2);
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(2);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        throw r8;
     */
    private static final <E> Object count(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                if (function1.invoke((Object) it.next(continuation)).booleanValue()) {
                    i++;
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return Integer.valueOf(i);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: ? super R */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        throw r7;
     */
    private static final <E, R> Object fold(ReceiveChannel<? extends E> receiveChannel, R r, Function2<? super R, ? super E, ? extends R> function2, Continuation<? super R> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        R r2 = r;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                r2 = (Object) function2.invoke(r2, (Object) it.next(continuation));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return r2;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v3, resolved type: ? super R */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r7.cancel(r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        throw r9;
     */
    private static final <E, R> Object foldIndexed(ReceiveChannel<? extends E> receiveChannel, R r, Function3<? super Integer, ? super R, ? super E, ? extends R> function3, Continuation<? super R> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = 0;
        R r2 = r;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                i++;
                r2 = (Object) function3.invoke(Integer.valueOf(i), r2, (Object) it.next(continuation));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return r2;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r9.cancel(r10);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0074, code lost:
        throw r11;
     */
    private static final <E, R extends Comparable<? super R>> Object maxBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends R> function1, Continuation<? super E> continuation) {
        int i;
        Object obj = null;
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        InlineMarker.mark(0);
        Object hasNext = it.hasNext(continuation);
        InlineMarker.mark(1);
        if (!((Boolean) hasNext).booleanValue()) {
            i = 3;
            InlineMarker.finallyStart(3);
        } else {
            InlineMarker.mark(0);
            obj = it.next(continuation);
            InlineMarker.mark(1);
            Comparable comparable = (Comparable) function1.invoke(obj);
            while (true) {
                InlineMarker.mark(0);
                Object hasNext2 = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext2).booleanValue()) {
                    break;
                }
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                Comparable comparable2 = (Comparable) function1.invoke(next);
                if (comparable.compareTo(comparable2) < 0) {
                    obj = next;
                    comparable = comparable2;
                }
            }
            i = 2;
            InlineMarker.finallyStart(2);
        }
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(i);
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r9.cancel(r10);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0074, code lost:
        throw r11;
     */
    private static final <E, R extends Comparable<? super R>> Object minBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends R> function1, Continuation<? super E> continuation) {
        int i;
        Object obj = null;
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        InlineMarker.mark(0);
        Object hasNext = it.hasNext(continuation);
        InlineMarker.mark(1);
        if (!((Boolean) hasNext).booleanValue()) {
            i = 3;
            InlineMarker.finallyStart(3);
        } else {
            InlineMarker.mark(0);
            obj = it.next(continuation);
            InlineMarker.mark(1);
            Comparable comparable = (Comparable) function1.invoke(obj);
            while (true) {
                InlineMarker.mark(0);
                Object hasNext2 = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext2).booleanValue()) {
                    break;
                }
                InlineMarker.mark(0);
                Object next = it.next(continuation);
                InlineMarker.mark(1);
                Comparable comparable2 = (Comparable) function1.invoke(next);
                if (comparable.compareTo(comparable2) > 0) {
                    obj = next;
                    comparable = comparable2;
                }
            }
            i = 2;
            InlineMarker.finallyStart(2);
        }
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(i);
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r5.cancel(r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        throw r7;
     */
    private static final <E> Object none(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return true;
            }
        } while (!function1.invoke((Object) it.next(continuation)).booleanValue());
        InlineMarker.finallyStart(2);
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(2);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        throw r8;
     */
    private static final <S, E extends S> Object reduce(ReceiveChannel<? extends E> receiveChannel, Function2<? super S, ? super E, ? extends S> function2, Continuation<? super S> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        InlineMarker.mark(0);
        Object hasNext = it.hasNext(continuation);
        InlineMarker.mark(1);
        if (((Boolean) hasNext).booleanValue()) {
            InlineMarker.mark(0);
            Object obj = (Object) it.next(continuation);
            InlineMarker.mark(1);
            while (true) {
                InlineMarker.mark(0);
                Object hasNext2 = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext2).booleanValue()) {
                    InlineMarker.mark(0);
                    InlineMarker.mark(1);
                    obj = (Object) function2.invoke(obj, (Object) it.next(continuation));
                } else {
                    InlineMarker.finallyStart(2);
                    receiveChannel.cancel(th);
                    InlineMarker.finallyEnd(2);
                    return obj;
                }
            }
        } else {
            throw new UnsupportedOperationException("Empty channel can't be reduced.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0064, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r8.cancel(r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006f, code lost:
        throw r10;
     */
    private static final <S, E extends S> Object reduceIndexed(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super S, ? super E, ? extends S> function3, Continuation<? super S> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        InlineMarker.mark(0);
        Object hasNext = it.hasNext(continuation);
        InlineMarker.mark(1);
        if (((Boolean) hasNext).booleanValue()) {
            InlineMarker.mark(0);
            Object obj = (Object) it.next(continuation);
            InlineMarker.mark(1);
            int i = 1;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext2 = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext2).booleanValue()) {
                    Integer valueOf = Integer.valueOf(i);
                    i++;
                    InlineMarker.mark(0);
                    InlineMarker.mark(1);
                    obj = (Object) function3.invoke(valueOf, obj, (Object) it.next(continuation));
                } else {
                    InlineMarker.finallyStart(2);
                    receiveChannel.cancel(th);
                    InlineMarker.finallyEnd(2);
                    return obj;
                }
            }
        } else {
            throw new UnsupportedOperationException("Empty channel can't be reduced.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r6.cancel(r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        throw r8;
     */
    private static final <E> Object sumBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Integer> function1, Continuation<? super Integer> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                i += function1.invoke((Object) it.next(continuation)).intValue();
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return Integer.valueOf(i);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r7.cancel(r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
        throw r9;
     */
    private static final <E> Object sumByDouble(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Double> function1, Continuation<? super Double> continuation) {
        Throwable th = null;
        ChannelIterator<? extends E> it = receiveChannel.iterator();
        double d = 0.0d;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                InlineMarker.mark(0);
                InlineMarker.mark(1);
                d += function1.invoke((Object) it.next(continuation)).doubleValue();
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                receiveChannel.cancel(th);
                InlineMarker.finallyEnd(1);
                return Double.valueOf(d);
            }
        }
    }
}
