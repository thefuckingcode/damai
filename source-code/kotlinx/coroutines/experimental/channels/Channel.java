package kotlinx.coroutines.experimental.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/experimental/channels/Channel;", "E", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "Factory", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Channel.kt */
public interface Channel<E> extends SendChannel<E>, ReceiveChannel<E> {
    public static final int CONFLATED = -1;
    public static final Factory Factory = Factory.$$INSTANCE;
    public static final int UNLIMITED = Integer.MAX_VALUE;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\b2\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/experimental/channels/Channel$Factory;", "", "()V", "CONFLATED", "", "UNLIMITED", "invoke", "Lkotlinx/coroutines/experimental/channels/Channel;", "E", "capacity", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Channel.kt */
    public static final class Factory {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();
        public static final int CONFLATED = -1;
        public static final int UNLIMITED = Integer.MAX_VALUE;

        private Factory() {
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with top-level function")
        public static /* bridge */ /* synthetic */ Channel invoke$default(Factory factory, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            return factory.invoke(i);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with top-level function")
        public final /* synthetic */ <E> Channel<E> invoke(int i) {
            return ChannelKt.Channel(i);
        }
    }
}
