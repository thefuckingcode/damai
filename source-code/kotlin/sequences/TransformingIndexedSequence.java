package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

public final class TransformingIndexedSequence<T, R> implements Sequence<R> {
    private final Sequence<T> sequence;
    private final Function2<Integer, T, R> transformer;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public TransformingIndexedSequence(Sequence<? extends T> sequence2, Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sequence2, "sequence");
        Intrinsics.checkParameterIsNotNull(function2, "transformer");
        this.sequence = sequence2;
        this.transformer = function2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new TransformingIndexedSequence$iterator$1(this);
    }
}
