package kotlinx.coroutines.channels;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.PublishedApi;
import kotlin.collections.l;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b11;
import tb.hf0;
import tb.k12;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class ChannelsKt__Channels_commonKt {
    @PublishedApi
    public static final void a(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = hf0.a("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.cancel(cancellationException);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @ObsoleteCoroutinesApi
    @Nullable
    public static final <E> Object b(@NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function1<? super E, ur2> function1, @NotNull Continuation<? super ur2> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$3;
        Object obj;
        int i;
        ReceiveChannel<E> receiveChannel;
        Throwable th;
        ReceiveChannel<E> receiveChannel2;
        ChannelIterator<E> channelIterator;
        Object hasNext;
        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$32;
        ReceiveChannel<E> receiveChannel3;
        ChannelIterator<E> channelIterator2;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$3) {
            channelsKt__Channels_commonKt$consumeEach$3 = (ChannelsKt__Channels_commonKt$consumeEach$3) continuation;
            int i2 = channelsKt__Channels_commonKt$consumeEach$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEach$3.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$consumeEach$3.result;
                Object obj2 = b.d();
                i = channelsKt__Channels_commonKt$consumeEach$3.label;
                if (i != 0) {
                    k12.b(obj);
                    ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
                    try {
                        receiveChannel2 = openSubscription;
                        channelIterator = openSubscription.iterator();
                    } catch (Throwable th2) {
                        receiveChannel = openSubscription;
                        th = th2;
                        b11.b(1);
                        ReceiveChannel.DefaultImpls.b(receiveChannel, null, 1, null);
                        b11.a(1);
                        throw th;
                    }
                    try {
                        channelsKt__Channels_commonKt$consumeEach$3.L$0 = function1;
                        channelsKt__Channels_commonKt$consumeEach$3.L$1 = receiveChannel2;
                        channelsKt__Channels_commonKt$consumeEach$3.L$2 = channelIterator;
                        channelsKt__Channels_commonKt$consumeEach$3.label = 1;
                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$consumeEach$3);
                        if (hasNext != obj2) {
                            return obj2;
                        }
                        channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
                        receiveChannel3 = receiveChannel2;
                        obj = hasNext;
                        channelIterator2 = channelIterator;
                        return obj2;
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel = receiveChannel2;
                        b11.b(1);
                        ReceiveChannel.DefaultImpls.b(receiveChannel, null, 1, null);
                        b11.a(1);
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$3.L$2;
                    receiveChannel = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$1;
                    Function1<? super E, ur2> function12 = (Function1) channelsKt__Channels_commonKt$consumeEach$3.L$0;
                    try {
                        k12.b(obj);
                        channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
                        receiveChannel3 = receiveChannel;
                        function1 = function12;
                        channelIterator2 = channelIterator3;
                    } catch (Throwable th4) {
                        th = th4;
                        b11.b(1);
                        ReceiveChannel.DefaultImpls.b(receiveChannel, null, 1, null);
                        b11.a(1);
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    function1.invoke(channelIterator2.next());
                    receiveChannel2 = receiveChannel3;
                    channelsKt__Channels_commonKt$consumeEach$3 = channelsKt__Channels_commonKt$consumeEach$32;
                    obj2 = obj2;
                    channelIterator = channelIterator2;
                    channelsKt__Channels_commonKt$consumeEach$3.L$0 = function1;
                    channelsKt__Channels_commonKt$consumeEach$3.L$1 = receiveChannel2;
                    channelsKt__Channels_commonKt$consumeEach$3.L$2 = channelIterator;
                    channelsKt__Channels_commonKt$consumeEach$3.label = 1;
                    hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$consumeEach$3);
                    if (hasNext != obj2) {
                    }
                    return obj2;
                }
                ur2 ur2 = ur2.INSTANCE;
                b11.b(1);
                ReceiveChannel.DefaultImpls.b(receiveChannel3, null, 1, null);
                b11.a(1);
                return ur2;
            }
        }
        channelsKt__Channels_commonKt$consumeEach$3 = new ChannelsKt__Channels_commonKt$consumeEach$3(continuation);
        obj = channelsKt__Channels_commonKt$consumeEach$3.result;
        Object obj22 = b.d();
        i = channelsKt__Channels_commonKt$consumeEach$3.label;
        if (i != 0) {
        }
        try {
            if (!((Boolean) obj).booleanValue()) {
                ur2 ur22 = ur2.INSTANCE;
            }
            ur2 ur222 = ur2.INSTANCE;
            b11.b(1);
            ReceiveChannel.DefaultImpls.b(receiveChannel3, null, 1, null);
            b11.a(1);
            return ur222;
        } catch (Throwable th5) {
            th = th5;
            receiveChannel = receiveChannel3;
            b11.b(1);
            ReceiveChannel.DefaultImpls.b(receiveChannel, null, 1, null);
            b11.a(1);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <E> Object c(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, ur2> function1, @NotNull Continuation<? super ur2> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$1 channelsKt__Channels_commonKt$consumeEach$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ChannelIterator<? extends E> channelIterator;
        Function1<? super E, ur2> function12;
        Function1<? super E, ur2> function13;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$1) {
            channelsKt__Channels_commonKt$consumeEach$1 = (ChannelsKt__Channels_commonKt$consumeEach$1) continuation;
            int i2 = channelsKt__Channels_commonKt$consumeEach$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEach$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$consumeEach$1.result;
                obj = b.d();
                i = channelsKt__Channels_commonKt$consumeEach$1.label;
                if (i != 0) {
                    k12.b(obj2);
                    try {
                        receiveChannel2 = receiveChannel;
                        channelIterator2 = receiveChannel.iterator();
                        function13 = function1;
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            b11.b(1);
                            b.b(receiveChannel2, th);
                            b11.a(1);
                            throw th3;
                        }
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$1.L$1;
                    function12 = (Function1) channelsKt__Channels_commonKt$consumeEach$1.L$0;
                    try {
                        k12.b(obj2);
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj2).booleanValue()) {
                            function12.invoke((Object) channelIterator.next());
                            function13 = function12;
                            channelIterator2 = channelIterator;
                        }
                        ur2 ur2 = ur2.INSTANCE;
                        b11.b(1);
                        b.b(receiveChannel2, null);
                        b11.a(1);
                        return ur2;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$consumeEach$1.L$0 = function13;
                channelsKt__Channels_commonKt$consumeEach$1.L$1 = receiveChannel2;
                channelsKt__Channels_commonKt$consumeEach$1.L$2 = channelIterator2;
                channelsKt__Channels_commonKt$consumeEach$1.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$consumeEach$1);
                if (hasNext != obj) {
                    return obj;
                }
                function12 = function13;
                obj2 = hasNext;
                channelIterator = channelIterator2;
                if (!((Boolean) obj2).booleanValue()) {
                    ur2 ur22 = ur2.INSTANCE;
                    b11.b(1);
                    b.b(receiveChannel2, null);
                    b11.a(1);
                }
                ur2 ur222 = ur2.INSTANCE;
                b11.b(1);
                b.b(receiveChannel2, null);
                b11.a(1);
                return ur222;
                return obj;
            }
        }
        channelsKt__Channels_commonKt$consumeEach$1 = new ChannelsKt__Channels_commonKt$consumeEach$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$consumeEach$1.result;
        obj = b.d();
        i = channelsKt__Channels_commonKt$consumeEach$1.label;
        if (i != 0) {
        }
        channelsKt__Channels_commonKt$consumeEach$1.L$0 = function13;
        channelsKt__Channels_commonKt$consumeEach$1.L$1 = receiveChannel2;
        channelsKt__Channels_commonKt$consumeEach$1.L$2 = channelIterator2;
        channelsKt__Channels_commonKt$consumeEach$1.label = 1;
        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$consumeEach$1);
        if (hasNext != obj) {
        }
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <E> Object d(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super List<? extends E>> continuation) {
        ChannelsKt__Channels_commonKt$toList$1 channelsKt__Channels_commonKt$toList$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ChannelIterator<? extends E> channelIterator;
        List list;
        List list2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator2;
        List list3;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$toList$1) {
            channelsKt__Channels_commonKt$toList$1 = (ChannelsKt__Channels_commonKt$toList$1) continuation;
            int i2 = channelsKt__Channels_commonKt$toList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$toList$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$toList$1.result;
                obj = b.d();
                i = channelsKt__Channels_commonKt$toList$1.label;
                if (i != 0) {
                    k12.b(obj2);
                    try {
                        List list4 = l.c();
                        list = list4;
                        receiveChannel2 = receiveChannel;
                        channelIterator2 = receiveChannel.iterator();
                        list3 = list4;
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            b.b(receiveChannel2, th);
                            throw th3;
                        }
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$toList$1.L$3;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$toList$1.L$2;
                    List list5 = (List) channelsKt__Channels_commonKt$toList$1.L$1;
                    list = (List) channelsKt__Channels_commonKt$toList$1.L$0;
                    try {
                        k12.b(obj2);
                        list2 = list5;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj2).booleanValue()) {
                            list2.add(channelIterator.next());
                            receiveChannel2 = receiveChannel3;
                            list3 = list2;
                            channelIterator2 = channelIterator;
                        }
                        ur2 ur2 = ur2.INSTANCE;
                        b.b(receiveChannel3, null);
                        return l.a(list);
                    } catch (Throwable th4) {
                        th = th4;
                        receiveChannel2 = receiveChannel3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$toList$1.L$0 = list;
                channelsKt__Channels_commonKt$toList$1.L$1 = list3;
                channelsKt__Channels_commonKt$toList$1.L$2 = receiveChannel2;
                channelsKt__Channels_commonKt$toList$1.L$3 = channelIterator2;
                channelsKt__Channels_commonKt$toList$1.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$toList$1);
                if (hasNext != obj) {
                    return obj;
                }
                receiveChannel3 = receiveChannel2;
                obj2 = hasNext;
                list2 = list3;
                channelIterator = channelIterator2;
                if (!((Boolean) obj2).booleanValue()) {
                    ur2 ur22 = ur2.INSTANCE;
                    b.b(receiveChannel3, null);
                }
                ur2 ur222 = ur2.INSTANCE;
                b.b(receiveChannel3, null);
                return l.a(list);
                return obj;
            }
        }
        channelsKt__Channels_commonKt$toList$1 = new ChannelsKt__Channels_commonKt$toList$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$toList$1.result;
        obj = b.d();
        i = channelsKt__Channels_commonKt$toList$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$toList$1.L$0 = list;
            channelsKt__Channels_commonKt$toList$1.L$1 = list3;
            channelsKt__Channels_commonKt$toList$1.L$2 = receiveChannel2;
            channelsKt__Channels_commonKt$toList$1.L$3 = channelIterator2;
            channelsKt__Channels_commonKt$toList$1.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$toList$1);
            if (hasNext != obj) {
            }
            return obj;
        } catch (Throwable th5) {
            th = th5;
            throw th;
        }
    }
}
