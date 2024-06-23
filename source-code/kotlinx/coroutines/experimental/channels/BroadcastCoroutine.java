package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.model.HttpHeaders;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.AbstractCoroutine;
import kotlinx.coroutines.experimental.Cancelled;
import kotlinx.coroutines.experimental.CompletedExceptionally;
import kotlinx.coroutines.experimental.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.experimental.selects.SelectClause2;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B#\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0001J\u0016\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"H\u0010¢\u0006\u0002\b#J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0001J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0001J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0001¢\u0006\u0002\b&J\u0019\u0010)\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010*R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\nX\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\nX\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R$\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0002\u0004\n\u0002\b\t¨\u0006+"}, d2 = {"Lkotlinx/coroutines/experimental/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/experimental/AbstractCoroutine;", "", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "Lkotlinx/coroutines/experimental/channels/BroadcastChannel;", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "_channel", "active", "", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/channels/BroadcastChannel;Z)V", "get_channel", "()Lkotlinx/coroutines/experimental/channels/BroadcastChannel;", "channel", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/experimental/channels/SendChannel;", "isClosedForSend", "()Z", "isFull", "onSend", "Lkotlinx/coroutines/experimental/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/experimental/selects/SelectClause2;", "cancel", "cause", "", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "offer", "element", "(Ljava/lang/Object;)Z", "onCancellationInternal", "exceptionally", "Lkotlinx/coroutines/experimental/CompletedExceptionally;", "onCancellationInternal$kotlinx_coroutines_core", "open", "Lkotlinx/coroutines/experimental/channels/SubscriptionReceiveChannel;", "openSubscription", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "openSubscription1", "send", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Broadcast.kt */
class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements ProducerScope<E>, BroadcastChannel<E> {
    private final BroadcastChannel<E> _channel;

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean close(Throwable th) {
        return this._channel.close(th);
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean isFull() {
        return this._channel.isFull();
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean offer(E e) {
        return this._channel.offer(e);
    }

    @Override // kotlinx.coroutines.experimental.channels.BroadcastChannel
    @Deprecated(message = "Renamed to `openSubscription`", replaceWith = @ReplaceWith(expression = "openSubscription()", imports = {}))
    public SubscriptionReceiveChannel<E> open() {
        return this._channel.open();
    }

    @Override // kotlinx.coroutines.experimental.channels.BroadcastChannel, kotlinx.coroutines.experimental.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        return this._channel.openSubscription();
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    /* access modifiers changed from: protected */
    public final BroadcastChannel<E> get_channel() {
        return this._channel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastCoroutine(CoroutineContext coroutineContext, BroadcastChannel<E> broadcastChannel, boolean z) {
        super(coroutineContext, z);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(broadcastChannel, "_channel");
        this._channel = broadcastChannel;
    }

    @Override // kotlinx.coroutines.experimental.channels.ProducerScope
    public SendChannel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.experimental.AbstractCoroutine, kotlinx.coroutines.experimental.JobSupport, kotlinx.coroutines.experimental.channels.BroadcastChannel, kotlinx.coroutines.experimental.Job
    public boolean cancel(Throwable th) {
        return super.cancel(th);
    }

    @Override // kotlinx.coroutines.experimental.AbstractCoroutine, kotlinx.coroutines.experimental.JobSupport
    public void onCancellationInternal$kotlinx_coroutines_core(CompletedExceptionally completedExceptionally) {
        boolean z;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        if (completedExceptionally instanceof Cancelled) {
            z = this._channel.cancel(th);
        } else {
            z = this._channel.close(th);
        }
        if (!z && th != null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        }
    }

    static /* synthetic */ Object send$suspendImpl(BroadcastCoroutine broadcastCoroutine, Object obj, Continuation continuation) {
        return broadcastCoroutine._channel.send(obj, continuation);
    }
}
