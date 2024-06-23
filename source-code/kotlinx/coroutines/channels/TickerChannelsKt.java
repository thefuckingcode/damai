package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.DelayKt;
import tb.cf0;
import tb.k12;
import tb.l2;
import tb.ur2;
import tb.ww1;

public final class TickerChannelsKt {
    public static final /* synthetic */ Object b(long j, long j2, SendChannel sendChannel, Continuation continuation) {
        return d(j, j2, sendChannel, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public static final Object c(long j, long j2, SendChannel<? super ur2> sendChannel, Continuation<? super ur2> continuation) {
        TickerChannelsKt$fixedDelayTicker$1 tickerChannelsKt$fixedDelayTicker$1;
        Object obj;
        int i;
        SendChannel<? super ur2> sendChannel2;
        ur2 ur2;
        if (continuation instanceof TickerChannelsKt$fixedDelayTicker$1) {
            tickerChannelsKt$fixedDelayTicker$1 = (TickerChannelsKt$fixedDelayTicker$1) continuation;
            int i2 = tickerChannelsKt$fixedDelayTicker$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedDelayTicker$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = tickerChannelsKt$fixedDelayTicker$1.result;
                obj = b.d();
                i = tickerChannelsKt$fixedDelayTicker$1.label;
                if (i != 0) {
                    k12.b(obj2);
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.label = 1;
                    if (DelayKt.b(j2, tickerChannelsKt$fixedDelayTicker$1) == obj) {
                        return obj;
                    }
                    ur2 = ur2.INSTANCE;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.label = 2;
                    if (sendChannel.send(ur2, tickerChannelsKt$fixedDelayTicker$1) != obj) {
                    }
                    return obj;
                } else if (i == 1) {
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    k12.b(obj2);
                    ur2 = ur2.INSTANCE;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.label = 2;
                    if (sendChannel.send(ur2, tickerChannelsKt$fixedDelayTicker$1) != obj) {
                        return obj;
                    }
                    sendChannel2 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.label = 3;
                    if (DelayKt.b(j, tickerChannelsKt$fixedDelayTicker$1) == obj) {
                    }
                    return obj;
                } else if (i == 2) {
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    k12.b(obj2);
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.label = 3;
                    if (DelayKt.b(j, tickerChannelsKt$fixedDelayTicker$1) == obj) {
                        return obj;
                    }
                } else if (i == 3) {
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    k12.b(obj2);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sendChannel = sendChannel2;
                ur2 = ur2.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(ur2, tickerChannelsKt$fixedDelayTicker$1) != obj) {
                }
                return obj;
            }
        }
        tickerChannelsKt$fixedDelayTicker$1 = new TickerChannelsKt$fixedDelayTicker$1(continuation);
        Object obj22 = tickerChannelsKt$fixedDelayTicker$1.result;
        obj = b.d();
        i = tickerChannelsKt$fixedDelayTicker$1.label;
        if (i != 0) {
        }
        sendChannel = sendChannel2;
        ur2 = ur2.INSTANCE;
        tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
        tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
        tickerChannelsKt$fixedDelayTicker$1.label = 2;
        if (sendChannel.send(ur2, tickerChannelsKt$fixedDelayTicker$1) != obj) {
        }
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fe A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    private static final Object d(long j, long j2, SendChannel<? super ur2> sendChannel, Continuation<? super ur2> continuation) {
        TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$1;
        Object obj;
        int i;
        long j3;
        long j4;
        SendChannel<? super ur2> sendChannel2;
        long j5;
        long c;
        long j6;
        long j7;
        SendChannel<? super ur2> sendChannel3;
        ur2 ur2;
        long j8;
        SendChannel<? super ur2> sendChannel4;
        if (continuation instanceof TickerChannelsKt$fixedPeriodTicker$1) {
            tickerChannelsKt$fixedPeriodTicker$1 = (TickerChannelsKt$fixedPeriodTicker$1) continuation;
            int i2 = tickerChannelsKt$fixedPeriodTicker$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedPeriodTicker$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = tickerChannelsKt$fixedPeriodTicker$1.result;
                obj = b.d();
                i = tickerChannelsKt$fixedPeriodTicker$1.label;
                if (i != 0) {
                    k12.b(obj2);
                    l2.a();
                    long nanoTime = System.nanoTime() + cf0.d(j2);
                    sendChannel4 = sendChannel;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                    j8 = j;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j8;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = nanoTime;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 1;
                    if (DelayKt.b(j2, tickerChannelsKt$fixedPeriodTicker$1) == obj) {
                        return obj;
                    }
                    j7 = nanoTime;
                    j6 = cf0.d(j8);
                    sendChannel3 = sendChannel4;
                    long j9 = j7 + j6;
                    ur2 = ur2.INSTANCE;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j9;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                    if (sendChannel3.send(ur2, tickerChannelsKt$fixedPeriodTicker$1) != obj) {
                    }
                    return obj;
                } else if (i == 1) {
                    j7 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    long j10 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    k12.b(obj2);
                    sendChannel4 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    j8 = j10;
                    j6 = cf0.d(j8);
                    sendChannel3 = sendChannel4;
                    long j92 = j7 + j6;
                    ur2 = ur2.INSTANCE;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j92;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                    if (sendChannel3.send(ur2, tickerChannelsKt$fixedPeriodTicker$1) != obj) {
                        return obj;
                    }
                    sendChannel2 = sendChannel3;
                    j4 = j6;
                    j3 = j92;
                    l2.a();
                    long nanoTime2 = System.nanoTime();
                    j5 = ww1.b(j3 - nanoTime2, 0);
                    if (j5 == 0) {
                    }
                    c = cf0.c(j5);
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j4;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                    if (DelayKt.b(c, tickerChannelsKt$fixedPeriodTicker$1) == obj) {
                    }
                    return obj;
                } else if (i == 2) {
                    j4 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j3 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    k12.b(obj2);
                    l2.a();
                    long nanoTime22 = System.nanoTime();
                    j5 = ww1.b(j3 - nanoTime22, 0);
                    if (j5 == 0 || j4 == 0) {
                        c = cf0.c(j5);
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j4;
                        tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                        if (DelayKt.b(c, tickerChannelsKt$fixedPeriodTicker$1) == obj) {
                            return obj;
                        }
                    } else {
                        long j11 = j4 - ((nanoTime22 - j3) % j4);
                        j3 = nanoTime22 + j11;
                        long c2 = cf0.c(j11);
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j4;
                        tickerChannelsKt$fixedPeriodTicker$1.label = 3;
                        if (DelayKt.b(c2, tickerChannelsKt$fixedPeriodTicker$1) == obj) {
                            return obj;
                        }
                    }
                    c = cf0.c(j5);
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j4;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                    if (DelayKt.b(c, tickerChannelsKt$fixedPeriodTicker$1) == obj) {
                    }
                } else if (i == 3) {
                    j4 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j3 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    k12.b(obj2);
                } else if (i == 4) {
                    j4 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j3 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    k12.b(obj2);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j7 = j3;
                j6 = j4;
                sendChannel3 = sendChannel2;
                long j922 = j7 + j6;
                ur2 = ur2.INSTANCE;
                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j922;
                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                if (sendChannel3.send(ur2, tickerChannelsKt$fixedPeriodTicker$1) != obj) {
                }
                return obj;
            }
        }
        tickerChannelsKt$fixedPeriodTicker$1 = new TickerChannelsKt$fixedPeriodTicker$1(continuation);
        Object obj22 = tickerChannelsKt$fixedPeriodTicker$1.result;
        obj = b.d();
        i = tickerChannelsKt$fixedPeriodTicker$1.label;
        if (i != 0) {
        }
        j7 = j3;
        j6 = j4;
        sendChannel3 = sendChannel2;
        long j9222 = j7 + j6;
        ur2 = ur2.INSTANCE;
        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j9222;
        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
        tickerChannelsKt$fixedPeriodTicker$1.label = 2;
        if (sendChannel3.send(ur2, tickerChannelsKt$fixedPeriodTicker$1) != obj) {
        }
        return obj;
    }
}
