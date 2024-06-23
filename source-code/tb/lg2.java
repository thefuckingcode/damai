package tb;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class lg2<T> implements Sequence<T>, DropTakeSequence<T> {
    @NotNull
    private final Sequence<T> a;
    private final int b;
    private final int c;

    /* compiled from: Taobao */
    public static final class a implements Iterator<T>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        private int b;
        final /* synthetic */ lg2<T> c;

        a(lg2<T> lg2) {
            this.c = lg2;
            this.a = ((lg2) lg2).a.iterator();
        }

        private final void a() {
            while (this.b < ((lg2) this.c).b && this.a.hasNext()) {
                this.a.next();
                this.b++;
            }
        }

        public boolean hasNext() {
            a();
            return this.b < ((lg2) this.c).c && this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.b < ((lg2) this.c).c) {
                this.b++;
                return this.a.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public lg2(@NotNull Sequence<? extends T> sequence, int i, int i2) {
        k21.i(sequence, "sequence");
        this.a = sequence;
        this.b = i;
        this.c = i2;
        boolean z = true;
        if (i >= 0) {
            if (i2 >= 0) {
                if (!(i2 < i ? false : z)) {
                    throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i2 + " < " + i).toString());
                }
                return;
            }
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i2).toString());
        }
        throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i).toString());
    }

    private final int d() {
        return this.c - this.b;
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> drop(int i) {
        return i >= d() ? SequencesKt__SequencesKt.e() : new lg2(this.a, this.b + i, this.c);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> take(int i) {
        if (i >= d()) {
            return this;
        }
        Sequence<T> sequence = this.a;
        int i2 = this.b;
        return new lg2(sequence, i2, i + i2);
    }
}
