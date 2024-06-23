package kotlinx.coroutines.experimental.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\fJ\u0014\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0017J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH&J\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0017¢\u0006\u0002\b\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/experimental/channels/BroadcastChannel;", "E", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "cancel", "", "cause", "", "open", "Lkotlinx/coroutines/experimental/channels/SubscriptionReceiveChannel;", "openSubscription", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "openSubscription1", "Factory", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: BroadcastChannel.kt */
public interface BroadcastChannel<E> extends SendChannel<E> {
    public static final Factory Factory = Factory.$$INSTANCE;

    boolean cancel(Throwable th);

    @Deprecated(message = "Renamed to `openSubscription`", replaceWith = @ReplaceWith(expression = "openSubscription()", imports = {}))
    SubscriptionReceiveChannel<E> open();

    ReceiveChannel<E> openSubscription();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Return type changed to `ReceiveChannel`, this one left here for binary compatibility")
    /* synthetic */ SubscriptionReceiveChannel<E> openSubscription();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/channels/BroadcastChannel$Factory;", "", "()V", "invoke", "Lkotlinx/coroutines/experimental/channels/BroadcastChannel;", "E", "capacity", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: BroadcastChannel.kt */
    public static final class Factory {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with top-level function")
        public final /* synthetic */ <E> BroadcastChannel<E> invoke(int i) {
            return BroadcastChannelKt.BroadcastChannel(i);
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: BroadcastChannel.kt */
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Return type changed to `ReceiveChannel`, this one left here for binary compatibility")
        public static /* synthetic */ <E> SubscriptionReceiveChannel<E> openSubscription(BroadcastChannel<E> broadcastChannel) {
            ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
            if (openSubscription != null) {
                return (SubscriptionReceiveChannel) openSubscription;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.SubscriptionReceiveChannel<E>");
        }

        @Deprecated(message = "Renamed to `openSubscription`", replaceWith = @ReplaceWith(expression = "openSubscription()", imports = {}))
        public static <E> SubscriptionReceiveChannel<E> open(BroadcastChannel<E> broadcastChannel) {
            ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
            if (openSubscription != null) {
                return (SubscriptionReceiveChannel) openSubscription;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.SubscriptionReceiveChannel<E>");
        }

        public static /* bridge */ /* synthetic */ boolean cancel$default(BroadcastChannel broadcastChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return broadcastChannel.cancel(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }
}
