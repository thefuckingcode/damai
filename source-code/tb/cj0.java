package tb;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class cj0<T, R, E> implements Sequence<E> {
    @NotNull
    private final Sequence<T> a;
    @NotNull
    private final Function1<T, R> b;
    @NotNull
    private final Function1<R, Iterator<E>> c;

    /* compiled from: Taobao */
    public static final class a implements Iterator<E>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        @Nullable
        private Iterator<? extends E> b;
        final /* synthetic */ cj0<T, R, E> c;

        a(cj0<T, R, E> cj0) {
            this.c = cj0;
            this.a = ((cj0) cj0).a.iterator();
        }

        private final boolean a() {
            Iterator<? extends E> it = this.b;
            if (it != null && !it.hasNext()) {
                this.b = null;
            }
            while (true) {
                if (this.b == null) {
                    if (this.a.hasNext()) {
                        Iterator<? extends E> it2 = (Iterator) ((cj0) this.c).c.invoke(((cj0) this.c).b.invoke(this.a.next()));
                        if (it2.hasNext()) {
                            this.b = it2;
                            break;
                        }
                    } else {
                        return false;
                    }
                } else {
                    break;
                }
            }
            return true;
        }

        public boolean hasNext() {
            return a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (a()) {
                Iterator<? extends E> it = this.b;
                k21.f(it);
                return (E) it.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends R> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super R, ? extends java.util.Iterator<? extends E>> */
    /* JADX WARN: Multi-variable type inference failed */
    public cj0(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1, @NotNull Function1<? super R, ? extends Iterator<? extends E>> function12) {
        k21.i(sequence, "sequence");
        k21.i(function1, "transformer");
        k21.i(function12, "iterator");
        this.a = sequence;
        this.b = function1;
        this.c = function12;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<E> iterator() {
        return new a(this);
    }
}
