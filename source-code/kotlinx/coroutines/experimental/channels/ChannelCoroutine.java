package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.model.HttpHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.AbstractCoroutine;
import kotlinx.coroutines.experimental.selects.SelectClause1;
import kotlinx.coroutines.experimental.selects.SelectClause2;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0013\u0010\"\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u0001J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0003J\u0016\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0002\u0010)J\u0011\u0010*\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u0004\u0018\u00018\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0019\u0010-\u001a\u00020\u00032\u0006\u0010&\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010.R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0012\u0010\u000f\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0012\u0010\u0012\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0015X\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R$\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c0\u001bX\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u0004\n\u0002\b\t¨\u0006/"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/experimental/AbstractCoroutine;", "", "Lkotlinx/coroutines/experimental/channels/Channel;", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "_channel", "active", "", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/channels/Channel;Z)V", "get_channel", "()Lkotlinx/coroutines/experimental/channels/Channel;", "channel", "getChannel", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "isFull", "onReceive", "Lkotlinx/coroutines/experimental/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/experimental/selects/SelectClause1;", "onReceiveOrNull", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/experimental/selects/SelectClause2;", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/experimental/selects/SelectClause2;", "cancel", "cause", "", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "iterator", "Lkotlinx/coroutines/experimental/channels/ChannelIterator;", "offer", "element", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChannelCoroutine.kt */
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    private final Channel<E> _channel;

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean close(Throwable th) {
        return this._channel.close(th);
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public SelectClause1<E> getOnReceive() {
        return this._channel.getOnReceive();
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        return this._channel.getOnReceiveOrNull();
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this._channel.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public boolean isEmpty() {
        return this._channel.isEmpty();
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean isFull() {
        return this._channel.isFull();
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return this._channel.iterator();
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean offer(E e) {
        return this._channel.offer(e);
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public E poll() {
        return this._channel.poll();
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public Object receive(Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return receiveOrNull$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    /* access modifiers changed from: protected */
    public final Channel<E> get_channel() {
        return this._channel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelCoroutine(CoroutineContext coroutineContext, Channel<E> channel, boolean z) {
        super(coroutineContext, z);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(channel, "_channel");
        this._channel = channel;
    }

    public final Channel<E> getChannel() {
        return this;
    }

    static /* synthetic */ Object receive$suspendImpl(ChannelCoroutine channelCoroutine, Continuation continuation) {
        return channelCoroutine._channel.receive(continuation);
    }

    static /* synthetic */ Object send$suspendImpl(ChannelCoroutine channelCoroutine, Object obj, Continuation continuation) {
        return channelCoroutine._channel.send(obj, continuation);
    }

    static /* synthetic */ Object receiveOrNull$suspendImpl(ChannelCoroutine channelCoroutine, Continuation continuation) {
        return channelCoroutine._channel.receiveOrNull(continuation);
    }

    @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel, kotlinx.coroutines.experimental.AbstractCoroutine, kotlinx.coroutines.experimental.JobSupport, kotlinx.coroutines.experimental.Job
    public boolean cancel(Throwable th) {
        return super.cancel(th);
    }
}
