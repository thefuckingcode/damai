package kotlin.streams.jdk8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\t\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0001H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0003H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007¨\u0006\r"}, d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/util/stream/DoubleStream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", "T", "Ljava/util/stream/Stream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 1, 16}, pn = "kotlin.streams")
/* compiled from: Streams.kt */
public final class StreamsKt {
    public static final <T> Sequence<T> asSequence(Stream<T> stream) {
        Intrinsics.checkParameterIsNotNull(stream, "$this$asSequence");
        return new StreamsKt$asSequence$$inlined$Sequence$1(stream);
    }

    public static final Sequence<Integer> asSequence(IntStream intStream) {
        Intrinsics.checkParameterIsNotNull(intStream, "$this$asSequence");
        return new StreamsKt$asSequence$$inlined$Sequence$2(intStream);
    }

    public static final Sequence<Long> asSequence(LongStream longStream) {
        Intrinsics.checkParameterIsNotNull(longStream, "$this$asSequence");
        return new StreamsKt$asSequence$$inlined$Sequence$3(longStream);
    }

    public static final Sequence<Double> asSequence(DoubleStream doubleStream) {
        Intrinsics.checkParameterIsNotNull(doubleStream, "$this$asSequence");
        return new StreamsKt$asSequence$$inlined$Sequence$4(doubleStream);
    }

    public static final <T> Stream<T> asStream(Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$this$asStream");
        Stream<T> stream = StreamSupport.stream(new StreamsKt$asStream$1(sequence), 16, false);
        Intrinsics.checkExpressionValueIsNotNull(stream, "StreamSupport.stream({ S…literator.ORDERED, false)");
        return stream;
    }

    public static final <T> List<T> toList(Stream<T> stream) {
        Intrinsics.checkParameterIsNotNull(stream, "$this$toList");
        Object collect = stream.collect(Collectors.toList());
        Intrinsics.checkExpressionValueIsNotNull(collect, "collect(Collectors.toList<T>())");
        return (List) collect;
    }

    public static final List<Integer> toList(IntStream intStream) {
        Intrinsics.checkParameterIsNotNull(intStream, "$this$toList");
        int[] array = intStream.toArray();
        Intrinsics.checkExpressionValueIsNotNull(array, "toArray()");
        return ArraysKt.asList(array);
    }

    public static final List<Long> toList(LongStream longStream) {
        Intrinsics.checkParameterIsNotNull(longStream, "$this$toList");
        long[] array = longStream.toArray();
        Intrinsics.checkExpressionValueIsNotNull(array, "toArray()");
        return ArraysKt.asList(array);
    }

    public static final List<Double> toList(DoubleStream doubleStream) {
        Intrinsics.checkParameterIsNotNull(doubleStream, "$this$toList");
        double[] array = doubleStream.toArray();
        Intrinsics.checkExpressionValueIsNotNull(array, "toArray()");
        return ArraysKt.asList(array);
    }
}
