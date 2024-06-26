package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlinx.coroutines.experimental.CoroutineScope;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ActorScope;", "E", "Lkotlinx/coroutines/experimental/CoroutineScope;", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "channel", "Lkotlinx/coroutines/experimental/channels/Channel;", "getChannel", "()Lkotlinx/coroutines/experimental/channels/Channel;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Actor.kt */
public interface ActorScope<E> extends CoroutineScope, ReceiveChannel<E> {
    Channel<E> getChannel();
}
