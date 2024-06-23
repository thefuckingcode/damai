package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineExceptionHandlerKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ActorCoroutine;", "E", "Lkotlinx/coroutines/experimental/channels/ChannelCoroutine;", "Lkotlinx/coroutines/experimental/channels/ActorScope;", "Lkotlinx/coroutines/experimental/channels/ActorJob;", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "channel", "Lkotlinx/coroutines/experimental/channels/Channel;", "active", "", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/channels/Channel;Z)V", "onCancellation", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Actor.kt */
class ActorCoroutine<E> extends ChannelCoroutine<E> implements ActorScope<E>, ActorJob<E> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActorCoroutine(CoroutineContext coroutineContext, Channel<E> channel, boolean z) {
        super(coroutineContext, channel, z);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.AbstractCoroutine
    public void onCancellation(Throwable th) {
        get_channel().cancel(th);
        if (th != null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        }
    }
}
