package kotlinx.coroutines.experimental.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.Cancelled;
import kotlinx.coroutines.experimental.CompletedExceptionally;
import kotlinx.coroutines.experimental.CoroutineExceptionHandlerKt;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0010¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ProducerCoroutine;", "E", "Lkotlinx/coroutines/experimental/channels/ChannelCoroutine;", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "Lkotlinx/coroutines/experimental/channels/ProducerJob;", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "channel", "Lkotlinx/coroutines/experimental/channels/Channel;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/channels/Channel;)V", "onCancellationInternal", "", "exceptionally", "Lkotlinx/coroutines/experimental/CompletedExceptionally;", "onCancellationInternal$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Produce.kt */
public final class ProducerCoroutine<E> extends ChannelCoroutine<E> implements ProducerScope<E>, ProducerJob<E> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProducerCoroutine(CoroutineContext coroutineContext, Channel<E> channel) {
        super(coroutineContext, channel, true);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
    }

    @Override // kotlinx.coroutines.experimental.AbstractCoroutine, kotlinx.coroutines.experimental.JobSupport
    public void onCancellationInternal$kotlinx_coroutines_core(CompletedExceptionally completedExceptionally) {
        boolean z;
        Throwable th = null;
        Throwable th2 = completedExceptionally != null ? completedExceptionally.cause : null;
        if (completedExceptionally instanceof Cancelled) {
            Channel<E> channel = get_channel();
            if (!(th2 instanceof CancellationException)) {
                th = th2;
            }
            z = channel.cancel(th);
        } else {
            z = get_channel().close(th2);
        }
        if (!z && th2 != null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th2);
        }
    }
}
