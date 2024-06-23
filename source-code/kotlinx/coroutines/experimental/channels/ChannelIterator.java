package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H¦Bø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00028\u0000H¦Bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\t¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ChannelIterator;", "E", "", "hasNext", "", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Channel.kt */
public interface ChannelIterator<E> {
    Object hasNext(Continuation<? super Boolean> continuation);

    Object next(Continuation<? super E> continuation);
}
