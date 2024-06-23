package kotlinx.coroutines.experimental.channels;

import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.EmptyCoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.experimental.DelayKt;
import kotlinx.coroutines.experimental.TimeSourceKt;
import kotlinx.coroutines.experimental.Unconfined;

public final class TickerChannelsKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TickerMode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
            iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
        }
    }

    public static /* bridge */ /* synthetic */ ReceiveChannel ticker$default(long j, TimeUnit timeUnit, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        long j3 = (i & 4) != 0 ? j : j2;
        if ((i & 8) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 16) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, timeUnit, j3, coroutineContext, tickerMode);
    }

    public static final ReceiveChannel<Unit> ticker(long j, TimeUnit timeUnit, long j2, CoroutineContext coroutineContext, TickerMode tickerMode) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(tickerMode, "mode");
        boolean z = true;
        if (j >= 0) {
            if (j2 < 0) {
                z = false;
            }
            if (z) {
                return ProduceKt.produce$default(Unconfined.INSTANCE.plus(coroutineContext), 0, null, null, new TickerChannelsKt$ticker$3(tickerMode, j, timeUnit, j2, null), 12, null);
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2).toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j).toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0184 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0036  */
    static final /* synthetic */ Object fixedPeriodTicker(long j, TimeUnit timeUnit, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$1;
        Object coroutine_suspended;
        int label;
        long j3;
        long j4;
        long j5;
        TimeUnit timeUnit2;
        SendChannel<? super Unit> sendChannel2;
        long j6;
        long j7;
        long j8;
        long j9;
        SendChannel<? super Unit> sendChannel3;
        long j10;
        long j11;
        long j12;
        SendChannel<? super Unit> sendChannel4;
        long coerceAtLeast;
        TimeUnit timeUnit3;
        Unit unit;
        SendChannel<? super Unit> sendChannel5;
        TimeUnit timeUnit4 = timeUnit;
        if (continuation instanceof TickerChannelsKt$fixedPeriodTicker$1) {
            tickerChannelsKt$fixedPeriodTicker$1 = (TickerChannelsKt$fixedPeriodTicker$1) continuation;
            if ((tickerChannelsKt$fixedPeriodTicker$1.getLabel() & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedPeriodTicker$1.setLabel(tickerChannelsKt$fixedPeriodTicker$1.getLabel() - Integer.MIN_VALUE);
                Object obj = tickerChannelsKt$fixedPeriodTicker$1.data;
                Throwable th = tickerChannelsKt$fixedPeriodTicker$1.exception;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = tickerChannelsKt$fixedPeriodTicker$1.getLabel();
                int i = 2;
                if (label == 0) {
                    if (label == 1) {
                        long j13 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                        sendChannel5 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$1;
                        j9 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        TimeUnit timeUnit5 = (TimeUnit) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        j7 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        if (th == null) {
                            j8 = j13;
                            timeUnit4 = timeUnit5;
                        } else {
                            throw th;
                        }
                    } else if (label == 2) {
                        long j14 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                        j12 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                        SendChannel<? super Unit> sendChannel6 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$1;
                        j11 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        timeUnit2 = (TimeUnit) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        j3 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        if (th == null) {
                            j6 = j14;
                            sendChannel4 = sendChannel6;
                            sendChannel2 = sendChannel4;
                            long nanoTime = TimeSourceKt.getTimeSource().nanoTime();
                            coerceAtLeast = RangesKt.coerceAtLeast(j12 - nanoTime, 0L);
                            if (coerceAtLeast == 0) {
                            }
                            timeUnit3 = TimeUnit.NANOSECONDS;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = timeUnit2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                            tickerChannelsKt$fixedPeriodTicker$1.L$1 = sendChannel2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$2 = j12;
                            tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                            tickerChannelsKt$fixedPeriodTicker$1.J$4 = nanoTime;
                            tickerChannelsKt$fixedPeriodTicker$1.J$5 = coerceAtLeast;
                            tickerChannelsKt$fixedPeriodTicker$1.setLabel(4);
                            if (DelayKt.delay(coerceAtLeast, timeUnit3, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        throw th;
                    } else if (label == 3) {
                        long j15 = tickerChannelsKt$fixedPeriodTicker$1.J$6;
                        long j16 = tickerChannelsKt$fixedPeriodTicker$1.J$5;
                        long j17 = tickerChannelsKt$fixedPeriodTicker$1.J$4;
                        j10 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                        j5 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                        SendChannel<? super Unit> sendChannel7 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$1;
                        j4 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        timeUnit2 = (TimeUnit) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        j3 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        if (th == null) {
                            sendChannel2 = sendChannel7;
                            j6 = j10;
                            timeUnit4 = timeUnit2;
                            j7 = j3;
                            j8 = j5;
                            j9 = j4;
                            sendChannel3 = sendChannel2;
                            i = 2;
                            long j18 = j8 + j6;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = timeUnit4;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j9;
                            tickerChannelsKt$fixedPeriodTicker$1.L$1 = sendChannel3;
                            tickerChannelsKt$fixedPeriodTicker$1.J$2 = j18;
                            tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                            tickerChannelsKt$fixedPeriodTicker$1.setLabel(i);
                            if (sendChannel3.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        throw th;
                    } else if (label == 4) {
                        long j19 = tickerChannelsKt$fixedPeriodTicker$1.J$5;
                        long j20 = tickerChannelsKt$fixedPeriodTicker$1.J$4;
                        long j21 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                        j5 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                        SendChannel<? super Unit> sendChannel8 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$1;
                        j4 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        timeUnit2 = (TimeUnit) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        j3 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        if (th == null) {
                            sendChannel2 = sendChannel8;
                            j6 = j21;
                            timeUnit4 = timeUnit2;
                            j7 = j3;
                            j8 = j5;
                            j9 = j4;
                            sendChannel3 = sendChannel2;
                            i = 2;
                            long j182 = j8 + j6;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = timeUnit4;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j9;
                            tickerChannelsKt$fixedPeriodTicker$1.L$1 = sendChannel3;
                            tickerChannelsKt$fixedPeriodTicker$1.J$2 = j182;
                            tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                            tickerChannelsKt$fixedPeriodTicker$1.setLabel(i);
                            if (sendChannel3.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            timeUnit2 = timeUnit4;
                            j12 = j182;
                            j3 = j7;
                            j11 = j9;
                            sendChannel4 = sendChannel3;
                            sendChannel2 = sendChannel4;
                            long nanoTime2 = TimeSourceKt.getTimeSource().nanoTime();
                            coerceAtLeast = RangesKt.coerceAtLeast(j12 - nanoTime2, 0L);
                            if (coerceAtLeast == 0 || j6 == 0) {
                                timeUnit3 = TimeUnit.NANOSECONDS;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = timeUnit2;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                                tickerChannelsKt$fixedPeriodTicker$1.L$1 = sendChannel2;
                                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j12;
                                tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                                tickerChannelsKt$fixedPeriodTicker$1.J$4 = nanoTime2;
                                tickerChannelsKt$fixedPeriodTicker$1.J$5 = coerceAtLeast;
                                tickerChannelsKt$fixedPeriodTicker$1.setLabel(4);
                                if (DelayKt.delay(coerceAtLeast, timeUnit3, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                j4 = j11;
                                j21 = j6;
                                j5 = j12;
                                j6 = j21;
                                timeUnit4 = timeUnit2;
                                j7 = j3;
                                j8 = j5;
                                j9 = j4;
                                sendChannel3 = sendChannel2;
                                i = 2;
                                long j1822 = j8 + j6;
                                unit = Unit.INSTANCE;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = timeUnit4;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j9;
                                tickerChannelsKt$fixedPeriodTicker$1.L$1 = sendChannel3;
                                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j1822;
                                tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                                tickerChannelsKt$fixedPeriodTicker$1.setLabel(i);
                                if (sendChannel3.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                                }
                                return coroutine_suspended;
                            }
                            long j22 = j6 - ((nanoTime2 - j12) % j6);
                            long j23 = nanoTime2 + j22;
                            TimeUnit timeUnit6 = TimeUnit.NANOSECONDS;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = timeUnit2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                            tickerChannelsKt$fixedPeriodTicker$1.L$1 = sendChannel2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$2 = j23;
                            tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                            tickerChannelsKt$fixedPeriodTicker$1.J$4 = nanoTime2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$5 = coerceAtLeast;
                            tickerChannelsKt$fixedPeriodTicker$1.J$6 = j22;
                            tickerChannelsKt$fixedPeriodTicker$1.setLabel(3);
                            if (DelayKt.delay(j22, timeUnit6, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            j4 = j11;
                            j10 = j6;
                            j5 = j23;
                            j6 = j10;
                            timeUnit4 = timeUnit2;
                            j7 = j3;
                            j8 = j5;
                            j9 = j4;
                            sendChannel3 = sendChannel2;
                            i = 2;
                            long j18222 = j8 + j6;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = timeUnit4;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j9;
                            tickerChannelsKt$fixedPeriodTicker$1.L$1 = sendChannel3;
                            tickerChannelsKt$fixedPeriodTicker$1.J$2 = j18222;
                            tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                            tickerChannelsKt$fixedPeriodTicker$1.setLabel(i);
                            if (sendChannel3.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                            timeUnit3 = TimeUnit.NANOSECONDS;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = timeUnit2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                            tickerChannelsKt$fixedPeriodTicker$1.L$1 = sendChannel2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$2 = j12;
                            tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                            tickerChannelsKt$fixedPeriodTicker$1.J$4 = nanoTime2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$5 = coerceAtLeast;
                            tickerChannelsKt$fixedPeriodTicker$1.setLabel(4);
                            if (DelayKt.delay(coerceAtLeast, timeUnit3, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            }
                            return coroutine_suspended;
                            return coroutine_suspended;
                        }
                        throw th;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th == null) {
                    long nanoTime3 = TimeSourceKt.getTimeSource().nanoTime() + timeUnit.toNanos(j2);
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = timeUnit4;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j2;
                    tickerChannelsKt$fixedPeriodTicker$1.L$1 = sendChannel;
                    tickerChannelsKt$fixedPeriodTicker$1.J$2 = nanoTime3;
                    tickerChannelsKt$fixedPeriodTicker$1.setLabel(1);
                    if (DelayKt.delay(j2, timeUnit4, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sendChannel5 = sendChannel;
                    j7 = j;
                    j9 = j2;
                    j8 = nanoTime3;
                } else {
                    throw th;
                }
                j6 = timeUnit4.toNanos(j7);
                sendChannel3 = sendChannel5;
                long j182222 = j8 + j6;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
                tickerChannelsKt$fixedPeriodTicker$1.L$0 = timeUnit4;
                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j9;
                tickerChannelsKt$fixedPeriodTicker$1.L$1 = sendChannel3;
                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j182222;
                tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                tickerChannelsKt$fixedPeriodTicker$1.setLabel(i);
                if (sendChannel3.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        tickerChannelsKt$fixedPeriodTicker$1 = new TickerChannelsKt$fixedPeriodTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedPeriodTicker$1.data;
        Throwable th2 = tickerChannelsKt$fixedPeriodTicker$1.exception;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = tickerChannelsKt$fixedPeriodTicker$1.getLabel();
        int i2 = 2;
        if (label == 0) {
        }
        j6 = timeUnit4.toNanos(j7);
        sendChannel3 = sendChannel5;
        long j1822222 = j8 + j6;
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
        tickerChannelsKt$fixedPeriodTicker$1.L$0 = timeUnit4;
        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j9;
        tickerChannelsKt$fixedPeriodTicker$1.L$1 = sendChannel3;
        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j1822222;
        tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
        tickerChannelsKt$fixedPeriodTicker$1.setLabel(i2);
        if (sendChannel3.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0033  */
    static final /* synthetic */ Object fixedDelayTicker(long j, TimeUnit timeUnit, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedDelayTicker$1 tickerChannelsKt$fixedDelayTicker$1;
        Object coroutine_suspended;
        int label;
        long j3;
        TimeUnit timeUnit2;
        SendChannel<? super Unit> sendChannel2;
        SendChannel<? super Unit> sendChannel3;
        Unit unit;
        TimeUnit timeUnit3 = timeUnit;
        long j4 = j2;
        if (continuation instanceof TickerChannelsKt$fixedDelayTicker$1) {
            tickerChannelsKt$fixedDelayTicker$1 = (TickerChannelsKt$fixedDelayTicker$1) continuation;
            if ((tickerChannelsKt$fixedDelayTicker$1.getLabel() & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedDelayTicker$1.setLabel(tickerChannelsKt$fixedDelayTicker$1.getLabel() - Integer.MIN_VALUE);
                Object obj = tickerChannelsKt$fixedDelayTicker$1.data;
                Throwable th = tickerChannelsKt$fixedDelayTicker$1.exception;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = tickerChannelsKt$fixedDelayTicker$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$1;
                        j4 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                        timeUnit2 = (TimeUnit) tickerChannelsKt$fixedDelayTicker$1.L$0;
                        j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                        if (th != null) {
                            throw th;
                        }
                    } else if (label == 2) {
                        sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$1;
                        j4 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                        timeUnit2 = (TimeUnit) tickerChannelsKt$fixedDelayTicker$1.L$0;
                        j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                        if (th != null) {
                            throw th;
                        }
                        tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                        tickerChannelsKt$fixedDelayTicker$1.L$0 = timeUnit2;
                        tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                        tickerChannelsKt$fixedDelayTicker$1.L$1 = sendChannel2;
                        tickerChannelsKt$fixedDelayTicker$1.setLabel(3);
                        if (DelayKt.delay(j3, timeUnit2, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (label == 3) {
                        sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$1;
                        j4 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                        timeUnit2 = (TimeUnit) tickerChannelsKt$fixedDelayTicker$1.L$0;
                        j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                        if (th != null) {
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th == null) {
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = timeUnit3;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                    sendChannel3 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.L$1 = sendChannel3;
                    tickerChannelsKt$fixedDelayTicker$1.setLabel(1);
                    if (DelayKt.delay(j4, timeUnit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = j;
                    unit = Unit.INSTANCE;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = timeUnit3;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                    tickerChannelsKt$fixedDelayTicker$1.L$1 = sendChannel3;
                    tickerChannelsKt$fixedDelayTicker$1.setLabel(2);
                    if (sendChannel3.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    timeUnit2 = timeUnit3;
                    sendChannel2 = sendChannel3;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = timeUnit2;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                    tickerChannelsKt$fixedDelayTicker$1.L$1 = sendChannel2;
                    tickerChannelsKt$fixedDelayTicker$1.setLabel(3);
                    if (DelayKt.delay(j3, timeUnit2, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else {
                    throw th;
                }
                sendChannel3 = sendChannel2;
                timeUnit3 = timeUnit2;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = timeUnit3;
                tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                tickerChannelsKt$fixedDelayTicker$1.L$1 = sendChannel3;
                tickerChannelsKt$fixedDelayTicker$1.setLabel(2);
                if (sendChannel3.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        tickerChannelsKt$fixedDelayTicker$1 = new TickerChannelsKt$fixedDelayTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedDelayTicker$1.data;
        Throwable th2 = tickerChannelsKt$fixedDelayTicker$1.exception;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = tickerChannelsKt$fixedDelayTicker$1.getLabel();
        if (label == 0) {
        }
        sendChannel3 = sendChannel2;
        timeUnit3 = timeUnit2;
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
        tickerChannelsKt$fixedDelayTicker$1.L$0 = timeUnit3;
        tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
        tickerChannelsKt$fixedDelayTicker$1.L$1 = sendChannel3;
        tickerChannelsKt$fixedDelayTicker$1.setLabel(2);
        if (sendChannel3.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
