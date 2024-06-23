package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.intrinsics.CancellableKt;
import kotlinx.coroutines.experimental.selects.SelectClause2;
import kotlinx.coroutines.experimental.selects.SelectInstance;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003BM\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012-\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\rH\u0014JV\u0010\u001a\u001a\u00020\r\"\u0004\b\u0001\u0010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001d2\u0006\u0010\u001e\u001a\u00028\u00002(\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020\r2\u0006\u0010\u0017\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010!R:\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n¢\u0006\u0002\b\u000fX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0011R&\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\t¨\u0006\""}, d2 = {"Lkotlinx/coroutines/experimental/channels/LazyActorCoroutine;", "E", "Lkotlinx/coroutines/experimental/channels/ActorCoroutine;", "Lkotlinx/coroutines/experimental/selects/SelectClause2;", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "channel", "Lkotlinx/coroutines/experimental/channels/Channel;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/channels/ActorScope;", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/channels/Channel;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "onSend", "getOnSend", "()Lkotlinx/coroutines/experimental/selects/SelectClause2;", "offer", "", "element", "(Ljava/lang/Object;)Z", "onStart", "registerSelectClause2", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "param", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "send", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Actor.kt */
final class LazyActorCoroutine<E> extends ActorCoroutine<E> implements SelectClause2<E, SendChannel<? super E>> {
    private final Function2<ActorScope<E>, Continuation<? super Unit>, Object> block;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.experimental.channels.ActorScope<E>, ? super kotlin.coroutines.experimental.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyActorCoroutine(CoroutineContext coroutineContext, Channel<E> channel, Function2<? super ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, channel, false);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        this.block = function2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.AbstractCoroutine
    public void onStart() {
        CancellableKt.startCoroutineCancellable(this.block, this, this);
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel, kotlinx.coroutines.experimental.channels.ChannelCoroutine
    public Object send(E e, Continuation<? super Unit> continuation) {
        start();
        return super.send(e, continuation);
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel, kotlinx.coroutines.experimental.channels.ChannelCoroutine
    public boolean offer(E e) {
        start();
        return super.offer(e);
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel, kotlinx.coroutines.experimental.channels.ChannelCoroutine
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.experimental.channels.SendChannel<? super E>, ? super kotlin.coroutines.experimental.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.experimental.selects.SelectClause2
    public <R> void registerSelectClause2(SelectInstance<? super R> selectInstance, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        start();
        super.getOnSend().registerSelectClause2(selectInstance, e, function2);
    }
}
