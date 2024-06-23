package kotlin.streams.jdk8;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/Spliterator;", "T", "kotlin.jvm.PlatformType", "get"}, k = 3, mv = {1, 1, 16})
/* compiled from: Streams.kt */
final class StreamsKt$asStream$1<T> implements Supplier<Spliterator<T>> {
    final /* synthetic */ Sequence $this_asStream;

    StreamsKt$asStream$1(Sequence sequence) {
        this.$this_asStream = sequence;
    }

    @Override // java.util.function.Supplier
    public final Spliterator<T> get() {
        return Spliterators.spliteratorUnknownSize(this.$this_asStream.iterator(), 16);
    }
}
