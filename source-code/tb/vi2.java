package tb;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class vi2<T> implements Sequence<T>, DropTakeSequence<T> {
    @NotNull
    private final Sequence<T> a;
    private final int b;

    /* compiled from: Taobao */
    public static final class a implements Iterator<T>, KMappedMarker {
        private int a;
        @NotNull
        private final Iterator<T> b;

        a(vi2<T> vi2) {
            this.a = ((vi2) vi2).b;
            this.b = ((vi2) vi2).a.iterator();
        }

        public boolean hasNext() {
            return this.a > 0 && this.b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.a;
            if (i != 0) {
                this.a = i - 1;
                return this.b.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public vi2(@NotNull Sequence<? extends T> sequence, int i) {
        k21.i(sequence, "sequence");
        this.a = sequence;
        this.b = i;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
        }
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> drop(int i) {
        int i2 = this.b;
        return i >= i2 ? SequencesKt__SequencesKt.e() : new lg2(this.a, i, i2);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> take(int i) {
        return i >= this.b ? this : new vi2(this.a, i);
    }
}
