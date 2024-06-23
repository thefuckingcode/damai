package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class b {
    @NotNull
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    @PublishedApi
    public static final void b(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th);
    }

    @PublishedApi
    @Nullable
    public static final <E, C extends SendChannel<? super E>> Object s(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.r(receiveChannel, c, continuation);
    }

    @PublishedApi
    @Nullable
    public static final <E, C extends Collection<? super E>> Object t(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.s(receiveChannel, c, continuation);
    }

    @Nullable
    public static final <E> Object u(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.d(receiveChannel, continuation);
    }

    @PublishedApi
    @Nullable
    public static final <K, V, M extends Map<? super K, ? super V>> Object v(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @NotNull M m, @NotNull Continuation<? super M> continuation) {
        return ChannelsKt__DeprecatedKt.t(receiveChannel, m, continuation);
    }
}
