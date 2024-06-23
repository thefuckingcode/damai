package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.channels.ReceiveChannel;
import tb.fh;
import tb.k12;
import tb.ur2;

public final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object b(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super ur2> continuation) {
        Object c = c(flowCollector, receiveChannel, true, continuation);
        return c == b.d() ? c : ur2.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <T> Object c(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, boolean z, Continuation<? super ur2> continuation) {
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        Object obj;
        int i;
        Throwable th;
        boolean z2;
        Object obj2;
        FlowCollector flowCollector2;
        Throwable e;
        FlowCollector<? super T> flowCollector3;
        if (continuation instanceof FlowKt__ChannelsKt$emitAllImpl$1) {
            flowKt__ChannelsKt$emitAllImpl$1 = (FlowKt__ChannelsKt$emitAllImpl$1) continuation;
            int i2 = flowKt__ChannelsKt$emitAllImpl$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ChannelsKt$emitAllImpl$1.label = i2 - Integer.MIN_VALUE;
                Object obj3 = flowKt__ChannelsKt$emitAllImpl$1.result;
                obj = b.d();
                i = flowKt__ChannelsKt$emitAllImpl$1.label;
                if (i != 0) {
                    k12.b(obj3);
                    c.k(flowCollector);
                    flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                    flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                    flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                    flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                    obj2 = receiveChannel.m928receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$1);
                    if (obj2 == obj) {
                        return obj;
                    }
                    flowCollector2 = flowCollector;
                    z2 = z;
                    if (!fh.i(obj2)) {
                    }
                    e = fh.e(obj2);
                    if (e != null) {
                    }
                    return obj;
                } else if (i == 1) {
                    z2 = flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                    receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                    k12.b(obj3);
                    obj2 = ((fh) obj3).l();
                    flowCollector2 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                    if (!fh.i(obj2)) {
                        e = fh.e(obj2);
                    } else {
                        flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector2;
                        flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z2;
                        flowKt__ChannelsKt$emitAllImpl$1.label = 2;
                        Object emit = flowCollector2.emit((Object) fh.g(obj2), flowKt__ChannelsKt$emitAllImpl$1);
                        flowCollector3 = flowCollector2;
                        if (emit == obj) {
                            return obj;
                        }
                    }
                    e = fh.e(obj2);
                    if (e != null) {
                        if (z2) {
                            kotlinx.coroutines.channels.b.b(receiveChannel, null);
                        }
                        return ur2.INSTANCE;
                    }
                    throw e;
                } else if (i == 2) {
                    z2 = flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                    receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                    FlowCollector<? super T> flowCollector4 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                    try {
                        k12.b(obj3);
                        flowCollector3 = flowCollector4;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            if (z2) {
                                kotlinx.coroutines.channels.b.b(receiveChannel, th);
                            }
                            throw th3;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = z2;
                flowCollector = flowCollector3;
                flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                obj2 = receiveChannel.m928receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$1);
                if (obj2 == obj) {
                }
                return obj;
            }
        }
        flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
        Object obj32 = flowKt__ChannelsKt$emitAllImpl$1.result;
        obj = b.d();
        i = flowKt__ChannelsKt$emitAllImpl$1.label;
        if (i != 0) {
        }
        z = z2;
        flowCollector = flowCollector3;
        try {
            flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
            flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
            flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
            flowKt__ChannelsKt$emitAllImpl$1.label = 1;
            obj2 = receiveChannel.m928receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$1);
            if (obj2 == obj) {
            }
            return obj;
        } catch (Throwable th4) {
            th = th4;
            z2 = z;
            throw th;
        }
    }
}
