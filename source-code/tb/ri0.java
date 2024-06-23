package tb;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ri0<T> implements Sequence<T> {
    @NotNull
    private final Sequence<T> a;
    private final boolean b;
    @NotNull
    private final Function1<T, Boolean> c;

    /* compiled from: Taobao */
    public static final class a implements Iterator<T>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        private int b = -1;
        @Nullable
        private T c;
        final /* synthetic */ ri0<T> d;

        a(ri0<T> ri0) {
            this.d = ri0;
            this.a = ((ri0) ri0).a.iterator();
        }

        private final void a() {
            while (this.a.hasNext()) {
                T next = this.a.next();
                if (((Boolean) ((ri0) this.d).c.invoke(next)).booleanValue() == ((ri0) this.d).b) {
                    this.c = next;
                    this.b = 1;
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
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public ri0(@NotNull Sequence<? extends T> sequence, boolean z, @NotNull Function1<? super T, Boolean> function1) {
        k21.i(sequence, "sequence");
        k21.i(function1, "predicate");
        this.a = sequence;
        this.b = z;
        this.c = function1;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
