package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlinx.coroutines.experimental.selects.SelectClause1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0014\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H¦\u0002J\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u0004\u0018\u00018\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n\u0002\u0004\n\u0002\b\t¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "E", "", "isClosedForReceive", "", "()Z", "isEmpty", "onReceive", "Lkotlinx/coroutines/experimental/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/experimental/selects/SelectClause1;", "onReceiveOrNull", "getOnReceiveOrNull", "cancel", "cause", "", "iterator", "Lkotlinx/coroutines/experimental/channels/ChannelIterator;", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "receiveOrNull", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Channel.kt */
public interface ReceiveChannel<E> {
    boolean cancel(Throwable th);

    SelectClause1<E> getOnReceive();

    SelectClause1<E> getOnReceiveOrNull();

    boolean isClosedForReceive();

    boolean isEmpty();

    ChannelIterator<E> iterator();

    E poll();

    Object receive(Continuation<? super E> continuation);

    Object receiveOrNull(Continuation<? super E> continuation);

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: Channel.kt */
    public static final class DefaultImpls {
        public static /* bridge */ /* synthetic */ boolean cancel$default(ReceiveChannel receiveChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return receiveChannel.cancel(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }
}
