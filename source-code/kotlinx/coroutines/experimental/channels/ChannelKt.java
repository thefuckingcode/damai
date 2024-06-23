package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Channel", "Lkotlinx/coroutines/experimental/channels/Channel;", "E", "capacity", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Channel.kt */
public final class ChannelKt {
    public static final <E> Channel<E> Channel() {
        return new RendezvousChannel();
    }

    public static final <E> Channel<E> Channel(int i) {
        if (i == -1) {
            return new ConflatedChannel();
        }
        if (i == 0) {
            return new RendezvousChannel();
        }
        if (i != Integer.MAX_VALUE) {
            return new ArrayChannel(i);
        }
        return new LinkedListChannel();
    }
}
