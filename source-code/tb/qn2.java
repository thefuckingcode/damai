package tb;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class qn2<T, R> implements Sequence<R> {
    @NotNull
    private final Sequence<T> a;
    @NotNull
    private final Function1<T, R> b;

    /* compiled from: Taobao */
    public static final class a implements Iterator<R>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        final /* synthetic */ qn2<T, R> b;

        a(qn2<T, R> qn2) {
            this.b = qn2;
            this.a = ((qn2) qn2).a.iterator();
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((qn2) this.b).b.invoke(this.a.next());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public qn2(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        k21.i(sequence, "sequence");
        k21.i(function1, "transformer");
        this.a = sequence;
        this.b = function1;
    }

    @NotNull
    public final <E> Sequence<E> c(@NotNull Function1<? super R, ? extends Iterator<? extends E>> function1) {
        k21.i(function1, "iterator");
        return new cj0(this.a, this.b, function1);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<R> iterator() {
        return new a(this);
    }
}
