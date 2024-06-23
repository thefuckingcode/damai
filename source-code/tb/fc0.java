package tb;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class fc0<T> implements Sequence<T>, DropTakeSequence<T> {
    @NotNull
    private final Sequence<T> a;
    private final int b;

    /* compiled from: Taobao */
    public static final class a implements Iterator<T>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        private int b;

        a(fc0<T> fc0) {
            this.a = ((fc0) fc0).a.iterator();
            this.b = ((fc0) fc0).b;
        }

        private final void a() {
            while (this.b > 0 && this.a.hasNext()) {
                this.a.next();
                this.b--;
            }
        }

        public boolean hasNext() {
            a();
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.a.next();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public fc0(@NotNull Sequence<? extends T> sequence, int i) {
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
        int i2 = this.b + i;
        return i2 < 0 ? new fc0(this, i) : new fc0(this.a, i2);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> take(int i) {
        int i2 = this.b;
        int i3 = i2 + i;
        return i3 < 0 ? new vi2(this, i) : new lg2(this.a, i2, i3);
    }
}
