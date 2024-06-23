package kotlinx.coroutines.experimental.channels;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.channels.TickerChannelsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "invoke", "(Lkotlinx/coroutines/experimental/channels/ProducerScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
/* compiled from: TickerChannels.kt */
final class TickerChannelsKt$ticker$3 extends CoroutineImpl implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delay;
    final /* synthetic */ long $initialDelay;
    final /* synthetic */ TickerMode $mode;
    final /* synthetic */ TimeUnit $unit;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TickerChannelsKt$ticker$3(TickerMode tickerMode, long j, TimeUnit timeUnit, long j2, Continuation continuation) {
        super(2, continuation);
        this.$mode = tickerMode;
        this.$delay = j;
        this.$unit = timeUnit;
        this.$initialDelay = j2;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((ProducerScope) obj, (Continuation<? super Unit>) continuation);
    }

    public final Continuation<Unit> create(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        TickerChannelsKt$ticker$3 tickerChannelsKt$ticker$3 = new TickerChannelsKt$ticker$3(this.$mode, this.$delay, this.$unit, this.$initialDelay, continuation);
        tickerChannelsKt$ticker$3.p$ = producerScope;
        return tickerChannelsKt$ticker$3;
    }

    public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(producerScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((TickerChannelsKt$ticker$3) create(producerScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (th != null) {
                    throw th;
                }
            } else if (th != null) {
                throw th;
            }
        } else if (th == null) {
            ProducerScope producerScope = this.p$;
            int i2 = TickerChannelsKt.WhenMappings.$EnumSwitchMapping$0[this.$mode.ordinal()];
            if (i2 == 1) {
                long j = this.$delay;
                TimeUnit timeUnit = this.$unit;
                long j2 = this.$initialDelay;
                SendChannel channel = producerScope.getChannel();
                this.label = 1;
                if (TickerChannelsKt.fixedPeriodTicker(j, timeUnit, j2, channel, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 == 2) {
                long j3 = this.$delay;
                TimeUnit timeUnit2 = this.$unit;
                long j4 = this.$initialDelay;
                SendChannel channel2 = producerScope.getChannel();
                this.label = 2;
                if (TickerChannelsKt.fixedDelayTicker(j3, timeUnit2, j4, channel2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            throw th;
        }
        return Unit.INSTANCE;
    }
}
