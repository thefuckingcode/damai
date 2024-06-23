package kotlinx.coroutines.experimental.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 2}, d1 = {"kotlinx/coroutines/experimental/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/experimental/channels/ChannelsKt__Channels_commonKt"}, k = 4, mv = {1, 1, 10})
public final class ChannelsKt {
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    public static final <E> Object any(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.any(receiveChannel, continuation);
    }

    public static final <E> ReceiveChannel<E> asReceiveChannel(Iterable<? extends E> iterable, CoroutineContext coroutineContext) {
        return ChannelsKt__Channels_commonKt.asReceiveChannel(iterable, coroutineContext);
    }

    public static final <E> ReceiveChannel<E> asReceiveChannel(Sequence<? extends E> sequence, CoroutineContext coroutineContext) {
        return ChannelsKt__Channels_commonKt.asReceiveChannel(sequence, coroutineContext);
    }

    public static final <E, R> R consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return (R) ChannelsKt__Channels_commonKt.consume(broadcastChannel, function1);
    }

    public static final <E, R> R consume(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return (R) ChannelsKt__Channels_commonKt.consume(receiveChannel, function1);
    }

    public static final Function1<Throwable, Unit> consumes(ReceiveChannel<?> receiveChannel) {
        return ChannelsKt__Channels_commonKt.consumes(receiveChannel);
    }

    public static final Function1<Throwable, Unit> consumesAll(ReceiveChannel<?>... receiveChannelArr) {
        return ChannelsKt__Channels_commonKt.consumesAll(receiveChannelArr);
    }

    public static final <E> Object count(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.count(receiveChannel, continuation);
    }

    public static final <E> ReceiveChannel<E> distinct(ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__Channels_commonKt.distinct(receiveChannel);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> drop(ReceiveChannel<? extends E> receiveChannel, int i, CoroutineContext coroutineContext) {
        return ChannelsKt__Channels_commonKt.drop(receiveChannel, i, coroutineContext);
    }

    public static final <E> ReceiveChannel<E> dropWhile(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.dropWhile(receiveChannel, coroutineContext, function2);
    }

    public static final <E> Object elementAt(ReceiveChannel<? extends E> receiveChannel, int i, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.elementAt(receiveChannel, i, continuation);
    }

    public static final <E> Object elementAtOrNull(ReceiveChannel<? extends E> receiveChannel, int i, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.elementAtOrNull(receiveChannel, i, continuation);
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.filter(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> filterIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return ChannelsKt__Channels_commonKt.filterIndexed(receiveChannel, coroutineContext, function3);
    }

    public static final <E> ReceiveChannel<E> filterNot(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.filterNot(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__Channels_commonKt.filterNotNull(receiveChannel);
    }

    public static final <E, C extends Collection<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterNotNullTo(receiveChannel, c, continuation);
    }

    public static final <E, C extends SendChannel<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterNotNullTo(receiveChannel, c, continuation);
    }

    public static final <E> Object first(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.first(receiveChannel, continuation);
    }

    public static final <E> Object firstOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.firstOrNull(receiveChannel, continuation);
    }

    public static final <E, R> ReceiveChannel<R> flatMap(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.flatMap(receiveChannel, coroutineContext, function2);
    }

    public static final <E> Object indexOf(ReceiveChannel<? extends E> receiveChannel, E e, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.indexOf(receiveChannel, e, continuation);
    }

    public static final <E> Object last(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.last(receiveChannel, continuation);
    }

    public static final <E> Object lastIndexOf(ReceiveChannel<? extends E> receiveChannel, E e, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.lastIndexOf(receiveChannel, e, continuation);
    }

    public static final <E> Object lastOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.lastOrNull(receiveChannel, continuation);
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.map(receiveChannel, coroutineContext, function2);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ChannelsKt__Channels_commonKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexedNotNull(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    public static final <E, R> ReceiveChannel<R> mapNotNull(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.mapNotNull(receiveChannel, coroutineContext, function2);
    }

    public static final <E> Object maxWith(ReceiveChannel<? extends E> receiveChannel, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.maxWith(receiveChannel, comparator, continuation);
    }

    public static final <E> Object minWith(ReceiveChannel<? extends E> receiveChannel, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.minWith(receiveChannel, comparator, continuation);
    }

    public static final <E> Object none(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.none(receiveChannel, continuation);
    }

    public static final <E> ReceiveChannel<E> requireNoNulls(ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__Channels_commonKt.requireNoNulls(receiveChannel);
    }

    public static final <E> void sendBlocking(SendChannel<? super E> sendChannel, E e) {
        ChannelsKt__ChannelsKt.sendBlocking(sendChannel, e);
    }

    public static final <E> Object single(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.single(receiveChannel, continuation);
    }

    public static final <E> Object singleOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.singleOrNull(receiveChannel, continuation);
    }

    public static final <E> ReceiveChannel<E> take(ReceiveChannel<? extends E> receiveChannel, int i, CoroutineContext coroutineContext) {
        return ChannelsKt__Channels_commonKt.take(receiveChannel, i, coroutineContext);
    }

    public static final <E> ReceiveChannel<E> takeWhile(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.takeWhile(receiveChannel, coroutineContext, function2);
    }

    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.toChannel(receiveChannel, c, continuation);
    }

    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.toCollection(receiveChannel, c, continuation);
    }

    public static final <E> Object toList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.toList(receiveChannel, continuation);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.toMap(receiveChannel, m, continuation);
    }

    public static final <K, V> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt__Channels_commonKt.toMap(receiveChannel, continuation);
    }

    public static final <E> Object toMutableList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<E>> continuation) {
        return ChannelsKt__Channels_commonKt.toMutableList(receiveChannel, continuation);
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt__Channels_commonKt.toMutableSet(receiveChannel, continuation);
    }

    public static final <E> Object toSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.toSet(receiveChannel, continuation);
    }

    public static final <E> ReceiveChannel<IndexedValue<E>> withIndex(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext) {
        return ChannelsKt__Channels_commonKt.withIndex(receiveChannel, coroutineContext);
    }

    public static final <E, R> ReceiveChannel<Pair<E, R>> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2) {
        return ChannelsKt__Channels_commonKt.zip(receiveChannel, receiveChannel2);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext coroutineContext, Function2<? super E, ? super R, ? extends V> function2) {
        return ChannelsKt__Channels_commonKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }
}
