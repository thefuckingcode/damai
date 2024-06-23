package tb;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class wi2<T> implements Sequence<T> {
    @NotNull
    private final Sequence<T> a;
    @NotNull
    private final Function1<T, Boolean> b;

    /* compiled from: Taobao */
    public static final class a implements Iterator<T>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        private int b = -1;
        @Nullable
        private T c;
        final /* synthetic */ wi2<T> d;

        a(wi2<T> wi2) {
            this.d = wi2;
            this.a = ((wi2) wi2).a.iterator();
        }

        private final void a() {
            if (this.a.hasNext()) {
                T next = this.a.next();
                if (((Boolean) ((wi2) this.d).b.invoke(next)).booleanValue()) {
                    this.b = 1;
                    this.c = next;
                    return;
                }
            }
            this.b = 0;
        }

        public boolean hasNext() {
            if (this.b == -1) {
                a();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b == -1) {
                a();
            }
            if (this.b != 0) {
                T t = this.c;
                this.c = null;
                this.b = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public wi2(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        k21.i(sequence, "sequence");
        k21.i(function1, "predicate");
        this.a = sequence;
        this.b = function1;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
