package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.k21;
import tb.qc;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class ChannelsKt__DeprecatedKt {
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        kotlinx.coroutines.channels.b.b(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$any$1 channelsKt__DeprecatedKt$any$1;
        int i;
        if (continuation instanceof ChannelsKt__DeprecatedKt$any$1) {
            channelsKt__DeprecatedKt$any$1 = (ChannelsKt__DeprecatedKt$any$1) continuation;
            int i2 = channelsKt__DeprecatedKt$any$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$any$1.label = i2 - Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$any$1.result;
                Object obj2 = b.d();
                i = channelsKt__DeprecatedKt$any$1.label;
                if (i != 0) {
                    k12.b(obj);
                    ChannelIterator it = receiveChannel.iterator();
                    channelsKt__DeprecatedKt$any$1.L$0 = receiveChannel;
                    channelsKt__DeprecatedKt$any$1.label = 1;
                    obj = it.hasNext(channelsKt__DeprecatedKt$any$1);
                    if (obj == obj2) {
                        return obj2;
                    }
                } else if (i == 1) {
                    receiveChannel = (ReceiveChannel) channelsKt__DeprecatedKt$any$1.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(receiveChannel, null);
                return obj;
            }
        }
        channelsKt__DeprecatedKt$any$1 = new ChannelsKt__DeprecatedKt$any$1(continuation);
        Object obj3 = channelsKt__DeprecatedKt$any$1.result;
        Object obj22 = b.d();
        i = channelsKt__DeprecatedKt$any$1.label;
        if (i != 0) {
        }
        b.b(receiveChannel, null);
        return obj3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object b(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$count$1 channelsKt__DeprecatedKt$count$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Ref$IntRef ref$IntRef;
        ReceiveChannel receiveChannel3;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$count$1) {
            channelsKt__DeprecatedKt$count$1 = (ChannelsKt__DeprecatedKt$count$1) continuation;
            int i2 = channelsKt__DeprecatedKt$count$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$count$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = channelsKt__DeprecatedKt$count$1.result;
                obj = b.d();
                i = channelsKt__DeprecatedKt$count$1.label;
                if (i != 0) {
                    k12.b(obj2);
                    try {
                        ref$IntRef = new Ref$IntRef();
                        receiveChannel3 = receiveChannel;
                        channelIterator = receiveChannel.iterator();
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
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$count$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$count$1.L$1;
                    ref$IntRef = (Ref$IntRef) channelsKt__DeprecatedKt$count$1.L$0;
                    try {
                        k12.b(obj2);
                        if (!((Boolean) obj2).booleanValue()) {
                            channelIterator.next();
                            ref$IntRef.element++;
                            receiveChannel3 = receiveChannel2;
                        }
                        ur2 ur2 = ur2.INSTANCE;
                        b.b(receiveChannel2, null);
                        return qc.b(ref$IntRef.element);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__DeprecatedKt$count$1.L$0 = ref$IntRef;
                channelsKt__DeprecatedKt$count$1.L$1 = receiveChannel3;
                channelsKt__DeprecatedKt$count$1.L$2 = channelIterator;
                channelsKt__DeprecatedKt$count$1.label = 1;
                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$count$1);
                if (hasNext != obj) {
                    return obj;
                }
                receiveChannel2 = receiveChannel3;
                obj2 = hasNext;
                if (!((Boolean) obj2).booleanValue()) {
                    ur2 ur22 = ur2.INSTANCE;
                    b.b(receiveChannel2, null);
                }
                ur2 ur222 = ur2.INSTANCE;
                b.b(receiveChannel2, null);
                return qc.b(ref$IntRef.element);
                return obj;
            }
        }
        channelsKt__DeprecatedKt$count$1 = new ChannelsKt__DeprecatedKt$count$1(continuation);
        Object obj22 = channelsKt__DeprecatedKt$count$1.result;
        obj = b.d();
        i = channelsKt__DeprecatedKt$count$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__DeprecatedKt$count$1.L$0 = ref$IntRef;
            channelsKt__DeprecatedKt$count$1.L$1 = receiveChannel3;
            channelsKt__DeprecatedKt$count$1.L$2 = channelIterator;
            channelsKt__DeprecatedKt$count$1.label = 1;
            hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$count$1);
            if (hasNext != obj) {
            }
            return obj;
        } catch (Throwable th5) {
            th = th5;
            receiveChannel2 = receiveChannel3;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object c(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        ChannelsKt__DeprecatedKt$elementAt$1 channelsKt__DeprecatedKt$elementAt$1;
        Object obj;
        int i2;
        Throwable th;
        ReceiveChannel receiveChannel2;
        int i3;
        ChannelIterator channelIterator;
        int i4;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$elementAt$1) {
            channelsKt__DeprecatedKt$elementAt$1 = (ChannelsKt__DeprecatedKt$elementAt$1) continuation;
            int i5 = channelsKt__DeprecatedKt$elementAt$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$elementAt$1.label = i5 - Integer.MIN_VALUE;
                Object obj2 = channelsKt__DeprecatedKt$elementAt$1.result;
                obj = b.d();
                i2 = channelsKt__DeprecatedKt$elementAt$1.label;
                if (i2 != 0) {
                    k12.b(obj2);
                    if (i >= 0) {
                        i4 = 0;
                        try {
                            channelIterator = receiveChannel.iterator();
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
                    } else {
                        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                    }
                } else if (i2 == 1) {
                    i3 = channelsKt__DeprecatedKt$elementAt$1.I$1;
                    i = channelsKt__DeprecatedKt$elementAt$1.I$0;
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$elementAt$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$elementAt$1.L$0;
                    try {
                        k12.b(obj2);
                        if (!((Boolean) obj2).booleanValue()) {
                            Object next = channelIterator.next();
                            int i6 = i3 + 1;
                            if (i == i3) {
                                b.b(receiveChannel2, null);
                            } else {
                                receiveChannel = receiveChannel2;
                                i4 = i6;
                            }
                            b.b(receiveChannel2, null);
                            return next;
                        }
                        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__DeprecatedKt$elementAt$1.L$0 = receiveChannel;
                channelsKt__DeprecatedKt$elementAt$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$elementAt$1.I$0 = i;
                channelsKt__DeprecatedKt$elementAt$1.I$1 = i4;
                channelsKt__DeprecatedKt$elementAt$1.label = 1;
                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$elementAt$1);
                if (hasNext != obj) {
                    return obj;
                }
                receiveChannel2 = receiveChannel;
                i3 = i4;
                obj2 = hasNext;
                if (!((Boolean) obj2).booleanValue()) {
                }
                throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                return obj;
            }
        }
        channelsKt__DeprecatedKt$elementAt$1 = new ChannelsKt__DeprecatedKt$elementAt$1(continuation);
        Object obj22 = channelsKt__DeprecatedKt$elementAt$1.result;
        obj = b.d();
        i2 = channelsKt__DeprecatedKt$elementAt$1.label;
        if (i2 != 0) {
        }
        channelsKt__DeprecatedKt$elementAt$1.L$0 = receiveChannel;
        channelsKt__DeprecatedKt$elementAt$1.L$1 = channelIterator;
        channelsKt__DeprecatedKt$elementAt$1.I$0 = i;
        channelsKt__DeprecatedKt$elementAt$1.I$1 = i4;
        channelsKt__DeprecatedKt$elementAt$1.label = 1;
        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$elementAt$1);
        if (hasNext != obj) {
        }
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062 A[Catch:{ all -> 0x007d }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object d(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 channelsKt__DeprecatedKt$elementAtOrNull$1;
        Object obj;
        int i2;
        Throwable th;
        ReceiveChannel receiveChannel2;
        int i3;
        Object obj2;
        ChannelIterator channelIterator;
        if (continuation instanceof ChannelsKt__DeprecatedKt$elementAtOrNull$1) {
            channelsKt__DeprecatedKt$elementAtOrNull$1 = (ChannelsKt__DeprecatedKt$elementAtOrNull$1) continuation;
            int i4 = channelsKt__DeprecatedKt$elementAtOrNull$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$elementAtOrNull$1.label = i4 - Integer.MIN_VALUE;
                Object obj3 = channelsKt__DeprecatedKt$elementAtOrNull$1.result;
                obj = b.d();
                i2 = channelsKt__DeprecatedKt$elementAtOrNull$1.label;
                if (i2 != 0) {
                    k12.b(obj3);
                    if (i < 0) {
                        b.b(receiveChannel, null);
                        return null;
                    }
                    i3 = 0;
                    try {
                        channelIterator = receiveChannel.iterator();
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i2 == 1) {
                    int i5 = channelsKt__DeprecatedKt$elementAtOrNull$1.I$1;
                    i = channelsKt__DeprecatedKt$elementAtOrNull$1.I$0;
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$elementAtOrNull$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$elementAtOrNull$1.L$0;
                    try {
                        k12.b(obj3);
                        i3 = i5;
                        receiveChannel = receiveChannel2;
                        obj2 = obj3;
                        if (((Boolean) obj2).booleanValue()) {
                            Object next = channelIterator.next();
                            int i6 = i3 + 1;
                            if (i == i3) {
                                b.b(receiveChannel, null);
                            } else {
                                i3 = i6;
                            }
                            b.b(receiveChannel, null);
                            return next;
                        }
                        b.b(receiveChannel, null);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            b.b(receiveChannel2, th);
                            throw th4;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__DeprecatedKt$elementAtOrNull$1.L$0 = receiveChannel;
                channelsKt__DeprecatedKt$elementAtOrNull$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$elementAtOrNull$1.I$0 = i;
                channelsKt__DeprecatedKt$elementAtOrNull$1.I$1 = i3;
                channelsKt__DeprecatedKt$elementAtOrNull$1.label = 1;
                obj2 = channelIterator.hasNext(channelsKt__DeprecatedKt$elementAtOrNull$1);
                if (obj2 == obj) {
                    return obj;
                }
                if (((Boolean) obj2).booleanValue()) {
                    b.b(receiveChannel, null);
                }
                b.b(receiveChannel, null);
                return null;
            }
        }
        channelsKt__DeprecatedKt$elementAtOrNull$1 = new ChannelsKt__DeprecatedKt$elementAtOrNull$1(continuation);
        Object obj32 = channelsKt__DeprecatedKt$elementAtOrNull$1.result;
        obj = b.d();
        i2 = channelsKt__DeprecatedKt$elementAtOrNull$1.label;
        if (i2 != 0) {
        }
        channelsKt__DeprecatedKt$elementAtOrNull$1.L$0 = receiveChannel;
        channelsKt__DeprecatedKt$elementAtOrNull$1.L$1 = channelIterator;
        channelsKt__DeprecatedKt$elementAtOrNull$1.I$0 = i;
        channelsKt__DeprecatedKt$elementAtOrNull$1.I$1 = i3;
        channelsKt__DeprecatedKt$elementAtOrNull$1.label = 1;
        obj2 = channelIterator.hasNext(channelsKt__DeprecatedKt$elementAtOrNull$1);
        if (obj2 == obj) {
        }
        if (((Boolean) obj2).booleanValue()) {
        }
        b.b(receiveChannel, null);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object e(ReceiveChannel receiveChannel, Collection collection, Continuation continuation) {
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 channelsKt__DeprecatedKt$filterNotNullTo$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        Collection collection2;
        Collection collection3;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$1) {
            channelsKt__DeprecatedKt$filterNotNullTo$1 = (ChannelsKt__DeprecatedKt$filterNotNullTo$1) continuation;
            int i2 = channelsKt__DeprecatedKt$filterNotNullTo$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$filterNotNullTo$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = channelsKt__DeprecatedKt$filterNotNullTo$1.result;
                obj = b.d();
                i = channelsKt__DeprecatedKt$filterNotNullTo$1.label;
                if (i != 0) {
                    k12.b(obj2);
                    try {
                        receiveChannel2 = receiveChannel;
                        channelIterator = receiveChannel.iterator();
                        collection3 = collection;
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
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$1.L$1;
                    collection2 = (Collection) channelsKt__DeprecatedKt$filterNotNullTo$1.L$0;
                    try {
                        k12.b(obj2);
                        if (!((Boolean) obj2).booleanValue()) {
                            ur2 ur2 = ur2.INSTANCE;
                            b.b(receiveChannel2, null);
                        } else {
                            Object next = channelIterator.next();
                            if (next != null) {
                                collection2.add(next);
                            }
                            collection3 = collection2;
                        }
                        ur2 ur22 = ur2.INSTANCE;
                        b.b(receiveChannel2, null);
                        return collection2;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__DeprecatedKt$filterNotNullTo$1.L$0 = collection3;
                channelsKt__DeprecatedKt$filterNotNullTo$1.L$1 = receiveChannel2;
                channelsKt__DeprecatedKt$filterNotNullTo$1.L$2 = channelIterator;
                channelsKt__DeprecatedKt$filterNotNullTo$1.label = 1;
                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$1);
                if (hasNext != obj) {
                    return obj;
                }
                collection2 = collection3;
                obj2 = hasNext;
                if (!((Boolean) obj2).booleanValue()) {
                }
                ur2 ur222 = ur2.INSTANCE;
                b.b(receiveChannel2, null);
                return collection2;
                return obj;
            }
        }
        channelsKt__DeprecatedKt$filterNotNullTo$1 = new ChannelsKt__DeprecatedKt$filterNotNullTo$1(continuation);
        Object obj22 = channelsKt__DeprecatedKt$filterNotNullTo$1.result;
        obj = b.d();
        i = channelsKt__DeprecatedKt$filterNotNullTo$1.label;
        if (i != 0) {
        }
        channelsKt__DeprecatedKt$filterNotNullTo$1.L$0 = collection3;
        channelsKt__DeprecatedKt$filterNotNullTo$1.L$1 = receiveChannel2;
        channelsKt__DeprecatedKt$filterNotNullTo$1.L$2 = channelIterator;
        channelsKt__DeprecatedKt$filterNotNullTo$1.label = 1;
        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$1);
        if (hasNext != obj) {
        }
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070 A[Catch:{ all -> 0x009d }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071 A[Catch:{ all -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007e A[Catch:{ all -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0097 A[Catch:{ all -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object f(ReceiveChannel receiveChannel, SendChannel sendChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$3;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        Object hasNext;
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$32;
        ChannelIterator channelIterator2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$3) {
            channelsKt__DeprecatedKt$filterNotNullTo$3 = (ChannelsKt__DeprecatedKt$filterNotNullTo$3) continuation;
            int i2 = channelsKt__DeprecatedKt$filterNotNullTo$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$filterNotNullTo$3.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$filterNotNullTo$3.result;
                Object obj2 = b.d();
                i = channelsKt__DeprecatedKt$filterNotNullTo$3.label;
                if (i != 0) {
                    k12.b(obj);
                    try {
                        channelIterator = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$filterNotNullTo$3.L$0 = sendChannel;
                        channelsKt__DeprecatedKt$filterNotNullTo$3.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$filterNotNullTo$3.L$2 = channelIterator;
                        channelsKt__DeprecatedKt$filterNotNullTo$3.label = 1;
                        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$3);
                        if (hasNext == obj2) {
                        }
                        return obj2;
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    k12.b(obj);
                    channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
                    channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$3.L$2;
                    receiveChannel = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$1;
                    sendChannel = (SendChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$0;
                } else if (i == 2) {
                    ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$3.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$1;
                    SendChannel sendChannel2 = (SendChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$0;
                    try {
                        k12.b(obj);
                        channelIterator = channelIterator3;
                        receiveChannel = receiveChannel2;
                        sendChannel = sendChannel2;
                        channelsKt__DeprecatedKt$filterNotNullTo$3.L$0 = sendChannel;
                        channelsKt__DeprecatedKt$filterNotNullTo$3.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$filterNotNullTo$3.L$2 = channelIterator;
                        channelsKt__DeprecatedKt$filterNotNullTo$3.label = 1;
                        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$3);
                        if (hasNext == obj2) {
                            return obj2;
                        }
                        channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
                        channelIterator2 = channelIterator;
                        obj = hasNext;
                        return obj2;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            b.b(receiveChannel2, th);
                            throw th4;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    ur2 ur2 = ur2.INSTANCE;
                } else {
                    Object next = channelIterator2.next();
                    if (next != null) {
                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$0 = sendChannel;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$2 = channelIterator2;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.label = 2;
                        if (sendChannel.send(next, channelsKt__DeprecatedKt$filterNotNullTo$32) == obj2) {
                            return obj2;
                        }
                    }
                    channelIterator = channelIterator2;
                    channelsKt__DeprecatedKt$filterNotNullTo$3 = channelsKt__DeprecatedKt$filterNotNullTo$32;
                    obj2 = obj2;
                    channelsKt__DeprecatedKt$filterNotNullTo$3.L$0 = sendChannel;
                    channelsKt__DeprecatedKt$filterNotNullTo$3.L$1 = receiveChannel;
                    channelsKt__DeprecatedKt$filterNotNullTo$3.L$2 = channelIterator;
                    channelsKt__DeprecatedKt$filterNotNullTo$3.label = 1;
                    hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$3);
                    if (hasNext == obj2) {
                    }
                    return obj2;
                }
                ur2 ur22 = ur2.INSTANCE;
                b.b(receiveChannel, null);
                return sendChannel;
            }
        }
        channelsKt__DeprecatedKt$filterNotNullTo$3 = new ChannelsKt__DeprecatedKt$filterNotNullTo$3(continuation);
        obj = channelsKt__DeprecatedKt$filterNotNullTo$3.result;
        Object obj22 = b.d();
        i = channelsKt__DeprecatedKt$filterNotNullTo$3.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
        ur2 ur222 = ur2.INSTANCE;
        b.b(receiveChannel, null);
        return sendChannel;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object g(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$first$1 channelsKt__DeprecatedKt$first$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        if (continuation instanceof ChannelsKt__DeprecatedKt$first$1) {
            channelsKt__DeprecatedKt$first$1 = (ChannelsKt__DeprecatedKt$first$1) continuation;
            int i2 = channelsKt__DeprecatedKt$first$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$first$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$first$1.result;
                Object obj2 = b.d();
                i = channelsKt__DeprecatedKt$first$1.label;
                if (i != 0) {
                    k12.b(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$first$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$first$1.L$1 = it;
                        channelsKt__DeprecatedKt$first$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$first$1);
                        if (hasNext == obj2) {
                            return obj2;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
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
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$first$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$first$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    b.b(receiveChannel2, null);
                    return next;
                }
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
        }
        channelsKt__DeprecatedKt$first$1 = new ChannelsKt__DeprecatedKt$first$1(continuation);
        obj = channelsKt__DeprecatedKt$first$1.result;
        Object obj22 = b.d();
        i = channelsKt__DeprecatedKt$first$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object h(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$firstOrNull$1 channelsKt__DeprecatedKt$firstOrNull$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        if (continuation instanceof ChannelsKt__DeprecatedKt$firstOrNull$1) {
            channelsKt__DeprecatedKt$firstOrNull$1 = (ChannelsKt__DeprecatedKt$firstOrNull$1) continuation;
            int i2 = channelsKt__DeprecatedKt$firstOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$firstOrNull$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$firstOrNull$1.result;
                Object obj2 = b.d();
                i = channelsKt__DeprecatedKt$firstOrNull$1.label;
                if (i != 0) {
                    k12.b(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$firstOrNull$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$firstOrNull$1.L$1 = it;
                        channelsKt__DeprecatedKt$firstOrNull$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$firstOrNull$1);
                        if (hasNext == obj2) {
                            return obj2;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
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
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$firstOrNull$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$firstOrNull$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) obj).booleanValue()) {
                    b.b(receiveChannel2, null);
                    return null;
                }
                Object next = channelIterator.next();
                b.b(receiveChannel2, null);
                return next;
            }
        }
        channelsKt__DeprecatedKt$firstOrNull$1 = new ChannelsKt__DeprecatedKt$firstOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$firstOrNull$1.result;
        Object obj22 = b.d();
        i = channelsKt__DeprecatedKt$firstOrNull$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object i(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        ChannelsKt__DeprecatedKt$indexOf$1 channelsKt__DeprecatedKt$indexOf$1;
        Object obj2;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        Object obj3;
        Ref$IntRef ref$IntRef;
        Object obj4;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$indexOf$1) {
            channelsKt__DeprecatedKt$indexOf$1 = (ChannelsKt__DeprecatedKt$indexOf$1) continuation;
            int i2 = channelsKt__DeprecatedKt$indexOf$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$indexOf$1.label = i2 - Integer.MIN_VALUE;
                Object obj5 = channelsKt__DeprecatedKt$indexOf$1.result;
                obj2 = b.d();
                i = channelsKt__DeprecatedKt$indexOf$1.label;
                if (i != 0) {
                    k12.b(obj5);
                    Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                    try {
                        receiveChannel2 = receiveChannel;
                        channelIterator = receiveChannel.iterator();
                        ref$IntRef = ref$IntRef2;
                        obj4 = obj;
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
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$indexOf$1.L$3;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$indexOf$1.L$2;
                    ref$IntRef = (Ref$IntRef) channelsKt__DeprecatedKt$indexOf$1.L$1;
                    obj3 = channelsKt__DeprecatedKt$indexOf$1.L$0;
                    try {
                        k12.b(obj5);
                        if (!((Boolean) obj5).booleanValue()) {
                            ur2 ur2 = ur2.INSTANCE;
                            b.b(receiveChannel2, null);
                        } else {
                            if (k21.d(obj3, channelIterator.next())) {
                                Integer b = qc.b(ref$IntRef.element);
                                b.b(receiveChannel2, null);
                            } else {
                                ref$IntRef.element++;
                                obj4 = obj3;
                            }
                            Integer b2 = qc.b(ref$IntRef.element);
                            b.b(receiveChannel2, null);
                            return b2;
                        }
                        ur2 ur22 = ur2.INSTANCE;
                        b.b(receiveChannel2, null);
                        return qc.b(-1);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__DeprecatedKt$indexOf$1.L$0 = obj4;
                channelsKt__DeprecatedKt$indexOf$1.L$1 = ref$IntRef;
                channelsKt__DeprecatedKt$indexOf$1.L$2 = receiveChannel2;
                channelsKt__DeprecatedKt$indexOf$1.L$3 = channelIterator;
                channelsKt__DeprecatedKt$indexOf$1.label = 1;
                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$indexOf$1);
                if (hasNext != obj2) {
                    return obj2;
                }
                obj3 = obj4;
                obj5 = hasNext;
                if (!((Boolean) obj5).booleanValue()) {
                }
                ur2 ur222 = ur2.INSTANCE;
                b.b(receiveChannel2, null);
                return qc.b(-1);
                return obj2;
            }
        }
        channelsKt__DeprecatedKt$indexOf$1 = new ChannelsKt__DeprecatedKt$indexOf$1(continuation);
        Object obj52 = channelsKt__DeprecatedKt$indexOf$1.result;
        obj2 = b.d();
        i = channelsKt__DeprecatedKt$indexOf$1.label;
        if (i != 0) {
        }
        channelsKt__DeprecatedKt$indexOf$1.L$0 = obj4;
        channelsKt__DeprecatedKt$indexOf$1.L$1 = ref$IntRef;
        channelsKt__DeprecatedKt$indexOf$1.L$2 = receiveChannel2;
        channelsKt__DeprecatedKt$indexOf$1.L$3 = channelIterator;
        channelsKt__DeprecatedKt$indexOf$1.label = 1;
        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$indexOf$1);
        if (hasNext != obj2) {
        }
        return obj2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object j(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$last$1 channelsKt__DeprecatedKt$last$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object next;
        ReceiveChannel receiveChannel3;
        Object hasNext;
        ChannelIterator channelIterator2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$last$1) {
            channelsKt__DeprecatedKt$last$1 = (ChannelsKt__DeprecatedKt$last$1) continuation;
            int i2 = channelsKt__DeprecatedKt$last$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$last$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$last$1.result;
                Object obj2 = b.d();
                i = channelsKt__DeprecatedKt$last$1.label;
                if (i != 0) {
                    k12.b(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$last$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$last$1.L$1 = it;
                        channelsKt__DeprecatedKt$last$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$last$1);
                        if (hasNext2 == obj2) {
                            return obj2;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator2 = it;
                        obj = hasNext2;
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
                    channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$last$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else if (i == 2) {
                    Object obj3 = channelsKt__DeprecatedKt$last$1.L$2;
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$last$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$0;
                    try {
                        k12.b(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            next = channelIterator.next();
                            receiveChannel3 = receiveChannel4;
                            channelsKt__DeprecatedKt$last$1.L$0 = receiveChannel3;
                            channelsKt__DeprecatedKt$last$1.L$1 = channelIterator;
                            channelsKt__DeprecatedKt$last$1.L$2 = next;
                            channelsKt__DeprecatedKt$last$1.label = 2;
                            hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$last$1);
                            if (hasNext != obj2) {
                                return obj2;
                            }
                            receiveChannel4 = receiveChannel3;
                            obj3 = next;
                            obj = hasNext;
                            if (!((Boolean) obj).booleanValue()) {
                                b.b(receiveChannel4, null);
                            }
                            return obj2;
                        }
                        b.b(receiveChannel4, null);
                        return obj3;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    next = channelIterator2.next();
                    channelIterator = channelIterator2;
                    receiveChannel3 = receiveChannel2;
                    channelsKt__DeprecatedKt$last$1.L$0 = receiveChannel3;
                    channelsKt__DeprecatedKt$last$1.L$1 = channelIterator;
                    channelsKt__DeprecatedKt$last$1.L$2 = next;
                    channelsKt__DeprecatedKt$last$1.label = 2;
                    hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$last$1);
                    if (hasNext != obj2) {
                    }
                    return obj2;
                }
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
        }
        channelsKt__DeprecatedKt$last$1 = new ChannelsKt__DeprecatedKt$last$1(continuation);
        obj = channelsKt__DeprecatedKt$last$1.result;
        Object obj22 = b.d();
        i = channelsKt__DeprecatedKt$last$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object k(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        ChannelsKt__DeprecatedKt$lastIndexOf$1 channelsKt__DeprecatedKt$lastIndexOf$1;
        Object obj2;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        Object obj3;
        Ref$IntRef ref$IntRef;
        Ref$IntRef ref$IntRef2;
        Object obj4;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$lastIndexOf$1) {
            channelsKt__DeprecatedKt$lastIndexOf$1 = (ChannelsKt__DeprecatedKt$lastIndexOf$1) continuation;
            int i2 = channelsKt__DeprecatedKt$lastIndexOf$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$lastIndexOf$1.label = i2 - Integer.MIN_VALUE;
                Object obj5 = channelsKt__DeprecatedKt$lastIndexOf$1.result;
                obj2 = b.d();
                i = channelsKt__DeprecatedKt$lastIndexOf$1.label;
                if (i != 0) {
                    k12.b(obj5);
                    Ref$IntRef ref$IntRef3 = new Ref$IntRef();
                    ref$IntRef3.element = -1;
                    ref$IntRef2 = new Ref$IntRef();
                    try {
                        receiveChannel2 = receiveChannel;
                        channelIterator = receiveChannel.iterator();
                        ref$IntRef = ref$IntRef3;
                        obj4 = obj;
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
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$lastIndexOf$1.L$4;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$lastIndexOf$1.L$3;
                    ref$IntRef2 = (Ref$IntRef) channelsKt__DeprecatedKt$lastIndexOf$1.L$2;
                    ref$IntRef = (Ref$IntRef) channelsKt__DeprecatedKt$lastIndexOf$1.L$1;
                    obj3 = channelsKt__DeprecatedKt$lastIndexOf$1.L$0;
                    try {
                        k12.b(obj5);
                        if (!((Boolean) obj5).booleanValue()) {
                            ur2 ur2 = ur2.INSTANCE;
                            b.b(receiveChannel2, null);
                        } else {
                            if (k21.d(obj3, channelIterator.next())) {
                                ref$IntRef.element = ref$IntRef2.element;
                            }
                            ref$IntRef2.element++;
                            obj4 = obj3;
                        }
                        ur2 ur22 = ur2.INSTANCE;
                        b.b(receiveChannel2, null);
                        return qc.b(ref$IntRef.element);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__DeprecatedKt$lastIndexOf$1.L$0 = obj4;
                channelsKt__DeprecatedKt$lastIndexOf$1.L$1 = ref$IntRef;
                channelsKt__DeprecatedKt$lastIndexOf$1.L$2 = ref$IntRef2;
                channelsKt__DeprecatedKt$lastIndexOf$1.L$3 = receiveChannel2;
                channelsKt__DeprecatedKt$lastIndexOf$1.L$4 = channelIterator;
                channelsKt__DeprecatedKt$lastIndexOf$1.label = 1;
                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$lastIndexOf$1);
                if (hasNext != obj2) {
                    return obj2;
                }
                obj3 = obj4;
                obj5 = hasNext;
                if (!((Boolean) obj5).booleanValue()) {
                }
                ur2 ur222 = ur2.INSTANCE;
                b.b(receiveChannel2, null);
                return qc.b(ref$IntRef.element);
                return obj2;
            }
        }
        channelsKt__DeprecatedKt$lastIndexOf$1 = new ChannelsKt__DeprecatedKt$lastIndexOf$1(continuation);
        Object obj52 = channelsKt__DeprecatedKt$lastIndexOf$1.result;
        obj2 = b.d();
        i = channelsKt__DeprecatedKt$lastIndexOf$1.label;
        if (i != 0) {
        }
        channelsKt__DeprecatedKt$lastIndexOf$1.L$0 = obj4;
        channelsKt__DeprecatedKt$lastIndexOf$1.L$1 = ref$IntRef;
        channelsKt__DeprecatedKt$lastIndexOf$1.L$2 = ref$IntRef2;
        channelsKt__DeprecatedKt$lastIndexOf$1.L$3 = receiveChannel2;
        channelsKt__DeprecatedKt$lastIndexOf$1.L$4 = channelIterator;
        channelsKt__DeprecatedKt$lastIndexOf$1.label = 1;
        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$lastIndexOf$1);
        if (hasNext != obj2) {
        }
        return obj2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object l(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$lastOrNull$1 channelsKt__DeprecatedKt$lastOrNull$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object next;
        ReceiveChannel receiveChannel3;
        Object hasNext;
        ChannelIterator channelIterator2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$lastOrNull$1) {
            channelsKt__DeprecatedKt$lastOrNull$1 = (ChannelsKt__DeprecatedKt$lastOrNull$1) continuation;
            int i2 = channelsKt__DeprecatedKt$lastOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$lastOrNull$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$lastOrNull$1.result;
                Object obj2 = b.d();
                i = channelsKt__DeprecatedKt$lastOrNull$1.label;
                if (i != 0) {
                    k12.b(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$lastOrNull$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$lastOrNull$1.L$1 = it;
                        channelsKt__DeprecatedKt$lastOrNull$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                        if (hasNext2 == obj2) {
                            return obj2;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator2 = it;
                        obj = hasNext2;
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
                    channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$lastOrNull$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else if (i == 2) {
                    Object obj3 = channelsKt__DeprecatedKt$lastOrNull$1.L$2;
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$lastOrNull$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$0;
                    try {
                        k12.b(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            next = channelIterator.next();
                            receiveChannel3 = receiveChannel4;
                            channelsKt__DeprecatedKt$lastOrNull$1.L$0 = receiveChannel3;
                            channelsKt__DeprecatedKt$lastOrNull$1.L$1 = channelIterator;
                            channelsKt__DeprecatedKt$lastOrNull$1.L$2 = next;
                            channelsKt__DeprecatedKt$lastOrNull$1.label = 2;
                            hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                            if (hasNext != obj2) {
                                return obj2;
                            }
                            receiveChannel4 = receiveChannel3;
                            obj3 = next;
                            obj = hasNext;
                            if (!((Boolean) obj).booleanValue()) {
                                b.b(receiveChannel4, null);
                            }
                            return obj2;
                        }
                        b.b(receiveChannel4, null);
                        return obj3;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) obj).booleanValue()) {
                    b.b(receiveChannel2, null);
                    return null;
                }
                next = channelIterator2.next();
                channelIterator = channelIterator2;
                receiveChannel3 = receiveChannel2;
                channelsKt__DeprecatedKt$lastOrNull$1.L$0 = receiveChannel3;
                channelsKt__DeprecatedKt$lastOrNull$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$lastOrNull$1.L$2 = next;
                channelsKt__DeprecatedKt$lastOrNull$1.label = 2;
                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                if (hasNext != obj2) {
                }
                return obj2;
            }
        }
        channelsKt__DeprecatedKt$lastOrNull$1 = new ChannelsKt__DeprecatedKt$lastOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$lastOrNull$1.result;
        Object obj22 = b.d();
        i = channelsKt__DeprecatedKt$lastOrNull$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object m(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        Object obj2;
        ChannelIterator channelIterator;
        ReceiveChannel receiveChannel3;
        Comparator comparator2;
        Object hasNext;
        ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$12;
        Object obj3;
        ChannelIterator channelIterator2;
        Comparator comparator3;
        if (continuation instanceof ChannelsKt__DeprecatedKt$maxWith$1) {
            channelsKt__DeprecatedKt$maxWith$1 = (ChannelsKt__DeprecatedKt$maxWith$1) continuation;
            int i2 = channelsKt__DeprecatedKt$maxWith$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$maxWith$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$maxWith$1.result;
                Object obj4 = b.d();
                i = channelsKt__DeprecatedKt$maxWith$1.label;
                if (i != 0) {
                    k12.b(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$maxWith$1.L$0 = comparator;
                        channelsKt__DeprecatedKt$maxWith$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$maxWith$1.L$2 = it;
                        channelsKt__DeprecatedKt$maxWith$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                        if (hasNext2 == obj4) {
                            return obj4;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator2 = it;
                        obj = hasNext2;
                        comparator3 = comparator;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$maxWith$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$1;
                    comparator3 = (Comparator) channelsKt__DeprecatedKt$maxWith$1.L$0;
                    try {
                        k12.b(obj);
                        if (((Boolean) obj).booleanValue()) {
                            b.b(receiveChannel2, null);
                            return null;
                        }
                        obj2 = channelIterator2.next();
                        comparator2 = comparator3;
                        channelIterator = channelIterator2;
                        receiveChannel3 = receiveChannel2;
                        channelsKt__DeprecatedKt$maxWith$1.L$0 = comparator2;
                        channelsKt__DeprecatedKt$maxWith$1.L$1 = receiveChannel3;
                        channelsKt__DeprecatedKt$maxWith$1.L$2 = channelIterator;
                        channelsKt__DeprecatedKt$maxWith$1.L$3 = obj2;
                        channelsKt__DeprecatedKt$maxWith$1.label = 2;
                        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                        if (hasNext != obj4) {
                            return obj4;
                        }
                        channelsKt__DeprecatedKt$maxWith$12 = channelsKt__DeprecatedKt$maxWith$1;
                        obj3 = obj2;
                        obj = hasNext;
                        return obj4;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else if (i == 2) {
                    Object obj5 = channelsKt__DeprecatedKt$maxWith$1.L$3;
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$maxWith$1.L$2;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$1;
                    comparator2 = (Comparator) channelsKt__DeprecatedKt$maxWith$1.L$0;
                    try {
                        k12.b(obj);
                        channelsKt__DeprecatedKt$maxWith$12 = channelsKt__DeprecatedKt$maxWith$1;
                        obj3 = obj5;
                        receiveChannel3 = receiveChannel4;
                    } catch (Throwable th4) {
                        th = th4;
                        receiveChannel2 = receiveChannel4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            b.b(receiveChannel2, th);
                            throw th5;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    obj2 = channelIterator.next();
                    if (comparator2.compare(obj3, obj2) >= 0) {
                        obj2 = obj3;
                    }
                    channelsKt__DeprecatedKt$maxWith$1 = channelsKt__DeprecatedKt$maxWith$12;
                    obj4 = obj4;
                    channelsKt__DeprecatedKt$maxWith$1.L$0 = comparator2;
                    channelsKt__DeprecatedKt$maxWith$1.L$1 = receiveChannel3;
                    channelsKt__DeprecatedKt$maxWith$1.L$2 = channelIterator;
                    channelsKt__DeprecatedKt$maxWith$1.L$3 = obj2;
                    channelsKt__DeprecatedKt$maxWith$1.label = 2;
                    hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                    if (hasNext != obj4) {
                    }
                    return obj4;
                }
                b.b(receiveChannel3, null);
                return obj3;
            }
        }
        channelsKt__DeprecatedKt$maxWith$1 = new ChannelsKt__DeprecatedKt$maxWith$1(continuation);
        obj = channelsKt__DeprecatedKt$maxWith$1.result;
        Object obj42 = b.d();
        i = channelsKt__DeprecatedKt$maxWith$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
            b.b(receiveChannel3, null);
        }
        b.b(receiveChannel3, null);
        return obj3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object n(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        Object obj2;
        ChannelIterator channelIterator;
        ReceiveChannel receiveChannel3;
        Comparator comparator2;
        Object hasNext;
        ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$12;
        Object obj3;
        ChannelIterator channelIterator2;
        Comparator comparator3;
        if (continuation instanceof ChannelsKt__DeprecatedKt$minWith$1) {
            channelsKt__DeprecatedKt$minWith$1 = (ChannelsKt__DeprecatedKt$minWith$1) continuation;
            int i2 = channelsKt__DeprecatedKt$minWith$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$minWith$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$minWith$1.result;
                Object obj4 = b.d();
                i = channelsKt__DeprecatedKt$minWith$1.label;
                if (i != 0) {
                    k12.b(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$minWith$1.L$0 = comparator;
                        channelsKt__DeprecatedKt$minWith$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$minWith$1.L$2 = it;
                        channelsKt__DeprecatedKt$minWith$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$minWith$1);
                        if (hasNext2 == obj4) {
                            return obj4;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator2 = it;
                        obj = hasNext2;
                        comparator3 = comparator;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$minWith$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$1;
                    comparator3 = (Comparator) channelsKt__DeprecatedKt$minWith$1.L$0;
                    try {
                        k12.b(obj);
                        if (((Boolean) obj).booleanValue()) {
                            b.b(receiveChannel2, null);
                            return null;
                        }
                        obj2 = channelIterator2.next();
                        comparator2 = comparator3;
                        channelIterator = channelIterator2;
                        receiveChannel3 = receiveChannel2;
                        channelsKt__DeprecatedKt$minWith$1.L$0 = comparator2;
                        channelsKt__DeprecatedKt$minWith$1.L$1 = receiveChannel3;
                        channelsKt__DeprecatedKt$minWith$1.L$2 = channelIterator;
                        channelsKt__DeprecatedKt$minWith$1.L$3 = obj2;
                        channelsKt__DeprecatedKt$minWith$1.label = 2;
                        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$minWith$1);
                        if (hasNext != obj4) {
                            return obj4;
                        }
                        channelsKt__DeprecatedKt$minWith$12 = channelsKt__DeprecatedKt$minWith$1;
                        obj3 = obj2;
                        obj = hasNext;
                        return obj4;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else if (i == 2) {
                    Object obj5 = channelsKt__DeprecatedKt$minWith$1.L$3;
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$minWith$1.L$2;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$1;
                    comparator2 = (Comparator) channelsKt__DeprecatedKt$minWith$1.L$0;
                    try {
                        k12.b(obj);
                        channelsKt__DeprecatedKt$minWith$12 = channelsKt__DeprecatedKt$minWith$1;
                        obj3 = obj5;
                        receiveChannel3 = receiveChannel4;
                    } catch (Throwable th4) {
                        th = th4;
                        receiveChannel2 = receiveChannel4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            b.b(receiveChannel2, th);
                            throw th5;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    obj2 = channelIterator.next();
                    if (comparator2.compare(obj3, obj2) <= 0) {
                        obj2 = obj3;
                    }
                    channelsKt__DeprecatedKt$minWith$1 = channelsKt__DeprecatedKt$minWith$12;
                    obj4 = obj4;
                    channelsKt__DeprecatedKt$minWith$1.L$0 = comparator2;
                    channelsKt__DeprecatedKt$minWith$1.L$1 = receiveChannel3;
                    channelsKt__DeprecatedKt$minWith$1.L$2 = channelIterator;
                    channelsKt__DeprecatedKt$minWith$1.L$3 = obj2;
                    channelsKt__DeprecatedKt$minWith$1.label = 2;
                    hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$minWith$1);
                    if (hasNext != obj4) {
                    }
                    return obj4;
                }
                b.b(receiveChannel3, null);
                return obj3;
            }
        }
        channelsKt__DeprecatedKt$minWith$1 = new ChannelsKt__DeprecatedKt$minWith$1(continuation);
        obj = channelsKt__DeprecatedKt$minWith$1.result;
        Object obj42 = b.d();
        i = channelsKt__DeprecatedKt$minWith$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
            b.b(receiveChannel3, null);
        }
        b.b(receiveChannel3, null);
        return obj3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
        kotlinx.coroutines.channels.b.b(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object o(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$none$1 channelsKt__DeprecatedKt$none$1;
        Object obj;
        int i;
        if (continuation instanceof ChannelsKt__DeprecatedKt$none$1) {
            channelsKt__DeprecatedKt$none$1 = (ChannelsKt__DeprecatedKt$none$1) continuation;
            int i2 = channelsKt__DeprecatedKt$none$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$none$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$none$1.result;
                Object obj2 = b.d();
                i = channelsKt__DeprecatedKt$none$1.label;
                boolean z = true;
                if (i != 0) {
                    k12.b(obj);
                    ChannelIterator it = receiveChannel.iterator();
                    channelsKt__DeprecatedKt$none$1.L$0 = receiveChannel;
                    channelsKt__DeprecatedKt$none$1.label = 1;
                    obj = it.hasNext(channelsKt__DeprecatedKt$none$1);
                    if (obj == obj2) {
                        return obj2;
                    }
                } else if (i == 1) {
                    receiveChannel = (ReceiveChannel) channelsKt__DeprecatedKt$none$1.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) obj).booleanValue()) {
                    z = false;
                }
                Boolean a = qc.a(z);
                b.b(receiveChannel, null);
                return a;
            }
        }
        channelsKt__DeprecatedKt$none$1 = new ChannelsKt__DeprecatedKt$none$1(continuation);
        obj = channelsKt__DeprecatedKt$none$1.result;
        Object obj22 = b.d();
        i = channelsKt__DeprecatedKt$none$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
        Boolean a2 = qc.a(z2);
        b.b(receiveChannel, null);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object p(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$single$1 channelsKt__DeprecatedKt$single$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel receiveChannel2;
        Object obj2;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator;
        if (continuation instanceof ChannelsKt__DeprecatedKt$single$1) {
            channelsKt__DeprecatedKt$single$1 = (ChannelsKt__DeprecatedKt$single$1) continuation;
            int i2 = channelsKt__DeprecatedKt$single$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$single$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$single$1.result;
                Object obj3 = b.d();
                i = channelsKt__DeprecatedKt$single$1.label;
                if (i != 0) {
                    k12.b(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$single$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$single$1.L$1 = it;
                        channelsKt__DeprecatedKt$single$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$single$1);
                        if (hasNext == obj3) {
                            return obj3;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
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
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$single$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else if (i == 2) {
                    obj2 = channelsKt__DeprecatedKt$single$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$0;
                    try {
                        k12.b(obj);
                        if (((Boolean) obj).booleanValue()) {
                            b.b(receiveChannel3, null);
                            return obj2;
                        }
                        throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    channelsKt__DeprecatedKt$single$1.L$0 = receiveChannel2;
                    channelsKt__DeprecatedKt$single$1.L$1 = next;
                    channelsKt__DeprecatedKt$single$1.label = 2;
                    Object hasNext2 = channelIterator.hasNext(channelsKt__DeprecatedKt$single$1);
                    if (hasNext2 == obj3) {
                        return obj3;
                    }
                    receiveChannel3 = receiveChannel2;
                    obj = hasNext2;
                    obj2 = next;
                    if (((Boolean) obj).booleanValue()) {
                    }
                } else {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
            }
        }
        channelsKt__DeprecatedKt$single$1 = new ChannelsKt__DeprecatedKt$single$1(continuation);
        obj = channelsKt__DeprecatedKt$single$1.result;
        Object obj32 = b.d();
        i = channelsKt__DeprecatedKt$single$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object q(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$singleOrNull$1 channelsKt__DeprecatedKt$singleOrNull$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel receiveChannel2;
        Object obj2;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator;
        if (continuation instanceof ChannelsKt__DeprecatedKt$singleOrNull$1) {
            channelsKt__DeprecatedKt$singleOrNull$1 = (ChannelsKt__DeprecatedKt$singleOrNull$1) continuation;
            int i2 = channelsKt__DeprecatedKt$singleOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$singleOrNull$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$singleOrNull$1.result;
                Object obj3 = b.d();
                i = channelsKt__DeprecatedKt$singleOrNull$1.label;
                if (i != 0) {
                    k12.b(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$singleOrNull$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$singleOrNull$1.L$1 = it;
                        channelsKt__DeprecatedKt$singleOrNull$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$singleOrNull$1);
                        if (hasNext == obj3) {
                            return obj3;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
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
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$singleOrNull$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else if (i == 2) {
                    obj2 = channelsKt__DeprecatedKt$singleOrNull$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$0;
                    try {
                        k12.b(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            b.b(receiveChannel3, null);
                            return null;
                        }
                        b.b(receiveChannel3, null);
                        return obj2;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) obj).booleanValue()) {
                    b.b(receiveChannel2, null);
                    return null;
                }
                Object next = channelIterator.next();
                channelsKt__DeprecatedKt$singleOrNull$1.L$0 = receiveChannel2;
                channelsKt__DeprecatedKt$singleOrNull$1.L$1 = next;
                channelsKt__DeprecatedKt$singleOrNull$1.label = 2;
                Object hasNext2 = channelIterator.hasNext(channelsKt__DeprecatedKt$singleOrNull$1);
                if (hasNext2 == obj3) {
                    return obj3;
                }
                receiveChannel3 = receiveChannel2;
                obj = hasNext2;
                obj2 = next;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        }
        channelsKt__DeprecatedKt$singleOrNull$1 = new ChannelsKt__DeprecatedKt$singleOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$singleOrNull$1.result;
        Object obj32 = b.d();
        i = channelsKt__DeprecatedKt$singleOrNull$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @PublishedApi
    @Nullable
    public static final <E, C extends SendChannel<? super E>> Object r(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        ChannelsKt__DeprecatedKt$toChannel$1 channelsKt__DeprecatedKt$toChannel$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ChannelIterator<? extends E> channelIterator;
        SendChannel sendChannel;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        C c2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$toChannel$1) {
            channelsKt__DeprecatedKt$toChannel$1 = (ChannelsKt__DeprecatedKt$toChannel$1) continuation;
            int i2 = channelsKt__DeprecatedKt$toChannel$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toChannel$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = channelsKt__DeprecatedKt$toChannel$1.result;
                obj = b.d();
                i = channelsKt__DeprecatedKt$toChannel$1.label;
                if (i != 0) {
                    k12.b(obj2);
                    try {
                        channelIterator2 = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$toChannel$1.L$0 = c;
                        channelsKt__DeprecatedKt$toChannel$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$toChannel$1.L$2 = channelIterator2;
                        channelsKt__DeprecatedKt$toChannel$1.label = 1;
                        hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$toChannel$1);
                        if (hasNext == obj) {
                            return obj;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = channelIterator2;
                        obj2 = hasNext;
                        sendChannel = c;
                        if (!((Boolean) obj2).booleanValue()) {
                            ur2 ur2 = ur2.INSTANCE;
                            b.b(receiveChannel2, null);
                        }
                        ur2 ur22 = ur2.INSTANCE;
                        b.b(receiveChannel2, null);
                        return sendChannel;
                        return obj;
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$toChannel$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$1;
                    k12.b(obj2);
                    sendChannel = (SendChannel) channelsKt__DeprecatedKt$toChannel$1.L$0;
                    if (!((Boolean) obj2).booleanValue()) {
                        Object next = channelIterator.next();
                        channelsKt__DeprecatedKt$toChannel$1.L$0 = sendChannel;
                        channelsKt__DeprecatedKt$toChannel$1.L$1 = receiveChannel2;
                        channelsKt__DeprecatedKt$toChannel$1.L$2 = channelIterator;
                        channelsKt__DeprecatedKt$toChannel$1.label = 2;
                        Object send = sendChannel.send(next, channelsKt__DeprecatedKt$toChannel$1);
                        c2 = sendChannel;
                        if (send == obj) {
                            return obj;
                        }
                    }
                    ur2 ur222 = ur2.INSTANCE;
                    b.b(receiveChannel2, null);
                    return sendChannel;
                } else if (i == 2) {
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$toChannel$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$1;
                    ?? r2 = (SendChannel) channelsKt__DeprecatedKt$toChannel$1.L$0;
                    try {
                        k12.b(obj2);
                        c2 = r2;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            b.b(receiveChannel2, th);
                            throw th4;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel2;
                c = c2;
                channelsKt__DeprecatedKt$toChannel$1.L$0 = c;
                channelsKt__DeprecatedKt$toChannel$1.L$1 = receiveChannel;
                channelsKt__DeprecatedKt$toChannel$1.L$2 = channelIterator2;
                channelsKt__DeprecatedKt$toChannel$1.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$toChannel$1);
                if (hasNext == obj) {
                }
                return obj;
            }
        }
        channelsKt__DeprecatedKt$toChannel$1 = new ChannelsKt__DeprecatedKt$toChannel$1(continuation);
        Object obj22 = channelsKt__DeprecatedKt$toChannel$1.result;
        obj = b.d();
        i = channelsKt__DeprecatedKt$toChannel$1.label;
        if (i != 0) {
        }
        channelIterator2 = channelIterator;
        receiveChannel = receiveChannel2;
        c = c2;
        channelsKt__DeprecatedKt$toChannel$1.L$0 = c;
        channelsKt__DeprecatedKt$toChannel$1.L$1 = receiveChannel;
        channelsKt__DeprecatedKt$toChannel$1.L$2 = channelIterator2;
        channelsKt__DeprecatedKt$toChannel$1.label = 1;
        hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$toChannel$1);
        if (hasNext == obj) {
        }
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @PublishedApi
    @Nullable
    public static final <E, C extends Collection<? super E>> Object s(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        ChannelsKt__DeprecatedKt$toCollection$1 channelsKt__DeprecatedKt$toCollection$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ChannelIterator<? extends E> channelIterator;
        Collection collection;
        C c2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$toCollection$1) {
            channelsKt__DeprecatedKt$toCollection$1 = (ChannelsKt__DeprecatedKt$toCollection$1) continuation;
            int i2 = channelsKt__DeprecatedKt$toCollection$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toCollection$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = channelsKt__DeprecatedKt$toCollection$1.result;
                obj = b.d();
                i = channelsKt__DeprecatedKt$toCollection$1.label;
                if (i != 0) {
                    k12.b(obj2);
                    try {
                        receiveChannel2 = receiveChannel;
                        channelIterator2 = receiveChannel.iterator();
                        c2 = c;
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
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$toCollection$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$toCollection$1.L$1;
                    Collection collection2 = (Collection) channelsKt__DeprecatedKt$toCollection$1.L$0;
                    try {
                        k12.b(obj2);
                        collection = collection2;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj2).booleanValue()) {
                            collection.add(channelIterator.next());
                            c2 = collection;
                            channelIterator2 = channelIterator;
                        }
                        ur2 ur2 = ur2.INSTANCE;
                        b.b(receiveChannel2, null);
                        return collection;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__DeprecatedKt$toCollection$1.L$0 = c2;
                channelsKt__DeprecatedKt$toCollection$1.L$1 = receiveChannel2;
                channelsKt__DeprecatedKt$toCollection$1.L$2 = channelIterator2;
                channelsKt__DeprecatedKt$toCollection$1.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$toCollection$1);
                if (hasNext != obj) {
                    return obj;
                }
                collection = c2;
                obj2 = hasNext;
                channelIterator = channelIterator2;
                if (!((Boolean) obj2).booleanValue()) {
                    ur2 ur22 = ur2.INSTANCE;
                    b.b(receiveChannel2, null);
                }
                ur2 ur222 = ur2.INSTANCE;
                b.b(receiveChannel2, null);
                return collection;
                return obj;
            }
        }
        channelsKt__DeprecatedKt$toCollection$1 = new ChannelsKt__DeprecatedKt$toCollection$1(continuation);
        Object obj22 = channelsKt__DeprecatedKt$toCollection$1.result;
        obj = b.d();
        i = channelsKt__DeprecatedKt$toCollection$1.label;
        if (i != 0) {
        }
        channelsKt__DeprecatedKt$toCollection$1.L$0 = c2;
        channelsKt__DeprecatedKt$toCollection$1.L$1 = receiveChannel2;
        channelsKt__DeprecatedKt$toCollection$1.L$2 = channelIterator2;
        channelsKt__DeprecatedKt$toCollection$1.label = 1;
        hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$toCollection$1);
        if (hasNext != obj) {
        }
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @PublishedApi
    @Nullable
    public static final <K, V, M extends Map<? super K, ? super V>> Object t(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @NotNull M m, @NotNull Continuation<? super M> continuation) {
        ChannelsKt__DeprecatedKt$toMap$2 channelsKt__DeprecatedKt$toMap$2;
        Object obj;
        int i;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel2;
        Throwable th;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator;
        Map map;
        M m2;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$toMap$2) {
            channelsKt__DeprecatedKt$toMap$2 = (ChannelsKt__DeprecatedKt$toMap$2) continuation;
            int i2 = channelsKt__DeprecatedKt$toMap$2.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toMap$2.label = i2 - Integer.MIN_VALUE;
                Object obj2 = channelsKt__DeprecatedKt$toMap$2.result;
                obj = b.d();
                i = channelsKt__DeprecatedKt$toMap$2.label;
                if (i != 0) {
                    k12.b(obj2);
                    try {
                        receiveChannel2 = receiveChannel;
                        channelIterator2 = receiveChannel.iterator();
                        m2 = m;
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
                    ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$toMap$2.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$toMap$2.L$1;
                    Map map2 = (Map) channelsKt__DeprecatedKt$toMap$2.L$0;
                    try {
                        k12.b(obj2);
                        map = map2;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj2).booleanValue()) {
                            Pair pair = (Pair) channelIterator.next();
                            map.put(pair.getFirst(), pair.getSecond());
                            m2 = map;
                            channelIterator2 = channelIterator;
                        }
                        ur2 ur2 = ur2.INSTANCE;
                        b.b(receiveChannel2, null);
                        return map;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__DeprecatedKt$toMap$2.L$0 = m2;
                channelsKt__DeprecatedKt$toMap$2.L$1 = receiveChannel2;
                channelsKt__DeprecatedKt$toMap$2.L$2 = channelIterator2;
                channelsKt__DeprecatedKt$toMap$2.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$toMap$2);
                if (hasNext != obj) {
                    return obj;
                }
                map = m2;
                obj2 = hasNext;
                channelIterator = channelIterator2;
                if (!((Boolean) obj2).booleanValue()) {
                    ur2 ur22 = ur2.INSTANCE;
                    b.b(receiveChannel2, null);
                }
                ur2 ur222 = ur2.INSTANCE;
                b.b(receiveChannel2, null);
                return map;
                return obj;
            }
        }
        channelsKt__DeprecatedKt$toMap$2 = new ChannelsKt__DeprecatedKt$toMap$2(continuation);
        Object obj22 = channelsKt__DeprecatedKt$toMap$2.result;
        obj = b.d();
        i = channelsKt__DeprecatedKt$toMap$2.label;
        if (i != 0) {
        }
        channelsKt__DeprecatedKt$toMap$2.L$0 = m2;
        channelsKt__DeprecatedKt$toMap$2.L$1 = receiveChannel2;
        channelsKt__DeprecatedKt$toMap$2.L$2 = channelIterator2;
        channelsKt__DeprecatedKt$toMap$2.label = 1;
        hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$toMap$2);
        if (hasNext != obj) {
        }
        return obj;
    }
}
